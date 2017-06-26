package com.nhry.model.order;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/12/13.
 */
public class YearCardBackModel {
    private String memoTxt;
    private String backReason;
    private Date backDate;
    private BigDecimal shRefund;         //应该退款
    private BigDecimal backAmt;         //实际退款
    private String orderNo;             //订单号
    private BigDecimal realDiscount;  //实际折扣

    public String getMemoTxt() {
        return memoTxt;
    }

    public void setMemoTxt(String memoTxt) {
        this.memoTxt = memoTxt;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public BigDecimal getShRefund() {
        return shRefund;
    }

    public void setShRefund(BigDecimal shRefund) {
        this.shRefund = shRefund;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public BigDecimal getRealDiscount() {
        return realDiscount;
    }

    public void setRealDiscount(BigDecimal realDiscount) {
        this.realDiscount = realDiscount;
    }

    public BigDecimal getBackAmt() {
        return backAmt;
    }

    public void setBackAmt(BigDecimal backAmt) {
        this.backAmt = backAmt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
