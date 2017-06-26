package com.nhry.data.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/12/12.
 */
public class TOrderDaliyPlanItemBack implements Serializable{
    private String orderNo;                 //订单号
    private Date dispDate;                  //配送日期
    private String matnr;                   //产品编号
    private int qty;                        //数量
    private BigDecimal salesPrice;          //价格
    private String unit;                     //规格
    private BigDecimal amt;                 //金额
    private String branchNo;                //奶站
    private Date createAt;                  //创建日期
    private String createBy;                //创建人编号
    private String createByTxt;             //创建人名称
    private String orderType;                  //订单类型

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    private String matnrTxt;

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

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
}
