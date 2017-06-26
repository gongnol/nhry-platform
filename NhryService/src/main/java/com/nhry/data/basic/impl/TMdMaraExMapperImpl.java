package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdMaraExMapper;
import com.nhry.data.basic.domain.TMdMaraEx;
import com.nhry.service.basic.pojo.BotType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TMdMaraExMapperImpl implements TMdMaraExMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public int uptProductExByCode(TMdMaraEx record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptProductExByCode", record);
	}

	@Override
	public int addMaraEx(TMdMaraEx record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addMaraEx", record);
	}

	@Override
	public TMdMaraEx getProductTransRateByCode(String matnr, String salesOrg) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("matnr",matnr);
		map.put("salesOrg",salesOrg);

		return this.sqlSessionTemplate.selectOne("getProductTransRateByCode",map);
	}

	@Override
	public int uptProductExByCodeAndSalesOrg(TMdMaraEx ex) {
		return this.sqlSessionTemplate.update("uptProductExByCodeAndSalesOrg", ex);
	}

	@Override
	public List<TMdMaraEx> getProductsBySalesOrg(String salesOrg) {
		return sqlSessionTemplate.selectList("getProductsBySalesOrg",salesOrg);
	}

	public TMdMaraEx findProductExByCode(Map<String,String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findProductExByCode", attrs);
	}

	@Override
	public List<BotType> getMataBotTypes(String salesOrg) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getMataBotTypes", salesOrg);
	}
}
