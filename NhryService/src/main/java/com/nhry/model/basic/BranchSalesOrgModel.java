package com.nhry.model.basic;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/7/19.
 */
public class BranchSalesOrgModel implements Serializable {
    private String dealerNo;
    private String branchNo;
    private String salesOrg;
    private String roleId;

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
