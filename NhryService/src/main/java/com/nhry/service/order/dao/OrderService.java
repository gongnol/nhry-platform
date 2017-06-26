package com.nhry.service.order.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.data.order.domain.TMstYearCardCompOrder;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.milk.RouteDetailUpdateModel;
import com.nhry.model.order.*;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.service.order.pojo.OrderRemainData;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService {
	List editOrderForLongForViewPlans(OrderEditModel record);

	/**
	 * 查询该用户上一张订单的送奶员和订单号
	 * @param vipNo 订户编号
	 * @return
     */
	TPreOrder selectLatestOrder(String vipNo);
	
	List<TOrderDaliyPlanItem> searchDaliyPlansByStatus(String orderNo, String status1,String status2,String status3);


	/**
	 * 导出需要续订的订单信息列表  LIUYIN
	 * @param smodel
	 * @return   1/2
	 */
	String  exportNeedResumeOrders(OrderSearchModel smodel);


	/**
	 * 查询需要续订的订单信息列表
	 * @param smodel
	 * @return  待续订的订单信息分页列表
     */
	PageInfo searchNeedResumeOrders(OrderSearchModel smodel);

	/**
	 * 通过电话号码查询需要续订的订单信息列表
	 * @param smodel
	 * @return
     */
	PageInfo searchReNeedOrdersByMp(OrderSearchModel smodel);

	PageInfo searchOrderByMp(OrderSearchModel smodel);
	
	PageInfo searchOrders(OrderSearchModel smodel);

	/**
	 * 订奶计划列表
	 * @return  日订单分页列表
	 */
	PageInfo searchDaliyOrders(OrderSearchModel smodel);
	
	OrderSearchModel calculateContinueOrder(OrderSearchModel record);

	String createOrder(OrderCreateModel record);

	String createOrders(List<OrderCreateModel> record);

	int editOrderForLong(OrderEditModel record);
	/**
	 * 订奶计划修改  停订、修改产品、数量、配送时间
	 * @param record
	 * @return
	 */
	int editOrderForShort(DaliyPlanEditModel record);

	int batchStopOrderForTime(OrderSearchModel record);
	
	int stopOrderForTime(OrderSearchModel record);
	
	int stopOrderInTime(OrderSearchModel record);

	int backOrder(OrderSearchModel record);

	int batchContinueOrder(OrderSearchModel record);
	
	int continueOrderAuto(OrderSearchModel record);
	
	int continueOrder(OrderSearchModel record);
	
	int batchContinueOrdeAfterStop(OrderSearchModel record);
	
	int continueOrdeAfterStop(OrderSearchModel record);

	int modifyOrderStatus(TPreOrder record);

	/**
	 * 根据订单编号 获取订单信息  订单查看
	 * @param orderCode
	 * @return
     */
	OrderCreateModel selectOrderByCode(String orderCode);

	PageInfo searchReturnOrders(ManHandOrderSearchModel manHandModel);

	TPreOrder manHandOrderDetail(String orderCode);

	int uptManHandOrder(UpdateManHandOrderModel uptManHandModel);

	int returnOrder(UpdateManHandOrderModel uptManHandModel);

	int orderConfirm(UpdateManHandOrderModel uptManHandModel);

	int batchorderConfirm(UpdateManHandOrderModel uptManHandModel);

	int canOrderUnsubscribe(String orderNo);

	List<TOrderDaliyPlanItem> selectDaliyPlansByOrderNo(String orderCode);
	
	void resumeDaliyPlanForRouteOrder(BigDecimal confirmQty,TDispOrderItem entry,TPlanOrderItem orgEntry,Date dispDate);

	void resumeDaliyPlanForRouteOrder2(BigDecimal confirmQty, TDispOrderItem e, TPlanOrderItem entry, Date dispDate);

	List<TOrderDaliyPlanItem> createDaliyPlan(TPreOrder order ,List<TPlanOrderItem> entries);
	
	OrderRemainData searchOrderRemainData(String phone);

	/**
	 * 根据订单编号查询收款信息
	 * @param orderCode
	 * @return  收款表信息
     */
	CollectOrderModel queryCollectByOrderNo(String orderCode);

	TPlanOrderItem calculateAmtAndEndDateForFront(TPlanOrderItem item);
	
	TPlanOrderItem calculateTotalQtyForFront(TPlanOrderItem item);
	
	int updateOrderAndEntriesDispStartDate(String orderNo,List<TPlanOrderItem> entries);

	/**
	 * 该组织下待确认的订单 数量
	 * @return
     */
   int selectRequiredOrderNum();

	/**
	 * 该组织下还有7天就到期没续订的订单
	 * @return
     */
   int selectStopOrderNum();

	/**
	 * 为导入的订单生成日计划
	 * @param str
	 * @return
     */
   int createDaliyPlansForIniOrders(String str);
   
   int replaceOrdersDispmember(OrderSearchModel record);
   
   List<TOrderDaliyPlanItem> viewDaliyPlans(OrderCreateModel record);

	/**
	 * 订奶计划修改  日订单恢复
	 * @param item
	 * @return
	 */
   int recoverStopDaliyDaliyPlan(TOrderDaliyPlanItem item); 
   
   void returnOrderRemainAmtToAcct(String orderNo,Date dispDate);
   
   void setOrderToFinish(String orderNo,Date dispDate);

	void returnOrderRemainAmtToAcct2(TPreOrder order,Date dispDate);

	void setOrderToFinish2(TPreOrder order,Date dispDate);
   
   void reEditDaliyPlansByRouteDetail(RouteDetailUpdateModel newItem , TDispOrderItem orgItem , Date dispDate);

	int selectUnfinishOrderNum(String vipCustNo);

	/**
	 * 该组织下人工分单 数量
	 * @return
	 */
	int searchReturnOrdersNum();

	BigDecimal calPreOrderTotalFactoryPrice(String orderNo);

	void selectOrdersAndSendMessage();

	PageInfo searchPendingConfirmUnOnline(OrderSearchModel smodel);
	PageInfo searchPendingConfirmOnline(OrderSearchModel smodel);

	int orderConfirmUnOnline(UpdateManHandOrderModel uptManHandModel);
	int batchOrderConfirmUnOnline(UpdateManHandOrderModel uptManHandModel);
	int advanceBackOrder(OrderSearchModel record);
	int updateBackState();

	int uptOrderlong(OrderEditModel record);

	/**
	 * 订单编辑中 预览订单日计划
	 * @param record
	 * @return
     */
	List uptOrderlongForViewPlans(OrderEditModel record);
	/**
	 * 订单编辑中 预览订单日计划  优化
	 * @param record
	 * @return
	 */
	List uptOrderlongForViewPlans2(OrderEditModel record);
	int backUnBranchOrder(UpdateManHandOrderModel smodel);

	int continueOrdeAfterStop2(OrderSearchModel record);

	int uptDispDateProm(DaliyPlanEditModel record);

	int daliyBackAmt(DaliyPlanEditModel record);

	int yearCardBackOrder(YearCardBackModel smodel);

	int advanceYearCardBackOrder(YearCardBackModel smodel);

	List<TMstYearCardCompOrder> selectYearCardCompensateList(ExtendBranchInfoModel model);

	int orderNoResume(OrderSearchModel smodel);

	TPreOrder selectByPrimaryKey(String orderNo);

	int replaceOrderBranch(OrderNoAndDispDateModel smodel);
	
	List<TPreOrder> selectOrderByResumeOrderNo(String orderNo);

	PageInfo<TPreOrder> searchOrderWithConsumer(OrderSearchModel smodel);
	
	String searchOrderWithConsumerExport(OrderSearchModel smodel)  throws Exception;

	String stopOrderAfterExport(String orderNo) throws Exception;

	String createFreeOrder(OrderCreateModel record);
	
	/**
	 * 机构内勤撤回订单(奶站还未确认之前)
	 * @param orderNo
	 * @return
	 */
	int cancelOrderRequire(String orderNo);


	/**
	 * 根据促销编号获取订单
	 * @param promNo
	 * @return
	 */
	List<TPreOrder> selectOrderByPromNo(String promNo);
}
