package com.nhry.data.promotion.domain;

public class PromotionOrigItemKey {
    private String promNo;

    private String itemNo;

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo == null ? null : promNo.trim();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }
}