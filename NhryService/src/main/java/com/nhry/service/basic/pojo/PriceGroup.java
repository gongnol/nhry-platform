package com.nhry.service.basic.pojo;

public class PriceGroup {
	private String priceType;
	private String priceGroup;
	private float price1;  //自取价
	private float price2;  //订户价
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getPriceGroup() {
		return priceGroup;
	}
	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
	}
	public float getPrice1() {
		return price1;
	}
	public void setPrice1(float price1) {
		this.price1 = price1;
	}
	public float getPrice2() {
		return price2;
	}
	public void setPrice2(float price2) {
		this.price2 = price2;
	}
}
