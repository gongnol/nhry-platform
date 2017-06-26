package com.nhry.data.auth.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysOrgsMapper;
import com.nhry.data.auth.domain.TSysOrgs;

public class TSysOrgsMapperImpl implements TSysOrgsMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int delSysOrgByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delSysOrgByOrgId", orgId);
	}

	@Override
	public int addSysOrgs(TSysOrgs record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addSysOrgs", record);
	}

	@Override
	public TSysOrgs findSysOrgById(String orgId) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findSysOrgById", orgId);
	}

	@Override
	public int uptSysOrg(TSysOrgs record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptSysOrg", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
