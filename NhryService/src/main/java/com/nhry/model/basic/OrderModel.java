package com.nhry.model.basic;

import java.io.Serializable;

public class OrderModel implements Serializable {
  private String orderNo;
  private String memoType;
  private String memoTitle;
  private String memoContent;
public String getOrderNo() {
	return orderNo;
}
public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}
public String getMemoType() {
	return memoType;
}
public void setMemoType(String memoType) {
	this.memoType = memoType;
}
public String getMemoTitle() {
	return memoTitle;
}
public void setMemoTitle(String memoTitle) {
	this.memoTitle = memoTitle;
}
public String getMemoContent() {
	return memoContent;
}
public void setMemoContent(String memoContent) {
	this.memoContent = memoContent;
}
}
