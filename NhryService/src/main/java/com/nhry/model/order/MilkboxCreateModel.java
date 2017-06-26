package com.nhry.model.order;

import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.model.basic.BaseQueryModel;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@ApiModel(value = "MilkboxCreateModel", description = "奶箱新建对象")
public class MilkboxCreateModel implements Serializable {
	@ApiModelProperty(value="status",notes="状态")
	private String code;
	private String status;
	private String paymentStatus;
	private Date setDate;
	private String empNo;
	private String addressNo;
	private String branchNo;
	private ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();
	
	public ArrayList<TPlanOrderItem> getEntries()
	{
		return entries;
	}
	public void setEntries(ArrayList<TPlanOrderItem> entries)
	{
		this.entries = entries;
	}
	public String getEmpNo()
	{
		return empNo;
	}
	public void setEmpNo(String empNo)
	{
		this.empNo = empNo;
	}
	public String getAddressNo()
	{
		return addressNo;
	}
	public void setAddressNo(String addressNo)
	{
		this.addressNo = addressNo;
	}
	public String getBranchNo()
	{
		return branchNo;
	}
	public void setBranchNo(String branchNo)
	{
		this.branchNo = branchNo;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getPaymentStatus()
	{
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus = paymentStatus;
	}
	public Date getSetDate()
	{
		return setDate;
	}
	public void setSetDate(Date setDate)
	{
		this.setDate = setDate;
	}
	
	
}
