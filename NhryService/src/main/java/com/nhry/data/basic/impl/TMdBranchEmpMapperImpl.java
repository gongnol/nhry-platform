package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.model.basic.BranchEmpSearchModel;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.model.bill.EmpSalQueryModel;
import com.nhry.service.basic.pojo.BranchEmpModel;

import java.util.List;

public class TMdBranchEmpMapperImpl implements TMdBranchEmpMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteBranchEmp(TMdBranchEmp record) {
		// TODO Auto-generated method stub
		int emp = sqlSessionTemplate.update("deleteBranchEmpByNo", record);
		int role = sqlSessionTemplate.delete("deleteEmpRole", record);
		return emp+role;
	}

	@Override
	public int addBranchEmp(TMdBranchEmp record) {
		// TODO Auto-generated method stub
		int emp = this.sqlSessionTemplate.insert("addBranchEmp", record);
//		int role = this.sqlSessionTemplate.insert("addEmpRole", record);
		return emp;
	}

	@Override
	public TMdBranchEmp selectBranchEmpByNo(String empNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectBranchEmpByNo", empNo);
	}

	@Override
	public BranchEmpModel empDetailInfo(String empNo) {
		TMdBranchEmp emp = this.sqlSessionTemplate.selectOne("selectBranchEmpByNo", empNo);
		List<TMdResidentialArea> arealist = this.sqlSessionTemplate.selectList("selectEmpRoutes", empNo);
		BranchEmpModel branchEmpModel = new BranchEmpModel();
		branchEmpModel.setEmp(emp);
		branchEmpModel.setRoutes(arealist);
		// TODO Auto-generated method stub
		return branchEmpModel;
	}

	@Override
	public int uptBranchEmpByNo(TMdBranchEmp record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptBranchEmpByNo", record);
	}
	
	@Override
	public int uptBranchEmpByBraNo(TMdBranchEmp record){
		return this.sqlSessionTemplate.update("uptBranchEmpByBraNo", record);
	}

	@Override
	public int isEmp(TMdBranchEmp record) {
		return sqlSessionTemplate.selectOne("isEmp",record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public PageInfo searchBranchEmp(EmpQueryModel smodel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("searchBranchEmp",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public List<TMdBranchEmp> queryBranchEmp(EmpQueryModel smodel){
		return sqlSessionTemplate.selectList("searchBranchEmp",smodel);
	}

	@Override
	public TMdBranchEmp selectBranchEmpByEmpNo(String empNo) {
		return sqlSessionTemplate.selectOne("selectBranchEmpByEmpNo",empNo);
	}

	@Override
	public List<TMdBranchEmp> getAllEmpMilkManByBranchNo(String branchNo,String salesOrg) {
		EmpQueryModel smodel = new EmpQueryModel();
		smodel.setBranchNo(branchNo);
		smodel.setSalesOrg(salesOrg);
		return sqlSessionTemplate.selectList("getAllEmpByBranchNo",smodel);
	}

	@Override
	public List<TMdBranchEmp> getAllBranchEmpByNo(BranchEmpSearchModel bModel) {
		return sqlSessionTemplate.selectList("getAllBranchEmpByNo",bModel);
	}

	@Override
	public List<TMdBranchEmp> getAllRationalMilkManByBranchNo(EmpSalQueryModel smodel) {
		return sqlSessionTemplate.selectList("getAllRationalMilkManByBranchNo",smodel);
	}

	@Override
	public List<TMdBranchEmp> getAllEmpBySalesOrg(String salesOrg) {
		return sqlSessionTemplate.selectList("getAllEmpBySalesOrg",salesOrg);
	}

	@Override
	public TMdBranchEmp selectActiveBranchEmpByNo(String empNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectActiveBranchEmpByNo",empNo);
	}

	@Override
	public List<TSsmSalOrder> selectSalOrderByOnlineCode(String sapCode) {
		return sqlSessionTemplate.selectList("selectSalOrderByOnlineCode",sapCode);
	}

	@Override
	public int updateSapCode(TSsmSalOrder ssmSalOrder) {
		return sqlSessionTemplate.update("updateSapCode",ssmSalOrder);
	}
}
