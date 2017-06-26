package com.nhry.rest.pi;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.model.sys.ResponseModel;
import com.nhry.model.webService.VipPointModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.basic.dao.ResidentialAreaService;
import com.nhry.service.basic.dao.TVipCrmInfoService;
import com.nhry.service.basic.dao.TVipCustInfoService;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.pi.dao.PIProductService;
import com.nhry.service.pi.dao.PIRequireOrderService;
import com.nhry.service.pi.dao.PIVipInfoDataService;
import com.nhry.service.pi.dao.PIVipPointService;
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
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by cbz on 6/22/2016.
 */
@Path("/piVipPoint")
@Controller
@Component
@Scope("request")
@Singleton
@Api(value = "/piVipPoint", description = "会员积分查询")
public class PIVipPointResouce extends BaseResource{
    @Autowired
    private PIVipPointService piVipPointService;
    @POST
    @Path("/queryVipPointData")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/queryVipPointData", response = ResponseModel.class, notes = "获取会员积分数据")
    public Response queryVipPointData(@ApiParam(name = "vipPoint",value = "vipPoint",required = true) VipPointModel vipPoint){
        return convertToRespModel(MessageCode.NORMAL, null, piVipPointService.queryVipPointData(vipPoint).getData());
    }
}
