package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 奶站排序表映射
 * @author Administrator
 *
 */
public class TMdMaraSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4032936928160903379L;
	private String matnr;
    private Integer sort;
    private String salesOrg;
    private String branchNo;
    private String hide;
    
	public String getHide() {
		return hide;
	}
	public void setHide(String hide) {
		this.hide = hide;
	}
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
  
}