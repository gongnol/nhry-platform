package com.nhry.data.stock.domain;

import java.math.BigDecimal;

public class TSsmVoucherItem extends TSsmVoucherItemKey {
    private String revertVoucherItemNo;

    private String branchNo;

    private String matnr;

    private String werks;

    private String lgort;

    private String unit;

    private BigDecimal qty;

    private String inOutType;

    private String bwart;

    private String chgReason;

    private String costCenter;

    private String refOrderNo;

    private String refOrderItemNo;

    public String getRevertVoucherItemNo() {
        return revertVoucherItemNo;
    }

    public void setRevertVoucherItemNo(String revertVoucherItemNo) {
        this.revertVoucherItemNo = revertVoucherItemNo == null ? null : revertVoucherItemNo.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks == null ? null : werks.trim();
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort == null ? null : lgort.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType == null ? null : inOutType.trim();
    }

    public String getBwart() {
        return bwart;
    }

    public void setBwart(String bwart) {
        this.bwart = bwart == null ? null : bwart.trim();
    }

    public String getChgReason() {
        return chgReason;
    }

    public void setChgReason(String chgReason) {
        this.chgReason = chgReason == null ? null : chgReason.trim();
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter == null ? null : costCenter.trim();
    }

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo == null ? null : refOrderNo.trim();
    }

    public String getRefOrderItemNo() {
        return refOrderItemNo;
    }

    public void setRefOrderItemNo(String refOrderItemNo) {
        this.refOrderItemNo = refOrderItemNo == null ? null : refOrderItemNo.trim();
    }
}