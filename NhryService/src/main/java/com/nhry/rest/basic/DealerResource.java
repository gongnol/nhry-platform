package com.nhry.rest.basic;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.SearchModel.TMdDealerStatusModel;
import com.nhry.data.basic.domain.DealerQueryModel;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.DealerService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/dealer")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/dealer", description = "经销商信息维护")
public class DealerResource extends BaseResource {
	@Autowired
	private DealerService dealerService;

	@GET
	@Path("/getDealerBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerBySalesOrg", response = List.class, notes = "根据销售组织查询经销商信息列表")
	public Response findBranchListByOrg(){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealerBySalesOrg());
	}

	@GET
	@Path("/getDealerOnAuth")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerOnAuth", response = List.class, notes = "查询经销商信息列表")
	public Response getDealerOnAuth(){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealerOnAuth());
	}
	

	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/list", response = TMdBranch.class, notes = "经销商编号信息列表")
	public Response findBranchListByPage(
			@ApiParam(required=true,name="dealerQueryModel",value="dealerQueryModel") DealerQueryModel sModel){
		PageInfo data = dealerService.findDealerListByPage(sModel);
		return convertToRespModel(MessageCode.NORMAL, null,data);
	}
	
	
	@GET
	@Path("/getDealersBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerBySalesOrg", response = List.class, notes = "根据销售组织查询经销商信息列表")
	public Response getDealersBySalesOrg(@ApiParam(required=true,name="salesOrg",value="salesOrg") @QueryParam("salesOrg") String salesOrg){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealersBySalesOrg(salesOrg));
		
	}
	
	

	@POST
	@Path("/addDealer")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/addDealer", response = ResponseModel.class, notes = "增加经销商")
	public Response addDealer(@ApiParam(required = true, name = "dealer", value = "经销商对象") TMdDealer dealer) {
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.addDealer(dealer));
	}
	
	
	@GET
	@Path("/getDealerInfo/{dealerNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerInfo/{dealerNo}", response = TMdBranch.class, notes = "根据经销商编号查询经销商信息列表")
	public Response getDealerInfo(@ApiParam(required=true,name="dealerNo",value="经销商编号")  @PathParam("dealerNo") String dealerNo){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.selectDealerByNo(dealerNo));
	}
	
	

	@POST
	@Path("/updateDealerStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/updateDealerStatus", response = String.class, notes = "更新经销商状态")
	public Response updateDealerStatus(@ApiParam(required=true,name="branchModel",value="SearchModel") TMdDealerStatusModel model){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.updateDealerStatus(model));
	}
	
	

	@GET
	@Path("/getDealerOnAuthAndGroup/{branchGroup}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerOnAuthAndGroup/{branchGroup}", response = List.class, notes = "查询经销商信息列表")
	public Response getDealerOnAuthAndGroup(@ApiParam(required=true,name="branchGroup",value="经销商编号")  @PathParam("branchGroup") String branchGroup){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealerOnAuthAndGroup(branchGroup));
	}
	
	

	@POST
	@Path("/updateDealerInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/updateDealerInfo", response = String.class, notes = "更新经销商信息")
	public Response updateDealerInfo(@ApiParam(required=true,name="dealer",value="dealer") TMdDealer dealer){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.updateDealerInfo(dealer));
	}
	
	
	



}
