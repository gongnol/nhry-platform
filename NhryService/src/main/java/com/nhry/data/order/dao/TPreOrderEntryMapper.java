package com.nhry.data.order.dao;

import com.nhry.data.order.domain.TPreOrderEntry;
import com.nhry.data.order.domain.TPreOrderEntryKey;

public interface TPreOrderEntryMapper {
    int deleteByPrimaryKey(TPreOrderEntryKey key);

    int insert(TPreOrderEntry record);

    int insertSelective(TPreOrderEntry record);

    TPreOrderEntry selectByPrimaryKey(TPreOrderEntryKey key);

    int updateByPrimaryKeySelective(TPreOrderEntry record);

    int updateByPrimaryKey(TPreOrderEntry record);
}