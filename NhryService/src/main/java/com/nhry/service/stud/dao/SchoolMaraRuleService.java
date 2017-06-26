package com.nhry.service.stud.dao;

import java.util.List;

import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.data.stud.domain.TMdSchoolMaraRuleBase;
import com.nhry.model.stud.SchoolMaraRuleModel;

/**
*
*@author dai
*/
public interface SchoolMaraRuleService {
	/**
	 * 获取学校损耗政策
	 * @param mdel
	 * @return
	 */
	 List<TMdSchoolMaraRule> findSchoolMaraRule(SchoolMaraRuleModel mdel);
	 /**
	  * 添加损耗政策
	  * @param mdel
	  * @return
	  */
	 int intsertinfo(SchoolMaraRuleModel mdel);
	 /**
	  * 删除政策
	  * @param mdel
	  * @return
	  */
//	 int deleteByModel(SchoolMaraRuleModel mdel);
	 /**
	 * 获取学校损耗政策基数
	 * @param mdel
	 * @return
	 */
	 TMdSchoolMaraRuleBase findMaraRuleBaseByModel(SchoolMaraRuleModel mdel);

}
