package com.nhry.model.basic;

/**
 * Created by gongjk on 2016/7/21.
 */
public class MatnrAndQtyModel {
    private String matnr;
    private String resendOrderNo;

    public String getResendOrderNo() {
        return resendOrderNo;
    }

    public void setResendOrderNo(String resendOrderNo) {
        this.resendOrderNo = resendOrderNo;
    }

    private int qty;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
