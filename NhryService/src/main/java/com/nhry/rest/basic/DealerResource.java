package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.DealerService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/dealer")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/dealer", description = "经销商信息维护")
public class DealerResource extends BaseResource {
	@Autowired
	private DealerService dealerService;

	@GET
	@Path("/getDealerBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerBySalesOrg", response = List.class, notes = "根据销售组织查询经销商信息列表")
	public Response findBranchListByOrg(){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealerBySalesOrg());
	}

	@GET
	@Path("/getDealerOnAuth")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getDealerOnAuth", response = List.class, notes = "查询经销商信息列表")
	public Response getDealerOnAuth(){
		return convertToRespModel(MessageCode.NORMAL, null,dealerService.getDealerOnAuth());
	}


}
