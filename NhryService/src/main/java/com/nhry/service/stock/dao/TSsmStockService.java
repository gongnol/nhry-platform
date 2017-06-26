package com.nhry.service.stock.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milktrans.domain.TMstRefuseResend;
import com.nhry.data.stock.domain.TSsmStock;
import com.nhry.data.stock.domain.TSsmStockKey;
import com.nhry.model.stock.StockModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cbz on 7/19/2016.
 */
public interface TSsmStockService {
    /**
     * 库存保存
     * */
    int save(TSsmStock ssmStock);
    TSsmStock getStock(TSsmStockKey key);

    /**
     * 返回库存信息
     * @param mode
     * @return
     */
    PageInfo findStock(StockModel mode);
    /**
     * 返回剩余库存信息
     * */
    List<StockModel> findStockinsidesal(StockModel mode);
    /**
     * 返回剩余拒收复送信息
     * */
    List<StockModel> findTmpStockinsidesal(StockModel model);
    BigDecimal findStockTotal(StockModel mode);
    int genarateStock(StockModel mode);

    /**
     * 库存运算
     * @param branchNo
     * @param matnr
     * @param qty
     * @param salesOrg
     * @return
     */
    int updateStock(String branchNo, String matnr, BigDecimal qty, String salesOrg);
    /**
     * 更新临时退库库存
     * @param branchNo
     * @param matnr
     * @param qty
     * @param salesOrg
     * @return
     */
    int updateTmpStock(String branchNo, String matnr, BigDecimal tmpQty, String salesOrg);
    /**
     * 根据奶站执行库存清零
     * */
    int updateStockToZero();

    /**
     * 查询拒收复送剩余数量-送奶员围度查询
     * create at 2016-10-27
     * */
    List<TMstRefuseResend> selectRefuseForInside(String empNo);

}
