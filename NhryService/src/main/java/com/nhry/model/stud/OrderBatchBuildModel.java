package com.nhry.model.stud;

/**
 * @author zhaoxijun
 * @date 2017年4月12日
 */
public class OrderBatchBuildModel {
	private String orderGetDateStr;
	private String uncloudSchoolCodeTxts;
	private String week;
	private String serverRandomCode;
	private String userRandomCode;
	
	
	
	public String getServerRandomCode() {
		return serverRandomCode;
	}
	public void setServerRandomCode(String serverRandomCode) {
		this.serverRandomCode = serverRandomCode;
	}
	public String getUserRandomCode() {
		return userRandomCode;
	}
	public void setUserRandomCode(String userRandomCode) {
		this.userRandomCode = userRandomCode;
	}
	private String orderDateStr;
	private String schoolCode;
	
	public String getOrderGetDateStr() {
		return orderGetDateStr;
	}
	public void setOrderGetDateStr(String orderGetDateStr) {
		this.orderGetDateStr = orderGetDateStr;
	}
	public String getOrderDateStr() {
		return orderDateStr;
	}
	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	
	public String getUncloudSchoolCodeTxts() {
		return uncloudSchoolCodeTxts;
	}
	public void setUncloudSchoolCodeTxts(String uncloudSchoolCodeTxts) {
		this.uncloudSchoolCodeTxts = uncloudSchoolCodeTxts;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	
}
