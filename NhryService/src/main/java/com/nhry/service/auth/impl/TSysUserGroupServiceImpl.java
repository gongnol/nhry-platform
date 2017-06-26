package com.nhry.service.auth.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserGroupMapper;
import com.nhry.data.auth.domain.TSysUserGroup;
import com.nhry.service.BaseService;
import com.nhry.service.auth.dao.TSysUserGroupService;
import com.nhry.utils.PrimaryKeyUtils;

public class TSysUserGroupServiceImpl extends BaseService implements TSysUserGroupService {
    private TSysUserGroupMapper ugMapper;
    
	@Override
	public int deleteUserGroupById(String id) {
		// TODO Auto-generated method stub
		TSysUserGroup ug = ugMapper.findUserGroupById(id);
		if(ug == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该对象在不存在，请核查传入的参数!");
		}
		
		return ugMapper.deleteUserGroupById(id);
	}

	@Override
	public int addUserGroup(TSysUserGroup record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getGroupName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "groupName属性不能为空!");
		}
		record.setId(PrimaryKeyUtils.generateUuidKey());
		return ugMapper.addUserGroup(record);
	}

	@Override
	public TSysUserGroup findUserGroupById(String id) {
		// TODO Auto-generated method stub
		return ugMapper.findUserGroupById(id);
	}

	@Override
	public int updateUserGroupById(TSysUserGroup record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getId()) || StringUtils.isEmpty(record.getGroupName())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "id、groupName属性不能为空!");
		}
		TSysUserGroup ug = ugMapper.findUserGroupById(record.getId());
		if(ug == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "该对象在不存在，请核查传入的参数!");
		}
		return ugMapper.updateUserGroupById(record);
	}

	public void setUgMapper(TSysUserGroupMapper ugMapper) {
		this.ugMapper = ugMapper;
	}

	@Override
	public List<TSysUserGroup> findAllUserGroups() {
		// TODO Auto-generated method stub
		return this.ugMapper.findAllUserGroups();
	}
}
