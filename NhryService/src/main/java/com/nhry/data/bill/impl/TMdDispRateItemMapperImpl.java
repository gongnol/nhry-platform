package com.nhry.data.bill.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.TMdDispRateItemMapper;
import com.nhry.data.bill.domain.TMdDispRateItem;

import java.util.List;

/**
 * Created by gongjk on 2016/7/4.
 */
public class TMdDispRateItemMapperImpl implements TMdDispRateItemMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<TMdDispRateItem> getDispRateNumBySalOrg(String salesOrg) {
        return sqlSessionTemplate.selectList("getDispRateNumBySalOrg",salesOrg);
    }

    @Override
    public int delDispRateNumBySaleOrg(String salesOrg) {
        return sqlSessionTemplate.delete("delDispRateNumBySaleOrg",salesOrg);
    }

    @Override
    public int addDispRateItem(TMdDispRateItem item) {
        return sqlSessionTemplate.insert("addDispRateItem",item);
    }
}
