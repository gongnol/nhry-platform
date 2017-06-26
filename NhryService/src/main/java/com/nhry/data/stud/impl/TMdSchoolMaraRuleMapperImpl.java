package com.nhry.data.stud.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMdSchoolMaraRuleMapper;
import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.model.stud.SchoolMaraRuleModel;

/**
*
*@author dai
*/
public class TMdSchoolMaraRuleMapperImpl  implements TMdSchoolMaraRuleMapper{

	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<TMdSchoolMaraRule> findSchoolMaraRule(SchoolMaraRuleModel mdel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("findSchoolMaraRule",mdel);
	}

	@Override
	public int intsertinfo(TMdSchoolMaraRule tMdSchoolMaraRule) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("intsertinfo",tMdSchoolMaraRule);
	}
	
	@Override
	public int deleteByModel(SchoolMaraRuleModel mdel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteByModel",mdel);
	}

	@Override
	public TMdSchoolMaraRule findSchoolMaraRuleForMatnr(HashMap<String, Object> selectMap) {
		return sqlSessionTemplate.selectOne("findSchoolMaraRuleForMatnr", selectMap);
	}
	
}
