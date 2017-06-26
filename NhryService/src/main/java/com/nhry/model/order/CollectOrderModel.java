package com.nhry.model.order;

import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.order.domain.TPreOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by gongjk on 2016/7/18.
 */
public class CollectOrderModel {
    private TPreOrder order;
    private List<ProductItem> entries;
    private BigDecimal totalPrice;
    private TMdAddress address;
    private TMdBranch branch;
    private BigDecimal custAccAmt;//订户余额
    private BigDecimal suppAmt;   //应收金额
    private BigDecimal discountAmt; //优惠金额
    public BigDecimal getCustAccAmt() {
        return custAccAmt;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getSuppAmt() {
        return suppAmt;
    }

    public void setSuppAmt(BigDecimal suppAmt) {
        this.suppAmt = suppAmt;
    }

    public void setCustAccAmt(BigDecimal custAccAmt) {
        this.custAccAmt = custAccAmt;
    }

    public TMdBranch getBranch() {
        return branch;
    }

    public void setBranch(TMdBranch branch) {
        this.branch = branch;
    }

    public TMdAddress getAddress() {
        return address;
    }

    public void setAddress(TMdAddress address) {
        this.address = address;
    }

    public TPreOrder getOrder() {
        return order;
    }

    public void setOrder(TPreOrder order) {
        this.order = order;
    }

    public List<ProductItem> getEntries() {
        return entries;
    }

    public void setEntries(List<ProductItem> entries) {
        this.entries = entries;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
