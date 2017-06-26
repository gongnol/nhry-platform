package com.nhry.model.milktrans;

import java.util.Date;

/**
 * Created by gongjk on 2016/7/6.
 * 奶瓶回收列表
 */
public class ReturnBoxModel {
    private String detLsh;
    private String retLsh;
    private String dealerNo;
    private String dealerName; //经销商名称
    private String branchNo; //回瓶日期
    private String branchName;
    private String empNo;
    private String empName;
    private String spec;
    private String specName;
    private String status;
    private Date recDate;
    private int receiveNum;
    private int realNum;
    private Date createAt;
    private Date lastModified;

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

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getDetLsh() {
        return detLsh;
    }

    public void setDetLsh(String detLsh) {
        this.detLsh = detLsh;
    }

    public String getRetLsh() {
        return retLsh;
    }

    public void setRetLsh(String retLsh) {
        this.retLsh = retLsh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public int getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(int receiveNum) {
        this.receiveNum = receiveNum;
    }

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }
}
