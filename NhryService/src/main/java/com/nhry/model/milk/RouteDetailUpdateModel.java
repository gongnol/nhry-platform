package com.nhry.model.milk;

import java.util.ArrayList;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "RouteDetailUpdateModel", description = "路单详细更新对象")
public class RouteDetailUpdateModel {
	
	private String orderNo;
	
	private String itemNo;
	
	private String orgItemNo;
	
	private String orgOrderNo;

	private String status;

   private String productCode;
   
   private String reason;
   
   private String replaceReason;
   
   private String confirmQty;
   
   private String matnr;
   
   public String getReplaceReason()
	{
		return replaceReason;
	}

	public void setReplaceReason(String replaceReason)
	{
		this.replaceReason = replaceReason;
	}

	public String getOrgOrderNo()
	{
		return orgOrderNo;
	}

	public void setOrgOrderNo(String orgOrderNo)
	{
		this.orgOrderNo = orgOrderNo;
	}

	public String getOrgItemNo()
   {
   	return orgItemNo;
   }
   
   public void setOrgItemNo(String orgItemNo)
   {
   	this.orgItemNo = orgItemNo;
   }

	public String getMatnr()
	{
		return matnr;
	}

	public void setMatnr(String matnr)
	{
		this.matnr = matnr;
	}

	public String getOrderNo()
	{
		return orderNo;
	}

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public String getItemNo()
	{
		return itemNo;
	}

	public void setItemNo(String itemNo)
	{
		this.itemNo = itemNo;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getConfirmQty()
	{
		return confirmQty;
	}

	public void setConfirmQty(String confirmQty)
	{
		this.confirmQty = confirmQty;
	}
   
}