package com.nhry.data.stock.domain;

import com.nhry.data.basic.domain.TMdMara;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class TSsmGiOrderItem extends TSsmGiOrderItemKey {
    
    private String matnr;

    private String unit;

    private BigDecimal qty;

    private BigDecimal confirmQty;

    private BigDecimal factoryPrice;

    private String itemType;

    private String remark;

    private String matnrTxt;

    private String baseUnit;

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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(BigDecimal confirmQty) {
        this.confirmQty = confirmQty;
    }

    public BigDecimal getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(BigDecimal factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }
}