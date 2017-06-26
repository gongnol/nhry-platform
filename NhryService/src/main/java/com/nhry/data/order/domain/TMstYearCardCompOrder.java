package com.nhry.data.order.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/12/14.
 * 年卡补偿单据
 */
public class TMstYearCardCompOrder {
    private String orderNo;         // 订单号
    private String matnrTxt;        // 产品名称
    private BigDecimal initAmt;        // 订单总金额（initAmt）
    private BigDecimal daliyQty;    // 均日数量
    private int preTotal;           // 预定数量
    private int realTotal;          // 已消费数量
    private BigDecimal preDiscount; //  原折扣
    private BigDecimal realDiscount; // 实际折扣
    private BigDecimal shRefund;     // 应退款
    private BigDecimal realRefund;  //  实际退款
    private BigDecimal difference;  //  差额
    private Date createAt;
    private String createBy;
    private String createByTxt;
    private Date backDate;          //年卡退订日期
    private String vipCustNo;       //订户编号
    private String vipName;         //订户名称
    private String custMp;          //订户电话
    private String custAddress;     //订户地址

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public BigDecimal getInitAmt() {
        return initAmt;
    }

    public void setInitAmt(BigDecimal initAmt) {
        this.initAmt = initAmt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public BigDecimal getDaliyQty() {
        return daliyQty;
    }

    public void setDaliyQty(BigDecimal daliyQty) {
        this.daliyQty = daliyQty;
    }

    public int getPreTotal() {
        return preTotal;
    }

    public void setPreTotal(int preTotal) {
        this.preTotal = preTotal;
    }

    public int getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(int realTotal) {
        this.realTotal = realTotal;
    }

    public BigDecimal getPreDiscount() {
        return preDiscount;
    }

    public void setPreDiscount(BigDecimal preDiscount) {
        this.preDiscount = preDiscount;
    }

    public BigDecimal getRealDiscount() {
        return realDiscount;
    }

    public void setRealDiscount(BigDecimal realDiscount) {
        this.realDiscount = realDiscount;
    }

    public BigDecimal getShRefund() {
        return shRefund;
    }

    public void setShRefund(BigDecimal shRefund) {
        this.shRefund = shRefund;
    }

    public BigDecimal getRealRefund() {
        return realRefund;
    }

    public void setRealRefund(BigDecimal realRefund) {
        this.realRefund = realRefund;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
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

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getCustMp() {
        return custMp;
    }

    public void setCustMp(String custMp) {
        this.custMp = custMp;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
