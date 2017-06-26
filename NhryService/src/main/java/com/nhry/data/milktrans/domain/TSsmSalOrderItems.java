package com.nhry.data.milktrans.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/16.
 * 销售订单行项目
 */
public class TSsmSalOrderItems {
    private String orderNo;         //销售订单号
    private int itemNo;             //行号 10、20、30
    private Date orderDate;         //日期
    private String matnr;           //产品编号
    private String matnrTxt;        //产品全称
    private String unit;            //规格
    private int qty;                //数量
    private String type;            //类型  '10'：经销商奶站根据要货计划生成的销售单，'20': 自营奶站根据路单和内部销售单生成的销售单
    private String refMatnr;
    private String refMatnrTxt;
    private String promNo;           //促销号
    private BigDecimal discountAmt; //折扣
    private BigDecimal price;       //价格
    private int iniQty;             //初始值
    private BigDecimal yk21;        //差额
    public String getRefMatnrTxt() {
        return refMatnrTxt;
    }

    public void setRefMatnrTxt(String refMatnrTxt) {
        this.refMatnrTxt = refMatnrTxt;
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo;
    }

    public String getRefMatnr() {
        return refMatnr;
    }

    public void setRefMatnr(String refMatnr) {
        this.refMatnr = refMatnr;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getIniQty() {
        return iniQty;
    }

    public void setIniQty(int iniQty) {
        this.iniQty = iniQty;
    }

    public BigDecimal getYk21() {
        return yk21;
    }

    public void setYk21(BigDecimal yk21) {
        this.yk21 = yk21;
    }
}
