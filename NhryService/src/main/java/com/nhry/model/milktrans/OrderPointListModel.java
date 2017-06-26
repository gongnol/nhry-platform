package com.nhry.model.milktrans;
import com.nhry.model.order.OrderPointModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbz on 8/17/2016.
 */
public class OrderPointListModel {
    List<OrderPointModel> OrderPoints = new ArrayList<OrderPointModel>();

    public List<OrderPointModel> getOrderPoints() {
        return OrderPoints;
    }

    public void setOrderPoints(List<OrderPointModel> orderPoints) {
        OrderPoints = orderPoints;
    }
}
