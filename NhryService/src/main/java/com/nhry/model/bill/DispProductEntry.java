package com.nhry.model.bill;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/5.
 */
public class DispProductEntry {
    private String matnr;
    private String matnrTxt;
    private BigDecimal dispRate;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public BigDecimal getDispRate() {
        return dispRate;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public void setDispRate(BigDecimal dispRate) {
        this.dispRate = dispRate;
    }
}
