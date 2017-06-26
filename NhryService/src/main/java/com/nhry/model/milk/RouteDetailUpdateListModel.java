package com.nhry.model.milk;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel(value = "RouteDetailUpdateListModel", description = "路单详细更新对象List")
public class RouteDetailUpdateListModel {
	
	private String routeNo;
	private String dispEmpNo;
	private List<RouteDetailUpdateModel> list = new ArrayList<RouteDetailUpdateModel>();;

	public String getRouteNo()
	{
		return routeNo;
	}

	public void setRouteNo(String routeNo)
	{
		this.routeNo = routeNo;
	}

	public String getDispEmpNo()
	{
		return dispEmpNo;
	}

	public void setDispEmpNo(String dispEmpNo)
	{
		this.dispEmpNo = dispEmpNo;
	}

	public List<RouteDetailUpdateModel> getList()
	{
		return list;
	}

	public void setList(List<RouteDetailUpdateModel> list)
	{
		this.list = list;
	}
	
}