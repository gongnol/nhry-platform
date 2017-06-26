package com.nhry.data.milktrans.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/30.
 */
public class TMstInsideSalOrder implements Serializable {
    private String insOrderNo;          //内部销售订单号
    private Date orderDate;             //日期
    private String dispOrderNo;         //路单号
    private String salEmpNo;            //送奶员编号
    private String empName;             //送奶员名称
    private String branchNo;            //奶站编号
    private String branchName;           //奶站名
    private Date createAt;
    private String createBy;


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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getInsOrderNo() {
        return insOrderNo;
    }

    public void setInsOrderNo(String insOrderNo) {
        this.insOrderNo = insOrderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDispOrderNo() {
        return dispOrderNo;
    }

    public void setDispOrderNo(String dispOrderNo) {
        this.dispOrderNo = dispOrderNo;
    }

    public String getSalEmpNo() {
        return salEmpNo;
    }

    public void setSalEmpNo(String salEmpNo) {
        this.salEmpNo = salEmpNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
