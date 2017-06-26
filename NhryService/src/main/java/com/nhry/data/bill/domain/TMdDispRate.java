package com.nhry.data.bill.domain;


import java.util.Date;

/**
 * Created by gongjk on 2016/7/4.
 */
public class TMdDispRate {
    private String salesOrg;    //销售组织
    private String salesOrgName;//销售组织名
    private String salaryMet; // 结算方式
    private String createBy;    //创建人编号
    private String createByTxt;//创建人名称
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getSalesOrgName() {
        return salesOrgName;
    }

    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    public String getSalaryMet() {
        return salaryMet;
    }

    public void setSalaryMet(String salaryMet) {
        this.salaryMet = salaryMet;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
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
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt;
    }
}
