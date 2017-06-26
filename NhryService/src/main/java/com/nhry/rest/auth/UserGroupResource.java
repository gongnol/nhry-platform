package com.nhry.rest.auth;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUserGroup;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.auth.dao.TSysUserGroupService;
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
@Path("/user/group")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/user/group", description = "用户组rest api")
public class UserGroupResource extends BaseResource {
  @Autowired
  private TSysUserGroupService ugService;
  
    @POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add", response = ResponseModel.class, notes = "添加用户组")
	public Response addUserGroup(@ApiParam(required = true, name = "record", value = "用户组json对象,只需要填写groupName属性") TSysUserGroup record) {
		return convertToRespModel(MessageCode.NORMAL, null, ugService.addUserGroup(record));
	}
    
    @POST
  	@Path("/delete/{id}")
  	@Produces(MediaType.APPLICATION_JSON)
  	@ApiOperation(value = "/delete/{id}", response = ResponseModel.class, notes = "删除用户组")
  	public Response deleteUserGroup(@ApiParam(required = true, name = "id", value = "主键id") @PathParam("id")String id) {
  		return convertToRespModel(MessageCode.NORMAL, null, ugService.deleteUserGroupById(id));
  	}
    
    @POST
  	@Path("/update")
  	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
  	@ApiOperation(value = "/update", response = String.class, notes = "删除用户组")
  	public Response updateUserGroup(@ApiParam(required = true, name = "id", value = "主键id") TSysUserGroup record) {
  		return convertToRespModel(MessageCode.NORMAL, null, ugService.updateUserGroupById(record));
  	}
    
    @POST
  	@Path("/find/{id}")
  	@Produces(MediaType.APPLICATION_JSON)
  	@ApiOperation(value = "/find/{id}", response = ResponseModel.class, notes = "根据主键id查找用户组")
  	public Response findUserGroup(@ApiParam(required = true, name = "id", value = "主键id") @PathParam("id")String id) {
  		return convertToRespModel(MessageCode.NORMAL, null,ugService.findUserGroupById(id));
  	}
    
    @POST
  	@Path("/find/all")
  	@Produces(MediaType.APPLICATION_JSON)
  	@ApiOperation(value = "/find/all", response = ResponseModel.class, notes = "查询所有的用户组")
  	public Response findAllUserGroup() {
  		return convertToRespModel(MessageCode.NORMAL, null,ugService.findAllUserGroups());
  	}
}
