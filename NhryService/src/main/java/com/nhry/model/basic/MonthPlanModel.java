package com.nhry.model.basic;

public class MonthPlanModel {
    private String branckNo;

    private String taskYear;

    private String salesOrg;

    public String getBranckNo() {
        return branckNo;
    }

    public void setBranckNo(String branckNo) {
        this.branckNo = branckNo == null ? null : branckNo.trim();
    }

    public String getTaskYear() {
        return taskYear;
    }

    public void setTaskYear(String taskYear) {
        this.taskYear = taskYear == null ? null : taskYear.trim();
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }
}