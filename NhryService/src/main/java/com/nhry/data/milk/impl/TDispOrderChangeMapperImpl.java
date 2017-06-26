package com.nhry.data.milk.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milk.dao.TDispOrderChangeMapper;
import com.nhry.data.milk.dao.TDispOrderMapper;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderChange;
import com.nhry.data.milk.domain.TDispOrderChangeKey;
import com.nhry.data.milk.domain.TDispOrderKey;
import com.nhry.model.milk.RouteOrderSearchModel;

public class TDispOrderChangeMapperImpl implements TDispOrderChangeMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int deleteByPrimaryKey(TDispOrderChangeKey key)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TDispOrderChange record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchAddNewDispOrderChanges(List<TDispOrderChange> record)
	{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("batchAddNewDispOrderChanges", record);
	}

	@Override
	public TDispOrderChange selectByPrimaryKey(TDispOrderChangeKey key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TDispOrderChange record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TDispOrderChange record)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchRouteChangeOrder(String code)
	{
		return sqlSessionTemplate.selectList("searchRouteChangeOrder", code);
	}
	
	@Override
	public int deleteDispOrderChangeByOrderNo(List<String> codeList)
	{
		return sqlSessionTemplate.delete("deleteDispOrderChangeByOrderNo", codeList);
	}
}
