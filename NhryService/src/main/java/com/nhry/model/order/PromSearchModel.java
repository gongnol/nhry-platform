package com.nhry.model.order;

import java.io.Serializable;

import com.nhry.model.basic.BaseQueryModel;

public class PromSearchModel extends BaseQueryModel implements Serializable {
	private String orderDateStart;//下单开始日期
	private String orderDateEnd;//下单截止日期
	private String promNo;			//促销编号
	private String salesOrg;
	private String branchNo;
	
	
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	
	public String getOrderDateStart() {
		return orderDateStart;
	}
	public void setOrderDateStart(String orderDateStart) {
		this.orderDateStart = orderDateStart;
	}
	public String getOrderDateEnd() {
		return orderDateEnd;
	}
	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}
	public String getPromNo() {
		return promNo;
	}
	public void setPromNo(String promNo) {
		this.promNo = promNo;
	}
	
	
	

}
