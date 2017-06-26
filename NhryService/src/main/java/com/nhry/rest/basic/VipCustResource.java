package com.nhry.rest.basic;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.*;
import com.nhry.model.basic.CustQueryModel;
import com.nhry.model.basic.CustStat;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.TVipCrmInfoService;
import com.nhry.service.basic.dao.TVipCustInfoService;
import com.nhry.service.basic.pojo.Addresses;
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

import java.util.HashMap;
import java.util.Map;

@Path("/vipcust")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/vipcust", description = "订户信息维护")
public class VipCustResource extends BaseResource {
	@Autowired
	private TVipCustInfoService custService;
	@Autowired
	private UserSessionService userSessionService;
	@Autowired
	private TVipCrmInfoService vipCrmInfoService;
	
	@GET
	@Path("/batchAddVipSapNo/{salesOrg}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getProductByCodeOrName/{salesOrg}", response = Integer.class, notes = "为导入的订户生成会员号")
	public Response getProductByCodeOrName(@ApiParam(required=true,name="salesOrg",value="销售组织") @PathParam("salesOrg")String salesOrg){
		return convertToRespModel(MessageCode.NORMAL, null, custService.batchAddVipCustSapNo(salesOrg));
	}
	
	@POST
	@Path("/{vipCustNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{vipCustNo}",response = TVipCustInfo.class, notes = "根据订户编号获取会员信息")
	public Response findVipCust(@ApiParam(required=true,name="vipCustNo",value="会员编号") @PathParam("vipCustNo") String vipCustNo) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.findVipCustByNo(vipCustNo));
	}
	
	@POST
	@Path("/upt/cust")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt/cust",response = ResponseModel.class, notes = "修改订户信息")
	public Response findVipCustForUpt(@ApiParam(required=true,name="vipCustNo",value="订户信息对象") TVipCustInfo cust) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.updateVipCustByNo(cust));
	}

	@POST
	@Path("/add/cust")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add/cust", response = ResponseModel.class, notes = "添加订户信息")
	public Response addVipCust(@ApiParam(required=true,name="cust",value="订户信息对象")TVipCustInfo cust) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.addVipCust(cust));
	}

