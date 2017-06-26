package com.nhry.rest.basic;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.model.basic.BranchExkostlModel;
import com.nhry.model.basic.BranchQueryModel;
import com.nhry.model.basic.BranchSendModel;
import com.nhry.model.webService.CustInfoModel;
import com.nhry.model.webService.DealerBranchModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.webService.dao.GetOrderBranchService;
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

@Path("/branch")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/branch", description = "网点客户信息(奶站)信息维护")
public class BranchResource extends BaseResource {
	@Autowired
	private BranchService branchService;
	@Autowired
	private GetOrderBranchService getOrderBranchService;

	@GET
	@Path("/searchBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchBySalesOrg", response = TMdBranch.class, notes = "根据销售组织查询网点客户信息列表")
	public Response findBranchListByOrg(){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.findBranchListByOrg());
	}

	@GET
	@Path("/getBranchByCodeOrName")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getBranchByCodeOrName", response = TMdBranch.class, notes = "根据奶站名称或者名称获取销售组织下奶站列表")
	public Response getBranchByCodeOrName(@ApiParam(required=true,name="branch",value="奶站编号或奶站名称")  @QueryParam("branch") String branch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.getBranchByCodeOrName(branch));
	}

	@GET
	@Path("/getBranchInfo/{branchNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getBranchInfo/{branchNo}", response = TMdBranch.class, notes = "根据网点编号查询网点客户信息列表")
	public Response getBranchByNo(@ApiParam(required=true,name="branchNo",value="网点客户编号")  @PathParam("branchNo") String branchNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.selectBranchByNo(branchNo));
	}

	@GET
	@Path("/getCustBranchInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getCustBranchInfo", response = TMdBranch.class, notes = "获取当前登录人所属奶站")
	public Response getCustBranchInfo(){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.getCustBranchInfo());
	}


	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/list", response = TMdBranch.class, notes = "奶站编号、奶站性质查询网点客户(奶站)信息列表")
	public Response findBranchListByPage(
			@ApiParam(required=true,name="branchModel",value="SearchModel") BranchQueryModel branchModel){
		PageInfo data = branchService.findBranchListByPage(branchModel);
		return convertToRespModel(MessageCode.NORMAL, null,data);
	}

	@POST
	@Path("/upt")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = String.class, notes = "更新网点客户(奶站)信息列表")
	public Response uptBranch(@ApiParam(required=true,name="branchModel",value="SearchModel") TMdBranch tMdBranch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.updateBranch(tMdBranch));
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add", response = String.class, notes = "更新网点客户(奶站)信息列表")
	public Response addBranch(@ApiParam(required=true,name="branchModel",value="SearchModel") TMdBranch tMdBranch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.addBranch(tMdBranch));
	}
	
	@POST
	@Path("/uptValidBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptValidBranch", response = String.class, notes = "更新奶站是否上线")
	public Response uptValidBranch(@ApiParam(required=true,name="branchModel",value="SearchModel") TMdBranch tMdBranch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.uptValidBranch(tMdBranch));
	}

	@POST
	@Path("/uptTargetBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptTargetBranch", response = String.class, notes = "更新奶站内部销售订单售达方")
	public Response uptTargetBranch(@ApiParam(required=true,name="branchModel",value="SearchModel") TMdBranch tMdBranch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.uptTargetBranch(tMdBranch));
	}
	@GET
	@Path("/getInfoByType")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getInfoByType", response = Response.class, notes = "自营下返回可选奶站，外包下返回可选经销商")
	public Response getInfoByType(
			@ApiParam(required=true,name="type",value="01（代表选择自营） 02（代表选择外包）")@QueryParam("type") String type){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.findResultByType(type));
	}
	
	@POST
	@Path("/find/{dealerNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/{deanerNo}", response = String.class, notes = "根据经销商编号获取奶站列表信息")
	public Response findBranchByDno(@ApiParam(required=true,name="dealerNo",value="经销商编号(自营奶站时：-1)")@PathParam("dealerNo") String dealerNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.findBranchByDno(dealerNo));
	}
	
	@POST
	@Path("/find/{salesOrg}/{dealerNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/{salesOrg}/{dealerNo}", response = String.class, notes = "根据销售组织、经销商编号获取奶站列表信息")
	public Response findBranchBySalesOrgDno(@ApiParam(required=true,name="salesOrg",value="销售组织编号")@PathParam("salesOrg") String salesOrg,
			@ApiParam(required=true,name="dealerNo",value="经销商编号(自营奶站时：-1)")@PathParam("dealerNo") String dealerNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.findBranchBySalesOrgDno(salesOrg,dealerNo));
	}

	@POST
	@Path("/getBranchByBussiness")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getBranchByBussiness", response = DealerBranchModel.class, notes = "根据收货人地址 通过电商接口获取分配的奶站")
	public Response getBranchByBussiness(@ApiParam(required=true,name="cModel",value="收货人地址") CustInfoModel cModel){
		return convertToRespModel(MessageCode.NORMAL, null,getOrderBranchService.getOrderBranch(cModel));
	}

	@POST
	@Path("/uptKostl")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptKostl", response = String.class, notes = "更新网点客户(奶站)成品中心属性")
	public Response uptKostl(@ApiParam(required=true,name="Model",value="model") BranchExkostlModel model){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.updateBranchKostl(model));
	}

	@GET
	@Path("/getBranchEx/{branchNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getBranchEx/{branchNo}", response = TMdBranchEx.class, notes = "获取所属奶站的扩展信息")
	public Response getCustBranchInfo(@ApiParam(required = true,name = "branchNo",value = "branchNo") @PathParam("branchNo") String branchNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.getBranchEx(branchNo));
	}

	@GET
	@Path("/isSendMode/{branchNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/isSendMode/{branchNo}", response = TMdBranch.class, notes = "查看是否是送奶工方式报货")
	public Response isSendMode(@ApiParam(required=true,name="branchNo",value="网点客户编号")  @PathParam("branchNo") String branchNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.isSendMode(branchNo));
	}

	@GET
	@Path("/searchSendMode")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchSendMode", response = TMdBranch.class, notes = "查看公司下采用送奶工报货的奶站信息")
	public Response searchSendMode(){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.findBranchSendMode());
	}

	@POST
	@Path("/addSendMode")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/addSendMode", response = String.class, notes = "设置送奶工报货奶站")
	public Response addSendMode(@ApiParam(required=true,name="Model",value="model") BranchSendModel model){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.insertSendModes(model.getBranchNos()));
	}
	@POST
	@Path("/uptBankBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptBankBranch", response = String.class, notes = "更新奶站户头")
	public Response uptBankBranch(@ApiParam(required=true,name="TMdBranch",value="tMdBranch") TMdBranch tMdBranch){
		return convertToRespModel(MessageCode.NORMAL, null,branchService.uptBankBranch(tMdBranch));
	}

}
