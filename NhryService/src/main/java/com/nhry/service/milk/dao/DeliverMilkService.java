package com.nhry.service.milk.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.model.milk.*;
import com.nhry.model.milktrans.*;
import com.nhry.model.order.OrderDaliyPlanReportEntityModel;
import com.nhry.model.order.OrderDaliyPlanReportModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DeliverMilkService {
	int deleteDispOrderByDate(String date);
	
	PageInfo searchRouteOrders(RouteOrderSearchModel smodel);
	
	PageInfo searchRouteOrderDetail(RouteOrderSearchModel smodel);
	
	List searchRouteOrderDetailAll(String code);

	List selectRouteDetailsAllforDeliver(String code);
	
	List searchRouteChangeOrder(String code);
	
	RouteOrderModel searchRouteDetails(String orderNo);

	List<TDispOrderItem> searchRouteDetailsForDeliver(String orderNo);
	
	int updateRouteOrder(RouteUpdateModel record);
	
	int updateRouteOrderAllItems(RouteDetailUpdateListModel record);
	
	int updateRouteOrderItems(RouteDetailUpdateModel record,Map<String,String> productMap);
	public int createInsideSalOrder(String dispOrderNo);
	
	int updateDaliyPlanByRouteOrder(String orderCode);
	
	int createDayRouteOder(String dateStr);
	
	int createRouteChanges();
	
	int updatePreOrderCurAmt(String orderNo , BigDecimal amt);
	
	int createDispOrderdayliy();

	PageInfo getInsideSalOrder(InSideSalOrderSearchModel sModel);

	PageInfo getInsideSalOrderDetail(InSideSalOrderDetailSearchModel sModel);

	int createInsideSalOrderByStock(CreateInSalOrderModel cModel);

	int createInsideSalOrderByTmpStock(CreateInsalOrderByRefuseModel cModel);
	
	int reEditRouteDetail(RouteDetailUpdateModel record);

	int updateInSalOrderAndStockByUpdateDiapOrder(TDispOrderItem newItem , TDispOrderItem orgItem);

	List<DispOrderReportEntityModel> reportDispOrderItemByParams(DispOrderReportModel model);

	List<OrderDaliyPlanReportEntityModel> reportOrderDaliyPlanByParams(OrderDaliyPlanReportModel model);

	int createTemRouteOrders(TemporaryDispOrderModel tModel);

	int updateDaliyPlanByRouteOrder2(String orderCode);


	List<Map<String, String>> findOrderSumByDate(MilkQueryModel  model);
}
