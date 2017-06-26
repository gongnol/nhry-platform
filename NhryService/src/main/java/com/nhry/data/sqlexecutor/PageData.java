package com.nhry.data.sqlexecutor;

import java.util.List;

public class PageData<T> implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int totalCount;
	private List<T> listData;
	private int curPageNo;
	private int pageSize;
	
	public PageData(){
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getListData() {
		return listData;
	}
	public void setListData(List<T> listData) {
		this.listData = listData;
	}
	public int getCurPageNo() {
		return curPageNo;
	}
	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
