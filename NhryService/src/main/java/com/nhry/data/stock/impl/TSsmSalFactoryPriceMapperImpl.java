package com.nhry.data.stock.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stock.dao.TSsmSalFactoryPriceMapper;
import com.nhry.data.stock.domain.TSsmSalFactoryPrice;
import com.nhry.data.stock.domain.TSsmSalFactoryPriceKey;

/**
 * Created by cbz on 8/24/2016.
 */
public class TSsmSalFactoryPriceMapperImpl implements TSsmSalFactoryPriceMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertFactoryPrice(TSsmSalFactoryPrice record) {
        return sqlSessionTemplate.insert("insertFactoryPrice",record);
    }

    @Override
    public TSsmSalFactoryPrice selectFactoryPrice(TSsmSalFactoryPriceKey key) {
        return sqlSessionTemplate.selectOne("selectFactoryPrice",key);
    }
}
