package com.nhry.model.milktrans;

/**
 * Created by gongjk on 2016/6/22.
 */
public class OrderRequireItem {
    private String matnr;
    private String matnrTxt;
    private Integer  qty;
    private Integer increQty;
    private String flag;
    private Integer resendQty;
    private boolean hasTmp;

    public Integer getResendQty() {
        return resendQty;
    }

    public void setResendQty(Integer resendQty) {
        this.resendQty = resendQty;
    }

    public boolean isHasTmp() {
        return hasTmp;
    }

    public void setHasTmp(boolean hasTmp) {
        this.hasTmp = hasTmp;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIncreQty() {
        return increQty;
    }

    public void setIncreQty(Integer increQty) {
        this.increQty = increQty;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
