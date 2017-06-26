package com.nhry.common.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.nhry.common.exception.MessageCode;
import com.nhry.utils.CookieUtil;
import com.nhry.utils.SysContant;

import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.container.ContainerRequest;

public class DhAuthFilter extends AuthFilter {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected UserSessionService userSessionService;
	
    public DhAuthFilter(HttpServletRequest request,HttpServletResponse response,UserSessionService userSessionService){
    	this.request=request;
    	this.response = response;
    	this.userSessionService = userSessionService;
    }

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		String uri = request.getAbsolutePath().getPath();
		String ak = CookieUtil.getCookieValue(this.request, UserSessionService.accessKey);
		String userName = CookieUtil.getCookieValue(this.request, UserSessionService.uname);
		//未登录
		if(StringUtils.isEmpty(ak) || StringUtils.isEmpty(userName)){
			if(!whiteUriList.contains(uri)){
				Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
	            throw new WebApplicationException(response); 
			}
		}else	if(!MessageCode.NORMAL.equals(userSessionService.checkIdentity(userName,this.request,DH_AUTH))){
			Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
            throw new WebApplicationException(response); 
		}
		return request;
	}

}
