package com.nhry.data.orderorg.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.orderorg.dao.TMdOrgCustMapper;
import com.nhry.data.orderorg.domain.TMdOrgCust;
import com.nhry.data.orderorg.domain.TMdOrgCustKey;

import java.util.List;

/**
 * Created by huaguan on 2016/12/7.
 */
public class TMdOrgCustMapperImpl implements TMdOrgCustMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteByPrimaryKey(TMdOrgCustKey key) {
        return sqlSessionTemplate.delete("deleteOrgCustByKey",key);
    }

    @Override
    public int insert(TMdOrgCust record) {
        return sqlSessionTemplate.insert("insertOrgCust",record);
    }

    @Override
    public int insertSelective(TMdOrgCust record) {
        return 0;
    }

    @Override
    public TMdOrgCust selectByPrimaryKey(TMdOrgCustKey key) {
        return null;
    }

    @Override
    public List<TMdOrgCust> findTMdOrgCustList(String orgId) {
        return sqlSessionTemplate.selectList("findTMdOrgCustList",orgId);
    }

    @Override
    public int updateByPrimaryKeySelective(TMdOrgCust record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TMdOrgCust record) {
        return 0;
    }
}
