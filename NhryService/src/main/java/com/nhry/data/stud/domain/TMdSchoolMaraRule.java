package com.nhry.data.stud.domain;

import java.util.Date;

public class TMdSchoolMaraRule {
    private String mid;

    private String schoolCode;
    

    private String matnr;
    
    private String matnrTxt;
    
    private String specUnit;
  

    private Integer matnrQty;

    private Integer fixedQty;

    private Integer fixedScale;

    private Integer fixedMaxQty;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;
    
    private String salesOrg;//销售组织
    
    
    public String getSpecUnit() {
		return specUnit;
	}

	public void setSpecUnit(String specUnit) {
		this.specUnit = specUnit;
	}


	public String getMatnrTxt() {
		return matnrTxt;
	}

	public void setMatnrTxt(String matnrTxt) {
		this.matnrTxt = matnrTxt;
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

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public Integer getMatnrQty() {
        return matnrQty;
    }

    public void setMatnrQty(Integer matnrQty) {
        this.matnrQty = matnrQty;
    }

    public Integer getFixedQty() {
        return fixedQty;
    }

    public void setFixedQty(Integer fixedQty) {
        this.fixedQty = fixedQty;
    }

    public Integer getFixedScale() {
        return fixedScale;
    }

    public void setFixedScale(Integer fixedScale) {
        this.fixedScale = fixedScale;
    }

    public Integer getFixedMaxQty() {
        return fixedMaxQty;
    }

    public void setFixedMaxQty(Integer fixedMaxQty) {
        this.fixedMaxQty = fixedMaxQty;
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