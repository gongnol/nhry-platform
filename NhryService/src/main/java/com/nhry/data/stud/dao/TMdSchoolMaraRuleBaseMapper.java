package com.nhry.data.stud.dao;

import com.nhry.data.stud.domain.TMdSchoolMaraRuleBase;
import com.nhry.model.stud.SchoolMaraRuleModel;

public interface TMdSchoolMaraRuleBaseMapper {
	/**
	 * 获取学校奶政策基数
	 * @param mdel
	 * @return
	 */
	TMdSchoolMaraRuleBase findMaraRuleBaseByModel(SchoolMaraRuleModel mdel);
	
	 /**
	  * 添加损耗政策基数
	  * @param mdel
	  * @return
	  */
	 int intsertinfo(TMdSchoolMaraRuleBase tMdSchoolMaraRuleBase);
	 /**
	  * 添加损耗政策基数
	  * @param tMdSchoolMaraRuleBase
	  * @return
	  */
	 int deleteBySalesOrgAndSchoolCode(String salesOrg, String schoolCode);

	
	
}