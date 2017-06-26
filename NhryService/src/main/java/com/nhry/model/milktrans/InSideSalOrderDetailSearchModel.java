package com.nhry.model.milktrans;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/7/20.
 */
public class InSideSalOrderDetailSearchModel extends BaseQueryModel implements Serializable {
    private String orderNo;
    private String salesOrg;

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
