package com.nhry.rest.basic;

import java.math.BigDecimal;

public class PromTionItemModel {
	private String goodNo;  	//參加促销产品
	
	private String giftNo; 		 //赠品产品
	
	private BigDecimal origNum;	 //满足满赠促销个数
	
	private BigDecimal giftNum;  //赠品个数
	
	
	private BigDecimal low;      //满足满减促销最低价格
	
	private BigDecimal discountAmt;	//促销价格

	public String getGoodNo() {
		return goodNo;
	}

	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}

	public String getGiftNo() {
		return giftNo;
	}

	public void setGiftNo(String giftNo) {
		this.giftNo = giftNo;
	}

	public BigDecimal getOrigNum() {
		return origNum;
	}

	public void setOrigNum(BigDecimal origNum) {
		this.origNum = origNum;
	}

	public BigDecimal getGiftNum() {
		return giftNum;
	}

	public void setGiftNum(BigDecimal giftNum) {
		this.giftNum = giftNum;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(BigDecimal discountAmt) {
		this.discountAmt = discountAmt;
	}
	
	
	
	
	
	

}
