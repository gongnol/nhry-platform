package com.nhry.rest.report;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javafx.scene.paint.Color;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.data.milktrans.domain.TssmMilkmanAmts;
import com.nhry.data.order.domain.TMilkboxPlan;
import com.nhry.data.order.domain.TMstYearCardCompOrder;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.bill.BatChCollectForExpModel;
import com.nhry.model.bill.CollectOrderBillModel;
import com.nhry.model.bill.CustBillQueryModel;
import com.nhry.model.milk.RouteOrderModel;
import com.nhry.model.milktrans.DispOrderReportEntityModel;
import com.nhry.model.milktrans.DispOrderReportModel;
import com.nhry.model.milktrans.OrderRequireItem;
import com.nhry.model.milktrans.ReqGoodsOrderSearch;
import com.nhry.model.milktrans.RequireOrderModel;
import com.nhry.model.order.CollectOrderModel;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.order.OrderDaliyPlanReportEntityModel;
import com.nhry.model.order.OrderDaliyPlanReportModel;
import com.nhry.model.order.ProductItem;
import com.nhry.model.statistics.BranchInfoModel;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.auth.dao.UserService;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.basic.dao.ProductService;
import com.nhry.service.basic.dao.ResidentialAreaService;
import com.nhry.service.basic.pojo.AreaSearchModel;
import com.nhry.service.basic.pojo.BranchEmpModel;
import com.nhry.service.bill.dao.CustomerBillService;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.milk.dao.DeliverMilkService;
import com.nhry.service.milktrans.dao.OutMilkService;
import com.nhry.service.milktrans.dao.RequireOrderService;
import com.nhry.service.order.dao.MilkBoxService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.statistics.dao.BranchInfoService;
import com.nhry.utils.CodeGeneratorUtil;
import com.nhry.utils.EnvContant;
import com.nhry.utils.ExcelUtil;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by cbz on 7/27/2016.
 */
@Path("/report")
@Controller
@Singleton
@Scope("request")
@Api(value = "/report", description = "导出")
public class ReportResource extends BaseResource{
    private static Logger logger = Logger.getLogger(ReportResource.class);
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserSessionService userSessionService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private DeliverMilkService deliverMilkService;
    @Autowired
    private MilkBoxService milkBoxService;
    @Autowired
    private BranchEmpService branchEmpService;
    @Autowired
    private BranchInfoService branchInfoService;
    @Autowired
    private CustomerBillService customerBillService;
    @Autowired
    private OutMilkService outMilkService;
    @Autowired
    private RequireOrderService requireOrderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResidentialAreaService sesidentialAreaService;
    @Autowired
    private DictionaryService dicService;
    
    
    
    @GET
    @Path("/reportCollect")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportCollect", response = OrderCreateModel.class, notes = "根据订单编号导出收款信息")
    public Response reportCollect(@ApiParam(required = true, name = "orderCode", value = "订单编号") @QueryParam("orderCode") String orderCode, @Context HttpServletRequest request, @Context HttpServletResponse response) {

        CollectOrderModel collect = orderService.queryCollectByOrderNo(orderCode);
        TSysUser user = userSessionService.getCurrentUser();
//        String url = request.getServletContext().getRealPath("/");
        String url = EnvContant.getSystemConst("filePath");
        logger.info("realPath："+url);
        TMdAddress address = collect.getAddress();
        if(address == null) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "配送地址为空，请检查！", null);
        }
        TPreOrder order = collect.getOrder();
        TMstRecvBill bill = customerBillService.getRecBillByOrderNo(orderCode);
        if(bill == null ){
            bill =  customerBillService.createRecBillByOrderNo(orderCode);
        }

        TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
        List<ProductItem> productItems =collect.getEntries();
        String outUrl = "";//request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "CollectOrderTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);
            XSSFCell cell = row.getCell(2);
            cell.setCellValue(order.getSalesOrgName());
            row = sheet.getRow(3);
            cell = row.getCell(1);

            cell.setCellValue("配送奶站："+order.getBranchName());
            cell = row.getCell(4);
           // 订奶起止日期：2016-7-21—  2016-8-23
            StringBuilder orderDate = new StringBuilder("订奶起止日期：");
            orderDate.append(format.format(order.getOrderDate()));
            orderDate.append("-");
            orderDate.append(format.format(order.getEndDate()));
            cell.setCellValue(orderDate.toString());
            cell = row.getCell(10);
            cell.setCellValue("送奶员："+order.getEmpName());
            row = sheet.getRow(4);
            cell = row.getCell(10);
            cell.setCellValue("送奶员电话："+order.getEmpTel());
            row = sheet.getRow(5);
            cell = row.getCell(1);
            cell.setCellValue("客户姓名："+order.getMilkmemberName());
            cell = row.getCell(3);
            cell.setCellValue("配送地址："+address.getResidentialAreaName()+" "+address.getAddressTxt());
            cell = row.getCell(12);
            cell.setCellValue("客户电话："+order.getCustomerTel());
            sheet.setForceFormulaRecalculation(true);
            BigDecimal sum = new BigDecimal(0);
            int num = 7;
            if(productItems != null){
                for(ProductItem item : productItems){
                    row = sheet.getRow(num);
                    cell = row.getCell(1);
                    cell.setCellValue(item.getMatnrTxt());
                    cell = row.getCell(5);
                    cell.setCellValue(item.getUnit());
                    cell = row.getCell(6);
                    cell.setCellValue(item.getBasePrice().toString());
                    cell = row.getCell(8);
                    cell.setCellValue(item.getQty());
                    cell = row.getCell(10);
                    cell.setCellValue(item.getTotalPrice().toString());
                    if(item.getTotalPrice()!=null)
                        sum = sum.add(item.getTotalPrice());
                    num++;
                }
            }
            row = sheet.getRow(13);
            cell=row.getCell(10);
            cell.setCellValue(bill.getAccAmt()==null ? "0" :String.valueOf(bill.getAccAmt()));
           // cell.setCellValue(order.getAcctAmt()==null ? "0" :String.valueOf(order.getAcctAmt()));
            row = sheet.getRow(14);
            cell = row.getCell(10);
            //首先账户合计减去账户余额 大于0后剩余金额为应收款,为负数时应收款应为0;
            if(order.getAcctAmt()!=null){
                sum = sum.subtract(order.getAcctAmt());//合计减去账户金额
                if(sum.compareTo(new BigDecimal("0"))==-1){
                    sum = new BigDecimal("0");
                }
            }
            cell.setCellValue(sum.toString());

            row = sheet.getRow(15);
            cell = row.getCell(1);
            cell.setCellValue("奶站地址："+ branch.getAddress());
            cell = row.getCell(7);
            cell.setCellValue("奶站电话："+ branch.getTel());

            row = sheet.getRow(18);
            cell = row.getCell(1);
            cell.setCellValue("打印日期："+ format.format(new Date()));
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "CollectOrder.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();

