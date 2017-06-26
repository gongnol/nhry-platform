package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.orderorg.domain.TMdOrderOrg;
import com.nhry.data.orderorg.domain.TMdOrgCust;
import com.nhry.data.orderorg.domain.TMdOrgCustKey;
import com.nhry.model.basic.OrderOrgModel;

import java.util.List;

/**
 * Created by huaguan on 2016/12/1.
 * 机构接口
 */
public interface OrderOrgService {
    /**
     * 根据机构ID删除机构信息
     * @param id
     * @return int
     */
    int deleteOrderOrgByPrimaryKey(String id);

    /**
     * 根据试题插入机构信息
     * @param record
     * @return
     */
    int insertOrderOrg(TMdOrderOrg record);

    /**
     * 根据机构实体（非主键允许为空）插入机构信息
     * @param record
     * @return
     */
    int insertOrderOrgSelective(OrderOrgModel record);

    /**
     * 根据机构ID查询机构信息
     * @param id
     * @return
     */
    TMdOrderOrg selectOrderOrgByPrimaryKey(String id);

    /**
     * 根据机构实体更新机构信息（非主键允许为空）
     * @param record
     * @return
     */
    int updateOrderOrgByPrimaryKeySelective(OrderOrgModel record);

    /**
     * 根据机构实体更新机构信息
     * @param record
     * @return
     */
    int updateOrderOrgByPrimaryKey(OrderOrgModel record);

    /**
     * 根据销售组织查询机构列表，带分页
     * @param
     * @return
     */
    PageInfo findTMdOrderOrgList(OrderOrgModel record);

    /**
     * 根据当前销售组织查询机构名称、机构代码
     * @return
     */
    List<TMdOrderOrg> findOrderOrgListForSelect();
    /**
     * 根据订户编号删除关联机构
     * @param key
     * @return
     */
    int deleteByPrimaryKey(TMdOrgCustKey key);

    /**
     * 新增机构-订户关联关系
     * @param record
     * @return
     */
    int insertOrgCust(TMdOrgCustKey record);

    /**
     * 根据机构ID查询改机构下关联的订户ID
     * @param orgId
     * @return
     */
    List<TMdOrgCust> findTMdOrgCustList(String orgId);

    /**
     * 根据机构CODE，销售组织查询机构信息
     * @param orgCode
     * @return
     */
    TMdOrderOrg findTMdOrderOrgByOrgCode(String orgCode);
}
