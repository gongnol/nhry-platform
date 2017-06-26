package com.nhry.service.stock.dao;

import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.model.stock.GiOrderModel;

import java.util.List;

/**
 * Created by cbz on 7/25/2016.
 */
public interface TSsmGiOrderService {

    List<TSsmGiOrder> findGiOrder(GiOrderModel model);

    int deleteGiOrderByNo(String orderNo);

    int insertGiOrder(TSsmGiOrder record);

    int insertGiOrderSelective(TSsmGiOrder record);

    TSsmGiOrder selectGiOrderByNo(String orderNo);

    int updateGiOrderSelective(TSsmGiOrder record);

    int updateGiOrder(TSsmGiOrder record);
}
