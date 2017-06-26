package com.nhry.rest.pi;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.config.impl.NHSysCodeItemMapperImpl;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.model.webService.CustomerComplainModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.basic.dao.ResidentialAreaService;
import com.nhry.service.basic.dao.TVipCrmInfoService;
import com.nhry.service.basic.dao.TVipCustInfoService;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.milktrans.dao.RedateByTradeService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.pi.dao.*;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.webService.client.PISuccessTMessage;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cbz on 6/22/2016.
 */
@Path("/pi")
@Controller
@Component
@Scope("request")
@Singleton
@Api(value = "/pi", description = "PI测试使用")
public class PIResouce extends BaseResource{
    @Autowired
    public PIProductService piProductService;
    @Autowired
    public PIRequireOrderService requireOrderService;
    @Autowired
    public BranchService branchService;
    @Autowired
    public TVipCrmInfoService tVipCrmInfoService;
    @Autowired
    public TVipCustInfoService tVipCustInfoService;
    @Autowired
    public PIVipInfoDataService piVipInfoDataService;
    @Autowired
    public DictionaryService dictionaryService;
    @Autowired
    public ResidentialAreaService residentialAreaService;
    @Autowired
    public SmsSendService smsSendService;
    @Autowired
    public UserSessionService userSessionService;
    @Autowired
    public PIRedateByTradeService redateByTradeService;
    @Autowired
    public RedateByTradeService redateByService;
    @Autowired
    public OrderService orderService;
    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getProducts", response = ResponseModel.class, notes = "获取产品数据")
    public Response getProducts() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.matHandler(), null);
    }
    
    @GET
    @Path("/getStudProducts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getStudProducts", response = ResponseModel.class, notes = "学生奶获取产品数据")
    public Response getStudProducts() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.studMatHandler(), null);
    }

    @GET
    @Path("/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getCustomer", response = ResponseModel.class, notes = "获取奶站经销商数据")
    public Response getCustomer() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.customerDataHandle(), null);
    }
    
    @GET
    @Path("/getStudCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getStudCustomer", response = ResponseModel.class, notes = "获取学生奶主数据")
    public Response getStudCustomer() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.studCustomerDataHandle(), null);
    }

    @GET
    @Path("/getZD")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getZD", response = ResponseModel.class, notes = "获取字典数据")
    public Response getZD() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.salesQueryHandler(), null);
    }

    @GET
    @Path("/getJHD/{orderNo}/{branchNo}/{isReq}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getJHD/{orderNo}/{branchNo}/{isReq}", response = ResponseModel.class, notes = "获取交货单数据")
    public Response gegetJHDZD(@PathParam("orderNo") String orderNo,@PathParam("branchNo") String branchNo,@PathParam("isReq")boolean isReq) throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, null, requireOrderService.generateDelivery(orderNo,branchNo,isReq));
    }

    @POST
    @Path("/getYHD/{date}/{branchNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getYHD/{date}/{branchNo}", response = ResponseModel.class, notes = "获取要货单数据")
    public Response getYHD(@PathParam("date") String date,@PathParam("branchNo") String branchNo) throws RemoteException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return convertToRespModel(MessageCode.NORMAL, requireOrderService.execRequieOrder(format.parse(date),branchNo), null);
    }
    @POST
    @Path("/getSalesOrder/{date}/{branchNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getSalesOrder/{date}/{branchNo}", response = ResponseModel.class, notes = "获取交货单数据")
    public Response getSalesOrder(@PathParam("date") String date,@PathParam("branchNo") String branchNo) throws RemoteException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        TMdBranch branch = branchService.selectBranchByNo(branchNo);
        return convertToRespModel(MessageCode.NORMAL, requireOrderService.execSalesOrder(format.parse(date),branch), null);
    }
    @GET
    @Path("/generateVipInfoData/{custId}/{vipTel}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/generateVipInfoData/{custId}/{vipTel}", response = ResponseModel.class, notes = "创建会员信息数据")
    public Response generateVipInfoData(@ApiParam(name = "custId",value = "订户编号",required = true)@PathParam("custId") String custId,@ApiParam(name = "vipTel",value = "会员电话",required = true)@PathParam("vipTel") String vipTel){
        TVipCustInfo vipCustInfo = tVipCustInfoService.findVipCustByNoForUpt(custId);
        String message = piVipInfoDataService.generateVipInfoData(vipCustInfo, vipTel).getMessage();
        return convertToRespModel(MessageCode.NORMAL,message, null);
    }
    @POST
    @Path("/createMemberActivities")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/createMemberActivities", response = ResponseModel.class, notes = "会员积分活动")
    public Response createMemberActivities() throws RemoteException, ParseException {
        MemberActivities ac = new MemberActivities();
        ac.setActivitydate(new Date());
        ac.setAmount(new BigDecimal(110));
//        ac.setCardid("0000000323");
        ac.setCategory("ACCRUAL");
        ac.setCommit("X");
        ac.setItemnum("10");
//        ac.setCurrency("");
//        ac.setPoints(new BigDecimal(110));
        ac.setProcesstype("YPOS_ACCRUAL");
        ac.setMembershipguid("0050568ADF8B1EE696C390EAA540A600");
        ac.setOrderid("10000000022323232");
        ac.setProductid("000000023");
        ac.setProductquantity(new BigDecimal(100));
        ac.setRetailstoreid("0300005935");
        ac.setSalesorg("4111");
        return convertToRespModel(MessageCode.NORMAL, piVipInfoDataService.createMemberActivities(ac), null);
    }


    @POST
    @Path("/sendSubscriber/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/sendSubscriber/{code}", response = ResponseModel.class, notes = "发送订户数据")
    public Response sendSubscriber(@PathParam("code") String code){
        TVipCustInfo vipCustInfo = tVipCustInfoService.findVipCustByNoForUpt(code);
        return convertToRespModel(MessageCode.NORMAL, piVipInfoDataService.sendSubscriber(vipCustInfo), null);
    }
    @POST
    @Path("/sendSms/{tel}/{context}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/sendSms/{tel}/{context}", response = ResponseModel.class, notes = "发送短信")
    public Response sendSms(@PathParam("tel") String tel,@PathParam("context") String context){
        return convertToRespModel(MessageCode.NORMAL, smsSendService.sendMessage(context,tel), null);
    }

    @GET
    @Path("/executeVipInfoData/{custId}/{vipTel}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/executeVipInfoData/{custId}/{vipTel}", response = ResponseModel.class, notes = "创建会员信息数据")
    public Response executeVipInfoData(@ApiParam(name = "custId",value = "订户编号",required = true)@PathParam("custId") String custId,@ApiParam(name = "vipTel",value = "会员电话",required = true)@PathParam("vipTel") String vipTel){
        TVipCustInfo vipCustInfo = tVipCustInfoService.findVipCustByNoForUpt(custId);
        piVipInfoDataService.executeVipInfoData(vipCustInfo, vipTel);
        return convertToRespModel(MessageCode.NORMAL,null, null);
    }
    @POST
    @Path("/saveFactoryPrice")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/saveFactoryPrice", response = ResponseModel.class, notes = "保存自营奶站出厂价格")
    public Response saveFactoryPrice(){
        return convertToRespModel(MessageCode.NORMAL, requireOrderService.saveFactoryPrice(), null);
    }

    @GET
    @Path("/getWerks")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getWerks", response = ResponseModel.class, notes = "更新库存对应的工厂数据")
    public Response getWerks() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, piProductService.matWHWHandler(), null);
    }

    @POST
    @Path("/queryCustomerComplain")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/queryCustomerComplain", response = ResponseModel.class, notes = "查询送奶工投诉信息")
    public Response queryCustomerComplain(@ApiParam(name = "model",value = "查询送奶工投诉信息的参数",required = false)CustomerComplainModel model){
        TSysUser user = userSessionService.getCurrentUser();
        model.setSalesOrg(user.getSalesOrg());
        if(StringUtils.isEmpty(model.getBranchNo())) {
            model.setBranchNo(user.getBranchNo());
        }
        PISuccessTMessage message = piVipInfoDataService.queryCustomerComplain(model);
        return convertToRespModel(MessageCode.NORMAL,message.getMessage(), message.getData());
    }

    @GET
    @Path("/execRedate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/execRedate", response = ResponseModel.class, notes = "测试发送返利")
    public Response execRedate() throws RemoteException {
        return convertToRespModel(MessageCode.NORMAL, redateByTradeService.sendRedateByTradeToCRM(), null);
    }

    @GET
    @Path("/saveRedate/{orderNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/saveRedate/{orderNo}", response = ResponseModel.class, notes = "保存返利数据")
    public Response saveRedate(@PathParam("orderNo") String orderNo) throws RemoteException {
        OrderCreateModel orderCreateModel = orderService.selectOrderByCode(orderNo);
        redateByService.saveRedate(orderCreateModel.getOrder());
        return convertToRespModel(MessageCode.NORMAL, null, null);
    }
}


