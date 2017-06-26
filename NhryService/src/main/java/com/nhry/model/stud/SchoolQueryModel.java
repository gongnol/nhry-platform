package com.nhry.model.stud;

import java.io.Serializable;

import com.nhry.model.basic.BaseQueryModel;
/**
 * 
 * @author dai
 *
 */
public class SchoolQueryModel extends BaseQueryModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String schoolCode;
	private String keyWord;
	private String visiable;
	private String salesOrg;
	private String erpCode;
	
	
	
	public String getErpCode() {
		return erpCode;
	}
	public void setErpCode(String erpCode) {
		this.erpCode = erpCode;
	}
	public SchoolQueryModel(String schoolCode, String keyWord, String visiable,
			String salesOrg) {
		super();
		this.schoolCode = schoolCode;
		this.keyWord = keyWord;
		this.visiable = visiable;
		this.salesOrg = salesOrg;
	}
	public SchoolQueryModel() {
		super();
	}
	public SchoolQueryModel(String schoolCode, String salesOrg) {
		this.schoolCode=schoolCode;
		this.salesOrg=salesOrg;
	}
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
