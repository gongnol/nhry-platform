package com.nhry.model.sys;

import java.io.Serializable;

public class ResponseModel implements Serializable {
  private String type;
  private Object msg;
  private Object data;
public String getType() {
	return type;
}
public Object getMsg() {
	return msg;
}
public void setMsg(Object msg) {
	this.msg = msg;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public void setType(String type) {
	this.type = type;
}

}
