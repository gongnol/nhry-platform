package com.nhry.data.order.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TMilkboxPlan {
    private String planNo;

    private String empNo;

    private String empName;

    private String orderNo;

    private String memberNo;

    private String memberName;

    private String memberTel;

    private String adressNo;

    private String custAddress;

    private String branchNo;
    
    private String branchName;
    
    private String branchTel;

    private Date planDate;

    private String milkboxStat;

    private String paymentStat;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public BigDecimal getInitAmt() {
        return initAmt;
    }

    public void setInitAmt(BigDecimal initAmt) {
        this.initAmt = initAmt;
    }

    private String lastModifiedByTxt;

    private String printFlag;

    private BigDecimal initAmt;

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    private String proNum;

    private String paymentmethod;

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getBranchName()
	{
		return branchName;
	}

	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}

	public String getBranchTel()
	{
		return branchTel;
	}

	public void setBranchTel(String branchTel)
	{
		this.branchTel = branchTel;
	}

	public String getPrintFlag(){
		return printFlag;
	 }

	public void setPrintFlag(String printFlag){
		this.printFlag = printFlag == null ? null : printFlag.trim();
	 }

	public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberTel() {
        return memberTel;
    }

    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel == null ? null : memberTel.trim();
    }

    public String getAdressNo() {
        return adressNo;
    }

    public void setAdressNo(String adressNo) {
        this.adressNo = adressNo == null ? null : adressNo.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }
    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getMilkboxStat() {
        return milkboxStat;
    }

    public void setMilkboxStat(String milkboxStat) {
        this.milkboxStat = milkboxStat == null ? null : milkboxStat.trim();
    }

    public String getPaymentStat() {
        return paymentStat;
    }

    public void setPaymentStat(String paymentStat) {
        this.paymentStat = paymentStat == null ? null : paymentStat.trim();
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
}