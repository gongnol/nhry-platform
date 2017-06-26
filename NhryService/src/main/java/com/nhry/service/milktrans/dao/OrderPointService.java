package com.nhry.service.milktrans.dao;

import com.nhry.model.order.OrderPointModel;
import java.util.List;
/**
 * Created by cbz on 8/17/2016.
 */
public interface OrderPointService {
    int uptYfrechAndYGrowthByOrderNoAndItemNo(List<OrderPointModel> models);
}
