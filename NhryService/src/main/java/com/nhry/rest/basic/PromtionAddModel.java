package com.nhry.rest.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PromtionAddModel {

	private String promNo; // 促销编号

	private String promDes; // 促销描述
	
	private String promSubType;	//促销类型

	private Date planStartTime; // 下单开始日期

	private Date planStopTime; // 下单截止日期

	private Date buyStartTime; // 配送开始日期

	private Date buyStopTime; // 配送截止日期
	
	
	List<PromTionItemModel> items = new ArrayList<PromTionItemModel>();


	
	
	
	public String getPromSubType() {
		return promSubType;
	}


	public void setPromSubType(String promSubType) {
		this.promSubType = promSubType;
	}


	public String getPromNo() {
		return promNo;
	}


	public void setPromNo(String promNo) {
		this.promNo = promNo;
	}

	


	public String getPromDes() {
		return promDes;
	}


	public void setPromDes(String promDes) {
		this.promDes = promDes;
	}


	public Date getPlanStartTime() {
		return planStartTime;
	}


	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}


	public Date getPlanStopTime() {
		return planStopTime;
	}


	public void setPlanStopTime(Date planStopTime) {
		this.planStopTime = planStopTime;
	}


	public Date getBuyStartTime() {
		return buyStartTime;
	}


	public void setBuyStartTime(Date buyStartTime) {
		this.buyStartTime = buyStartTime;
	}


	public Date getBuyStopTime() {
		return buyStopTime;
	}


	public void setBuyStopTime(Date buyStopTime) {
		this.buyStopTime = buyStopTime;
	}


	public List<PromTionItemModel> getItems() {
		return items;
	}


	public void setItems(List<PromTionItemModel> items) {
		this.items = items;
	}
	
	
	
	

}
