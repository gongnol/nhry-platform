package com.nhry.data.milktrans.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/30.
 */
public class TMstInsideSalOrderItem implements Serializable {
    private String insOrderNo;          //内部销售订单号
    private Date orderDate;             //日期
    private String itemNo;              //行号
    private String orgOrderNo;          //订单号
    private String matnr;               //产品
    private String matnrTxt;            //产品名
    private BigDecimal qty;             //数量
    private String reason;              //产生原因 （路单原因）40，50
    private BigDecimal price;           //价格
    private String spec;                //规格
    private String secCate;
    private String zbotCode;

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSecCate() {
        return secCate;
    }

    public void setSecCate(String secCate) {
        this.secCate = secCate;
    }

    public String getZbotCode() {
        return zbotCode;
    }

    public void setZbotCode(String zbotCode) {
        this.zbotCode = zbotCode;
    }

    public String getInsOrderNo() {
        return insOrderNo;
    }

    public void setInsOrderNo(String insOrderNo) {
        this.insOrderNo = insOrderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getOrgOrderNo() {
        return orgOrderNo;
    }

    public void setOrgOrderNo(String orgOrderNo) {
        this.orgOrderNo = orgOrderNo;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
