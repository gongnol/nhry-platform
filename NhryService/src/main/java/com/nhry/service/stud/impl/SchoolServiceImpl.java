package com.nhry.service.stud.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.service.BaseService;
import com.nhry.service.stud.dao.SchoolService;

/**
*
*@author dai
*/

public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private TMdSchoolMapper tMdSchoolMapper;

	@Override
	public PageInfo<TMdSchool> findSchoolPage(SchoolQueryModel model) {
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if(StringUtils.isEmpty(sysuser.getSalesOrg())){
			return null;
		}
		model.setSalesOrg(sysuser.getSalesOrg());
		return tMdSchoolMapper.serchSchoolList(model);
	}

	@Override
	public List<TMdSchool> findSchoolList(SchoolQueryModel model) {
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if(StringUtils.isEmpty(sysuser.getSalesOrg())){
			return null;
		}
		return tMdSchoolMapper.findSchoolList(model);
	}
	
	@Override
	public int updateSchool(TMdSchool tMdSchool) {
		TSysUser sysuser = this.userSessionService.getCurrentUser();
		if(StringUtils.isEmpty(sysuser.getSalesOrg())){
			return 0;
		}
		return tMdSchoolMapper.updateStatusByTMdSchool(tMdSchool);
	}

}
