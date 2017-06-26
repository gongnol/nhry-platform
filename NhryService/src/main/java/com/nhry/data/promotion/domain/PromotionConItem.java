package com.nhry.data.promotion.domain;

import java.math.BigDecimal;

public class PromotionConItem extends PromotionConItemKey {
    private String conType;

    private String opt;

    private BigDecimal high;

    private BigDecimal low;

    public String getConType() {
        return conType;
    }

    public void setConType(String conType) {
        this.conType = conType == null ? null : conType.trim();
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt == null ? null : opt.trim();
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }
}