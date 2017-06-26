package com.nhry.data.order.domain;

import java.util.Date;

public class TPreOrderRecord {
    private String id;

    private String opType;

    private String opTxt;

    private String opUser;

    private String opUserTxt;

    private Date opTime;

    private String orderNo;

    private Date orderDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public String getOpTxt() {
        return opTxt;
    }

    public void setOpTxt(String opTxt) {
        this.opTxt = opTxt == null ? null : opTxt.trim();
    }

    public String getOpUser() {
        return opUser;
    }

    public void setOpUser(String opUser) {
        this.opUser = opUser == null ? null : opUser.trim();
    }

    public String getOpUserTxt() {
        return opUserTxt;
    }

    public void setOpUserTxt(String opUserTxt) {
        this.opUserTxt = opUserTxt == null ? null : opUserTxt.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

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
}