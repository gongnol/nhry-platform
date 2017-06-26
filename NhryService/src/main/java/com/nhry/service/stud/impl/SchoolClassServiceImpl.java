package com.nhry.service.stud.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.stud.dao.TMdSchoolClassMapper;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolClass;
import com.nhry.model.stud.SchoolClassModel;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.service.stud.dao.SchoolClassService;

/**
 * @author zhaoxijun
 */
public class SchoolClassServiceImpl implements SchoolClassService {

	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private TMdSchoolClassMapper schoolClassMapper;
	
	@Autowired
	private TMdSchoolMapper schoolMapper;
	
	@Override
	public int addSchoolClass(SchoolClassModel schoolClassModel) {
		
		if(null == schoolClassModel || null == schoolClassModel.getSchoolCode()){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		
		TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(schoolClassModel.getSchoolCode(),userSessionService.getCurrentUser().getSalesOrg()) );
		
		if(null == school || !"10".equals(school.getVisiable())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校不存在:"+schoolClassModel.getSchoolCode());
		}
		
		
		if(StringUtils.isBlank(school.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校未关联销售组织:"+schoolClassModel.getSchoolCode());
		}
		int result = 0;
		TMdSchoolClass item = new TMdSchoolClass(schoolClassModel.getSchoolCode());
		Date date = new Date();
		item.setCreateAt(date);
		item.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
		item.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		item.setLastModified(date);
		item.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		item.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		item.setSalesOrg(school.getSalesOrg());
		
		delSchoolClassBySalesOrg(schoolClassModel);
		List<TMdClass> gettMdClass = schoolClassModel.gettMdClass();
		for(TMdClass tMdClass : gettMdClass){
			item.setMid(UUID.randomUUID().toString().replace("-", ""));
			item.setClassCode(tMdClass.getClassCode());
			result += schoolClassMapper.insertSchoolClass(item);
		}
		return result;
	}

	@Override
	public int delSchoolClassBySalesOrg(SchoolClassModel schoolClassModel) {
		if(null == schoolClassModel || null == schoolClassModel.getSchoolCode()){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		schoolClassModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		
		return schoolClassMapper.delSchoolClassBySalesOrg(schoolClassModel);
	}

	@Override
	public List<TMdClass> findAllClassBySchool(SchoolClassModel schoolClassModel) {
		if(null == schoolClassModel || null == schoolClassModel.getSchoolCode()){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		schoolClassModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		
		return schoolClassMapper.findAllClassBySchool(schoolClassModel);
	}

	@Override
	public List<TMdClass> findNoneClassBySchool(SchoolClassModel schoolClassModel) {
		if(null == schoolClassModel || null == schoolClassModel.getSchoolCode()){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		schoolClassModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		List<TMdClass> findNoneClassBySchool = schoolClassMapper.findNoneClassBySchool(schoolClassModel);
		return findNoneClassBySchool;
	}

}
