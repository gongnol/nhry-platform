package com.nhry.rest.milk;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.model.milk.*;
import com.nhry.rest.BaseResource;
import com.nhry.service.milk.dao.DeliverMilkService;
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
import java.util.List;

@Path("/deliverMilk")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/deliverMilk", description = "送奶信息维护")
public class DeliverMilkResource extends BaseResource {
	@Autowired
	private DeliverMilkService deliverMilkService;
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search", response = PageInfo.class, notes = "查询路单信息列表")
	public Response findRouteOrders(@ApiParam(required=true,name="smodel",value="SearchModel") RouteOrderSearchModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.searchRouteOrders(smodel));
	}
	
	@POST
	@Path("/searchDetailsByPage")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchDetailsByPage", response = PageInfo.class, notes = "查询路单详细信息列表分页")
	public Response searchDetailsByPage(@ApiParam(required=true,name="smodel",value="SearchModel") RouteOrderSearchModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.searchRouteOrderDetail(smodel));
	}
	
	@GET
	@Path("/searchDetails/{orderCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{orderCode}", response = List.class, notes = "查询路单详细信息列表")
	public Response findRouteOrderDetails(@ApiParam(required=true,name="orderCode",value="路单编号") @PathParam("orderCode") String orderCode){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.searchRouteOrderDetailAll(orderCode));
	}
	
	
	
	@POST
	@Path("/findOrderSumByDate")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findOrderSumByDate", response = List.class, notes = "根据时间获取登录订奶员日计划汇总数量")
	public Response findOrderSumByDate(@ApiParam(required=true,name="milkQueryModel",value="model")MilkQueryModel  model){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.findOrderSumByDate(model));
	}
	
	@GET
	@Path("/{orderCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{orderCode}", response = RouteOrderModel.class, notes = "根据路单编号查询路单详细信息")
	public Response selectRouteOrderByCode(@ApiParam(required=true,name="orderCode",value="路单编号") @PathParam("orderCode") String orderCode){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.searchRouteDetails(orderCode));
	}
	
	@POST
	@Path("/uptRouteOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptRouteOrder", response = Integer.class, notes = "更新路单状态")
	public Response uptRouteOrder(@ApiParam(required=true,name="smodel",value="SearchModel") RouteUpdateModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.updateRouteOrder(smodel));
	}
	
	@GET
	@Path("/createRouteOrders/{dateStr}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createRouteOrders/{dateStr}", response = Integer.class, notes = "生成路单")
	public Response createRouteOrders(@ApiParam(required=true,name="dateStr",value="日期编号") @PathParam("dateStr") String dateStr){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createDayRouteOder(dateStr));
	}

	@POST
	@Path("/createTemRouteOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createTemRouteOrders", response = Integer.class, notes = "生成临时路单")
	public Response createTemRouteOrders(@ApiParam(required=true,name="dateStr",value="日期编号") TemporaryDispOrderModel tModel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createTemRouteOrders(tModel));
	}
	
	@GET
	@Path("/deleteRouteOrders/{dateStr}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/deleteRouteOrders/{dateStr}", response = Integer.class, notes = "删除路单")
	public Response deleteRouteOrders(@ApiParam(required=true,name="dateStr",value="日期编号") @PathParam("dateStr") String dateStr){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.deleteDispOrderByDate(dateStr));
	}
	
	@GET
	@Path("/createRouteChanges")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createRouteChanges", response = Integer.class, notes = "生成路单变化单")
	public Response createRouteChanges(){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.createRouteChanges());
	}
	
	@GET
	@Path("/changeDaliyPlans/{orderCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/changeDaliyPlans/{orderCode}", response = RouteOrderModel.class, notes = "根据路单更新日计划  路单确认")
	public Response changeDaliyPlans(@ApiParam(required=true,name="orderCode",value="路单编号") @PathParam("orderCode") String orderCode){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.updateDaliyPlanByRouteOrder2(orderCode));
	}
	
	@GET
	@Path("/searchRouteChangeOrder/{orderCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "searchRouteChangeOrder/{orderCode}", response = List.class, notes = "查询变化路单")
	public Response searchRouteChangeOrder(@ApiParam(required=true,name="orderCode",value="路单编号") @PathParam("orderCode") String orderCode){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.searchRouteChangeOrder(orderCode));
	}
	
//	@POST
//	@Path("/uptRouteOrderDetail")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	@ApiOperation(value = "/uptRouteOrder", response = Integer.class, notes = "更新路单状态")
//	public Response uptRouteOrderDetail(@ApiParam(required=true,name="smodel",value="SearchModel") RouteDetailUpdateModel smodel){
//		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.updateRouteOrderItems(smodel));
//	}
	
	@POST
	@Path("/uptRouteOrderDetailList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptRouteOrderDetailList", response = Integer.class, notes = "更新路单列表 路单保存")
	public Response uptRouteOrderDetailList(@ApiParam(required=true,name="smodel",value="SearchModel") RouteDetailUpdateListModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.updateRouteOrderAllItems(smodel));
	}
	
	@POST
	@Path("/reEditRouteDetail")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/reEditRouteDetail", response = Integer.class, notes = "重新修改某路单行项目")
	public Response reEditRouteDetail(@ApiParam(required=true,name="smodel",value="SearchModel") RouteDetailUpdateModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, deliverMilkService.reEditRouteDetail(smodel));
	}
	
	
	
}
