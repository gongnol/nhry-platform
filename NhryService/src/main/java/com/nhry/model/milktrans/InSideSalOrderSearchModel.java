package com.nhry.model.milktrans;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/20.
 */
public class InSideSalOrderSearchModel extends BaseQueryModel implements Serializable{
    private String branchNo;
    private String dealerNo;
    private String salesOrg;
    private Date startDate;
    private Date endDate;
    private String empNo;
    private String  inSalOrderNo;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getInSalOrderNo() {
        return inSalOrderNo;
    }

    public void setInSalOrderNo(String inSalOrderNo) {
        this.inSalOrderNo = inSalOrderNo;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