//	@POST
//	@Path("/find/{phone}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiOperation(value = "/find/{phone}", response = TVipCustInfo.class, notes = "根据电话号码查询订户信息")
//	public Response findCustByPhone(@ApiParam(required=true,name="phone",value="电话号码") @PathParam("phone")String phone) {
//		if(!StringUtils.isEmpty(userSessionService.getCurrentUser().getBranchNo())){
//			//奶站用户
//			Map<String,String> attrs = new HashMap<String,String>();
//			attrs.put("branchNo", this.userSessionService.getCurrentUser().getBranchNo());
//			attrs.put("phone",phone);
//			return convertToRespModel(MessageCode.NORMAL, null,custService.findStaCustByPhone(attrs));
//		}
//		//公司用户
//		Map<String,String> attrs = new HashMap<String,String>();
//		attrs.put("branchNo", this.userSessionService.getCurrentUser().getSalesOrg());
//		attrs.put("phone",phone);
//		return convertToRespModel(MessageCode.NORMAL, null,custService.findCompanyCustByPhone(attrs));
//	}
	
	@POST
	@Path("/add/address")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add/address", response = ResponseModel.class, notes = "为订户信息添加地址信息")
	public Response addAdress(@ApiParam(required=true,name="address",value="地址信息对象") TMdAddress address) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.addAddressForCust(address,null,null));
	}
	
	@POST
	@Path("/upt/address")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt/address", response = ResponseModel.class, notes = "修改订户详细地址信息")
	public Response uptCustAddress(@ApiParam(required=true,name="address",value="地址信息对象") TMdAddress address) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.uptCustAddress(address));
	}
	
	@POST
	@Path("/batch/upt/address")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "batch/upt/address", response = ResponseModel.class, notes = "批量更新订户详细地址信息")
	public Response batchUptCustAddress(@ApiParam(required=true,name="addresses",value="地址信息对象列表") Addresses addresses) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.batchUptCustAddress(addresses));
	}
	
	@POST
	@Path("/find/cust")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/cust", response = PageInfo.class, notes = "根据奶站编号、征订时间等内容查询订户信息")
	public Response findcustMixedTerms(@ApiParam(required=true,name="cust",value="订户查询对象") CustQueryModel cust) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.findcustMixedTerms(cust));
	}

	@POST
	@Path("/find/custByOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/custByOrg", response = PageInfo.class, notes = "根据奶站编号、征订时间等内容查询订户信息,机构订户")
	public Response findCustByOrg(@ApiParam(required=true,name="cust",value="订户查询对象") CustQueryModel cust) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.findCustByOrg(cust));
	}
	@POST
	@Path("/find/custWithoutOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/custWithoutOrg", response = PageInfo.class, notes = "根据奶站编号、征订时间等内容查询订户信息,非机构订户")
	public Response custWithoutOrg(@ApiParam(required=true,name="cust",value="订户查询对象") CustQueryModel cust) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.findCustWithoutOrg(cust));
	}

	@POST
	@Path("/find/orgCust")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/orgCust", response = PageInfo.class, notes = "机构订户-根据奶站编号、征订时间等内容查询订户信息")
	public Response findCustByOrgId(@ApiParam(required=true,name="cust",value="订户查询对象") CustQueryModel cust) {
		return convertToRespModel(MessageCode.NORMAL, null,custService.findCustByOrgId(cust));
	}

	@POST
	@Path("/find/address/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/address/{id}", response = TMdAddress.class, notes = "根据地址编号获取地址详细信息")
	public Response findAddressById(@ApiParam(required=true,name="id",value="地址编号id")@PathParam("id")String id) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.findAddressDetailById(id));
	}
	
	@POST
	@Path("/find/cust/address/{custNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/cust/address/{custNo}", response = TMdAddress.class, notes = "根据订户编号获取地址列表信息")
	public Response findCnAddressByCustNo(@ApiParam(required=true,name="custNo",value="订户编号")@PathParam("custNo")String custNo) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.findCnAddressByCustNo(custNo));
	}
	
	@POST
	@Path("/find/cust/acct/{custNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/cust/acct/{custNo}", response = TVipAcct.class, notes = "根据订户编号查询订户的资金订户信息")
	public Response findVipAcctByCustNo(@ApiParam(required=true,name="custNo",value="订户编号")@PathParam("custNo")String custNo) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.findVipAcctByCustNo(custNo));
	}
	
	@POST
	@Path("/upt/address/{status}/{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/find/cust/address/{custNo}", response = ResponseModel.class, notes = "更改订户详细地址状态")
	public Response findVipAcctByCustNo(@ApiParam(required=true,name="status",value="状态标示(10 : 删除  20 ： 改成默认地址)")@PathParam("status")String status,
			@ApiParam(required=true,name="addressId",value="地址编号")@PathParam("addressId")String addressId) {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.uptAddressById(status,addressId));
	}
	
	@POST
	@Path("/status/stat")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/status/stat", response = CustStat.class, notes = "订户状态信息统计( 10-在订;20-暂停;30-停订;40-退订)")
	public Response getCustInfoStat() {
	  return convertToRespModel(MessageCode.NORMAL, null,custService.getCustInfoStat());
	}
	
	@POST
	@Path("/upt/crm/address")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt/crm/address", response = ResponseModel.class, notes = "修改会员详细地址")
	public Response updateVipCrmAddress(@ApiParam(required=true,name="address",value="crm详细地址对象") TMdAddress address) {
	  return convertToRespModel(MessageCode.NORMAL, null,vipCrmInfoService.updateVipCrmAddress(address));
	}
	
	@POST
	@Path("/upt/crm/custinfo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt/crm/custinfo", response = ResponseModel.class, notes = "修改会员详细信息")
	public Response addVipCrm(@ApiParam(required=true,name="crminfo",value="会员对象") TVipCrmInfo crminfo) {
	  return convertToRespModel(MessageCode.NORMAL, null,vipCrmInfoService.updateVipCrmByNo(crminfo));
	}

	@POST
	@Path("/crm/isVip/{mp}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/crm/isVip/{mp}", response = ResponseModel.class, notes = "是否是会员")
	public Response isVip(@ApiParam(required=true,name="mp",value="会员手机号码")@PathParam("mp") String mp) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("phone",mp);
		return convertToRespModel(MessageCode.NORMAL, null,vipCrmInfoService.getCrmNoByPhone(map));
	}

}
