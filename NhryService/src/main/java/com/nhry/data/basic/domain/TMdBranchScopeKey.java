package com.nhry.data.basic.domain;

public class TMdBranchScopeKey {
    private String branchNo;

    private String residentialAreaId;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getResidentialAreaId() {
        return residentialAreaId;
    }

    public void setResidentialAreaId(String residentialAreaId) {
        this.residentialAreaId = residentialAreaId == null ? null : residentialAreaId.trim();
    }
}