package com.nhry.model.bill;

/**
 * Created by gongjk on 2016/7/1.
 */
public class MatnrEntry {
    private String orderNo;
    private String matnr;
    private String matnrTxt;
    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
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
}
