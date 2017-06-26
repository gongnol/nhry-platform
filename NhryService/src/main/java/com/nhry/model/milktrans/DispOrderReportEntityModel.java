package com.nhry.model.milktrans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cbz on 9/14/2016.
 */
public class DispOrderReportEntityModel implements Serializable{
    String empName;
    Date dispDate;
    String reachTimeType;
    String addressTxt;
    String mp;
    String vipName;
    String matnrTxt;
    String confirmMatnrTxt;
    BigDecimal qty;
    BigDecimal confirmQty;

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

    public String getConfirmMatnrTxt() {
        return confirmMatnrTxt;
    }

    public void setConfirmMatnrTxt(String confirmMatnrTxt) {
        this.confirmMatnrTxt = confirmMatnrTxt;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(BigDecimal confirmQty) {
        this.confirmQty = confirmQty;
    }
}
