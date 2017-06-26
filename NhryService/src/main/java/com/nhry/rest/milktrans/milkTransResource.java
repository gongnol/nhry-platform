package com.nhry.rest.milktrans;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrder;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrderItem;
import com.nhry.model.milktrans.*;
import com.nhry.rest.BaseResource;
import com.nhry.service.milk.dao.DeliverMilkService;
import com.nhry.service.milktrans.dao.RequireOrderService;
import com.nhry.service.milktrans.dao.ReturnBoxService;
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
import java.util.Date;

@Path("/milkTrans")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/milkTrans", description = "送奶管理")
public class milkTransResource extends BaseResource {
	@Autowired
	private RequireOrderService requireOrderService;
	@Autowired
	private ReturnBoxService returnBoxService;
	@Autowired
	private DeliverMilkService deliverMilkService;

	@POST
	@Path("/creatPromoSalOrderOfDealerBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatPromoSalOrderOfDealerBranch", response = Response.class, notes = "根据日订单生成经销商奶站的参加促销的销售订单")
	public Response creatSalOrderOfDealerBranch(@ApiParam(required=true,name="rSearch",value="日期") ReqGoodsOrderSearch  rSearch){
		return convertToRespModel(MessageCode.NORMAL, null,  requireOrderService.creatPromoSalOrderOfDealerBranch(rSearch.getRequiredDate(),"" ,"" ));
	}


