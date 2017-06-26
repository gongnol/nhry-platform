package com.nhry.data.basic.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TMdMaraUnit extends TMdMaraUnitKey {
    private BigDecimal umrez;

    private String baseUnit;

    private BigDecimal umren;

    private Date lastModified;

    private Date createAt;

    public BigDecimal getUmrez() {
        return umrez;
    }

    public void setUmrez(BigDecimal umrez) {
        this.umrez = umrez;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit == null ? null : baseUnit.trim();
    }

    public BigDecimal getUmren() {
        return umren;
    }

    public void setUmren(BigDecimal umren) {
        this.umren = umren;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}