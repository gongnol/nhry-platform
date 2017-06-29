package com.nhry.data.basic.SearchModel;

import java.util.ArrayList;
import java.util.List;

public class TMdDealerStatusModel {
	private String dealerNo;
	private String delFlag;
	private List<String> dealerNos = new ArrayList<String>();
	
	public String getDealerNo() {
		return dealerNo;
	}
	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public List<String> getDealerNos() {
		return dealerNos;
	}
	public void setDealerNos(List<String> dealerNos) {
		this.dealerNos = dealerNos;
	}
	
	
	
}
