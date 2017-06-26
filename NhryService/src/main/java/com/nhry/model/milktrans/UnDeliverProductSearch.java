package com.nhry.model.milktrans;

import com.nhry.model.basic.BaseQueryModel;

import java.util.Date;

/**
 * Created by gongjk on 2016/6/30.
 */
public class UnDeliverProductSearch extends BaseQueryModel {
    private String orderNo; //路单号
    private String branchNo;
    private String empNo;
    private Date createDate;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
