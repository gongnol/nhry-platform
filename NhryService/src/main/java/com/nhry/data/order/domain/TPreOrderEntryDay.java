package com.nhry.data.order.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TPreOrderEntryDay {
    private String dayNo;

    private String orderNo;

    private String entryNo;

    private String maraNo;

    private Date excuDate;

    private String status;

    private BigDecimal qty;

    private String unit;

    private BigDecimal price;

    private BigDecimal amt;

    private BigDecimal amountRemain;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    public String getDayNo() {
        return dayNo;
    }

    public void setDayNo(String dayNo) {
        this.dayNo = dayNo == null ? null : dayNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(String entryNo) {
        this.entryNo = entryNo == null ? null : entryNo.trim();
    }

    public String getMaraNo() {
        return maraNo;
    }

    public void setMaraNo(String maraNo) {
        this.maraNo = maraNo == null ? null : maraNo.trim();
    }

    public Date getExcuDate() {
        return excuDate;
    }

    public void setExcuDate(Date excuDate) {
        this.excuDate = excuDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getAmountRemain() {
        return amountRemain;
    }

    public void setAmountRemain(BigDecimal amountRemain) {
        this.amountRemain = amountRemain;
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
}