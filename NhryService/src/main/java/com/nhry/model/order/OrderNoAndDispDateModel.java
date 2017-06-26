package com.nhry.model.order;

import java.util.Date;

/**
 * Created by cbz on 4/14/2017.
 */
public class OrderNoAndDispDateModel {
    String orderNo;
    Date disDate;
    String branchNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getDisDate() {
        return disDate;
    }

    public void setDisDate(Date disDate) {
        this.disDate = disDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
