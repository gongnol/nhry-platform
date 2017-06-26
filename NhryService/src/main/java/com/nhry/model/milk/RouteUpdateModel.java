package com.nhry.model.milk;

import java.util.ArrayList;

import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "RouteUpdateModel", description = "路单更新对象")
public class RouteUpdateModel {
	
	private String orderNo;
    
   private String status;

	public String getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}


}