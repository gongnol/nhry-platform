package com.nhry.data.milktrans.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TssmMilkmanAmts extends TssmMilkmanAmtsKey {
    private BigDecimal reAmt;

    private BigDecimal dayAmt;

    private BigDecimal dayBillAmt;

    private BigDecimal totalAmt;

    private Date createAt;

    private Date lastModified;

    private String lastModifiedBy;

    public BigDecimal getReAmt() {
        return reAmt;
    }

    public void setReAmt(BigDecimal reAmt) {
        this.reAmt = reAmt;
    }

    public BigDecimal getDayAmt() {
        return dayAmt;
    }

    public void setDayAmt(BigDecimal dayAmt) {
        this.dayAmt = dayAmt;
    }

    public BigDecimal getDayBillAmt() {
        return dayBillAmt;
    }

    public void setDayBillAmt(BigDecimal dayBillAmt) {
        this.dayBillAmt = dayBillAmt;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}