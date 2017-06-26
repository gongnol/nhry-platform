package com.nhry.rest;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.nhry.common.auth.UserSessionService;
import com.nhry.model.sys.ResponseModel;
import com.nhry.utils.CookieUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BaseResource {
    protected final int pageSize = 8;
    @Context
    protected HttpServletRequest request;
    @Context
    protected HttpServletResponse response;

    protected Response convertToRespModel(String type, Object msg, Object data) {
//		CookieUtil.setCookie(request, response, UserSessionService.accessKey, accesskey);
//		CookieUtil.setCookie(request, response, UserSessionService.uname, loginuser.getLoginName());
        ResponseModel rsmodel = new ResponseModel();
        rsmodel.setType(type);
        rsmodel.setMsg(msg);
        rsmodel.setData(data == null ? "" : data);
        return Response.ok().entity(rsmodel).build();
    }

    protected Response convertToFile(String url) {
        if (StringUtils.isNotEmpty(url)) {
            File targetFilePath = new File(url);
            String mt = new MimetypesFileTypeMap().getContentType(targetFilePath);
            return Response
                    .ok(targetFilePath, mt)
                    .header("Content-disposition", "attachment;filename=" + targetFilePath.getName())
                    .header("ragma", "No-cache").header("Cache-Control", "no-cache").build();
        }else{
            return Response.ok().build();
        }
    }
    
    protected void convertToStream(BufferedImage img) throws IOException {
    	ImageIO.write(img, "JPG", response.getOutputStream());
    }
}
