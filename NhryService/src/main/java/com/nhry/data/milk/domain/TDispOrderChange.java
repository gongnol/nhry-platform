package com.nhry.data.milk.domain;

import java.math.BigDecimal;

public class TDispOrderChange extends TDispOrderChangeKey {
    private String yestodayMatnr;

    private String todayMatnr;

    private BigDecimal yestodayQty;

    private BigDecimal todayQty;

    private String yestodayReachTimeType;

    private String todayReachTimeType;

    private String reason;

    private String milkmemberNo;

    private String addressNo;
    
    private String custTel;

    private String empNo;

    public String getCustTel()
	{
		return custTel;
	}

	public void setCustTel(String custTel)
	{
		this.custTel = custTel;
	}

	public String getYestodayMatnr() {
        return yestodayMatnr;
    }

    public void setYestodayMatnr(String yestodayMatnr) {
        this.yestodayMatnr = yestodayMatnr == null ? null : yestodayMatnr.trim();
    }

    public String getTodayMatnr() {
        return todayMatnr;
    }

    public void setTodayMatnr(String todayMatnr) {
        this.todayMatnr = todayMatnr == null ? null : todayMatnr.trim();
    }

    public BigDecimal getYestodayQty() {
        return yestodayQty;
    }

    public void setYestodayQty(BigDecimal yestodayQty) {
        this.yestodayQty = yestodayQty;
    }

    public BigDecimal getTodayQty() {
        return todayQty;
    }

    public void setTodayQty(BigDecimal todayQty) {
        this.todayQty = todayQty;
    }

    public String getYestodayReachTimeType() {
        return yestodayReachTimeType;
    }

    public void setYestodayReachTimeType(String yestodayReachTimeType) {
        this.yestodayReachTimeType = yestodayReachTimeType == null ? null : yestodayReachTimeType.trim();
    }

    public String getTodayReachTimeType() {
        return todayReachTimeType;
    }

    public void setTodayReachTimeType(String todayReachTimeType) {
   	 this.todayReachTimeType = todayReachTimeType == null ? null : todayReachTimeType.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getMilkmemberNo() {
        return milkmemberNo;
    }

    public void setMilkmemberNo(String milkmemberNo) {
        this.milkmemberNo = milkmemberNo == null ? null : milkmemberNo.trim();
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo == null ? null : addressNo.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }
}