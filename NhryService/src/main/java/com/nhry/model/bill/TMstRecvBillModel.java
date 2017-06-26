package com.nhry.model.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/23.
 */
public class TMstRecvBillModel implements Serializable {
    private String receiptNo;
    private Date receiptDate;
    private String orderNo;
    private String paymentType;
    private String status;
    private Integer amt;
    private String vipCustNo;
    private Date startTime;
    private Date endTime;
    private String paymentYearMonth;
    private String recvEmp;
    private String recvEmpName;
    private Date createAt;
    private  String createBy;
    private String createByTxt;
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPaymentYearMonth() {
        return paymentYearMonth;
    }

    public void setPaymentYearMonth(String paymentYearMonth) {
        this.paymentYearMonth = paymentYearMonth;
    }

    public String getRecvEmp() {
        return recvEmp;
    }

    public void setRecvEmp(String recvEmp) {
        this.recvEmp = recvEmp;
    }

    public String getRecvEmpName() {
        return recvEmpName;
    }

    public void setRecvEmpName(String recvEmpName) {
        this.recvEmpName = recvEmpName;
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
        this.createBy = createBy;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
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
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt;
    }
}
