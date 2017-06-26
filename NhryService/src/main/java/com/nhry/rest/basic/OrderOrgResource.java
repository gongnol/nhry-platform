package com.nhry.rest.basic;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.orderorg.domain.TMdOrderOrg;
import com.nhry.data.orderorg.domain.TMdOrgCustKey;
import com.nhry.model.basic.OrderOrgModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.OrderOrgService;
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

/**
 * Created by huaguan on 2016/12/1.
 */
@Path("/orderOrg")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/orderOrg", description = "机构信息维护")
public class OrderOrgResource extends BaseResource {
    @Autowired
    private OrderOrgService orderOrgService;

    @POST
    @Path("/findTMdOrderOrgList")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findTMdOrderOrgList", response = PageInfo.class, notes = "查询机构信息列表")
    public Response findTMdOrderOrgList(@ApiParam(required=true,name="orderOrg",value="机构查询") OrderOrgModel sModel){
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.findTMdOrderOrgList(sModel));
    }

    @GET
    @Path("/getOrderOrgByNo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getOrderOrgByNo/{id}", response = String.class, notes = "根据机构ID查询机构信息")
    public Response getOrderOrgByNo(@ApiParam(required=true,name="id",value="机构ID")  @PathParam("id") String id){
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.selectOrderOrgByPrimaryKey(id));
    }


    @POST
    @Path("/uptOrderOrg")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/uptOrderOrg", response = String.class, notes = "更新机构信息")
    public Response uptOrderOrg(@ApiParam(required=true,name="OrderOrgModel",value="OrderOrgModel") OrderOrgModel sModel){
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.updateOrderOrgByPrimaryKeySelective(sModel));
    }

    @POST
    @Path("/addOrderOrg")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/addOrderOrg", response = ResponseModel.class, notes = "添加机构信息")
    public Response addOrderOrg(@ApiParam(required=true,name="orderOrg",value="机构信息对象")TMdOrderOrg sModel) {
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.insertOrderOrg(sModel));
    }

    @POST
    @Path("/addOrgCust")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/addOrgCust", response = ResponseModel.class, notes = "添加机构订户关系")
    public Response addOrgCust(@ApiParam(required=true,name="orderOrg",value="机构订户关联关系")TMdOrgCustKey sModel) {
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.insertOrgCust(sModel));
    }

    @POST
    @Path("/deleteOrgCust")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/deleteOrgCust", response = ResponseModel.class, notes = "删除机构订户关联关系")
    public Response deleteOrgCust(@ApiParam(required=true,name="delorderOrg",value="机构订户关联关系")TMdOrgCustKey sModel) {
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.deleteByPrimaryKey(sModel));
    }

    @GET
    @Path("/getOrderOrgName")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getOrderOrgName", response = String.class, notes = "查询该销售组织下机构名称")
    public Response getOrderOrgName(){
        return convertToRespModel(MessageCode.NORMAL, null,orderOrgService.findOrderOrgListForSelect());
    }
}
