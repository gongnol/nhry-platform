package com.nhry.data.config.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.model.order.OrderSearchModel;

public class NHSysCodeItemMapperImpl implements NHSysCodeItemMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<NHSysCodeItem> getCodeItemsByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("getCodeItemsByTypeCode", typecode);
	}
	
	@Override
	public PageInfo searchCodeItemsByPages(OrderSearchModel smodel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("searchCodeItemsByPages", smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int findItemCountByTypeCode(String typecode) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findTypeItemCountByTypeCode", typecode);
	}

	@Override
	public int deleteCodeItemByCode(NHSysCodeItem codeitem) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteCodeItemByCode", codeitem);
	}

	@Override
	public int addCodeItem(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addCodeItem",record);
	}

	@Override
	public NHSysCodeItem findCodeItenByCode(NHSysCodeItem codeitem) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findCodeItenByCode", codeitem);
	}

	@Override
	public int updateCodeItemByCode(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateCodeItemByCode", record);
	}

	@Override
	public List<NHSysCodeItem> findItemsByParentCode(NHSysCodeItem record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findItemsByParentCode", record);
	}
}
