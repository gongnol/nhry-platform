package com.nhry.data.order.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.order.dao.TOrderDaliyPlanItemBackMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItemBack;

/**
 * Created by gongjk on 2016/12/12.
 */
public class TOrderDaliyPlanItemBackMapperImpl implements TOrderDaliyPlanItemBackMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertNewItem(TOrderDaliyPlanItemBack back) {
        return sqlSessionTemplate.insert("insertNewItem",back);
    }


}
