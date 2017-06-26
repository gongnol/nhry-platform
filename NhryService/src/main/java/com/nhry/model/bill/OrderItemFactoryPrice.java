package com.nhry.model.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/28.
 */
public class OrderItemFactoryPrice implements Serializable{

    private String matnr;
    private int qty;
    private BigDecimal factoryPrice;
    private Date orderDate;

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

    public BigDecimal getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(BigDecimal factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
