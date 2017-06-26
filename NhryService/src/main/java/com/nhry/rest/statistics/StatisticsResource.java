package com.nhry.rest.statistics;

//import com.nhry.model.statistics.Erp_Sale_Report_Model;
import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
//import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInit;
import com.nhry.model.statistics.BranchInfoModel;
import com.nhry.model.statistics.Cash_account_Model;
import com.nhry.model.statistics.DistInfoModel;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.statistics.OutMilkModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.milktrans.dao.OutMilkService;
import com.nhry.service.statistics.dao.BranchInfoService;
import com.nhry.service.statistics.dao.DistributionInfoService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cbz on 7/18/2016.
 */
@Path("/statistics")
@Controller
@Singleton
@Scope("request")
@Api(value = "/statistics",description = "统计")
public class StatisticsResource extends BaseResource {
	 @Autowired 
	public UserSessionService userSessionService;
    @Autowired
    private BranchInfoService branchInfoService;
    @Autowired
    private DistributionInfoService distributionInfoService;
    @Autowired
    private OutMilkService outMilkService;
    @POST
    @Path("/branchDayInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branchDayInfo}", response = ResponseModel.class, notes = "奶站日报表")
    public Response branchDayInfo(@ApiParam(name = "model",value = "奶站日报") BranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.branchDayInfo(model));
    }

