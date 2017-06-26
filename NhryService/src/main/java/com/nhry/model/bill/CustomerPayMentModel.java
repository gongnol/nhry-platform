package com.nhry.model.bill;

import java.util.ArrayList;

import com.nhry.data.order.domain.TPlanOrderItem;

/**
 * Created by gongjk on 2016/6/29.
 */
public class CustomerPayMentModel  {
    private String orderNo;
    private String amt;
    private String paymentType;
    private String empNo;
    private String remark;
    private ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();
    
    public ArrayList<TPlanOrderItem> getEntries()
	{
		return entries;
	}

	public void setEntries(ArrayList<TPlanOrderItem> entries)
	{
		this.entries = entries;
	}

	public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
