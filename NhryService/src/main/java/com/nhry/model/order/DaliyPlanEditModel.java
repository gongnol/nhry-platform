package com.nhry.model.order;

import java.util.ArrayList;

import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "DaliyPlanEditModel", description = "日计划修改对象")
public class DaliyPlanEditModel {
	
	private String orderCode;

	private String isOld;
	
	private ArrayList<TOrderDaliyPlanItem> entries = new ArrayList<TOrderDaliyPlanItem>();

	public String getOrderCode()
	{
		return orderCode;
	}

	public void setOrderCode(String orderCode)
	{
		this.orderCode = orderCode;
	}

	public ArrayList<TOrderDaliyPlanItem> getEntries()
	{
		return entries;
	}

	public void setEntries(ArrayList<TOrderDaliyPlanItem> entries)
	{
		this.entries = entries;
	}

	public String getIsOld() {
		return isOld;
	}

	public void setIsOld(String isOld) {
		this.isOld = isOld;
	}
}