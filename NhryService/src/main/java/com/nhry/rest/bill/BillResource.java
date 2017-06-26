package com.nhry.rest.bill;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.model.bill.*;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.bill.dao.BranchBillService;
import com.nhry.service.bill.dao.CustomerBillService;
import com.nhry.service.bill.dao.EmpBillService;
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
import java.math.BigDecimal;

@Path("/bill")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/bill", description = "结算管理")
public class BillResource extends BaseResource {
    @Autowired
    private CustomerBillService customerBillService;
    @Autowired
    private BranchBillService branchBillService;
    @Autowired
    private EmpBillService empBillService;


    @POST
    @Path("/cust/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/search", response = PageInfo.class, notes = "查询订户订单列表")
    public Response searchCustomerOrder(@ApiParam(required = true, name = "cModel", value = "cModel") CustBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.searchCustomerOrder(cModel));
    }

    @POST
    @Path("/cust/searchForRecBill")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/searchForRecBill", response = PageInfo.class, notes = "查询订户订单列表(存在收款单的)")
    public Response searchForRecBill(@ApiParam(required = true, name = "cModel", value = "cModel") CustBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.searchCustomerOrderForRecBill(cModel));
    }


    @POST
    @Path("/cust/searchForExp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/search", response = PageInfo.class, notes = "获取条件下的订单编号（批量导出收款单用）")
    public Response searchForExp(@ApiParam(required = true, name = "cModel", value = "cModel") CustBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.searchCustomerOrderForExp(cModel));
    }


    @POST
    @Path("/cust/BatchPrintForExp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/BatchPrintForExp", response = PageInfo.class, notes = "获取条件下的订单编号（批量导出收款单用）")
    public Response BatchPrintForExp(@ApiParam(required = true, name = "cModel", value = "cModel") CustBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.BatchPrintForExp2(cModel));
    }

    @GET
    @Path("/cust/getCustomerOrderDetialByCode")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/getCustomerOrderByCode", response = Response.class, notes = "查询订户收款表详情")
    public Response getCustomerOrderByCode(@ApiParam(required = true, name = "orderNo", value = "订单号") @QueryParam("orderNo") String orderNo) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.getCustomerOrderDetailByCode(orderNo));
    }

    @GET
    @Path("/cust/getRecBillByOrderNo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/getRecBillByOrderNo", response = Response.class, notes = "根据订单号获取收款单")
    public Response getRecBillByOrderNo(@ApiParam(required = true, name = "orderNo", value = "订单号") @QueryParam("orderNo") String orderNo) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.getRecBillByOrderNo(orderNo));
    }

    @GET
    @Path("/cust/customerOffset")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/customerOffset", response = int.class, notes = "订户冲销")
    public Response customerOffset(@ApiParam(required = true, name = "receiptNo", value = "收款单号") @QueryParam("receiptNo") String receiptNo) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.customerOffset(receiptNo));
    }

    @GET
    @Path("/cust/delReceipt")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/delReceipt", response = int.class, notes = "删除收款单")
    public Response delReceipt(@ApiParam(required = true, name = "receiptNo", value = "收款单号") @QueryParam("receiptNo") String receiptNo) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.delReceipt(receiptNo));
    }

    @POST
    @Path("/cust/custRefund")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/custRefund", response = int.class, notes = "订户退款")
    public Response custRefund(@ApiParam(required = true, name = "cModel", value = "订户退款信息") CustomerRefundModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.custRefund(cModel));
    }

    @POST
    @Path("/cust/customerPayment")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/customerPayment", response = int.class, notes = "订户收款")
    public Response customerPayment(@ApiParam(required = true, name = "cModel", value = "收款信息") CustomerPayMentModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.customerPayment(cModel));
    }

    @POST
    @Path("/cust/cacularTotalBeforBatch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/cacularTotalBeforBatch", response = BigDecimal.class, notes = "选择收款人批量收款前 计算订单总金额")
    public Response cacularTotalBeforBatch(@ApiParam(required = true, name = "cModel", value = "收款信息") CustBatchBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.calculateTotalBeforBatch(cModel));
    }


    @POST
    @Path("/cust/custBatchCollect")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/custBatchCollect", response = BatChCollectResultModel.class, notes = "选择收款人批量收款")
    public Response custBatchCollect(@ApiParam(required = true, name = "cModel", value = "收款信息") CustBatchBillQueryModel cModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.custBatchCollect(cModel));
    }

    @POST
    @Path("/cust/delRecBills")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/delRecBills", response = BatChCollectResultModel.class, notes = "选择订单批量删除收款单")
    public Response delRecBills(@ApiParam(required = true, name = "orders", value = "订单号list") OrderSearchModel oModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.delRecBills(oModel));
    }

    @GET
    @Path("/cust/getCurrentBranch")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/getCurrentBranch", response = Response.class, notes = "获取当前用户所属奶站")
    public Response getCurrentBranch() {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.getCurrentBranch());
    }

    @GET
    @Path("/cust/setBranchRemark")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/setBranchRemark", response = Response.class, notes = "设置奶站备注")
    public Response setBranchRemark(@ApiParam(required = true, name = "branchRemark", value = "奶站备注") @QueryParam("branchRemark")String branchRemark) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.setBranchRemark(branchRemark));
    }

    @POST
    @Path("/cust/custBatchCollectBySelect")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/custBatchCollectBySelect", response = BatChCollectResultModel.class, notes = "选择订单批量收款")
    public Response custBatchCollectBySelect(@ApiParam(required = true, name = "orders", value = "订单号list") OrderSearchModel oModel) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.custBatchCollectBySelect(oModel));
    }


    @GET
    @Path("/cust/createRecBillByOrderNo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/createRecBillByOrderNo", response = Response.class, notes = "根据订单号创建收款单")
    public Response createRecBillByOrderNo(@ApiParam(required = true, name = "orderNo", value = "员工工资单流水号") @QueryParam("orderNo") String orderNo) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.createRecBillByOrderNo(orderNo));
    }


    @POST
    @Path("/emp/empDispDetialInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/empDispDetialInfo", response = Response.class, notes = "获取送奶工配送数量明细结算表")
    public Response empDispDetialInfo(@ApiParam(required = true, name = "eSearch", value = "收款信息") EmpDispDetialInfoSearch eSearch) {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.empDispDetialInfo(eSearch));
    }

    @POST
    @Path("/emp/empAccountReceAmount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/empAccountReceAmount", response = Response.class, notes = "送奶员收款金额核算")
    public Response empAccountReceAmount(@ApiParam(required = true, name = "eSearch", value = "收款信息") EmpDispDetialInfoSearch eSearch) {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.empAccountReceAmount(eSearch));
    }


    @POST
    @Path("/emp/searchEmpSalaryRep")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/searchEmpSalaryRep", response = PageInfo.class, notes = "送奶员工资报表")
    public Response searchEmpSalaryRep(@ApiParam(required = true, name = "eSearch", value = "查询条件") EmpDispDetialInfoSearch eSearch) {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.searchEmpSalaryRep(eSearch));
    }


    @POST
    @Path("/emp/setBranchEmpSalary")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/setBranchEmpSalary", response = Response.class, notes = "结算上月本奶站下所有送奶员工资")
    public Response setBranchEmpSalary() {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.setBranchEmpSalary());
    }

    @POST
    @Path("/emp/setBranchEmpSalaryThisMonth")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/setBranchEmpSalaryThisMonth", response = Response.class, notes = "结算本月本奶站下所有送奶员工资")
    public Response setBranchEmpSalaryThisMonth() {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.setBranchEmpSalaryThisMonth());
    }

    @GET
    @Path("/emp/getEmpSalaryBySalaryNo")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/getEmpSalaryBySalaryNo", response = PageInfo.class, notes = "根据工资单流水号获取详情")
    public Response getEmpSalaryBySalaryNo(@ApiParam(required = true, name = "empSalLsh", value = "员工工资单流水号") @QueryParam("empSalLsh") String empSalLsh) {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.getEmpSalaryBySalaryNo(empSalLsh));
    }


    @POST
    @Path("/emp/getSalesOrgDispRate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/getSalesOrgDispRate", response = Response.class, notes = "获取当前登录人所在的 销售组织下的配送率")
    public Response getSalesOrgDispRate() {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.getSalesOrgDispRate());
    }


    @POST
    @Path("/emp/uptEmpDispRate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/emp/uptEmpDispRate", response = int.class, notes = "更新销售组织 配送率")
    public Response uptEmpDispRate(@ApiParam(required = true, name = "sModel", value = "JSON 格式") SaleOrgDispRateModel sModel) {
        return convertToRespModel(MessageCode.NORMAL, null, empBillService.uptEmpDispRate(sModel));
    }


    @POST
    @Path("/branch/customerBranchBill")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branch/customerBranchBill", response = PageInfo.class, notes = "奶站结算-订户维度")
    public Response branchBill(@ApiParam(required = true, name = "customerBill", value = "奶站结算") CustBranchBillSearch bsearch) {
        return convertToRespModel(MessageCode.NORMAL, null, branchBillService.CustomerBranchBill(bsearch));
    }

    @POST
    @Path("/branch/empBranchBill")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branch/empBranchBill", response = PageInfo.class, notes = "奶站结算-送奶工维度")
    public Response branchBill(@ApiParam(required = true, name = "customerBill", value = "奶站结算") EmpBranchBillSearch eSearch) {
        return convertToRespModel(MessageCode.NORMAL, null, branchBillService.EmpBranchBill(eSearch));
    }


    @POST
    @Path("/branch/getEmpBranchBillDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branch/getEmpBranchBillDetail", response = PageInfo.class, notes = "奶站结算-送奶员维度-详情")
    public Response getEmpBranchBillDetail(@ApiParam(required = true, name = "customerBill", value = "根据送奶员和日期获取详情") EmpBranchBillDetailSearch bsearch) {
        return convertToRespModel(MessageCode.NORMAL, null, branchBillService.getEmpBranchBillDetail(bsearch));
    }


    @POST
    @Path("/cust/queryCollectByOrderNo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/cust/queryCollectByOrderNo", response = PageInfo.class, notes = "根据订单号 获取 收款单信息")
    public Response queryCollectByOrderNo(@ApiParam(required = true, name = "orderCode", value = "订单号") @QueryParam("orderCode") String orderCode) {
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.queryCollectByOrderNo(orderCode));
    }

    @POST
    @Path("/selectOrdersNoBillCount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/selectOrdersNoBillCount", response = Integer.class, notes = "查询预付款未收款数量")
    public Response selectOrdersNoBillCount(){
        return convertToRespModel(MessageCode.NORMAL, null, customerBillService.selectOrdersNoBillCount());
    }
}