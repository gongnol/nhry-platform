package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TMdMaraEx implements Serializable{
    private String matnr;

    private String matnrTxt;

    private String salesFlag;

    private String shortTxt;

    private Integer preDays;

    private String botType;

    private String retBotFlag;
    
    private String salesOrg;
    
    private BigDecimal rate;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

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
        this.matnrTxt = matnrTxt;
    }

    public String getSalesFlag() {
        return salesFlag;
    }

    public void setSalesFlag(String salesFlag) {
        this.salesFlag = salesFlag == null ? null : salesFlag.trim();
    }

    public String getShortTxt() {
        return shortTxt;
    }

    public void setShortTxt(String shortTxt) {
        this.shortTxt = shortTxt == null ? null : shortTxt.trim();
    }

    public Integer getPreDays() {
        return preDays;
    }

    public void setPreDays(Integer preDays) {
        this.preDays = preDays;
    }

    public String getBotType() {
        return botType;
    }

    public void setBotType(String botType) {
        this.botType = botType == null ? null : botType.trim();
    }

    public String getRetBotFlag() {
        return retBotFlag;
    }

    public void setRetBotFlag(String retBotFlag) {
        this.retBotFlag = retBotFlag == null ? null : retBotFlag.trim();
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

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}