//            String mt = new MimetypesFileTypeMap().getContentType(targetFilePath);
//            return Response
//                    .ok(targetFilePath, mt)
//                    .header("Content-disposition","attachment;filename=" + targetFilePath.getName())
//                    .header("ragma", "No-cache").header("Cache-Control", "no-cache").build();
            outUrl = fname + "CollectOrder.xlsx";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @GET
    @Path("/reportDeliver")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportDeliver", response = OrderCreateModel.class, notes = "根据路单编号导出路单信息")
    public Response reportDeliver(@ApiParam(required = true, name = "orderCode", value = "订单编号") @QueryParam("orderCode") String orderCode, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        List<TDispOrderItem> details = deliverMilkService.selectRouteDetailsAllforDeliver(orderCode);
        //List<TDispOrderChange> ChangeOrders  = deliverMilkService.searchRouteChangeOrder(orderCode);
        RouteOrderModel model = deliverMilkService.searchRouteDetails(orderCode);
        List<TDispOrderItem> modelDeliver =  deliverMilkService.searchRouteDetailsForDeliver(orderCode);
        String outUrl = "";
        logger.debug("##################"+EnvContant.getSystemConst("filePath"));
//        String url = request.getServletContext().getRealPath("/");
        String url = EnvContant.getSystemConst("filePath");
        try{
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "NewDeliverMilkTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(2);
            XSSFCell cell = row.getCell(1);
            TDispOrder order = model.getOrder();
            XSSFCellStyle styleBoldwrap = workbook.createCellStyle();
            styleBoldwrap.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBoldwrap.setWrapText(true);


            cell.setCellValue("配送人员：" + order.getDispEmpName().concat("-").concat(order.getBranchName()));
            row = sheet.getRow(3);
            cell = row.getCell(1);
            cell.setCellValue("送奶日期："+format.format(order.getOrderDate()));
            row = sheet.getRow(4);
            cell = row.getCell(1);
            cell.setCellValue("送奶时间：".concat("10".equals(order.getReachTimeType())?"上午配送":"下午配送"));
            row = sheet.getRow(5);
            cell = row.getCell(1);
            cell.setCellStyle(styleBoldwrap);
            String total = "应送总数：".concat(order.getTotalQty()==null?"":order.getTotalQty().toString().concat("--").concat(model.getProducts()));
            cell.setCellValue(total);
            if(total.length()>90){
                row.setHeight((short)600);
            }

            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);

            int r = 8;
            if(details!=null){
                for(TDispOrderItem item : details) {
                    row = sheet.createRow(r);
                    cell = row.createCell(1);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getAddressTxt());//配送地址
                    cell = row.createCell(2);//今日配送
                    cell.setCellStyle(styleBold);

                    if (StringUtils.isNotEmpty(item.getMatnrTxt())){
                        cell.setCellValue(item.getMatnrTxt());
                    }
                    cell = row.createCell(3);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getCustTel());//订户电话
                    cell = row.createCell(4);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getCustName());//订户姓名

                    cell = row.createCell(5);//余额
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getRemainAmt()==null?"" : item.getRemainAmt().toString());
                    cell = row.createCell(6);
                    cell.setCellValue(" ");
                    cell.setCellStyle(styleBold);
                    cell = row.createCell(7);
                    cell.setCellValue(" ");//设置第五列为空字符串
                    cell.setCellStyle(styleBold);
                    cell = row.createCell(8);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getMemoTxt());
                   /* String status="";
                    if(ChangeOrders!=null){
                        for(TDispOrderChange ocitems:ChangeOrders){
                            if(ocitems.getOrgItemNo().equals(item.getOrgItemNo())){
                                switch (ocitems.getReason()){
                                    case "10":status="产品变更";break;
                                    case "20":status="数量变更";break;
                                    case "30":status="新增订户";break;
                                    case "40":status="减少订户";break;
                                    case "50":status="更改配送时间";break;
                                }
                                cell.setCellValue(status);
                            }
                        }
                    }*/
                    r++;
                }
                XSSFCellStyle styleBoldDown = workbook.createCellStyle();
                styleBoldDown.setWrapText(true);

                int r1 = details.size()+9;
                row = sheet.createRow(r1);
                cell = row.createCell(1);
                cell.setCellValue("按小区合计:");
                if(modelDeliver!=null){
                    for(TDispOrderItem deliverItem : modelDeliver){
                        row = sheet.createRow(r1+1);
                        cell = row.createCell(1);
                        String addressTotal = (deliverItem.getAddressTxt()==null?"--":deliverItem.getAddressTxt()).concat(":").concat(deliverItem.getTotalQty()==null?"" : deliverItem.getTotalQty().toString()).concat("--").concat(deliverItem.getMatnrTxt());
                        cell.setCellValue(addressTotal);//小区名称
                        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 8));
                        if(addressTotal.length()>90){
                            row.setHeight((short)600);
                        }
                        cell.setCellStyle(styleBoldDown);
                        r1++;
                    }

                }

                sheet.setForceFormulaRecalculation(true);
            }
            //String fname = CodeGeneratorUtil.getCode();
            String fname = (format.format(order.getDispDate())).concat(order.getDispEmpNo()).concat(".xlsx");
            String rq = format.format(new Date(order.getDispDate().getTime() - 24 * 60 * 60 * 1000));
            System.out.print(rq);
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname);
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();

            outUrl = fname;
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @GET
    @Path("/reportFile/{fileName}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportFile/{fileName}", response = OrderCreateModel.class, notes = "下载文件")
    public Response reportFile(@ApiParam(required = true,value = "fileName",defaultValue = "fileName")@PathParam("fileName") String fileName){
    	 String url =EnvContant.getSystemConst("filePath");
//        String url = request.getServletContext().getRealPath("/");
        String urlPath = url +  File.separator + "report"+ File.separator + "export" + File.separator + fileName;
//        String urlPath = url + fileName;
        logger.info("##########"+urlPath);
        return convertToFile(urlPath);
    }

    @GET
    @Path("/reportMilkBox/{empNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportMilkBox/{empNo}", response = OrderCreateModel.class, notes = "根据送奶员导出装箱列表信息")
    public Response reportMilkBox(@ApiParam(required = true, name = "empNo", value = "送奶员编号") @PathParam("empNo") String empNo, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        List<TMilkboxPlan> details = milkBoxService.findMilkBox(empNo);
        BranchEmpModel empdata =  branchEmpService.empDetailInfo(empNo);
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "MilkBoxTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);
            XSSFCell cell = row.getCell(1);
            cell.setCellValue(empdata.getEmp().getBranchName());
            cell = row.getCell(4);
            cell.setCellValue(empdata.getEmp().getEmpName());
            cell = row.getCell(7);
            cell.setCellValue(format.format(new Date()));

            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

            int r = 3;
            if(details!=null){
                for(TMilkboxPlan item : details){
                    row = sheet.createRow(r);
                    cell = row.createCell(0);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getMemberName());
                    cell= row.createCell(1);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getMemberTel());
                    cell = row.createCell(2);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getAdressNo());
                    cell = row.createCell(3);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");
                    cell = row.createCell(4);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");
                    sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 2, 4));
                    cell = row.createCell(5);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getProNum());
                    cell = row.createCell(6);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(item.getInitAmt().toString());
                    cell = row.createCell(7);
                    cell.setCellStyle(styleBold);
                    String paymentStatName="";
                    if(item.getPaymentmethod().equals("10")){
                        paymentStatName="后付款";
                    }else if(item.getPaymentmethod().equals("20")){
                        paymentStatName="预付款";
                    }else if(item.getPaymentmethod().equals("30")){
                        paymentStatName="垫付费";
                    }
                    cell.setCellValue(paymentStatName);
                    cell = row.createCell(8);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");
                    cell = row.createCell(9);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");
                    r++;
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "MilkBoxTemplate.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "MilkBoxTemplate.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/findReqOrderOutput")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findReqOrderOutput}", response = ResponseModel.class, notes = "根据日期,经销商,奶站编号生成要货计划导出")
    public Response findReqOrderOutput(@ApiParam(name = "model",value = "output要货计划") BranchInfoModel model){
        List<Map<String,String>>  details = branchInfoService.findReqOrderOutput(model);
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "ReqOrderTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell ;
            int r = 2;
            if(details!=null){
                for(Map<String,String> map : details){
                    row = sheet.createRow(r);r++;
                    cell=row.createCell(1);
                    cell.setCellValue(map.get("dealerName"));
                    cell=row.createCell(2);
                    cell.setCellValue(map.get("branchName"));
                    cell=row.createCell(3);
                    cell.setCellValue(map.get("matnrTxt"));

                    if(map.get("qty")!=null){
                        cell=row.createCell(4);
                        cell.setCellValue(String.valueOf(map.get("qty")));
                    }
                    if(map.get("increQty")!=null){
                        cell=row.createCell(5);
                        cell.setCellValue(String.valueOf(map.get("increQty")));
                    }
                    if(map.get("sumQty")!=null){
                        cell=row.createCell(6);
                        cell.setCellValue(String.valueOf(map.get("sumQty")));
                    }
                    if(map.get("bl")!=null){
                        cell=row.createCell(7);
                        cell.setCellValue(String.valueOf(map.get("bl")));
                    }
                    cell=row.createCell(8);
                    cell.setCellValue(map.get("flag"));
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "ReqOrderTemplate.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "ReqOrderTemplate.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/branchDayOutput")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/branchDayOutput}", response = ResponseModel.class, notes = "奶站日报表")
    public Response branchDayOutput(@ApiParam(name = "model",value = "奶站日报") BranchInfoModel model){
        List<Map<String,String>>  details = branchInfoService.branchDayOutput(model);
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        try{
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "DayReportTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            com.nhry.utils.date.Date date1 = new com.nhry.utils.date.Date(model.getTheDate());
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row=sheet.getRow(1);
            XSSFCell cell = row.getCell(4);
            cell.setCellValue(date1.addDays(-4).toShortDate());
            cell = row.getCell(5);
            cell.setCellValue(date1.addDays(-3).toShortDate());
            cell = row.getCell(6);
            cell.setCellValue(date1.addDays(-2).toShortDate());
            cell = row.getCell(7);
            cell.setCellValue(date1.addDays(-1).toShortDate());
            cell = row.getCell(8);
            cell.setCellValue(format.format(model.getTheDate()));
            int r = 2;
            if(details!=null){
                for(Map<String,String> map : details){
                    row = sheet.createRow(r);r++;
/*                    cell=row.createCell(1);
                    cell.setCellValue(map.get("branchNo"));*/
                    cell=row.createCell(2);
                    cell.setCellValue(map.get("branchName"));
                    cell=row.createCell(3);
                    String groupName="";
                    if(map.get("branchGroup").equals("01")){
                        groupName = "自营奶站";
                    }else if(map.get("branchGroup").equals("02")){
                        groupName = "经销商奶站";
                    }
                    cell.setCellValue(groupName);
                    cell = row.createCell(4);
                    cell.setCellValue(map.get("date1")==null ? "0" :String.valueOf(map.get("date1")));
                    cell = row.createCell(5);
                    cell.setCellValue(map.get("date2")==null ? "0" :String.valueOf(map.get("date2")));
                    cell = row.createCell(6);
                    cell.setCellValue(map.get("date3")==null ? "0" :String.valueOf(map.get("date3")));
                    cell = row.createCell(7);
                    cell.setCellValue(map.get("date4")==null ? "0" :String.valueOf(map.get("date4")));
                    cell = row.createCell(8);
                    cell.setCellValue(map.get("date5")==null ? "0" :String.valueOf(map.get("date5")));
                    cell = row.createCell(9);
                    cell.setCellValue(map.get("hb")==null ? "0" :String.valueOf(map.get("hb")));

                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "DayReportTemplate.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "DayReportTemplate.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    @POST
    @Path("/findMonthReportOutput")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findMonthReportOutput}", response = ResponseModel.class, notes = "奶站月任务报表导出")
    public Response findMonthReportOutput(@ApiParam(name = "model",value = "月任务") BranchInfoModel model){
        List<Map<String,String>>  details = branchInfoService.findBranchMonthReportOutput(model);
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "MonthReportTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            com.nhry.utils.date.Date date1 = new com.nhry.utils.date.Date(model.getTheDate());
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            int r = 2;
            if(details!=null){
                for(Map<String,String> map : details){
                    row = sheet.createRow(r);r++;
                    cell=row.createCell(1);
                    cell.setCellValue(map.get("branchName"));
                    cell=row.createCell(2);
                    String groupName="";
                    if(map.get("branchGroup").equals("01")){
                        groupName = "自营奶站";
                    }else if(map.get("branchGroup").equals("02")){
                        groupName = "经销商奶站";
                    }
                    cell.setCellValue(groupName);
                    cell=row.createCell(4);
                    cell.setCellValue(map.get("dayQty")==null ? "0" :String.valueOf(map.get("dayQty")));
                    cell=row.createCell(5);
                    cell.setCellValue(map.get("monthQty")==null ? "0" :String.valueOf(map.get("monthQty")));
                    cell=row.createCell(6);
                    cell.setCellValue(map.get("hb")==null ? "0" :String.valueOf(map.get("hb")));
                    cell=row.createCell(7);
                    cell.setCellValue(map.get("newQty")==null ? "0" :String.valueOf(map.get("newQty")));
                    cell=row.createCell(8);
                    cell.setCellValue(map.get("dayWeigth")==null ? "0" :String.valueOf(map.get("dayWeigth")));
                    cell=row.createCell(9);
                    cell.setCellValue(map.get("dayPrice")==null ? "0" :String.valueOf(map.get("dayPrice")));
                    cell=row.createCell(10);
                    cell.setCellValue(map.get("montyPrice")==null ? "0" :String.valueOf(map.get("montyPrice")));
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "MonthReportTemplate.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "MonthReportTemplate.xlsx";

        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    @POST
    @Path("/findOrderRatioOupput")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findOrderRatioOupput}", response = ResponseModel.class, notes = "奶站订单转化率(T+3)报表导出")
    public Response findOrderRatioOupput(@ApiParam(name = "model",value = "订单转化率") BranchInfoModel model){
        List<Map<String,String>>  details = branchInfoService.findOrderRatioOutput(model);
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "OrderRatioTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            com.nhry.utils.date.Date date1 = new com.nhry.utils.date.Date(model.getTheDate());
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row=sheet.getRow(1);
            XSSFCell cell = row.getCell(3);
            cell.setCellValue(format.format(model.getTheDate()));
            cell = row.getCell(4);
            cell.setCellValue(date1.addDays(-3).toShortDate());
            int r=2;
            if(details!=null){
                for(Map<String,String> map : details){
                    row = sheet.createRow(r);r++;
                    cell=row.createCell(1);
                    cell.setCellValue(map.get("branchName"));
                    cell=row.createCell(2);
                    String groupName="";
                    if(map.get("branchGroup").equals("01")){
                        groupName = "自营奶站";
                    }else if(map.get("branchGroup").equals("02")){
                        groupName = "经销商奶站";
                    }
                    cell.setCellValue(groupName);
                    cell = row.createCell(3);
                    cell.setCellValue(map.get("validQty")==null ? "0" :String.valueOf(map.get("validQty")));
                    cell = row.createCell(4);
                    cell.setCellValue(map.get("initQty")==null ? "0" :String.valueOf(map.get("initQty")));
                    cell = row.createCell(5);
                    cell.setCellValue(map.get("infoErrQty")==null ? "0" :String.valueOf(map.get("infoErrQty")));
                    cell = row.createCell(6);
                    cell.setCellValue(map.get("custQty")==null ? "0" :String.valueOf(map.get("custQty")));
                    cell = row.createCell(7);
                    cell.setCellValue(map.get("superQty")==null ? "0" :String.valueOf(map.get("superQty")));
                    cell = row.createCell(8);
                    cell.setCellValue(map.get("otherQty")==null ? "0" :String.valueOf(map.get("otherQty")));
                    cell = row.createCell(9);
                    cell.setCellValue(map.get("ratio")==null ? "0" :String.valueOf(map.get("ratio")));
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "OrderRatioTemplate.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "OrderRatioTemplate.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    @POST
    @Path("/reportCollectByEmp")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportCollectByEmp", response = OrderCreateModel.class, notes = "根据订单编号导出收款信息")
    public Response reportCollectByEmp(@ApiParam(required = true, name = "model", value = "送奶员编号")CustBillQueryModel model, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        BatChCollectForExpModel result = customerBillService.BatchPrintForExp2(model);
        List<CollectOrderBillModel> orderBillModel1 =result.getBillModels();
        String url = EnvContant.getSystemConst("filePath");
//        logger.info("realPath："+url);
        String outUrl = "";
        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("sheet");
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "CollectOrderTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));

//            sheet.setDefaultColumnWidth((short)8);
//            sheet.setDefaultRowHeightInPoints((short)12.75);
//            sheet.setColumnWidth(0,(short)3 * 100);
//            sheet.setColumnWidth(14,(short)3 * 100);
            List<CollectOrderBillModel> gt6 = new ArrayList<CollectOrderBillModel>();
            List<CollectOrderBillModel> lt6 = new ArrayList<CollectOrderBillModel>();
            if(orderBillModel1.size() > 0) {
                for(CollectOrderBillModel orderBillModel : orderBillModel1){
                    List<ProductItem> productItems = orderBillModel.getEntries();
                    if(productItems.size()>6){
                        gt6.add(orderBillModel);
                    }else{
                        lt6.add(orderBillModel);
                    }
                }
                String branchRemark = "";
                TMdBranch branch = customerBillService.getCurrentBranch();
                if(null != branch && StringUtils.isNotBlank(branch.getRemark())){
                    branchRemark = branch.getRemark();
                }

                if(lt6.size()>0){
                    XSSFSheet sheet = workbook.getSheetAt(0);
                    executeSheet(lt6, workbook, sheet,result.getBranchName(),result.getBranchTel(),result.getBranchAddress(),result.getSalesOrgName(), branchRemark);
                }
                if(gt6.size()>0){
                    XSSFSheet sheet = workbook.createSheet("特殊结款单");
                    executeSheet(gt6, workbook, sheet,result.getBranchName(),result.getBranchTel(),result.getBranchAddress(),result.getSalesOrgName(), branchRemark);
                }
            }
//            ps.setOrientation(PrintOrientation.PORTRAIT);
//            sheet.setPrintGridlines(true);
//            sheet.setDisplayGridlines(true);
//            ps.setFitWidth((short)22);
//            ps.setFitHeight((short)9);
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "CollectOrder.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();

//            String mt = new MimetypesFileTypeMap().getContentType(targetFilePath);
//            return Response
//                    .ok(targetFilePath, mt)
//                    .header("Content-disposition","attachment;filename=" + targetFilePath.getName())
//                    .header("ragma", "No-cache").header("Cache-Control", "no-cache").build();
            outUrl = fname + "CollectOrder.xlsx";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    private void executeSheet(List<CollectOrderBillModel> orderBillModel1, XSSFWorkbook workbook, XSSFSheet sheet,String branchName,String branchTel,String branchAddress,String salesOrgName, String branchRemark) {
        int rowNum = 0;
        for(CollectOrderBillModel orderBillModel : orderBillModel1) {
//                XSSFRow rownull = sheet.createRow(rowNum++);
//                rownull.setHeightInPoints((float) 8);
            List<ProductItem> productItems = orderBillModel.getEntries();
            XSSFRow row = sheet.createRow(rowNum++);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue(salesOrgName);
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("微软雅黑");
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
            cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 13));

            XSSFRow row1 = sheet.createRow(rowNum++);
            XSSFCell cell1 = row1.createCell(1);
            cell1.setCellValue("订奶专用收据");
            XSSFCellStyle cellStyle1 = workbook.createCellStyle();
            XSSFFont font1 = workbook.createFont();
            font1.setFontName("微软雅黑");
            font1.setFontHeightInPoints((short) 6);
            cellStyle1.setFont(font1);
            cellStyle1.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
            cellStyle1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
            cell1.setCellStyle(cellStyle1);
            sheet.addMergedRegion(new CellRangeAddress(row1.getRowNum(), row1.getRowNum(), 1, 13));

            XSSFRow row2 = sheet.createRow(rowNum++);
            XSSFRow row3 = sheet.createRow(rowNum++);

            ExcelUtil.createCell(row2,1,"配送奶站："+branchName,ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row2.getRowNum(), row2.getRowNum() + 1, 1, 4));

            ExcelUtil.createCell(row2,5,"订奶起止日期："+
                    (null != orderBillModel.getStartDate()?format.format(orderBillModel.getStartDate()):"") +"--"+
                    (null != orderBillModel.getEndDate()?format.format(orderBillModel.getEndDate()):"" )+"",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row2.getRowNum(), row2.getRowNum() + 1, 5, 9));

            ExcelUtil.createCell(row2,10,"送奶员："+orderBillModel.getEmpName(),ExcelUtil.getCellStyle4(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row2.getRowNum(), row2.getRowNum(), 10, 13));
            String empTel = StringUtils.isNotEmpty(orderBillModel.getEmpTel())?orderBillModel.getEmpTel():"";
            ExcelUtil.createCell(row3,10,"送奶员电话：" + empTel,ExcelUtil.getCellStyle4(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row3.getRowNum(), row3.getRowNum(), 10, 13));

            XSSFRow row4 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row4,1,"客户姓名："+orderBillModel.getVipName(),ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row4.getRowNum(), row4.getRowNum(), 1, 2));

            ExcelUtil.createCell(row4,3,"配送地址："+orderBillModel.getCustAddress(),ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row4.getRowNum(), row4.getRowNum(), 3, 10));

            ExcelUtil.createCell(row4,11,"客户电话："+orderBillModel.getCustTel(),ExcelUtil.getCellStyle4(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row4.getRowNum(), row4.getRowNum(), 11, 13));

            XSSFRow row5 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row5,1,"产品",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row5.getRowNum(), row5.getRowNum(), 1, 4));

            ExcelUtil.createCell(row5,5,"单位",ExcelUtil.setFontStype(workbook));
            ExcelUtil.createCell(row5,6,"单价",ExcelUtil.setFontStype(workbook));

            ExcelUtil.createCell(row5,7,"数量",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row5.getRowNum(), row5.getRowNum(), 7, 8));

            ExcelUtil.createCell(row5,9,"金额",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row5.getRowNum(), row5.getRowNum(), 9, 10));

            ExcelUtil.createCell(row5,11,"产品备注",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row5.getRowNum(), row5.getRowNum(), 11, 13));

            for(ProductItem item : productItems){
                XSSFRow rows = ExcelUtil.createRow(sheet,rowNum++);
                rows.setHeightInPoints((short)12);
                ExcelUtil.createCell(rows,1,item.getMatnrTxt(),ExcelUtil.getCellStyle3(workbook));
                ExcelUtil.addMergedRegion(sheet,rows.getRowNum(),rows.getRowNum(),1,4);
                ExcelUtil.createCell(rows,5,item.getUnit(),ExcelUtil.getCellStyle1(workbook));
                ExcelUtil.createCell(rows,6,item.getBasePrice().toString(),ExcelUtil.getCellStyle1(workbook));
                ExcelUtil.createCell(rows,7,String.valueOf(item.getQty()),ExcelUtil.getCellStyle1(workbook));
                ExcelUtil.addMergedRegion(sheet,rows.getRowNum(),rows.getRowNum(),7,8);
                ExcelUtil.createCell(rows,9,String.valueOf(item.getTotalPrice()),ExcelUtil.getCellStyle1(workbook));
                ExcelUtil.addMergedRegion(sheet,rows.getRowNum(),rows.getRowNum(),9,10);
                ExcelUtil.createCell(rows,11,"",ExcelUtil.getCellStyle1(workbook));
                ExcelUtil.addMergedRegion(sheet,rows.getRowNum(),rows.getRowNum(),11,13);
            }
            if(productItems.size() < 6){
                rowNum=rowNum + 6 - productItems.size();
            }
            XSSFRow row14 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row14,1,"账户余额",ExcelUtil.getCellStyle4(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row14.getRowNum(), row14.getRowNum(), 1, 9));

            ExcelUtil.createCell(row14,10,orderBillModel.getCustAccAmt()!=null?orderBillModel.getCustAccAmt().toString():"0",ExcelUtil.setFontStype(workbook));


            XSSFRow row15 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row15,1,"应收款",ExcelUtil.getCellStyle4(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row15.getRowNum(), row15.getRowNum(), 1, 9));

            ExcelUtil.createCell(row15,10,orderBillModel.getOrderAmt()!=null?orderBillModel.getOrderAmt().toString():"0",ExcelUtil.setFontStype(workbook));

            XSSFRow row16 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row16,1,"奶站地址："+branchAddress,ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row16.getRowNum(), row16.getRowNum(), 1, 6));

            ExcelUtil.createCell(row16,7,"奶站电话："+branchTel,ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row16.getRowNum(), row16.getRowNum(), 7, 10));

            ExcelUtil.createCell(row16,11,"公司电话：4008850555",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row16.getRowNum(), row16.getRowNum(), 11, 13));

            XSSFRow row17 = sheet.createRow(rowNum++);
            ExcelUtil.createCell(row17,1,"备注："+branchRemark,ExcelUtil.getCellStyle2(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row17.getRowNum(), row17.getRowNum() + 1, 1, 13));
            rowNum++;
            XSSFRow row19 = sheet.createRow(rowNum++);
            XSSFCell cell19_1 = row19.createCell(1);

            ExcelUtil.createCell(row19,1,"打印日期："+format.format(new Date()),ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row19.getRowNum(), row19.getRowNum(), 1, 9));

            ExcelUtil.createCell(row19,10,"客户签字：",ExcelUtil.setFontStype(workbook));
            sheet.addMergedRegion(new CellRangeAddress(row19.getRowNum(), row19.getRowNum(), 10, 13));

            XSSFRow rowend = sheet.createRow(rowNum++);
            rowend.setHeightInPoints((float) 12);
        }
        workbook.setPrintArea(
                0, //sheet index
                0, //start column
                14, //end column
                0, //start row
                rowNum //end row
        );
        sheet.setMargin(XSSFSheet.BottomMargin, (double)0); //页边距（下）
        sheet.setMargin(XSSFSheet.LeftMargin, (double)0); //页边距（左）
        sheet.setMargin(XSSFSheet.RightMargin, (double)0); //页边距（右）
        sheet.setMargin(XSSFSheet.TopMargin, (double)0); //页边距（上）
        sheet.setHorizontallyCenter(true); //设置打印页面为水平居中
        sheet.setAutobreaks(true);
        XSSFPrintSetup ps = sheet.getPrintSetup();
        System.out.println(ps.getPaperSize());
        ps.setPaperSize((short)133);
    }
    @POST
    @Path("/reportBatchCollectByEmp")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportBatchCollectByEmp", response = OrderCreateModel.class, notes = "根据订单编号批量导出收款信息")
    public Response reportBatchCollectByEmp(@ApiParam(required = true, name = "model", value = "送奶员编号")CustBillQueryModel model, @Context HttpServletRequest request, @Context HttpServletResponse response) {
//        List<CollectOrderBillModel> orderBillModel1  = customerBillService.BatchPrintForExp(model);
        BatChCollectForExpModel result  = customerBillService.BatchPrintForExp2(model);
        List<CollectOrderBillModel> orderBillModel1 = result.getBillModels();

        BranchEmpModel empModel = branchEmpService.empDetailInfo(model.getEmpNo());
        String url = EnvContant.getSystemConst("filePath");
        String outUrl = "";
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "BatchCollectOrderTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));

            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);
            XSSFCell cell = row.getCell(1);
