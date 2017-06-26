package com.nhry.data.order.dao;

import com.nhry.data.order.domain.TOrderDaliyPlanItemBack;

/**
 * Created by gongjk on 2016/12/12.
 */
public interface TOrderDaliyPlanItemBackMapper {
    int insertNewItem(TOrderDaliyPlanItemBack back);

    //PageInfo<TOrderDaliyPlanItemBack> selectDaliyPlanBackByPage();
}
