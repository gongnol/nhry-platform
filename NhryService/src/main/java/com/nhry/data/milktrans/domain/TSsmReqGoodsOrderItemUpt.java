package com.nhry.data.milktrans.domain;

/**
 * Created by gongjk on 2016/7/6.
 */
public class TSsmReqGoodsOrderItemUpt {
    private String orderNo;
    private String oldMatnr;
    private String matnr;
    private String matnrTxt;
    private String unit;
    private int qty;
    private int increQty;
    private int resendQty;

    public int getResendQty() {
        return resendQty;
    }

    public void setResendQty(int resendQty) {
        this.resendQty = resendQty;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOldMatnr() {
        return oldMatnr;
    }

    public void setOldMatnr(String oldMatnr) {
        this.oldMatnr = oldMatnr;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getIncreQty() {
        return increQty;
    }

    public void setIncreQty(int increQty) {
        this.increQty = increQty;
    }
}
