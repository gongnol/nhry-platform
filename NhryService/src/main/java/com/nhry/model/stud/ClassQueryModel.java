package com.nhry.model.stud;

import java.io.Serializable;

import com.nhry.model.basic.BaseQueryModel;
/**
 * 
 * @author zhaoxijun
 */
public class ClassQueryModel extends BaseQueryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String salesOrg;
	private String classCode;
	
	
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	
	
	
	
}
