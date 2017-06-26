package com.nhry.common.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.utils.HttpUtils;
import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;
import com.sun.jersey.spi.container.ContainerRequest;

public class HttpBasicFilter extends AuthFilter {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected UserSessionService userSessionService;
	
    public HttpBasicFilter(HttpServletRequest request,HttpServletResponse response,UserSessionService userSessionService){
    	this.request=request;
    	this.response = response;
    	this.userSessionService = userSessionService;
    }

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub
		TSysUser sysuser = (TSysUser)this.request.getSession().getAttribute("dh-auth");
		if(sysuser != null){
			//swagger方式登录
			if(!MessageCode.NORMAL.equals(userSessionService.checkIdentity(null,this.request,HTTP_AUTH))){
				Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
	            throw new WebApplicationException(response); 
			}
		}else{
			//外部系统调用rest
			if(!MessageCode.NORMAL.equals(userSessionService.checkIdentity(null,this.request,HTTP_AUTH))){
				Response response = formatData(MessageCode.UNAUTHORIZED, SysContant.getSystemConst(MessageCode.UNAUTHORIZED), null, Status.UNAUTHORIZED);
	            throw new WebApplicationException(response); 
			}
		}
		return request;
	}
}
