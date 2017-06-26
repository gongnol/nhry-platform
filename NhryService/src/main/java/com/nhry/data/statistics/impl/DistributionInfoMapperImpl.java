package com.nhry.data.statistics.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.statistics.dao.DistributionInfoMapper;
import com.nhry.model.statistics.DistInfoModel;

/**
 * Created by cbz on 7/16/2016.
 */
public class DistributionInfoMapperImpl implements DistributionInfoMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public PageInfo findDistDifferInfo(DistInfoModel model) {
        return sqlSessionTemplate.selectListByPages("findDistDifferInfo", model, Integer.valueOf(model.getPageNum()), Integer.valueOf(model.getPageSize()));
    }
}
