package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.Date;

public class TMdBranchEmp implements Serializable,Cloneable {
    private String empNo;

    private String hrEmpNo;

    private String branchNo;

    private String branchName;
    private String salesOrg;

    private String empName;

    private String gender;

    private String roleId;

    private String roleName;

    private String empType;

    private String tel;

    private String mp;

    private String webchat;

    private String idNo;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String status;

    private Date joinDate;

    private int baseSalary;

    private String salaryMet;
    
    private Date leaveDate;

    private String sapcode;

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getSalaryMet() {
        return salaryMet;
    }

    public void setSalaryMet(String salaryMet) {
        this.salaryMet = salaryMet;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getHrEmpNo() {
        return hrEmpNo;
    }

    public void setHrEmpNo(String hrEmpNo) {
        this.hrEmpNo = hrEmpNo == null ? null : hrEmpNo.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId  == null ? null : roleId.trim();;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender  == null ? null : gender.trim();
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType == null ? null : empType.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp == null ? null : mp.trim();
    }

    public String getWebchat() {
        return webchat;
    }

    public void setWebchat(String webchat) {
        this.webchat = webchat == null ? null : webchat.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt == null ? null : createByTxt.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt == null ? null : lastModifiedByTxt.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

    public String getSapcode() {
        return sapcode;
    }

    public void setSapcode(String sapcode) {
        this.sapcode = sapcode == null ? null : sapcode.trim();
    }
}