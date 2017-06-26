package com.nhry.rest.basic;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.model.basic.BranchAreaSearch;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.ResidentialAreaService;
import com.nhry.service.basic.pojo.AreaSearchModel;
import com.nhry.service.basic.pojo.BranchScopeModel;
import com.nhry.service.basic.pojo.ResidentialAreaModel;
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

@Path("/residentialArea")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/residentialArea", description = "小区信息（配送区域）维护")
public class ResidentialAreaResource extends BaseResource {
	@Autowired
	private ResidentialAreaService residentialAreaService;

	@POST
	@Path("/searchAreaBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchAreaBySalesOrg", response = Response.class, notes = "获取当前销售组织下的获取小区(配送区域)列表")
	public Response searchAreaBySalesOrg(@ApiParam(required=true,name="aModel",value="省、市、区") AreaSearchModel aModel) {
		return convertToRespModel(MessageCode.NORMAL, null,residentialAreaService.searchAreaBySalesOrg(aModel));
	}

	@POST
	@Path("/searchSalesOrgArea")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchSalesOrgArea", response = Response.class, notes = "获取当前销售组织下所有的获取小区(配送区域)列表")
	public Response searchSalesOrgArea(@ApiParam(required=true,name="aModel",value="省、市、区") AreaSearchModel aModel) {
		return convertToRespModel(MessageCode.NORMAL, null,residentialAreaService.searchSalesOrgArea(aModel));
	}

	@POST
	@Path("/searchAreaByBranchNo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAreaByBranchNo", response = PageInfo.class, notes = "根据网点客户信息号(奶站编号)获取小区(配送区域)列表")
	public Response getAreaByBranchNo(
			@ApiParam(required = true, name = "bsearch", value = "网店客户信息号(奶站编号)") BranchAreaSearch bsearch) {
		return convertToRespModel(MessageCode.NORMAL, null,
				residentialAreaService.searchAreaByBranchNo(bsearch));
	}


	@GET
	@Path("/getAreaByBranchNo/{branchNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAreaByBranchNo", response = PageInfo.class, notes = "根据网点客户信息号(奶站编号)获取小区(配送区域)列表")
	public Response getAreaByBranchNo(
			@ApiParam(required = true, name = "branchNo", value = "网店客户信息号(奶站编号)") @PathParam("branchNo") String  branchNo) {
		return convertToRespModel(MessageCode.NORMAL, null,
				residentialAreaService.getAreaByBranchNo(branchNo));
	}

	@GET
	@Path("/getAreaById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAreaById/{id}", response = TMdResidentialArea.class, notes = "根据小区编号获取配送区域(小区)")
	public Response selectById(
			@ApiParam(required = true, name = "id", value = "小区编号") @PathParam("id") String id) {
		return convertToRespModel(MessageCode.NORMAL, null,
				residentialAreaService.selectById(id));
	}

	@GET
	@Path("/deleteAreaById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/deleteAreaById/{id}", response = TMdResidentialArea.class, notes = "删除小区信息，并删除小区和奶站的关系表")
	public Response deleteAreaById(
			@ApiParam(required = true, name = "id", value = "小区编号") @PathParam("id") String id) {
		return convertToRespModel(MessageCode.NORMAL, null,
				residentialAreaService.deleteAreaById(id));
	}

	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/list", response = TMdResidentialArea.class, notes = "根据省份、城市、状态查询小区(配送区域)信息列表")
	public Response findAreaListByPage(
			@ApiParam(required=true,name="branchModel",value="SearchModel") ResidentialAreaModel residentialAreaModel){
		PageInfo data = residentialAreaService.findAreaListByPage(residentialAreaModel);
		return convertToRespModel(MessageCode.NORMAL, null,data);
	}



	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add", response = String.class, notes = "添加小区信息")
	public Response addResidentialArea(@ApiParam(required=true,name="residentialAreaModel",value="系统参数json格式")TMdResidentialArea tMdResidentialArea){
		return convertToRespModel(MessageCode.NORMAL, null,  residentialAreaService.addResidentialArea(tMdResidentialArea));
	}

	@POST
	@Path("/upt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = String.class, notes = "更新小区信息")
	public Response uptResidentialArea(@ApiParam(required=true,name="residentialAreaModel",value="系统参数json格式")TMdResidentialArea tMdResidentialArea){
		return convertToRespModel(MessageCode.NORMAL, null,  residentialAreaService.uptResidentialArea(tMdResidentialArea));
	}

	@POST
	@Path("/relBranch")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/relBranch", response = String.class, notes = "配送区域关联奶站")
	public Response areaRelBranch(@ApiParam(required=true,name="bModel",value="系统参数json格式")BranchScopeModel bModel){
		return convertToRespModel(MessageCode.NORMAL, null,  residentialAreaService.areaRelBranch(bModel));
	}

	@POST
	@Path("/getUnDistAreas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getUnDistAreas", response = TMdResidentialArea.class, notes = "获取未分配区域列表")
	public Response getUnDistAreas(){
		return convertToRespModel(MessageCode.NORMAL, null,  residentialAreaService.getUnDistAreas());
	}




}
