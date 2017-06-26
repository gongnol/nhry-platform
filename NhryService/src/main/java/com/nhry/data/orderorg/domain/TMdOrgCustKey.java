package com.nhry.data.orderorg.domain;

import java.io.Serializable;

public class TMdOrgCustKey implements Serializable {
    private String orgId;

    private String custId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}