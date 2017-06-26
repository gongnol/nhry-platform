package com.nhry.data.stud.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.model.stud.SchoolQueryModel;

/**
*
*@author dai
*/
public class TMdSchoolMapperImpl implements TMdSchoolMapper {
	
	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;

    
	@Override
	public PageInfo<TMdSchool> serchSchoolList(SchoolQueryModel model) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectListByPages("serchSchoolList", model, Integer.parseInt(model.getPageNum()), Integer.parseInt(model.getPageSize()));
	}
	

	@Override
	public int updateStatusByTMdSchool(TMdSchool tMdSchool) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateStatusByTMdSchool", tMdSchool);
	}
	
	@Override
	public int updateByTMdSchool(TMdSchool tMdSchool) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updateByTMdSchool", tMdSchool);
	}
	
	
	
	
	
	@Override
	public List<TMdSchool> findSchoolList(SchoolQueryModel model) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("serchSchoolList", model);
	}

	@Override
	public TMdSchool selectByPrimaryKey(SchoolQueryModel model) {
		return sqlSessionTemplate.selectOne("selectOne", model);
	}


	@Override
	public TMdSchool selectByEmpCode(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("selectByEmpCode", map);
	}


	@Override
	public int saveSchool(TMdSchool tMdSchool) {
		return sqlSessionTemplate.insert("saveSchool", tMdSchool);
	}


	@Override
	public List<TMdSchool> findSchoolListForBuildBatchOrder(String salesOrg) {
		return sqlSessionTemplate.selectList("findSchoolListForBuildBatchOrder", salesOrg);
	}


	
	
	



	

}
