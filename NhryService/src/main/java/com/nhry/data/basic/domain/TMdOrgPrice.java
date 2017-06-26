package com.nhry.data.basic.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TMdOrgPrice {
    private String id;

    private String matnr;

    private String salesOrg;

    private String orgId;

    private BigDecimal priceAgree;  //协议价

    private BigDecimal priceDeliver;  //配送费

    private Date startDate;

    private Date endDate;

    private String status;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private String isShow;

    private String shortTxt;

    private String matnrTxt;

    private String secCateName;

    private BigDecimal oldPrice;

    private BigDecimal priceHome;  //到户费

    private BigDecimal priceNetValue; //净值

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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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