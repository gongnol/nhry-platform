package com.nhry.data.basic.domain;

import java.util.Date;

public class TSysPushMessageLog {
    private String mno;

    private String reqType;

    private String reqUrl;

    private String reqContent;

    private String sysFlag;

    private String errorMessage;

    private String errorCode;

    private String procExecResults;

    private String status;

    private Date createAt;

    private Date lastModified;

    private Integer amount;

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno == null ? null : mno.trim();
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType == null ? null : reqType.trim();
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent == null ? null : reqContent.trim();
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag == null ? null : sysFlag.trim();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getProcExecResults() {
        return procExecResults;
    }

    public void setProcExecResults(String procExecResults) {
        this.procExecResults = procExecResults == null ? null : procExecResults.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}