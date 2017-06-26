package com.nhry.model.order;

import java.math.BigDecimal;

/**
 * Created by cbz on 8/17/2016.
 */
public class OrderPointModel {
    String orderNo;
    String itemNo;
    BigDecimal yfresh;
    BigDecimal ygrowth;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public BigDecimal getYfresh() {
        return yfresh;
    }

    public void setYfresh(BigDecimal yfresh) {
        this.yfresh = yfresh;
    }

    public BigDecimal getYgrowth() {
        return ygrowth;
    }

    public void setYgrowth(BigDecimal ygrowth) {
        this.ygrowth = ygrowth;
    }
}
