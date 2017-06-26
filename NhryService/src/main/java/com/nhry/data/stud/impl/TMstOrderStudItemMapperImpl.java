package com.nhry.data.stud.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMstOrderStudItemMapper;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.data.stud.domain.TMstOrderStudItem;

/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public class TMstOrderStudItemMapperImpl implements TMstOrderStudItemMapper {

	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertSdutOrderItem(TMstOrderStudItem orderStudItem) {
		return sqlSessionTemplate.insert("insertSdutOrderItem", orderStudItem);
	}

	@Override
	public TMstOrderStudItem selectByMid(String mid) {
		return sqlSessionTemplate.selectOne("selectByMid", mid);
	}

	@Override
	public List<TMstOrderStudItem> findOrderItemByOrderId(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByOrderId", parameterMap);
	}
	

	@Override
	public List<TMstOrderStudItem> findOrderItemByOrderIdUnpack(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByOrderIdUnpack", parameterMap);
	}

	@Override
	public List<TMstOrderStudItem> findOrderItemByMap(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByMap", parameterMap);
	}
	
	@Override
	public List<TMstOrderStudItem> findOrderItemByMapUnpack(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByMapUnpack", parameterMap);
	}
	
	@Override
	public List<TMstOrderStudItem> findOrderItemByMapFill(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByMapFill", parameterMap);
	}

	@Override
	public List<TMstOrderStudItem> findOrderItemByMapWithBatch(Map<String, Object> parameterMap) {
		return sqlSessionTemplate.selectList("findOrderItemByMapWithBatch", parameterMap);
	}

//	@Override
//	public int deleteOrderAndItem(Map<String, Object> delMap) {
//		return sqlSessionTemplate.update("deleteOrderAndItem", delMap);
//	}

	@Override
	public int deleteOrderWithBatch(Map<String, Object> delMap) {
		return sqlSessionTemplate.update("deleteOrderWithBatch", delMap);
	}

	@Override
	public String findSumBySelective(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findSumBySelective", obj);
	}

	@Override
	public String findLossSumBySelective(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findLossSumBySelective", obj);
	}

	@Override
	public List<TMstOrderStud> findClassOrderItemByOrderStud(TMstOrderStud item) {
		return sqlSessionTemplate.selectList("findClassOrderItemByOrderStud", item);
	}

	@Override
	public int insertSdutOrderItemUnpack(TMstOrderStudItem item) {
		return sqlSessionTemplate.insert("insertSdutOrderItemUnpack", item);
	}
	
	@Override
	public int insertSdutOrderItemFill(TMstOrderStudItem item) {
		return sqlSessionTemplate.insert("insertSdutOrderItemFill", item);
	}

	@Override
	public int deleteOrderItemByOrderIdUnpack(String orderId) {
		return sqlSessionTemplate.delete("deleteOrderItemByOrderIdUnpack", orderId);
	}
	
	@Override
	public int deleteOrderItemByOrderIdFill(String orderId) {
		return sqlSessionTemplate.delete("deleteOrderItemByOrderIdFill", orderId);
	}

	@Override
	public String findSumBySelectiveUnpack(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findSumBySelectiveUnpack", obj);
	}
	
	@Override
	public String findSumBySelectiveFill(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findSumBySelectiveFill", obj);
	}

	@Override
	public String findLossSumBySelectiveUnpack(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findLossSumBySelectiveUnpack", obj);
	}
	
	@Override
	public String findLossSumBySelectiveFill(TMstOrderStud obj) {
		return sqlSessionTemplate.selectOne("findLossSumBySelectiveFill", obj);
	}

	@Override
	public List<TMstOrderStudItem> findOrderItemUnpackByMapWithBatch(Map<String, Object> selectMap) {
		return sqlSessionTemplate.selectList("findOrderItemUnpackByMapWithBatch", selectMap);
	}

	@Override
	public int deleteOrderItemByOrderId(String orderId) {
		return sqlSessionTemplate.delete("deleteOrderItemByOrderId", orderId);
	}

	@Override
	public int findMatnrCountByMap(String sourceType, String matnr,
			String startOrderDateStr, String endOrderDateStr, String schoolCode, String salesOrg) {
		Map<String, String> selectMap = new HashMap<String, String>();
		selectMap.put("sourceType", sourceType);
		selectMap.put("matnr", matnr);
		selectMap.put("startOrderDateStr", startOrderDateStr);
		selectMap.put("endOrderDateStr", endOrderDateStr);
		selectMap.put("schoolCode", schoolCode);
		selectMap.put("salesOrg", salesOrg);
		Integer result = sqlSessionTemplate.selectOne("findMatnrCountByMap", selectMap);
		return null==result?0:result;
	}

}
