package com.nhry.data.milk.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TDispOrderItem extends TDispOrderItemKey {
    private String matnr;					//配送产品
    
    private String confirmMatnr;			//实际配送产品

    private BigDecimal confirmQty;			//实际配送数量

    private BigDecimal qty;					//配送数量

    private String unit;					//规格

    private BigDecimal price;				//价格

    private BigDecimal amt;					//价值

	private BigDecimal remainAmt;			//记录日订单 剩余金额

    private BigDecimal confirmAmt;			//实际配送总价值  实际配送数量 * 实际配送产品价格

    private String status;					//状态

    private String pickupOrderNo;

    private String pickupOrderItemNo;

    private String reason;				//原因  10 换货，20 缺货，30 质量问题，40 损毁，50 拒收，60 拒收复送

    private Date redispDate;

    private BigDecimal wholesalePrice;

    private BigDecimal wholesalePrice1;

    private String addressNo;			//地址编号

    private String orgItemNo;			// 订单行项目号
    
    private String orgOrderNo;			// 订单号
    
    private String reachTimeType;       //上下午
    
    private String dispEmpNo;
    
    private String addressTxt;			//地址
    
    private String matnrTxt;			//产品名称
    
    private String custName;			//订户名
    
    private String custTel;				//订户电话
    
    private Integer retQtyB;			//应回瓶  大口瓶数量
    
    private Integer retQtyS;     		//应回瓶  小口瓶数量
    
    private Integer retQtyM;			//应回瓶  中口瓶数量
    
    private String replaceReason;		//原因为换货  的二级原因 10 公司原因，20质量原因，30运输损坏

	private BigDecimal priceDeliver;  //配送费

	private BigDecimal priceHome;  //到户费

	private BigDecimal priceNetValue; //净值

	public String getMemoTxt() {
		return memoTxt;
	}

	public void setMemoTxt(String memoTxt) {
		this.memoTxt = memoTxt;
	}

	private String giftFlag;

	private Integer totalQty;

	private String memoTxt;

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	public BigDecimal getRemainAmt() {
		return remainAmt;
	}

	public void setRemainAmt(BigDecimal remainAmt) {
		this.remainAmt = remainAmt;
	}

	public String getGiftFlag()
	{
		return giftFlag;
	}

	public void setGiftFlag(String giftFlag)
	{
		this.giftFlag = giftFlag;
	}

	public String getReplaceReason()
	{
		return replaceReason;
	}

	public void setReplaceReason(String replaceReason)
	{
		this.replaceReason = replaceReason;
	}

	public Integer getRetQtyB()
	{
		return retQtyB;
	}

	public void setRetQtyB(Integer retQtyB)
	{
		this.retQtyB = retQtyB;
	}

	public Integer getRetQtyS()
	{
		return retQtyS;
	}

	public void setRetQtyS(Integer retQtyS)
	{
		this.retQtyS = retQtyS;
	}

	public Integer getRetQtyM()
	{
		return retQtyM;
	}

	public void setRetQtyM(Integer retQtyM)
	{
		this.retQtyM = retQtyM;
	}

	public String getCustTel()
	{
		return custTel;
	}

	public void setCustTel(String custTel)
	{
		this.custTel = custTel;
	}

	public String getCustName()
	{
		return custName;
	}

	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	public String getAddressTxt()
	{
		return addressTxt;
	}

	public void setAddressTxt(String addressTxt)
	{
		this.addressTxt = addressTxt;
	}

	public String getMatnrTxt()
	{
		return matnrTxt;
	}

	public void setMatnrTxt(String matnrTxt)
	{
		this.matnrTxt = matnrTxt;
	}
    
    public String getDispEmpNo()
	{
		return dispEmpNo;
	}

	public void setDispEmpNo(String dispEmpNo)
	{
		this.dispEmpNo = dispEmpNo;
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

	public BigDecimal getPriceDeliver() {
		return priceDeliver;
	}

	public void setPriceDeliver(BigDecimal priceDeliver) {
		this.priceDeliver = priceDeliver;
	}

	public BigDecimal getPriceHome() {
		return priceHome;
	}

	public void setPriceHome(BigDecimal priceHome) {
		this.priceHome = priceHome;
	}

	public BigDecimal getPriceNetValue() {
		return priceNetValue;
	}

	public void setPriceNetValue(BigDecimal priceNetValue) {
		this.priceNetValue = priceNetValue;
	}
}