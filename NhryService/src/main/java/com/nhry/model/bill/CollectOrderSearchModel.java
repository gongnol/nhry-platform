package com.nhry.model.bill;

import java.util.List;

/**
 * Created by gongjk on 2016/8/29.
 */
public class CollectOrderSearchModel {
    private String paymentmehod ;
    private String orderNo;
    private List<String> orders;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPaymentmehod() {
        return paymentmehod;
    }

    public void setPaymentmehod(String paymentmehod) {
        this.paymentmehod = paymentmehod;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }
}
