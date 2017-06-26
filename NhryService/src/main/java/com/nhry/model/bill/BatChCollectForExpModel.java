package com.nhry.model.bill;

import java.util.List;

/**
 * Created by gongjk on 2016/12/26.
 */
public class BatChCollectForExpModel {
    private List<CollectOrderBillModel> billModels;
    private String branchName;      //奶站名
    private String branchTel;       //奶站电话
    private String branchAddress;   //奶站地址
    private String salesOrgName;  // 销售组织名称

    public List<CollectOrderBillModel> getBillModels() {
        return billModels;
    }

    public void setBillModels(List<CollectOrderBillModel> billModels) {
        this.billModels = billModels;
    }

    public String getSalesOrgName() {
        return salesOrgName;
    }

    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchTel() {
        return branchTel;
    }

    public void setBranchTel(String branchTel) {
        this.branchTel = branchTel;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
