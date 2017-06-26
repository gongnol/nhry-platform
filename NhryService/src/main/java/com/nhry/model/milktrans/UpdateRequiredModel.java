package com.nhry.model.milktrans;

/**
 * Created by gongjk on 2016/7/6.
 */
public class UpdateRequiredModel {
    private String orderNo;
    private String matnr;
    private int increQty;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public int getIncreQty() {
        return increQty;
    }

    public void setIncreQty(int increQty) {
        this.increQty = increQty;
    }
}
