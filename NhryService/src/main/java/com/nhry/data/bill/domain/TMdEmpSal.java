package com.nhry.data.bill.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/12.
 * 员工工资表
 */
public class TMdEmpSal implements Serializable {
    private String empSalLsh;   //员工工资单流水号
    private String empNo;       //送奶工编号
    private int dispNum;        //总配送数量
    private BigDecimal totalSal;//总工资
    private Date setDate;       //结算日期
    private BigDecimal compRate;//投诉率
    private BigDecimal dispRate; //配送率
    private BigDecimal compSal; //投诉费
    private BigDecimal dispSal; //配送费
    private BigDecimal InDispSal;//内部销售订单配送费
    private BigDecimal sendDispSal;//赠品配送费
    private Date createAt;
    private String createBy;
    private String createByTxt;
    private String setYearMonth;
    private String empName;
    private String branchNo;
    private String branchName;
    private String baseSalary;  //基本工资
    private String salaryMet;   //结算方式

    public String getSetYearMonth() {
        return setYearMonth;
    }

    public void setSetYearMonth(String setYearMonth) {
        this.setYearMonth = setYearMonth;
    }

    public BigDecimal getSendDispSal() {
        return sendDispSal;
    }

    public void setSendDispSal(BigDecimal sendDispSal) {
        this.sendDispSal = sendDispSal;
    }

    public BigDecimal getInDispSal() {
        return InDispSal;
    }

    public void setInDispSal(BigDecimal inDispSal) {
        InDispSal = inDispSal;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getSalaryMet() {
        return salaryMet;
    }

    public void setSalaryMet(String salaryMet) {
        this.salaryMet = salaryMet;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSalLsh() {
        return empSalLsh;
    }


    public BigDecimal getCompRate() {
        return compRate;
    }

    public void setCompRate(BigDecimal compRate) {
        this.compRate = compRate;
    }

    public BigDecimal getCompSal() {
        return compSal;
    }

    public void setCompSal(BigDecimal compSal) {
        this.compSal = compSal;
    }

    public BigDecimal getDispRate() {
        return dispRate;
    }

    public void setDispRate(BigDecimal dispRate) {
        this.dispRate = dispRate;
    }

    public BigDecimal getDispSal() {
        return dispSal;
    }

    public void setDispSal(BigDecimal dispSal) {
        this.dispSal = dispSal;
    }

    public void setEmpSalLsh(String empSalLsh) {
        this.empSalLsh = empSalLsh;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public int getDispNum() {
        return dispNum;
    }

    public void setDispNum(int dispNum) {
        this.dispNum = dispNum;
    }

    public BigDecimal getTotalSal() {
        return totalSal;
    }

    public void setTotalSal(BigDecimal totalSal) {
        this.totalSal = totalSal;
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
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
