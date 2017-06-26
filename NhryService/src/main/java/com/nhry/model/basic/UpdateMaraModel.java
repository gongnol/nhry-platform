package com.nhry.model.basic;

import java.io.Serializable;
import java.util.ArrayList;

import com.nhry.model.sys.ResponseModel;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

public class UpdateMaraModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String salesOrg;
	private Integer sort;
	private String hide;
	private String matnr;
	private String branchNo;
	
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getHide() {
		return hide;
	}
	public void setHide(String hide) {
		this.hide = hide;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	
	
}
