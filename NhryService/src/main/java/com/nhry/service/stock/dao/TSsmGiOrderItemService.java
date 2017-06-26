package com.nhry.service.stock.dao;

import com.nhry.data.stock.domain.TSsmGiOrderItem;
import com.nhry.data.stock.domain.TSsmGiOrderItemKey;
import java.util.List;

/**
 * Created by cbz on 7/25/2016.
 */
public interface TSsmGiOrderItemService {
    int deleteGiOrderItemByNo(TSsmGiOrderItemKey key);

    int insertGiOrderItem(TSsmGiOrderItem record);

    int insertGiOrderItemSelective(TSsmGiOrderItem record);

    TSsmGiOrderItem selectGiOrderItemByNo(TSsmGiOrderItemKey key);

    int updateGiOrderItemSelective(TSsmGiOrderItem record);

    int updateGiOrderItem(TSsmGiOrderItem record);

    List<TSsmGiOrderItem> findGiOrderItem(TSsmGiOrderItemKey key);

    int updateGiOrderItems(List<TSsmGiOrderItem> giOrderItems, String salesOrg);
}
