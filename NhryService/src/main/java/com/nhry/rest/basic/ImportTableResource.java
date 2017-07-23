package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.basic.domain.*;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.data.orderorg.domain.TMdOrderOrg;
import com.nhry.model.basic.YearcardPriceQueryModel;
import com.nhry.model.bill.CustomerPayMentModel;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.*;
import com.nhry.service.basic.pojo.BranchScopeModel;
import com.nhry.service.bill.dao.CustomerBillService;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.order.dao.PromotionService;
import com.nhry.utils.ExcelUtil;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huaguan on 2016/8/30.
 */
@Path("/importTable")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/importTable", description = "导入历史数据")
public class ImportTableResource extends BaseResource {

    @Autowired
    private ResidentialAreaService residentialAreaService;
    @Autowired
    private TVipCustInfoService tVipCustInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private CustomerBillService customerBillService;
    @Autowired
    private OrderOrgService orderOrgService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private TMdOrgPriceService tMdOrgPriceService;
    @Autowired
    private YearcardPriceService yearcardPriceService;
    @Autowired
    private DictionaryService dictionaryService;
    
    @POST
    @Path("/importResidentialArea")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importResidentialArea", response = ResponseModel.class, notes = "导入小区主数据")
    public Response importResidentialArea(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！", "");
        }
        List<TMdResidentialArea> areas = new ArrayList<TMdResidentialArea>();//配送区域
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                TMdResidentialArea area = new TMdResidentialArea();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(j++);
                //start 导入小区信息
                area.setId(ExcelUtil.getCellValue(cell, row));//主键编号
                cell = row.getCell(j++);
                area.setResidentialAreaTxt(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                area.setProvince(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                area.setCity(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                area.setCounty(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                area.setAddressTxt(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                area.setSalesOrg(ExcelUtil.getCellValue(cell, row));
                areas.add(area);
            }
        } catch (RuntimeException e) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        return convertToRespModel(MessageCode.NORMAL, "保存成功！", residentialAreaService.addResidentialAreas(areas));
    }

    @POST
    @Path("/importVipcustInfo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importVipcustInfo", response = ResponseModel.class, notes = "导入订户主数据")
    public Response importVipcustInfo(FormDataMultiPart form, @Context HttpServletRequest request) {
        List<TVipCustInfo> vipcusts = new ArrayList<TVipCustInfo>();//订户
        try {
            FormDataBodyPart filePart = form.getField("file");
            InputStream fileInputStream = filePart.getValueAs(InputStream.class);
            FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
            String source = formDataContentDisposition.getFileName();
            if (!source.endsWith("xlsx")) {
                return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！", "");
            }
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                TVipCustInfo vipcust = new TVipCustInfo();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(j++);

                //订户姓名
                vipcust.setVipName(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //订户地址
                vipcust.setAddressTxt(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //小区编号
                vipcust.setSubdist(ExcelUtil.getCellValue(cell, row));
                //需要通过小区编号查询出小区信息并写入到订户地址中
                TMdResidentialArea area = residentialAreaService.selectById(vipcust.getSubdist());
                if (area == null) {
                    return convertToRespModel(MessageCode.LOGIC_ERROR, "第" + (row.getRowNum() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列：小区编号" + vipcust.getSubdist() + "的小区信息不存在！请从导入模板中删除该订户，并重新校验同类问题", "");
                }
                vipcust.setProvince(area.getProvince());
                vipcust.setCity(area.getCity());
                vipcust.setCounty(area.getCounty());
                cell = row.getCell(j++);
                //手机号
                //订户编号
                String vipCustNo = ExcelUtil.getCellValue(cell, row);
                vipcust.setMp(ExcelUtil.getCellValue(cell, row));

                cell = row.getCell(j++);
                //性别
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    vipcust.setSex(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //订户来源
                vipcust.setVipSrc(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //订户类型
                vipcust.setVipType(ExcelUtil.getCellValue(cell, row));

                //订户状态
                vipcust.setStatus("10");
                cell = row.getCell(j++);
                //备注
                if(cell != null && StringUtils.isNotEmpty(cell.toString())){
                    vipcust.setMemoTxt(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //销售组织
                vipcust.setSalesOrg(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //经销商编号
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    vipcust.setDealerNo(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //奶站编号
                String branchNo = ExcelUtil.getCellValue(cell, row);
                vipcust.setBranchNo(branchNo);
                vipcust.setVipCustNo(branchNo.substring(branchNo.length()-6).concat(vipCustNo));
                vipcusts.add(vipcust);
            }

            //校验手机号是否重复
            for (int k = 0; k < vipcusts.size() - 1; k++) {
                TVipCustInfo tmp1 = vipcusts.get(k);
                for (int l = vipcusts.size() - 1; l > k; l--) {
                    TVipCustInfo tmp2 = vipcusts.get(l);
                    if (tmp1.getVipCustNo().equals(tmp2.getVipCustNo())) {
                        return convertToRespModel(MessageCode.NORMAL, "模板中" + tmp1.getVipCustNo() + "的订户号重复，请重新校验数据！", "");
                    }
                    if (tmp1.getMp().equals(tmp2.getMp())) {
                        return convertToRespModel(MessageCode.NORMAL, "模板中" + tmp1.getMp() + "的手机号重复，请重新校验数据！", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        return convertToRespModel(MessageCode.NORMAL, "保存成功！", tVipCustInfoService.addVipCusts(vipcusts));
    }

    @POST
    @Path("/importPreorder")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importPreorder", response = ResponseModel.class, notes = "导入订单、行项目数据")
    public Response importPreorder(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        List<OrderCreateModel> OrderModels = new ArrayList<OrderCreateModel>();//订单
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！,文件后缀名应为xlsx的EXCEL模版文件", "");
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);//模版上sheet1页面
            XSSFSheet sheet1 = workbook.getSheetAt(1);//模版上sheet2页面
            int rowNum = sheet.getLastRowNum();
            int rowNum1 = sheet1.getLastRowNum();

            //循环sheet1获取页面值
            for (int i = 1; i <= rowNum; i++) {
                OrderCreateModel OrderModel = new OrderCreateModel();
                TPreOrder order = new TPreOrder();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                XSSFCell cell = row.getCell(j++);
                //订单编号
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                    order.setOrderNo(cell.toString());
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号为空，请检查！");
                }
                cell = row.getCell(j++);
                //奶站编号
                String branchNo = cell.toString();
                order.setBranchNo(cell.toString());
                TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
                if (branch == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列奶站编码为" + cell.toString() + "奶站不存在！请重新校验数据！");
                }
                String salesOrg = branch.getSalesOrg();
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //配送方式
                order.setDeliveryType(ExcelUtil.getCellValue(cell, row));

                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //付费方式
                order.setPaymentmethod(ExcelUtil.getCellValue(cell, row));

                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //订户编码规则是
                String vipCustNo = ExcelUtil.getCellValue(cell, row);
                String vipCust = branchNo.substring(branchNo.length()-6).concat(vipCustNo);
                //订户编号
                order.setMilkmemberNo(vipCust);
                //根据订户编号，查询订户会员编号，如果有，则赋值给订单对应的会员字段
                TVipCustInfo vci = tVipCustInfoService.findVipCustByNoForUpt(vipCust);
                if(vci!=null){
                    order.setMemberNo(vci.getVipCustNoSap());
                }
                //通过订户查询到地址信息，并写入到订单里
                TMdAddress tMdAddress = tVipCustInfoService.findAddressByCustNoISDefault(vipCust);
                if (tMdAddress == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + cell.toString() + "的订户编码没有对应的地址信息，请校验数据是否正确！");
                }
                order.setAdressNo(tMdAddress.getAddressId());
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //付款方式
                order.setPaymentStat(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //装箱状态
                order.setMilkboxStat(ExcelUtil.getCellValue(cell, row));

                cell = row.getCell(j++);
                //送奶员
                order.setEmpNo(ExcelUtil.getCellValue(cell, row));

                order.setPreorderStat("10");
                cell = row.getCell(j++);
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    order.setMemoTxt(cell.toString());
                }
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //收款类型
                order.setPayMethod(ExcelUtil.getCellValue(cell, row));
                //在订
                order.setSign("10");
                order.setOrderType("20");
                order.setPreorderSource("30");
                OrderModel.setOrder(order);

                ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();//订单行项目
                for (int s = 1; s <= rowNum1; s++) {
                    TPlanOrderItem entrie = new TPlanOrderItem();
                    int t = 0;
                    XSSFRow row1 = sheet1.getRow(s);
                    XSSFCell cell1 = row1.getCell(t++);
                    //判断订单号码是否一致，如果一致放到一个事物里
                    if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                        if (cell1.toString().equals(order.getOrderNo())) {
                            entrie.setOrderNo(cell1.toString());
                            cell1 = row1.getCell(t++);
                            
                            //补足到18位
                    		String matnr = ExcelUtil.getCellValue(cell1, row1);
                    		while (matnr.length() < 18)matnr = "0".concat(matnr);
                    		
                            entrie.setMatnr(matnr);
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setRuleType(ExcelUtil.getCellValue(cell1, row));
                            cell1 = row1.getCell(t++);
                            entrie.setQty(Integer.valueOf(cell1.toString()));
                            //算出配送天数
                            // entrie.setDispDays();
                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
                                if (entrie.getRuleType().equals("10")) {
                                    entrie.setGapDays(Integer.valueOf(ExcelUtil.getCellValue(cell1, row1)));
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，间隔天数不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("10")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为周期配送，间隔天数不能为空！");
                                }
                            }

                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                                if (entrie.getRuleType().equals("20")) {
                                    entrie.setRuleTxt(cell1.toString());
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，配送规则不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("20")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为星期配送，配送规则不能为空！");
                                }
                            }
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setReachTimeType(ExcelUtil.getCellValue(cell1, row1));
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setStartDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setStartDispDateStr(cell1.toString());
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setEndDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setEndDispDateStr(cell1.toString());
                            if (entrie.getEndDispDate().before(entrie.getStartDispDate())) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,结束时间大于开始时间，请校验");
                            }


                            float price = priceService.getMaraPriceForCreateOrder(order.getBranchNo(), entrie.getMatnr(), order.getDeliveryType(), salesOrg);
                            if (price <= 0)
                                throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                            entrie.setSalesPrice(new BigDecimal(String.valueOf(price)));
                            entries.add(entrie);
                        }
                    }
                }
                OrderModel.setEntries(entries);
                OrderModels.add(OrderModel);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        if(OrderModels.size()>0) {
            for (OrderCreateModel orderModel : OrderModels) {
                TPreOrder order = orderModel.getOrder();
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getPaymentStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择付款方式!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkboxStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择装箱状态!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getEmpNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择送奶员!");
                    }
                }
                if (orderModel.getEntries() == null || orderModel.getEntries().size() == 0) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择商品行!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkmemberNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {//电商不交验订户
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择订户!");
                    }
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getAdressNo())) {
                    if (orderModel.getAddress() == null) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择或输入地址!");
                    }
                }
                for (TPlanOrderItem e : orderModel.getEntries()) {
                    if (org.apache.commons.lang3.StringUtils.isBlank(e.getRuleType())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "商品行必须要有配送规律!");
                    }
                }
            }

            orderService.createOrders(OrderModels);
            for (int om = 0; om < OrderModels.size(); om++) {
                OrderCreateModel ocm = OrderModels.get(om);
                if ("20".equals(ocm.getOrder().getPaymentmethod())
                        && "20".equals(ocm.getOrder().getPaymentStat())
                        &&!"10".equals(ocm.getOrder().getMilkboxStat())) {
                    customerBillService.createRecBillByOrderNo(ocm.getOrder().getOrderNo());
                    CustomerPayMentModel cModel = new CustomerPayMentModel();
                    cModel.setOrderNo(ocm.getOrder().getOrderNo());
                    cModel.setAmt(ocm.getOrder().getCurAmt().toString());
                    cModel.setPaymentType(ocm.getOrder().getPayMethod());
                    cModel.setEmpNo(ocm.getOrder().getEmpNo());
                    customerBillService.customerPayment(cModel);
                }
            }
        }
        return convertToRespModel(MessageCode.NORMAL, "上传成功！", null);
    }
    
    @POST
    @Path("/importEccPreorder")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importEccPreorder", response = ResponseModel.class, notes = "导入订单、行项目数据")
    public Response importEccPreorder(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        List<OrderCreateModel> OrderModels = new ArrayList<OrderCreateModel>();//订单
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！,文件后缀名应为xlsx的EXCEL模版文件", "");
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);//模版上sheet1页面
            //XSSFSheet sheet1 = workbook.getSheetAt(1);//模版上sheet2页面
            int rowNum = sheet.getLastRowNum();
            //int rowNum1 = sheet1.getLastRowNum();

            //循环sheet1获取页面值
            for (int i = 1; i <= rowNum; i++) {
                OrderCreateModel OrderModel = new OrderCreateModel();
                TPreOrder order = new TPreOrder();
                TMdAddress address = new TMdAddress(); 
                OrderModel.setAddress(address);
                int j = 2;
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                
                //订单编号
                XSSFCell cell = row.getCell(j++);
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                    order.setOrderNo(cell.toString());
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号为空，请检查！");
                }
                
                //订单创建日期
                cell = row.getCell(j++);
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                	try {
						order.setOrderDate(format2.parse(cell.toString()));
					} catch (ParseException e) {
						throw new ServiceException("第" + (row.getRowNum() + 1) + "创建日期格式有问题，请检查！");
					}
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,创建日期为空，请检查！");
                }
                
                //装箱状态
                j++;
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setMilkboxStat(ExcelUtil.getCellValue(cell, row));
                
                //都是先付款,已付款
                order.setPaymentmethod("20");
                order.setPaymentStat("20");
                
                //付款标志
                j++;j++;
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setIsPaid("Y");
                
                //付款日期
                cell = row.getCell(j++);
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                	try {
						order.setPayDate( format2.parse( cell.toString()));
						order.setPayDateStr( format.format(format2.parse( cell.toString()) ) );
					} catch (ParseException e) {
						throw new ServiceException("第" + (row.getRowNum() + 1) + "付款日期格式有问题，请检查！");
					}
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,付款日期为空，请检查！");
                }
                
                //顾客,地址信息
                j++;j++;j++;j++;
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                OrderModel.getAddress().setRecvName(ExcelUtil.getCellValue(cell, row));
                
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                OrderModel.getAddress().setMp(ExcelUtil.getCellValue(cell, row));
                
                j++;//电话没有
                
                NHSysCodeItem codeitem = new NHSysCodeItem();
                codeitem.setTypeCode("1001");
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                codeitem.setItemName(ExcelUtil.getCellValue(cell, row));
                OrderModel.getAddress().setProvince(dictionaryService.findItemsByItemNameAndLevel(codeitem).getItemCode());
                
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                codeitem.setItemName(ExcelUtil.getCellValue(cell, row));
                OrderModel.getAddress().setCity(dictionaryService.findItemsByItemNameAndLevel(codeitem).getItemCode());
                
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                codeitem.setItemName(ExcelUtil.getCellValue(cell, row));
                OrderModel.getAddress().setCounty(dictionaryService.findItemsByItemNameAndLevel(codeitem).getItemCode());
                
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                OrderModel.getAddress().setAddressTxt(ExcelUtil.getCellValue(cell, row));
                
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                OrderModel.getAddress().setResidentialArea(ExcelUtil.getCellValue(cell, row));
                
                //备注
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setMemoTxt(ExcelUtil.getCellValue(cell, row));
                
                //配送方式,配送
                order.setDeliveryType("20");
                
//                奶站编号
//                String branchNo = cell.toString();
//                order.setBranchNo(cell.toString());
//                TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
//                if (branch == null) {
//                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列奶站编码为" + cell.toString() + "奶站不存在！请重新校验数据！");
//                }
//                String salesOrg = branch.getSalesOrg();
                
//                cell = row.getCell(j++);
//                ExcelUtil.isNullCell(cell, row, j);
//                //订户编码规则是
//                String vipCustNo = ExcelUtil.getCellValue(cell, row);
//                String vipCust = branchNo.substring(branchNo.length()-6).concat(vipCustNo);
//                //订户编号
//                order.setMilkmemberNo(vipCust);
//                //根据订户编号，查询订户会员编号，如果有，则赋值给订单对应的会员字段
//                TVipCustInfo vci = tVipCustInfoService.findVipCustByNoForUpt(vipCust);
//                if(vci!=null){
//                    order.setMemberNo(vci.getVipCustNoSap());
//                }
//                //通过订户查询到地址信息，并写入到订单里
//                TMdAddress tMdAddress = tVipCustInfoService.findAddressByCustNoISDefault(vipCust);
//                if (tMdAddress == null) {
//                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + cell.toString() + "的订户编码没有对应的地址信息，请校验数据是否正确！");
//                }
//                order.setAdressNo(tMdAddress.getAddressId());
//                cell = row.getCell(j++);
//                ExcelUtil.isNullCell(cell, row, j);
//                
//                //付款方式
//                order.setPaymentStat(ExcelUtil.getCellValue(cell, row));
//
//                cell = row.getCell(j++);
//                //送奶员
//                order.setEmpNo(ExcelUtil.getCellValue(cell, row));
//
//                order.setPreorderStat("10");
//                cell = row.getCell(j++);
//                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
//                    order.setMemoTxt(cell.toString());
//                }
                
                //在订
                order.setPayMethod("10");//收款类型
                order.setSign("10");
                order.setOrderType("10");//线上
                order.setPreorderSource("20");//电商
                order.setPreorderStat("20");//电商
                OrderModel.setOrder(order);

//////////////////////////////////////////////////订单行项目/////////////////////////////////////////////////////
                ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();
//                for (int s = 1; s <= rowNum1; s++) {
                    TPlanOrderItem entrie = new TPlanOrderItem();
                    XSSFCell cell1 = cell;
                    XSSFRow row1 = row;
                    int t = j;
                      //判断订单号码是否一致，如果一致放到一个事物里
//                    if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
//                        if (cell1.toString().equals(order.getOrderNo())) {
                            
                            //产品编码
                            cell1 = row1.getCell(t++);
                            String matnr = ExcelUtil.getCellValue(cell1, row1);
                    		while (matnr.length() < 18)matnr = "0".concat(matnr);
                            entrie.setMatnr(matnr);
                            
                            //总数
                            cell1 = row1.getCell(t++);
                            entrie.setDispTotal(Double.valueOf(cell1.toString()).intValue());
                            
                            //总金额
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setItemamount(new BigDecimal(ExcelUtil.getCellValue(cell1, row)));
                            order.setInitAmt(entrie.getItemamount());
                            
                            //配送规律,每天送
                            entrie.setGapDays(0);
                            entrie.setRuleType("10");
                            
                            //每天个数
                            t++;
                            cell1 = row1.getCell(t++);
                            entrie.setQty(Double.valueOf(cell1.toString()).intValue());
                            
                            //开始时间
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            if(cell1!=null && StringUtils.isNotEmpty(cell.toString())){
                            	try {
									entrie.setStartDispDate( format2.parse( cell1.toString()));
								} catch (ParseException e) {
									throw new ServiceException("第" + (row.getRowNum() + 1) + "配送开始日期格式有问题，请检查！");
								}
                            }else{
                                throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送开始日期为空，请检查！");
                            }
                            
                            //送达时段
                            t++;
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setReachTimeType(ExcelUtil.getCellValue(cell1, row));
                            
                            //销售组织
                            t++;t++;
                            cell1 = row1.getCell(t++);
                            if( cell1 == null || StringUtils.isEmpty(cell1.toString())){
                            	throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,销售组织为空，请检查！");
                            }
                            ExcelUtil.isNullCell(cell1, row, t);
                            order.setSalesOrg(ExcelUtil.getCellValue(cell1, row));
                            
                            //奶站号
                            cell1 = row1.getCell(t++);
                            if( cell1 != null && StringUtils.isNotEmpty(cell1.toString())){
                            	order.setBranchNo(ExcelUtil.getCellValue(cell1, row));
                            }
                            
//                            cell1 = row1.getCell(t++);
//                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
//                                if (entrie.getRuleType().equals("10")) {
//                                    entrie.setGapDays(Integer.valueOf(ExcelUtil.getCellValue(cell1, row1)));
//                                } else {
//                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，间隔天数不需要填写！");
//                                }
//                            } else {
//                                if (entrie.getRuleType().equals("10")) {
//                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为周期配送，间隔天数不能为空！");
//                                }
//                            }
//
//                            cell1 = row1.getCell(t++);
//                            if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
//                                if (entrie.getRuleType().equals("20")) {
//                                    entrie.setRuleTxt(cell1.toString());
//                                } else {
//                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，配送规则不需要填写！");
//                                }
//                            } else {
//                                if (entrie.getRuleType().equals("20")) {
//                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为星期配送，配送规则不能为空！");
//                                }
//                            }
//                            cell1 = row1.getCell(t++);
//                            ExcelUtil.isNullCell(cell1, row, t);
//                            entrie.setReachTimeType(ExcelUtil.getCellValue(cell1, row1));
//                            cell1 = row1.getCell(t++);
//                            try {
//                                format.parse(cell1.toString());
//                                entrie.setStartDispDate(format.parse(cell1.toString()));
//                            } catch (Exception e) {
//                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
//                            }
//                            entrie.setStartDispDateStr(cell1.toString());
//                            cell1 = row1.getCell(t++);
//                            try {
//                                format.parse(cell1.toString());
//                                entrie.setEndDispDate(format.parse(cell1.toString()));
//                            } catch (Exception e) {
//                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
//                            }
//                            entrie.setEndDispDateStr(cell1.toString());
//                            if (entrie.getEndDispDate().before(entrie.getStartDispDate())) {
//                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,结束时间大于开始时间，请校验");
//                            }
//
//
//                            float price = priceService.getMaraPriceForCreateOrder(order.getBranchNo(), entrie.getMatnr(), order.getDeliveryType(), salesOrg);
//                            if (price <= 0)
//                                throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
//                            entrie.setSalesPrice(new BigDecimal(String.valueOf(price)));
//                            entries.add(entrie);
//                        }
//                    }
//                }
                OrderModel.setEntries(entries);
                OrderModels.add(OrderModel);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        if(OrderModels.size()>0) {
            for (OrderCreateModel orderModel : OrderModels) {
                TPreOrder order = orderModel.getOrder();
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getPaymentStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择付款方式!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkboxStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择装箱状态!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getEmpNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择送奶员!");
                    }
                }
                if (orderModel.getEntries() == null || orderModel.getEntries().size() == 0) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择商品行!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkmemberNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {//电商不交验订户
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择订户!");
                    }
                }
//                if (org.apache.commons.lang3.StringUtils.isBlank(order.getAdressNo())) {
//                    if (orderModel.getAddress() == null) {
//                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择或输入地址!");
//                    }
//                }
                for (TPlanOrderItem e : orderModel.getEntries()) {
                    if (org.apache.commons.lang3.StringUtils.isBlank(e.getRuleType())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "商品行必须要有配送规律!");
                    }
                }
            }

            orderService.createOrders(OrderModels);
