package com.nhry.data.milk.dao;

import java.util.List;

import com.nhry.data.milk.domain.TDispOrderChange;
import com.nhry.data.milk.domain.TDispOrderChangeKey;

public interface TDispOrderChangeMapper {
	
	 int deleteDispOrderChangeByOrderNo(List<String> codeList);
	
    int deleteByPrimaryKey(TDispOrderChangeKey key);

    int insert(TDispOrderChange record);

    int batchAddNewDispOrderChanges(List<TDispOrderChange> record);

    TDispOrderChange selectByPrimaryKey(TDispOrderChangeKey key);

    int updateByPrimaryKeySelective(TDispOrderChange record);

    int updateByPrimaryKey(TDispOrderChange record);
    
    List searchRouteChangeOrder(String code);
}