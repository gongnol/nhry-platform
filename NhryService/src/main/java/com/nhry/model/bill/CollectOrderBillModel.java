package com.nhry.model.bill;

import com.nhry.model.order.ProductItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/8/18.
 */
public class CollectOrderBillModel {
    private String orderNo;         //订单号
    private String branchNo;        //奶站号
    private String branchName;      //奶站名
    private String branchTel;       //奶站电话
    private String branchAddress;   //奶站地址
    private String vipCustNo;       //订户号
    private String vipName;         //订户名称
    private String custTel;         //订户电话
    private BigDecimal custAccAmt;  //订户余额
    private BigDecimal accAmt;      //订户余额（收取的订户余额)
    private String custAddress;     //订户地址
    private String custAddressShort;//订户地址(不包括省市区)
    private String empNo;           //送奶工号
    private String empName;         //送奶工名称
    private String empTel;          //送奶工电话
    private BigDecimal initAmt;     //订单金额
    private BigDecimal orderAmt;         //应收金额
    private Date startDate;          //订奶起始日期
    private Date endDate;             //订奶结束日期
    private String salesOrgName;      //销售组织名称
    private BigDecimal discountAmt;    //折扣价
    private String promDescribe;    //促销描述
    private List<ProductItem> entries; // 产品

    public String getPromDescribe() {
        return promDescribe;
    }

    public void setPromDescribe(String promDescribe) {
        this.promDescribe = promDescribe;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getCustAccAmt() {
        return custAccAmt;
    }

    public void setCustAccAmt(BigDecimal custAccAmt) {
        this.custAccAmt = custAccAmt;
    }

    public String getCustAddressShort() {
        return custAddressShort;
    }

    public void setCustAddressShort(String custAddressShort) {
        this.custAddressShort = custAddressShort;
    }

    public String getSalesOrgName() {
        return salesOrgName;
    }

    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ProductItem> getEntries() {
        return entries;
    }

    public void setEntries(List<ProductItem> entries) {
        this.entries = entries;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchTel() {
        return branchTel;
    }

    public void setBranchTel(String branchTel) {
        this.branchTel = branchTel;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public BigDecimal getAccAmt() {
        return accAmt;
    }

    public void setAccAmt(BigDecimal accAmt) {
        this.accAmt = accAmt;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public BigDecimal getInitAmt() {
        return initAmt;
    }

    public void setInitAmt(BigDecimal initAmt) {
        this.initAmt = initAmt;
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }
}
