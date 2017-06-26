package com.nhry.model.milk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongjk on 2016/10/21.
 */
public class TemporaryDispOrderModel {
    private List<String> orders = new ArrayList<String>();
    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }
}
