package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TVipCrmMapper;
import com.nhry.data.basic.domain.TVipCrmInfo;

import java.util.Map;

public class TVipCrmMapperImpl implements TVipCrmMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int addVipCrm(TVipCrmInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addVipCrm",record);
	}

	@Override
	public TVipCrmInfo findVipCrmByNo(String vipCrmNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCrmByNo", vipCrmNo);
	}

	@Override
	public int updateVipCrmByNo(TVipCrmInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateVipCrmByNo", record);
	}

	@Override
	public TVipCrmInfo findVipCrmByNoForUpt(String vipCrmNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCrmByNoForUpt", vipCrmNo);
	}

	@Override
	public TVipCrmInfo findVipCrmOnlyByNo(String vipCrmNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCrmOnlyByNo", vipCrmNo);
	}

	@Override
	public int uptCrmStatus(TVipCrmInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptCrmStatus", record);
	}

	@Override
	public String getCrmNoByPhone(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("getCrmNoByPhone", attrs);
	}

	@Override
	public TVipCrmInfo getVipCrm(String vipCustNo) {
		return this.sqlSessionTemplate.selectOne("getVipCrm",vipCustNo);
	}

}
