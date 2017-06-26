package com.nhry.data.stock.dao;

import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.model.stock.GiOrderModel;

import java.util.List;

public interface TSsmGiOrderMapper {
    int deleteGiOrderByNo(String orderNo);

    int insertGiOrder(TSsmGiOrder record);

    int insertGiOrderSelective(TSsmGiOrder record);

    TSsmGiOrder selectGiOrderByNo(String orderNo);

    int updateGiOrderSelective(TSsmGiOrder record);

    int updateGiOrder(TSsmGiOrder record);

    List<TSsmGiOrder> findGiOrder(GiOrderModel model);

    List<TSsmGiOrder> findGiOrderByReqOrderNo(String reqOrderNo);

}