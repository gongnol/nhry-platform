package com.nhry.service.auth.dao;

import java.util.List;

import com.nhry.data.auth.domain.TSysUserGroup;

public interface TSysUserGroupService {
	public int deleteUserGroupById(String id);

	public int addUserGroup(TSysUserGroup record) ;

	public TSysUserGroup findUserGroupById(String id);

	public int updateUserGroupById(TSysUserGroup record);
    
	public List<TSysUserGroup> findAllUserGroups();
}
