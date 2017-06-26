package com.nhry.data.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TMstInsideSalOrderMapper;
import com.nhry.data.milktrans.domain.TMstInsideSalOrder;
import com.nhry.model.milktrans.InSideSalOrderSearchModel;

/**
 * Created by gongjk on 2016/6/30.
 */
public class TMstInsideSalOrderMapperImpl implements TMstInsideSalOrderMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public TMstInsideSalOrder getInSalOrderByDispOrderNo(String dispOrderNo) {
        return sqlSessionTemplate.selectOne("getInSalOrderByDispOrderNo",dispOrderNo);
    }

    @Override
    public int insertInsideSalOrder(TMstInsideSalOrder sOrder) {
        return sqlSessionTemplate.insert("insertInsideSalOrder",sOrder);
    }

    @Override
    public PageInfo getAuthAllInsideSalOrder(InSideSalOrderSearchModel smodel) {
        return sqlSessionTemplate.selectListByPages("getAuthAllInsideSalOrder",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
    }

    @Override
    public int deleteInSalOrderByDispOrderNo(String insOrderNo) {
        return sqlSessionTemplate.delete("deleteInSalOrderByDispOrderNo",insOrderNo);
    }


}
