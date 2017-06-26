package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TVipCustInfo implements Serializable{
    private String vipCustNo;

    private String vipCustNoSap;

    private String salesOrg;

    private String vipName;

    private String addressTxt;

    private String country;

    private String province;

    private String city;

    private String county;

    private String street;

    private String road;

    private String subdist;
    
    private String subdistName;

    private String room;

    private String mp;

    private String tel;

    private String zip;

    private String email;

    private String alipayAccount;

    private String webchatNo;

    private String nhEcAccount;

    private String jdAccount;

    private String sex;

    private Date birthday;

    private String certId;

    private String vipSrc;
    
    private String vipSrcName;

    private String milkbox;

    private String vipType;
    
    private String vipTypeName;

    private Date subscribeDate;

    private String subscriber;

    private String activityNo;

    private String status;

    private BigDecimal vipAmt;

    private Date createAt;

    private String createBy;

    private String createByTxt;

    private Date lastModified;

    private String lastModifiedBy;

    private String lastModifiedByTxt;

    private String memoTxt;

    private String dispMemoTxt;

    private String branchNo;
    
    private String branchName;
    
    private Date firstOrderTime;
    
    private Date lastOrderTime;
    
    private String dealerNo;
    
    private String dealerName;

    private String orgId;
    private String orgName;

    private List<TMdAddress> addresses = new ArrayList<TMdAddress>();

    public String vipMp;

    private BigDecimal acctAmt;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public BigDecimal getAcctAmt() {
        return acctAmt;
    }

    public void setAcctAmt(BigDecimal acctAmt) {
        this.acctAmt = acctAmt;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo == null ? null : vipCustNo.trim();
    }

    public String getVipCustNoSap() {
        return vipCustNoSap;
    }

    public void setVipCustNoSap(String vipCustNoSap) {
        this.vipCustNoSap = vipCustNoSap == null ? null : vipCustNoSap.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName == null ? null : vipName.trim();
    }

    public String getAddressTxt() {
        return addressTxt;
    }

    public void setAddressTxt(String addressTxt) {
        this.addressTxt = addressTxt == null ? null : addressTxt.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road == null ? null : road.trim();
    }

    public String getSubdist() {
        return subdist;
    }

    public void setSubdist(String subdist) {
        this.subdist = subdist == null ? null : subdist.trim();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp == null ? null : mp.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount == null ? null : alipayAccount.trim();
    }

    public String getWebchatNo() {
        return webchatNo;
    }

    public void setWebchatNo(String webchatNo) {
        this.webchatNo = webchatNo == null ? null : webchatNo.trim();
    }

    public String getNhEcAccount() {
        return nhEcAccount;
    }

    public void setNhEcAccount(String nhEcAccount) {
        this.nhEcAccount = nhEcAccount == null ? null : nhEcAccount.trim();
    }

    public String getJdAccount() {
        return jdAccount;
    }

    public void setJdAccount(String jdAccount) {
        this.jdAccount = jdAccount == null ? null : jdAccount.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId == null ? null : certId.trim();
    }

    public String getVipSrc() {
        return vipSrc;
    }

    public void setVipSrc(String vipSrc) {
        this.vipSrc = vipSrc == null ? null : vipSrc.trim();
    }

    public String getMilkbox() {
        return milkbox;
    }

    public void setMilkbox(String milkbox) {
        this.milkbox = milkbox == null ? null : milkbox.trim();
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType == null ? null : vipType.trim();
    }
    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber == null ? null : subscriber.trim();
    }

    public String getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(String activityNo) {
        this.activityNo = activityNo == null ? null : activityNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getVipAmt() {
        return vipAmt;
    }

    public void setVipAmt(BigDecimal vipAmt) {
        this.vipAmt = vipAmt;
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

    public String getMemoTxt() {
        return memoTxt;
    }

    public void setMemoTxt(String memoTxt) {
        this.memoTxt = memoTxt == null ? null : memoTxt.trim();
    }

    public String getDispMemoTxt() {
        return dispMemoTxt;
    }

    public void setDispMemoTxt(String dispMemoTxt) {
        this.dispMemoTxt = dispMemoTxt == null ? null : dispMemoTxt.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo == null ? null : branchNo.trim();
    }

	public List<TMdAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<TMdAddress> addresses) {
		this.addresses = addresses;
	}
	public Date getFirstOrderTime() {
		return firstOrderTime;
	}

	public void setFirstOrderTime(Date firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}
	public Date getLastOrderTime() {
		return lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDealerNo() {
		return dealerNo;
	}

	public void setDealerNo(String dealerNo) {
		this.dealerNo = dealerNo;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getVipSrcName() {
		return vipSrcName;
	}

	public void setVipSrcName(String vipSrcName) {
		this.vipSrcName = vipSrcName;
	}

	public String getVipTypeName() {
		return vipTypeName;
	}

	public void setVipTypeName(String vipTypeName) {
		this.vipTypeName = vipTypeName;
	}

	public String getSubdistName() {
		return subdistName;
	}

	public void setSubdistName(String subdistName) {
		this.subdistName = subdistName;
	}

    public String getVipMp() {
        return vipMp;
    }

    public void setVipMp(String vipMp) {
        this.vipMp = vipMp;
    }


}
