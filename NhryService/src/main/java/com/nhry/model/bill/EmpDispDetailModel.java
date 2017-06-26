package com.nhry.model.bill;

import java.util.Date;

/**
 * Created by gongjk on 2016/6/30.
 */
public class EmpDispDetailModel {
    private String branchNo;
    private String branchName;
    private String dealerName;
    private String dealerNo;
    private String empNo;
    private String empName;
    private Date     dispDate;
    private String matnr;
    private String matnrTxt;
    private Integer qty;
    private String type;

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
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

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public String getType() {
        return type;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setType(String type) {
        this.type = type;
    }
}
