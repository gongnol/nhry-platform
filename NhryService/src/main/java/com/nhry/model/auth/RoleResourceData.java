package com.nhry.model.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nhry.data.auth.domain.TSysRoleResource;

public class RoleResourceData implements Serializable{
	
	private List<TSysRoleResource> records = new ArrayList<TSysRoleResource>();

	public List<TSysRoleResource> getRecords() {
		return records;
	}

	public void setRecords(List<TSysRoleResource> records) {
		this.records = records;
	}
}
