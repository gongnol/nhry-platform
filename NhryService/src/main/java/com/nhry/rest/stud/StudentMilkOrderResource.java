
package com.nhry.rest.stud;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.stud.ExportStudOrderMilkModel;
import com.nhry.model.stud.OrderBatchBuildModel;
import com.nhry.model.stud.OrderStudLossModel;
import com.nhry.model.stud.OrderStudQueryModel;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.pi.dao.PIRequireOrderService;
import com.nhry.service.stud.dao.ClassService;
import com.nhry.service.stud.dao.MaraStudService;
import com.nhry.service.stud.dao.OrderStudService;
import com.nhry.service.stud.dao.SchoolClassService;
import com.nhry.service.stud.dao.SchoolRuleService;
import com.nhry.service.stud.dao.SchoolService;
import com.nhry.utils.RandomCodeUtils;
import com.nhry.webService.client.PISuccessMessage;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
@Path("/studentMilk/order")
@Controller
@Singleton
@Scope("request")
@Api(value = "/studentMilk/order",description = "学生奶_订奶管理")
public class StudentMilkOrderResource  extends BaseResource {
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SchoolRuleService schoolRuleService;
	
	@Autowired
	private OrderStudService orderStudService;
	
	@Autowired
	private MaraStudService maraStudService;
	
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private RedisTemplate<String, Object> objectRedisTemplate;
	
	@GET
	@Path("/randomCode")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/randomCode", response = Response.class, notes = "随机验证码(base64)")
	public Response randomCode() throws IOException{
		String code = RandomCodeUtils.randomCode(4);
		objectRedisTemplate.opsForHash().put(RandomCodeUtils.USERRANDOMCODE, userSessionService.getCurrentUser().getLoginName(), code);
		return convertToRespModel(MessageCode.NORMAL, null, RandomCodeUtils.base64Image(RandomCodeUtils.getImageBuffer(code)));
	}
	
	@POST
	@Path("/findAllSchool")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findAllSchool", response = List.class, notes = "获取全部学校信息列表")
	public Response findAllSchool(@ApiParam(required=true,name="smodel",value="SearchModel") SchoolQueryModel smodel){
		smodel.setVisiable("10");
		return convertToRespModel(MessageCode.NORMAL, null, schoolService.findSchoolPage(smodel));
	}
	
	@GET
	@Path("/findByOrderId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findByOrderId", response = TMstOrderStud.class, notes = "根据订单号查询订单")
	public Response findClassByClassCode(@ApiParam(required=true,name="orderId") @PathParam("orderId") String orderId){
		return convertToRespModel(MessageCode.NORMAL, null, orderStudService.selectByOrderId(orderId));
	}
	