	@POST
	@Path("/creatNoPromoSalOrderOfDealerBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatNoPromoSalOrderOfDealerBranch", response = Response.class, notes = "根据日订单，要货计划生成经销商奶站的销售订单")
	public Response creatNoPromoSalOrderOfDealerBranch(@ApiParam(required=true,name="rSearch",value="日期") ReqGoodsOrderSearch  rSearch){
		TSysUser user = new TSysUser();
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creatNoPromoSalOrderOfDealerBranch(rSearch.getRequiredDate(), user.getBranchNo(),user.getSalesOrg() ));
	}


	@POST
	@Path("/creatNoPromoSalOrderOfSelftBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatNoPromoSalOrderOfSelftBranch", response = Response.class, notes = "根据当天确认的日订单的非赠品，内部销售订单 生成自营奶站的销售订单")
	public Response creatNoPromoSalOrderOfSelftBranch(@ApiParam(required=true,name="rSearch",value="日期") ReqGoodsOrderSearch  rSearch){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creatNoPromoSalOrderAndSendOfSelftBranch(rSearch.getRequiredDate()));
	}


	@POST
	@Path("/creatPromoSalOrderOfSelftBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatPromoSalOrderOfSelftBranch", response = Response.class, notes = "根据当天确认的日订单中赠品 生成自营奶站免费的销售订单（并发送）")
	public Response creatPromoSalOrderOfSelftBranch(@ApiParam(required=true,name="rSearch",value="日期") ReqGoodsOrderSearch  rSearch){
		return convertToRespModel(MessageCode.NORMAL, null,  requireOrderService.creatPromoSalOrderAndSendOfSelftBranch(rSearch.getRequiredDate()));
	}

	@POST
	@Path("/creatRequireOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatRequireOrder", response = RequireOrderModel.class, notes = "生成要货计划")
	public Response creatRequireOrder(){
		ReqGoodsOrderSearch eSearch = new ReqGoodsOrderSearch();
		eSearch.setRequiredDate(new Date());
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creatRequireOrderByDate(eSearch));
	}


	@POST
	@Path("/queryRefuseResendByMatnr/{matnr}/{orderNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/queryRefuseResendByMatnr/{matnr}/{reqOrderNo}", response = RequireOrderModel.class, notes = "查询奶站下拒收复送产品信息")
	public Response queryRefuseResendByMatnr(@ApiParam(required=true,name="matnr",value="产品编号") @PathParam("matnr") String matnr,
											 @ApiParam(required=true,name="reqOrderNo",value="产品编号")@PathParam("orderNo") String orderNo) {
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.queryRefuseResendByMatnr(matnr,orderNo));
	}

	@POST
	@Path("/uptRequireOrderByResendItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptRequireOrderByResendItem", response = RequireOrderModel.class, notes = "要货计划 确认使用拒收复送产品信息")
	public Response uptRequireOrderByResendItem(@ApiParam(required=true,name="eSearch",value="产品编号") UptReqOrderByResendItemMode umodel) {
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.uptRequireOrderByResendItem(umodel));
	}


	@POST
	@Path("/creatRequireOrderByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creatRequireOrderByDate", response = RequireOrderModel.class, notes = "生成指定日期的要货计划")
	public Response creatRequireOrderByDate(@ApiParam(required=true,name="orderDate",value="日期") ReqGoodsOrderSearch eSearch){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creatRequireOrderByDate(eSearch));
	}

	@POST
	@Path("/queryRequireOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/queryRequireOrder", response = RequireOrderModel.class, notes = "查询奶站下某一天的要货计划")
	public Response searchRequireOrder(@ApiParam(required=true,name="eSearch",value="要货计划日期") ReqGoodsOrderSearch eSearch) {

		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.searchRequireOrder(eSearch.getRequiredDate()));
	}

	@POST
	@Path("/uptRequireOrderItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptRequireOrderItem", response = Response.class, notes = "更新生成的要货计划行")
	public Response uptRequireOrderItem(@ApiParam(required=true,name="rModel",value="要货计划") UpdateRequiredModel  uModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.uptRequireOrder(uModel));
	}



	@POST
	@Path("/uptNewRequireOrderItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptNewRequireOrderItem", response = Response.class, notes = "更新新添加的要货计划行")
	public Response uptNewRequireOrderItem(@ApiParam(required=true,name="rModel",value="要货计划") UpdateNewRequiredModel  uModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.uptNewRequireOrderItem(uModel));
	}



	@POST
	@Path("/addRequireOrderItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/addRequireOrderItem", response = Response.class, notes = "添加新的生成要货计划行")
	public Response addRequireOrderItem(@ApiParam(required=true,name="item",value="要货计划") TSsmReqGoodsOrderItem item){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.addRequireOrderItem(item));
	}



	@POST
	@Path("/delRequireOrderItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/delRequireOrderItem", response = Response.class, notes = "删除新添加的生成要货计划行")
	public Response delRequireOrderItem(@ApiParam(required=true,name="dModel",value="要货计划") ReqGoodsOrderItemSearch  item){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.delRequireOrderItem(item));
	}



	@POST
	@Path("/sendRequireOrderToERP")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sendRequireOrderToERP", response = String.class, notes = "传到ERP系统")
	public Response sendRequireOrderToERP(){
		ReqGoodsOrderSearch eSearch = new ReqGoodsOrderSearch();
		eSearch.setRequiredDate(new Date());
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.sendRequireOrderToERPByDate(eSearch));
	}

	@POST
	@Path("/sendRequireOrderToERPByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sendRequireOrderToERPByDate", response = String.class, notes = "传到指定日期的要货计划ERP系统")
	public Response sendRequireOrderToERPByDate(@ApiParam(required=true,name="orderDate",value="日期") ReqGoodsOrderSearch eSearch){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.sendRequireOrderToERPByDate(eSearch));
	}

	@POST
	@Path("/creaSalOrderOfSelftBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creaSalOrderOfSelftBranch", response = Response.class, notes = "自营奶站 根据（路单和内部销售订单）交货单(不参加促销的) 和 参加促销（路单中）产品  创建今天的销售订单")
	public Response creaSalOrderOfSelftBranch(){
		SalOrderDaySearch search = new SalOrderDaySearch();
		search.setOrderDate(new Date());
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creaSalOrderOfSelftBranchByDate2(search));
	}

	@POST
	@Path("/creaSalOrderOfSelftBranchByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creaSalOrderOfSelftBranchByDate", response = Response.class, notes = "自营奶站 根据指定日期的 路单和内部销售订单 创建销售订单")
	public Response creaSalOrderOfSelftBranchByDate(@ApiParam(required=true,name="search",value="日期") SalOrderDaySearch search){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creaSalOrderOfSelftBranchByDate2(search));
	}

	@POST
	@Path("/creaSalOrderOfDealerBranchByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/creaSalOrderOfDealerBranchByDate", response = Response.class, notes = "经销商奶站 根据 日订单 创建销售订单")
	public Response creaSalOrderOfDealerBranch(@ApiParam(required=true,name="search",value="日期") SalOrderDaySearch search){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.creaSalOrderOfDealerBranchByDate(search.getOrderDate()));
	}



	@POST
	@Path("/salOrder/getSaleOrderByQueryDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/salOrder/getSaleOrderByQueryDate", response = Response.class, notes = "查询日期的销售订单")
	public Response getSaleOrderByQueryDate(@ApiParam(required=true,name="eSearch",value="销售订单日期") SalOrderModel sModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.getSaleOrderByQueryDate(sModel));
	}


	@GET
	@Path("/salOrder/getSaleOrderDetailByOrderNo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/salOrder/getSaleOrderDetailByOrderNo", response = Response.class, notes = "根据销售订单号获取详情")
	public Response getSaleOrderDetailByOrderNo(@ApiParam(required=true,name="orderNo",value="销售订单号") @QueryParam("orderNo") String orderNo){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.getSaleOrderDetailByOrderNo(orderNo));
	}



	@POST
	@Path("/box/upt")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/box/upt", response = Response.class, notes = "录入回瓶管理")
	public Response uptBoxRetrun(@ApiParam(required=true,name="cModel",value="cModel") UpdateReturnBoxModel boxModel){
		return convertToRespModel(MessageCode.NORMAL, null, returnBoxService.uptBoxRetrun(boxModel));
	}


	@GET
	@Path("/box/createDayRetBox")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/box/createDayRetBox", response = Response.class, notes = "生成当天(员工)需要回瓶的数据")
	public Response createDayRetBox(@ApiParam(required=true,name="dispOrderNo",value="配送单号") @QueryParam("dispOrderNo") String dispOrderNo){
		return convertToRespModel(MessageCode.NORMAL, null, returnBoxService.createDayRetBox(dispOrderNo));
	}


	@POST
	@Path("/box/searchRetBoxPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/box/createToDayRetBox", response = PageInfo.class, notes = "奶瓶回收列表")
	public Response searchToDayRetBoxPage(@ApiParam(required=true,name="rSearch",value="cModel") ReturnboxSerarch rSearch){
		return convertToRespModel(MessageCode.NORMAL, null, returnBoxService.searchRetBoxPage(rSearch));
	}


	@POST
	@Path("/createInsideSalOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createInsideSalOrder", response = Response.class, notes = "根据确认后的路单创建内部销售订单")
	public Response createInsideSalOrder(@ApiParam(required=true,name="dispOrderNo",value="配送单号")@QueryParam("dispOrderNo") String  dispOrderNo){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createInsideSalOrder(dispOrderNo));
	}
	@POST
	@Path("/createInsideSalOrderByStock")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createInsideSalOrderByStock", response = Response.class, notes = "根据多余库存创建内部销售订单")
	public Response createInsideSalOrderByStock(@ApiParam(required=true,name="dispOrderNo",value="员工（默认站长），产品编码列表，销售组织") CreateInSalOrderModel cModel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createInsideSalOrderByStock(cModel));
	}

	@POST
	@Path("/createInsideSalOrderByTmpStock")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createInsideSalOrderByTmpStock", response = Response.class, notes = "根据拒收复送创建内部销售订单")
	public Response createInsideSalOrderByTmpStock(@ApiParam(required=true,name="dispOrderNo",value="员工（默认站长），产品编码列表，销售组织") CreateInsalOrderByRefuseModel cModel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createInsideSalOrderByTmpStock(cModel));
	}

	@POST
	@Path("/getInsideSalOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getInsideSalOrder", response = Response.class, notes = "获取当前奶站下所有的内部销售订单")
	public Response getInsideSalOrder(@ApiParam(required=true,name="sModel",value="分页查询") InSideSalOrderSearchModel sModel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.getInsideSalOrder(sModel));
	}



	@POST
	@Path("/getInsideSalOrderDetail")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getInsideSalOrderDetail", response = Response.class, notes = "获取内部销售订单详情")
	public Response getInsideSalOrderDetail(@ApiParam(required=true,name="sModel",value="订单号必须，分页查询") InSideSalOrderDetailSearchModel sModel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.getInsideSalOrderDetail(sModel));
	}

	@POST
	@Path("/search/dealer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search/dealer", response = Response.class, notes = "经销商内勤查询要货单信息")
	public Response searchRequireOrderByDealer(@ApiParam(required=true,name="sModel",value="订单号必须，分页查询") RequireOrderSearchPage sModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.searchRequireOrderByDealer(sModel));
	}

	@POST
	@Path("/searchSalOrder/dealer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchSalOrder/dealer", response = Response.class, notes = "经销商内勤查询销售订单信息")
	public Response searchSalOrderByDealer(@ApiParam(required=true,name="sModel",value="分页查询") RequireOrderSearchPage sModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.searchSalOrderByDealer(sModel));
	}

	@GET
	@Path("/queryRequireOrder/{orderNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/queryRequireOrder/{orderNo}", response = RequireOrderModel.class, notes = "查询指定的要货计划")
	public Response searchRequireOrderByOrderNo(@ApiParam(required=true,name="orderNo",value="要货计划编号")@PathParam("orderNo")String orderNo) {
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.getRequireOrderByOrderNo(orderNo));
	}
	@POST
	@Path("/batch/send")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/batch/send", response = RequireOrderModel.class, notes = "经销商内勤发送销售订单到ERP")
	public Response batchSendSalOrder(@ApiParam(required = false,name = "orderNos",value = "订单号")ReqOrderNosSearch orderNos) {
		return convertToRespModel(MessageCode.NORMAL, null,requireOrderService.batchSendSalOrder(orderNos.getOrderNos()));
	}

	@POST
	@Path("/queryRefuseResendByOrderNo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/queryRefuseResendByOrderNo", response = Response.class, notes = "查询要货单的拒收复送产品信息")
	public Response queryRefuseResendByMatnr(@ApiParam(required=true,name="params",value="订单orderDate 和 orderNo")TSsmReqGoodsOrder params) {
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.findReqGoodResendByOrderNo(params.getOrderDate(),params.getBranchNo()));
	}

	@POST
	@Path("/batchSendSalOrderByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/batchSendSalOrderByDate", response = Response.class, notes = "自营奶站 发送送奶工相关的销售订单")
	public Response batchSendSalOrderByDate(@ApiParam(required=true,name="search",value="日期") SalOrderDaySearch search){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.batchSendSalOrderByDate(search));
	}


	@POST
	@Path("/updateSalOrderItems")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/updateSalOrderItems", response = Response.class, notes = "更新销售订单明细产品数量")
	public Response updateSalOrderItems(@ApiParam(required=true,name="eSearch",value="销售订单明细列表") SaleOrderModel sModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.updateSalOrderItems(sModel.getEntries()));
	}

	@POST
	@Path("/isEmpSendMode")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/isEmpSendMode", response = Response.class, notes = "判断是否是送奶工报货")
	public Response updateSalOrderItems(){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.isEmpSendMode());
	}

	@POST
	@Path("/getRequireDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getRequireDate", response = Response.class, notes = "获取奶站要货日期或销售日期")
	public Response getSalOrderDate(@ApiParam(required=true,name="eSearch",value="销售订单明细列表") SalOrderModel sModel){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.getRequireDate(sModel.getOrderDate()));
	}

	@POST
	@Path("/sumGiOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sumGiOrder", response = Response.class, notes = "统计奶站交货单数量")
	public Response sumGiOrder(@ApiParam(required=true,name="search",value="日期") SalOrderDaySearch search){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.sumGiOrderItemByReqOrderNo(search.getOrderDate()));
	}

	@POST
	@Path("/sumSalOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sumSalOrder", response = Response.class, notes = "统计奶站销售订单数量")
	public Response sumSalOrder(@ApiParam(required=true,name="search",value="日期") SalOrderDaySearch search){
		return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.sumSalOrderByDate(search.getOrderDate()));
	}
}
