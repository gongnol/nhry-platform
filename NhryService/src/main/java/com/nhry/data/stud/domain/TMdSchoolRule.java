package com.nhry.data.stud.domain;

import java.util.Date;

public class TMdSchoolRule {
    private String mid;

    private String schoolCode;
    
    private String schoolName;

    private String isBatchPrint;

    private String visiable;

    private String week1Matnr;

    private String week2Matnr;

    private String week3Matnr;

    private String week4Matnr;

    private String week5Matnr;

    private String week6Matnr;

    private String week7Matnr;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;
    
    private String salesOrg;//销售组织
    
    private Boolean checkbox;//false 可用，true 不可用
    
    private String schoolCodeTxt;
    
    
    public String getSchoolCodeTxt() {
		return schoolCodeTxt;
	}

	public void setSchoolCodeTxt(String schoolCodeTxt) {
		this.schoolCodeTxt = schoolCodeTxt;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Boolean getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Boolean checkbox) {
		this.checkbox = checkbox;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode == null ? null : schoolCode.trim();
    }

    public String getIsBatchPrint() {
        return isBatchPrint;
    }

    public void setIsBatchPrint(String isBatchPrint) {
        this.isBatchPrint = isBatchPrint == null ? null : isBatchPrint.trim();
    }

    public String getVisiable() {
        return visiable;
    }

    public void setVisiable(String visiable) {
        this.visiable = visiable == null ? null : visiable.trim();
    }

    public String getWeek1Matnr() {
        return week1Matnr;
    }

    public void setWeek1Matnr(String week1Matnr) {
        this.week1Matnr = week1Matnr == null ? null : week1Matnr.trim();
    }

    public String getWeek2Matnr() {
        return week2Matnr;
    }

    public void setWeek2Matnr(String week2Matnr) {
        this.week2Matnr = week2Matnr == null ? null : week2Matnr.trim();
    }

    public String getWeek3Matnr() {
        return week3Matnr;
    }

    public void setWeek3Matnr(String week3Matnr) {
        this.week3Matnr = week3Matnr == null ? null : week3Matnr.trim();
    }

    public String getWeek4Matnr() {
        return week4Matnr;
    }

    public void setWeek4Matnr(String week4Matnr) {
        this.week4Matnr = week4Matnr == null ? null : week4Matnr.trim();
    }

    public String getWeek5Matnr() {
        return week5Matnr;
    }

    public void setWeek5Matnr(String week5Matnr) {
        this.week5Matnr = week5Matnr == null ? null : week5Matnr.trim();
    }

    public String getWeek6Matnr() {
        return week6Matnr;
    }

    public void setWeek6Matnr(String week6Matnr) {
        this.week6Matnr = week6Matnr == null ? null : week6Matnr.trim();
    }

    public String getWeek7Matnr() {
        return week7Matnr;
    }

    public void setWeek7Matnr(String week7Matnr) {
        this.week7Matnr = week7Matnr == null ? null : week7Matnr.trim();
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