package com.nhry.data.stud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stud.dao.TMdSchoolClassMapper;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolClass;
import com.nhry.model.stud.SchoolClassModel;

public class TMdSchoolClassMapperImpl implements TMdSchoolClassMapper {

	@Autowired
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertSchoolClass(TMdSchoolClass mdSchoolClass) {
		return sqlSessionTemplate.insert("insertSchoolClass", mdSchoolClass);
	}

	@Override
	public int delSchoolClassBySalesOrg(SchoolClassModel schoolClassModel) {
		return sqlSessionTemplate.delete("delSchoolClassBySalesOrg", schoolClassModel);
	}

	@Override
	public List<TMdClass> findAllClassBySchool(SchoolClassModel schoolClassModel) {
		return sqlSessionTemplate.selectList("findAllClassBySchool", schoolClassModel);
	}

	@Override
	public List<TMdClass> findNoneClassBySchool(SchoolClassModel schoolClassModel) {
		return sqlSessionTemplate.selectList("findAllClassBySchool", schoolClassModel);
	}


}
