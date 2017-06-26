package com.nhry.data.auth.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nhry.service.auth.pojo.UserRoles;

public class TSysUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginName;
	
	private String password;    //密码
	
	//员工号
	private String empNo;  

    private String displayName;

    private String departmentNumber;

    private String departmentName;

    private Date customizedPositionid;

    private String customizedPositionname;

    private Date lastModified;

    private Date createOn;

    private String branchNo;
        
    private String branchName;

    private String dealerId;
    
    private String dealerName;

    private String salesOrg;
    
    private String orgName;

    private Date lastLogin;

    private String customizedDutyid;

    private String customizedDutyname;

    private String customizedResidence;

    private String customizedPersonalMail;

    private String mail;

    private String mobile;

    private Date customizedJoininworkdate;

    private Date customizedJoinsysdate;

    private String customizedResigneddate;

    private String customizedLastdepartmentname;

    private String customizedHrregion;

    private String customizedHrregiontxt;

    private String customizedSubhrregion;

    private String customizedSubhrregiontxt;

    private String customizedEmptype;

    private String customizedEmptypetxt;

    private String customizedSubemptype;

    private String customizedSubemptypetxt;

    private String customizedDegree;

    private String customizedMajor;

    private String customizedManagercode;

    private String customizedManagername;

    private String smartIdcardnumber;

    private String customizedNation;

    private String customizedCountry;

    private String smartType;

    private String smartCategory;

    private String cumstomizedVpath;

    private String cumstomizedRpath;

    private String smartAuthority;

    private String dsPwpAccountDisabled;

    private String groupId;

    private String roleIds;
    
    private String roleNames;

    private String[] roleIdArray;

    private boolean isRole;

    private String saleName;
    
    
    private String newPassword;
    
    private String confirmPassword;
    
    

    
    
    public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }
    
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber == null ? null : departmentNumber.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Date getCustomizedPositionid() {
        return customizedPositionid;
    }

    public void setCustomizedPositionid(Date customizedPositionid) {
        this.customizedPositionid = customizedPositionid;
    }

    public String getCustomizedPositionname() {
        return customizedPositionname;
    }

    public void setCustomizedPositionname(String customizedPositionname) {
        this.customizedPositionname = customizedPositionname == null ? null : customizedPositionname.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId == null ? null : dealerId.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCustomizedDutyid() {
        return customizedDutyid;
    }

    public void setCustomizedDutyid(String customizedDutyid) {
        this.customizedDutyid = customizedDutyid == null ? null : customizedDutyid.trim();
    }

    public String getCustomizedDutyname() {
        return customizedDutyname;
    }

    public void setCustomizedDutyname(String customizedDutyname) {
        this.customizedDutyname = customizedDutyname == null ? null : customizedDutyname.trim();
    }

    public String getCustomizedResidence() {
        return customizedResidence;
    }

    public void setCustomizedResidence(String customizedResidence) {
        this.customizedResidence = customizedResidence == null ? null : customizedResidence.trim();
    }

    public String getCustomizedPersonalMail() {
        return customizedPersonalMail;
    }

    public void setCustomizedPersonalMail(String customizedPersonalMail) {
        this.customizedPersonalMail = customizedPersonalMail == null ? null : customizedPersonalMail.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCustomizedJoininworkdate() {
        return customizedJoininworkdate;
    }

    public void setCustomizedJoininworkdate(Date customizedJoininworkdate) {
        this.customizedJoininworkdate = customizedJoininworkdate;
    }

    public Date getCustomizedJoinsysdate() {
        return customizedJoinsysdate;
    }

    public void setCustomizedJoinsysdate(Date customizedJoinsysdate) {
        this.customizedJoinsysdate = customizedJoinsysdate;
    }

    public String getCustomizedResigneddate() {
        return customizedResigneddate;
    }

    public void setCustomizedResigneddate(String customizedResigneddate) {
        this.customizedResigneddate = customizedResigneddate == null ? null : customizedResigneddate.trim();
    }

    public String getCustomizedLastdepartmentname() {
        return customizedLastdepartmentname;
    }

    public void setCustomizedLastdepartmentname(String customizedLastdepartmentname) {
        this.customizedLastdepartmentname = customizedLastdepartmentname == null ? null : customizedLastdepartmentname.trim();
    }

    public String getCustomizedHrregion() {
        return customizedHrregion;
    }

    public void setCustomizedHrregion(String customizedHrregion) {
        this.customizedHrregion = customizedHrregion == null ? null : customizedHrregion.trim();
    }

    public String getCustomizedHrregiontxt() {
        return customizedHrregiontxt;
    }

    public void setCustomizedHrregiontxt(String customizedHrregiontxt) {
        this.customizedHrregiontxt = customizedHrregiontxt == null ? null : customizedHrregiontxt.trim();
    }

    public String getCustomizedSubhrregion() {
        return customizedSubhrregion;
    }

    public void setCustomizedSubhrregion(String customizedSubhrregion) {
        this.customizedSubhrregion = customizedSubhrregion == null ? null : customizedSubhrregion.trim();
    }

    public String getCustomizedSubhrregiontxt() {
        return customizedSubhrregiontxt;
    }

    public void setCustomizedSubhrregiontxt(String customizedSubhrregiontxt) {
        this.customizedSubhrregiontxt = customizedSubhrregiontxt == null ? null : customizedSubhrregiontxt.trim();
    }

    public String getCustomizedEmptype() {
        return customizedEmptype;
    }

    public void setCustomizedEmptype(String customizedEmptype) {
        this.customizedEmptype = customizedEmptype == null ? null : customizedEmptype.trim();
    }

    public String getCustomizedEmptypetxt() {
        return customizedEmptypetxt;
    }

    public void setCustomizedEmptypetxt(String customizedEmptypetxt) {
        this.customizedEmptypetxt = customizedEmptypetxt == null ? null : customizedEmptypetxt.trim();
    }

    public String getCustomizedSubemptype() {
        return customizedSubemptype;
    }

    public void setCustomizedSubemptype(String customizedSubemptype) {
        this.customizedSubemptype = customizedSubemptype == null ? null : customizedSubemptype.trim();
    }

    public String getCustomizedSubemptypetxt() {
        return customizedSubemptypetxt;
    }

    public void setCustomizedSubemptypetxt(String customizedSubemptypetxt) {
        this.customizedSubemptypetxt = customizedSubemptypetxt == null ? null : customizedSubemptypetxt.trim();
    }

    public String getCustomizedDegree() {
        return customizedDegree;
    }

    public void setCustomizedDegree(String customizedDegree) {
        this.customizedDegree = customizedDegree == null ? null : customizedDegree.trim();
    }

    public String getCustomizedMajor() {
        return customizedMajor;
    }

    public void setCustomizedMajor(String customizedMajor) {
        this.customizedMajor = customizedMajor == null ? null : customizedMajor.trim();
    }

    public String getCustomizedManagercode() {
        return customizedManagercode;
    }

    public void setCustomizedManagercode(String customizedManagercode) {
        this.customizedManagercode = customizedManagercode == null ? null : customizedManagercode.trim();
    }

    public String getCustomizedManagername() {
        return customizedManagername;
    }

    public void setCustomizedManagername(String customizedManagername) {
        this.customizedManagername = customizedManagername == null ? null : customizedManagername.trim();
    }

    public String getSmartIdcardnumber() {
        return smartIdcardnumber;
    }

    public void setSmartIdcardnumber(String smartIdcardnumber) {
        this.smartIdcardnumber = smartIdcardnumber == null ? null : smartIdcardnumber.trim();
    }

    public String getCustomizedNation() {
        return customizedNation;
    }

    public void setCustomizedNation(String customizedNation) {
        this.customizedNation = customizedNation == null ? null : customizedNation.trim();
    }

    public String getCustomizedCountry() {
        return customizedCountry;
    }

    public void setCustomizedCountry(String customizedCountry) {
        this.customizedCountry = customizedCountry == null ? null : customizedCountry.trim();
    }

    public String getSmartType() {
        return smartType;
    }

    public void setSmartType(String smartType) {
        this.smartType = smartType == null ? null : smartType.trim();
    }

    public String getSmartCategory() {
        return smartCategory;
    }

    public void setSmartCategory(String smartCategory) {
        this.smartCategory = smartCategory == null ? null : smartCategory.trim();
    }

    public String getCumstomizedVpath() {
        return cumstomizedVpath;
    }

    public void setCumstomizedVpath(String cumstomizedVpath) {
        this.cumstomizedVpath = cumstomizedVpath == null ? null : cumstomizedVpath.trim();
    }

    public String getCumstomizedRpath() {
        return cumstomizedRpath;
    }

    public void setCumstomizedRpath(String cumstomizedRpath) {
        this.cumstomizedRpath = cumstomizedRpath == null ? null : cumstomizedRpath.trim();
    }

    public String getSmartAuthority() {
        return smartAuthority;
    }

    public void setSmartAuthority(String smartAuthority) {
        this.smartAuthority = smartAuthority == null ? null : smartAuthority.trim();
    }

    public String getDsPwpAccountDisabled() {
        return dsPwpAccountDisabled;
    }

    public void setDsPwpAccountDisabled(String dsPwpAccountDisabled) {
        this.dsPwpAccountDisabled = dsPwpAccountDisabled == null ? null : dsPwpAccountDisabled.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

//    public List<TSysUserRole> getRoleIds() {
//        return roleIds;
//    }
//
//    public void setRoleIds(List<TSysUserRole> roleIds) {
//        this.roleIds = roleIds;
//    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        roleIdArray = roleIds.split(",");
        this.roleIds = roleIds;
    }

    public String[] getRoleIdArray() {
        return roleIdArray;
    }

    public void setRoleIdArray(String[] roleIdArray) {
        this.roleIdArray = roleIdArray;
    }

    public boolean isRole() {
        return isRole;
    }

    public void setRole(boolean role) {
        isRole = role;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
}