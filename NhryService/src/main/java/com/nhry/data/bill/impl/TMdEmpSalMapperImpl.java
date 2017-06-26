package com.nhry.data.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.TMdEmpSalMapper;
import com.nhry.data.bill.domain.TMdEmpSal;
import com.nhry.model.bill.EmpDispDetialInfoSearch;

import java.util.Map;

/**
 * Created by gongjk on 2016/7/12.
 */
public class TMdEmpSalMapperImpl implements TMdEmpSalMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public PageInfo searchEmpSalaryRep(EmpDispDetialInfoSearch eSearch) {
        return sqlSessionTemplate.selectListByPages("searchEmpSalaryRep",eSearch, Integer.parseInt(eSearch.getPageNum()), Integer.parseInt(eSearch.getPageSize()));

    }

    @Override
    public TMdEmpSal getEmpSalByEmpNoAndDate(Map<String, String> map) {
        return sqlSessionTemplate.selectOne("getEmpSalByEmpNoAndDate",map);
    }

    @Override
    public int addEmpSal(TMdEmpSal empSal) {
        return sqlSessionTemplate.insert("addEmpSal",empSal);
    }

    @Override
    public TMdEmpSal getEmpSalByEmpSalLsh(String empSalLsh) {
        return sqlSessionTemplate.selectOne("getEmpSalByEmpSalLsh",empSalLsh);
    }

    @Override
    public int delEmpSalByEmpNoAndDate(Map<String, String> map) {
        return sqlSessionTemplate.delete("delEmpSalByEmpNoAndDate",map);
    }
}
