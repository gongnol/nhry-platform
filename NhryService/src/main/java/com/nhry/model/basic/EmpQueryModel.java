package com.nhry.model.basic;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "EmpSearchModel", description = "网点员工信息查询对象")
public class EmpQueryModel extends BaseQueryModel implements Serializable {
	@ApiModelProperty(value="branchNo",notes="网点编号")
	private String branchNo;
	private String dealerNo;
	private String status;
	private String salesOrg;
	private String roleId;
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getDealerNo() {
		return dealerNo;
	}

	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}

	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
}
