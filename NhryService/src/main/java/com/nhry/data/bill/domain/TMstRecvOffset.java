package com.nhry.data.bill.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/8/24.
 * 冲销单
 */
public class TMstRecvOffset {
    private String offsetNo;        //冲销单号
    private Date offsetDate;        //冲销日期
    private String receiptNo;       //收款单号
    private String orderNo;         //订单号
    private BigDecimal amt;         // 收款金额
    private BigDecimal accAmt;      //收取的订户余额
    private Date createAt;          //操作时间
    private String createBy;         //操作人
    private String createByTxt;      //操作人名称
    private String vipCustNo;       //订户号
    private String remark;          //备注


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOffsetNo() {
        return offsetNo;
    }

    public void setOffsetNo(String offsetNo) {
        this.offsetNo = offsetNo;
    }

    public Date getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(Date offsetDate) {
        this.offsetDate = offsetDate;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getAccAmt() {
        return accAmt;
    }

    public void setAccAmt(BigDecimal accAmt) {
        this.accAmt = accAmt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }
}
