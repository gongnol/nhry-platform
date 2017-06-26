package com.nhry.data.bill.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.TMdDispRateMapper;
import com.nhry.data.bill.domain.TMdDispRate;

/**
 * Created by gongjk on 2016/7/4.
 */
public class TMdDispRateMapperImpl implements TMdDispRateMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public TMdDispRate getDispRateBySaleOrg(String salesOrg) {
        return sqlSessionTemplate.selectOne("getDispRateBySaleOrg",salesOrg);
    }

    @Override
    public int uptDispRateTypeBySaleOrg(TMdDispRate dispRate) {
        return sqlSessionTemplate.update("uptDispRateTypeBySaleOrg",dispRate);
    }

    @Override
    public int addDispRateSalOrg(TMdDispRate dispRate) {
        return sqlSessionTemplate.insert("addDispRateSalOrg", dispRate);
    }
}
