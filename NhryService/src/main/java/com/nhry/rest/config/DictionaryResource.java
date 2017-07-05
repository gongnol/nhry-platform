package com.nhry.rest.config;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.config.domain.NHSysCodeType;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.utils.date.Date;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/dic")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/dic", description = "字典信息维护")
public class DictionaryResource extends BaseResource {
	@Autowired
	private DictionaryService dicService;
/*	
	@Autowired
	private LadpService ladpService;
	*/
	@POST
	@Path("/items/{typecode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/items/{typecode}", response = NHSysCodeItem.class, notes = "根据类型编码查找字典代码")
	public Response getCodeItems(@ApiParam(required=true,name="typecode",value="类型编码")@PathParam("typecode")String typecode){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.getCodeItemsByTypeCode(typecode));
	}
	
	@POST
	@Path("/items/tree/{typecode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/items/tree/{typecode}", response = NHSysCodeItem.class, notes = "根据类型编码查找字典代码(树状结构)")
	public Response getTreeCodeItemsByTypeCode(@ApiParam(required=true,name="typecode",value="类型编码")@PathParam("typecode")String typecode){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.getTreeCodeItemsByTypeCode(typecode));
	}
	
	@POST
	@Path("/find/child/items")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/child/items", response = NHSysCodeItem.class, notes = "根据typeCode和parent查询子itemsCode")
	public Response findItemsByParentCode(@ApiParam(required=true,name="record",value="字典代码行项目对象(typeCode、parent)")NHSysCodeItem record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.findItemsByParentCode(record));
	}
	
	@POST
	@Path("/del/codetype/{typecode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/del/codetype/{typecode}", response = ResponseModel.class, notes = "根据typecode删除字典代码类型")
	public Response delSysCodeTypeByCode(@ApiParam(required=true,name="typecode",value="类型编码")@PathParam("typecode")String typecode){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.delSysCodeTypeByCode(typecode));
	}
	
	@POST
	@Path("/add/codetype")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add/codetype", response = ResponseModel.class, notes = "添加字典代码类型")
	public Response addSysCodeType(@ApiParam(required=true,name="record",value="字典代码类型对象")NHSysCodeType record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.addSysCodeType(record));
	}
	
	@POST
	@Path("/find/codetype/{typecode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/codetype/{typecode}", response = NHSysCodeType.class, notes = "根据typecode查询字典代码类型")
	public Response findCodeTypeByCode(@ApiParam(required=true,name="typeCode",value="类型编码")@PathParam("typecode")String typecode){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.findCodeTypeByCode(typecode));
	}
	
	@POST
	@Path("/update/codetype")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/del/codetype/{typecode}", response = ResponseModel.class, notes = "修改字典代码类型")
	public Response updateSysCodeType(@ApiParam(required=true,name="record",value="字典代码类型对象")NHSysCodeType record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.updateSysCodeType(record));
	}
	
	@POST
	@Path("/add/codeitem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add/codeitem", response = ResponseModel.class, notes = "修改字典代码行项目")
	public Response addCodeItem(@ApiParam(required=true,name="record",value="字典代码行项目对象")NHSysCodeItem record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.addCodeItem(record));
	}
	
	@POST
	@Path("/find/codeitem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/codeitem", response = NHSysCodeItem.class, notes = "根据code查询字典代码行项目")
	public Response findCodeItenByCode(@ApiParam(required=true,name="record",value="字典代码行项目对象(typeCode、itemCode)")NHSysCodeItem record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.findCodeItenByCode(record));
	}
	
	@POST
	@Path("/update/codeitem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/update/codeitem", response = ResponseModel.class, notes = "根据code字典代码行项目")
	public Response updateCodeItemByCode(@ApiParam(required=true,name="record",value="字典代码行项目对象")NHSysCodeItem record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.updateCodeItemByCode(record));
	}
	
	@POST
	@Path("/delete/codeitem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/delete/codeitem", response = ResponseModel.class, notes = "根据code删除字典代码行项目")
	public Response deleteCodeItemByCode(@ApiParam(required=true,name="record",value="字典代码行项目对象(typeCode、itemCode)")NHSysCodeItem record){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.deleteCodeItemByCode(record));
	}
	
	
	
	@GET
	@Path("/allTypeCodes")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/allTypeCodes", response = String.class, notes = "获取所有字典代码类型")
	public Response getAllTypeCodes(){
		return convertToRespModel(MessageCode.NORMAL, null,  dicService.findAllTypeCodes());
	}
/*
	@GET
	@Path("/allTypeCodesByPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/allTypeCodes", response = String.class, notes = "获取所有字典代码类型")
	public Response getAllTypeCodesByPage(@ApiParam(required=true,name="dictionarySearchModel",value="dictionarySearchModel") DictionarySearchModel searchModel){
		PageInfo data = dicService.findAllTypeCodesByPage(searchModel);
		return convertToRespModel(MessageCode.NORMAL, null, data );
	}
	*/
	/*
	@POST
	@Path("/sync/users/all")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sync/users/all", response = ResponseModel.class, notes = "全量同步idm订户系统用户")
	public Response syncSysUsers(){
		return convertToRespModel(MessageCode.NORMAL, null,  ladpService.syncSysUsers(true));
	}
	
	@POST
	@Path("/sync/users/upt")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sync/users/upt", response = ResponseModel.class, notes = "增量同步idm订户系统用户")
	public Response syncSysUsersForUpt(){
		return convertToRespModel(MessageCode.NORMAL, null,  ladpService.syncSysUsers(false));
	}*/
	
	@GET
	@Path("/sys/date")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sys/date", response = ResponseModel.class, notes = "获取系统时间")
	public Response getSysDate(){
		return convertToRespModel(MessageCode.NORMAL, null,  new Date().toTimeStamp());
	}
}
