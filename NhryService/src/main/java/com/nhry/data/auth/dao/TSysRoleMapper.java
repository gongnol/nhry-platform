package com.nhry.data.auth.dao;

import java.util.List;

import com.nhry.data.auth.domain.TSysRole;
import com.nhry.service.auth.pojo.UserRoles;

public interface TSysRoleMapper {
    int deleteRoleByRid(String id);

    int addRole(TSysRole record);

    TSysRole findRoleByRid(String id);

    int updateRoleByRid(TSysRole record);
    
    List<TSysRole> getAllRoles();
    
    /**
     * 根据用户名获取用户角色资源
     * @param uname
     * @return
     */
    public List<UserRoles> getUserRoles(String uname);
}