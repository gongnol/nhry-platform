package com.nhry.model.bill;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by gongjk on 2016/7/4.
 */
public class EmpSalaryBillModel implements Serializable {
    private String branchNo;
    private String branchName;
    private String empNo;
    private String empName;
    private int baseSalary;//基本工资
    private String salaryMet;//结算方式
    private BigDecimal dispFee;//配送费
    private BigDecimal milkBoxRetExp;//奶瓶回收率
    private BigDecimal salary;


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

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getSalaryMet() {
        return salaryMet;
    }

    public void setSalaryMet(String salaryMet) {
        this.salaryMet = salaryMet;
    }

    public BigDecimal getDispFee() {
        return dispFee;
    }

    public void setDispFee(BigDecimal dispFee) {
        this.dispFee = dispFee;
    }

    public BigDecimal getMilkBoxRetExp() {
        return milkBoxRetExp;
    }

    public void setMilkBoxRetExp(BigDecimal milkBoxRetExp) {
        this.milkBoxRetExp = milkBoxRetExp;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
