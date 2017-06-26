package com.nhry.data.order.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.domain.TMstYearCardCompOrder;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TOrderDaliyPlanItemKey;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.milk.MilkQueryModel;
import com.nhry.model.milktrans.RequireOrderSearch;
import com.nhry.model.order.OrderDaliyPlanReportEntityModel;
import com.nhry.model.order.OrderDaliyPlanReportModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.ReturnOrderModel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TOrderDaliyPlanItemMapperImpl implements TOrderDaliyPlanItemMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int updateDaliyPlansToStopDateToDate(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.update("updateDaliyPlansToStopDateToDate", record);
	}
	
	@Override
	public int deletePlansForLongEdit(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.delete("deletePlansForLongEdit", record);
	}
	
	@Override
	public int deleteFromDateToDate(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.delete("deleteFromDateToDate", record);
	}

	@Override
	public int deleteFromDateToDateExceptProm(TOrderDaliyPlanItem record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteFromDateToDateExceptProm", record);
	}

	@Override
	public int selectMaxDaliyPlansNoByOrderNo(String orderNo)
	{
		return sqlSessionTemplate.selectOne("selectMaxDaliyPlansNoByOrderNo", orderNo);
	}
	
	@Override
	public int insert(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.insert("insertNewOrderDaliyPlanEntry", record);
	}
	
	@Override
	public int updateDaliyPlanItemStatus(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.update("updateDaliyPlanItemStatus", record);
	}

	@Override
	public int updateDaliyPlanItemStatusBatch(HashMap map)
	{
		return sqlSessionTemplate.update("updateDaliyPlanItemStatusBatch", map);
	}
	
	@Override
	public int updateDaliyPlanItemRemainAmt(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.update("updateDaliyPlanItemRemainAmt", record);
	}
	
	@Override
	public int updateDaliyPlanItem(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.update("updateDaliyPlanItem", record);
	}

	@Override
	public int updateDaliyPlanItemByItemNo(TOrderDaliyPlanItem record)
	{
		return sqlSessionTemplate.update("updateDaliyPlanItemByItemNo", record);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectDaliyByAfterDayAndNo(TOrderDaliyPlanItem newPlan) {
		return sqlSessionTemplate.selectList("selectDaliyByAfterDayAndNo",newPlan);
	}

	@Override
	public int deleteFromDate(TOrderDaliyPlanItem item) {
		return sqlSessionTemplate.delete("deleteFromDate",item);
	}

	@Override
	public int deleteOneDayItem(TOrderDaliyPlanItem plan) {
		return sqlSessionTemplate.delete("deleteOneDayItem",plan);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectByDayAndNo(TOrderDaliyPlanItem plan) {
		return sqlSessionTemplate.selectList("selectByDayAndNo", plan);
	}

	//查询日期区间内 所有的状态为10的日订单
	@Override
	public List<TOrderDaliyPlanItem> selectByDayAndNoBetweenDays(OrderSearchModel omodel) {
		return sqlSessionTemplate.selectList("selectByDayAndNoBetweenDays", omodel);
	}

	@Override
	public int updateDaliyPlansToStopByStatus(OrderSearchModel omodel) {
		return sqlSessionTemplate.update("updateDaliyPlansToStopByStatus",omodel);
	}

	@Override
	public int updateDaliyReachTimeTypeItemNo(TOrderDaliyPlanItem item) {
		return sqlSessionTemplate.update("updateDaliyReachTimeTypeItemNo",item);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlansByEntryNo(String itemNo)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectDaliyPlansByEntryNo", itemNo);
	}

	//不要改
	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlansByOrderNo(String orderNo)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectDaliyPlansByOrderNo", orderNo);
	}

	//不要改
	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlansByOrderNo2(String orderNo)
	{
		return sqlSessionTemplate.selectList("selectDaliyPlansByOrderNo2", orderNo);
	}
	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlansByOrderNoAsc(String orderNo)
	{
		return sqlSessionTemplate.selectList("selectDaliyPlansByOrderNoAsc", orderNo);
	}
	
	@Override
	public TOrderDaliyPlanItem selectDaliyPlansByEntryNoAndNo(TOrderDaliyPlanItemKey record)
	{
		return sqlSessionTemplate.selectOne("selectDaliyPlansByEntryNoAndNo", record);
	}
	
	@Override
	public int updateDaliyPlansToStop(TPreOrder record)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		record.setStopDateStartStr(format.format(record.getStopDateStart()));
//		if(record.getStopDateEnd()!=null){
//			record.setStopDateEndStr(format.format(record.getStopDateEnd()));
//		}
		return sqlSessionTemplate.update("updateDaliyPlansToStop", record);
	}
	
	@Override
	public int updateDaliyPlansToBack(TPreOrder record)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		record.setStopDateStartStr(format.format(record.getBackDate()));
		return sqlSessionTemplate.update("updateDaliyPlansToStop", record);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlansByBranchAndDay(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectDaliyPlansByBranchAndDay", rModel);
	}

	@Override
	public List<String> getDailOrderPromOfDealerBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("getDailOrderPromOfDealerBranch", rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectProDayPlanOfDealerBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectProDayPlanOfDealerBranch", rModel);
	}

	@Override
	public List<Map<String, Object>> selectProDayPlanOfSelfOrg(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectProDayPlanOfSelfOrg",rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfDealerBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranch", rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectProDayPlanOfDealerBranch40(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectProDayPlanOfDealerBranch40",rModel);
	}

	@Override
	public List<Map<String, Object>> selectNoProDayPlanOfDealerBranch70(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranch70",rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfDealerBranch40(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranch40",rModel);
	}

	@Override
	public List<String> getDailOrderPromOfSelfBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("getDailOrderPromOfSelfBranch", rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfSelfBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfSelfBranch", rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectProDayPlanOfSelfBranch(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectProDayPlanOfSelfBranch", rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfSelfBranch40(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfSelfBranch40",rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> getProductItemsByOrderNo(String orderCode,String salesOrg) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("orderNo",orderCode);
		map.put("salesOrg",salesOrg);
		return sqlSessionTemplate.selectList("getProductItemsByOrderNo", map);
	}

	@Override
	public int deletePlansByOrder(String orderNo) {
		return sqlSessionTemplate.delete("deletePlansByOrder",orderNo);
	}

	@Override
	public int deletePlansWithoutPromDayByOrder(String orderNo) {
		return sqlSessionTemplate.delete("deletePlansWithoutPromDayByOrder",orderNo);
	}

	@Override
	public int deletePromDayDayByOrder(String orderNo) {
		return sqlSessionTemplate.delete("deletePromDayDayByOrder",orderNo);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectPromDaysByNo(String orderCode) {
		return sqlSessionTemplate.selectList("selectPromDaysByNo",orderCode);
	}

	@Override
	public List<Map<String, Object>> selectNoProDayPlanOfDealerBranchAndEmpNo(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranchAndEmpNo",rModel);
	}

	@Override
	public List<Map<String, Object>> selectNoProDayPlanOfSelfBranchAndEmpNo(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfSelfBranchAndEmpNo",rModel);
	}

	@Override
	public BigDecimal sumFinishAmtByPlanOrderNo(String planItemNo) {
		return sqlSessionTemplate.selectOne("sumFinishAmtByPlanOrderNo",planItemNo);
	}

	@Override
	public List<OrderDaliyPlanReportEntityModel> reportOrderDaliyPlanByParams(OrderDaliyPlanReportModel model) {
		return sqlSessionTemplate.selectList("reportOrderDaliyPlanByParams",model);
	}

	@Override
	public BigDecimal getOrderOrderDailyFinishAmtByOrderNo(String orderNo) {
		return sqlSessionTemplate.selectOne("getOrderOrderDailyFinishAmtByOrderNo",orderNo);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectbyDispLineNoByOrderNos(String empNo, String date ,String reachTimeType,String branch, List<String> orderNos) {
		TOrderDaliyPlanItemKey key = new TOrderDaliyPlanItemKey();
		key.setPlanItemNo(date);
		key.setItemNo(empNo);
		key.setOrderNo(reachTimeType);
		key.setTmpBranch(branch);
		key.setOrderNos(orderNos);
		return sqlSessionTemplate.selectList("selectDaliyPlansByDispNo", key);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectDaliyPlanByOrderAndDispDate(String orderNo, Date date) {
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setOrderNo(orderNo);
		item.setDispDate(date);
		return sqlSessionTemplate.selectList("selectDaliyPlanByOrderAndDispDate",item);
	}

	@Override
	public int deleteDailyByStopDate(OrderSearchModel model) {
		return sqlSessionTemplate.delete("deleteDailyByStopDate",model);
	}

	@Override
	public BigDecimal getSumDailyBackAmtByBackDate(OrderSearchModel model) {
		return sqlSessionTemplate.selectOne("getSumDailyBackAmtByBackDate",model);
	}

	@Override
	public Date selectEndDispDate(String itemNo) {
		return sqlSessionTemplate.selectOne("selectEndDispDate",itemNo);
	}

	@Override
	public Date selectFirstDispDateByOrder(String orderNo) {
		return sqlSessionTemplate.selectOne("selectFirstDispDateByOrder",orderNo);
	}

	@Override
	public TMstYearCardCompOrder selectYearCardBackOrder(String orderNo,Date backDate) {
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setOrderNo(orderNo);
		item.setDispDate(backDate);
		return sqlSessionTemplate.selectOne("selectYearCardBackOrder",item);
	}

	@Override
	public int updateDaliyRemainAmtAfterAdvanceBack(String orderNo, BigDecimal backAmt) {
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setOrderNo(orderNo);
		item.setAmt(backAmt);
		return sqlSessionTemplate.update("updateDaliyRemainAmtAfterAdvanceBack",item);
	}

	@Override
	public TOrderDaliyPlanItem selectByDateAndItemNoAndNo(TOrderDaliyPlanItem plan) {
		return sqlSessionTemplate.selectOne("selectByDateAndItemNoAndNo",plan);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectByBeforeDayAndNo(TOrderDaliyPlanItem oplan) {
		return sqlSessionTemplate.selectList("selectByBeforeDayAndNo",oplan);
	}


	/**
	 * 根据订单号和日期获取当前日期的日订单状态
	 * @param orderNo
	 * @param date
	 * @return 日订单状态
	 */
	@Override
	public String getDayOrderStat(String orderNo, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ReturnOrderModel returnOrderModel = new ReturnOrderModel();
		returnOrderModel.setOrderNo(orderNo);
		returnOrderModel.setRetReason(format.format(date));
		List<TOrderDaliyPlanItem> items = sqlSessionTemplate.selectList("getDayOrderStat", returnOrderModel);
		for(TOrderDaliyPlanItem it : items){
			if("20".equals(it.getStatus())){
				return it.getStatus();
			}
		}
		return "10";
	}



	@Override
	public BigDecimal selectDaliyPlansRemainAmt(TOrderDaliyPlanItemKey record)
	{
		return sqlSessionTemplate.selectOne("selectDaliyPlansRemainAmt", record);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectbyDispLineNo(String empNo , String date ,String reachTimeType,String branch)
	{
		TOrderDaliyPlanItemKey key = new TOrderDaliyPlanItemKey();
		key.setPlanItemNo(date);
		key.setItemNo(empNo);
		key.setOrderNo(reachTimeType);
		key.setTmpBranch(branch);
		return sqlSessionTemplate.selectList("selectDaliyPlansByDispNo", key);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectbyDispLineNo2(String empNo , String date ,String reachTimeType,String branch)
	{
		TOrderDaliyPlanItemKey key = new TOrderDaliyPlanItemKey();
		key.setPlanItemNo(date);
		key.setItemNo(empNo);
		key.setOrderNo(reachTimeType);
		key.setTmpBranch(branch);
		return sqlSessionTemplate.selectList("selectDaliyPlansByDispNo2", key);
	}

	@Override
	public int updateByPrimaryKeySelective(TOrderDaliyPlanItem record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFromDateToDate(TOrderDaliyPlanItem record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateFromDateToDate", record);
	}
	
	@Override
	public PageInfo selectDaliyOrdersByPages(OrderSearchModel smodel)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("searchDaliyOrdersByPage",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));	
	}
	
	@Override
	public List<TOrderDaliyPlanItem> selectDaliyOrdersAll(OrderSearchModel smodel)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("searchDaliyOrdersByPage",smodel);	
	}

	@Override
	public List<TOrderDaliyPlanItem> searchDaliyOrdersByOrderNoAndFinalStop(OrderSearchModel smodel)
	{
		return sqlSessionTemplate.selectList("searchDaliyOrdersByOrderNoAndFinalStop", smodel);
	}

	@Override
	public List<TOrderDaliyPlanItem> searchDaliyOrdersByData(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectList("searchDaliyOrdersByData", smodel);
	}

	@Override
	public List<TOrderDaliyPlanItem> searchDaliyPlansByStatus(String orderNo, String status1,String status2,String status3)
	{
		TOrderDaliyPlanItem smodel = new TOrderDaliyPlanItem();
		smodel.setOrderNo(orderNo);
		smodel.setStatus(status1);
		smodel.setCreateBy(status2);
		smodel.setCreateByTxt(status3);
		return sqlSessionTemplate.selectList("searchDaliyPlansByStatus", smodel);
	}

	/* (non-Javadoc) 
	* @title: deletePlansByAmt
	* @description: 
	* @param orderNo
	* @return 
	* @see com.nhry.data.order.dao.TOrderDaliyPlanItemMapper#deletePlansByAmt(java.lang.String) 
	*/
	@Override
	public int deletePlansByAmt(String orderNo)
	{
		return sqlSessionTemplate.delete("deletePlansByAmt",orderNo);
	}
	/**
	 * 查询订单下完结的日订单数量
	 * */
	@Override
	public int selectStatusDailyPlansCounts(String orderNo)
	{
		return sqlSessionTemplate.selectOne("selectStatusDailyPlansCounts",orderNo);
	}

	@Override
	public BigDecimal selectInitAmtDaysByNo(String orderNo) {
		return sqlSessionTemplate.selectOne("selectInitAmtDaysByNo",orderNo);
	}

	@Override
	public BigDecimal selectCurAmtDaysByNo(String orderNo) {
		return sqlSessionTemplate.selectOne("selectCurAmtDaysByNo",orderNo);
	}

	@Override
	public int deleteFromDateByStatus(TOrderDaliyPlanItem newplan) {
		return sqlSessionTemplate.delete("deleteFromDateByStatus",newplan);
	}

	@Override
	public int deleteFromDateByStatusAndProm(TOrderDaliyPlanItem newplan) {
		return sqlSessionTemplate.delete("deleteFromDateByStatusAndProm",newplan);
	}

	@Override
	public TOrderDaliyPlanItem selectDaliyByDispItem(TDispOrderItem entry){
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setItemNo(entry.getOrgItemNo());
		item.setDispDate(entry.getOrderDate());
		item.setReachTimeType(entry.getReachTimeType());
		if("Y".equals(entry.getGiftFlag())){
			item.setPromotionFlag("Y");
		}
		return sqlSessionTemplate.selectOne("selectDaliyByDispItem",item);
	}

	@Override
	public int updateDaliyRemainAmtAfterRouteConfirmBeforDay(Date dispDate, BigDecimal cj, String orderNo) {
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setDispDate(dispDate);
		item.setAmt(cj);
		item.setOrderNo(orderNo);
		return sqlSessionTemplate.update("updateDaliyRemainAmtAfterRouteConfirmBeforDay",item);
	}

	/**
	 *
	 * @param orderNo  订单号
	 * @param itemNo   产品行号
	 * @param startDate  开始日期
	 * @param endDate   截止日期
     * @return
     */
	@Override
	public List<TOrderDaliyPlanItem> selectPromDaliyBetweenDaysAndNo(String orderNo,String itemNo,Date startDate, Date endDate) {
		TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
		item.setOrderDate(startDate);
		item.setItemNo(itemNo);
		item.setOrderNo(orderNo);
		item.setDispDate(endDate);
		return sqlSessionTemplate.selectList("selectPromDaliyBetweenDaysAndNo",item);
	}
	
	@Override
	public List<Map<String, String>> findOrderSumByDate(MilkQueryModel  model) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("findOrderSumByDate", model);
	}
	
	@Override
	public List<Map<String, Object>> selectNoProDayPlanOfSelfBranch10(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfSelfBranch10",rModel);
	}

	@Override
	public List<Map<String, Object>> selectProDayPlanOfSelfBranch10(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectProDayPlanOfSelfBranch10",rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfSelfBranch90(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfSelfBranch90",rModel);
	}

	@Override
	public List<Map<String, Object>> selectNoProDayPlanOfDealerBranch10(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranch10",rModel);
	}

	@Override
	public List<TOrderDaliyPlanItem> selectNoProDayPlanOfDealerBranch90(RequireOrderSearch rModel) {
		return sqlSessionTemplate.selectList("selectNoProDayPlanOfDealerBranch90",rModel);
	}
}
