package com.nhry.data.auth.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUserRole;
import com.nhry.model.auth.UserRoleModel;
import com.nhry.service.BaseService;

import java.util.List;

public class TSysUserRoleMapperImpl extends BaseService implements TSysUserRoleMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int deleteUserRoleByLoginName(TSysUserRole key) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteUserRoleByLoginName", key);
	}

	@Override
	public int addUserRole(TSysUserRole record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addUserRole", record);
	}

	@Override
	public int updateUserRoleByLoginName(TSysUserRole record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateUserRoleByLoginName", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public TSysUserRole findUserRoleRelations(TSysUserRole record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findUserRoleRelations",record);
	}

	@Override
	public int deleteUserRoles(UserRoleModel urmodel) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteUserRoles", urmodel);
	}

	@Override
	public List<TSysUserRole> findUserRoleByRid(String rid) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findUserRoleByRid", rid);
	}

	@Override
	public List<TSysUserRole> getUserRoleByLoginName(String loginName) {
		return this.sqlSessionTemplate.selectList("getUserRoleByLoginName", loginName);
	}

	@Override
	public List<String> getUserRidsByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getUserRidsByLoginName", loginName);
	}
}
