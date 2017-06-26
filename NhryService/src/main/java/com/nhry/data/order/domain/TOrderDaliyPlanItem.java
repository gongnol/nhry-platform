package com.nhry.data.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TOrderDaliyPlanItem extends TOrderDaliyPlanItemKey {
    private Date dispDate;                  //配送日期
    
    private String dispDateStr;             //配送日期 字符串类型

	 private String reachTime;

    private String reachTimeType;           //上下午，10 上午，20下午

    private String matnr;                   //产品编码

    private String confirmMatnr;            //确认产品编码
    private String matnrTxt;                //产品名称
    private String shortTxt;                //产品名称 简称

    private String unit;                    //规格

    private Integer qty;                    //数量

    private BigDecimal price;               //价格

    private BigDecimal amt;                 //价值  数量*价格

    private BigDecimal remainAmt;           //剩余金额

    private String status;                  //状态  10 在订，20 完结，30 停订

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;


    private String lastModifiedByTxt;
    
    private Integer giftQty;
    
    private String promotionFlag;

    private String weekly;

    private BigDecimal balanceAmt;  //差额

    private BigDecimal priceDeliver;  //配送费

    private BigDecimal priceHome;  //到户费

    private BigDecimal priceNetValue; //净值


    public String getWeekly() {
        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }
    public String getShortTxt() {
        return shortTxt;
    }

    public void setShortTxt(String shortTxt) {
        this.shortTxt = shortTxt;
    }

    public String getConfirmMatnr() {
        return confirmMatnr;
    }

    public void setConfirmMatnr(String confirmMatnr) {
        this.confirmMatnr = confirmMatnr;
    }

    public Integer getGiftQty()
	{
		return giftQty;
	}

	public void setGiftQty(Integer giftQty)
	{
		this.giftQty = giftQty;
	}

	public String getPromotionFlag()
	{
		return promotionFlag;
	}

	public void setPromotionFlag(String promotionFlag)
	{
		this.promotionFlag = promotionFlag;
	}

	public String getDispDateStr()
 	 {
 		  return dispDateStr;
 	 }

 	 public void setDispDateStr(String dispDateStr)
 	 {
 		  this.dispDateStr = dispDateStr;
 	 }
 	 
 	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime == null ? null : reachTime.trim();
    }

    public String getReachTimeType() {
        return reachTimeType;
    }

    public void setReachTimeType(String reachTimeType) {
        this.reachTimeType = reachTimeType == null ? null : reachTimeType.trim();
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt  == null ? null : matnrTxt.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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

    public BigDecimal getRemainAmt() {
        return remainAmt;
    }

    public void setRemainAmt(BigDecimal remainAmt) {
        this.remainAmt = remainAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
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