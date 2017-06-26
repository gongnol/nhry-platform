package com.nhry.data.milktrans.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cbz on 12/26/2016.
 */
public class TSsmRedateByTrade implements Serializable{
    String orderNo;
    String branchNo;
    String salesOrg;
    String promNo;
    Date orderDate;
    String matnr;
    BigDecimal redate;
    String crmNo;
    String dhNo;
    Date createDate;
    Date lastModified;
    String werks;
    String lgort;
    String dealerNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public BigDecimal getRedate() {
        return redate;
    }

    public void setRedate(BigDecimal redate) {
        this.redate = redate;
    }

    public String getCrmNo() {
        return crmNo;
    }

    public void setCrmNo(String crmNo) {
        this.crmNo = crmNo;
    }

    public String getDhNo() {
        return dhNo;
    }

    public void setDhNo(String dhNo) {
        this.dhNo = dhNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }
}
