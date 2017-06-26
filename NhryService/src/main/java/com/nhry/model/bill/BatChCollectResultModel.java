package com.nhry.model.bill;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/9/1.
 */
public class BatChCollectResultModel {
    private BigDecimal totalPayment;
    private BigDecimal totalAcctAmt;
    private BigDecimal totalAmt;

    public BigDecimal getTotalAcctAmt() {
        return totalAcctAmt;
    }

    public void setTotalAcctAmt(BigDecimal totalAcctAmt) {
        this.totalAcctAmt = totalAcctAmt;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }
}
