package com.nhry.data.stud.dao;

import java.util.HashMap;
import java.util.List;

import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.model.stud.SchoolMaraRuleModel;

public interface TMdSchoolMaraRuleMapper {
	/**
	 * 获取学校政策
	 * @param mdel
	 * @return
	 */
	 List<TMdSchoolMaraRule> findSchoolMaraRule(SchoolMaraRuleModel mdel);
	 /**
	  * 添加损耗政策
	  * @param mdel
	  * @return
	  */
	 int intsertinfo(TMdSchoolMaraRule tMdSchoolMaraRule);
	 /**
	  * 删除政策
	  * @param mdel
	  * @return
	  */
	 int deleteByModel(SchoolMaraRuleModel mdel);
	 
	 
	 /**
	 * @param selectMap
	 * @return
	 */
	TMdSchoolMaraRule findSchoolMaraRuleForMatnr(HashMap<String, Object> selectMap);
	
	 
}