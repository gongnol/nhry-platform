package com.nhry.data.promotion.domain;

public class PromotionScopeItem{
    private String branchNo;

    private String promNo;

    private String ItemNo;


    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo == null ? null : promNo.trim();
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
    }
}