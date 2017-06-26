package com.nhry.data.auth.impl;

import java.util.List;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.auth.dao.TSysUserGroupMapper;
import com.nhry.data.auth.domain.TSysUserGroup;

public class TSysUserGroupMapperImpl implements TSysUserGroupMapper {
	
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteUserGroupById(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteUserGroupById",id);
	}

	@Override
	public int addUserGroup(TSysUserGroup record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addUserGroup",record);
	}

	@Override
	public TSysUserGroup findUserGroupById(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findUserGroupById", id);
	}

	@Override
	public int updateUserGroupById(TSysUserGroup record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateUserGroupById", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TSysUserGroup> findAllUserGroups() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("findAllUserGroups");
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
