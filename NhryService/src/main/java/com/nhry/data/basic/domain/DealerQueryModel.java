package com.nhry.data.basic.domain;

import com.nhry.model.basic.BaseQueryModel;

public class DealerQueryModel extends BaseQueryModel{
	
	private String dealerNo;
	
	private String salesOrg;
	
	private String search;

	public String getDealerNo() {
		return dealerNo;
	}

	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}



	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
	

}
