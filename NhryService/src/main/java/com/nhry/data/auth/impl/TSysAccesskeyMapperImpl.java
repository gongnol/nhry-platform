package com.nhry.data.auth.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysAccesskeyMapper;
import com.nhry.data.auth.domain.TSysAccesskey;

public class TSysAccesskeyMapperImpl implements TSysAccesskeyMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int deleteAccesskeyByAk(TSysAccesskey key) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteAccesskeyByAk", key);
	}

	@Override
	public int addIsysAccessKey(TSysAccesskey record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addIsysAccessKey", record);
	}

	@Override
	public TSysAccesskey findAccesskeyByKey(TSysAccesskey key) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findAccesskeyByKey", key);
	}

	@Override
	public int updateIsysAccessKey(TSysAccesskey record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateIsysAccessKey", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int deleteExpiredAccesskey() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteExpiredAccesskey");
	}
}
