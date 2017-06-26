package com.nhry.data.stud.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMdSchoolRuleMapper;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.model.stud.SchoolRuleQueryModel;

/**
*学校奶品种政策
*@author dai
*/
public class TMdSchoolRuleMapperImpl implements TMdSchoolRuleMapper {
	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public PageInfo<TMdSchoolRule> serchSchoolRuleList(SchoolRuleQueryModel model) {
		return sqlSessionTemplate.selectListByPages("serchSchoolRuleList", model, Integer.parseInt(model.getPageNum()), Integer.parseInt(model.getPageSize()));
	}

	@Override
	public int uptSchoolRule(TMdSchoolRule tMdSchoolRule) {
		return sqlSessionTemplate.update("updateReule", tMdSchoolRule);
	}
	
	@Override
	public int saveone(TMdSchoolRule tMdSchoolRule) {
		return sqlSessionTemplate.insert("saveone", tMdSchoolRule);
	}

	@Override
	public TMdSchoolRule findSchoolRuleByMap(Map<String, Object> selectMap) {
		return sqlSessionTemplate.selectOne("findSchoolRuleByMap", selectMap);
	}

	@Override
	public List<TMdSchool> findAllSchoolWithOutSet(String salesOrg) {
		return sqlSessionTemplate.selectList("findAllSchoolWithOutSet", salesOrg);
	}

}
