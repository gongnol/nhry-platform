package com.nhry.model.bill;

import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.order.domain.TPlanOrderItem;

import java.util.List;

/**
 * Created by gongjk on 2016/6/23.
 */
public class CustomerBillOrder {
    private TMstRecvBill bill;
    List<TPlanOrderItem> entries;

    public TMstRecvBill getBill() {
        return bill;
    }

    public void setBill(TMstRecvBill bill) {
        this.bill = bill;
    }

    public List<TPlanOrderItem> getEntries() {
        return entries;
    }

    public void setEntries(List<TPlanOrderItem> entries) {
        this.entries = entries;
    }
}
