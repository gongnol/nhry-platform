package com.nhry.data.milktrans.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/10/19.
 * 拒收复送记录 Item
 */
public class TMstRefuseResendItem {
    private String resendOrderNo;    //拒收复送号
    private String orderNo;          //单号  如果类型是要货计划 则保存要货计划号，如果是应用内部销售订单，则保存内部销售订单号
    private String type;             //类型  10 要货单，20 内部销售订单
    private BigDecimal qty;          //应用数量
    private String createBy;         //操作人
    private Date createAt;            //操作时间

    public String getResendOrderNo() {
        return resendOrderNo;
    }

    public void setResendOrderNo(String resendOrderNo) {
        this.resendOrderNo = resendOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
