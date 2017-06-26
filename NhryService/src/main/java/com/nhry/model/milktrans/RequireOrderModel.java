package com.nhry.model.milktrans;

import com.wordnik.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/6/21.
 */
@ApiModel(value = "ReturnOrderModel", description = "要货计划对象")
public class RequireOrderModel implements Serializable {
    private String branchNo;
    private String orderNo;
    private Date requiredDate;
    private String status;
    private Date orderDate;
    private String voucherNo;
    private Date createAt;
    private Date lastModified;
    List<OrderRequireItem> entries;

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public List<OrderRequireItem> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderRequireItem> entries) {
        this.entries = entries;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}