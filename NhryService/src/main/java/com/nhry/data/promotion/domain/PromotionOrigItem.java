package com.nhry.data.promotion.domain;

import java.math.BigDecimal;

public class PromotionOrigItem{

    private String promNo;

    private String itemNo;

    private String goodNo;

    private BigDecimal origNum;

    private String unit;

    private BigDecimal discountAmt;

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }

    public BigDecimal getOrigNum() {
        return origNum;
    }

    public void setOrigNum(BigDecimal origNum) {
        this.origNum = origNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo == null ? null : promNo.trim();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }
}