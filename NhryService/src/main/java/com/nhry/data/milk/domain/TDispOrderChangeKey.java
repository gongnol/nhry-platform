package com.nhry.data.milk.domain;

import java.util.Date;

public class TDispOrderChangeKey {
    private String orderNo;

    private Date orderDate;

    private String orgOrderNo;

    private String orgItemNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrgOrderNo() {
        return orgOrderNo;
    }

    public void setOrgOrderNo(String orgOrderNo) {
        this.orgOrderNo = orgOrderNo == null ? null : orgOrderNo.trim();
    }

    public String getOrgItemNo() {
        return orgItemNo;
    }

    public void setOrgItemNo(String orgItemNo) {
        this.orgItemNo = orgItemNo == null ? null : orgItemNo.trim();
    }
}