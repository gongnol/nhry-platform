package com.nhry.data.auth.dao;

import com.nhry.data.auth.domain.TSysUserRole;
import com.nhry.model.auth.UserRoleModel;

import java.util.List;

public interface TSysUserRoleMapper {
    int deleteUserRoleByLoginName(TSysUserRole key);

    int addUserRole(TSysUserRole record);

    int updateUserRoleByLoginName(TSysUserRole record);
    
    public TSysUserRole findUserRoleRelations(TSysUserRole record);
    
    public int deleteUserRoles(UserRoleModel urmodel);
    
    public List<TSysUserRole> findUserRoleByRid(String rid);

    /**
     * 获取用户角色关系信息列表
     * @param loginName
     * @return
     */
    List<TSysUserRole> getUserRoleByLoginName(String loginName);
    
    /**
     * 根据用户名获取角色id列表
     * @param loginName
     * @return
     */
    public List<String> getUserRidsByLoginName(String loginName);
}