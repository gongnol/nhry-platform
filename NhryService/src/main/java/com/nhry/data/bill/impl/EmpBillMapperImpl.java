package com.nhry.data.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.EmpBillMapper;
import com.nhry.model.bill.EmpAccoDispFeeByProduct;
import com.nhry.model.bill.EmpDispDetialInfoSearch;

import java.util.List;

/**
 * Created by gongjk on 2016/7/1.
 */
public class EmpBillMapperImpl implements EmpBillMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public PageInfo empDispDetialInfo(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectListByPages("empDispDetialInfo",eSearch, Integer.parseInt(eSearch.getPageNum()), Integer.parseInt(eSearch.getPageSize()));

    }

    @Override
    public PageInfo empAccountReceAmount(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectListByPages("empAccountReceAmount",eSearch, Integer.parseInt(eSearch.getPageNum()), Integer.parseInt(eSearch.getPageSize()));
    }

    @Override
    public PageInfo empSalaryRep(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectListByPages("empSalaryRep",eSearch, Integer.parseInt(eSearch.getPageNum()), Integer.parseInt(eSearch.getPageSize()));
    }

    @Override
    public List<EmpAccoDispFeeByProduct> empAccoDispFeeByProduct(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectList("empAccoDispFeeByProduct",eSearch);
    }

    @Override
    public int empAccoDispFeeByNum(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectOne("empAccoDispFeeByNum",eSearch);
    }

    @Override
    public int empInDispFeeNum(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectOne("empInDispFeeNum",eSearch);
    }

    @Override
    public int empDispFeeNum(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectOne("empDispFeeNum",eSearch);
    }

    @Override
    public int empFreeDispFeeNum(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectOne("empFreeDispFeeNum",eSearch);
    }

    @Override
    public List<EmpAccoDispFeeByProduct> empDisByProduct(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectList("empDisByProduct",eSearch);
    }

    @Override
    public List<EmpAccoDispFeeByProduct> empInDispByProduct(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectList("empInDispByProduct",eSearch);
    }

    @Override
    public List<EmpAccoDispFeeByProduct> empFreeDispByProduct(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectList("empFreeDispByProduct",eSearch);
    }
}
