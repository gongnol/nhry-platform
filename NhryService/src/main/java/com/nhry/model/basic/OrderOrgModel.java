package com.nhry.model.basic;

import com.wordnik.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huaguan on 2016/12/1.
 */
@ApiModel(value = "OrderOrgModel", description = "机构信息列表查询对象")
public class OrderOrgModel extends BaseQueryModel implements Serializable {
    private String id;

    private String orgName;

    private String salesOrg;

    private String tel;

    private String address;

    private String orgCode;

    private String queryTxt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    private String contact;

    private String mp;
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getQueryTxt() {return queryTxt; }

    public void setQueryTxt(String queryTxt) {this.queryTxt = queryTxt;}
}
