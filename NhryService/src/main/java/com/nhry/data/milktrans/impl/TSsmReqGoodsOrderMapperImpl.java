package com.nhry.data.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderMapper;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrder;
import com.nhry.model.milktrans.RequireOrderSearch;
import com.nhry.model.milktrans.RequireOrderSearchPage;

import java.util.List;

/**
 * Created by gongjk on 2016/6/22.
 */
public class TSsmReqGoodsOrderMapperImpl implements TSsmReqGoodsOrderMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public int insertRequireOrder(TSsmReqGoodsOrder order) {
        return sqlSessionTemplate.insert("insertRequireOrder",order);
    }

    @Override
    public TSsmReqGoodsOrder searchRequireOrder(RequireOrderSearch rModel) {
        return sqlSessionTemplate.selectOne("searchRequireOrder",rModel);
    }

    @Override
    public TSsmReqGoodsOrder getRequireOrderByNo(String orderNo) {
        return sqlSessionTemplate.selectOne("getRequireOrderByNo",orderNo);
    }

    @Override
    public int uptRequireGoodsModifyInfo(TSsmReqGoodsOrder orderModel) {
        return sqlSessionTemplate.update("uptRequireGoodsModifyInfo",orderModel);
    }

    @Override
    public TSsmReqGoodsOrder getRequireOrderByVoucherNo(String voucherNo) {
        return sqlSessionTemplate.selectOne("getRequireOrderByVoucherNo",voucherNo);
    }

    @Override
    public int deleRequireGoodsOrderbyNo(String orderNo) {
        return sqlSessionTemplate.delete("deleRequireGoodsOrderbyNo",orderNo);
    }

    @Override
    public List<TSsmReqGoodsOrder> searchRequireOrderByRequireDate(RequireOrderSearch rModel) {
        return sqlSessionTemplate.selectList("searchRequireOrderByRequireDate",rModel);
    }

    @Override
    public PageInfo searchRequireOrderByDealer(RequireOrderSearchPage rModel) {
        return sqlSessionTemplate.selectListByPages("searchRequireOrderByDealer",rModel,Integer.valueOf(rModel.getPageNum()),Integer.valueOf(rModel.getPageSize()));
    }
}
