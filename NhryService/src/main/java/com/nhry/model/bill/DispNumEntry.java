package com.nhry.model.bill;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/4.
 */
public class DispNumEntry {
    private int itemValue;
    private int startValue;
    private int endValue;
    private BigDecimal rate;

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
