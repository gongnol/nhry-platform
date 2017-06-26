package com.nhry.data.order.dao;

import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.model.order.OrderPointModel;
import com.nhry.service.pi.pojo.MemberActivities;

import java.util.List;
import java.util.Map;

public interface TPlanOrderItemMapper {
    int deleteByEntryItemNo(String itemNo);

    int insert(TPlanOrderItem record);
    
    int selectEntriesQtyByOrderCode(String orderCode);

    int insertSelective(TPlanOrderItem record);

    TPlanOrderItem selectByPrimaryKey(String itemNo);

    int updateByPrimaryKeySelective(TPlanOrderItem record);

    int updateByPrimaryKey(TPlanOrderItem record);

    TPlanOrderItem selectEntryByEntryNo(String code);

    List<TPlanOrderItem> selectByOrderCode(String orderCode);

    int updateEntryByItemNo(TPlanOrderItem record);

    List<TPlanOrderItem> selectEntriesByOrderNo(Map<String, String> map);

    int uptYfrechAndYGrowthByOrderNoAndItemNo(OrderPointModel model);

    OrderPointModel getSumYfrechAndYGrowByOrderNo(String orderNo);

    List<MemberActivities> selectBeforePayActivitiesByOrderNo(Map<String, String> planOrderMap);

    List<MemberActivities> selectAfterPayActivitiesByOrderNo(Map<String, String> planOrderMap);

    int deleteByOrderNo(String orderNo);

    List<TPlanOrderItem> selectPlanOrderItemByOrderNo(String orderNo);

    List<TPlanOrderItem> selectDetailByOrderCode(String orderCode);

	String findMinOrderStartDateByOrderNo(String orderNo);

	String findMaxOrderEndDateByOrderNo(String orderNo);
}