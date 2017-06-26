package com.nhry.model.milktrans;

/**
 * Created by gongjk on 2016/7/6.
 */
public class UpdateNewRequiredModel  {
    private String orderNo;
    private String oldMatnr;
    private String matnr;
    private String matnrTxt;
    private int qty;
    private int increQty;

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
