package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.TMdBranchScopeService;
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

@Path("/branchScope")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/branchScope", description = "网点客户信息(奶站)与配送区域关系信息维护")
public class BranchScopeResource extends BaseResource {
	@Autowired
	private TMdBranchScopeService tMdBranchScopeService;

	@GET
	@Path("/deleteByBranchNo/{branchNo}/{residentNoStr}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/deleteByBranchNo/{branchNo}/{residentNoStr}", response = String.class, notes = "删除奶站下的配送区域")
	public Response deleteAreaByBranchNo(
			@ApiParam(required=true,name="branchNo",value="奶站编号")@PathParam("branchNo")String branchNo,
			@ApiParam(required=true,name="residentNoStr",value="需要删除的配送区域的编号")@PathParam("residentNoStr")String  residentNoStr){
		return convertToRespModel(MessageCode.NORMAL, null,  tMdBranchScopeService.deleteAreaByBranchNo(branchNo,residentNoStr));
	}


}
