package com.nhry.service.stud.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.stud.dao.TMdSchoolRuleMapper;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.model.stud.SchoolRuleQueryModel;
import com.nhry.service.stud.dao.SchoolRuleService;

/**
*
*@author dai
*/
public class SchoolRuleServiceImpl  implements SchoolRuleService {
	
	@Autowired
	private TMdSchoolRuleMapper tMdSchoolRuleMapper;
	
	@Autowired
	private UserSessionService userSessionService;
	
	
	@Override
	public PageInfo<TMdSchoolRule> findSchoolRulePage(SchoolRuleQueryModel model) {
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if( StringUtils.isBlank(sysuser.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校未关联销售组织:"+model.getSchoolCode());
		}
		model.setSalesOrg(sysuser.getSalesOrg());
		return tMdSchoolRuleMapper.serchSchoolRuleList(model);
	}
	

	@Override
	public int uptSchoolRule(TMdSchoolRule tMdSchoolRule) {
		TSysUser currentUser = this.userSessionService.getCurrentUser();
		if( StringUtils.isBlank(currentUser.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校未关联销售组织:"+tMdSchoolRule.getSchoolCode());
		}
		if(StringUtils.isNotBlank(tMdSchoolRule.getMid())){
			Date date = new Date();
			tMdSchoolRule.setLastModified(date);
			tMdSchoolRule.setLastModifiedBy(currentUser.getLoginName());
			tMdSchoolRule.setLastModifiedByTxt(currentUser.getDisplayName());
			return tMdSchoolRuleMapper.uptSchoolRule(tMdSchoolRule);
		}else{
			Date date = new Date();
			tMdSchoolRule.setMid(UUID.randomUUID().toString().replace("-", ""));
			tMdSchoolRule.setCreateAt(date);
			tMdSchoolRule.setCreateBy(currentUser.getLoginName());
			tMdSchoolRule.setCreateByTxt(currentUser.getDisplayName());
			tMdSchoolRule.setLastModified(date);
			tMdSchoolRule.setLastModifiedBy(currentUser.getLoginName());
			tMdSchoolRule.setLastModifiedByTxt(currentUser.getDisplayName());
			tMdSchoolRule.setSalesOrg(currentUser.getSalesOrg());
			return tMdSchoolRuleMapper.saveone(tMdSchoolRule);
		}
	}


	@Override
	public List<TMdSchool> findAllSchoolWithOutSet() {
		TSysUser currentUser = this.userSessionService.getCurrentUser();
		if( StringUtils.isBlank(currentUser.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未关联销售组织");
		}
		return tMdSchoolRuleMapper.findAllSchoolWithOutSet(currentUser.getSalesOrg());
	}


}
