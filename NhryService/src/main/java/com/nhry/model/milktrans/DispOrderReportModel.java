package com.nhry.model.milktrans;

import java.util.Date;
import java.util.List;
/**
 * Created by cbz on 9/14/2016.
 */
public class DispOrderReportModel {
    String branchNo;
    List<String> empNos;
    List<String> confirmMatnrs;
    Date beginDate;
    Date endDate;
    String reachTimeType;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public List<String> getEmpNos() {
        return empNos;
    }

    public void setEmpNos(List<String> empNos) {
        this.empNos = empNos;
    }

    public List<String> getConfirmMatnrs() {
        return confirmMatnrs;
    }

    public void setConfirmMatnrs(List<String> confirmMatnrs) {
        this.confirmMatnrs = confirmMatnrs;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReachTimeType() {
        return reachTimeType;
    }

    public void setReachTimeType(String reachTimeType) {
        this.reachTimeType = reachTimeType;
    }
}
