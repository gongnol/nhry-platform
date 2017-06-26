package com.nhry.model.order;

import java.util.ArrayList;

import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "OrderEditModel", description = "订单修改对象")
public class OrderEditModel {
	
	private TPreOrder order;
	
	private ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();
	
	private String editDate;

	public String getEditDate()
	{
		return editDate;
	}

	public void setEditDate(String editDate)
	{
		this.editDate = editDate;
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