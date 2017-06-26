package com.nhry.model.stud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.data.stud.domain.TMdSchoolMaraRuleBase;

/**
*
*@author dai
*/
public class SchoolMaraRuleModel  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String salesOrg;
	//学校
	private String schoolCode;
	//学校基数
	private TMdSchoolMaraRuleBase ruleBase;
	//班级
	private List<TMdSchoolMaraRule> schoolMaraList;
	
	
	public SchoolMaraRuleModel() {
		super();
	}

	public SchoolMaraRuleModel(String salesOrg, String schoolCode,
			TMdSchoolMaraRuleBase ruleBase,
			List<TMdSchoolMaraRule> schoolMaraList) {
		super();
		this.salesOrg = salesOrg;
		this.schoolCode = schoolCode;
		this.ruleBase = ruleBase;
		this.schoolMaraList = schoolMaraList;
	}

	public TMdSchoolMaraRuleBase getRuleBase() {
		return ruleBase;
	}

	public void setRuleBase(TMdSchoolMaraRuleBase ruleBase) {
		this.ruleBase = ruleBase;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public List<TMdSchoolMaraRule> getSchoolMaraList() {
		return schoolMaraList;
	}

	public void setSchoolMaraList(List<TMdSchoolMaraRule> schoolMaraList) {
		this.schoolMaraList = schoolMaraList;
	}



	
	
	
}