	@POST
	@Path("/findOrderPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findOrderPage", response = PageInfo.class, notes = "分页查询订单")
	public Response findClassListBySalesOrg(@ApiParam(required=true,name="queryModel")OrderStudQueryModel queryModel){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.findOrderPage(queryModel));
	}
	
	@POST
	@Path("/createOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createOrder", response = int.class, notes = "创建订单(分包)")
	public Response createOrder(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.createOrder(mstOrderStud));
	}
	
	@POST
	@Path("/createOrderUnpack")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createOrderUnpack", response = int.class, notes = "创建订单(不分包)")
	public Response createOrderUnpack(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.createOrderUnpack(mstOrderStud));
	}
	
	@POST
	@Path("/createOrderFill")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createOrderFill", response = int.class, notes = "创建订单(补单)")
	public Response createOrderFill(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.createOrderFill(mstOrderStud));
	}
	
	@POST
	@Path("/updateOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/updateOrder", response = int.class, notes = "更新订单")
	public Response updateOrder(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.updateByOrder(mstOrderStud));
	}
	
	
	@GET
	@Path("/findMaraStudAllList")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findMaraStudAllList", response = List.class, notes = "查询奶品列表")
	public Response findMaraStudAllList(){
		return convertToRespModel(MessageCode.NORMAL, null,  maraStudService.findAllListBySalesOrg());
	}
	
	
	@POST
	@Path("/findMaraStudAllPage")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findMaraStudAllPage", notes = "查询奶品列表分页")
	public Response findMaraStudAllPage(@ApiParam(required=true,name="queryModel")OrderStudQueryModel queryModel){
		return convertToRespModel(MessageCode.NORMAL, null,  maraStudService.findMaraStudAllPage(queryModel));
	}
	
	@POST
	@Path("/saveMaraStud")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/saveMaraStud", response = Integer.class, notes = "保存奶产品")
	public Response saveMaraStud(@ApiParam(required=true,name="tMdMaraStud")TMdMaraStud tMdMaraStud){
		return convertToRespModel(MessageCode.NORMAL, null,  maraStudService.updateMaraStud(tMdMaraStud));
	}
	
	@POST
	@Path("/findOrderInfoBySchoolCodeAndDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findOrderInfoBySchoolCodeAndDate", response = Map.class, notes = "根据学校，时间查询订单详情列表(分包)")
	public Response findOrderInfoBySchoolCodeAndDate(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.findOrderInfoBySchoolCodeAndDate(mstOrderStud));
	}
	
	@POST
	@Path("/findOrderInfoBySchoolCodeAndDateUnpack")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findOrderInfoBySchoolCodeAndDateUnpack", response = Map.class, notes = "根据学校，时间查询订单详情列表(不分包)")
	public Response findOrderInfoBySchoolCodeAndDateUnpack(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.findOrderInfoBySchoolCodeAndDateUnpack(mstOrderStud));
	}
	
	@POST
	@Path("/findOrderInfoBySchoolCodeAndDateFill")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findOrderInfoBySchoolCodeAndDateFill", response = Map.class, notes = "根据学校，时间查询订单详情列表(补单)")
	public Response findOrderInfoBySchoolCodeAndDateFill(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.findOrderInfoBySchoolCodeAndDateFill(mstOrderStud));
	}
	
	@POST
	@Path("/buildBatchInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/buildBatchInfo", response = Map.class, notes = "批量生成订单数据准备")
	public Response buildBatchInfo(@ApiParam(required=true,name="orderBatchBuildModel")OrderBatchBuildModel orderBatchBuildModel)  throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.buildBatchInfo(orderBatchBuildModel));
	}
	
	@POST
	@Path("/createOrderWithBatch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/createOrderWithBatch", response = int.class, notes = "批量生成订单")
	public Response createOrderWithBatch(@ApiParam(required=true,name="orderBatchBuildModel")OrderBatchBuildModel orderBatchBuildModel) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.createOrderWithBatch(orderBatchBuildModel));
	}
	
	@POST
	@Path("/deleteOrderWithBatch")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/deleteOrderWithBatch", response = int.class, notes = "批量删除指定日期的订单")
	public Response deleteOrderWithBatch(@ApiParam(required=true,name="orderBatchBuildModel")OrderBatchBuildModel orderBatchBuildModel) throws Exception{
		Object serverRandomCode = objectRedisTemplate.opsForHash().get(RandomCodeUtils.USERRANDOMCODE, userSessionService.getCurrentUser().getLoginName());
		orderBatchBuildModel.setServerRandomCode(null!=serverRandomCode?serverRandomCode.toString():"");
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.updateOrderWithBatch(orderBatchBuildModel));
	}
	
	@POST
	@Path("/calcLoss")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/calcLoss", response = int.class, notes = "订奶计算损耗")
	public Response calcLoss(@ApiParam(required=true,name="orderStudLossModel")OrderStudLossModel orderStudLossModel) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.calcLoss(orderStudLossModel));
	}
	
	@POST
	@Path("/exportStudOrderMilkSum")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/exportStudOrderMilkSum", response = int.class, notes = "导出总销售报表EXCEl")
	public Response exportStudOrderMilkSum(@ApiParam(required=true,name="model")ExportStudOrderMilkModel model) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.exportStudOrderMilkSum(model));
	}
	
	@POST
	@Path("/exportStudOrderMilk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/exportStudOrderMilk", response = int.class, notes = "导出EXCEl")
	public Response exportStudOrderMilk(@ApiParam(required=true,name="model")ExportStudOrderMilkModel model) throws Exception{
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.exportStudOrderMilk(model));
	}
	
	@POST
	@Path("/findDefaultMaraForSchool")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/findDefaultMaraForSchool", response = Response.class, notes = "查询指定学校当前日期的奶品政策")
	public Response findDefaultMaraForSchool(@ApiParam(required=true,name="mstOrderStud")TMstOrderStud mstOrderStud){
		return convertToRespModel(MessageCode.NORMAL, null,  orderStudService.findDefaultMaraForSchool(mstOrderStud));
	}
	
	@Autowired
	PIRequireOrderService pIRequireOrderService;
	
	

	/*@GET
	@Path("/generateSalesOrder18")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/generateSalesOrder18", response = int.class, notes = "生成ERP销售订单")
	public Response generateSalesOrder18() throws Exception{
		StringBuffer  sb=new StringBuffer();
		//获取当天所有的报货信息
		List<TMstOrderStud> list = orderStudService.findOrderStudByDateAndSalesOrg();
		
		
		
		if(list !=null &&  list.size() > 0 ){
			for (TMstOrderStud order : list) {
				new Thread(new Runnable() {
					public void run() {
						PISuccessMessage sucMsg = pIRequireOrderService.generateSalesOrder18(order);
						if (sucMsg.isSuccess()) {
							order.setErpOrderId(sucMsg.getData());
							order.setErpOrderStatus("10");
							order.setErpOrderMsg(sucMsg.getMessage());
							orderStudService.updateByOrder(order);
				        } else {
				        	sb.append(sucMsg.getMessage());
				        }
					}
				}).start();
			}
		}
		return convertToRespModel(MessageCode.NORMAL, null,sb);
	}*/
	
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;

	@GET
	@Path("/generateSalesOrder18")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/generateSalesOrder18", response = int.class, notes = "生成ERP销售订单")
	public Response generateSalesOrder18() throws Exception{
		StringBuffer  sb=new StringBuffer();
		//获取当天所有的报货信息
		List<TMstOrderStud> list = orderStudService.findOrderStudByDateAndSalesOrg();
		Map<String, FutureTask<PISuccessMessage>> taskMap = new HashMap<String, FutureTask<PISuccessMessage>>();
		if(list !=null &&  list.size() > 0 ){
			for (TMstOrderStud order : list) {
				
				//已经发送成功的不再发送
				if("10".equals(order.getErpOrderStatus()) && "10".equals(order.getErpOrderFreeStatus()) && "10".equals(order.getErpOrderFillStatus()) && "10".equals(order.getErpOrderFreeFillId()) ){
					continue;
				}
				
				taskMap.put(order.getOrderId(), new FutureTask<PISuccessMessage>(new Callable<PISuccessMessage>(){
					@Override
					public PISuccessMessage call() throws Exception {
						
						if(!"10".equals(order.getErpOrderStatus())){
							//正常销售订单
							PISuccessMessage sucMsg = pIRequireOrderService.generateSalesOrder18(order);
							if (sucMsg.isSuccess()) {
								order.setErpOrderId(sucMsg.getData());
								order.setErpOrderStatus("10");
								order.setErpOrderMsg("发送成功");
								orderStudService.updateByOrder(order);
					        } else {
					        	order.setErpOrderId(sucMsg.getData());
								order.setErpOrderStatus("20");
								order.setErpOrderMsg(sucMsg.getMessage());
								orderStudService.updateByOrder(order);
								sb.append(order.getOrderId()+"正常销售订单").append(":{").append(sucMsg.getMessage()).append("},");
					        }
						}
						
					
						
						if(!"10".equals(order.getErpOrderFreeStatus())){
							//免费销售订单
							PISuccessMessage sucMsgLoss = pIRequireOrderService.generateSalesOrderLoss18(order);
							if(sucMsgLoss.isSuccess()){
								order.setErpOrderFreeStatus("10");
								order.setErpOrderFreeMsg("发送成功");
								order.setErpOrderFreeId(sucMsgLoss.getData());
								orderStudService.updateByOrder(order);
							}else{
								order.setErpOrderId(sucMsgLoss.getData());
								order.setErpOrderFreeStatus("20");
								order.setErpOrderFreeMsg(sucMsgLoss.getMessage());
								orderStudService.updateByOrder(order);
								sb.append(order.getOrderId()+"免费销售订单").append(":{").append(sucMsgLoss.getMessage()).append("},");
							}
						}
						
						
						if(!"10".equals(order.getErpOrderFillStatus())){
							//补单
							PISuccessMessage sucMsg = pIRequireOrderService.generateSalesOrderFll18(order);
							if (sucMsg.isSuccess()) {
								order.setErpOrderFillId(sucMsg.getData());
								order.setErpOrderFillStatus("10");
								order.setErpOrderFillMsg("发送成功");
								orderStudService.updateByOrder(order);
					        } else {
					        	order.setErpOrderFillId(sucMsg.getData());
								order.setErpOrderFillStatus("20");
								order.setErpOrderFillMsg(sucMsg.getMessage());
								orderStudService.updateByOrder(order);
								sb.append(order.getOrderId()+"有效补单").append(":{").append(sucMsg.getMessage()).append("},");
					        }
						}
						
						if(!"10".equals(order.getErpOrderFreeFillStatus())){
							//补单免费订单
							PISuccessMessage sucMsg = pIRequireOrderService.generateSalesOrderLossFll18(order);
							if (sucMsg.isSuccess()) {
								order.setErpOrderFreeFillId(sucMsg.getData());
								order.setErpOrderFreeFillStatus("10");
								order.setErpOrderFreeFillMsg("发送成功");
								orderStudService.updateByOrder(order);
					        } else {
					        	order.setErpOrderFreeFillId(sucMsg.getData());
								order.setErpOrderFreeFillStatus("20");
								order.setErpOrderFreeFillMsg(sucMsg.getMessage());
								orderStudService.updateByOrder(order);
								sb.append(order.getOrderId()+"有效补单免费订单").append(":{").append(sucMsg.getMessage()).append("},");
					        }
						}
						return null;
					}}));
			}
		}
		
		if(taskMap != null && !taskMap.isEmpty()){
			for(String key : taskMap.keySet()){
				taskExecutor.submit(taskMap.get(key));
			}
			while (true) {
				int i=0;
				for(String key : taskMap.keySet()){
					FutureTask<PISuccessMessage> futureTask = taskMap.get(key);
					if(futureTask.isDone()){
						i++;
					}
				}
				if(i== taskMap.size()){
					break;
				}
				Thread.sleep(2000);
			}
			if(sb.length()==0){
				sb.append("发送成功");
			}
		}
		else{
			sb.append("暂无可发送的数据");
		}
		return convertToRespModel(MessageCode.NORMAL, null,sb);
	}
	
	
	
	
	
	
}
