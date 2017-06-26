package com.nhry.rest.basic;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.basic.domain.TaskYearMonthPlan;
import com.nhry.model.basic.MonthPlanModel;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.ResidentialAreaService;
import com.nhry.service.basic.dao.TaskYearMonthPlanService;
import com.nhry.utils.CodeGeneratorUtil;
import com.nhry.utils.EnvContant;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
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
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cbz on 8/12/2016.
 */
@Path("/plan")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/plan", description = "月任务")
public class TaskYearMonthPlanResource extends BaseResource {
    @Autowired
    private TaskYearMonthPlanService taskYearMonthPlanService;

    @POST
    @Path("/findPlan")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/findPlan", notes = "查询公司奶站月任务计划", response = ResponseModel.class)
    public Response findPlanByYear(@ApiParam(name = "model", value = "model", required = false) MonthPlanModel model) {
        return convertToRespModel(MessageCode.NORMAL, null, taskYearMonthPlanService.findPlanByYear(model));
    }

    @POST
    @Path("/savePlans")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/savePlans", notes = "批量保存奶站月任务计划", response = ResponseModel.class)
    public Response savePlans(@ApiParam(name = "plans", value = "plans", required = true) List<TaskYearMonthPlan> plans) {
        return convertToRespModel(MessageCode.NORMAL, null, taskYearMonthPlanService.savePlans(plans));
    }

    @POST
    @Path("/savePlan")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/savePlan", notes = "保存奶站月任务计划", response = ResponseModel.class)
    public Response savePlans(@ApiParam(name = "plan", value = "plan", required = true) TaskYearMonthPlan plan) {
        return convertToRespModel(MessageCode.NORMAL, null, taskYearMonthPlanService.savePlan(plan));
    }

    @POST
    @Path("/exportTemplate")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/exportTemplate", response = OrderCreateModel.class, notes = "导出月任务模板")
    public Response exportTemplate(@ApiParam(name = "model", value = "model", required = false) MonthPlanModel model, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        List<TaskYearMonthPlan> plans = taskYearMonthPlanService.findPlanByYear(model);
        String url = EnvContant.getSystemConst("filePath");
        String outUrl = "";
        String fileName = "MonthTaskTemplate.xlsx";
        try {
            File file = new File(url + File.separator + "report" + File.separator + "template" + File.separator + fileName);    //审批单
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(input));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int i = 2;
            for (TaskYearMonthPlan plan : plans) {
                XSSFRow row = sheet.createRow(i++);
                XSSFCell cell;
                int j = 1;
                cell = row.createCell(j++);
                cell.setCellValue(plan.getBranckNo());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getBranchName());
                cell = row.createCell(j++);
                if(StringUtils.isEmpty(plan.getTaskYear())) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    int year = calendar.get(Calendar.YEAR);
                    cell.setCellValue(String.valueOf(year));
                }else{
                    cell.setCellValue(plan.getTaskYear());
                }
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskJan() == null ? "" : plan.getTaskJan().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskFeb() == null ? "" : plan.getTaskFeb().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskMar() == null ? "" : plan.getTaskMar().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskApr() == null ? "" : plan.getTaskApr().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskMay() == null ? "" : plan.getTaskMay().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskJun() == null ? "" : plan.getTaskJun().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskJul() == null ? "" : plan.getTaskJul().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskAug() == null ? "" : plan.getTaskAug().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskSep() == null ? "" : plan.getTaskSep().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskOct() == null ? "" : plan.getTaskOct().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskNov() == null ? "" : plan.getTaskNov().toString());
                cell = row.createCell(j++);
                cell.setCellValue(plan.getTaskDev() == null ? "" : plan.getTaskDev().toString());
            }
            String fname = CodeGeneratorUtil.getCode();
            File export = new File(url + File.separator + "report" + File.separator + "export" + File.separator + fname + fileName);
            FileOutputStream stream = new FileOutputStream(export);
            workbook.write(stream);
            stream.flush();
            stream.close();

            outUrl = fname + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertToRespModel(MessageCode.NORMAL, null, outUrl);
    }

    @POST
    @Path("/importPlans")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/importPlans", response = ResponseModel.class, notes = "导入计划")
    public Response importPlans(FormDataMultiPart form, @Context HttpServletRequest request) throws IOException {
        String url = EnvContant.getSystemConst("filePath");
        FormDataBodyPart filePart = form.getField("file");
        FormDataBodyPart taskYear = form.getField("taskYear");
        InputStream fileInputStream = filePart.getValueAs(InputStream.class);
        FormDataContentDisposition formDataContentDisposition = filePart.getFormDataContentDisposition();
        String source = formDataContentDisposition.getFileName();
        if (!source.endsWith("xlsx")) {
            return convertToRespModel(MessageCode.LOGIC_ERROR, "文件类型错误！", "");
        }
        String result = new String(source.getBytes("ISO8859-1"), "UTF-8");
        String filePath = url + File.separator + "report" + File.separator + "template" + File.separator + result;
        File file = new File(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(new BufferedInputStream(fileInputStream));
//        FileUtils.copyInputStreamToFile(fileInputStream,file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        List<TaskYearMonthPlan> plans = new ArrayList<TaskYearMonthPlan>();
        for (int i = 2; i <= rowNum; i++) {
            TaskYearMonthPlan plan = new TaskYearMonthPlan();
            if (taskYear != null && StringUtils.isNotEmpty(taskYear.getValue())) {
                plan.setTaskYear(taskYear.getValue());
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int year = calendar.get(Calendar.YEAR);
                plan.setTaskYear(String.valueOf(year));
            }
            int j = 1;
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(j++);
            plan.setBranckNo(cell.toString());
            cell = row.getCell(j++);
            plan.setBranchName(cell.toString());
            cell = row.getCell(j++);
            plan.setTaskYear(cell.toString());
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskJan(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskFeb(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskMar(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskApr(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskMay(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskJun(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskJul(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskAug(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskSep(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskOct(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskNov(getCellValue(cell));
            }
            cell = row.getCell(j++);
            if (cell != null && StringUtils.isNotEmpty(cell.toString())) {
                plan.setTaskDev(getCellValue(cell));
            }
            plans.add(plan);
        }
        return convertToRespModel(MessageCode.NORMAL, null, taskYearMonthPlanService.savePlans(plans));
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
}
