package com.nhry.data.order.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.promotion.domain.PromotionScopeItem;
import com.nhry.model.bill.CustBatchBillQueryModel;
import com.nhry.model.bill.CustBillQueryModel;
import com.nhry.model.order.ManHandOrderSearchModel;
import com.nhry.model.order.OrderPointModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.UpdateManHandOrderModel;
import com.nhry.service.order.pojo.OrderRemainData;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
public class TPreOrderMapperImpl implements TPreOrderMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public TPreOrder selectLastOrder(String vipNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectLastestOrder",vipNo);
	}
	
	@Override
	public int updateOrderResumed(String orderNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateOrderResumed",orderNo);
	}
	
	@Override
	public PageInfo selectOrdersByPages(OrderSearchModel smodel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("searchOrders",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}
	
	@Override
	public int updateOrderStatus(TPreOrder record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateOrderStatus", record);
	}
	
	@Override
	public int updateOrderEmpNo(TPreOrder record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateOrderEmpNo", record);
	}

	@Override
	public PageInfo searchReturnOrders(ManHandOrderSearchModel manHandModel) {
		return sqlSessionTemplate.selectListByPages("searchReturnOrders",manHandModel, Integer.parseInt(manHandModel.getPageNum()), Integer.parseInt(manHandModel.getPageSize()));
	}

	@Override
	public PageInfo searchPendingConfirmUnOnline(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchPendingConfirmUnOnline",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public PageInfo searchPendingConfirmOnline(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchPendingConfirmOnline",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public List<TPreOrder> selectBackOrderByBackDate(TPreOrder order) {
		return sqlSessionTemplate.selectList("selectBackOrderByBackDate", order);
	}

	@Override
	public List<TPreOrder> selectOrdersByOrderNos(ArrayList<String> orders) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orders",orders);
		return sqlSessionTemplate.selectList("selectOrdersByOrderNos",map);
	}

	@Override
	public int updateBySelective(TPreOrder order) {
		return sqlSessionTemplate.update("updateBySelective",order);
	}


	@Override
	public TPreOrder manHandOrderDetail(String orderNo) {
		return sqlSessionTemplate.selectOne("manHandOrderDetail", orderNo);
	}


	@Override
	public int uptManHandOrder(UpdateManHandOrderModel uptManHandModel) {
		return sqlSessionTemplate.update("uptManHandOrder", uptManHandModel);
	}

	@Override
	public int returnOrder(UpdateManHandOrderModel uptManHandModel) {
		return sqlSessionTemplate.update("returnOrder", uptManHandModel);
	}

	@Override
	public int orderUnsubscribe(String orderNo) {
		return sqlSessionTemplate.update("orderUnsubscribe", orderNo);
	}

	@Override
	public PageInfo searchCustomerOrder(CustBillQueryModel cModel) {
		return sqlSessionTemplate.selectListByPages("searchCustomerOrder",cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));

	}

	@Override
	public PageInfo searchCustomerOrderForRecBill(CustBillQueryModel cModel) {
		return sqlSessionTemplate.selectListByPages("searchCustomerOrderForRecBill",cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));

	}



	@Override
	public int updateOrderPayMentStatus(String orderNo) {
		return sqlSessionTemplate.update("updateOrderPayMentStatus", orderNo);

	}

	@Override
	public int insert(TPreOrder record)
	{
		return sqlSessionTemplate.insert("insertNewOrder", record);
	}
	
	@Override
	public TPreOrder selectByPrimaryKey(String orderNo)
	{
		return sqlSessionTemplate.selectOne("selectByOrderCode", orderNo);
	}
	
	@Override
	public int updateOrderEndDate(TPreOrder record)
	{
		return sqlSessionTemplate.update("updateOrderEndDate", record);
	}
	
	@Override
	public List<TPreOrder> selectDispNoByGroup(String branchNo)
	{
		return sqlSessionTemplate.selectList("selectDispNoByGroup",branchNo);
	}

	@Override
	public List<TPreOrder> selectDispNoByGroup2(String branchNo,Date dispDate)
	{
		Map<String,Object> groupMap = new HashMap<String,Object>();
		groupMap.put("branchNo",branchNo);
		groupMap.put("dispDate",dispDate);
		return sqlSessionTemplate.selectList("selectDispNoByGroup2",groupMap);
	}
	@Override
	public int deleteByPrimaryKey(String orderNo)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateOrderInitAmtAndCurAmt(TPreOrder record)
	{
		return sqlSessionTemplate.update("updateOrderInitAmtAndCurAmt",record);
	}
	
	@Override
	public int updateOrderCurAmt(TPreOrder record)
	{
		return sqlSessionTemplate.update("updateOrderCurAmt", record);
	}
	
	@Override
	public int updateOrderCurAmtAndInitAmt(TPreOrder record)
	{
		return sqlSessionTemplate.update("updateOrderCurAmtAndInitAmt", record);
	}
	
	@Override
	public int updateByPrimaryKey(TPreOrder record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderRemainData searchOrderRemainData(String memberNo)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectOrderRemainAndAmt", memberNo);
	}
	
	@Override
	public List<TPreOrder> selectByMilkmemberNo(String memberNo)
	{
		return sqlSessionTemplate.selectList("selectByMilkmemberNo", memberNo);
	}
	
	@Override
	public List<TPreOrder> selectByMilkmemberNoRetOrder(String memberNo)
	{
		return sqlSessionTemplate.selectList("selectByMilkmemberNoRetOrder", memberNo);
	}

	@Override
	public List<TPreOrder> selectNodeletedByMilkmemberNo(TPreOrder order)
	{
		return sqlSessionTemplate.selectList("selectNodeletedByMilkmemberNo", order);
	}

	@Override
	public int updateOrderSolicitor(TPreOrder order)
	{
		return sqlSessionTemplate.update("updateOrderSolicitor", order);
	}

	@Override
	public BigDecimal calculateOrderFactoryAmt(String orderNo) {
		return sqlSessionTemplate.selectOne("calculateOrderFactoryAmt",orderNo);
	}


	@Override
	public int updateOrderFacAmt(BigDecimal factAmt, String orderNo) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("factAmt",factAmt);
		map.put("orderNo",orderNo);
		return sqlSessionTemplate.update("updateOrderFacAmt",map);
	}

	public int selectRequiredOrderNum(OrderSearchModel smodel)
	{
		return sqlSessionTemplate.selectOne("selectRequiredOrderNum",smodel);
	}

	@Override
	public int selectStopOrderNum(OrderSearchModel smodel)
	{
		return sqlSessionTemplate.selectOne("selectStopOrderNum",smodel);
	}
	@Override
	public int searchReturnOrdersNum(OrderSearchModel smodel)
	{
		return sqlSessionTemplate.selectOne("searchReturnOrdersNum",smodel);
	}
	@Override
	public PageInfo selectNeedResumeOrders(OrderSearchModel smodel) {

		return sqlSessionTemplate.selectListByPages("selectNeedResumeOrders",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public PageInfo searchReNeedOrdersByMp(OrderSearchModel smodel){
		return sqlSessionTemplate.selectListByPages("searchReNeedOrdersByMp",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public PageInfo searchOrderByMp(OrderSearchModel smodel){
		return sqlSessionTemplate.selectListByPages("searchOrderByMp",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	/* (non-Javadoc) 
	* @title: selectIniOrders
	* @description: 查找所有期初订单
	* @return 
	* @see com.nhry.data.order.dao.TPreOrderMapper#selectIniOrders() 
	*/
	@Override
	public List<TPreOrder> selectIniOrders(TPreOrder order)
	{
		return sqlSessionTemplate.selectList("selectIniOrders",order);
	}

	@Override
	public List<String> searchCustomerOrderForExp(CustBillQueryModel cModel) {
		return sqlSessionTemplate.selectList("searchCustomerOrderForExp",cModel);
	}

	@Override
	public List<TPreOrder> searchCustomerOrderByEmpNo(CustBatchBillQueryModel model) {
		return sqlSessionTemplate.selectList("searchCustomerOrderByEmpNo",model);
	}

	@Override
	public int uptYfrechAndYGrowthByOrderNo(OrderPointModel model) {
		return sqlSessionTemplate.update("uptYfrechAndYGrowthByOrderNo",model);
	}

	@Override
	public List<TPreOrder> selectCustBatchCollect(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectList("selectCustBatchCollect",smodel);
	}

	@Override
	public BigDecimal calculateAfterOrderFactoryAmt(String orderNo) {
		return sqlSessionTemplate.selectOne("calculateAfterOrderFactoryAmt", orderNo);
	}

	@Override
	public BigDecimal calculateTotalBeforBatch(CustBatchBillQueryModel cModel) {
		return sqlSessionTemplate.selectOne("calculateTotalBeforBatch", cModel);
	}

	@Override
	public int selectUnfinishOrderNum(String vipCustNo) {
		return sqlSessionTemplate.selectOne("selectUnfinishOrderNum",vipCustNo);
	}

	@Override
	public List<String> selectAdvanceOrderNos(CustBillQueryModel cModel) {
		return sqlSessionTemplate.selectList("selectAdvanceOrderNos",cModel);
	}

	@Override
	public List<String> selectAfterOrderNos(CustBillQueryModel cModel) {
		return sqlSessionTemplate.selectList("selectAfterOrderNos",cModel);
	}

	@Override
	public int orderConfirm(UpdateManHandOrderModel uptManHandModel) {
		return sqlSessionTemplate.update("orderConfirm", uptManHandModel);
	}

	@Override
	public List<TPreOrder> selectDispNoByGroupAndOrders(String branchNo, List<String> orderNos) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("branchNo",branchNo);
		map.put("orderNos",orderNos);
		return sqlSessionTemplate.selectList("selectDispNoByGroupAndOrders",map);
	}

	@Override
	public List<TPreOrder> selectDispNoByGroupAndOrders2(String branchNo,Date dispDate,List<String> orderNos) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("branchNo",branchNo);
		map.put("dispDate",dispDate);
		map.put("orderNos",orderNos);
		return sqlSessionTemplate.selectList("selectDispNoByGroupAndOrders2",map);
	}


	/* (non-Javadoc) 
	* @title: replaceOrdersDispmember
	* @description: 替换所有a送奶员的订单为b送奶员
	* @param smodel
	* @return 
	* @see com.nhry.data.order.dao.TPreOrderMapper#replaceOrdersDispmember(com.nhry.model.order.OrderSearchModel) 
	*/
	@Override
	public int replaceOrdersDispmember(OrderSearchModel smodel)
	{
		return sqlSessionTemplate.update("replaceOrdersDispmember", smodel);
	}

	/* (non-Javadoc) 
	* @title: updateOrderToFinish
	* @description: 订单完结
	* @param orderNo
	* @return 
	* @see com.nhry.data.order.dao.TPreOrderMapper#updateOrderToFinish(java.lang.String) 
	*/
	@Override
	public int updateOrderToFinish(String orderNo)
	{
		return sqlSessionTemplate.update("updateOrderToFinish", orderNo);
	}

	/* (non-Javadoc) 
	* @title: selectNumOfdeletedByMilkmemberNo
	* @description: 在订的订单数量
	* @return 
	* @see com.nhry.data.order.dao.TPreOrderMapper#selectNumOfdeletedByMilkmemberNo() 
	*/
	@Override
	public int selectNumOfdeletedByMilkmemberNo(String milkmemberNo)
	{
		return sqlSessionTemplate.selectOne("selectNumOfdeletedByMilkmemberNo",milkmemberNo);
	}

	//发送短信用start
	@Override
	public List<TPreOrder> searchPrePayOrdersForSendMessage(String endDate)
	{
		return sqlSessionTemplate.selectList("searchPrePayOrdersForSendMessage", endDate);
	}
	@Override
	public List<TPreOrder> searchAfPayOrdersForSendMessage(String endDate)
	{
		return sqlSessionTemplate.selectList("searchAfPayOrdersForSendMessage", endDate);
	}
	@Override
	public List<TPreOrder> searchECOrdersForSendMessage(String endDate)
	{
		return sqlSessionTemplate.selectList("searchECOrdersForSendMessage", endDate);
	}
	//发送短信用end

	@Override
	public int selectOrdersNoBillCount(String BranchNo){
		return sqlSessionTemplate.selectOne("selectOrdersNoBillCount", BranchNo);
	}

	@Override
	public int updateOrderCurAmtByOrderAndAmt(Map<String, Object> uptMap)
	{
		return sqlSessionTemplate.update("updateOrderCurAmtByOrderAndAmt", uptMap);
	}

	@Override
	public int uptOrderNoResume(String orderNo)
	{
		return sqlSessionTemplate.update("uptOrderNoResume", orderNo);
	}


	@Override
	public int updateBackOrder(TPreOrder record){return sqlSessionTemplate.update("updateBackOrder", record);}

	@Override
	public List<TPreOrder> selectOrderByResumeOrderNo(String orderNo) {
		if(StringUtils.isBlank(orderNo)){
			return null;
		}
		List<String> list = new ArrayList<String>();
		if(orderNo.contains(",")){
			for(String item : StringUtils.split(orderNo, ",")){
				if(StringUtils.isNotBlank(item)){
					list.add(item);
				}
			}
		}
		else{
			list.add(orderNo);
		}
		return sqlSessionTemplate.selectList("selectOrderByResumeOrderNo", list);
	}
	
	@Override
	public PageInfo<TPreOrder> searchOrderWithConsumer(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchOrderWithConsumer",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}
	
	@Override
	public List<TPreOrder> searchOrderWithConsumerList(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectList("searchOrderWithConsumer", smodel);
	}

	@Override
	public int uptPreOrderStatByOrderNo(String preOrderStat, String orderNo) {
		Map<String, String> uptMap = new HashMap<String, String>();
		uptMap.put("preOrderStat", preOrderStat);
		uptMap.put("orderNo", orderNo);
		return sqlSessionTemplate.update("uptPreOrderStatByOrderNo", uptMap);
	}

	@Override
	public List<TPreOrder> selectOrderByPromNo(String promNo) {
		return sqlSessionTemplate.selectList("selectOrderByPromNo", promNo);
	}

	@Override
	public List<TPreOrder> selectOrderByPromScope(PromotionScopeItem scope) {
		return sqlSessionTemplate.selectList("selectOrderByPromScope", scope);

	}
}
