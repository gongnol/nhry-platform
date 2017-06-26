package com.nhry.service.stud.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.model.stud.SchoolRuleQueryModel;

public interface SchoolRuleService {
	/**
	 * 获取该销售组织的订奶信息
	 * @param model
	 * @return
	 */
	PageInfo<TMdSchoolRule> findSchoolRulePage(SchoolRuleQueryModel model);
   
	
	/**
	 * 更新学校政策
	 */
	int uptSchoolRule(TMdSchoolRule tMdSchoolRule);


	/**
	 * 查询出还未设置奶品政策的学校列表
	 * @return
	 */
	List<TMdSchool> findAllSchoolWithOutSet();
	
}
