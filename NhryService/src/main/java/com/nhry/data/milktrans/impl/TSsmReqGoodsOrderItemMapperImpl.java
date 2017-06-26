package com.nhry.data.milktrans.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderItemMapper;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrderItem;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrderItemUpt;
import com.nhry.model.milktrans.ReqGoodsOrderItemSearch;
import com.nhry.model.milktrans.UpdateRequiredModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/7/5.
 */
public class TSsmReqGoodsOrderItemMapperImpl implements TSsmReqGoodsOrderItemMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertRequireOrderItem(TSsmReqGoodsOrderItem item) {
        return sqlSessionTemplate.insert("insertRequireOrderItem",item);
    }

    @Override
    public List<TSsmReqGoodsOrderItem> getReqGoodsItemsByOrderNo(String orderNo) {
        return sqlSessionTemplate.selectList("getReqGoodsItemsByOrderNo",orderNo);
    }

    @Override
    public TSsmReqGoodsOrderItem getReqGoodsItemsByMatnrAndOrderNo(String orderNo, String oldMatnr) {
        ReqGoodsOrderItemSearch item = new ReqGoodsOrderItemSearch();
        item.setMatnr(oldMatnr);
        item.setOrderNo(orderNo);
        return sqlSessionTemplate.selectOne("getReqGoodsItemsByMatnrAndOrderNo",item);
    }

    @Override
    public int uptNewReqGoodsItem(TSsmReqGoodsOrderItemUpt itemUpt) {
        return sqlSessionTemplate.update("uptNewReqGoodsItem",itemUpt);
}

    //更新生成的要货计划行的增量
    @Override
    public int uptReqGoodsItem(UpdateRequiredModel uModel) {
        return sqlSessionTemplate.update("uptReqGoodsItem",uModel);
    }

    @Override
    public int delRequireOrderItem(ReqGoodsOrderItemSearch item) {
        return sqlSessionTemplate.delete("delRequireOrderItem",item);
    }

    @Override
    public List<Map<String, String>> findItemsForPI(ReqGoodsOrderItemSearch item) {
        return sqlSessionTemplate.selectList("findOrderItemsForPI",item);
    }

    @Override
    public int getMaxItemNoByOrderNo(String orderNo) {
        return sqlSessionTemplate.selectOne("getMaxItemNoByOrderNo",orderNo);
    }

    @Override
    public int delRequireOrderItemsByOrderNo(String orderNo) {
        return sqlSessionTemplate.delete("delRequireOrderItemsByOrderNo",orderNo);
    }
}
