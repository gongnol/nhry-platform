package com.nhry.model.basic;

import java.io.Serializable;

public class BaseQueryModel implements Serializable {
	//每页显示条数
	protected String pageSize = "8";
	//当前页数
	protected String pageNum;
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
}