//liu yin add  start
    @POST
    @Path("/report_nh_erp_sale")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/report_nh_erp_sale}", response = ResponseModel.class, notes = "奶站销售日报表")
    public Response report_nh_erp_sale(@ApiParam(name = "model",value = "奶站销售日报表") Object model){
        SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
        
        return null;
       // return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.branchDayInfo(model));
    }
   // liuyin  add end

    
    
    
  //liu yin add  start
    @POST
    @Path("/Cash_account")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/Cash_account}", response = ResponseModel.class, notes = "现金账户信息查询")
    public Response Cash_account(@ApiParam(name = "model",value = "现金账户信息查询") Cash_account_Model model){
        SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
         TSysUser user = userSessionService.getCurrentUser(); 
        model.setSalesOrg(user.getSalesOrg());
        model.setBranchNo(user.getBranchNo());
        model.setBranchName(user.getBranchName());
        model.setCash_num("0");//账户余额
        //余额查询功能，待完善。
        PageInfo pageInfo = new  PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(8);
        pageInfo.setTotal(10);
        ArrayList<Cash_account_Model> arrayList = new ArrayList<Cash_account_Model>();
       arrayList.add(model);
        pageInfo.setList(arrayList);
        return convertToRespModel(MessageCode.NORMAL, null, pageInfo );
    }
   // liuyin  add end
  
    
     
    

    @POST
    @Path("/findDifferInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findDifferInfo}", response = ResponseModel.class, notes = "路单配送差异明细")
    public Response findDifferInfo(@ApiParam(name = "model",value = "路单配送") DistInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, distributionInfoService.findDistDifferInfo(model));
    }

    
    
    
    @POST
    @Path("/findOrderRatio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findOrderRatio}", response = ResponseModel.class, notes = "奶站订单转化率(T+3)报表")
    public Response findOrderRatio(@ApiParam(name = "model",value = "订单转化率") BranchInfoModel model){

        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.findOrderRatio(model));
    }
    @POST
    @Path("/findMonthReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findMonthReport}", response = ResponseModel.class, notes = "奶站月任务报表")
    public Response findMonthReport(@ApiParam(name = "model",value = "月任务") BranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.findBranchMonthReport(model));
    }
    @POST
    @Path("/findReqOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findReqOrder}", response = ResponseModel.class, notes = "要货计划查询")
    public Response findReqOrder(@ApiParam(name = "model",value = "要货计划") BranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.findReqOrder(model));
    }
    @POST
    @Path("/findChangeplanStatReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findChangeplanStatReport}", response = ResponseModel.class, notes = "换货差明细")
    public Response findChangeplanStatReport(@ApiParam(name = "model",value = "换货差异") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.findChangeplanStatReport(model));
    }
    @POST
    @Path("/returnBoxStatReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/returnBoxStatReport}", response = ResponseModel.class, notes = "回瓶汇总")
    public Response returnBoxStatReport(@ApiParam(name = "model",value = "回瓶汇总") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.returnBoxStatReport(model));
    }
    @POST
    @Path("/mstDispNumStat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/mstDispNumStat}", response = ResponseModel.class, notes = "配送数量汇总-送奶员维度")
    public Response mstDispNumStat(@ApiParam(name = "model",value = "配送数量汇总-送奶员维度") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.mstDispNumStat(model));
    }
    @POST
    @Path("/branchMstDispNumStat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branchMstDispNumStat}", response = ResponseModel.class, notes = "配送数量汇总-奶站维度")
    public Response branchMstDispNumStat(@ApiParam(name = "model",value = "配送数量汇总-奶站维度") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.branchMstDispNumStat(model));
    }
    @POST
    @Path("/dayMstDispNumStat")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/dayMstDispNumStat}", response = ResponseModel.class, notes = "奶站日配送数量汇总")
    public Response dayMstDispNumStat(@ApiParam(name = "model",value = "奶站日配送数量汇总") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.dayMstDispNumStat(model));
    }
    @POST
    @Path("/branchDayRepo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branchDayRepo}", response = ResponseModel.class, notes = "公司部门、经销商日统计送奶份数")
    public Response branchDayRepo(@ApiParam(name = "model",value = "公司部门、经销商日统计送奶份数") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.branchDayRepo(model));
    }
    @POST
    @Path("/branchDayQty")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branchDayQty}", response = ResponseModel.class, notes = "公司部门、经销商当日送奶份数 ")
    public Response branchDayQty(@ApiParam(name = "model",value = "公司部门、经销商当日送奶份数") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.branchDayQty(model));
    }

    @POST
    @Path("/Refuse2receiveResend")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/Refuse2receiveResend}", response = ResponseModel.class, notes = "拒收复送报表")
    public Response Refuse2receive(@ApiParam(name = "model",value = "公司部门、经销商当日送奶份数") ExtendBranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.Refuse2receiveResend(model));
    }

    @POST
    @Path("/Refuse2receiveResendDetail/{resendOrderNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/Refuse2receiveResendDetail/{resendOrderNo}", response = ResponseModel.class, notes = "拒收复送详情")
    public Response Refuse2receiveResendDetail(@ApiParam(name = "resendOrderNo",value = "单号") @PathParam("resendOrderNo") String resendOrderNo){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.Refuse2receiveResendDetail(resendOrderNo));
    }

    @POST
    @Path("/createOutMilk")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/createOutMilk", response = Integer.class, notes = "生成出奶表结余金额")
    public Response createOutMilk(@ApiParam(required=true,name="record",value="OutMilkModel") OutMilkModel record){
        return convertToRespModel(MessageCode.NORMAL, null, outMilkService.insertAmtInit(record));
    }
    @POST
    @Path("/createAmtsdayByday")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/createAmtsdayByday", response = Integer.class, notes = "按日期生成出年表")
    public Response createAmtsdayByday(){
        return convertToRespModel(MessageCode.NORMAL, null, outMilkService.createAmtsdayByday());
    }
    @POST
    @Path("/createAmtsByBranch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/createAmtsByBranch", response = Integer.class, notes = "根据日期生成该奶站下送奶员以后日期的出奶表统计")
    public Response createAmtsByBranch(@ApiParam(required=true,name="record",value="OutMilkModel") OutMilkModel record){
        return convertToRespModel(MessageCode.NORMAL, null, outMilkService.createAmtsByBranch(record));
    }

    @POST
    @Path("/selectAmtInitList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/selectAmtInitList", response = ResponseModel.class, notes = "查询奶站下送奶员初始化送奶表信息")
    public Response selectAmtInitList(){
        return convertToRespModel(MessageCode.NORMAL, null, outMilkService.selectAmtInitList());
    }
    @POST
    @Path("/updateAmtInitByPrimaryKeySelective")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/updateAmtInitByPrimaryKeySelective", response = Integer.class, notes = "修改出奶表初始化金额")
    public Response updateAmtInitByPrimaryKeySelective(@ApiParam(required=true,name="record",value="OutMilkModel") OutMilkModel record){
        return convertToRespModel(MessageCode.NORMAL, null, outMilkService.updateAmtInitByPrimaryKeySelective(record));
    }
    @POST
    @Path("/dayReportBasisForm")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/dayReportBasisForm}", response = ResponseModel.class, notes = "要货计划日报表")
    public Response dayReportBasisForm(@ApiParam(name = "model",value = "要货计划日报表") BranchInfoModel model){
        return convertToRespModel(MessageCode.NORMAL, null, branchInfoService.getDayReportBasisForm(model));
    }
}