package com.nhry.data.stud.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.model.stud.ClassQueryModel;

public interface TMdClassMapper {
	
	int deleteByClassCode(String classCode);
	
	int deleteByClass(TMdClass mdClass);
	
    int insertClass(TMdClass mdClass);

    TMdClass selectByClassCode(String classCode);

    int updateTMdClass(TMdClass mdClass);
    
    List<TMdClass> findClassListBySalesOrg(String salesOrg);
    
    List<TMdClass> findClassListBySalesOrg10(String salesOrg);
    
    PageInfo<TMdClass> findClassPage(ClassQueryModel queryModel);


	List<TMdClass> findClassListBySalesOrgNotIn(Map<String, Object> selectClassMap);

	
}