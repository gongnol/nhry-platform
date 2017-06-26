package com.nhry.model.order;

import java.util.Date;
import java.util.List;

/**
 * Created by cbz on 9/14/2016.
 */
public class OrderDaliyPlanReportModel {
    String branchNo;
    List<String> empNos;
    List<String> matnrs;
    Date beginDate;
    Date endDate;

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

    public List<String> getMatnrs() {
        return matnrs;
    }

    public void setMatnrs(List<String> matnrs) {
        this.matnrs = matnrs;
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

}
