package com.nhry.data.basic.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TMdPriceYearcard {
    private String id;

    private String matnr;

    private String shortTxt;

    private String matnrTxt;

    private String salesOrg;

    private String secCateName;

    private BigDecimal priceAgree;

    private BigDecimal priceDeliver;

    private Date startDate;

    private Date endDate;

    private String status;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private String isShow;

    private BigDecimal priceHome;

    private BigDecimal priceNetValue;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private BigDecimal oldPrice;

    private BigDecimal oldPriceDeliver;

    private BigDecimal oldPriceHome;

    private BigDecimal oldPriceNetValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public BigDecimal getPriceAgree() {
        return priceAgree;
    }

    public void setPriceAgree(BigDecimal priceAgree) {
        this.priceAgree = priceAgree;
    }

    public BigDecimal getPriceDeliver() {
        return priceDeliver;
    }

    public void setPriceDeliver(BigDecimal priceDeliver) {
        this.priceDeliver = priceDeliver;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
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

    public String getShortTxt() {
        return shortTxt;
    }

    public void setShortTxt(String shortTxt) {
        this.shortTxt = shortTxt;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getSecCateName() {
        return secCateName;
    }

    public void setSecCateName(String secCateName) {
        this.secCateName = secCateName;
    }


    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getOldPriceDeliver() {
        return oldPriceDeliver;
    }

    public void setOldPriceDeliver(BigDecimal oldPriceDeliver) {
        this.oldPriceDeliver = oldPriceDeliver;
    }

    public BigDecimal getOldPriceHome() {
        return oldPriceHome;
    }

    public void setOldPriceHome(BigDecimal oldPriceHome) {
        this.oldPriceHome = oldPriceHome;
    }

    public BigDecimal getOldPriceNetValue() {
        return oldPriceNetValue;
    }

    public void setOldPriceNetValue(BigDecimal oldPriceNetValue) {
        this.oldPriceNetValue = oldPriceNetValue;
    }
}