package com.nhry.data.stud.domain;

import java.util.Date;

public class TMdMaraStud extends TMdMaraStudKey {
    private String matnrTxt;
    
    private String shortTxt;

    private String baseUnit;

    private String status;

    private Date lastModified;

    private Date createAt;

    private String firstCat;

    private String secCate;
    
    private String secCateName;

    private String brand;

    private Float weight;

    private String weightUnit;

    private String importantPrdFlag;

    private String spec;
    
    private String specName;

    private String specUnit;

    private String botSpec;

    private String zbotCode;
    
    private String zbotCodeName;

    private String dealerNo;
    
    
    public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSecCateName() {
		return secCateName;
	}

	public void setSecCateName(String secCateName) {
		this.secCateName = secCateName;
	}

	public String getShortTxt() {
		return shortTxt;
	}

	public void setShortTxt(String shortTxt) {
		this.shortTxt = shortTxt;
	}

	public String getZbotCodeName() {
		return zbotCodeName;
	}

	public void setZbotCodeName(String zbotCodeName) {
		this.zbotCodeName = zbotCodeName;
	}

	public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt == null ? null : matnrTxt.trim();
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit == null ? null : baseUnit.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFirstCat() {
        return firstCat;
    }

    public void setFirstCat(String firstCat) {
        this.firstCat = firstCat == null ? null : firstCat.trim();
    }

    public String getSecCate() {
        return secCate;
    }

    public void setSecCate(String secCate) {
        this.secCate = secCate == null ? null : secCate.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    public String getImportantPrdFlag() {
        return importantPrdFlag;
    }

    public void setImportantPrdFlag(String importantPrdFlag) {
        this.importantPrdFlag = importantPrdFlag == null ? null : importantPrdFlag.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getSpecUnit() {
        return specUnit;
    }

    public void setSpecUnit(String specUnit) {
        this.specUnit = specUnit == null ? null : specUnit.trim();
    }

    public String getBotSpec() {
        return botSpec;
    }

    public void setBotSpec(String botSpec) {
        this.botSpec = botSpec == null ? null : botSpec.trim();
    }

    public String getZbotCode() {
        return zbotCode;
    }

    public void setZbotCode(String zbotCode) {
        this.zbotCode = zbotCode == null ? null : zbotCode.trim();
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo == null ? null : dealerNo.trim();
    }
}