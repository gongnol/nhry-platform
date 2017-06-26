package com.nhry.model.basic;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "EmpSearchModel", description = "网点员工信息查询对象")
public class BranchQueryModel extends BaseQueryModel implements Serializable {
	@ApiModelProperty(value="branchLevel",notes="奶站等级")

	private String dealerNo;
	private String branchNo;
	private String branchGroup;
	private String salesOrg;
	private String branchN;
	public String getBranchN() {
		return branchN;
	}

	public void setBranchN(String branchN) {
		this.branchN = branchN;
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

	public String getDealerNo() {
		return dealerNo;
	}

	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}

	public String getBranchGroup() {
		return branchGroup;
	}

	public void setBranchGroup(String branchGroup) {
		this.branchGroup = branchGroup;
	}
}
