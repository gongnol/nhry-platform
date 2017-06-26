package com.nhry.data.stud.dao;

import java.util.List;
import java.util.Map;

import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.data.stud.domain.TMstOrderStudItem;

public interface TMstOrderStudItemMapper {
	
    int insertSdutOrderItem(TMstOrderStudItem orderStudItem);

    TMstOrderStudItem selectByMid(String mid);

    List<TMstOrderStudItem> findOrderItemByOrderId(Map<String, Object> parameterMap);
    List<TMstOrderStudItem> findOrderItemByOrderIdUnpack(Map<String, Object> parameterMap);
    
    List<TMstOrderStudItem> findOrderItemByMap(Map<String, Object> parameterMap);
    
    List<TMstOrderStudItem> findOrderItemByMapWithBatch(Map<String, Object> parameterMap);

//	int deleteOrderAndItem(Map<String, Object> delMap);

	//批量删除（逻辑删除）
	//单独生成的订奶订单不能被批量删除
	//已发送ERP的订奶订单不能批量删除
	int deleteOrderWithBatch(Map<String, Object> delMap);

	String findSumBySelective(TMstOrderStud obj);

	String findLossSumBySelective(TMstOrderStud obj);

	List<TMstOrderStud> findClassOrderItemByOrderStud(TMstOrderStud item);

	int insertSdutOrderItemUnpack(TMstOrderStudItem item);
	
	int insertSdutOrderItemFill(TMstOrderStudItem item);

	int deleteOrderItemByOrderIdUnpack(String orderId);
	
	int deleteOrderItemByOrderIdFill(String orderId);

	List<TMstOrderStudItem> findOrderItemByMapUnpack(Map<String, Object> selectMap);
	
	List<TMstOrderStudItem> findOrderItemByMapFill(Map<String, Object> selectMap);

	String findSumBySelectiveUnpack(TMstOrderStud obj);

	String findLossSumBySelectiveUnpack(TMstOrderStud obj);

	List<TMstOrderStudItem> findOrderItemUnpackByMapWithBatch(Map<String, Object> selectMap);

	int deleteOrderItemByOrderId(String orderId);
	
	int findMatnrCountByMap(String sourceType, String matnr, String startOrderDateStr, String endOrderDateStr, String schoolCode, String salesOrg);

	String findSumBySelectiveFill(TMstOrderStud obj);

	String findLossSumBySelectiveFill(TMstOrderStud obj);
	
}