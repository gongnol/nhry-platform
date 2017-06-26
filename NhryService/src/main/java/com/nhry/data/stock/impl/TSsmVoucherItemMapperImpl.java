package com.nhry.data.stock.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stock.dao.TSsmVoucherItemMapper;
import com.nhry.data.stock.domain.TSsmVoucherItem;
import com.nhry.data.stock.domain.TSsmVoucherItemKey;

/**
 * Created by cbz on 7/19/2016.
 */
public class TSsmVoucherItemMapperImpl implements TSsmVoucherItemMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteVoucherItem(TSsmVoucherItemKey key) {
        return sqlSessionTemplate.delete("deleteVoucherItem",key);
    }

    @Override
    public int insertVoucherItem(TSsmVoucherItem record) {
        return sqlSessionTemplate.insert("insertVoucherItem",record);
    }

    @Override
    public TSsmVoucherItem getVoucherItem(TSsmVoucherItemKey key) {
        return sqlSessionTemplate.selectOne("getVoucherItem",key);
    }

    @Override
    public int updateVoucherItemSelective(TSsmVoucherItem record) {
        return sqlSessionTemplate.update("updateVoucherItemSelective",record);
    }

    @Override
    public int updateVoucherItem(TSsmVoucherItem record) {
        return sqlSessionTemplate.update("updateVoucherItem",record);
    }
}
