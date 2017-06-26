package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.Date;

public class TMdResidentialArea implements Serializable{
    private String id;

    private String branchNo;

    private String branchName;
    private String residentialAreaTxt;

    private String province;
    private String provinceName;

    private String city;

    private String cityName;

    private String county;

    private String countyName;

    private String street;

    private String streetName;

    private String guideboard;

    private String status;


    private String addressTxt;

    private Integer residentialNum;

    private String salesOrg;

    private String propertyTxt;

    private String propertyTel;

    private Date createAt;

    private String createBy;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

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
        this.createBy = createBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo  == null ? null : branchNo.trim();
    }

    public String getResidentialAreaTxt() {
        return residentialAreaTxt;
    }

    public void setResidentialAreaTxt(String residentialAreaTxt) {
        this.residentialAreaTxt = residentialAreaTxt == null ? null : residentialAreaTxt.trim();
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

    public String getGuideboard() {
        return guideboard;
    }

    public void setGuideboard(String guideboard) {
        this.guideboard = guideboard  == null ? null : guideboard.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getAddressTxt() {
        return addressTxt;
    }

    public void setAddressTxt(String addressTxt) {
        this.addressTxt = addressTxt == null ? null : addressTxt.trim();
    }

    public Integer getResidentialNum() {
        return residentialNum;
    }

    public void setResidentialNum(Integer residentialNum) {
        this.residentialNum = residentialNum;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg == null ? null : salesOrg.trim();
    }

    public String getPropertyTxt() {
        return propertyTxt;
    }

    public void setPropertyTxt(String propertyTxt) {
        this.propertyTxt = propertyTxt == null ? null : propertyTxt.trim();
    }

    public String getPropertyTel() {
        return propertyTel;
    }

    public void setPropertyTel(String propertyTel) {
        this.propertyTel = propertyTel == null ? null : propertyTel.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}