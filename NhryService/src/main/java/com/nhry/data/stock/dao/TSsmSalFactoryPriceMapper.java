package com.nhry.data.stock.dao;

import com.nhry.data.stock.domain.TSsmSalFactoryPrice;
import com.nhry.data.stock.domain.TSsmSalFactoryPriceKey;

public interface TSsmSalFactoryPriceMapper {
    int insertFactoryPrice(TSsmSalFactoryPrice record);
    TSsmSalFactoryPrice selectFactoryPrice(TSsmSalFactoryPriceKey key);
}