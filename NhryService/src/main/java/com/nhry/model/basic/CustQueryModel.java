package com.nhry.model.basic;

import java.io.Serializable;

import com.nhry.utils.date.Date;

public class CustQueryModel extends BaseQueryModel {
	private String salesOrg;
	private String station;
	private String dealerNo;
	private String stationType;
	private String status;
	private String phone;
	private String startDate;
	private String endDate;
	private String content;
	private String orgId;
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStationType() {
		return stationType;
	}
	public void setStationType(String stationType) {
		this.stationType = stationType;
	}
	public String getDealerNo() {
		return dealerNo;
	}
	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}
	public String getOrgId() {return orgId;}
	public void setOrgId(String orgId) {this.orgId = orgId;}
}
