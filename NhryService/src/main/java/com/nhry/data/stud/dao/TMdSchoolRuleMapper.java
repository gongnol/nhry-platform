package com.nhry.data.stud.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.model.stud.SchoolRuleQueryModel;

public interface TMdSchoolRuleMapper {
	/**
	 * 获取该销售组织的订奶信息
	 * @param model
	 * @return
	 */
	PageInfo<TMdSchoolRule> serchSchoolRuleList(SchoolRuleQueryModel model);
   
	
	/**
	 * 更新学校政策
	 */
	int uptSchoolRule(TMdSchoolRule tMdSchoolRule);
	
	/**
	 * 添加学校政策
	 * @param tMdSchoolRule
	 * @return
	 */
	int saveone(TMdSchoolRule tMdSchoolRule);


	TMdSchoolRule findSchoolRuleByMap(Map<String, Object> selectMap);


	/**
	 * 查询出还未设置奶品政策的学校列表
	 * @param salesOrg
	 * @return
	 */
	List<TMdSchool> findAllSchoolWithOutSet(String salesOrg);
}