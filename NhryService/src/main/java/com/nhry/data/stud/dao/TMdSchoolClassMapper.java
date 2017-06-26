package com.nhry.data.stud.dao;

import java.util.List;

import com.nhry.data.stud.domain.TMdClass;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolClass;
import com.nhry.model.stud.SchoolClassModel;

public interface TMdSchoolClassMapper {

    int insertSchoolClass(TMdSchoolClass record);
    
    int delSchoolClassBySalesOrg(SchoolClassModel schoolClassModel);

    List<TMdClass> findAllClassBySchool(SchoolClassModel schoolClassModel);
    
    List<TMdClass> findNoneClassBySchool(SchoolClassModel schoolClassModel);
}