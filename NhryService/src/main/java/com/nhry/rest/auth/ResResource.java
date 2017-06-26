package com.nhry.rest.auth;

import com.alibaba.druid.filter.AutoLoad;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysResource;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.auth.dao.ResourceService;
import com.nhry.utils.PrimaryKeyUtils;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbz on 6/13/2016.
 */
@Path("/res")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/res", description = "资源信息维护")
public class ResResource extends BaseResource {
    @Autowired
    private ResourceService resService;

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/add", response = ResponseModel.class, notes = "添加资源(resType: 10 --> 菜单;20 --> 功能按钮)")
    public Response addRes(@ApiParam(required = true, name = "resource", value = "资源对象(资源编码(resCode)可以自定义)")TSysResource resource) {
        return convertToRespModel(MessageCode.NORMAL, null, resService.addRes(resource));
    }
    
    @POST
    @Path("/lists")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/lists", response = TSysResource.class, notes = "获取所有的资源列表")
    public Response getAllResources() {
        return convertToRespModel(MessageCode.NORMAL, null, resService.getAllResources());
    }
    
    @POST
    @Path("/{roleId}/res/lists")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/{roleId}/res/lists", response = TSysResource.class, notes = "根据角色编号，查询角色关联的资源列表")
    public Response getAllResources(@ApiParam(required = true, name = "roleId", value = "角色编号")@PathParam("roleId")String roleId) {
        return convertToRespModel(MessageCode.NORMAL, null, resService.getRoleResources(roleId));
    }

    @POST
    @Path("/{resCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/get/{resCode}", response = TSysResource.class, notes = "查找资源")
    public Response addRes(@ApiParam(required = true, name = "resCode", value = "资源编号")@PathParam("resCode")String resCode) {
        return convertToRespModel(MessageCode.NORMAL, null, resService.selectResByCode(resCode));
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/update", response = ResponseModel.class, notes = "修改资源")
    public Response updateResByCode(@ApiParam(required = true, name = "resource", value = "资源对象")TSysResource resource) {
        return convertToRespModel(MessageCode.NORMAL, null, resService.updateResByCode(resource));
    }

    @POST
    @Path("/delete/{resCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/delete/{resCode}", response = ResponseModel.class, notes = "删除资源")
    public Response deleteRes(@ApiParam(required = true, name = "resCode", value = "资源编码")@PathParam("resCode")String resCode) {
        return convertToRespModel(MessageCode.NORMAL, null, resService.deleteResByCode(resCode));
    }
    
    @POST
    @Path("/find/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/find/{userId}", response = TSysResource.class, notes = "根据用户编码查询资源信息")
    public Response findResourceByUserId(@ApiParam(required = true, name = "userId", value = "用户编码")@PathParam("userId")String userId){
        return convertToRespModel(MessageCode.NORMAL, null, resService.findRecoureByUserId(userId));
    }
    
    @POST
    @Path("/find/component")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/find/component", response = TSysResource.class, notes = "根据当前用户拥有组件资源信息列表")
    public Response findComponentByLogName(){
        return convertToRespModel(MessageCode.NORMAL, null, resService.findCurUserComponents());
    }
    
    @POST
    @Path("/find/pages")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/find/pages", response = TSysResource.class, notes = "根据当前用户拥有页面资源信息列表")
    public Response findCurUserPages(){
        return convertToRespModel(MessageCode.NORMAL, null, resService.findCurUserPages());
    }
    
    @GET
    @Path("/createUUID")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/createUUID", response = TSysResource.class, notes = "批量生成UUID")
    public Response createUUID(@ApiParam(required = true, name = "count", value = "生成个数")@QueryParam("count")int count){
    	List<String> uuids = new ArrayList<String>();
    	for(int i = 0; i < count; i++) {
    		uuids.add(PrimaryKeyUtils.generateUpperUuidKey());
    	}
    	return convertToRespModel(MessageCode.NORMAL, null, uuids);
    }
}
