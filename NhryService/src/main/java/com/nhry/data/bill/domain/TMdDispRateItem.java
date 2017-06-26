package com.nhry.data.bill.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/4.
 * 配送费率表
 */
public class TMdDispRateItem {
    private String  itemNo;
    private int itemValue; //存放区间范围
    private int itemIndex; //存放1、2、3、4、5序号
    private String salesOrg; //销售组织

    private BigDecimal rate;     //配送率

    private String createBy;
    private String createByTxt;
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }


    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt;
    }
}
