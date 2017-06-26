package com.nhry.model.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cbz on 9/14/2016.
 */
public class OrderDaliyPlanReportEntityModel implements Serializable{
    String empName;
    Date dispDate;
    String reachTimeType;
    String addressTxt;
    String mp;
    String vipName;
    String matnrTxt;
    BigDecimal curAmt;
    BigDecimal qty;
    BigDecimal price;
    String status;
    String orderNo;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public String getReachTimeType() {
        return reachTimeType;
    }

    public void setReachTimeType(String reachTimeType) {
        this.reachTimeType = reachTimeType;
    }

    public String getAddressTxt() {
        return addressTxt;
    }

    public void setAddressTxt(String addressTxt) {
        this.addressTxt = addressTxt;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getCurAmt() {
        return curAmt;
    }

    public void setCurAmt(BigDecimal curAmt) {
        this.curAmt = curAmt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
