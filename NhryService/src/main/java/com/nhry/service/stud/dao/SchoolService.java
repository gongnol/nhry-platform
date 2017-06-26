package com.nhry.service.stud.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.model.stud.SchoolQueryModel;

public interface SchoolService {
	/**
	 * 学校查询
	 * @param model
	 * @return
	 */
	PageInfo<TMdSchool>  findSchoolPage(SchoolQueryModel model);
	
	/**
	 * 查询所有学校
	 */
	List<TMdSchool>  findSchoolList(SchoolQueryModel model);
	
	/**
	 * 更新学校
	 * @param model
	 * @return
	 */
	int updateSchool(TMdSchool model);
	
	
	
	
}
