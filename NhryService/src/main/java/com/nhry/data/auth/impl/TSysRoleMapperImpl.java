package com.nhry.data.auth.impl;

import java.util.List;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysRoleMapper;
import com.nhry.data.auth.domain.TSysRole;
import com.nhry.service.auth.pojo.UserRoles;

public class TSysRoleMapperImpl implements TSysRoleMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int deleteRoleByRid(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteRoleByRid", id);
	}

	@Override
	public int addRole(TSysRole record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addRole", record);
	}

	@Override
	public TSysRole findRoleByRid(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findRoleByRid", id);
	}

	@Override
	public int updateRoleByRid(TSysRole record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateRoleByRid", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TSysRole> getAllRoles() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getAllRoles");
	}

	@Override
	public List<UserRoles> getUserRoles(String uname) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getUserRoles", uname);
	}
}
