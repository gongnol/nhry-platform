package com.nhry.data.orderorg.domain;

import java.io.Serializable;
import java.util.Date;

public class TMdOrgCust extends TMdOrgCustKey {
    private Date createAt;

    private String createBy;

    private String createByTxt;

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
}