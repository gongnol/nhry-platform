package com.nhry.data.basic.impl;

import java.util.List;
import java.util.Map;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TBranchNotsellListMapper;
import com.nhry.data.basic.domain.TBranchNotsellList;

public class TBranchNotsellListMapperImpl implements TBranchNotsellListMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	@Override
	public int addBranchNotSell(TBranchNotsellList record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addBranchNotSell", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int delBranchNotsellByNo(String listNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delBranchNotsellByNo", listNo);
	}

	@Override
	public int delBranchNotsellByMatnr(String matnr) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delBranchNotsellByMatnr", matnr);
	}

	@Override
	public List<TBranchNotsellList> getNotSellListByMatnr(Map<String,String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getNotSellListByMatnr", attrs);
	}

	@Override
	public List<String> getNotSellDealerNosByMatnr(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getNotSellDealerNosByMatnr", attrs);
	}
}
