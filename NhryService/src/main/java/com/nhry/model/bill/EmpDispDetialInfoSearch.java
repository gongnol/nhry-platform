package com.nhry.model.bill;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/30.
 * 配送数量明细结算表的生成  查询条件
 */
public class EmpDispDetialInfoSearch  extends BaseQueryModel implements Serializable{
    private String dealerNo;
    private String branchNo;
    private String empNo;
    private Date startDate;
    private Date endDate;
    private String salesOrg;
    private Date salDate;
    private String yearMonth;
    private String vipCustNo;

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Date getSalDate() {
        return salDate;
    }

    public void setSalDate(Date salDate) {
        this.salDate = salDate;
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
}
