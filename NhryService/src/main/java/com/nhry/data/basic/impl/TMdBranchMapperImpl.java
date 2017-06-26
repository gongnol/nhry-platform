package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchSendMode;
import com.nhry.model.basic.BranchQueryModel;
import com.nhry.model.basic.BranchSalesOrgModel;

import java.util.List;
import java.util.Map;

public class TMdBranchMapperImpl implements TMdBranchMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int deleteBranchByNo(String branchNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBranchRemark(TMdBranch tMdBranch) {
		return sqlSessionTemplate.update("setBranchRemark",tMdBranch);
	}

	@Override
	public int addBranch(TMdBranch record) {
		return sqlSessionTemplate.insert("addBranch",record);
	}



	@Override
	public TMdBranch selectBranchByNo(String branchNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectBranchByNo",branchNo);
	}

	@Override
	public int updateBranch(TMdBranch tMdBranch) {
		return sqlSessionTemplate.update("uptBranch",tMdBranch);
	}

	@Override
	public int uptValidBranch(TMdBranch tMdBranch) {
		return sqlSessionTemplate.update("uptValidBranch",tMdBranch);
	}

	@Override
	public int uptTargetBranch(TMdBranch tMdBranch){
		return sqlSessionTemplate.update("uptTargetBranch",tMdBranch);
	}

	@Override
	public List<TMdBranch> getBranchByCodeOrName(Map<String, String> map) {
		return sqlSessionTemplate.selectList("getBranchByCodeOrName",map);
	}

	@Override
	public List<TMdBranch> findBranchListByOrgAndAuto(String salesOrg) {
		return sqlSessionTemplate.selectList("findBranchListByOrgAndAuto",salesOrg);
	}


	@Override
	public List<TMdBranch> findBranchListByOrg(BranchSalesOrgModel bModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("findBranchListByOrg", bModel);
	}

	@Override
	public PageInfo findBranchListByPage(BranchQueryModel branchModel) {
		return sqlSessionTemplate.selectListByPages("searchBranch",branchModel, Integer.parseInt(branchModel.getPageNum()), Integer.parseInt(branchModel.getPageSize()));

	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TMdBranch> findBranchByDno(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findBranchByDno", attrs);
	}

	@Override
	public TMdBranch getBranchByNo(String branchNo) {
		return this.sqlSessionTemplate.selectOne("getBranchByNo",branchNo);
	}

	@Override
	public TMdBranch  selectBranchInfoByBranchNo(String branchNo) {
		return this.sqlSessionTemplate.selectOne("selectBranchInfoByBranchNo",branchNo);
	}

	@Override
	public TMdBranchSendMode getSendMode(String branchNo) {
		return sqlSessionTemplate.selectOne("getSendMode",branchNo);
	}

	@Override
	public List<TMdBranchSendMode> selectBranchSendMode(String salesOrg) {
		return sqlSessionTemplate.selectList("selectBranchSendMode",salesOrg);
	}

	@Override
	public int insertSendMode(TMdBranchSendMode sendMode) {
		return sqlSessionTemplate.insert("insertSendMode",sendMode);
	}

	@Override
	public int delSendMode(String salesOrg) {
		return sqlSessionTemplate.delete("delSendMode",salesOrg);
	}

	@Override
	public int uptBankBranch(TMdBranch record) {
		return sqlSessionTemplate.update("uptBankBranch",record);
	}

	@Override
	public List<TMdBranch> getBranchsByPromNo(String promNO) {
		return sqlSessionTemplate.selectList("getBranchsByPromNo",promNO);
	}
}
