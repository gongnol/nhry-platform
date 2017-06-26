package com.nhry.service.basic.pojo;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/6/3.
 */
public class ResidentialAreaModel extends BaseQueryModel implements Serializable {
    private String province;
    private String city;
    private String status;
    private String county;
    private String branchNo;
    private String salesOrg;
    private String areaTxt;
    public String getAreaTxt() {
        return areaTxt;
    }

    public void setAreaTxt(String areaTxt) {
        this.areaTxt = areaTxt;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
