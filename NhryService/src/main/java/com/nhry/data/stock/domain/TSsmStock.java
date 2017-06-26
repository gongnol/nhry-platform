package com.nhry.data.stock.domain;

import java.math.BigDecimal;

public class TSsmStock extends TSsmStockKey {
    private String unit;

    private BigDecimal qty;

    private String zbotCodeName; //包装类型

    private String specName;

    private String secCateName;

    public String getSpecUnit() {
        return specUnit;
    }

    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit;
    }

    private String specUnit;

    private String matnrTxt;

    private String salesOrg;

    private BigDecimal tmpQty;

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

    public BigDecimal getTmpQty() {
        return tmpQty;
    }

    public void setTmpQty(BigDecimal tmpQty) {
        this.tmpQty = tmpQty;
    }

    public String getZbotCodeName() {
        return zbotCodeName;
    }

    public void setZbotCodeName(String zbotCodeName) {
        this.zbotCodeName = zbotCodeName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSecCateName() {
        return secCateName;
    }

    public void setSecCateName(String secCateName) {
        this.secCateName = secCateName;
    }

    public String getMatnrTxt() {

        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }
}