package com.nhry.data.stud.domain;

import java.util.Date;

public class TMstOrderStudLoss {
    private String mid;

    private String orderId;

    private String matnr;

    private Integer qty;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;
    
    private String salesOrg;//销售组织
    
    private String matnrTxt;//
    
    private String zbotCode;//
    
    private String zbotCodeName;//
    
    private String baseUnit;
    

    public String getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	public String getMatnrTxt() {
		return matnrTxt;
	}

	public void setMatnrTxt(String matnrTxt) {
		this.matnrTxt = matnrTxt;
	}

	public String getZbotCode() {
		return zbotCode;
	}

	public void setZbotCode(String zbotCode) {
		this.zbotCode = zbotCode;
	}

	public String getZbotCodeName() {
		return zbotCodeName;
	}

	public void setZbotCodeName(String zbotCodeName) {
		this.zbotCodeName = zbotCodeName;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr == null ? null : matnr.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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