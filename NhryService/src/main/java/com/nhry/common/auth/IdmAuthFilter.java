package com.nhry.common.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.exception.MessageCode;
import com.nhry.service.auth.dao.TSysAccesskeyService;
import com.nhry.utils.Base64Util;
import com.nhry.utils.EnvContant;
import com.nhry.utils.SysContant;
import com.sun.jersey.spi.container.ContainerRequest;

public class IdmAuthFilter extends AuthFilter {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserSessionService userSessionService;
	private String type;
	
    public IdmAuthFilter(HttpServletRequest request,HttpServletResponse response,UserSessionService userSessionService,String type){
    	this.request=request;
    	this.response = response;
    	this.userSessionService = userSessionService;
    	this.type = type;
    }
    
	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		String uri = request.getAbsolutePath().getPath();
		String flag =request.getHeaderValue("nh-flag");
		String host = request.getHeaderValue("Host");
		String appkey = request.getHeaderValue("appkey");
		String appcode =request.getHeaderValue("appcode");
		String authflag = IDM_AUTH;
		if("dhxt".equals(appcode)){
			authflag = IDM_AUTH;
		}else if("snapp".equals(appcode)){
			authflag = IDM_REST_AUTH;
		}
		if(!MessageCode.NORMAL.equals(userSessionService.checkIdentity(appkey,this.request,authflag))){
			if("dhxt".equals(appcode)){
				Response response = formatData(MessageCode.SESSION_EXPIRE, SysContant.getSystemConst(MessageCode.SESSION_EXPIRE), 
						StringUtils.isEmpty(flag) ? EnvContant.getIdmLoginPage(null) : EnvContant.getIdmLoginPage(host), Status.UNAUTHORIZED);
	            throw new WebApplicationException(response);
			}else if("snapp".equals(appcode)){
				Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
	            throw new WebApplicationException(response);
			}
		}
		return request;
	}
}
