package com.nhry.data.stock.domain;

import java.util.Date;

public class TSsmVoucher extends TSsmVoucherKey {
    private String branchNo;

    private String orderType;

    private String orderNo;

    private String revertVoucherNo;

    private String voucherType;

    private String revertStatus;

    private Date acctDate;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String sapAcctStatus;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getRevertVoucherNo() {
        return revertVoucherNo;
    }

    public void setRevertVoucherNo(String revertVoucherNo) {
        this.revertVoucherNo = revertVoucherNo == null ? null : revertVoucherNo.trim();
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType == null ? null : voucherType.trim();
    }

    public String getRevertStatus() {
        return revertStatus;
    }

    public void setRevertStatus(String revertStatus) {
        this.revertStatus = revertStatus == null ? null : revertStatus.trim();
    }

    public Date getAcctDate() {
        return acctDate;
    }

    public void setAcctDate(Date acctDate) {
        this.acctDate = acctDate;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt == null ? null : createByTxt.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt == null ? null : lastModifiedByTxt.trim();
    }

    public String getSapAcctStatus() {
        return sapAcctStatus;
    }

    public void setSapAcctStatus(String sapAcctStatus) {
        this.sapAcctStatus = sapAcctStatus == null ? null : sapAcctStatus.trim();
    }
}