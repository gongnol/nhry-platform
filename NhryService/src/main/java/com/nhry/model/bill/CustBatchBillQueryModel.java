package com.nhry.model.bill;

import java.util.Date;

/**
 * Created by gongjk on 2016/8/18.
 */
public class CustBatchBillQueryModel {
    private Date orderStartDate;
    private Date orderEndDate;
    private String branchNo ;
    private String dealerNo;
    private String salesOrg;
    private String empNo;

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date orderEndDate) {
        this.orderEndDate = orderEndDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
}
