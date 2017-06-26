package com.nhry.data.order.dao;

import com.nhry.data.order.domain.TPreOrderRecord;

public interface TPreOrderRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPreOrderRecord record);

    int insertSelective(TPreOrderRecord record);

    TPreOrderRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPreOrderRecord record);

    int updateByPrimaryKey(TPreOrderRecord record);
}