package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.config.domain.NHSysParameter;
import com.nhry.model.basic.BranchEmpSearchModel;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.pojo.BranchEmpModel;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emp")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/emp", description = "网点员工信息维护")
public class BranchEmpResource extends BaseResource {
	@Autowired
	private BranchEmpService branchEmpService;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/add", response = ResponseModel.class, notes = "增加网点员工")
	public Response addBranchEmp(@ApiParam(required=true,name="record",value="系统参数json格式")TMdBranchEmp record){
		return convertToRespModel(MessageCode.NORMAL, null,  branchEmpService.addBranchEmp(record,true));
	}
	
	@POST
	@Path("/upt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = String.class, notes = "修改网点员工信息")
	public Response uptBranchEmp(@ApiParam(required=true,name="record",value="系统参数json格式") TMdBranchEmp record){
		return convertToRespModel(MessageCode.NORMAL, null,  branchEmpService.uptBranchEmpByNo(record));
	}
	
	@POST
	@Path("/del/{empNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/del/{empNo}", response = String.class, notes = "删除员工信息")
	public Response delBranchEmp(@ApiParam(required=true,name="empNo",value="员工编号")@PathParam("empNo")String empNo){
		return convertToRespModel(MessageCode.NORMAL, null,  branchEmpService.deleteBranchEmpByNo(empNo));
	}
	
	@GET
	@Path("/{empNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{empNo}", response = BranchEmpModel.class, notes = "根据员工编号查询员工详细信息")
	public Response findBranchEmpByNo(@ApiParam(required=true,name="empNo",value="员工编号") @PathParam("empNo") String empNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.empDetailInfo(empNo));
	} 
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{search}", response = NHSysParameter.class, notes = "查询员工信息列表")
	public Response findBranchEmpByNo(@ApiParam(required=true,name="smodel",value="SearchModel") EmpQueryModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.searchBranchEmp(smodel));
	}

	@GET
	@Path("/getAllEmpByBranchNo")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAllEmpByBranchNo", response = Response.class, notes = "获取奶站下的所有送奶员")
	public Response getAllEmpByBranchNo(@ApiParam(required=true,name="branchNo",value="奶站编号") @QueryParam("branchNo")String branchNo){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.getAllEmpByBranchNo(branchNo));
	}


	@POST
	@Path("/getAllBranchEmpByNo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAllBranchEmpByNo", response = Response.class, notes = "获取奶站下的所有员工")
	public Response getAllBranchEmpByNo(@ApiParam(required=true,name="bModel",value="branchNo-奶站编号,type='milkMan'送奶工 type!='milkMan' （员工）") BranchEmpSearchModel bModel){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.getAllBranchEmpByNo(bModel));
	}

	@GET
	@Path("/getAllEmpBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getAllEmpBySalesOrg", response = Response.class, notes = "获取本销售组织下的所有员工")
	public Response getAllEmpBySalesOrg(){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.getAllEmpBySalesOrg());
	}

	@POST
	@Path("/getComPanyAllBranch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getComPanyAllBranch", response = Response.class, notes = "查询登录员工所属公司下所有的奶站")
	public Response getComPanyAllBranch(){
		return convertToRespModel(MessageCode.NORMAL, null,branchEmpService.getComPanyAllBranch());
	}




}
