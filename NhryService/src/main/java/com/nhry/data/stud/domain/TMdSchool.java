package com.nhry.data.stud.domain;

import java.util.Date;

public class TMdSchool {
	
    private String schoolCode;
    
    private String schoolCodeTxt;
    
    private String schoolName;

    private String erpCode;

    private String tel;

    private String mobilePhone;

    private String contact;

    private String address;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String visiable;
    
    private Boolean chekbox;//true为 禁用勾选，false：为禁用不勾选
    
    private String salesOrg;//销售组织
    
    
    private String werks; //公司
    
    
    private String dispatching; //供应商
    
    private String dispatchingName;
    
    private String unload;//卸货点
    
    private String unloadName;
    
    private String lgort;//库存地点
    
    
    private String erpCodeSales;//售达方
    

    
    public String getDispatchingName() {
		return dispatchingName;
	}

	public void setDispatchingName(String dispatchingName) {
		this.dispatchingName = dispatchingName;
	}

	public String getUnloadName() {
		return unloadName;
	}

	public void setUnloadName(String unloadName) {
		this.unloadName = unloadName;
	}

	public String getErpCodeSales() {
		return erpCodeSales;
	}

	public void setErpCodeSales(String erpCodeSales) {
		this.erpCodeSales = erpCodeSales;
	}

	public String getLgort() {
		return lgort;
	}

	public void setLgort(String lgort) {
		this.lgort = lgort;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public String getSchoolCodeTxt() {
		return schoolCodeTxt;
	}

	public void setSchoolCodeTxt(String schoolCodeTxt) {
		this.schoolCodeTxt = schoolCodeTxt;
	}

	public String getDispatching() {
		return dispatching;
	}

	public void setDispatching(String dispatching) {
		this.dispatching = dispatching;
	}

	public String getUnload() {
		return unload;
	}

	public void setUnload(String unload) {
		this.unload = unload;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSalesOrg() {
		return salesOrg;
	}
	
	public Boolean getChekbox() {
		return chekbox;
	}

	public void setChekbox(Boolean chekbox) {
		this.chekbox = chekbox;
	}

	public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode == null ? null : schoolCode.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode == null ? null : erpCode.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getVisiable() {
        return visiable;
    }

    public void setVisiable(String visiable) {
        this.visiable = visiable == null ? null : visiable.trim();
    }
}