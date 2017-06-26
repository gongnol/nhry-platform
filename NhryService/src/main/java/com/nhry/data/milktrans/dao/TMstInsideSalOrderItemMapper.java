package com.nhry.data.milktrans.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milktrans.domain.TMstInsideSalOrderItem;
import com.nhry.model.milktrans.InSideSalOrderDetailSearchModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/6/30.
 */
public interface TMstInsideSalOrderItemMapper {
    int delInSalOrderItemByOrderNo(String insOrderNo);

    int insertOrderItem(TMstInsideSalOrderItem item);

    PageInfo getInsideSalOrderDetail(InSideSalOrderDetailSearchModel sModel);

    int deleteInSalOrderItemByMap(Map<String, String> map);

    List<TMstInsideSalOrderItem> getItemsByNo(String insOrderNo);


    public int batchAddNewInsideOrderItems(List<TMstInsideSalOrderItem> items);

}
