package com.nhry.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by cbz on 11/18/2016.
 */
public class PromotionOrderModel {
    String branchNo;
    String saleOrg;
    Date orderDate;
    Date startDate;
    Date endDate;
    BigDecimal initAmt;
    List<PromotionPlanDetail> details = new ArrayList<PromotionPlanDetail>();

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

    public BigDecimal getInitAmt() {
        return initAmt;
    }

    public void setInitAmt(BigDecimal initAmt) {
        this.initAmt = initAmt;
    }

    public List<PromotionPlanDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PromotionPlanDetail> details) {
        this.details = details;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getSaleOrg() {
        return saleOrg;
    }

    public void setSaleOrg(String saleOrg) {
        this.saleOrg = saleOrg;
    }
}
