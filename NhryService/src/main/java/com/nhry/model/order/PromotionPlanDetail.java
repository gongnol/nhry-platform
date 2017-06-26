package com.nhry.model.order;

import java.math.BigDecimal;

/**
 * Created by cbz on 11/23/2016.
 */
public class PromotionPlanDetail {
    String matnr;
    Integer qty;
    BigDecimal salesPrice;
    BigDecimal amt;

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }
}
