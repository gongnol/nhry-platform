package com.nhry.data.order.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TPromotion {
    private String promNo;    //促销号

    private String promDes;

    private String promType;

    private String promSubType; //类型 Z008 单品满赠，Z015单品满减，Z016 整单满减 Z017年卡

    private String salesOrg;      //销售组织

    private String salesDist;
    
    private String branchNo;       //奶站编号

    private String customerType;

    private String promStat;

    private Date planStartTime;  // 下单开始日期

    private Date planStopTime;  // 下单截止日期

    private Date buyStartTime;  // 配送开始日期

    private Date buyStopTime;  // 配送截止日期

    private BigDecimal buyAmt;

    private BigDecimal giftAmt;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;
    
    private String orgMatnr;        //参加促销产品编号
    
    private BigDecimal orgQty;      //参加促销最少数量
    
    private String giftMatnr;       //赠品编号

    private String giftUnit;        //赠品规格
    
    private BigDecimal giftQty;     //赠品数量

    private BigDecimal discountAmt;   //优惠金额

    private BigDecimal lowAmt;        //最低消费金额

    private String itemNo;            //促销行号

    private String yearType;
    
    private String promSubTypeName;
    

    public String getPromSubTypeName() {
		return promSubTypeName;
	}

	public void setPromSubTypeName(String promSubTypeName) {
		this.promSubTypeName = promSubTypeName;
	}

	public String getYearType() {
        return yearType;
    }

    public void setYearType(String yearType) {
        this.yearType = yearType;
    }

    public String getGiftUnit()
	{
		return giftUnit;
	}

	public void setGiftUnit(String giftUnit)
	{
		this.giftUnit = giftUnit;
	}

	public String getBranchNo()
	{
		return branchNo;
	}

	public void setBranchNo(String branchNo)
	{
		this.branchNo = branchNo;
	}

	public BigDecimal getOrgQty()
	{
		return orgQty;
	}

	public void setOrgQty(BigDecimal orgQty)
	{
		this.orgQty = orgQty;
	}

	public BigDecimal getGiftQty()
	{
		return giftQty;
	}

	public void setGiftQty(BigDecimal giftQty)
	{
		this.giftQty = giftQty;
	}

	public String getOrgMatnr()
	{
		return orgMatnr;
	}

	public void setOrgMatnr(String orgMatnr)
	{
		this.orgMatnr = orgMatnr;
	}

	public String getGiftMatnr()
	{
		return giftMatnr;
	}

	public void setGiftMatnr(String giftMatnr)
	{
		this.giftMatnr = giftMatnr;
	}

	public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo == null ? null : promNo.trim();
    }

    public String getPromDes() {
        return promDes;
    }

    public void setPromDes(String promDes) {
        this.promDes = promDes == null ? null : promDes.trim();
    }

    public String getPromType() {
        return promType;
    }

    public void setPromType(String promType) {
        this.promType = promType == null ? null : promType.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public String getSalesDist() {
        return salesDist;
    }

    public void setSalesDist(String salesDist) {
        this.salesDist = salesDist == null ? null : salesDist.trim();
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public String getPromStat() {
        return promStat;
    }

    public void setPromStat(String promStat) {
        this.promStat = promStat == null ? null : promStat.trim();
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanStopTime() {
        return planStopTime;
    }

    public void setPlanStopTime(Date planStopTime) {
        this.planStopTime = planStopTime;
    }

    public Date getBuyStartTime() {
        return buyStartTime;
    }

    public void setBuyStartTime(Date buyStartTime) {
        this.buyStartTime = buyStartTime;
    }

    public Date getBuyStopTime() {
        return buyStopTime;
    }

    public void setBuyStopTime(Date buyStopTime) {
        this.buyStopTime = buyStopTime;
    }

    public BigDecimal getBuyAmt() {
        return buyAmt;
    }

    public void setBuyAmt(BigDecimal buyAmt) {
        this.buyAmt = buyAmt;
    }

    public BigDecimal getGiftAmt() {
        return giftAmt;
    }

    public void setGiftAmt(BigDecimal giftAmt) {
        this.giftAmt = giftAmt;
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

    public String getPromSubType() {
        return promSubType;
    }

    public void setPromSubType(String promSubType) {
        this.promSubType = promSubType;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getLowAmt() {
        return lowAmt;
    }

    public void setLowAmt(BigDecimal lowAmt) {
        this.lowAmt = lowAmt;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
}