package com.nhry.servlet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.nhry.common.auth.AuthFilter;
import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysAccesskey;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.service.auth.dao.TSysAccesskeyService;
import com.nhry.service.auth.dao.UserService;
import com.nhry.utils.AES;
import com.nhry.utils.APIHttpClient;
import com.nhry.utils.Base64Util;
import com.nhry.utils.CookieUtil;
import com.nhry.utils.EnvContant;
import com.nhry.utils.HttpUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;
import com.nhry.utils.json.JackJson;
@Component
public class IdmAuthServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(IdmAuthServlet.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserSessionService userSessionService;
	@Autowired
	private TSysAccesskeyService isysAkService;
	@Autowired
	private TSysUserRoleMapper urMapper;
	
	public void init(ServletConfig config) throws ServletException {
		 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取临时令牌
		try {
			String code = request.getParameter("code");
			String ip = request.getParameter("id");
			if (!StringUtils.isEmpty(code)) {
				Map<String,Object> attrs = new HashMap<String,Object>();
				attrs.put("client_id", EnvContant.getSystemConst("client_id"));
				attrs.put("client_secret", EnvContant.getSystemConst("client_secret"));
				attrs.put("grant_type", EnvContant.getSystemConst("grant_type"));
				attrs.put("redirect_uri", EnvContant.getSystemConst("redirect_uri"));
				attrs.put("code", code);
				String access_token = HttpUtils.request(EnvContant.getSystemConst("auth_token"), attrs,"utf-8");
				LOGGER.info("access_token" + access_token);
				if(!StringUtils.isEmpty(access_token)){
					attrs.clear();
					String token = access_token.split("=")[1].split("&")[0];
					attrs.put("access_token", token);
					String userObject = HttpUtils.request(EnvContant.getSystemConst("auth_profile"), attrs,"utf-8");
					JSONObject userJson = new JSONObject(userObject);
					if(userJson.has("id") && !StringUtils.isEmpty(userJson.getString("id"))){
						TSysUser user = new TSysUser();
						user.setLoginName(userJson.getString("id"));
						LOGGER.info("user"+userJson.getString("id")+";token"+ token);
						TSysUser loginuser = userService.login(user);
						if(loginuser == null){
							sendRedirectToLogout(response);
							return;
						}
						TSysAccesskey ak = new TSysAccesskey();
						ak.setAccesskey(token);
						ak.setLoginname(user.getLoginName());
						ak.setType("10"); //10 : idm auth2.0
						ak.setVisitFirstTime(new Date());
						ak.setVisitLastTime(new Date());
						isysAkService.updateIsysAccessKey(ak);
						
						//判断当前用户销售组织是否存在
						if(StringUtils.isEmpty(loginuser.getSalesOrg())){
							List<String> roles = urMapper.getUserRidsByLoginName(loginuser.getLoginName());
							if(roles == null || roles.size() == 0){
								sendRedirectToInfoPage(response,token);
								return;
							}else{
								if(!roles.contains(SysContant.getSystemConst("sys_manager_no"))){
									sendRedirectToInfoPage(response,token);
									return;
								}
							}
						}
						
						sendRedirectToHomePage(request, response, token,ip);
					}else{
						sendRedirectToLogout(response);
					}
				}
			} else {
				sendRedirectToLogin(response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.warn("IdmAuthServlet error message  client_id： "+EnvContant.getSystemConst("client_id")+" client_secret : "+EnvContant.getSystemConst("client_secret")+" grant_type : "+
					EnvContant.getSystemConst("grant_type")+" redirect_uri : "+EnvContant.getSystemConst("redirect_uri")+" code : "+request.getParameter("code"));
			sendRedirectToLogin(response);
		}
	}
	
	/**
	 * 跳转到登录
	 * @param response
	 */
	public void sendRedirectToLogin(HttpServletResponse response){
		//跳转到登录页面
		try {
			response.sendRedirect(EnvContant.getSystemConst("authurl")
					+ "?client_id=" + EnvContant.getSystemConst("client_id")
					+ "&redirect_uri="
					+ EnvContant.getSystemConst("redirect_uri")
					+ "&response_type="
					+ EnvContant.getSystemConst("response_type"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到登出
	 * @param response
	 */
	public void sendRedirectToLogout(HttpServletResponse response){
		//跳转到登出页面
		try {
			response.sendRedirect(EnvContant.getSystemConst("idm_logout_uri")+EnvContant.getSystemConst("redirect_uri"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRedirectToHomePage(HttpServletRequest request, HttpServletResponse response,String token,String ip){
		//跳转到登录页面
		try {
			if(StringUtils.isEmpty(ip)){
				response.setHeader("appkey", token);
				CookieUtil.setCookie(request, response, "appkey", token,180);
				response.sendRedirect(EnvContant.getSystemConst("front_home_page")+"?appkey="+token);
//				response.sendRedirect(EnvContant.getSystemConst("front_home_page"));
			}else{
				response.setHeader("appkey", token);
				CookieUtil.setCookie(request, response, "appkey", token,180);
				response.sendRedirect("http://"+Base64Util.decodeStr(ip)+EnvContant.getSystemConst("front_short_url")+"?appkey="+token);
//				response.sendRedirect("http://"+Base64Util.decodeStr(ip)+EnvContant.getSystemConst("front_short_url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转到消息提示页面
	 * @param response
	 */
	public void sendRedirectToInfoPage(HttpServletResponse response,String token){
		//跳转到登出页面
		try {
			response.setHeader("appkey", token);
			response.sendRedirect(EnvContant.getSystemConst("info_page_uri")+"?appkey="+token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String request(String uri, Map<String, Object> params,
								 String encoding) throws IOException {
		System.setProperty("javax.net.ssl.trustStore", "/opt/java/jdk1.8.0_72/jre/lib/security/cacerts");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		long currentTime = System.currentTimeMillis();
		URL postUrl = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);

		connection.setRequestMethod("POST");

		connection.setUseCaches(false);

		connection.setInstanceFollowRedirects(true);

		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		StringBuffer content = new StringBuffer();
		Object[] arrays = params.entrySet().toArray();
		for (int index = 0; index < arrays.length; index++) {
			Map.Entry<String, Object> value = (Map.Entry<String, Object>) arrays[index];
			Object target = value.getValue();
			if (target instanceof Collection) {
				Object array[] = ((Collection) target).toArray();
				for (int i = 0; i < array.length; i++) {
					content.append(value.getKey() + "="
							+ URLEncoder.encode(array[i].toString(), encoding));
					if (i <= array.length - 1) {
						content.append("&");
					}
				}
				continue;
			} else {
				content.append(value.getKey()
						+ "="
						+ URLEncoder.encode(
						target == null ? "" : target.toString(),
						encoding));
			}

			if (index <= arrays.length - 1) {
				content.append("&");
			}
		}

		out.writeBytes(content.toString());
		out.flush();
		out.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String line;
		StringBuffer result = new StringBuffer();

		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		connection.disconnect();
		return result.toString();
	}


}