//            for (int om = 0; om < OrderModels.size(); om++) {
//                OrderCreateModel ocm = OrderModels.get(om);
//                if ("20".equals(ocm.getOrder().getPaymentmethod())
//                        && "20".equals(ocm.getOrder().getPaymentStat())
//                        &&!"10".equals(ocm.getOrder().getMilkboxStat())) {
//                    customerBillService.createRecBillByOrderNo(ocm.getOrder().getOrderNo());
//                    CustomerPayMentModel cModel = new CustomerPayMentModel();
//                    cModel.setOrderNo(ocm.getOrder().getOrderNo());
//                    cModel.setAmt(ocm.getOrder().getCurAmt().toString());
//                    cModel.setPaymentType(ocm.getOrder().getPayMethod());
//                    cModel.setEmpNo(ocm.getOrder().getEmpNo());
//                    customerBillService.customerPayment(cModel);
//                }
//            }
        }
        return convertToRespModel(MessageCode.NORMAL, "上传成功！", null);
    }

    @POST
    @Path("/importLinks")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importLinks", response = ResponseModel.class, notes = "导入奶站关联小区信息")
    public Response importLinks(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        BranchScopeModel model = new BranchScopeModel();
        model.setBranchNo(sheet.getRow(0).getCell(0).toString());
        List<String> areaids = new ArrayList<String>();
        for (int i = 1; i <= rowNum; i++) {
            int j = 1;
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(j++);
            //start 导入小区信息
            areaids.add(cell.toString());//小区编号
        }
        model.setResidentialAreaIds(areaids);
        return convertToRespModel(MessageCode.NORMAL, null, residentialAreaService.areaRelBranch(model));
    }

    private BigDecimal getCellValue(XSSFCell cell) {
        BigDecimal value = new BigDecimal(0);
        if (null != cell) {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_NUMERIC: // 数字
                    value = new BigDecimal(cell.getNumericCellValue());
                    break;
                case XSSFCell.CELL_TYPE_STRING: // 字符串
                    value = new BigDecimal(cell.getStringCellValue());
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    break;
                case XSSFCell.CELL_TYPE_FORMULA: // 公式
                    break;
                case XSSFCell.CELL_TYPE_BLANK: // 空值
                    break;
                case XSSFCell.CELL_TYPE_ERROR: // 故障
                    break;
                default:
                    break;
            }
        }
        return value;
    }

    @POST
    @Path("/importOrgVipcustInfo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importOrgVipcustInfo", response = ResponseModel.class, notes = "导入机构订户主数据")
    public Response importOrgVipcustInfo(FormDataMultiPart form, @Context HttpServletRequest request) {
        List<TVipCustInfo> vipcusts = new ArrayList<TVipCustInfo>();//订户
        try {
            FormDataBodyPart filePart = form.getField("file");
            InputStream fileInputStream = filePart.getValueAs(InputStream.class);
            FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
            String source = formDataContentDisposition.getFileName();
            if (!source.endsWith("xlsx")) {
                return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！", "");
            }
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 1; i <= rowNum; i++) {
                TVipCustInfo vipcust = new TVipCustInfo();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(j++);

                //订户姓名
                vipcust.setVipName(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //地址
                vipcust.setAddressTxt(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //小区编号
                vipcust.setSubdist(ExcelUtil.getCellValue(cell, row));
                //需要通过小区编号查询出小区信息并写入到订户地址中
                TMdResidentialArea area = residentialAreaService.selectById(vipcust.getSubdist());
                if (area == null) {
                    return convertToRespModel(MessageCode.LOGIC_ERROR, "第" + (row.getRowNum() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列：小区编号" + vipcust.getSubdist() + "的小区信息不存在！请从导入模板中删除该订户，并重新校验同类问题", "");
                }
                vipcust.setProvince(area.getProvince());
                vipcust.setCity(area.getCity());
                vipcust.setCounty(area.getCounty());
                cell = row.getCell(j++);
                //订户手机号
                String vipCustNo = ExcelUtil.getCellValue(cell, row);
                vipcust.setMp(ExcelUtil.getCellValue(cell, row));

                cell = row.getCell(j++);
                //性别
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    vipcust.setSex(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //订户来源
                vipcust.setVipSrc(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //订户类型
                vipcust.setVipType(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //订户状态
                vipcust.setStatus(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //备注
                if(cell != null && StringUtils.isNotEmpty(cell.toString())){
                    vipcust.setMemoTxt(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //销售组织
                vipcust.setSalesOrg(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //经销商编号
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    vipcust.setDealerNo(ExcelUtil.getCellValue(cell, row));
                }
                cell = row.getCell(j++);
                //奶站编号
                String branchNo = ExcelUtil.getCellValue(cell, row);
                cell = row.getCell(j++);
                //机构编号
                if(cell !=null && StringUtils.isNotEmpty(cell.toString())){
                    String orgCode = ExcelUtil.getCellValue(cell, row);
                    TMdOrderOrg orderOrg = orderOrgService.findTMdOrderOrgByOrgCode(orgCode);
                    if(orderOrg!=null){
                        vipcust.setOrgId(orderOrg.getId());
                    }else{
                        return convertToRespModel(MessageCode.LOGIC_ERROR, "第" + (row.getRowNum() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列：机构编号不存在，请检查", "");
                    }
                }else{
                    return convertToRespModel(MessageCode.LOGIC_ERROR, "第" + (row.getRowNum() + 1) + "行，第" + (cell.getColumnIndex() + 1) + "列：机构编号不能为空，并重新校验同类问题", "");
                }
                vipcust.setBranchNo(branchNo);
                vipcust.setVipCustNo(branchNo.substring(branchNo.length()-6).concat(vipCustNo));
                vipcusts.add(vipcust);
            }

            //校验手机号是否重复
            for (int k = 0; k < vipcusts.size() - 1; k++) {
                TVipCustInfo tmp1 = vipcusts.get(k);
                for (int l = vipcusts.size() - 1; l > k; l--) {
                    TVipCustInfo tmp2 = vipcusts.get(l);
                    if (tmp1.getVipCustNo().equals(tmp2.getVipCustNo())) {
                        return convertToRespModel(MessageCode.NORMAL, "模板中" + tmp1.getVipCustNo() + "的订户号重复，请重新校验数据！", "");
                    }
                    if (tmp1.getMp().equals(tmp2.getMp())) {
                        return convertToRespModel(MessageCode.NORMAL, "模板中" + tmp1.getMp() + "的手机号重复，请重新校验数据！", "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        return convertToRespModel(MessageCode.NORMAL, "上传成功！", tVipCustInfoService.addVipCusts(vipcusts));
    }

    @POST
    @Path("/importOrgPreorder")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importOrgPreorder", response = ResponseModel.class, notes = "导入订单、行项目数据")
    public Response importOrgPreorder(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        List<OrderCreateModel> OrderModels = new ArrayList<OrderCreateModel>();//订单
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！,文件后缀名应为xlsx的EXCEL模版文件", "");
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);//模版上sheet1页面
            XSSFSheet sheet1 = workbook.getSheetAt(1);//模版上sheet2页面
            int rowNum = sheet.getLastRowNum();
            int rowNum1 = sheet1.getLastRowNum();

            //循环sheet1获取页面值
            for (int i = 1; i <= rowNum; i++) {
                OrderCreateModel OrderModel = new OrderCreateModel();
                TPreOrder order = new TPreOrder();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                XSSFCell cell = row.getCell(j++);
                //订单编号-1
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                    order.setOrderNo(cell.toString());
                    TPreOrder tellOrder = orderService.selectByPrimaryKey(order.getOrderNo());
                    if(tellOrder!=null){
                        throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号"+order.getOrderNo()+"在系统中已存在，请检查！");
                    }
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号为空，请检查！");
                }
                cell = row.getCell(j++);
                //奶站编号-2
                String branchNo = cell.toString();
                order.setBranchNo(cell.toString());
                TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
                if (branch == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列奶站编码为" + cell.toString() + "奶站不存在！请重新校验数据！");
                }
                String salesOrg = branch.getSalesOrg();
                cell = row.getCell(j++);
                //配送方式-3
                ExcelUtil.isNullCell(cell, row, j);
                order.setDeliveryType(ExcelUtil.getCellValue(cell, row));
               /* try {
                    cell = row.getCell(j++);
                    order.setOrderDate(format.parse(cell.toString()));
                    cell = row.getCell(j++);
                    order.setEndDate(format.parse(cell.toString()));
                } catch (Exception e) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + cell.toString() + "日期格式有误,正确日期格式：2016-09-09 ！");
                }
                if(order.getEndDate().before(order.getOrderDate())){
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列，订单结束时间小于订单开始时间，请检查");
                }*/

                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //订户编码规则是
                String vipCustNo = ExcelUtil.getCellValue(cell, row);
                String vipCust = branchNo.substring(branchNo.length()-6).concat(vipCustNo);
                order.setMilkmemberNo(vipCust);
                //根据订户编号，查询订户会员编号，如果有，则赋值给订单对应的会员字段
                TVipCustInfo vci = tVipCustInfoService.findVipCustByNoForUpt(vipCust);
                if(vci!=null){
                    order.setMemberNo(vci.getVipCustNoSap());
                }
                //通过订户查询到地址信息，并写入到订单里
                TMdAddress tMdAddress = tVipCustInfoService.findAddressByCustNoISDefault(vipCust);
                if (tMdAddress == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + cell.toString() + "的订户编码没有对应的地址信息，请校验数据是否正确！");
                }
                order.setAdressNo(tMdAddress.getAddressId());
                //付费方式
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setPaymentmethod(ExcelUtil.getCellValue(cell, row));
                //装箱状态
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setMilkboxStat(ExcelUtil.getCellValue(cell, row));
                //机构编号
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setOnlineSourceType(ExcelUtil.getCellValue(cell, row));
                //付款状态为已付款
                order.setPaymentStat("20");
                //暂停订单
                order.setPreorderStat("20");
                cell = row.getCell(j++);
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    order.setMemoTxt(cell.toString());
                }
                cell = row.getCell(j++);
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    try {
                        order.setOrderDate(format.parse(cell.toString()));
                    }catch ( Exception e ){
                        e.printStackTrace();
                    }

                }
                //在订
                order.setSign("10");
                //暂停
                order.setOrderType("20");
                //机构
                order.setPreorderSource("70");

                OrderModel.setOrder(order);

                ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();//订单行项目
                for (int s = 1; s <= rowNum1; s++) {
                    TPlanOrderItem entrie = new TPlanOrderItem();
                    int t = 0;
                    XSSFRow row1 = sheet1.getRow(s);
                    XSSFCell cell1 = row1.getCell(t++);
                    //判断订单号码是否一致，如果一致放到一个事物里
                    if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                        if (cell1.toString().equals(order.getOrderNo())) {
                            //订单编号
                            entrie.setOrderNo(cell1.toString());
                            //订购的产品编码
                            cell1 = row1.getCell(t++);
                            entrie.setMatnr("0000000000".concat(ExcelUtil.getCellValue(cell1, row1)));//补齐产品编码
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            //配送规律
                            entrie.setRuleType(ExcelUtil.getCellValue(cell1, row));
                            cell1 = row1.getCell(t++);
                            //每次配送数量
                            entrie.setQty(Integer.valueOf(cell1.toString()));
                            //算出配送天数
                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
                                if (entrie.getRuleType().equals("10")) {
                                    entrie.setGapDays(Integer.valueOf(ExcelUtil.getCellValue(cell1, row1)));
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，间隔天数不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("10")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为周期配送，间隔天数不能为空！");
                                }
                            }

                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                                if (entrie.getRuleType().equals("20")) {
                                    entrie.setRuleTxt(cell1.toString());
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，配送规则不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("20")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为星期配送，配送规则不能为空！");
                                }
                            }
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setReachTimeType(ExcelUtil.getCellValue(cell1, row1));
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setStartDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setStartDispDateStr(cell1.toString());
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setEndDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setEndDispDateStr(cell1.toString());
                            if (entrie.getEndDispDate().before(entrie.getStartDispDate())) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,结束时间大于开始时间，请校验");
                            }
                            cell1 = row1.getCell(t++);
                            if ("20".equals(order.getPaymentmethod()) && (cell1 == null || StringUtils.isEmpty(cell1.toString()))) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列，预付款项目必须填写配送数量！请重新校验同类问题！");
                            }
                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
                                entrie.setDispTotal(Integer.valueOf(cell1.getStringCellValue()));
                            }
                            float price = 0;
                            float priceDeliver = 0;
                            float priceNetValue = 0;
                            float priceHome = 0;
                            /**
                             * 如过订单日期不为空，取历史价格填入行项目
                             */
                            if(order.getOrderDate()!=null){
                                TMdOrgPrice opc = tMdOrgPriceService.selectOrgPriceByMatnrOldPrice(order.getOnlineSourceType(),order.getOrderDate(),entrie.getMatnr());
                                if(opc.getOldPrice()==null){
                                    throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    price = opc.getOldPrice().floatValue();
                                }
                                if(opc.getOldPriceDeliver()==null){
                                    throw new ServiceException("产品配送费小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    priceDeliver = opc.getOldPriceDeliver().floatValue();
                                }
                                if(opc.getOldPriceNetValue()==null){
                                    throw new ServiceException("产品净值价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    priceNetValue = opc.getOldPriceNetValue().floatValue();
                                }
                                if(opc.getOldPriceHome()!=null){
                                    priceHome = opc.getOldPriceHome().floatValue();
                                }
                            }
                            /*float price = priceService.getMaraPriceForCreateOrder(order.getBranchNo(), entrie.getMatnr(), order.getDeliveryType(), salesOrg);
                            if (price <= 0)
                                throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                            entrie.setSalesPrice(new BigDecimal(String.valueOf(price)));*/
                            entrie.setSalesPrice(new BigDecimal(String.valueOf(price)));
                            entrie.setPriceDeliver(new BigDecimal(String.valueOf(priceDeliver)));
                            entrie.setPriceNetValue(new BigDecimal(String.valueOf(priceNetValue)));
                            entrie.setPriceHome(new BigDecimal(String.valueOf(priceHome)));
                            entries.add(entrie);
                        }
                    }
                }
                OrderModel.setEntries(entries);
                OrderModels.add(OrderModel);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        if(OrderModels.size()>0) {
            for (OrderCreateModel orderModel : OrderModels) {
                TPreOrder order = orderModel.getOrder();
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getPaymentStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择付款方式!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkboxStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择奶箱状态!");
                }

                if (orderModel.getEntries() == null || orderModel.getEntries().size() == 0) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择商品行!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkmemberNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {//电商不交验订户
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择订户!");
                    }
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getAdressNo())) {
                    if (orderModel.getAddress() == null) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择或输入地址!");
                    }
                }
                for (TPlanOrderItem e : orderModel.getEntries()) {
                    if (org.apache.commons.lang3.StringUtils.isBlank(e.getRuleType())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "商品行必须要有配送规律!");
                    }
                }
            }

            orderService.createOrders(OrderModels);
           /* for (int om = 0; om < OrderModels.size(); om++) {
                OrderCreateModel ocm = OrderModels.get(om);
                if ("20".equals(ocm.getOrder().getPaymentmethod())) {
                    customerBillService.createRecBillByOrderNo(ocm.getOrder().getOrderNo());
                    CustomerPayMentModel cModel = new CustomerPayMentModel();
                    cModel.setOrderNo(ocm.getOrder().getOrderNo());
                    cModel.setAmt(ocm.getOrder().getCurAmt().toString());
                    cModel.setPaymentType(ocm.getOrder().getPayMethod());
                    cModel.setEmpNo(ocm.getOrder().getEmpNo());
                    customerBillService.customerPayment(cModel);
                }
            }*/
        }
        return convertToRespModel(MessageCode.NORMAL, "上传成功！", null);
    }
    @POST
    @Path("/importYearPreorder")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importYearPreorder", response = ResponseModel.class, notes = "导入年卡订单、行项目数据")
    public Response importYearPreorder(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        List<OrderCreateModel> OrderModels = new ArrayList<OrderCreateModel>();//订单
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        FormDataBodyPart filePart = form.getField("file");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误，请使用正规模板！,文件后缀名应为xlsx的EXCEL模版文件", "");
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
            XSSFSheet sheet = workbook.getSheetAt(0);//模版上sheet1页面
            XSSFSheet sheet1 = workbook.getSheetAt(1);//模版上sheet2页面
            int rowNum = sheet.getLastRowNum();
            int rowNum1 = sheet1.getLastRowNum();

            //循环sheet1获取页面值
            for (int i = 1; i <= rowNum; i++) {
                OrderCreateModel OrderModel = new OrderCreateModel();
                TPreOrder order = new TPreOrder();
                int j = 0;
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                XSSFCell cell = row.getCell(j++);
                //订单编号-1
                if(cell!=null && StringUtils.isNotEmpty(cell.toString())){
                    order.setOrderNo(cell.toString());
                    TPreOrder tellOrder = orderService.selectByPrimaryKey(order.getOrderNo());
                    if(tellOrder!=null){
                        throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号"+order.getOrderNo()+"在系统中已存在，请检查！");
                    }
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,订单编号为空，请检查！");
                }
                cell = row.getCell(j++);
                //奶站编号-2
                String branchNo = cell.toString();
                order.setBranchNo(cell.toString());
                TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
                if (branch == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列奶站编码为" + cell.toString() + "奶站不存在！请重新校验数据！");
                }
                String salesOrg = branch.getSalesOrg();
                cell = row.getCell(j++);
                //配送方式-3
                ExcelUtil.isNullCell(cell, row, j);
                order.setDeliveryType(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                //装箱状态-4
                ExcelUtil.isNullCell(cell, row, j);
                order.setMilkboxStat(ExcelUtil.getCellValue(cell, row));
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                //订户编码规则是
                String vipCustNo = ExcelUtil.getCellValue(cell, row);
                String vipCust = branchNo.substring(branchNo.length()-6).concat(vipCustNo);
                order.setMilkmemberNo(vipCust);
                //根据订户编号，查询订户会员编号，如果有，则赋值给订单对应的会员字段
                TVipCustInfo vci = tVipCustInfoService.findVipCustByNoForUpt(vipCust);
                if(vci!=null){
                    order.setMemberNo(vci.getVipCustNoSap());
                }
                //通过订户查询到地址信息，并写入到订单里
                TMdAddress tMdAddress = tVipCustInfoService.findAddressByCustNoISDefault(vipCust);
                if (tMdAddress == null) {
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + cell.toString() + "的订户编码没有对应的地址信息，请校验数据是否正确！");
                }
                order.setAdressNo(tMdAddress.getAddressId());

                //年卡编号
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                order.setPromotion(ExcelUtil.getCellValue(cell, row));
                //年卡类型
                cell = row.getCell(j++);
                ExcelUtil.isNullCell(cell, row, j);
                String promStatus = ExcelUtil.getCellValue(cell, row);
                List<TPromotion> promotion = promotionService.selYearCardPromByPromNo(salesOrg,order.getPromotion());
                Date promotionStartBuyDate = null;
                Date promotionStopBuyDate = null;
                Date promotionStartPlanDate = null;
                Date promotionStopPlanDate = null;
                if(promotion.size()>0){
                    for(TPromotion items:promotion ){
                        //10年卡
                        if(promStatus.equals("10") && "YEAR-CARD".equals(items.getYearType())){
                            order.setPromItemNo(items.getItemNo());
                            order.setDiscountAmt(items.getDiscountAmt());

                            promotionStartBuyDate = items.getBuyStartTime();
                            promotionStopBuyDate  = items.getBuyStopTime();
                            promotionStartPlanDate = items.getPlanStartTime() ;
                            promotionStopPlanDate = items.getPlanStopTime();
                        }else if(promStatus.equals("20") && "HALF-YEAR-CARD".equals(items.getYearType())){
                            order.setPromItemNo(items.getItemNo());
                            order.setDiscountAmt(items.getDiscountAmt());

                            promotionStartBuyDate = items.getBuyStartTime();
                            promotionStopBuyDate  = items.getBuyStopTime();
                            promotionStartPlanDate = items.getPlanStartTime() ;
                            promotionStopPlanDate = items.getPlanStopTime();
                        }else if(promStatus.equals("30") && "QUARTER-CARD".equals(items.getYearType())){
                            order.setPromItemNo(items.getItemNo());
                            order.setDiscountAmt(items.getDiscountAmt());

                            promotionStartBuyDate = items.getBuyStartTime();
                            promotionStopBuyDate  = items.getBuyStopTime();
                            promotionStartPlanDate = items.getPlanStartTime() ;
                            promotionStopPlanDate = items.getPlanStopTime();
                        }else{
                            throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + order.getPromotion() + "年卡类型不存在，请检查");
                        }
                    }
                }else{
                    throw new ServiceException("第" + (row.getRowNum() + 1) + "行,第" + (cell.getColumnIndex() + 1) + "列" + order.getPromotion() + "促销号、年卡类型不存在，请检查");
                }
                //付款状态为已付款
                order.setPaymentStat("20");
                order.setIsPaid("Y");
                order.setPayDateStr(format.format(new Date()).toString());
                //暂停订单
                order.setPreorderStat("20");
                cell = row.getCell(j++);
                //订单备注
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    order.setMemoTxt(cell.toString());
                }
                cell = row.getCell(j++);
                //订单是否为历史订单
                if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                    try {
                        order.setOrderDate(format.parse(cell.toString()));
                    }catch ( Exception e ){
                        e.printStackTrace();
                    }
                }
                //在订
                order.setSign("10");
                //暂停
                order.setOrderType("20");
                //机构
                order.setPreorderSource("30");
                //年卡为预付费
                order.setPaymentmethod("20");

                OrderModel.setOrder(order);

                ArrayList<TPlanOrderItem> entries = new ArrayList<TPlanOrderItem>();//订单行项目
                for (int s = 1; s <= rowNum1; s++) {
                    TPlanOrderItem entrie = new TPlanOrderItem();
                    int t = 0;
                    XSSFRow row1 = sheet1.getRow(s);
                    XSSFCell cell1 = row1.getCell(t++);
                    //判断订单号码是否一致，如果一致放到一个事物里
                    if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                        if (cell1.toString().equals(order.getOrderNo())) {
                            //订单编号
                            entrie.setOrderNo(cell1.toString());
                            //订购的产品编码
                            cell1 = row1.getCell(t++);
                            entrie.setMatnr("0000000000".concat(ExcelUtil.getCellValue(cell1, row1)));//补齐产品编码
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            //配送规律
                            entrie.setRuleType(ExcelUtil.getCellValue(cell1, row));
                            cell1 = row1.getCell(t++);
                            //每次配送数量
                            entrie.setQty(Integer.valueOf(cell1.toString()));
                            //算出配送天数
                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
                                if (entrie.getRuleType().equals("10")) {
                                    entrie.setGapDays(Integer.valueOf(ExcelUtil.getCellValue(cell1, row1)));
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，间隔天数不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("10")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为周期配送，间隔天数不能为空！");
                                }
                            }

                            cell1 = row1.getCell(t++);
                            if (cell1 != null && StringUtils.isNotEmpty(cell1.toString())) {
                                if (entrie.getRuleType().equals("20")) {
                                    entrie.setRuleTxt(cell1.toString());
                                } else {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,第" + (cell1.getColumnIndex() + 1) + "列,配送规律为星期配送，配送规则不需要填写！");
                                }
                            } else {
                                if (entrie.getRuleType().equals("20")) {
                                    throw new ServiceException("第" + (row1.getRowNum() + 1) + "行,配送规律为星期配送，配送规则不能为空！");
                                }
                            }
                            cell1 = row1.getCell(t++);
                            ExcelUtil.isNullCell(cell1, row, t);
                            entrie.setReachTimeType(ExcelUtil.getCellValue(cell1, row1));
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setStartDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setStartDispDateStr(cell1.toString());
                            cell1 = row1.getCell(t++);
                            try {
                                format.parse(cell1.toString());
                                entrie.setEndDispDate(format.parse(cell1.toString()));
                            } catch (Exception e) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列,日期格式有误");
                            }
                            entrie.setEndDispDateStr(cell1.toString());
                            if (entrie.getEndDispDate().before(entrie.getStartDispDate())) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,结束时间大于开始时间，请校验");
                            }
                            /*cell1 = row1.getCell(t++);
                            if ("20".equals(order.getPaymentmethod()) && (cell1 == null || StringUtils.isEmpty(cell1.toString()))) {
                                throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行，第" + cell1.getColumnIndex() + "列，预付款项目必须填写配送数量！请重新校验同类问题！");
                            }
                            if (cell1 != null && StringUtils.isNotBlank(cell1.toString())) {
                                entrie.setDispTotal(Integer.valueOf(cell1.getStringCellValue()));
                            }*/
                            Date today = new Date();
                            //订单行项目判断年卡促销时间
                            if(promotionStartBuyDate!=null &&promotionStopBuyDate!=null &&promotionStartPlanDate!=null && promotionStopPlanDate!=null){

                               if(format.format(promotionStartBuyDate).compareTo(format.format(entrie.getStartDispDate()))>0){
                                    throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,年卡配送开始时间:"+format.format(promotionStartBuyDate)+"大于行项目开始时间:"+format.format(entrie.getStartDispDate())+"，请校验");
                                }else if(format.format(entrie.getStartDispDate()).compareTo(format.format(promotionStopBuyDate))>0){
                                    throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,年卡配送结束时间:"+format.format(promotionStopBuyDate)+"小于行项目结束时间:"+format.format(entrie.getStartDispDate())+"，请校验");
                                }else if(format.format(promotionStartPlanDate).compareTo(format.format(today))>0){
                                    throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,年卡下单开始:"+format.format(promotionStartPlanDate)+"时间大于今日，请校验");
                                }else if(format.format(today).compareTo(format.format(promotionStopPlanDate))>0){
                                    throw new ServiceException("行项目：第" + (row1.getRowNum() + 1) + "行,年卡下单结束时间"+format.format(promotionStartPlanDate)+"小于今日，请校验");
                                }
                            }
                            float price = 0;
                            float priceDeliver = 0;
                            float priceNetValue = 0;
                            float priceHome = 0;
                            /**
                             * 如过订单日期不为空，取历史价格填入行项目
                             */
                            if(order.getOrderDate()!=null){
                                YearcardPriceQueryModel recode = new YearcardPriceQueryModel();
                                recode.setSearch(entrie.getMatnr());
                                recode.setOrderDate(order.getOrderDate());
                                recode.setSalesOrg(order.getSalesOrg());
                                TMdPriceYearcard opc = yearcardPriceService.selectOldPriceYearcardByMatnr(recode);
                                if(opc.getPriceAgree()==null){
                                    throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    price = opc.getPriceAgree().floatValue();
                                }
                                if(opc.getPriceDeliver()==null){
                                    throw new ServiceException("产品配送费小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    priceDeliver = opc.getPriceDeliver().floatValue();
                                }
                                if(opc.getPriceNetValue()==null){
                                    throw new ServiceException("产品净值价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);
                                }else{
                                    priceNetValue = opc.getPriceNetValue().floatValue();
                                }
                                if(opc.getPriceHome()!=null){
                                    priceHome = opc.getPriceHome().floatValue();
                                }
                            }
                           /* float price = priceService.getMaraPriceForCreateOrder(order.getBranchNo(), entrie.getMatnr(), order.getDeliveryType(), salesOrg);
                            if (price <= 0)
                                throw new ServiceException("产品价格小于0,请检查传入的商品号，奶站和配送方式!信息：" + "奶站：" + order.getBranchNo() + "商品号：" + entrie.getMatnr() + "配送方式：" + order.getDeliveryType() + "销售组织：" + salesOrg);*/
                            entrie.setSalesPrice(new BigDecimal(String.valueOf(price)));
                            entrie.setPriceDeliver(new BigDecimal(String.valueOf(priceDeliver)));
                            entrie.setPriceNetValue(new BigDecimal(String.valueOf(priceNetValue)));
                            entrie.setPriceHome(new BigDecimal(String.valueOf(priceHome)));
                            entries.add(entrie);
                        }
                    }
                }
                OrderModel.setEntries(entries);
                OrderModels.add(OrderModel);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return convertToRespModel(MessageCode.LOGIC_ERROR, e.getMessage(), "");
        }
        if(OrderModels.size()>0) {
            for (OrderCreateModel orderModel : OrderModels) {
                TPreOrder order = orderModel.getOrder();
                if (orderModel.getEntries() == null || orderModel.getEntries().size() == 0) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择商品行!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkboxStat())) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择奶箱状态!");
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getMilkmemberNo())) {
                    if (!"10".equals(order.getPreorderSource()) && !"20".equals(order.getPreorderSource())) {//电商不交验订户
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择订户!");
                    }
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(order.getAdressNo())) {
                    if (orderModel.getAddress() == null) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "请选择或输入地址!");
                    }
                }
                for (TPlanOrderItem e : orderModel.getEntries()) {
                    if (org.apache.commons.lang3.StringUtils.isBlank(e.getRuleType())) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "订单编号" + order.getOrderNo() + "商品行必须要有配送规律!");
                    }
                }
            }

            orderService.createOrders(OrderModels);

        }
        return convertToRespModel(MessageCode.NORMAL, "上传成功！", null);
    }
}
