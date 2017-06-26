package com.nhry.service.pi.pojo;

import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by cbz on 7/20/2016.
 */

public class Order implements Serializable {
    public TPreOrder getOrder() {
        return order;
    }

    public void setOrder(TPreOrder order) {
        this.order = order;
    }

    TPreOrder order;
    List<TOrderDaliyPlanItem> daliyPlanItems = new ArrayList<TOrderDaliyPlanItem>();
    List<TPlanOrderItem> planOrderItems = new ArrayList<TPlanOrderItem>();

    public List<TOrderDaliyPlanItem> getDaliyPlanItems() {
        return daliyPlanItems;
    }

    public void setDaliyPlanItems(List<TOrderDaliyPlanItem> daliyPlanItems) {
        this.daliyPlanItems = daliyPlanItems;
    }

    public List<TPlanOrderItem> getPlanOrderItems() {
        return planOrderItems;
    }

    public void setPlanOrderItems(List<TPlanOrderItem> planOrderItems) {
        this.planOrderItems = planOrderItems;
    }

    public Order(){}
}
