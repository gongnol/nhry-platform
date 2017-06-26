package com.nhry.data.stock.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stock.dao.TSsmVoucherMapper;
import com.nhry.data.stock.domain.TSsmVoucher;
import com.nhry.data.stock.domain.TSsmVoucherKey;

/**
 * Created by cbz on 7/19/2016.
 */
public class TSsmVoucherMapperImpl implements TSsmVoucherMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteVoucher(TSsmVoucherKey key) {
        return sqlSessionTemplate.delete("deleteVoucher",key);
    }

    @Override
    public int insertVoucher(TSsmVoucher record) {
        return sqlSessionTemplate.insert("insertVoucher",record);
    }

    @Override
    public TSsmVoucher getVoucher(TSsmVoucherKey key) {
        return sqlSessionTemplate.selectOne("getVoucher",key);
    }

    @Override
    public int updateVoucher(TSsmVoucher record) {
        return sqlSessionTemplate.update("updateVoucher",record);
    }
}
