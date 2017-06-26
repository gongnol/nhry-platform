package com.nhry.model.stud;

import java.io.Serializable;

import com.nhry.model.basic.BaseQueryModel;

/**
 * @author zhaoxijun
 */
public class OrderStudQueryModel extends BaseQueryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String keyWord;
	
	private String salesOrg;
	
	private String orderDateStr;
	
	
		
	public String getOrderDateStr() {
		return orderDateStr;
	}

	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
}
