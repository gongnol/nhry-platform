package com.nhry.data.stock.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TSsmSalFactoryPrice extends TSsmSalFactoryPriceKey {
    private BigDecimal factoryPrice;

    private String salesOrg;

    private Date createAt;

    private String createBy;

    public BigDecimal getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(BigDecimal factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
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
        this.createBy = createBy;
    }
}