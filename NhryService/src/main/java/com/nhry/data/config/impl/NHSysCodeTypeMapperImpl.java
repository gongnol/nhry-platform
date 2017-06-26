package com.nhry.data.config.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.config.dao.NHSysCodeTypeMapper;
import com.nhry.data.config.domain.NHSysCodeType;
import com.nhry.model.basic.DictionarySearchModel;

public class NHSysCodeTypeMapperImpl implements NHSysCodeTypeMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int delSysCodeTypeByCode(String typeCode) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delSysCodeTypeByCode", typeCode);
	}

	@Override
	public int addSysCodeType(NHSysCodeType record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addSysCodeType", record);
	}

	@Override
	public NHSysCodeType findCodeTypeByCode(String typeCode) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findCodeTypeByCode", typeCode);
	}

	@Override
	public int updateSysCodeType(NHSysCodeType record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateSysCodeType", record);
	}
	
	@Override
	public List<NHSysCodeType> getAllTypeCodes()
	{
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findAllTypeCodes");
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
