package com.nhry.model.milktrans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/24.
 */
public class RequireOrderSearch  implements Serializable {
    private String branchNo;
    private Date requiredDate;
    private Date orderDate;
    private int preDays;
    private String salesOrg;
    private Date firstDay;
    private Date secondDay;
    private String promotion;
    private String reqOrderNo;
    private String preorderSource;

    public String getReqOrderNo() {
        return reqOrderNo;
    }

    public void setReqOrderNo(String reqOrderNo) {
        this.reqOrderNo = reqOrderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    public Date getSecondDay() {
        return secondDay;
    }

    public void setSecondDay(Date secondDay) {
        this.secondDay = secondDay;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public int getPreDays() {
        return preDays;
    }

    public void setPreDays(int preDays) {
        this.preDays = preDays;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getPreorderSource() {
        return preorderSource;
    }

    public void setPreorderSource(String preorderSource) {
        this.preorderSource = preorderSource;
    }
}

