package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.Date;
import com.nhry.data.auth.domain.TSysUser;


public class TMdBranch implements Serializable{
    private String branchNo;

    private String branchName;

    private int totalCus;

    private String salesOrg;

    private String salesOrgName;

    private String salesCha;

    private String branchGroup;

    private String branchLevel;

    private String contact;

    private String empNo;

    private String tel;

    private String mp;

    private String dealerNo;

    private String dealerName;

    private String address;

    private String province;

    private String provinceName;

    private String city;

    private String cityName;

    private String county;

    private String countyName;

    private String werks;

    private String lgort;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String remark;

    private String payee;

    private String openBank;

    private String bankAccount;
    
    
    public void initData(TSysUser user){
    	//this.companyCode = SysCodeUtil.getCompanyCodeBySalesOrg(user.getSalesOrg(), SysContant.getSystemConst("comp_code"));
    	
    	this.salesOrg = user.getSalesOrg();
    	this.createAt = new Date();
    	this.createBy = user.getLoginName();
    	this.lastModified = new Date();
    	this.lastModifiedBy = user.getLoginName();
    	this.lastModifiedByTxt = user.getDisplayName();
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public Date getOnlineDate() {
        return onlineDate;
    }

    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    private String lastModifiedByTxt;

    private String companyCode;

    private String companyName;

    private String isValid;

    public String getTargetPerson() {
        return targetPerson;
    }

    public void setTargetPerson(String targetPerson) {
        this.targetPerson = targetPerson;
    }

    private Date onlineDate;

    private String targetPerson;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getSalesOrgName() {
        return salesOrgName;
    }

    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

    public int getTotalCus() {
        return totalCus;
    }

    public void setTotalCus(int totalCus) {
        this.totalCus = totalCus;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public String getSalesCha() {
        return salesCha;
    }

    public void setSalesCha(String salesCha) {
        this.salesCha = salesCha == null ? null : salesCha.trim();
    }

    public String getBranchGroup() {
        return branchGroup;
    }

    public void setBranchGroup(String branchGroup) {
        this.branchGroup = branchGroup == null ? null : branchGroup.trim();
    }

    public String getBranchLevel() {
        return branchLevel;
    }

    public void setBranchLevel(String branchLevel) {
        this.branchLevel = branchLevel == null ? null : branchLevel.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
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

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo == null ? null : dealerNo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks == null ? null : werks.trim();
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort == null ? null : lgort.trim();
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}