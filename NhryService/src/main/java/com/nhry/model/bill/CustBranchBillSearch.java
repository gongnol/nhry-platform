package com.nhry.model.bill;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/27.
 */
public class CustBranchBillSearch extends BaseQueryModel implements Serializable{
    private Date startDate;
    private Date endDate;
    private String branchNo;
    private String orderNo;
    private String salesOrg;
    private String dealerNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
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
