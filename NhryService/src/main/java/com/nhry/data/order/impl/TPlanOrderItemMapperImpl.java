package com.nhry.data.order.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.model.order.OrderPointModel;
import com.nhry.service.pi.pojo.MemberActivities;



import java.util.List;
import java.util.Map;

public class TPlanOrderItemMapperImpl implements TPlanOrderItemMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int deleteByEntryItemNo(String itemNo)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteByEntryItemNo", itemNo);
	}
	
	@Override
	public int selectEntriesQtyByOrderCode(String orderCode)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectEntriesQtyByOrderCode", orderCode);
	}
	
	@Override
	public List<TPlanOrderItem> selectByOrderCode(String orderCode)
	{
		return sqlSessionTemplate.selectList("selectEntriesByOrderCode", orderCode);
	}
	
	@Override
	public int insert(TPlanOrderItem record)
	{
		return sqlSessionTemplate.insert("insertNewOrderEntry", record);
	}
	
	@Override
	public int updateEntryByItemNo(TPlanOrderItem record)
	{
		return sqlSessionTemplate.update("updateEntryByOrderCode", record);
	}

	@Override
	public List<TPlanOrderItem> selectEntriesByOrderNo(Map<String, String> map) {
		return sqlSessionTemplate.selectList("selectEntriesByOrderNo",map);
	}

	@Override

	public int uptYfrechAndYGrowthByOrderNoAndItemNo(OrderPointModel model) {
		return sqlSessionTemplate.update("uptYfrechAndYGrowthByOrderNoAndItemNo",model);
	}

	@Override
	public OrderPointModel getSumYfrechAndYGrowByOrderNo(String orderNo) {
		return sqlSessionTemplate.selectOne("getSumYfrechAndYGrowByOrderNo",orderNo);
	}

	@Override
	public List<MemberActivities> selectBeforePayActivitiesByOrderNo(Map<String, String> planOrderMap) {
		return sqlSessionTemplate.selectList("selectBeforePayActivitiesByOrderNo", planOrderMap);
	}

	@Override
	public List<MemberActivities> selectAfterPayActivitiesByOrderNo(Map<String, String> planOrderMap) {
		return sqlSessionTemplate.selectList("selectAfterPayActivitiesByOrderNo", planOrderMap);
	}

	@Override
	public int deleteByOrderNo(String orderNo) {
		return sqlSessionTemplate.delete("deleteByOrderNo", orderNo);
	}

	@Override
	public List<TPlanOrderItem> selectPlanOrderItemByOrderNo(String orderNo) {
		return sqlSessionTemplate.selectList("selectPlanOrderItemByOrderNo",orderNo);
	}
	@Override
	public List<TPlanOrderItem> selectDetailByOrderCode(String orderNo) {
		return sqlSessionTemplate.selectList("selectDetailByOrderCode",orderNo);
	}

	@Override
	public TPlanOrderItem selectEntryByEntryNo(String code)
	{
		return sqlSessionTemplate.selectOne("selectEntryByEntryNo", code);
	}
	
	@Override
	public int insertSelective(TPlanOrderItem record)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public TPlanOrderItem selectByPrimaryKey(String itemNo)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateByPrimaryKeySelective(TPlanOrderItem record)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateByPrimaryKey(TPlanOrderItem record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String findMinOrderStartDateByOrderNo(String orderNo) {
		return sqlSessionTemplate.selectOne("findMinOrderStartDateByOrderNo", orderNo);
	}

	@Override
	public String findMaxOrderEndDateByOrderNo(String orderNo) {
		return sqlSessionTemplate.selectOne("findMaxOrderEndDateByOrderNo", orderNo);
	}
	
	
}
