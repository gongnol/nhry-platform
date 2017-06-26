package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMdMara implements Serializable{
    private String matnr;

    private String matnrTxt;

    private String baseUnit;

    private String status;

    private Date lastModified;

    private Date createAt;

    private String firstCat;

    private String firstCateName;
    
    private String secCate;
    
    private String secCateName;

    private String brand;
    
    private String brandName;

    private Float weight;

    private String weightUnit;

    private String importantPrdFlag;

    private String spec;
    
    private String specName;

    private String specUnit;

    private String botSpec;

    private String zbotCode;
    
    private String zbotCodeName; //包装类型

    private String salesOrg;

    private String dealerNo;
    
    private TMdMaraEx maraEx;
    
    private Integer sort;
    private String hide;

    
    
    public Integer getSort() {
		return sort;
	}


	public void setSort(Integer sort) {
		this.sort = sort;
	}


	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	private List<TBranchNotsellList> notsellList = new ArrayList<TBranchNotsellList>();

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
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

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo == null ? null : dealerNo.trim();
    }

	public TMdMaraEx getMaraEx() {
		return maraEx;
	}

	public void setMaraEx(TMdMaraEx maraEx) {
		this.maraEx = maraEx;
	}

	public List<TBranchNotsellList> getNotsellList() {
		return notsellList;
	}

	public void setNotsellList(List<TBranchNotsellList> notsellList) {
		this.notsellList = notsellList;
	}

	public String getFirstCateName() {
		return firstCateName;
	}

	public void setFirstCateName(String firstCateName) {
		this.firstCateName = firstCateName;
	}

	public String getSecCateName() {
		return secCateName;
	}

	public void setSecCateName(String secCateName) {
		this.secCateName = secCateName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getZbotCodeName() {
		return zbotCodeName;
	}

	public void setZbotCodeName(String zbotCodeName) {
		this.zbotCodeName = zbotCodeName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}