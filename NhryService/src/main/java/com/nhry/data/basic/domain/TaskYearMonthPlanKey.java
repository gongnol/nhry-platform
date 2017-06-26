package com.nhry.data.basic.domain;

public class TaskYearMonthPlanKey {
    private String branckNo;

    private String taskYear;

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
}