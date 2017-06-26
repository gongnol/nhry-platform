package com.nhry.model.stock;

import java.util.Date;

/**
 * Created by cbz on 7/25/2016.
 */
public class GiOrderModel {
    String branchNo;
    Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
