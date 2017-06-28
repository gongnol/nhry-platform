package com.nhry.common.auth;

import com.nhry.common.exception.MessageCode;
import com.nhry.model.sys.ResponseModel;
import com.nhry.service.auth.dao.TSysAccesskeyService;
import com.nhry.utils.CookieUtil;
import com.nhry.utils.SysContant;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthFilter implements ContainerRequestFilter {
	private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);
	protected static  List<String> whiteUriList =null;
	protected static  List<String> whiteHostList =null;
	protected static final String IDM_AUTH="idm_auth";
	protected static final String IDM_REST_AUTH="idm_rest_auth";
	protected static final String DH_AUTH="dh_auth";
	protected static final String HTTP_AUTH="http_auth";
	public static String IDM_AUTH2_SIGN="10";  //idm auth2.0 验证方式标记
	public static String IDM_REST_SIGN="20";	  //idm rest 验证方式标记
	
	@Context
	protected HttpServletRequest request;
	@Context
	protected HttpServletResponse response;
	@Autowired
	protected UserSessionService userSessionService;
	@Autowired
	private TSysAccesskeyService isysAkService;
	
	static{
		whiteUriList = new ArrayList<String>();
		whiteUriList.add("POST;/NhryService/api/v1/user/doLogin");
		whiteUriList.add("POST;/NhryService/api/v1/user/login");
		whiteUriList.add("GET;/api/v1/order/");
		whiteUriList.add("GET;/api/v1/order/dailyPlans/");
		whiteUriList.add("POST;/api/v1/vipcust/upt/crm/address");
		whiteUriList.add("POST;/api/v1/vipcust/upt/crm/custinfo");
		whiteUriList.add("POST;/api/v1/orderPoint/uptOrderPoint");
		whiteUriList.add("GET;/api/v1/dic/sys/date");
	}
	
	static{
		whiteHostList = new ArrayList<String>();
		whiteHostList.add("127.0.0.1");
		whiteHostList.add("localhost");
		whiteHostList.add("test.nhry-dev.com");
	}

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		String uri = request.getAbsolutePath().getPath();
//		if("product".equals(SysContant.getSystemConst("app_mode"))){
			/**
			 * dh-token   salt(appcode+appkey+timestamp) 26位(固定：010da99b8b994b5794094f2eae)+6位变化的
			 *             内容：appcode+appkey+timestamp
			 * appcode 系统标示  
			 * appkey 对于线下系统调用的是：8位的随机数(字母+数字 组合),线上系统是idm的token
			 * timestamp yyyyMMddHHmmss
			 */
			String idm_auth =request.getHeaderValue("dh-token");
			String appcode =request.getHeaderValue("appcode");
			String dh_ak = CookieUtil.getCookieValue(this.request, UserSessionService.accessKey);
			String http_auth = request.getHeaderValue("Authorization");
			if(!StringUtils.isEmpty(idm_auth)){
				if(StringUtils.isEmpty(appcode)){
					Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
		            throw new WebApplicationException(response);
				}else if("dhxt".equals(appcode)){
					//idm auth2.0认证
					return new IdmAuthFilter(this.request,this.response,this.userSessionService,"dhxt").filter(request);
				}else if("snapp".equals(appcode)){
					//送奶员app认证
					return new IdmAuthFilter(this.request,this.response,this.userSessionService,"snapp").filter(request);
				}else{
					//其他系统线下调用 http basic认证
					return new HttpBasicFilter(this.request,this.response,this.userSessionService).filter(request);
				}
			}else if(!StringUtils.isEmpty(http_auth)){
				//http basic认证
				return new HttpBasicFilter(this.request,this.response,this.userSessionService).filter(request);
			}else if(!StringUtils.isEmpty(dh_ak)){
				//订户系统原来的登录方式
				return new DhAuthFilter(this.request,this.response,this.userSessionService).filter(request);
			}else{
				if(isExsitUri(request.getMethod(),uri)){
					//白名单过滤
					return request;
				}
				Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
	            throw new WebApplicationException(response); 
			}
//		}
		//		return request;
	}
	
	protected Response formatData(String type, Object msg, Object data,Status statusCode) {
		ResponseModel rsmodel = new ResponseModel();
		rsmodel.setType(type);
		rsmodel.setMsg(msg);
		rsmodel.setData(data==null ? "" : data);
		return Response.ok(rsmodel,MediaType.APPLICATION_JSON).status(statusCode).build();
	}
	
	private boolean isExsitUri(String type,String uri){
		for(String u : whiteUriList){
			String _type = u.split(";")[0];
			String _uri = u.split(";")[1];
			if(_type.equalsIgnoreCase(type) && uri.contains(_uri)){
				return true;
			}
		}
		return false;
	}
}
