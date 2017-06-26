package com.nhry.model.milktrans;

import java.util.Date;

/**
 * Created by gongjk on 2016/6/28.
 */
public class CreateEmpReturnboxModel {
    private String branchNo;
    private String empNo;
    private Date retDate;

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

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }
}
