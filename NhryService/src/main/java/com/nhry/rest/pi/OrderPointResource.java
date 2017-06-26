package com.nhry.rest.pi;

import com.nhry.common.exception.MessageCode;
import com.nhry.model.milktrans.OrderPointListModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.milktrans.dao.OrderPointService;
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

/**
 * Created by cbz on 8/17/2016.
 */
@Path("/orderPoint")
@Controller
@Component
@Scope("request")
@Singleton
@Api(value = "/orderPoint", description = "销售订单会员积分明细更新")
public class OrderPointResource extends BaseResource{
    @Autowired
    private OrderPointService orderPointService;
    @POST
    @Path("/uptOrderPoint")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/uptOrderPoint", response = ResponseModel.class, notes = "销售订单会员积分明细更新")
    public Response uptOrderPoint(@ApiParam(name = "models",value = "积分明细",required = true)OrderPointListModel models){
        return convertToRespModel(MessageCode.NORMAL,null,orderPointService.uptYfrechAndYGrowthByOrderNoAndItemNo(models.getOrderPoints()));
    }

}
