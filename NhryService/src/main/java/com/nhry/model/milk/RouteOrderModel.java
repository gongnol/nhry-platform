package com.nhry.model.milk;

import java.util.ArrayList;

import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "RouteOrderModel", description = "路单对象")
public class RouteOrderModel {
	
	private TDispOrder order;
    
   private String products;
   
   private String retAmt;

	public String getRetAmt()
	{
		return retAmt;
	}

	public void setRetAmt(String retAmt)
	{
		this.retAmt = retAmt;
	}

	public TDispOrder getOrder()
	{
		return order;
	}

	public void setOrder(TDispOrder order)
	{
		this.order = order;
	}

	public String getProducts()
	{
		return products;
	}

	public void setProducts(String products)
	{
		this.products = products;
	}


}