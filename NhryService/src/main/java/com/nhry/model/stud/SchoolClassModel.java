package com.nhry.model.stud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nhry.data.stud.domain.TMdClass;

/**
 * @author zhaoxijun
 */
public class SchoolClassModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String salesOrg;
	private String schoolCode;
	private List<TMdClass> tMdClass=new ArrayList<TMdClass>();
	
	public SchoolClassModel() {
		super();
	}
	public SchoolClassModel(String salesOrg, String schoolCode) {
		super();
		this.salesOrg = salesOrg;
		this.schoolCode = schoolCode;
	}
	public List<TMdClass> gettMdClass() {
		return tMdClass;
	}
	public void settMdClass(List<TMdClass> tMdClass) {
		this.tMdClass = tMdClass;
	}
	public String getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	
	
	
	
	
	
}
