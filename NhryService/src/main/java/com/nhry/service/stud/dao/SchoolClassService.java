package com.nhry.service.stud.dao;

import java.util.List;

import com.nhry.data.stud.domain.TMdClass;
import com.nhry.model.stud.SchoolClassModel;

/**
 * @author zhaoxijun
 */
public interface SchoolClassService {
    int addSchoolClass(SchoolClassModel schoolClassModel);
    
    int delSchoolClassBySalesOrg(SchoolClassModel schoolClassModel);

    List<TMdClass> findAllClassBySchool(SchoolClassModel schoolClassModel);
    
    List<TMdClass> findNoneClassBySchool(SchoolClassModel schoolClassModel);
}
