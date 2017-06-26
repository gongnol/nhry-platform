package com.nhry.data.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.bill.CustBranchBillSearch;
import com.nhry.model.bill.EmpBranchBillDetailSearch;
import com.nhry.model.bill.EmpBranchBillSearch;

/**
 * Created by gongjk on 2016/6/27.
 */
public interface BranchBillMapper {

    PageInfo branchBillEmpSearch(EmpBranchBillSearch bsearch);

    PageInfo branchBillEmpItemSearch(EmpBranchBillDetailSearch bsearch);

    PageInfo CustomerBranchBill(CustBranchBillSearch bsearch);
}
