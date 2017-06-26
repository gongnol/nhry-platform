package com.nhry.data.order.domain;

import java.math.BigDecimal;
import java.util.Date;


public class TPlanOrderItem {
    private String itemNo;                  //行号 由订单号orderNo + refItemNo(0,1,2,3,4...)组成

    private String orderNo;                 //订单号

    private Date orderDate;                 //订单创建日期

    private String refItemNo;               //行数 0,1,2,3...

    private String newRowFlag;              //新加行标识
    
    private String newFlag;

    private String matnr;                   //产品编码

    private String matnrTxt;                //产品名称
    
    private String shortTxt;                 //产品简称
    
    private String unit;                    //产品规格

    private Integer qty;                    //数量

    private BigDecimal salesPrice;          //销售价格

    private String ruleType;                //配送规律，10 按周期配送 ，20按星期配送

    private Integer dispDays;               //配送总天数

    private Integer gapDays;                //如果是按周期配送，记录间隔天数

    private String ruleTxt;                 //如果是按星期配送 记录星期数，比如 周一、周三送 记录1,3

    private String reachTime;
    
    private String reachTimeType;           //上下午，10 上午，20 下午

    private Date startDispDate;             //产品开始配送日期
    
    private Date stopStartDate;             //产品截止配送日期
    
    private Date stopEndDate;

    private Date endDispDate;
    
    private String startDispDateStr;

    private String endDispDateStr;

    private String promotion;               //促销编号 记录的是单品促销 促销编号

    private String promItemNo;              //促销编号行号 记录的是单品促销 促销编号行号

    private Integer promDays;

    private String status;                  //状态

    private Integer buyQty;                  //购买正品数量

    private Integer giftQty;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;
    
    private String giftMatnr;
    
    private String giftUnit;
    
    private Integer dispTotal;              //配送总数
    
    private BigDecimal entryTotal;
    
    private Integer yGrowth;
    
    private Integer yFresh;
    
    private boolean isModified;

    private String promotionDetail;         //促销描述
//    private String isDeletedFlag;
    
//    private String deletePlansFlag;
    
    private String isStop;              //行项目停订标识，Y 不参与续订
    
    private String toStop;

    private  int rowNum;
    /**
     * 电商订单推送时使用
     */
    private BigDecimal onlineInitAmt;
    /**
     * 电商订单推送时使用
     */
    private BigDecimal itemamount;
    /**
     * 电商行项目订单产生的余额金额
     */
    private BigDecimal balanceAmt;

    private String balanceFlag;

    private BigDecimal priceDeliver;  //配送费

    private BigDecimal priceHome;  //到户费

    private BigDecimal priceNetValue; //净值

    public String getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getPromItemNo() {
        return promItemNo;
    }

    public void setPromItemNo(String promItemNo) {
        this.promItemNo = promItemNo;
    }

    public String getToStop()
	{
		return toStop;
	}

	public void setToStop(String toStop)
	{
		this.toStop = toStop;
	}

	public boolean isModified()
	{
		return isModified;
	}

	public void setModified(boolean isModified)
	{
		this.isModified = isModified;
	}

	public String getShortTxt()
	{
		return shortTxt;
	}

	public void setShortTxt(String shortTxt)
	{
		this.shortTxt = shortTxt;
	}

	public Date getStopStartDate()
	{
		return stopStartDate;
	}

	public void setStopStartDate(Date stopStartDate)
	{
		this.stopStartDate = stopStartDate;
	}

	public Date getStopEndDate()
	{
		return stopEndDate;
	}

	public void setStopEndDate(Date stopEndDate)
	{
		this.stopEndDate = stopEndDate;
	}

	public String getIsStop()
	{
		return isStop;
	}

	public void setIsStop(String isStop)
	{
		this.isStop = isStop;
	}

	public String getNewFlag()
	{
		return newFlag;
	}

	public void setNewFlag(String newFlag)
	{
		this.newFlag = newFlag;
	}

	public Integer getyGrowth()
	{
		return yGrowth;
	}

	public void setyGrowth(Integer yGrowth)
	{
		this.yGrowth = yGrowth;
	}

