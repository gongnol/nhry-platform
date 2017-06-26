package com.nhry.data.stock.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stock.domain.TSsmStock;
import com.nhry.data.stock.domain.TSsmStockKey;
import com.nhry.model.stock.StockModel;

import java.math.BigDecimal;
import java.util.List;

public interface TSsmStockMapper {
    int deleteStock(TSsmStockKey key);

    int insertStock(TSsmStock record);

    TSsmStock getStock(TSsmStockKey key);

    int updateStock(TSsmStock record);

    int updateStockToZero(String BranchNo);

    List findStockinsidesal(StockModel model);

    List findTmpStockinsidesal(StockModel model);

    PageInfo findStock(StockModel model);

    BigDecimal findStockTotal(StockModel model);
}