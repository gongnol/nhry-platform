package com.nhry.data.stock.dao;

import com.nhry.data.stock.domain.TSsmVoucher;
import com.nhry.data.stock.domain.TSsmVoucherKey;

public interface TSsmVoucherMapper {
    int deleteVoucher(TSsmVoucherKey key);

    int insertVoucher(TSsmVoucher record);

    TSsmVoucher getVoucher(TSsmVoucherKey key);

    int updateVoucher(TSsmVoucher record);
}