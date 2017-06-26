package com.nhry.data.config.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.config.dao.NHSysParameterMapper;
import com.nhry.data.config.domain.NHSysParameter;
import com.nhry.model.basic.SysParamQueryModel;

public class NHSysParameterMapperImpl implements NHSysParameterMapper {
	
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteSysParamByCode(String paramCode) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteSysParamByCode",paramCode);
	}

	@Override
	public int addSysParam(NHSysParameter record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addSysParam", record);
	}

	@Override
	public NHSysParameter selectSysParamByCode(String paramCode) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectSysParamByCode", paramCode);
	}

	@Override
	public int uptSysParamByCode(NHSysParameter record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptSysParamByCode", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public PageInfo findSysParam(SysParamQueryModel param) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectListByPages("findSysParam", param, Integer.parseInt(param.getPageNum()), Integer.parseInt(param.getPageSize()));
	}
}
