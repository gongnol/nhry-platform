package com.nhry.data.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.bill.domain.TMdEmpSal;
import com.nhry.model.bill.EmpDispDetialInfoSearch;

import java.util.Map;

/**
 * Created by gongjk on 2016/7/12.
 */
public interface TMdEmpSalMapper {

    PageInfo searchEmpSalaryRep(EmpDispDetialInfoSearch eSearch);

    TMdEmpSal getEmpSalByEmpNoAndDate(Map<String, String> map);


    int addEmpSal(TMdEmpSal empSal);

    TMdEmpSal getEmpSalByEmpSalLsh(String empSalLsh);

    int delEmpSalByEmpNoAndDate(Map<String, String> map);
}
