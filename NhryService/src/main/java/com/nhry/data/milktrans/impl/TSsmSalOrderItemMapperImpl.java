package com.nhry.data.milktrans.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TSsmSalOrderItemMapper;
import com.nhry.data.milktrans.domain.TSsmSalOrderItems;
import com.nhry.model.milktrans.RequireOrderSearch;
import com.nhry.model.order.OrderPointModel;

import java.math.BigDecimal;
import java.util.Map;

import java.util.List;

/**
 * Created by gongjk on 2016/7/16.
 */
public class TSsmSalOrderItemMapperImpl implements TSsmSalOrderItemMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public int addSalOrderItem(TSsmSalOrderItems salOrderItems) {
        return sqlSessionTemplate.insert("addSalOrderItem",salOrderItems);
    }

    @Override
    public List<TSsmSalOrderItems> selectItemsBySalOrderNo(Map  map) {
        return sqlSessionTemplate.selectList("selectItemsBySalOrderNo",map);
    }

    @Override
    public List<Map<String, String>> findItemsForPI(String orderNo) {
        return sqlSessionTemplate.selectList("findItemsForPI",orderNo);
    }

    @Override
    public List<Map<String, String>> findDealerItemsForPI(String orderNo) {
        return sqlSessionTemplate.selectList("findDealerItemsForPI",orderNo);
    }

    @Override
    public int delSalOrderItemsByOrderNo(String orderNo) {
        return sqlSessionTemplate.delete("delSalOrderItemsByOrderNo",orderNo);
    }

    @Override
    public int uptYfrechAndYGrowthByOrderNoAndItemNo(OrderPointModel model) {
        return sqlSessionTemplate.update("uptYfrechAndYGrowthByOrderNoAndItemNo",model);
    }

    @Override
    public OrderPointModel getSumYfrechAndYGrowByOrderNo(String orderNo) {
        return sqlSessionTemplate.selectOne("getSumYfrechAndYGrowByOrderNo",orderNo);
    }

    @Override
    public List<Map<String, String>> selectPromDaliyDiscountAmtOfDearler(RequireOrderSearch rModel) {
        return sqlSessionTemplate.selectList("selectPromDaliyDiscountAmtOfDearler",rModel);
    }

    @Override
    public List<Map<String, String>> selectPromDaliyDiscountAmtOfBranch(RequireOrderSearch rModel) {
        return sqlSessionTemplate.selectList("selectPromDaliyDiscountAmtOfBranch",rModel);
    }

    @Override
    public int updateDiscountAmt(TSsmSalOrderItems item) {
        return sqlSessionTemplate.update("updateDiscountAmt",item);
    }

    @Override
    public TSsmSalOrderItems getSalOrderItemByKey(TSsmSalOrderItems items) {
        return sqlSessionTemplate.selectOne("getSalOrderItemByKey",items);
    }
    @Override
    public int updateSalOrderItem(TSsmSalOrderItems items) {
        return sqlSessionTemplate.update("updateSalOrderItem",items);
    }

    @Override
    public BigDecimal sumSalOrderByDate(RequireOrderSearch rModel) {
        return sqlSessionTemplate.selectOne("sumSalOrderByDate",rModel);
    }
}
