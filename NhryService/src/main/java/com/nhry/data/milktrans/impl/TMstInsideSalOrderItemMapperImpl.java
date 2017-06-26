package com.nhry.data.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TMstInsideSalOrderItemMapper;
import com.nhry.data.milktrans.domain.TMstInsideSalOrderItem;
import com.nhry.model.milktrans.InSideSalOrderDetailSearchModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/6/30.
 */
public class TMstInsideSalOrderItemMapperImpl implements TMstInsideSalOrderItemMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public int delInSalOrderItemByOrderNo(String insOrderNo) {
        return sqlSessionTemplate.delete("delInSalOrderItemByOrderNo",insOrderNo);
    }

    @Override
    public int insertOrderItem(TMstInsideSalOrderItem item) {
        return sqlSessionTemplate.insert("insertOrderItem",item);
    }

    @Override
    public int batchAddNewInsideOrderItems(List<TMstInsideSalOrderItem> items)
    {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.insert("batchAddNewInsideOrderItems", items);
    }
    @Override
    public PageInfo getInsideSalOrderDetail(InSideSalOrderDetailSearchModel smodel) {
        return sqlSessionTemplate.selectListByPages("getInsideSalOrderDetail",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
    }

    @Override
    public int deleteInSalOrderItemByMap(Map<String, String> map) {
        return sqlSessionTemplate.delete("deleteInSalOrderItemByMap",map);
    }

    @Override
    public List<TMstInsideSalOrderItem> getItemsByNo(String insOrderNo) {
        return sqlSessionTemplate.selectList("getItemsByNo",insOrderNo);
    }
}
