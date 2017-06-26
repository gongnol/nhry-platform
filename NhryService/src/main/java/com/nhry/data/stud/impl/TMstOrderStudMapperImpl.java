package com.nhry.data.stud.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMstOrderStudMapper;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.stud.OrderStudQueryModel;

public class TMstOrderStudMapperImpl implements TMstOrderStudMapper {
	
	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertOrder(TMstOrderStud mstOrderStud) {
		return sqlSessionTemplate.insert("insertOrder", mstOrderStud);
	}

	@Override
	public TMstOrderStud selectByOrderId(String orderId) {
		return sqlSessionTemplate.selectOne("selectByOrderId", orderId);
	}

	@Override
	public int updateByOrder(TMstOrderStud mstOrderStud) {
		return sqlSessionTemplate.update("updateByOrder", mstOrderStud);
	}

	@Override
	public PageInfo<TMstOrderStud> findOrderPage(OrderStudQueryModel queryModel) {
		return sqlSessionTemplate.selectListByPages("findOrderPage", queryModel, Integer.parseInt(queryModel.getPageNum()), Integer.parseInt(queryModel.getPageSize()));
	}

	@Override
	public TMstOrderStud selectOrderBySchoolCodeAndDateWithOrderStatus10(TMstOrderStud mstOrderStud) {
		return sqlSessionTemplate.selectOne("selectOrderBySchoolCodeAndDateWithOrderStatus10", mstOrderStud);
	}

	@Override
	public List<TMstOrderStud> findMatnrWithOrder(TMstOrderStud selectObj) {
		return sqlSessionTemplate.selectList("findMatnrWithOrder", selectObj);
	}

	@Override
	public List<TMstOrderStud> findSchoolWithOrder(TMstOrderStud selectObj) {
		return sqlSessionTemplate.selectList("findSchoolWithOrder", selectObj);
	}

	@Override
	public List<TMstOrderStud> findMatnrWithOrderUnpack(TMstOrderStud selectObj) {
		return sqlSessionTemplate.selectList("findMatnrWithOrderUnpack", selectObj);
	}
	
	@Override
	public List<TMstOrderStud> findMatnrWithOrderFill(TMstOrderStud selectObj) {
		return sqlSessionTemplate.selectList("findMatnrWithOrderFill", selectObj);
	}

	@Override
	public List<TMstOrderStud> findOrderStudByDateAndSalesOrg(String orderDateStr, String salesOrg) {
		HashMap<String, String> selectMap = new HashMap<String, String>();
		selectMap.put("orderDateStr", orderDateStr);
		selectMap.put("salesOrg", salesOrg);
		return sqlSessionTemplate.selectList("findOrderStudByDateAndSalesOrg", selectMap);
	}

	@Override
	public List<String> findAllSchoolByOrderDateBetwen(String salesOrg,
			String startOrderDateStr, String endOrderDateStr) {
		HashMap<String, String> selectMap = new HashMap<String, String>();
		selectMap.put("salesOrg", salesOrg);
		selectMap.put("startOrderDateStr", startOrderDateStr);
		selectMap.put("endOrderDateStr", endOrderDateStr);
		return sqlSessionTemplate.selectList("findAllSchoolByOrderDateBetwen", selectMap);
	}
	
	

}
