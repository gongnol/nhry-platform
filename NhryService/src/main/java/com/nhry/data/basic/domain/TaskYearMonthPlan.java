package com.nhry.data.basic.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TaskYearMonthPlan extends TaskYearMonthPlanKey {

    private String branchName;

    private BigDecimal taskJan;

    private BigDecimal taskFeb;

    private BigDecimal taskMar;

    private BigDecimal taskApr;

    private BigDecimal taskMay;

    private BigDecimal taskJun;

    private BigDecimal taskJul;

    private BigDecimal taskAug;

    private BigDecimal taskSep;

    private BigDecimal taskOct;

    private BigDecimal taskNov;

    private BigDecimal taskDev;

    private BigDecimal taskYearPlan;

    private String createrBy;

    private Date createrAt;

    private Date updateAt;

    private String updateBy;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public BigDecimal getTaskJan() {
        return taskJan;
    }

    public void setTaskJan(BigDecimal taskJan) {
        this.taskJan = taskJan;
    }

    public BigDecimal getTaskFeb() {
        return taskFeb;
    }

    public void setTaskFeb(BigDecimal taskFeb) {
        this.taskFeb = taskFeb;
    }

    public BigDecimal getTaskMar() {
        return taskMar;
    }

    public void setTaskMar(BigDecimal taskMar) {
        this.taskMar = taskMar;
    }

    public BigDecimal getTaskApr() {
        return taskApr;
    }

    public void setTaskApr(BigDecimal taskApr) {
        this.taskApr = taskApr;
    }

    public BigDecimal getTaskMay() {
        return taskMay;
    }

    public void setTaskMay(BigDecimal taskMay) {
        this.taskMay = taskMay;
    }

    public BigDecimal getTaskJun() {
        return taskJun;
    }

    public void setTaskJun(BigDecimal taskJun) {
        this.taskJun = taskJun;
    }

    public BigDecimal getTaskJul() {
        return taskJul;
    }

    public void setTaskJul(BigDecimal taskJul) {
        this.taskJul = taskJul;
    }

    public BigDecimal getTaskAug() {
        return taskAug;
    }

    public void setTaskAug(BigDecimal taskAug) {
        this.taskAug = taskAug;
    }

    public BigDecimal getTaskSep() {
        return taskSep;
    }

    public void setTaskSep(BigDecimal taskSep) {
        this.taskSep = taskSep;
    }

    public BigDecimal getTaskOct() {
        return taskOct;
    }

    public void setTaskOct(BigDecimal taskOct) {
        this.taskOct = taskOct;
    }

    public BigDecimal getTaskNov() {
        return taskNov;
    }

    public void setTaskNov(BigDecimal taskNov) {
        this.taskNov = taskNov;
    }

    public BigDecimal getTaskDev() {
        return taskDev;
    }

    public void setTaskDev(BigDecimal taskDev) {
        this.taskDev = taskDev;
    }

    public BigDecimal getTaskYearPlan() {
        return taskYearPlan;
    }

    public void setTaskYearPlan(BigDecimal taskYearPlan) {
        this.taskYearPlan = taskYearPlan;
    }

    public String getCreaterBy() {
        return createrBy;
    }

    public void setCreaterBy(String createrBy) {
        this.createrBy = createrBy == null ? null : createrBy.trim();
    }

    public Date getCreaterAt() {
        return createrAt;
    }

    public void setCreaterAt(Date createrAt) {
        this.createrAt = createrAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}