package com.nhry.data.order.dao;

import com.nhry.data.order.domain.TPreOrderEntryDay;

public interface TPreOrderEntryDayMapper {
    int deleteByPrimaryKey(String dayNo);

    int insert(TPreOrderEntryDay record);

    int insertSelective(TPreOrderEntryDay record);

    TPreOrderEntryDay selectByPrimaryKey(String dayNo);

    int updateByPrimaryKeySelective(TPreOrderEntryDay record);

    int updateByPrimaryKey(TPreOrderEntryDay record);
}