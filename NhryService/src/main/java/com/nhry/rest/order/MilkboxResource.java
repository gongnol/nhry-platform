package com.nhry.rest.order;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.order.domain.TMilkboxPlan;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.order.*;
import com.nhry.rest.BaseResource;
import com.nhry.service.order.dao.MilkBoxService;
import com.nhry.service.order.dao.OrderService;
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

import java.util.ArrayList;

@Path("/milkbox")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/milkbox", description = "奶箱信息维护")
public class MilkboxResource extends BaseResource {
	@Autowired
	private MilkBoxService milkBoxService;
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search", response = PageInfo.class, notes = "查询奶箱信息列表")
	public Response findMilkboxes(@ApiParam(required=true,name="smodel",value="SearchModel") MilkboxSearchModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.searchMilkBox(smodel));
	}

	@POST
	@Path("/selectMilkboxsCount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/selectMilkboxsCount", response = Integer.class, notes = "查询未装箱数量")
	public Response selectMilkboxsCount(){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.selectMilkboxsCount());
	}
	
	@GET
	@Path("/{planNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{planNo}", response = TMilkboxPlan.class, notes = "根据装箱单号查询详细")
	public Response selectMilkboxplanByCode(@ApiParam(required=true,name="planNo",value="装箱单号") @PathParam("planNo") String planNo){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.selectMilkboxByPlanNo(planNo));
	}
	
	@POST
	@Path("/upt")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = Integer.class, notes = "更新奶箱")
	public Response uptMilkbox(@ApiParam(required=true,name="smodel",value="SearchModel") MilkboxCreateModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.updateMilkboxStatus(smodel));
	}
	
	@POST
	@Path("/addNewPlan")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/addNewPlan", response = Integer.class, notes = "新增奶箱")
	public Response addNewPlan(@ApiParam(required=true,name="smodel",value="SearchModel") MilkboxCreateModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.addNewMilkboxPlan(smodel));
	}
	
	@POST
	@Path("/uptByList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptByList", response = Integer.class, notes = "批量更新奶箱")
	public Response uptByList(@ApiParam(required=true,name="smodel",value="SearchModel") MilkboxCreateModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.updateMilkboxStatusByList(smodel));
	}
	
	@GET
	@Path("/printPlan")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/uptByList", response = Integer.class, notes = "打印更新状态")
	public Response printPlan(@ApiParam(required=true,name="planNo",value="装箱单号") @PathParam("planNo") String planNo){
		return convertToRespModel(MessageCode.NORMAL, null, milkBoxService.updateMilkboxPlanPrinted(planNo));
	}

}
