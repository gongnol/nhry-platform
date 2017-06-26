package com.nhry.rest.config;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.config.domain.NHSysParameter;
import com.nhry.model.basic.SysParamQueryModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.config.dao.SysParamService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/sys/param")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/sys/param", description = "系统参数信息维护")
public class SysParamterResource extends BaseResource {
	@Autowired
	private SysParamService sysParamService;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add", response = ResponseModel.class, notes = "增加系统参数")
	public Response addSysParam(@ApiParam(required=true,name="param",value="系统参数json格式")NHSysParameter param){
		return convertToRespModel(MessageCode.NORMAL, null,  sysParamService.addSysParam(param));
	}
	
	@POST
	@Path("/upt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = String.class, notes = "修改系统参数")
	public Response uptSysParam(@ApiParam(required=true,name="param",value="系统参数json格式")NHSysParameter param){
		return convertToRespModel(MessageCode.NORMAL, null,  sysParamService.uptSysParamByCode(param));
	}
	
	@POST
	@Path("/del/{paramCode}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/del", response = String.class, notes = "根据参数编码删除系统参数")
	public Response delSysParam(@ApiParam(required=true,name="paramCode",value="参数编码")@PathParam("paramCode")String paramCode){
		return convertToRespModel(MessageCode.NORMAL, null,  sysParamService.deleteSysParamByCode(paramCode));
	}
	
	@POST
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{code}", response = NHSysParameter.class, notes = "根据code查询系统参数")
	public Response findSysParamByCode(@ApiParam(required=true,name="code",value="参数编码") @PathParam("code") String code){
		return convertToRespModel(MessageCode.NORMAL, null,sysParamService.selectSysParamByCode(code));
	}
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search", response = NHSysParameter.class, notes = "根据参数编码、参数名称、参数值，查询系统参数")
	public Response searchSysParam(@ApiParam(required=true,name="paramName",value="参数名称") SysParamQueryModel param){
		return convertToRespModel(MessageCode.NORMAL, null,sysParamService.findSysParam(param));
	}
	
}
