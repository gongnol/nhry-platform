package com.nhry.common.auth;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.jedis.entity.ObjectRedisTemplate;
import com.nhry.data.auth.domain.TSysAccesskey;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.model.sys.AccessKey;
import com.nhry.service.auth.dao.TSysAccesskeyService;
import com.nhry.service.auth.dao.UserService;
import com.nhry.utils.Base64Util;
import com.nhry.utils.EnvContant;
import com.nhry.utils.HttpUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;
import com.nhry.utils.redis.RedisUtil;
import com.sun.jersey.spi.container.ContainerRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserSessionService {
	private static final Logger LOGGER = Logger.getLogger(UserSessionService.class);
	public static final String accessKey="accessKey";
	public static final String uname="uname";
	private static final ThreadLocal<TSysUser> accessKeyThread = new ThreadLocal<TSysUser>();
	private RedisTemplate objectRedisTemplate;
	private static Map<String,String> authsMap = null;
	private TSysAccesskeyService isysAkService;
	private UserService userService;
	
	static{
		authsMap = new HashMap<String,String>();
		authsMap.put("ec", "Ab1234@Ec");
		authsMap.put("cisco", "cisco@abc");
		authsMap.put("app", "Ad1234@App");
	}
	
	public String checkIdentity(String accessKey,HttpServletRequest servletRequest,String authflag){
		if(AuthFilter.IDM_AUTH.equals(authflag) || AuthFilter.IDM_REST_AUTH.equals(authflag)){
			//idm auth2.0   接口rest认证
		   return checkIdmAuth(accessKey, servletRequest,authflag);
		}else if(AuthFilter.DH_AUTH.equals(authflag)){
			TSysUser user = (TSysUser)objectRedisTemplate.opsForHash().get(SysContant.getSystemConst("app_user_key"),accessKey);
			accessKeyThread.set(user);
			return MessageCode.NORMAL;
		}else if(AuthFilter.HTTP_AUTH.equals(authflag)){
			TSysUser sysuser = (TSysUser)servletRequest.getSession().getAttribute("dh-auth");
			if(sysuser != null){
				accessKeyThread.set(sysuser);
			}else{
				//http basic认证
				return checkHeaderAuth(servletRequest);
			}
		}
		return MessageCode.NORMAL;
	}
	
	/**
	 * idm auth2.0 用户认证
	 * @param accessKey
	 * @param servletRequest
	 * @return
	 */
	private String checkIdmAuth(String accessKey,HttpServletRequest servletRequest,String authflag){
		try {
			String idm_auth =servletRequest.getHeader("dh-token");
			String appcode =servletRequest.getHeader("appcode");
			String appkey = servletRequest.getHeader("appkey");
			String timestamp = servletRequest.getHeader("timestamp");
			String ticketName = servletRequest.getHeader("ticketName");
			if("-1".equals(accessKey) || StringUtils.isEmpty(timestamp)){
				return MessageCode.SESSION_EXPIRE;
			}
			if(AuthFilter.IDM_REST_AUTH.equals(authflag) && StringUtils.isEmpty(ticketName)){
				//idm rest接口认证方式，ticketName必须传入
				return MessageCode.UNAUTHORIZED;
			}
			boolean flag = false;
			if(HttpUtils.isValidDate(timestamp)){
				Date fdate = com.nhry.utils.date.Date.parseDate(timestamp,"yyyyMMddHHmmss").addMinutes(3);
//				Date fdate = com.nhry.utils.date.Date.parseDate(timestamp,"yyyyMMddHHmmss").addMinutes(60*8);
				Date sysdate = new Date();
				if(sysdate.before(fdate)){
					//系统时间 小于 前端时间+3分钟
					String encrypt= HttpUtils.encodePassword(appcode+appkey+timestamp, SysContant.getSystemConst(appcode+"_base_pw")+HttpUtils.getSixpw(timestamp));
					if(encrypt.equals(idm_auth)){
						flag = true;
						TSysAccesskey key = new TSysAccesskey();
						key.setAccesskey(appkey);
						key.setType(AuthFilter.IDM_AUTH.equals(authflag) ? AuthFilter.IDM_AUTH2_SIGN : AuthFilter.IDM_REST_SIGN);
						TSysAccesskey ak = isysAkService.findAccesskeyByKey(key);
						if(ak == null){
							if(AuthFilter.IDM_AUTH.equals(authflag)){
								return MessageCode.SESSION_EXPIRE;
							}else{
								//其他认证方式  idm rest 接口认证方式(第一次访问)
								return authenticate4RestAuth(appkey, servletRequest.getRemoteHost(),ticketName);
							}
						}
						Date lastDate = new Date(ak.getVisitLastTime());
						if(lastDate.addHours(2).before(new Date())){
							System.out.println("-----超过两小时------");
							//如果上次(第一次)访问时间与系统时间相差2两小时的话，往idm验证一次
							if(AuthFilter.IDM_AUTH.equals(authflag)){
								return authenticate4Auth(appkey,ak.getLoginname(),servletRequest.getRemoteHost());
							}else if(AuthFilter.IDM_REST_AUTH.equals(authflag)){
								return authenticate4RestAuth(appkey, servletRequest.getRemoteHost(),ticketName);
							}
						}else{
							//如果没有超过2小时直接允许继续访问
							TSysUser user = new TSysUser();
							user.setLoginName(ak.getLoginname());
							TSysUser sysUser = userService.login(user);
							if(sysUser == null){
								return MessageCode.SESSION_EXPIRE;
							}else{
								accessKeyThread.set(sysUser);
								return MessageCode.NORMAL;
							}
						}
					}
				}
			}
			if(!flag){
				if(AuthFilter.IDM_AUTH.equals(authflag)){
					return MessageCode.SESSION_EXPIRE;
				}else if(AuthFilter.IDM_REST_AUTH.equals(authflag)){
					return MessageCode.UNAUTHORIZED;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageCode.SESSION_EXPIRE;
	}
	
	/**
	 * idm auth2 校验请求
	 * @param appkey
	 * @return
	 */
	private String authenticate4Auth(String appkey,String lname,String ip){
		try {
			Map attrs = new HashMap(2);
			attrs.put("access_token", appkey);
			String userObject = HttpUtils.request(EnvContant.getSystemConst("auth_profile"), attrs);
			JSONObject userJson = new JSONObject(userObject);
			if(userJson.has("id") && !StringUtils.isEmpty(userJson.getString("id"))){                                        
				TSysUser user = new TSysUser();
				user.setLoginName(lname);
				TSysUser sysUser = userService.login(user);
				if(sysUser == null){
					return MessageCode.SESSION_EXPIRE;
				}else{
					TSysAccesskey record = new TSysAccesskey();
					record.setAccesskey(appkey);
					record.setType(AuthFilter.IDM_AUTH2_SIGN);
					record.setVisitLastTime(new Date());
					record.setVisitIp(ip);
					isysAkService.updateIsysAccessKey(record);
					accessKeyThread.set(sysUser);
					return MessageCode.NORMAL;
				}
			}else{
				return MessageCode.SESSION_EXPIRE;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageCode.SESSION_EXPIRE;
	}
	
	/**
	 * idm token 接口验证方式
	 * @param appkey
	 * @param ip
	 * @return
	 */
	private String authenticate4RestAuth(String token,String ip,String ticketName){
		try {
			JSONObject ticketEntry = new JSONObject();
			ticketEntry.put("ticketName", ticketName);
			ticketEntry.put("ticketValue", token);
	    	String userObject = HttpUtils.idmAppPost(EnvContant.getSystemConst("app_token_validate"),ticketEntry.toString());
			JSONObject userJson = new JSONObject(userObject);
			if(userJson.has("status") && "true".equals(userJson.getString("status")) && userJson.has("user") && userJson.getJSONObject("user").has("uid")){
				TSysUser user = new TSysUser();
				user.setLoginName(userJson.getJSONObject("user").getString("uid"));
				TSysUser sysUser = userService.login(user);
				if(sysUser == null){
					return MessageCode.UNAUTHORIZED;
				}else{
					TSysAccesskey record = new TSysAccesskey();
					record.setAccesskey(token);
					record.setLoginname(sysUser.getLoginName());
					record.setType(AuthFilter.IDM_REST_SIGN); //20 : 送奶app
					record.setVisitLastTime(new Date());
					record.setVisitFirstTime(new Date());
					record.setVisitIp(ip);
					isysAkService.updateIsysAccessKey(record);
					accessKeyThread.set(sysUser);
					return MessageCode.NORMAL;
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageCode.UNAUTHORIZED;
	}
	
	/**
	 * 检查http basic
	 * @param servletRequest
	 * @return
	 */
	private String checkHeaderAuth(HttpServletRequest servletRequest)  {
		String idm_auth =servletRequest.getHeader("dh-token");
		String appcode =servletRequest.getHeader("appcode");
		String appkey = servletRequest.getHeader("appkey");
		String timestamp = servletRequest.getHeader("timestamp");
		boolean flag = false;
		if(HttpUtils.isValidDate(timestamp)){
			Date fdate = com.nhry.utils.date.Date.parseDate(timestamp,"yyyyMMddHHmmss").addMinutes(6);
			Date sysdate = new Date();
			if(sysdate.before(fdate)){
				//系统时间 小于 前端时间+6分钟
				String encrypt= HttpUtils.encodePassword(appcode+appkey+timestamp, SysContant.getSystemConst(appcode+"_base_pw")+HttpUtils.getSixpw(timestamp));
				if(encrypt.equals(idm_auth)){
					flag = true;
				}
			}
		}
		if(!flag){
			return MessageCode.UNAUTHORIZED;
		}
		//构建虚拟用户
		TSysUser sysuser = new TSysUser();
		sysuser.setLoginName(appcode);
		sysuser.setDisplayName(appcode);
		accessKeyThread.set(sysuser);
		return MessageCode.NORMAL;
	}
	
	/**
	 * 缓存用户信息
	 * @param uName
	 * @param accessKey
	 * @param user
	 * @param request
	 */
	public void cacheUserSession(String uName,String accessKey,TSysUser user,HttpServletRequest request){
		//解密之后再放入缓存
		//缓存用户对象,如果对于的key用户已经存在，则更新，否则新加
		objectRedisTemplate.opsForHash().put(SysContant.getSystemConst("app_user_key"), user.getLoginName(), user);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		objectRedisTemplate.opsForHash().put("SALORDER",user.getBranchNo()+ format.format(new Date()),"OFF");
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public TSysUser getCurrentUser(){
		if(!"product".equals(SysContant.getSystemConst("app_mode"))){
			//测试时使用
			TSysUser user = new TSysUser();
			Date date =  new Date();
			user.setLoginName("ex_wangju");
			user.setDisplayName("测试用户");
			user.setBranchNo("0300006134");
			user.setSalesOrg("4151");
			user.setLastModified(date);
			return user;
		}
		return accessKeyThread.get();
	}
	
	/**
	 * 生成一个key
	 * @return
	 */
	public String generateKey(){
		return Base64Util.encodeStr(java.util.UUID.randomUUID().toString().replace("-", ""));
	}

	public void setObjectRedisTemplate(RedisTemplate objectRedisTemplate) {
		this.objectRedisTemplate = objectRedisTemplate;
	}

	public void setIsysAkService(TSysAccesskeyService isysAkService) {
		this.isysAkService = isysAkService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
