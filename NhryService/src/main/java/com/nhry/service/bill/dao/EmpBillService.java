package com.nhry.service.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.bill.domain.TMdEmpSal;
import com.nhry.model.bill.EmpDispDetialInfoSearch;
import com.nhry.model.bill.SaleOrgDispRateModel;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/1.
 */
public interface EmpBillService {
    public PageInfo empDispDetialInfo(EmpDispDetialInfoSearch eSearch);

    PageInfo empAccountReceAmount(EmpDispDetialInfoSearch eSearch);

    public BigDecimal CalculateEmpTransRateByNum(String empNo,int dispNum);

    /**
     * 修改配送费率
     * @param sModel
     * @return
     */
    int uptEmpDispRate(SaleOrgDispRateModel sModel);

   public SaleOrgDispRateModel getSalesOrgDispRate();

    PageInfo searchEmpSalaryRep(EmpDispDetialInfoSearch eSearch);

    PageInfo setBranchEmpSalary();

    TMdEmpSal getEmpSalaryBySalaryNo(String empSalLsh);

    PageInfo setBranchEmpSalaryThisMonth();
}
