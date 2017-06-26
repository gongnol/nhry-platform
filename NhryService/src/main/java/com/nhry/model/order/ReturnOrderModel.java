package com.nhry.model.order;

import com.wordnik.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/21.
 */
@ApiModel(value = "ReturnOrderModel", description = "订单退回对象")
public class ReturnOrderModel implements Serializable {

    private String orderNo;
    private String retReason;
    private String memoTxt;
    private Date retDate;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRetReason() {
        return retReason;
    }

    public void setRetReason(String retReason) {
        this.retReason = retReason;
    }

    public String getMemoTxt() {
        return memoTxt;
    }

    public void setMemoTxt(String memoTxt) {
        this.memoTxt = memoTxt;
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }
}