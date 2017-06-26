package com.nhry.data.milktrans.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/27.
 * 回瓶表
 */
public class TRecBotDetail implements Serializable {
    private String detLsh;      //明细流水号
    private String spec;        //规格 名称
    private String dispOrderNo; //配送单号
    private String branchNo;   //奶站号
    private String empNo;       //送奶员号
    private Date recDate;       //回瓶日期
    private int receiveNum;     //应收数量
    private int realNum;        //实收数量
    private String status;      //状态
    private Date createAt;
    private String createBy;
    private String createByTxt;
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;

    public String getDispOrderNo() {
        return dispOrderNo;
    }

    public void setDispOrderNo(String dispOrderNo) {
        this.dispOrderNo = dispOrderNo;
    }

    public String getStatus() {
        return status;
    }


    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDetLsh() {
        return detLsh;
    }

    public void setDetLsh(String detLsh) {
        this.detLsh = detLsh;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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
