package com.nhry.model.milktrans;

import java.math.BigDecimal;
import java.util.Date;

public class UnDeliverProductModel {
    private String branchNo;

    private String empNo;

    private String orderNo;

    private Date orderDate;

    private String matnr;
    
    private String confirmMatnr;

    private BigDecimal confirmQty;

    private BigDecimal qty;

    private String unit;

    private BigDecimal price;

    private BigDecimal amt;

    private BigDecimal confirmAmt;

    private String status;

    private String pickupOrderNo;

    private String pickupOrderItemNo;

    private String reason;

    private Date redispDate;

    private BigDecimal wholesalePrice;

    private BigDecimal wholesalePrice1;

    private String addressNo;
    
    private String orgItemNo;
    
    private String orgOrderNo;
    
    private String reachTimeType;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getReachTimeType()
	{
		return reachTimeType;
	}

	public void setReachTimeType(String reachTimeType)
	{
		this.reachTimeType = reachTimeType;
	}

	public String getOrgItemNo()
	{
		return orgItemNo;
	}

	public void setOrgItemNo(String orgItemNo)
	{
		this.orgItemNo = orgItemNo == null ? null : orgItemNo.trim();
	}

	public String getOrgOrderNo()
	{
		return orgOrderNo;
	}

	public void setOrgOrderNo(String orgOrderNo)
	{
		this.orgOrderNo = orgOrderNo == null ? null : orgOrderNo.trim();
	}

	public String getAddressNo()
	{
		return addressNo;
	}

	public void setAddressNo(String addressNo)
	{
		this.addressNo = addressNo == null ? null : addressNo.trim();
	}

	public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public String getConfirmMatnr()
	 {
		return confirmMatnr;
	 }

	public void setConfirmMatnr(String confirmMatnr)
	{
		this.confirmMatnr = confirmMatnr == null ? null : confirmMatnr.trim();
	}

	public BigDecimal getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(BigDecimal confirmQty) {
        this.confirmQty = confirmQty;
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

    public BigDecimal getConfirmAmt() {
        return confirmAmt;
    }

    public void setConfirmAmt(BigDecimal confirmAmt) {
        this.confirmAmt = confirmAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPickupOrderNo() {
        return pickupOrderNo;
    }

    public void setPickupOrderNo(String pickupOrderNo) {
        this.pickupOrderNo = pickupOrderNo == null ? null : pickupOrderNo.trim();
    }

    public String getPickupOrderItemNo() {
        return pickupOrderItemNo;
    }

    public void setPickupOrderItemNo(String pickupOrderItemNo) {
        this.pickupOrderItemNo = pickupOrderItemNo == null ? null : pickupOrderItemNo.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getRedispDate() {
        return redispDate;
    }

    public void setRedispDate(Date redispDate) {
        this.redispDate = redispDate;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getWholesalePrice1() {
        return wholesalePrice1;
    }

    public void setWholesalePrice1(BigDecimal wholesalePrice1) {
        this.wholesalePrice1 = wholesalePrice1;
    }
}