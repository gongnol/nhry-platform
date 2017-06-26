package com.nhry.model.milk;

import com.nhry.model.basic.BaseQueryModel;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "RouteOrderSearchModel", description = "路单查询对象")
public class RouteOrderSearchModel extends BaseQueryModel implements Serializable {
	@ApiModelProperty(value="status",notes="状态")
	private String emp;
	private String branchNo;
	private String deliverTime;
	private String deliverDate;
	private String type;
	private String orderNo;
	private String branchNo1;
	private String salesOrg;
	private String status;
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getBranchNo1()
	{
		return branchNo1;
	}
	public void setBranchNo1(String branchNo1)
	{
		this.branchNo1 = branchNo1;
	}
	public String getSalesOrg()
	{
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg)
	{
		this.salesOrg = salesOrg;
	}
	public String getOrderNo()
	{
		return orderNo;
	}
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getEmp()
	{
		return emp;
	}
	public void setEmp(String emp)
	{
		this.emp = emp;
	}
	public String getBranchNo()
	{
		return branchNo;
	}
	public void setBranchNo(String branchNo)
	{
		this.branchNo = branchNo;
	}
	public String getDeliverTime()
	{
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime)
	{
		this.deliverTime = deliverTime;
	}
	public String getDeliverDate()
	{
		return deliverDate;
	}
	public void setDeliverDate(String deliverDate)
	{
		this.deliverDate = deliverDate;
	}
	
	
}
