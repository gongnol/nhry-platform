package com.nhry.data.promotion.domain;

import java.math.BigDecimal;

public class PromotionGiftItem extends PromotionGiftItemKey {
    private String giftType;

    private String giftNo;

    private BigDecimal giftNum;

    private String giftUnit;

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType == null ? null : giftType.trim();
    }

    public String getGiftNo() {
        return giftNo;
    }

    public void setGiftNo(String giftNo) {
        this.giftNo = giftNo == null ? null : giftNo.trim();
    }

    public BigDecimal getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(BigDecimal giftNum) {
        this.giftNum = giftNum;
    }

    public String getGiftUnit() {
        return giftUnit;
    }

    public void setGiftUnit(String giftUnit) {
        this.giftUnit = giftUnit == null ? null : giftUnit.trim();
    }
}