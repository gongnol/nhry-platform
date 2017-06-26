package com.nhry.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import sun.misc.BASE64Decoder;

import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.service.auth.dao.UserService;
import com.nhry.utils.CookieUtil;
import com.nhry.utils.SysContant;

public class ApiServlet extends HttpServlet {
	@Autowired
	private UserSessionService userSessionService;
	@Autowired
	private UserService userService;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		TSysUser sysuser = (TSysUser)request.getSession().getAttribute("dh-auth");
		if (sysuser != null) {
			if(StringUtils.isEmpty(request.getContextPath())){
				response.sendRedirect("/master/swagger/index.html");
			}else{
				response.sendRedirect(request.getContextPath()+"/swagger/index.html");
			}
		} else {
			if (!checkHeaderAuth(request, response)) {
				redirect2NoAuth(response);
			}
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
	}
	
	/**
	 * 检查用户权限
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private boolean checkHeaderAuth(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String auth = request.getHeader("Authorization");
		if ((auth != null) && (auth.length() > 6)) {
			auth = auth.substring(6, auth.length());
			String decodedAuth = getFromBASE64(auth);
			if(StringUtils.isEmpty(decodedAuth) || decodedAuth.split(":").length < 2){
				return false;
			}
			String[] auths = decodedAuth.split(":");
			if(auths != null && auths.length == 2){
				if(!SysContant.getSystemConst("commonPw").equals(auths[1])){
					return false;
				}
				//检查用户是否存在
				checkUserIsExists(request, response, auths[0]);
				return true;
			}
		} 
		return false;
	}
	
	/**
	 * 检查用户是否存在
	 * @param request
	 * @param response
	 * @param uname
	 */
	private void checkUserIsExists(HttpServletRequest request,HttpServletResponse response,String uname){
		try {
			TSysUser _user = new TSysUser();
			_user.setLoginName(uname);
			TSysUser loginuser = userService.login(_user);
			if(loginuser == null){
				redirect2NoAuth(response);
			}else{
				request.getSession().setAttribute("dh-auth", loginuser);
				if(StringUtils.isEmpty(request.getContextPath())){
					response.sendRedirect("/master/swagger/index.html");
				}else{
					response.sendRedirect(request.getContextPath()+"/swagger/index.html");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirect2NoAuth(response);
		}
	}
	
	private void redirect2NoAuth(HttpServletResponse response){
		response.setStatus(401);
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("WWW-authenticate", "Basic Realm=\"USER LOGIN\"");
	}
	
	private String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
}