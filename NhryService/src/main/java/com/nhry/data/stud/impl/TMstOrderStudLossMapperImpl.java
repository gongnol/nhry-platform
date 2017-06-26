package com.nhry.data.stud.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMstOrderStudLossMapper;
import com.nhry.data.stud.domain.TMstOrderStudLoss;

/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public class TMstOrderStudLossMapperImpl implements TMstOrderStudLossMapper {

	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertOrderStudLoss(TMstOrderStudLoss orderStudLoss) {
		return sqlSessionTemplate.insert("insertOrderStudLoss", orderStudLoss);
	}

	@Override
	public List<TMstOrderStudLoss> findLossByOrderId(Map<String, Object> selectMap) {
		return sqlSessionTemplate.selectList("findLossByOrderId", selectMap);
	}
	
	@Override
	public List<TMstOrderStudLoss> findLossByOrderIdUnpack(Map<String, Object> selectMap) {
		return sqlSessionTemplate.selectList("findLossByOrderIdUnpack", selectMap);
	}

	@Override
	public List<TMstOrderStudLoss> findLossByOrderIdFill(Map<String, Object> selectMap) {
		return sqlSessionTemplate.selectList("findLossByOrderIdFill", selectMap);
	}
	
	@Override
	public int insertOrderStudLossUnpack(TMstOrderStudLoss orderStudLoss) {
		return sqlSessionTemplate.insert("insertOrderStudLossUnpack", orderStudLoss);
	}
	
	@Override
	public int insertOrderStudLossFill(TMstOrderStudLoss orderStudLoss) {
		return sqlSessionTemplate.insert("insertOrderStudLossFill", orderStudLoss);
	}

	@Override
	public int deleteByOrderIdUnpack(String orderId) {
		return sqlSessionTemplate.delete("deleteByOrderIdUnpack", orderId);
	}
	
	@Override
	public int deleteByOrderIdFill(String orderId) {
		return sqlSessionTemplate.delete("deleteByOrderIdFill", orderId);
	}

	@Override
	public int deleteByOrderId(String orderId) {
		return sqlSessionTemplate.delete("deleteByOrderId", orderId);
	}

}
