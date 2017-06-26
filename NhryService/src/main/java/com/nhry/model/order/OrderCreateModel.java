package com.nhry.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TVipAcct;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "OrderCreateModel", description = "订单创建对象")
public class OrderCreateModel {
	
	private TPreOrder order;
    
   private ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();

   private TMdAddress address;
   
   private TVipAcct account;
   
   private String hasPlans;
   
   private String hasRoute;
   
	public String getHasPlans()
	{
		return hasPlans;
	}

	public void setHasPlans(String hasPlans)
	{
		this.hasPlans = hasPlans;
	}

	public String getHasRoute()
	{
		return hasRoute;
	}

	public void setHasRoute(String hasRoute)
	{
		this.hasRoute = hasRoute;
	}

	public TVipAcct getAccount()
	{
		return account;
	}

	public void setAccount(TVipAcct account)
	{
		this.account = account;
	}

	public TMdAddress getAddress()
	{
		return address;
	}

	public void setAddress(TMdAddress address)
	{
		this.address = address;
	}

	public TPreOrder getOrder()
	{
		return order;
	}

	public void setOrder(TPreOrder order)
	{
		this.order = order;
	}

	public ArrayList<TPlanOrderItem> getEntries()
	{
		return entries;
	}

	public void setEntries(ArrayList<TPlanOrderItem> entries)
	{
		this.entries = entries;
	}


    

}