package com.nhry.model.auth;

import java.io.Serializable;
import java.util.List;

import com.nhry.model.basic.BaseQueryModel;

public class UserRoleModel implements Serializable {
    private List<String> loginNames;
    private String roleId;
    private String isDefault;
    private String loginName;
    private List<String> roleIds; 
	public List<String> getLoginNames() {
		return loginNames;
	}
	public void setLoginNames(List<String> loginNames) {
		this.loginNames = loginNames;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public List<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
