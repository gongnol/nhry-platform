package com.nhry.model.bill;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/6/29.
 */
public class BranchBillEmpModel {
    private String empNo;
    private String empName;
    private Date dispDate;
    private BigDecimal qty;
    private BigDecimal salePrice;
    private BigDecimal billPrice;
    private List<BranchBillEmpItemModel> entries;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(BigDecimal billPrice) {
        this.billPrice = billPrice;
    }

    public List<BranchBillEmpItemModel> getEntries() {
        return entries;
    }

    public void setEntries(List<BranchBillEmpItemModel> entries) {
        this.entries = entries;
    }
}
