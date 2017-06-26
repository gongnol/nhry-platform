package com.nhry.model.stud;

import java.io.Serializable;
import java.util.List;

import com.nhry.data.stud.domain.TMdClass;

/**
*
*@author dai
*/
public class SchoolBoundClassModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 学校
	 */
	private String schoolCode;
	/**
	 * 班级
	 */
	private List<TMdClass> classList;
	
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public List<TMdClass> getClassList() {
		return classList;
	}
	public void setClassList(List<TMdClass> classList) {
		this.classList = classList;
	}
	
	

}
