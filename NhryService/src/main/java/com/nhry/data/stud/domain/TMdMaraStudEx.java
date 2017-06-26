package com.nhry.data.stud.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TMdMaraStudEx extends TMdMaraStudExKey {
    private String salesFlag;

    private String shortTxt;

    private Integer preDays;

    private String botType;

    private String retBotFlag;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String werks;

    private String reslo;

    private BigDecimal rate;

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

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks == null ? null : werks.trim();
    }

    public String getReslo() {
        return reslo;
    }

    public void setReslo(String reslo) {
        this.reslo = reslo == null ? null : reslo.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}