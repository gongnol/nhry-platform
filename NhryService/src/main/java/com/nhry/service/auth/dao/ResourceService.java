package com.nhry.service.auth.dao;

import com.nhry.data.auth.domain.TSysResource;
import com.nhry.data.auth.domain.TSysRoleResource;
import com.nhry.model.auth.RoleResourceData;

import java.util.List;

public interface ResourceService {
	/**
	 * 根据资源编码删除资源
	 * @param resCode
	 * @return
	 */
	int deleteResByCode(String resCode);
	
	/**
	 * 添加资源
	 * @param record
	 * @return
	 */
    String addRes(TSysResource record);
    
    /**
     * 根据资源编码查看资源详情
     * @param resCode
     * @return
     */
    TSysResource selectResByCode(String resCode);
    
    /**
     * 修改资源
     * @param record
     * @return
     */
    int updateResByCode(TSysResource record);
    
    /**
     * 添加角色资源关系
     * @param record
     * @return
     */
    int addRoleRes(TSysRoleResource record);
    
    /**
     * 批量添加角色资源关系
     * @param records
     * @return
     */
    int addRoleRes(RoleResourceData record);
    
    /**
     * 根据角色id和资源编码删除角色资源关系
     * @param roleId
     * @param resCode
     * @return
     */
    int deleteRoleRes(TSysRoleResource record);

	/**
	 * 批量删除角色资源关系
	 * @param record
	 * @return
     */
	int deleteRoleRes(RoleResourceData record);

	/**
	 * 根据用户编码查询资源信息
	 * @param userId
	 * @return
     */
	List<TSysResource> findRecoureByUserId (String userId);
	
	/**
     * 获取所有的资源
     * @return
     */
    List<TSysResource> getAllResources();
    
    /**
     * 根据角色编号，查询角色拥有的资源
     * @param id
     * @return
     */
    public List<TSysResource> getRoleResources(String id);

    /**
     * 查询当前用户拥有的组件资源列表
     * @param userId
     * @return
     */
    public List<TSysResource> findCurUserComponents();
    
    /**
     * 查询当前用户拥有的页面资源列表
     * @return
     */
    public List<TSysResource> findCurUserPages();
}
