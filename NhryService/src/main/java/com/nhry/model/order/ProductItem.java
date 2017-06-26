package com.nhry.model.order;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/18.
 */
public class ProductItem {
    private String matnr;
    private String unit;
    private String matnrTxt;
    private int qty;
    private BigDecimal basePrice;
    private BigDecimal totalPrice;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
