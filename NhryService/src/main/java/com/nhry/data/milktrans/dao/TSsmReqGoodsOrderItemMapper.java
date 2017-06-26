package com.nhry.data.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmReqGoodsOrderItem;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrderItemUpt;
import com.nhry.model.milktrans.ReqGoodsOrderItemSearch;
import com.nhry.model.milktrans.UpdateRequiredModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/7/5.
 */
public interface TSsmReqGoodsOrderItemMapper {
    public int insertRequireOrderItem(TSsmReqGoodsOrderItem item);

    List<TSsmReqGoodsOrderItem> getReqGoodsItemsByOrderNo(String orderNo);

    TSsmReqGoodsOrderItem getReqGoodsItemsByMatnrAndOrderNo(String orderNo, String oldMatnr);

    int uptNewReqGoodsItem(TSsmReqGoodsOrderItemUpt itemUpt);

    int uptReqGoodsItem(UpdateRequiredModel uModel);

    int delRequireOrderItem(ReqGoodsOrderItemSearch item);

    List<Map<String,String>> findItemsForPI (ReqGoodsOrderItemSearch item);

    int getMaxItemNoByOrderNo(String orderNo);

    int delRequireOrderItemsByOrderNo(String orderNo);
}
