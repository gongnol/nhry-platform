package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.model.basic.CustOperationQueryModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.OperationLogService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/operationLog")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/operationLog", description = "日志信息维护")
public class OperationLogResource extends BaseResource {
    @Autowired
    private OperationLogService operationLogService;

    @POST
    @Path("/getCustOperationLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getCustOperationLog", response = List.class, notes = "根据销售组织查询经销商信息列表")
    public Response findBranchListByOrg(@ApiParam(required=true,name="branchModel",value="SearchModel") CustOperationQueryModel cModel){
        return convertToRespModel(MessageCode.NORMAL, null,operationLogService.getCustOperationLog(cModel));
    }

    @POST
    @Path("/getOrderOperationLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getOrderOperationLog", response = List.class, notes = "订单日志列表")
    public Response getOrderLogList(@ApiParam(required=true,name="branchModel",value="SearchModel") CustOperationQueryModel cModel){
        return convertToRespModel(MessageCode.NORMAL, null,operationLogService.getOrderOperationLog(cModel));
    }

    @POST
    @Path("/getPlanOperationLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getPlanOperationLog", response = List.class, notes = "订奶计划日志列表")
    public Response getPlanLogList(@ApiParam(required=true,name="branchModel",value="SearchModel") CustOperationQueryModel cModel){
        return convertToRespModel(MessageCode.NORMAL, null,operationLogService.getPlanOperationLog(cModel));
    }

    @POST
    @Path("/getRouteOperationLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getRouteOperationLog", response = List.class, notes = "路单日志列表")
    public Response getRouteLogList(@ApiParam(required=true,name="branchModel",value="SearchModel") CustOperationQueryModel cModel){
        return convertToRespModel(MessageCode.NORMAL, null,operationLogService.getRouteOperationLog(cModel));
    }
}
