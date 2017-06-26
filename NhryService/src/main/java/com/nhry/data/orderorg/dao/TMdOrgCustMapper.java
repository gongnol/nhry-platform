package com.nhry.data.orderorg.dao;

import com.nhry.data.orderorg.domain.TMdOrgCust;
import com.nhry.data.orderorg.domain.TMdOrgCustKey;

import java.util.List;

public interface TMdOrgCustMapper {
    int deleteByPrimaryKey(TMdOrgCustKey key);

    int insert(TMdOrgCust record);

    int insertSelective(TMdOrgCust record);

    TMdOrgCust selectByPrimaryKey(TMdOrgCustKey key);

    int updateByPrimaryKeySelective(TMdOrgCust record);

    int updateByPrimaryKey(TMdOrgCust record);

    List<TMdOrgCust> findTMdOrgCustList(String orgId);
}