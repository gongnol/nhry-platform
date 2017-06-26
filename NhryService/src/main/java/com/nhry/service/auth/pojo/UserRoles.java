package com.nhry.service.auth.pojo;

import java.io.Serializable;

public class UserRoles implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String roleId;
  private String roleName;
  private String isDefault;
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public String getIsDefault() {
	return isDefault;
}
public void setIsDefault(String isDefault) {
	this.isDefault = isDefault;
}
}
