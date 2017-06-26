package com.nhry.data.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.BranchBillMapper;
import com.nhry.model.bill.CustBranchBillSearch;
import com.nhry.model.bill.EmpBranchBillDetailSearch;
import com.nhry.model.bill.EmpBranchBillSearch;

/**
 * Created by gongjk on 2016/6/27.
 */
public class BranchBillMapperImpl implements BranchBillMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public PageInfo branchBillEmpSearch(EmpBranchBillSearch bsearch) {
        return sqlSessionTemplate.selectListByPages("branchBillEmpSearch",bsearch, Integer.parseInt(bsearch.getPageNum()), Integer.parseInt(bsearch.getPageSize()));

    }

    @Override
    public PageInfo branchBillEmpItemSearch(EmpBranchBillDetailSearch bsearch) {
        return sqlSessionTemplate.selectListByPages("branchBillEmpItemSearch",bsearch, Integer.parseInt(bsearch.getPageNum()), Integer.parseInt(bsearch.getPageSize()));
    }

    @Override
    public PageInfo CustomerBranchBill(CustBranchBillSearch bsearch) {
        return sqlSessionTemplate.selectListByPages("CustomerBranchBill",bsearch, Integer.parseInt(bsearch.getPageNum()), Integer.parseInt(bsearch.getPageSize()));

    }
}
