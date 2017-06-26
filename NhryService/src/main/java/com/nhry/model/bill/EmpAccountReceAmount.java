package com.nhry.model.bill;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/1.
 */
public class EmpAccountReceAmount {
    private String orderNo;            //订单号
    private String receiptNo;          //收款单号
    private String empName;            //送奶工名称
    private String custName;           //订户名称
    private String address;            //订户地址
    private String mp;                 //订户电话
    private BigDecimal amountRece;     //应收账款
    private BigDecimal amountReal;     //实收账款
    private BigDecimal acctAmt;        //订户余额付款金额
    private BigDecimal custAcctAmt;   //订户付款时余额
    private BigDecimal amountGap;      //差额
    private String paymentType;        //付款类型
    private String paymentDate;        //收款日期
    private String branchName;         //奶站名称
    private String paymentmethod;

    public BigDecimal getCustAcctAmt() {
        return custAcctAmt;
    }

    public void setCustAcctAmt(BigDecimal custAcctAmt) {
        this.custAcctAmt = custAcctAmt;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }


    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public BigDecimal getAcctAmt() {
        return acctAmt;
    }

    public void setAcctAmt(BigDecimal acctAmt) {
        this.acctAmt = acctAmt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public BigDecimal getAmountRece() {
        return amountRece;
    }

    public void setAmountRece(BigDecimal amountRece) {
        this.amountRece = amountRece;
    }

    public BigDecimal getAmountReal() {
        return amountReal;
    }

    public void setAmountReal(BigDecimal amountReal) {
        this.amountReal = amountReal;
    }

    public BigDecimal getAmountGap() {
        return amountGap;
    }

    public void setAmountGap(BigDecimal amountGap) {
        this.amountGap = amountGap;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
