package com.nhry.service.stud.dao;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.model.stud.ClassListModel;
import com.nhry.model.stud.ClassQueryModel;

/**
 * @author zhaoxijun
 * @data 2017年4月10日
 */
public interface ClassService {
	
	/**
	 * 查询班级
	 * findClassByClassCode
	 * @param classCode
	 * @return
	 */
	TMdClass findClassByClassCode(String classCode);
	
	/**
	 * 查询班级列表
	 * @param salesOrg
	 * @return
	 */
	List<TMdClass> findClassListBySalesOrg(String salesOrg);
	
	/**
	 * 分页查询班级列表
	 * @param queryModel
	 * @return
	 */
	PageInfo<TMdClass> findClassPage(ClassQueryModel queryModel);
	
	/**
	 * 添加班级
	 * @return
	 */
	int addClass(TMdClass mdClass);
	
	/**
	 * 添加班级
	 * @return
	 */
	int addClassList(ClassListModel smodel);
	
	/**更新班级
	 * @param mdClass
	 * @return
	 */
	int updClass(TMdClass mdClass);
	
	/**
	 * 删除班级
	 * @param classCode
	 * @return
	 */
	int delClass(String classCode);
}
