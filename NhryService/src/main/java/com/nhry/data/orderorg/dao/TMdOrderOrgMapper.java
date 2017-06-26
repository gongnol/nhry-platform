package com.nhry.data.orderorg.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.orderorg.domain.TMdOrderOrg;
import com.nhry.model.basic.OrderOrgModel;

import java.util.List;

public interface TMdOrderOrgMapper {
    int deleteOrderOrgByPrimaryKey(String id);

    int insertOrderOrg(TMdOrderOrg record);

    int insertOrderOrgSelective(TMdOrderOrg record);

    TMdOrderOrg selectOrderOrgByPrimaryKey(String id);

    int updateOrderOrgByPrimaryKeySelective(TMdOrderOrg record);

    int updateOrderOrgByPrimaryKey(TMdOrderOrg record);

    PageInfo findTMdOrderOrgList(OrderOrgModel smodel);

    TMdOrderOrg findTMdOrderOrgByOrgCode(OrderOrgModel smodel);

    List<TMdOrderOrg> findOrderOrgListForSelect(String salesOrg);

    TMdOrderOrg selectOrgByCustId(String custId);
}