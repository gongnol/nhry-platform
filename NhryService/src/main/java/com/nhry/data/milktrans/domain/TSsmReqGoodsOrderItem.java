package com.nhry.data.milktrans.domain;

import java.util.Date;

/**
 * Created by gongjk on 2016/7/5.
 */
public class TSsmReqGoodsOrderItem {
    private String orderNo;
    private Date  orderDate;
    private String matnr;
    private String matnrTxt;
    private String unit;
    private int qty;
    private int increQty;
    private int resendQty;
    private boolean hasTmp;
    private String flag;
    private int itemNo;
    private int backQty;


    public int getBackQty() {
		return backQty;
	}

	public void setBackQty(int backQty) {
		this.backQty = backQty;
	}

	public int getResendQty() {
        return resendQty;
    }

    public void setResendQty(int resendQty) {
        this.resendQty = resendQty;
    }

    public boolean isHasTmp() {
        return hasTmp;
    }

    public void setHasTmp(boolean hasTmp) {
        this.hasTmp = hasTmp;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
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

    public int getIncreQty() {
        return increQty;
    }

    public void setIncreQty(int increQty) {
        this.increQty = increQty;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
