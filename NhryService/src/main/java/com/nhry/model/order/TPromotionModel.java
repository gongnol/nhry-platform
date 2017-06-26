package com.nhry.model.order;

import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/11/30.
 */
public class TPromotionModel {
    private int rowNumber;              //订单行号
    private String promNo;             //促销号
    private String promItemNo;          //促销行号
    private String promSubType;         //促销类型
    private BigDecimal discountAmt;        //满减金额
    private String itemDescribe;        //描述

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo;
    }

    public String getPromItemNo() {
        return promItemNo;
    }

    public void setPromItemNo(String promItemNo) {
        this.promItemNo = promItemNo;
    }

    public String getPromSubType() {
        return promSubType;
    }

    public void setPromSubType(String promSubType) {
        this.promSubType = promSubType;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }
}
