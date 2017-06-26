package com.nhry.rest.stud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.data.stud.domain.TMdSchoolMaraRuleBase;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.model.stud.ClassListModel;
import com.nhry.model.stud.SchoolMaraRuleModel;
import com.nhry.model.stud.SchoolClassModel;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.model.stud.SchoolRuleQueryModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.stud.dao.ClassService;
import com.nhry.service.stud.dao.SchoolClassService;
import com.nhry.service.stud.dao.SchoolMaraRuleService;
import com.nhry.service.stud.dao.SchoolRuleService;
import com.nhry.service.stud.dao.SchoolService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
*
*@author dai
*/
@Path("/studentMilk")
@Controller
@Singleton
@Scope("request")
@Api(value = "/studentMilk",description = "学生奶")
public class StudentMilkResource  extends BaseResource {
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SchoolRuleService schoolRuleService;
	
	
	@Autowired
	private SchoolMaraRuleService schoolMaraRuleService;
	
	
	
	/*********************************学校基础信息********************************/
	@POST
	@Path("/school/findSchoolPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/school/findSchoolPage", response = PageInfo.class, notes = "获取学校信息列表")
	public Response findSchoolPage(@ApiParam(required=true,name="smodel",value="SearchModel") SchoolQueryModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolService.findSchoolPage(smodel));
	}
	
	@POST
	@Path("/school/upt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/school/upt", response = Integer.class, notes = "更新商品信息")
	public Response uptProduct(@ApiParam(required=true,name="record",value="系统参数json格式")TMdSchool tMdSchool){
		return convertToRespModel(MessageCode.NORMAL, null,  schoolService.updateSchool(tMdSchool));
	}
	
	/*********************************班级基础信息********************************/
	@GET
	@Path("/class/findClassListBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/studentClass/findClassListBySalesOrg", response = List.class, notes = "查询班级列表")
	public Response findClassListBySalesOrg(@ApiParam(required=false,name="salesOrg") @QueryParam("salesOrg")String salesOrg){
		return convertToRespModel(MessageCode.NORMAL, null,  classService.findClassListBySalesOrg(salesOrg));
	}
	
	@POST
	@Path("/class/addClassList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/studentClass/addClassList", response =Integer.class, notes = "新增班级")
	public Response addClassList(@ApiParam(required=true, name="mdClass") ClassListModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, classService.addClassList(smodel));
	}
	
	/*********************************学校班级基础信息********************************/
	@POST
	@Path("/schoolClass/addSchoolClass")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolClass/addSchoolClass", response = int.class, notes = "新增学校班级关联信息")
	public Response addSchoolClass(@ApiParam(required=true, name="schoolClassModel") SchoolClassModel schoolClassModel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolClassService.addSchoolClass(schoolClassModel));
	}

	@POST
	@Path("/schoolClass/findAllClassBySchool")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolClass/findAllClassBySchool", response = List.class, notes = "查询学校关联的班级列表")
	public Response findAllClassBySchool(@ApiParam(required=true, name="schoolClassModel") SchoolClassModel schoolClassModel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolClassService.findAllClassBySchool(schoolClassModel));
	}
	
	@POST
	@Path("/schoolClass/findNoneClassBySchool")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolClass/findNoneClassBySchool", response = List.class, notes = "查询学校还未关联的班级列表")
	public Response findNoneClassBySchool(@ApiParam(required=true, name="schoolClassModel") SchoolClassModel schoolClassModel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolClassService.findNoneClassBySchool(schoolClassModel));
	}
	
	
	/*********************************学校订奶政策设置基础信息********************************/
	@POST
	@Path("/schoolRule/findSchoolPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolRule/findSchoolPage", response = PageInfo.class, notes = "通过销售组织获取学校订奶政策")
	public Response findSchoolRulePage(@ApiParam(required=true,name="smodel",value="SearchModel") SchoolRuleQueryModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolRuleService.findSchoolRulePage(smodel));
	}
	
	@POST
	@Path("/schoolRule/uptSchoolRule")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolRule/uptSchoolRule", response = Integer.class, notes = "修改订奶政策")
	public Response uptSchoolRule(@ApiParam(required=true,name="tMdSchoolRule",value="tMdSchoolRule") TMdSchoolRule tMdSchoolRule){
		return convertToRespModel(MessageCode.NORMAL, null, schoolRuleService.uptSchoolRule(tMdSchoolRule));
	}
	
	@POST
	@Path("/schoolRule/findAllSchoolWithOutSet")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolRule/findAllSchoolWithOutSet", response = List.class, notes = "查询出还未设置奶品政策的学校列表")
	public Response findAllSchoolWithOutSet(){
		return convertToRespModel(MessageCode.NORMAL, null, schoolRuleService.findAllSchoolWithOutSet());
	}

	/*********************************学校订奶政策损耗基础信息********************************/
	
	@POST
	@Path("/schoolMaraRule/findMaraRuleList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolMaraRule/findMaraRuleList", response = TMdSchoolMaraRule.class, notes = "通过学校和销售组织获取当前学校的所有的损耗政策")
	public Response findMaraRuleList(@ApiParam(required=true,name="smodel",value="SearchModel") SchoolMaraRuleModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolMaraRuleService.findSchoolMaraRule(smodel));
	}
	

	@POST
	@Path("/schoolMaraRule/findMaraRuleBaseByModel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolMaraRule/findMaraRuleBaseByModel", response = TMdSchoolMaraRuleBase.class, notes = "通过学校和销售组织获取当前学校的损耗政策基数")
	public Response findMaraRuleBaseByModel(@ApiParam(required=true,name="smodel",value="SearchModel") SchoolMaraRuleModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolMaraRuleService.findMaraRuleBaseByModel(smodel));
	}
	
	
	@POST
	@Path("/schoolMaraRule/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/schoolMaraRule/save", response = Integer.class, notes = "保存学校的订奶损耗政策")
	public Response saveSchoolRule(@ApiParam(required=true,name="smodel",value="smodel") SchoolMaraRuleModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, schoolMaraRuleService.intsertinfo(smodel));
	}
	

}
