package com.nhry.common.jedis.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Test implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
   private String code;
   private String name;
   private Timestamp createAt;
   
   
public Timestamp getCreateAt() {
	return createAt;
}
public void setCreateAt(Timestamp createAt) {
	this.createAt = createAt;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
   
}
