package com.nhry.model.stud;

import java.io.Serializable;

import com.nhry.model.basic.BaseQueryModel;
/**
 * 
 * @author dai
 *
 */
public class SchoolRuleQueryModel extends BaseQueryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String schoolCode;
	private String keyWord;
	private String visiable;
	private String salesOrg;
	
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getVisiable() {
		return visiable;
	}
	public void setVisiable(String visiable) {
		this.visiable = visiable;
	}
	
}