	public Integer getyFresh()
	{
		return yFresh;
	}

	public void setyFresh(Integer yFresh)
	{
		this.yFresh = yFresh;
	}

	public BigDecimal getEntryTotal()
	{
		return entryTotal;
	}

	public void setEntryTotal(BigDecimal entryTotal)
	{
		this.entryTotal = entryTotal;
	}

	public Integer getDispTotal()
	{
		return dispTotal;
	}

	public void setDispTotal(Integer dispTotal)
	{
		this.dispTotal = dispTotal;
	}

	public String getGiftUnit()
	{
		return giftUnit;
	}

	public void setGiftUnit(String giftUnit)
	{
		this.giftUnit = giftUnit;
	}

	public String getGiftMatnr()
	{
		return giftMatnr;
	}

	public void setGiftMatnr(String giftMatnr)
	{
		this.giftMatnr = giftMatnr;
	}

	public String getMatnrTxt()
	{
		return matnrTxt;
	}

	public void setMatnrTxt(String matnrTxt)
	{
		this.matnrTxt = matnrTxt;
	}

	public String getStartDispDateStr() {
       return startDispDateStr;
    }

    public void setStartDispDateStr(String startDispDateStr) {
       this.startDispDateStr = startDispDateStr == null ? null : startDispDateStr.trim();
    }
    
    public String getEndDispDateStr() {
       return endDispDateStr;
    }

    public void setEndDispDateStr(String endDispDateStr) {
       this.endDispDateStr = endDispDateStr == null ? null : endDispDateStr.trim();
    }
    
    public String getReachTime() {
       return reachTime;
    }

    public void setReachTime(String reachTime) {
       this.reachTime = reachTime == null ? null : reachTime.trim();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRefItemNo() {
        return refItemNo;
    }

    public void setRefItemNo(String refItemNo) {
        this.refItemNo = refItemNo == null ? null : refItemNo.trim();
    }

    public String getNewRowFlag() {
        return newRowFlag;
    }

    public void setNewRowFlag(String newRowFlag) {
        this.newRowFlag = newRowFlag == null ? null : newRowFlag.trim();
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
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

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public Integer getDispDays() {
        return dispDays;
    }

    public void setDispDays(Integer dispDays) {
        this.dispDays = dispDays;
    }

    public Integer getGapDays() {
        return gapDays;
    }

    public void setGapDays(Integer gapDays) {
        this.gapDays = gapDays;
    }

    public String getRuleTxt() {
        return ruleTxt;
    }

    public void setRuleTxt(String ruleTxt) {
        this.ruleTxt = ruleTxt == null ? null : ruleTxt.trim();
    }

    public String getReachTimeType() {
        return reachTimeType;
    }

    public void setReachTimeType(String reachTimeType) {
        this.reachTimeType = reachTimeType == null ? null : reachTimeType.trim();
    }
    
    public Date getStartDispDate() {
        return startDispDate;
    }

    public void setStartDispDate(Date startDispDate) {
        this.startDispDate = startDispDate;
    }
    public Date getEndDispDate() {
        return endDispDate;
    }

    public void setEndDispDate(Date endDispDate) {
        this.endDispDate = endDispDate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Integer getPromDays() {
        return promDays;
    }

    public void setPromDays(Integer promDays) {
        this.promDays = promDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getBuyQty() {
        return buyQty;
    }

    public void setBuyQty(Integer buyQty) {
        this.buyQty = buyQty;
    }

    public Integer getGiftQty() {
        return giftQty;
    }

    public void setGiftQty(Integer giftQty) {
        this.giftQty = giftQty;
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

    public BigDecimal getOnlineInitAmt() {
        return onlineInitAmt;
    }

    public void setOnlineInitAmt(BigDecimal onlineInitAmt) {
        this.onlineInitAmt = onlineInitAmt;
    }

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public BigDecimal getItemamount() {
        return itemamount;
    }

    public void setItemamount(BigDecimal itemamount) {
        this.itemamount = itemamount;
    }

    public String getBalanceFlag() {
        return balanceFlag;
    }

    public void setBalanceFlag(String balanceFlag) {
        this.balanceFlag = balanceFlag;
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