package com.nhry.service.auth.dao;

import java.util.List;

import com.nhry.data.auth.domain.TSysRole;
import com.nhry.data.auth.domain.TSysUserRole;
import com.nhry.model.auth.UserRoleModel;

public interface RoleService {
	/**
	 * 根据角色id，删除角色
	 * @param id
	 * @return
	 */
	int deleteRoleByRid(String id);
	
	/**
	 * 添加角色
	 * @param record
	 * @return
	 */
    int addRole(TSysRole record);
    
    /**
     * 根据角色id，查看角色详情
     * @param id
     * @return
     */
    TSysRole findRoleByRid(String id);
    
    /**
     * 获取所有的角色
     * @return
     */
    public List<TSysRole> getAllRoles();
    
    /**
     * 修改角色
     * @param record
     * @return
     */
    int updateRoleByRid(TSysRole record);
    
    /**
     * 给用户添加指定角色
     * @param urmodel
     * @return
     */
    public int assignRoleToUsers(UserRoleModel urmodel);
    
    /**
     * 删除用户角色(支持删除多个角色)
     * @param urmodel
     * @return
     */
    public int deleteUserRoles(UserRoleModel urmodel);
    
}
