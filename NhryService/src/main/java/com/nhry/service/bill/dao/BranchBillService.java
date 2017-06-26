package com.nhry.service.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.bill.CustBranchBillSearch;
import com.nhry.model.bill.EmpBranchBillDetailSearch;
import com.nhry.model.bill.EmpBranchBillSearch;

/**
 * Created by gongjk on 2016/6/27.
 */
public interface BranchBillService {
    PageInfo EmpBranchBill(EmpBranchBillSearch bsearch);

    PageInfo getEmpBranchBillDetail(EmpBranchBillDetailSearch bsearch);

    PageInfo CustomerBranchBill(CustBranchBillSearch bsearch);
}
