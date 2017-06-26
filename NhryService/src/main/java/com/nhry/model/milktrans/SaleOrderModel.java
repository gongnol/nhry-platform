package com.nhry.model.milktrans;

import com.nhry.data.milktrans.domain.TSsmSalOrderItems;

import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/7/26.
 */
public class SaleOrderModel {
    private String branchNo;
    private String orderNo;
    private Date requiredDate;
    List<TSsmSalOrderItems> entries;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public List<TSsmSalOrderItems> getEntries() {
        return entries;
    }

    public void setEntries(List<TSsmSalOrderItems> entries) {
        this.entries = entries;
    }
}
