package com.nhry.model.statistics;


import com.wordnik.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by huaguan on 2016/12/23.
 */
@ApiModel(value = "OutMilkModel", description = "出奶表实体")
public class OutMilkModel {
    private String empNo;
    private String branchNo;
    private Date orderDate;
    private BigDecimal reAmt;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getReAmt() {
        return reAmt;
    }

    public void setReAmt(BigDecimal reAmt) {
        this.reAmt = reAmt;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
