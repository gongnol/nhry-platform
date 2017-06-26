package com.nhry.data.basic.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/10/24.
 */
public class TMdOperationLog implements Serializable{
    private String logNo;               //编号
    private String logBranch;            //奶站
    private String logType;             //类型
    private String originalValue;       //原值
    private String  newValue;           //新值
    private String logMatnr;            //产品
    private Date logDispDate;              //日期
    private String logName;             //名称
    private String logEmp;            //送奶员
    private String dispAddress;         //配送地址
    private Date  logDate;              //日志日期
    private Date createAt;              //创建时间
    private  String createBy;           //创建人编号
    private String createByTxt;         //创建人名称

    public String getLogBranch() {
        return logBranch;
    }

    public void setLogBranch(String logBranch) {
        this.logBranch = logBranch;
    }

    public String getDispAddress() {
        return dispAddress;
    }

    public void setDispAddress(String dispAddress) {
        this.dispAddress = dispAddress;
    }

    public String getLogEmp() {
        return logEmp;
    }

    public void setLogEmp(String logEmp) {
        this.logEmp = logEmp;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getLogMatnr() {
        return logMatnr;
    }

    public void setLogMatnr(String logMatnr) {
        this.logMatnr = logMatnr;
    }

    public Date getLogDispDate() {
        return logDispDate;
    }

    public void setLogDispDate(Date logDispDate) {
        this.logDispDate = logDispDate;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
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

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
    }
}