//            cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            cell.setCellValue("配送奶站："+empModel.getEmp().getBranchName());

            cell = row.getCell(5);
//            cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            cell.setCellValue("送奶员: "+empModel.getEmp().getEmpName());
            int rowNum = 4;
            if(orderBillModel1.size() > 0) {
                for(CollectOrderBillModel orderBillModel : orderBillModel1){
                    List<ProductItem> productItems = orderBillModel.getEntries();
                    row = sheet.createRow(rowNum);
                    cell = row.createCell(1);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(orderBillModel.getCustAddressShort());
                    cell = row.createCell(2);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(orderBillModel.getCustTel());
                    cell = row.createCell(3);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    StringBuilder pitemstr = new StringBuilder();
                    for(ProductItem pItems : productItems){
                        pitemstr.append(pItems.getMatnrTxt().concat("--").concat(String.valueOf(pItems.getQty())).concat("  "));
                    }
                    cell.setCellValue(pitemstr.toString());
                    cell = row.createCell(4);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(orderBillModel.getInitAmt()!=null?orderBillModel.getInitAmt().toString():"0");
                    cell = row.createCell(5);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(orderBillModel.getCustAccAmt()!=null?orderBillModel.getCustAccAmt().toString():"0");
                    cell = row.createCell(6);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(orderBillModel.getOrderAmt()!=null?orderBillModel.getOrderAmt().toString():"0");
                    cell = row.createCell(7);cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    cell.setCellValue(format.format(orderBillModel.getStartDate()));
                    rowNum++;

                }
                //executeBatchSheet(lt6, workbook, sheet);
            }

            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "BatchCollectOrder.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "BatchCollectOrder.xlsx";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    private void executeBatchSheet(List<CollectOrderBillModel> orderBillModel1, XSSFWorkbook workbook, XSSFSheet sheet){
        int rowNum = 0;
        for(CollectOrderBillModel orderBillModel : orderBillModel1) {
            List<ProductItem> productItems = orderBillModel.getEntries();
            XSSFRow row = sheet.createRow(rowNum++);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue(orderBillModel.getSalesOrgName());
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("微软雅黑");
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
            cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
            cell.setCellStyle(cellStyle);
            //sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 13));

            XSSFRow row2 = sheet.createRow(rowNum++);

        }
    }
    @POST
    @Path("/exportDispInlOrderByModel")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportDispInlOrderByModel}", response = ResponseModel.class, notes = "导出出奶表-台帐")
    public Response exportDispInlOrderByModel(@ApiParam(name = "model",value = "出奶表-台帐") ExtendBranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranchEmp emp = branchEmpService.selectBranchEmpByNo(model.getEmpNo());
        String url = EnvContant.getSystemConst("filePath");
        String outUrl = "";
        try{
            model.setBranchNo(user.getBranchNo());

            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "EmpAccountTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("微软雅黑");
            font.setFontHeightInPoints((short) 10);
            cellStyle.setFont(font);
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
            cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中
            //需要加粗的样式
            XSSFCellStyle cellStyleBold = workbook.createCellStyle();
            XSSFFont fontBold = workbook.createFont();
            fontBold.setFontName("微软雅黑");
            fontBold.setFontHeightInPoints((short) 10);
            fontBold.setBold(true);
            cellStyleBold.setFont(fontBold);
            cellStyleBold.setAlignment(XSSFCellStyle.ALIGN_CENTER);//水平居中
            cellStyleBold.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直居中

            int rowNum = 0;
            //内部销售订单+确认的路单配送数量月份集合，按照日期、送奶员分组统计
            List<Map<String, String>> dispInls = branchInfoService.exportDispInlOrderByModel(model);
            //查询出奶表统计金额
            List<TssmMilkmanAmts> tmas = outMilkService.selectAmtsByPrimaryKey(model);

            Map<String, String> projectMap = new TreeMap<String, String>();//产品行
            Map<String, String> dateMap = new TreeMap<String, String>();//员工列
            for (Map<String, String> map : dispInls) {
                projectMap.put(map.get("CONFIRM_MATNR"), map.get("MATNR_TXT"));
                dateMap.put(map.get("DISP_DATE"), map.get("DISP_DATE"));
            }
            projectMap.put("A-REAMT","上日结存");
            projectMap.put("B-DAYAMT","本日进货");
            projectMap.put("C-DAYBILLAMT","本日交款");
            projectMap.put("D-TOTALAMT","结存金额");
            int columnNum = 1;
            XSSFRow row1 = sheet.getRow(3);
            for (Map.Entry<String, String> entry : projectMap.entrySet()) {
                XSSFCell cell = row1.createCell(columnNum++);
                cell.setCellValue(entry.getValue());
                cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            }
            //表头
            XSSFRow row0 = sheet.createRow(0);
            XSSFCell cellhead = row0.createCell(0);
            cellhead.setCellValue(user.getOrgName()+"出奶表");
            cellhead.setCellStyle(cellStyle);
            int headNum = 0;
            if(columnNum!=0){
                headNum = columnNum-1;
            }
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headNum));
            //日期
            XSSFRow rowsec = sheet.createRow(1);
            XSSFCell cellsec = rowsec.createCell(0);
            cellsec.setCellValue(model.getMonthDate());
            cellsec.setCellStyle(cellStyleBold);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, headNum));
            //奶站送奶员信息
            XSSFRow rowthe = sheet.createRow(2);
            XSSFCell cellthe = rowthe.createCell(0);
            cellthe.setCellValue("奶站："+user.getBranchName());
            cellthe.setCellStyle(cellStyleBold);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));
            if(headNum>4){
                cellthe = rowthe.createCell(headNum-3);
                cellthe.setCellValue(emp.getEmpName());
                cellthe.setCellStyle(cellStyleBold);
                cellthe = rowthe.createCell(headNum-2);
                cellthe.setCellValue("单位：袋、瓶、杯、元");
                cellthe.setCellStyle(cellStyle);
                sheet.addMergedRegion(new CellRangeAddress(2, 2, headNum-2, headNum));
            }

            rowNum = 4;
            for (Map.Entry<String, String> entry : dateMap.entrySet()) {
                int cNum = 0;
                XSSFRow row = sheet.createRow(rowNum++);
                XSSFCell cell = row.createCell(cNum++);
                String dispdate = format.format(entry.getKey());
                cell.setCellValue(format.format(entry.getKey()));
                cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                for (Map.Entry<String, String> entry1 : projectMap.entrySet()) {
                    XSSFCell cell1 = row.createCell(cNum++);
                    cell1.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    String matnr = entry1.getKey();
                    for (Map<String, String> map : dispInls) {
                        String matnrT = map.get("CONFIRM_MATNR");
                        String disoDateT = format.format(map.get("DISP_DATE"));
                        if (dispdate.equals(disoDateT) && matnr.equals(matnrT)) {
                            if (map.get("CONFIRM_QTY") != null) {
                                int CCQTY = new BigDecimal(String.valueOf(map.get("CONFIRM_QTY"))).intValue();
                                cell1.setCellValue(CCQTY);
                                cell1.setCellStyle(cellStyle);
                            }
                        }
                    }
                    for(TssmMilkmanAmts details:tmas){
                        cell1.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                        String disoDateT = format.format(details.getOrderDate());
                        if(dispdate.equals(disoDateT) && entry1.getValue().equals("上日结存")){
                            cell1.setCellValue(details.getReAmt()==null?"":String.valueOf(details.getReAmt()));
                            cell1.setCellStyle(cellStyle);
                        }
                        if(dispdate.equals(disoDateT) && entry1.getValue().equals("本日进货")){
                            cell1.setCellValue(details.getDayAmt()==null?"":String.valueOf(details.getDayAmt()));
                            cell1.setCellStyle(cellStyle);
                        }
                        if(dispdate.equals(disoDateT) && entry1.getValue().equals("本日交款")){
                            cell1.setCellValue(details.getDayBillAmt()==null?"":String.valueOf(details.getDayBillAmt()));
                            cell1.setCellStyle(cellStyle);
                        }
                        if(dispdate.equals(disoDateT) && entry1.getValue().equals("结存金额")){
                            cell1.setCellValue(details.getTotalAmt()==null?"":String.valueOf(details.getTotalAmt()));
                        }
                    }
                }
            }
            int scNum = 0;
            XSSFRow row = sheet.createRow(rowNum);
            XSSFCell cellColTitle = row.createCell(scNum++);
            cellColTitle.setCellValue("本月合计");
            cellColTitle.setCellStyle(cellStyleBold);
            cellColTitle.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            int totalQty = 0;
            //产品循环-列合计
            for (Map.Entry<String, String> entry1 : projectMap.entrySet()) {
                int ROWQTY = 0;
                double tamsQty = 0;

                String matnr = entry1.getKey();
                for (Map<String, String> map : dispInls){
                    String matnrT =map.get("CONFIRM_MATNR");
                    if( matnr.equals(matnrT)){
                        if(map.get("CONFIRM_QTY")!=null){
                            int rqty =  new BigDecimal(String.valueOf( map.get("CONFIRM_QTY"))).intValue();
                            ROWQTY =ROWQTY + rqty;
                            totalQty = totalQty + rqty;
                        }
                    }
                }
                if(entry1.getValue().equals("上日结存")){
                    ROWQTY = totalQty;
                }

                for(TssmMilkmanAmts details:tmas){
                    for (Map.Entry<String, String> entry : dateMap.entrySet()){
                        String dispdate = format.format(entry.getKey());
                        String tmasDate = format.format(details.getOrderDate());
                        if(entry1.getValue().equals("本日进货")&& dispdate.equals(tmasDate)){
                            double rqty =  new BigDecimal(String.valueOf(details.getDayAmt())).doubleValue();
                            tamsQty =tamsQty + rqty;
                        }
                        if(entry1.getValue().equals("本日交款")&& dispdate.equals(tmasDate)){
                            double rqty =  new BigDecimal(String.valueOf(details.getDayBillAmt())).doubleValue();
                            tamsQty =tamsQty + rqty;
                        }
                    }

                }

                XSSFCell cell = row.createCell(scNum++);
                cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                if(entry1.getValue().equals("本日进货")){
                    cell.setCellValue(String.valueOf(tamsQty));
                }else if(entry1.getValue().equals("本日交款")){
                    cell.setCellValue(String.valueOf(tamsQty));
                }else if(entry1.getValue().equals("结存金额")){
                    cell.setCellValue("");
                }else{
                    cell.setCellValue(String.valueOf(ROWQTY));
                }
            }

            outUrl = saveFile(url, workbook,"Emp.xlsx");
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    @POST
    @Path("/exportOrderByModel")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportOrderByModel}", response = ResponseModel.class, notes = "导出奶站分奶表")
    public Response exportOrderByModel(@ApiParam(name = "model",value = "路单") BranchInfoModel model){
        String url = EnvContant.getSystemConst("filePath");
        String outUrl = "";
        TSysUser currentUser=null;
        try {
            if(StringUtils.isEmpty(model.getBranchNo())){
            	currentUser = userSessionService.getCurrentUser();
                model.setBranchNo(currentUser.getBranchNo());
            }
            List<Map<String, String>> orders = branchInfoService.exportOrderByModel(model);
            //获取奶站可销售的产品
            ProductQueryModel pm = new ProductQueryModel();
            pm.setSeting("N");
            List<TMdMara> branchSaleMaraList = productService.getBranchSaleMaraList(pm);
            
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "FnbTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("sheet");
            int rowNum = 0;
            XSSFCell cellDate = sheet.createRow(0).createCell(0);
            SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
            cellDate.setCellValue("分奶表日期： "+ dateFmt.format(model.getTheDate()));
            
            Map<String, String> projectMap = new HashMap<String, String>();//产品行
            Map<String, String> empMap = new HashMap<String, String>();//员工列
//            ArrayList<String> emps=new ArrayList<String>();//送奶员编号
            Set<String> emps= new HashSet<String>();
            for (Map<String, String> map : orders) {
                projectMap.put(map.get("CONFIRM_MATNR"), map.get("MATNR_TXT"));
                empMap.put(map.get("DISP_EMP_NO"), map.get("EMP_NAME"));
                emps.add(map.get("DISP_EMP_NO"));
            }
            
            //分奶排序:判断是否存在排序
            if(branchSaleMaraList !=null &&  branchSaleMaraList.size() >0){
            	//LinkedHashMap有序map进行排序
            	Map<String, String> projectMapSort = new LinkedHashMap<String, String>();//产品行
            	for (TMdMara tMdMara : branchSaleMaraList) {
            		//获取排序000000000050000006;000000000050000006
            		String value = projectMap.get(tMdMara.getMatnr());
            		//判断是否存在
            		if(StringUtils.isNotBlank(value)){
            			//如果现将排序
            			if("N".equals(tMdMara.getHide())){
            				projectMapSort.put(tMdMara.getMatnr(), value);
            			}
            		}else{
            			if("N".equals(tMdMara.getHide())){
            				projectMapSort.put(tMdMara.getMatnr(), value);
            				projectMapSort.put(tMdMara.getMatnr(),tMdMara.getMatnrTxt());
            			}
            		}
				}
            	projectMap=projectMapSort;
            }
            
            
            //员工入职时间排序
            List<TSysUser>  userList=userService.findUserByLoginNameList( new ArrayList<>(emps));
            if(userList !=null &&  userList.size() >0){
            	//LinkedHashMap有序map进行排序
            	Map<String, String> empMapSort = new LinkedHashMap<String, String>();//产品行
            	for (TSysUser user : userList) {
            		//获取排序
            		String value = empMap.get(user.getLoginName());
            		//判断是否
            		if(StringUtils.isNotBlank(value)){
            			empMapSort.put(user.getLoginName(), value);
            			empMap.remove(user.getLoginName());
            		}
				}
            	empMapSort.putAll(empMap);
            	empMap=empMapSort;
            }
            
            
            int columnNum = 1;
            XSSFRow row1 = sheet.getRow(2);

            for (Map.Entry<String, String> entry : projectMap.entrySet()) {
                XSSFCell cell = row1.createCell(columnNum++);
                cell.setCellValue(entry.getValue());
                cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            }
            
            
            XSSFCell cellSumTitle = row1.createCell(columnNum);
            cellSumTitle.setCellValue("合计");
            cellSumTitle.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            
            XSSFCell signatory = row1.createCell(columnNum+1);
            signatory.setCellValue("签收人");
            signatory.setCellStyle(ExcelUtil.setBorderStyle(workbook));

            rowNum = 3;
            for (Map.Entry<String, String> entry : empMap.entrySet()) {
                int CELLQTY = 0;
                int cNum = 0;
                XSSFRow row = sheet.createRow(rowNum++);
                XSSFCell cell = row.createCell(cNum++);
                String empNo = entry.getKey();
                cell.setCellValue(entry.getValue());
                cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                //Excel 产品名称循环
                for (Map.Entry<String, String> entry1 : projectMap.entrySet()) {
                    XSSFCell cell1 = row.createCell(cNum++);
                    cell1.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                    //设置默认值
                    //cell1.setCellValue(0);
                    String matnr = entry1.getKey();
//                    cell1.setCellValue(matnr);
                    //循环订单
                    for (Map<String, String> map : orders) {
                    	//当前产品产品编号
                        String matnrT =map.get("CONFIRM_MATNR");
                        //前产品送奶员
                        String empNoT = map.get("DISP_EMP_NO");
                        if(empNo.equals(empNoT) && matnr.equals(matnrT)){
                            if(map.get("CQTY")!=null) {
                                String count;
                                int RESEND_QTY =  new BigDecimal(String.valueOf( map.get("RESEND_QTY"))).intValue();
                                int CCQTY =  new BigDecimal(String.valueOf( map.get("CQTY"))).intValue();
                                if(RESEND_QTY==0){
                                    count = String.valueOf( map.get("CQTY"));
                                }else{
                                    count = String.valueOf(CCQTY-RESEND_QTY).concat(",(").concat(String.valueOf(RESEND_QTY)).concat(")");
                                }
                                cell1.setCellValue(count);
                                int cqty =  new BigDecimal(String.valueOf( map.get("FINAL_QTY"))).intValue();
                                CELLQTY = CELLQTY + cqty;
                            }
                        }
                    }
                    
                }
                //行合计
                XSSFCell cellSum = row.createCell(cNum);
                cellSum.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                cellSum.setCellValue(String.valueOf(CELLQTY));
                
                //签收人
                XSSFCell signator = row.createCell(cNum+1);
                signator.setCellStyle(ExcelUtil.setBorderStyle(workbook));
                
            }
            int scNum = 0;
            XSSFRow row = sheet.createRow(rowNum);
            XSSFCell cellColTitle = row.createCell(scNum++);
            cellColTitle.setCellValue("合计");
            cellColTitle.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            int totalQty = 0;
            //产品循环-列合计
            for (Map.Entry<String, String> entry1 : projectMap.entrySet()) {
                int ROWQTY = 0;
                String matnr = entry1.getKey();
                    for (Map<String, String> map : orders){
                        String matnrT =map.get("CONFIRM_MATNR");
                        if( matnr.equals(matnrT)){
                            if(map.get("FINAL_QTY")!=null){
                                int rqty =  new BigDecimal(String.valueOf( map.get("FINAL_QTY"))).intValue();
                                ROWQTY =ROWQTY + rqty;
                            }
                        }
                    }
                totalQty = totalQty + ROWQTY;
                XSSFCell cell = row.createCell(scNum++);
            	cell.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            	cell.setCellValue(String.valueOf(ROWQTY));
            }
            //总合计
            XSSFCell cellTotolSum = row.createCell(scNum++);
            cellTotolSum.setCellStyle(ExcelUtil.setBorderStyle(workbook));
            cellTotolSum.setCellValue(String.valueOf(totalQty));
            //签收人
            XSSFCell signator = row.createCell(scNum);
            signator.setCellStyle(ExcelUtil.setBorderStyle(workbook));

            outUrl = saveFileOrderBy(url, workbook,format.format(model.getTheDate())+"分奶表"+".xlsx");
//            outUrl = fname + "fnb.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    
    
    private String saveFileOrderBy(String url, XSSFWorkbook workbook,String fileName) throws IOException {
        String rq =fileName.split("\\.")[0];
        String filePath = url + File.separator + "report" + File.separator + "export";
        File delFiles = new File(filePath);
        if (delFiles.isDirectory()) {
            for (File del : delFiles.listFiles()) {
                if (del.getName().contains(rq)) {
                    del.delete();
                }
            }
        }
        File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fileName);
        FileOutputStream stream = new FileOutputStream(export);
        workbook.write(stream);
        stream.flush();
        stream.close();
        return fileName;
    }
    
    

    private String saveFile(String url, XSSFWorkbook workbook,String fileName) throws IOException {
        String fname = CodeGeneratorUtil.getCode() + fileName;
        String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
        String filePath = url + File.separator + "report" + File.separator + "export";
        File delFiles = new File(filePath);
        if (delFiles.isDirectory()) {
            for (File del : delFiles.listFiles()) {
                if (del.getName().contains(rq)) {
                    del.delete();
                }
            }
        }
        File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname);
        FileOutputStream stream = new FileOutputStream(export);
        workbook.write(stream);
        stream.flush();
        stream.close();
        return fname;
    }

    @POST
    @Path("/reportDispItem")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportDispItem",response = ResponseModel.class,notes = "导出路单明细")
    public Response reportDispItem(@ApiParam(value = "路单参数",required = true,name = "model") DispOrderReportModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<DispOrderReportEntityModel> lists = deliverMilkService.reportDispOrderItemByParams(model);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("sheet1");

            int rowNum = 0;
            XSSFRow row = sheet.createRow(rowNum++);
            int rawNum = 0;
            XSSFCell cell = row.createCell(rawNum++);
            cell.setCellValue("送奶员");
            cell = row.createCell(rawNum++);
            cell.setCellValue("送奶日期");
            cell = row.createCell(rawNum++);
            cell.setCellValue("送奶时间");
            cell = row.createCell(rawNum++);
            cell.setCellValue("配送地址");
            cell = row.createCell(rawNum++);
            cell.setCellValue("联系电话");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户姓名");
            cell = row.createCell(rawNum++);
            cell.setCellValue("应送产品");
            cell = row.createCell(rawNum++);
            cell.setCellValue("应送数量");
            cell = row.createCell(rawNum++);
            cell.setCellValue("实送产品");
            cell = row.createCell(rawNum++);
            cell.setCellValue("实送数量");
            for (DispOrderReportEntityModel entity : lists) {
                int raw = 0;
                row = sheet.createRow(rowNum++);
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getEmpName());
                cell = row.createCell(raw++);
                cell.setCellValue(format.format(entity.getDispDate()));
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getReachTimeType());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getAddressTxt());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getMp());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getVipName());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getMatnrTxt());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getQty().toString());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getConfirmMatnrTxt());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getConfirmQty().toString());
            }
            for(int i=0;i<rawNum;i++){
                sheet.setColumnWidth(i,(short)50*100);
            }
            outUrl = saveFile(url, workbook,"DispItem.xlsx");
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/reportOrderDaliyPlan")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/reportOrderDaliyPlan",response = ResponseModel.class,notes = "导出日计划明细报表")
    public Response reportOrderDaliyPlan(@ApiParam(value = "日计划明细参数",required = true,name = "model") OrderDaliyPlanReportModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<OrderDaliyPlanReportEntityModel> lists = deliverMilkService.reportOrderDaliyPlanByParams(model);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("日计划明细");
            int rowNum = 0;
            XSSFRow row = sheet.createRow(rowNum++);
            int rawNum = 0;
            XSSFCell cell = row.createCell(rawNum++);
            cell.setCellValue("订户电话");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户地址");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户姓名");
            cell = row.createCell(rawNum++);
            cell.setCellValue("配送日期");
            cell = row.createCell(rawNum++);
            cell.setCellValue("产品简称");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订单余额");
            cell = row.createCell(rawNum++);
            cell.setCellValue("数量");
            cell = row.createCell(rawNum++);
            cell.setCellValue("单价");
            cell = row.createCell(rawNum++);
            cell.setCellValue("配送时间");
            cell = row.createCell(rawNum++);
            cell.setCellValue("送奶员");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户订单");
            cell = row.createCell(rawNum++);
            cell.setCellValue("状态");
            for(OrderDaliyPlanReportEntityModel entity : lists){
                int raw = 0;
                row = sheet.createRow(rowNum++);
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getMp());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getAddressTxt());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getVipName());
                cell = row.createCell(raw++);
                cell.setCellValue(format.format(entity.getDispDate()));
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getMatnrTxt());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getCurAmt()!=null?entity.getCurAmt().toString():"");
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getQty()!=null?entity.getQty().toString():"");
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getPrice()!=null?entity.getPrice().toString():"");
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getReachTimeType());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getEmpName());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getOrderNo());
                cell = row.createCell(raw++);
                cell.setCellValue(entity.getStatus());

            }
            for(int i=0;i<rawNum;i++){
                sheet.setColumnWidth(i,(short)50*100);
            }
            outUrl = saveFile(url, workbook,"OrderDaliyPlan.xlsx");
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/orderOnlineStatReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/orderOnlineStatReport",response = ResponseModel.class,notes = "导出对账报表")
    public Response orderOnlineStatReport(@ApiParam(value = "对账报表",required = true,name = "model") ExtendBranchInfoModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<Map<String,String>>  lists = branchInfoService.orderOnlineStatReport(model);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("对账报表");
            int rowNum = 0;
            XSSFRow row = sheet.createRow(rowNum++);
            int rawNum = 0;
            XSSFCell cell = row.createCell(rawNum++);
            cell.setCellValue("经销商");
            cell = row.createCell(rawNum++);
            cell.setCellValue("奶站");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订单编号");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订单来源");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户电话");
            cell = row.createCell(rawNum++);
            cell.setCellValue("原单价");
            cell = row.createCell(rawNum++);
            cell.setCellValue("订户价");
            cell = row.createCell(rawNum++);
            cell.setCellValue("付款时间");
            if(lists!=null){
                for(Map<String,String> map : lists){
                    int raw = 0;
                    row = sheet.createRow(rowNum++);
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("DEALER_NAME")==null?"自营奶站":map.get("DEALER_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("BRANCH_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("ORDER_NO"));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("PREORDER_SOURCE").concat(map.get("ONLINE_SOURCE_TYPE")==null?"":"-".concat(map.get("ONLINE_SOURCE_TYPE"))));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("VIP_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("VIP_MP"));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("ONLINE_INIT_AMT")==null?"0":String.valueOf(map.get("ONLINE_INIT_AMT")));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("CUR_AMT")==null?"0":String.valueOf(map.get("CUR_AMT")));
                    cell = row.createCell(raw++);
                    cell.setCellValue(map.get("PAY_DATE")==null?"":String.valueOf(map.get("PAY_DATE")));
                }
            }

            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "OrderOnlineStat.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "OrderOnlineStat.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/pendingUnConfirmOnlineReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/pendingUnConfirmOnlineReport",response = ResponseModel.class,notes = "导出待确认订单")
    public Response pendingUnConfirmOnlineReport(){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<Map<String, String>> unConfirmOrders = branchInfoService.PendingUnConfirmOnline();
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "UnConfirmOrdersTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = 1;
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);
            if(unConfirmOrders!=null){
                for(Map<String,String> map : unConfirmOrders){
                    int raw = 0;
                    XSSFRow row = sheet.createRow(rowNum);
                    XSSFCell cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(format.format(new Date()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("ONLINEORDER_NO"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("ORDER_NO"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("VIP_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("VIP_MP"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("RESIDENTIAL_AREA_TXT")==null?"":map.get("RESIDENTIAL_AREA_TXT").concat(map.get("ADDRESS_TXT")));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("MATNR"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("SHORT_TXT"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("DISP_TOTAL")==null?"0":String.valueOf(map.get("DISP_TOTAL")));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("ONLINE_INIT_AMT")==null?"0":String.valueOf(map.get("ONLINE_INIT_AMT")));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("BRANCH_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("PREORDER_SOURCE"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("MEMO_TXT"));
                    rowNum++;
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "UnConfirmOrders.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "UnConfirmOrders.xlsx";
        }catch(Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/yearCardCompensateList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/yearCardCompensateList",response = ResponseModel.class,notes = "年卡补偿单据")
    public Response yearCardCompensateList(@ApiParam(value = "区间日期",required = true,name = "model") ExtendBranchInfoModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<TMstYearCardCompOrder>  lists = orderService.selectYearCardCompensateList(model);
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "YearCardCompensateTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = 2;
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);

            XSSFRow row = sheet.createRow(rowNum++);
            int rawNum = 0;
            XSSFCell cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("序号");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("订单编号");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("客户姓名");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("地址");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("电话");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("产品名称");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("日均数量");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("预定总数");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("已消费总数");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("原单价");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("原折扣");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("应退款");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("实际折扣");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("实退款");
            cell = row.createCell(rawNum++);
            cell.setCellStyle(styleBold);
            cell.setCellValue("差额");
            if(lists!=null){
                for(TMstYearCardCompOrder ycc : lists){
                    int raw = 0;
                    row = sheet.createRow(rowNum);
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(rowNum-2);
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getOrderNo());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getVipName());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getCustAddress());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getCustMp());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getMatnrTxt());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(ycc.getDaliyQty()==null?0:(ycc.getDaliyQty()).intValue());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(String.valueOf(ycc.getPreTotal()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(String.valueOf(ycc.getRealTotal()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getInitAmt()==null?"0":String.valueOf(ycc.getInitAmt()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getPreDiscount()==null?"0":String.valueOf(ycc.getPreDiscount()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getShRefund()==null?"0":String.valueOf(ycc.getShRefund()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getRealDiscount()==null?"0":String.valueOf(ycc.getRealDiscount()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getRealRefund()==null?"0":String.valueOf(ycc.getRealRefund()));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(ycc.getDifference()==null?"0":String.valueOf(ycc.getDifference()));
                    rowNum++;
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "YearCards.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "YearCards.xlsx";
        }catch(Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/exportQueryRequireOrder")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportQueryRequireOrder", response = RequireOrderModel.class, notes = "导出查询奶站下某一天的要货计划")
    public Response exportQueryRequireOrder(@ApiParam(required=true,name="eSearch",value="要货计划日期") ReqGoodsOrderSearch eSearch) {
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        RequireOrderModel orderModel = requireOrderService.searchRequireOrder(eSearch.getRequiredDate());
        TSysUser user = userSessionService.getCurrentUser();
        try{
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "RequireOrderTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);

            XSSFRow row = sheet.getRow(0);
            XSSFCell cell = row.getCell(1);
            cell.setCellValue(orderModel.getOrderNo());
            row = sheet.getRow(1);
            cell = row.getCell(1);
            cell.setCellValue(orderModel.getVoucherNo());

            int rowNum = 4;
            int totalQty=0;
            if(orderModel.getEntries()!=null){
                for(OrderRequireItem orItems:orderModel.getEntries()){
                    int raw = 0;
                    XSSFRow rowList = sheet.createRow(rowNum);
                    XSSFCell cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getMatnr()!=null?orItems.getMatnr().substring(10):"");
                    cellList.setCellStyle(styleBold);
                    cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getMatnrTxt());
                    cellList.setCellStyle(styleBold);
                    cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getQty());
                    cellList.setCellStyle(styleBold);
                    cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getIncreQty());
                    cellList.setCellStyle(styleBold);
                    cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getIncreQty()+orItems.getQty());
                    cellList.setCellStyle(styleBold);
                    cellList = rowList.createCell(raw++);
                    cellList.setCellValue(orItems.getResendQty());
                    cellList.setCellStyle(styleBold);
                    rowNum++;
                    totalQty = totalQty + orItems.getIncreQty() + orItems.getQty();

                }
            }
            row = sheet.getRow(2);
            cell = row.getCell(1);
            cell.setCellValue(totalQty);
            row = sheet.getRow(2);
            cell = row.getCell(4);
            cell.setCellValue(user.getBranchName());
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "RequireOrder.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "RequireOrder.xlsx";
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/exportReturnBox")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportReturnBox", response = ResponseModel.class, notes = "回瓶汇总导出")
    public Response exportReturnBox(@ApiParam(name = "model",value = "回瓶汇总") ExtendBranchInfoModel model){
        String outUrl = "";
        String url =EnvContant.getSystemConst("filePath");
        List<Map<String, String>> boxList = branchInfoService.returnBoxStatList(model);
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "ReturnBoxTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = 2;
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);
            if(boxList!=null){
                for(Map<String,String> map : boxList){
                    int raw = 0;
                    XSSFRow row = sheet.createRow(rowNum);
                    XSSFCell cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("BRANCH_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("EMP_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("SPEC_NAME"));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("RECEIVE_NUM")==null?"0":String.valueOf(map.get("RECEIVE_NUM")));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("REAL_NUM")==null?"0":String.valueOf(map.get("REAL_NUM")));
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(map.get("dif")==null?"0":String.valueOf(map.get("dif")));

                    rowNum++;
                }
            }
            String fname = CodeGeneratorUtil.getCode();
            String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
            String filePath = url +  File.separator + "report"+ File.separator + "export";
            File delFiles = new File(filePath);
            if(delFiles.isDirectory()){
                for(File del : delFiles.listFiles()){
                    if(del.getName().contains(rq)){
                        del.delete();
                    }
                }
            }
            File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "rbox.xlsx");
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();
            outUrl = fname + "rbox.xlsx";
        }catch(Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    /**
     * 配送区域下载
     * @param model
     * @return
     */
    @POST
    @Path("/exportArea")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportArea", response = ResponseModel.class, notes = "配送区域下载")
    public Response exportArea(@ApiParam(name = "model",value = "配送区域") AreaSearchModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");

        List<TMdResidentialArea> areaList = sesidentialAreaService.searchAreaSaleOrgBranchNo(model);
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "AreaDownTemplate.xlsx");    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
            styleBold.setWrapText(true);
            int rowNum = 1;
            if(areaList!=null){
                for(TMdResidentialArea area : areaList){
                    int raw = 0;
                    XSSFRow row = sheet.createRow(rowNum);
                    XSSFCell cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getId());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getResidentialAreaTxt());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getAddressTxt());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getBranchNo());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getBranchName());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getProvinceName());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getCityName());
                    cell = row.createCell(raw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(area.getCountyName());

                    rowNum++;

                }
                String fname = CodeGeneratorUtil.getCode();
                String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
                String filePath = url +  File.separator + "report"+ File.separator + "export";
                File delFiles = new File(filePath);
                if(delFiles.isDirectory()){
                    for(File del : delFiles.listFiles()){
                        if(del.getName().contains(rq)){
                            del.delete();
                        }
                    }
                }
                File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "area.xlsx");
                FileOutputStream stream = new FileOutputStream(export);
                workbook.write(stream);
                stream.flush();
                stream.close();
                outUrl = fname + "area.xlsx";
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }

    /**
     * 模版下载
     * @param fileName
     * @return
     */
    @GET
    @Path("/exportTemplate/{fileName}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportTemplate/{fileName}", response = OrderCreateModel.class, notes = "下载模版文件")
    public Response exportTemplate(@ApiParam(required = true,value = "fileName",defaultValue = "fileName")@PathParam("fileName") String fileName){
        String url = EnvContant.getSystemConst("filePath");
//        String url = request.getServletContext().getRealPath("/");
        String urlPath = url +  File.separator + "report"+ File.separator + "template" + File.separator + fileName+".xlsx";
//        String urlPath = url + fileName;
        logger.info("##########"+urlPath);
        return convertToFile(urlPath);
    }
    @GET
    @Path("/exportAreasCode/{itemCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportAreasCode/{itemCode}", response = ResponseModel.class, notes = "配送区域下载")
    public Response exportAreasCode(@ApiParam(required = true,value = "itemCode",defaultValue = "itemCode")@PathParam("itemCode")  String itemCode){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");
        List<NHSysCodeItem> areasItems = dicService.getTreeCodeItemsByTypeCode("1001");

        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "AreasCodeTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框

            styleBold.setWrapText(true);
            int rowNum = 1;

            if(areasItems!=null){
                for(NHSysCodeItem items : areasItems){
                    if(items.getItemCode().equals(itemCode)){
                        XSSFRow row = sheet.createRow(rowNum);
                        XSSFCell cell = row.createCell(0);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.getItemName());
                        cell = row.createCell(3);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.getItemCode());
                        if(items.getChildrens()!=null){
                            int rowNum2 = rowNum+1;
                            for(NHSysCodeItem childres2:items.getChildrens()){
                                XSSFRow chrrow = sheet.createRow(rowNum2);
                                XSSFCell chrcell = chrrow.createCell(1);
                                chrcell.setCellStyle(styleBold);
                                chrcell.setCellValue(childres2.getItemName());
                                chrcell = chrrow.createCell(3);
                                chrcell.setCellStyle(styleBold);
                                chrcell.setCellValue(childres2.getItemCode());
                                if(childres2.getChildrens()!=null){
                                    int rowNum3 = rowNum2+1;
                                    for(NHSysCodeItem childres3:childres2.getChildrens()){
                                        XSSFRow chrrow3 = sheet.createRow(rowNum3);
                                        XSSFCell chrcell3 = chrrow3.createCell(2);
                                        chrcell3.setCellStyle(styleBold);
                                        chrcell3.setCellValue(childres3.getItemName());
                                        chrcell3 = chrrow3.createCell(3);
                                        chrcell3.setCellStyle(styleBold);
                                        chrcell3.setCellValue(childres3.getItemCode());
                                        rowNum3++;
                                    }
                                    rowNum2 = rowNum3++;

                                }
                            }
                        }
                        rowNum++;
                    }
                }
                String fname = CodeGeneratorUtil.getCode();
                String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
                String filePath = url +  File.separator + "report"+ File.separator + "export";
                File delFiles = new File(filePath);
                if(delFiles.isDirectory()){
                    for(File del : delFiles.listFiles()){
                        if(del.getName().contains(rq)){
                            del.delete();
                        }
                    }
                }
                File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "area.xlsx");
                FileOutputStream stream = new FileOutputStream(export);
                workbook.write(stream);
                stream.flush();
                stream.close();
                outUrl = fname + "area.xlsx";
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
    @POST
    @Path("/getDayReportBasisForm")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/getDayReportBasisForm}", response = ResponseModel.class, notes = "要货计划日报表")
    public Response getDayReportBasisForm(@ApiParam(name = "model",value = "output要货计划日报表") BranchInfoModel model){
        String outUrl = "";
        String url = EnvContant.getSystemConst("filePath");

        List<Map<String,String>> branchList = branchInfoService.getDayReportBranch(model);
        try {
            File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "BasisFormTemplate.xlsx");
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
            styleBold.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
            styleBold.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
            styleBold.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框

            styleBold.setWrapText(true);
            int totalNum =1;
            int allRaw=0;
            int allnormalOrderTotal =  0;
            int allDSOrderTotal =  0;
            int allNNQBOrderTotal =  0;
            int allyearOrderTotal =  0;
            int allorgOrderTotal =  0;
            int allgiveOrderTotal =  0;
            int alltotalQtyTotal = 0;
            if(branchList!=null){
                for(Map<String,String> branchitems:branchList){
                    int totalRaw = 0;
                    int normalOrderTotal =  0;
                    int DSOrderTotal =  0;
                    int NNQBOrderTotal =  0;
                    int yearOrderTotal =  0;
                    int orgOrderTotal =  0;
                    int giveOrderTotal =  0;
                    int totalQtyTotal = 0;

                    model.setBranchNo(branchitems.get("BRANCH_NO"));
                    //取一个奶站的
                    List<Map<String,String>> basisFormItems = branchInfoService.getDayReportBasisForm(model);
                    int rowNum = totalNum;

                    for(Map<String,String> items:basisFormItems){
                        int raw = 0;
                        XSSFRow row = sheet.createRow(rowNum);
                        XSSFCell cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("BRANCH_NO"));//奶站编码
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("BRANCH_NAME"));//奶站名称
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("SHORT_TXT"));//产品简称
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("ITEM_NAME"));//单位
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("normalOrder")==null?"":String.valueOf(items.get("normalOrder")));//饮户订奶
                        if(items.get("normalOrder")!=null){
                            int normalOrder =  new BigDecimal(String.valueOf( items.get("normalOrder"))).intValue();
                            normalOrderTotal = normalOrderTotal+normalOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("DSOrder")==null?"":String.valueOf(items.get("DSOrder")));//电商订奶
                        if(items.get("DSOrder")!=null){
                            int DSOrder =  new BigDecimal(String.valueOf( items.get("DSOrder"))).intValue();
                            DSOrderTotal = DSOrderTotal+DSOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("NNQBOrder")==null?"":String.valueOf(items.get("NNQBOrder")));//牛奶钱包
                        if(items.get("NNQBOrder")!=null){
                            int NNQBOrder =  new BigDecimal(String.valueOf( items.get("NNQBOrder"))).intValue();
                            NNQBOrderTotal = NNQBOrderTotal+NNQBOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("yearOrder")==null?"":String.valueOf(items.get("yearOrder")));//年卡订奶
                        if(items.get("yearOrder")!=null){
                            int yearOrder =  new BigDecimal(String.valueOf( items.get("yearOrder"))).intValue();
                            yearOrderTotal = yearOrderTotal+yearOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("orgOrder")==null?"":String.valueOf(items.get("orgOrder")));//机构订奶
                        if(items.get("orgOrder")!=null){
                            int orgOrder =  new BigDecimal(String.valueOf( items.get("orgOrder"))).intValue();
                            orgOrderTotal = orgOrderTotal+orgOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("giveOrder")==null?"":String.valueOf(items.get("giveOrder")));//赠品数量
                        if(items.get("giveOrder")!=null){
                            int giveOrder =  new BigDecimal(String.valueOf( items.get("giveOrder"))).intValue();
                            giveOrderTotal = giveOrderTotal+giveOrder;
                        }
                        cell = row.createCell(raw++);
                        cell.setCellStyle(styleBold);
                        cell.setCellValue(items.get("totalQty")==null?"":String.valueOf(items.get("totalQty")));//总数
                        if(items.get("totalQty")!=null){
                            int totalQty =  new BigDecimal(String.valueOf( items.get("totalQty"))).intValue();
                            totalQtyTotal = totalQtyTotal+totalQty;
                        }
                        rowNum++;
                        totalNum = rowNum;
                    }
                    XSSFRow row = sheet.createRow(totalNum);
                    XSSFCell cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("小计");//奶站编码
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");//奶站名称
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");//产品简称
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue("");//单位
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(normalOrderTotal);//饮户订奶
                    allnormalOrderTotal = allnormalOrderTotal+normalOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(DSOrderTotal);//电商订奶
                    allDSOrderTotal = allDSOrderTotal+DSOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(NNQBOrderTotal);//牛奶钱包
                    allNNQBOrderTotal = allNNQBOrderTotal+NNQBOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(yearOrderTotal);//年卡订奶
                    allyearOrderTotal = allyearOrderTotal+yearOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(orgOrderTotal);//机构订奶
                    allorgOrderTotal = allorgOrderTotal+orgOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(giveOrderTotal);//赠品数量
                    allgiveOrderTotal = allgiveOrderTotal+giveOrderTotal;
                    cell = row.createCell(totalRaw++);
                    cell.setCellStyle(styleBold);
                    cell.setCellValue(totalQtyTotal);//总数
                    alltotalQtyTotal = alltotalQtyTotal+totalQtyTotal;
                    totalNum++;

                }
                XSSFRow row = sheet.createRow(totalNum);
                XSSFCell cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue("合计");//奶站编码
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue("");//奶站名称
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue("");//产品简称
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue("");//单位
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allnormalOrderTotal);//饮户订奶
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allDSOrderTotal);//电商订奶
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allNNQBOrderTotal);//牛奶钱包
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allyearOrderTotal);//年卡订奶
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allorgOrderTotal);//机构订奶
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(allgiveOrderTotal);//赠品数量
                cell = row.createCell(allRaw++);
                cell.setCellStyle(styleBold);
                cell.setCellValue(alltotalQtyTotal);//总数
                String fname = CodeGeneratorUtil.getCode();
                String rq = format1.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
                String filePath = url +  File.separator + "report"+ File.separator + "export";
                File delFiles = new File(filePath);
                if(delFiles.isDirectory()){
                    for(File del : delFiles.listFiles()){
                        if(del.getName().contains(rq)){
                            del.delete();
                        }
                    }
                }
                File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + fname + "basis.xlsx");
                FileOutputStream stream = new FileOutputStream(export);
                workbook.write(stream);
                stream.flush();
                stream.close();
                outUrl = fname + "basis.xlsx";
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        return convertToRespModel(MessageCode.NORMAL,null,outUrl);
    }
}
