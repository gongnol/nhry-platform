package com.nhry.data.basic.impl;

import java.util.Map;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdPriceBranchMapper;
import com.nhry.data.basic.domain.TMdPriceBranch;

public class TMdPriceBranchMapperImpl implements TMdPriceBranchMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int addPriceBranch(TMdPriceBranch record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addPriceBranch", record);
	}

	@Override
	public int delPriceBranchByNo(String branchNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delPriceBranchByNo", branchNo);
	}

	@Override
	public int delPriceBranchById(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delPriceBranchById", id);
	}

	@Override
	public int delPriceBranch(Map<String,String> atrrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delPriceBranch", atrrs);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int findPriceBranchCount(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findPriceBranchCount", attrs);
	}

	@Override
	public int findPriceBrachCountByPt(TMdPriceBranch record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findPriceBrachCountByPt", record);
	}
}
