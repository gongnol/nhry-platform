package com.nhry.data.stock.dao;

import com.nhry.data.stock.domain.TSsmVoucherItem;
import com.nhry.data.stock.domain.TSsmVoucherItemKey;

public interface TSsmVoucherItemMapper {
    int deleteVoucherItem(TSsmVoucherItemKey key);

    int insertVoucherItem(TSsmVoucherItem record);

    TSsmVoucherItem getVoucherItem(TSsmVoucherItemKey key);

    int updateVoucherItemSelective(TSsmVoucherItem record);

    int updateVoucherItem(TSsmVoucherItem record);
}