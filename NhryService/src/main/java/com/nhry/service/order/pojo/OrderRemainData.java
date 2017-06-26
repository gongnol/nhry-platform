package com.nhry.service.order.pojo;

import java.math.BigDecimal;

public class OrderRemainData {
	private Integer qty;
	private BigDecimal amt;
	public Integer getQty()
	{
		return qty;
	}
	public void setQty(Integer qty)
	{
		this.qty = qty;
	}
	public BigDecimal getAmt()
	{
		return amt;
	}
	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}
	
}
