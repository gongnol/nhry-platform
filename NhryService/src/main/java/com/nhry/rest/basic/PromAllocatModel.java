package com.nhry.rest.basic;

import java.util.ArrayList;
import java.util.List;

public class PromAllocatModel {
	
	private String promNo;
	
	private List<String> branchNos = new ArrayList<String>();


	public List<String> getBranchNos() {
		return branchNos;
	}

	public void setBranchNos(List<String> branchNos) {
		this.branchNos = branchNos;
	}

	public String getPromNo() {
		return promNo;
	}

	public void setPromNo(String promNo) {
		this.promNo = promNo;
	}

	

}
