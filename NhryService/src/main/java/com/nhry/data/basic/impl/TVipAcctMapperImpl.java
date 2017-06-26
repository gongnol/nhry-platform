package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TVipAcctMapper;
import com.nhry.data.basic.domain.TVipAcct;

public class TVipAcctMapperImpl implements TVipAcctMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int addVipAcct(TVipAcct record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addVipAcct", record);
	}

	@Override
	public TVipAcct findVipAcctByCustNo(String custNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipAcctByCustNo", custNo);
	}

	@Override
	public int uptVipAcct(TVipAcct record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptVipAcct", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
