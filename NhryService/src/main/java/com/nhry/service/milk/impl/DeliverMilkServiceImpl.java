package com.nhry.service.milk.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.dao.TMdMaraMapper;
import com.nhry.data.basic.dao.TMdOperationLogMapper;
import com.nhry.data.basic.domain.*;
import com.nhry.data.milk.dao.*;
import com.nhry.data.milk.domain.*;
import com.nhry.data.milktrans.dao.TMstInsideSalOrderItemMapper;
import com.nhry.data.milktrans.dao.TMstInsideSalOrderMapper;
import com.nhry.data.milktrans.domain.*;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.model.basic.MatnrAndQtyModel;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.milk.*;
import com.nhry.model.milktrans.*;
import com.nhry.model.order.OrderDaliyPlanReportEntityModel;
import com.nhry.model.order.OrderDaliyPlanReportModel;
import com.nhry.model.stock.StockModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.BranchEmpService;
import com.nhry.service.basic.dao.BranchService;
import com.nhry.service.basic.dao.ProductService;
import com.nhry.service.milk.dao.DeliverMilkService;
import com.nhry.service.milk.pojo.TDispOrderChangeItem;
import com.nhry.service.milktrans.dao.ReturnBoxService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.stock.dao.TSsmStockService;
import com.nhry.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DeliverMilkServiceImpl extends BaseService implements DeliverMilkService
{
	private TDispOrderItemMapper tDispOrderItemMapper;
	private TDispOrderMapper tDispOrderMapper;
	private TPreOrderMapper tPreOrderMapper;
	private TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper;
	private TDispOrderChangeMapper tDispOrderChangeMapper;
	private TPlanOrderItemMapper tPlanOrderItemMapper;
	private OrderService orderService;
	private ProductService productService;
	private ReturnBoxService returnBoxService;
	private TSsmStockService tSsmStockService;
	private TSysUserRoleMapper urMapper;
	private TMstRefuseResendMapper resendMapper;
	private TMstRefuseResendItemMapper resendItemMapper;
	private TMdBranchEmpMapper branchEmpMapper;
	private TMdOperationLogMapper operationLogMapper;
	private TMdMaraMapper tMdMaraMapper;
	private BranchService branchService;
	private BranchEmpService branchEmpService;

	public void settMdMaraMapper(TMdMaraMapper tMdMaraMapper) {
		this.tMdMaraMapper = tMdMaraMapper;
	}

	public void setOperationLogMapper(TMdOperationLogMapper operationLogMapper) {
		this.operationLogMapper = operationLogMapper;
	}

	public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper) {
		this.branchEmpMapper = branchEmpMapper;
	}

	public void setResendItemMapper(TMstRefuseResendItemMapper resendItemMapper) {
		this.resendItemMapper = resendItemMapper;
	}

	public void setResendMapper(TMstRefuseResendMapper resendMapper) {
		this.resendMapper = resendMapper;
	}

	public void setUrMapper(TSysUserRoleMapper urMapper) {
		this.urMapper = urMapper;
	}

	public void settSsmStockService(TSsmStockService tSsmStockService) {
		this.tSsmStockService = tSsmStockService;
	}

	public void setReturnBoxService(ReturnBoxService returnBoxService)
	{
		this.returnBoxService = returnBoxService;
	}
	
	public void setProductService(ProductService productService)
	{
		this.productService = productService;
	}
	
	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}
	
	private TMstInsideSalOrderMapper tMstInsideSalOrderMapper;
	private TMstInsideSalOrderItemMapper tMstInsideSalOrderItemMapper;

	public void settMstInsideSalOrderMapper(TMstInsideSalOrderMapper tMstInsideSalOrderMapper) {
		this.tMstInsideSalOrderMapper = tMstInsideSalOrderMapper;
	}

	public void settMstInsideSalOrderItemMapper(TMstInsideSalOrderItemMapper tMstInsideSalOrderItemMapper) {
		this.tMstInsideSalOrderItemMapper = tMstInsideSalOrderItemMapper;
	}

	public void settPlanOrderItemMapper(TPlanOrderItemMapper tPlanOrderItemMapper)
	{
		this.tPlanOrderItemMapper = tPlanOrderItemMapper;
	}
	
	public void settDispOrderChangeMapper(TDispOrderChangeMapper tDispOrderChangeMapper)
	{
		this.tDispOrderChangeMapper = tDispOrderChangeMapper;
	}

	public void settDispOrderItemMapper(TDispOrderItemMapper tDispOrderItemMapper)
	{
		this.tDispOrderItemMapper = tDispOrderItemMapper;
	}

	public void settDispOrderMapper(TDispOrderMapper tDispOrderMapper)
	{
		this.tDispOrderMapper = tDispOrderMapper;
	}
	
	public void settOrderDaliyPlanItemMapper(TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper)
	{
		this.tOrderDaliyPlanItemMapper = tOrderDaliyPlanItemMapper;
	}

	public void settPreOrderMapper(TPreOrderMapper tPreOrderMapper)
	{
		this.tPreOrderMapper = tPreOrderMapper;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	public void setBranchEmpService(BranchEmpService branchEmpService) {
		this.branchEmpService = branchEmpService;
	}



	//路单确认后 生成内部销售订单
	public int createInsideSalOrderAfterConfirmRoute(List<TDispOrderItem> entries,TDispOrder dispOrder,TSysUser user) {
		if(entries!=null && entries.size()>0){
			TMstInsideSalOrder sOrder = tMstInsideSalOrderMapper.getInSalOrderByDispOrderNo(dispOrder.getOrderNo());
			//删除 重新生成  为了测试用
			if(sOrder!=null){
				tMstInsideSalOrderItemMapper.delInSalOrderItemByOrderNo(sOrder.getInsOrderNo());
			}
			String insOrderNo = null;
			for(TDispOrderItem entry : entries){
				if(entry.getReason()!=null && ("40".equals(entry.getReason()) || "50".equals(entry.getReason()) )){
					if(insOrderNo==null){
						insOrderNo = SerialUtil.creatSeria();
					}
					//生成内部销售订单
					TMstInsideSalOrderItem item = new TMstInsideSalOrderItem();
					item.setInsOrderNo(insOrderNo);
					item.setItemNo(entry.getItemNo());
					item.setOrgOrderNo(entry.getOrgOrderNo());
					item.setMatnr(entry.getMatnr());
					item.setOrderDate(dispOrder.getOrderDate());
					item.setPrice(entry.getPrice());
					item.setQty(entry.getQty().subtract(entry.getConfirmQty()));
					item.setReason(entry.getReason());
					tMstInsideSalOrderItemMapper.insertOrderItem(item);
				}
			}
			if(insOrderNo!=null){
				TMdBranch branch = branchService.selectBranchByNo(dispOrder.getBranchNo());
				EmpQueryModel sModel =new  EmpQueryModel();
				sModel.setBranchNo(dispOrder.getBranchNo());
				sModel.setRoleId("10002");
				List<TMdBranchEmp> tbList = branchEmpService.queryBranchEmp(sModel);
				if(branch!=null){
					//如果奶站维护了内部销售订单售达方为站长，则内部销售订单挂到站长头上，否则挂到送奶员头上
					sOrder = new TMstInsideSalOrder();
					if("20".equals(branch.getTargetPerson())){
						if(tbList.size()==0){
							throw new ServiceException(MessageCode.LOGIC_ERROR,"此奶站没有奶站站长，请维护！！！！");
						}else if(tbList.size()>1) {
							throw new ServiceException(MessageCode.LOGIC_ERROR, "此奶站有多个奶站站长，请维护！！！！");
						}
						for(TMdBranchEmp item:tbList ){
							sOrder.setSalEmpNo(item.getEmpNo());
						}
					}else{
						sOrder.setSalEmpNo(dispOrder.getDispEmpNo());
					}
				}
				sOrder.setInsOrderNo(insOrderNo);
				sOrder.setOrderDate(dispOrder.getOrderDate());
				sOrder.setDispOrderNo(dispOrder.getOrderNo());
				sOrder.setBranchNo(dispOrder.getBranchNo());
				sOrder.setCreateAt(new Date());
				sOrder.setCreateBy(user.getLoginName());
				tMstInsideSalOrderMapper.insertInsideSalOrder(sOrder);
			}

		}
		return 1;
	}
	/**
	 * 路单确认后  扣除库存
	 * 产生拒收复送记录
	 * 生成 对应的内部销售订单
	 * @param dispOrderNo
	 * @return
     */
	@Override
	public int createInsideSalOrder(String dispOrderNo) {
			final long startTime = System.currentTimeMillis();
			TSysUser user = userSessionService.getCurrentUser();
			TMstInsideSalOrder sOrder = tMstInsideSalOrderMapper.getInSalOrderByDispOrderNo(dispOrderNo);
			TDispOrder order = tDispOrderMapper.getDispOrderByNo(dispOrderNo);
			List<TDispOrderItem> entries = tDispOrderItemMapper.selectItemsByOrderNo(dispOrderNo);

			if(sOrder!=null){
				tMstInsideSalOrderItemMapper.delInSalOrderItemByOrderNo(sOrder.getInsOrderNo());
			}
			String insOrderNo = null;
			if(entries!=null && entries.size()>0){
				for(TDispOrderItem entry : entries){
					//更新库存
					if( "30".equals(entry.getReason()) || "40".equals(entry.getReason()) || "50".equals(entry.getReason())) {
						tSsmStockService.updateStock(order.getBranchNo(), entry.getConfirmMatnr(), entry.getQty(), user.getSalesOrg());
					}else{
						if("60".equals(entry.getReason())){
							tSsmStockService.updateStock(order.getBranchNo(), entry.getConfirmMatnr(), entry.getQty().subtract(entry.getConfirmQty()), user.getSalesOrg());
						}else{
							tSsmStockService.updateStock(order.getBranchNo(), entry.getConfirmMatnr(), entry.getConfirmQty(), user.getSalesOrg());
						}
						//如果原因是 60 （拒收复送）拒收部分保存至库存中
						//T创建产品拒收复送记录，包括路单日期、奶站、送奶员、产品、拒收复送数量，（应用要货标识和部分应用要货标识、应用要货数量）
						if("60".equals(entry.getReason()) && entry.getQty().subtract(entry.getConfirmQty()).compareTo(BigDecimal.ZERO)!=0){
							TMstRefuseResend oldResend = resendMapper.selectRefuseResendByDispEmpAndMatnr(dispOrderNo,order.getDispEmpNo(),entry.getConfirmMatnr());
							if(oldResend!=null){
								oldResend.setQty(oldResend.getQty().add(entry.getQty().subtract(entry.getConfirmQty())));
								oldResend.setRemainQty(oldResend.getRemainQty().add(entry.getQty().subtract(entry.getConfirmQty())));
								resendMapper.uptRefuseResend(oldResend);
							}else{
								TMstRefuseResend resend = new TMstRefuseResend();
								resend.setResendOrderNo(PrimaryKeyUtils.generateUpperUuidKey());
								resend.setBranchNo(user.getBranchNo());
								resend.setEmpNo(order.getDispEmpNo());
								resend.setQty(entry.getQty().subtract(entry.getConfirmQty()));
								resend.setRemainQty(entry.getQty().subtract(entry.getConfirmQty()));
								resend.setConfirmQty(BigDecimal.ZERO);
								resend.setInsideQty(BigDecimal.ZERO);
								resend.setMatnr(entry.getMatnr());
								resend.setStatus("10");
								resend.setSalesOrg(user.getSalesOrg());
								resend.setDispDate(entry.getOrderDate());
								resend.setDispOrderNo(entry.getOrderNo());
								resendMapper.addTMstRefuseResend(resend);
							}

							tSsmStockService.updateTmpStock(order.getBranchNo(), entry.getConfirmMatnr(), entry.getConfirmQty().subtract(entry.getQty()), user.getSalesOrg());
						}
					}
					if(entry.getReason()!=null && ("40".equals(entry.getReason()) || "50".equals(entry.getReason()) )){
						if(insOrderNo==null){
							insOrderNo = SerialUtil.creatSeria();
						}
						//生成内部销售订单
						TMstInsideSalOrderItem item = new TMstInsideSalOrderItem();
						item.setInsOrderNo(insOrderNo);
						item.setItemNo(entry.getItemNo());
						item.setOrgOrderNo(entry.getOrgOrderNo());
						item.setMatnr(entry.getMatnr());
						item.setOrderDate(order.getOrderDate());
						item.setPrice(entry.getPrice());
						item.setQty(entry.getQty().subtract(entry.getConfirmQty()));
						item.setReason(entry.getReason());
						tMstInsideSalOrderItemMapper.insertOrderItem(item);
					}
				}
				if(insOrderNo!=null){
					TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
					EmpQueryModel sModel =new  EmpQueryModel();
					sModel.setBranchNo(order.getBranchNo());
					sModel.setRoleId("10002");
					List<TMdBranchEmp> tbList = branchEmpService.queryBranchEmp(sModel);

					if(branch!=null){
						//如果奶站维护了内部销售订单售达方为站长，则内部销售订单挂到站长头上，否则挂到送奶员头上
						sOrder = new TMstInsideSalOrder();
						if("20".equals(branch.getTargetPerson())){
							if(tbList.size()==0){
								throw new ServiceException(MessageCode.LOGIC_ERROR,"此奶站没有奶站站长，请维护！！！！");
							}else if(tbList.size()>1) {
								throw new ServiceException(MessageCode.LOGIC_ERROR, "此奶站有多个奶站站长，请维护！！！！");
							}
							for(TMdBranchEmp item:tbList ){
								sOrder.setSalEmpNo(item.getEmpNo());
							}
						}else{
							sOrder.setSalEmpNo(order.getDispEmpNo());
						}
					}

					sOrder.setInsOrderNo(insOrderNo);
					sOrder.setOrderDate(order.getOrderDate());
					sOrder.setDispOrderNo(order.getOrderNo());
					sOrder.setBranchNo(order.getBranchNo());
					sOrder.setCreateAt(new Date());
					sOrder.setCreateBy(user.getLoginName());
					tMstInsideSalOrderMapper.insertInsideSalOrder(sOrder);
				}

			}
			System.out.println("根据路单生成拒收复送和内部销售订单共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
			return 1;



	}



	@Override
	public PageInfo getInsideSalOrder(InSideSalOrderSearchModel sModel) {
		TSysUser user = userSessionService.getCurrentUser();
		List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
		sModel.setSalesOrg(user.getSalesOrg());
		sModel.setBranchNo(user.getBranchNo());
		sModel.setDealerNo(user.getDealerId());
		return tMstInsideSalOrderMapper.getAuthAllInsideSalOrder(sModel);
	}

	@Override
	public PageInfo getInsideSalOrderDetail(InSideSalOrderDetailSearchModel sModel) {
		TSysUser user = userSessionService.getCurrentUser();
		sModel.setSalesOrg(user.getSalesOrg());
		return tMstInsideSalOrderItemMapper.getInsideSalOrderDetail(sModel);
	}

	@Override
	public int createInsideSalOrderByStock(CreateInSalOrderModel cModel) {
		List<MatnrAndQtyModel> items = cModel.getMatnrs();
		if(items!=null && items.size()>0){
			Date date = new Date();
			TSysUser user = userSessionService.getCurrentUser();
			TMstInsideSalOrder order = new TMstInsideSalOrder();
			String insOrderNo = PrimaryKeyUtils.generateUuidKey();
			order.setSalEmpNo(cModel.getEmpNo());
			order.setInsOrderNo(insOrderNo);
			order.setOrderDate(date);
			order.setBranchNo(user.getBranchNo());
			for(int i=0 ;i <items.size();i++){
				MatnrAndQtyModel model = items.get(i);
				TMstInsideSalOrderItem item = new TMstInsideSalOrderItem();
				item.setOrderDate(date);
				item.setInsOrderNo(insOrderNo);
				//item.setReason("");
				item.setMatnr(model.getMatnr());
				item.setQty(new BigDecimal(model.getQty()));
				item.setItemNo(SerialUtil.creatSeria());
				item.setReason("80");//库存生成内部销售订单定义为80
				tMstInsideSalOrderItemMapper.insertOrderItem(item);
				//更新库存
				tSsmStockService.updateStock(order.getBranchNo(),model.getMatnr(),new BigDecimal(model.getQty()),user.getSalesOrg());
			}
			tMstInsideSalOrderMapper.insertInsideSalOrder(order);

			//创建回瓶
			StockModel smodel = new StockModel();
			smodel.setBranchNo(user.getBranchNo());
			smodel.setEmpNo(cModel.getEmpNo());
			returnBoxService.craeteRetBotByStock(smodel);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有选择产品！！！！");
		}

 		return 0;
	}
	/**
	 * 拒收复送内部销售
	 * */
	@Override
	public int createInsideSalOrderByTmpStock(CreateInsalOrderByRefuseModel cModel) {
		List<MatnrAndQtyModel> items = cModel.getMatnrs();
		if(items!=null && items.size()>0){
			Date date = new Date();
			TSysUser user = userSessionService.getCurrentUser();
			TMstInsideSalOrder order = new TMstInsideSalOrder();
			String insOrderNo = PrimaryKeyUtils.generateUuidKey();
			order.setSalEmpNo(cModel.getEmpNo());
			order.setInsOrderNo(insOrderNo);
			order.setOrderDate(date);
			order.setBranchNo(user.getBranchNo());
			for(int i=0 ;i <items.size();i++){
				MatnrAndQtyModel model = items.get(i);
				TMstInsideSalOrderItem item = new TMstInsideSalOrderItem();
				item.setOrderDate(date);
				item.setInsOrderNo(insOrderNo);
				//item.setReason("");
				item.setMatnr(model.getMatnr());
				item.setQty(new BigDecimal(model.getQty()));
				item.setItemNo(SerialUtil.creatSeria());
				item.setReason("90");//拒收复送生成内部销售订单定义为90
				tMstInsideSalOrderItemMapper.insertOrderItem(item);
				//更新库存--拒收复送
				tSsmStockService.updateTmpStock(order.getBranchNo(),model.getMatnr(),new BigDecimal(model.getQty()),user.getSalesOrg());
				TMstRefuseResend refuseResend = resendMapper.selectRefuseResendByNo(model.getResendOrderNo());
				if(refuseResend!=null){
					//拒收复送剩余数量减去内部销售数量
					refuseResend.setRemainQty(refuseResend.getRemainQty().subtract(new BigDecimal(model.getQty())));
					//原内部销售数量加上新增数量
					refuseResend.setInsideQty(refuseResend.getInsideQty().add(new BigDecimal(model.getQty())));
					//拒收复送表更新
					resendMapper.uptRefuseResend(refuseResend);

					TMstRefuseResendItem ritem = new TMstRefuseResendItem();
					ritem.setResendOrderNo(refuseResend.getResendOrderNo());
					ritem.setOrderNo(insOrderNo);//内部销售单号
					ritem.setCreateBy(user.getLoginName());
					ritem.setCreateAt(date);
					ritem.setQty(new BigDecimal(model.getQty()));
					ritem.setType("20");//内部销售单类型为20
					//拒收复送子表添加记录
					resendItemMapper.addResendItem(ritem);
				}

			}
			tMstInsideSalOrderMapper.insertInsideSalOrder(order);

			//创建回瓶
			StockModel smodel = new StockModel();
			smodel.setBranchNo(user.getBranchNo());
			smodel.setEmpNo(cModel.getEmpNo());
			returnBoxService.craeteRetBotByStock(smodel);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有选择产品！！！！");
		}

		return 0;
	}

	/* (non-Javadoc) 
	* @title: searchOrders
	* @description: 查询路单列表
	* @param smodel
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchOrders(com.nhry.model.milk.RouteOrderSearchModel) 
	*/
	@Override
	public PageInfo searchRouteOrders(RouteOrderSearchModel smodel)
	{
		if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
		}
		smodel.setBranchNo1(userSessionService.getCurrentUser().getBranchNo());
		smodel.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		return tDispOrderMapper.searchRoutePlansByPage(smodel);
	}

	/* (non-Javadoc) 
	* @title: searchRouteDetails
	* @description: 搜索路单详情
	* @param smodel
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchRouteDetails(com.nhry.model.milk.RouteOrderSearchModel) 
	*/
	@Override
	public RouteOrderModel searchRouteDetails(String orderNo)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(orderNo);
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		List<TDispOrderItem> entries = null;
		RouteOrderModel routeModel = new RouteOrderModel();
		if(dispOrder!=null){
			TDispOrderItemKey record = new TDispOrderItemKey();
			record.setOrderNo(orderNo);
			entries = tDispOrderItemMapper.selectItemsByKeys(record);
			StringBuffer sb = new StringBuffer();
			
			try{
				//昨天的回瓶
				TDispOrder record2 = new TDispOrder();
				record2.setDispEmpNo(dispOrder.getDispEmpNo());
				record2.setBranchName(format.format(afterDate(dispOrder.getDispDate(),-1)));//日期
				record2.setReachTimeType(dispOrder.getReachTimeType());
				TDispOrder tmpDispOrder = tDispOrderMapper.selectYestodayDispOrderByEmpType10(record2);
				if(tmpDispOrder!=null){
					String yestodayOrderNo = tmpDispOrder.getOrderNo();
					//查昨日的回瓶管理
					routeModel.setRetAmt(returnBoxService.getLastDayRets(yestodayOrderNo));
				}
				
				//处理每个产品应该送多少个
				Map<String,Integer> productMap = new HashMap<String,Integer>();
				Map<String,String> productNameMap = new HashMap<String,String>();
				entries.stream().forEach((e)->{
					if(!productNameMap.containsKey(e.getMatnr())){
						productNameMap.put(e.getMatnr(), e.getMatnrTxt());
					}
					if(productMap.containsKey(e.getMatnr())){
						productMap.replace(e.getMatnr(), productMap.get(e.getMatnr()) + e.getQty().intValue());
					}else{
						productMap.put(e.getMatnr(), e.getQty().intValue());
					}
				});
				productMap.keySet().stream().forEach((e)->{
					sb.append(productNameMap.get(e) + "(" + productMap.get(e) + "),");
				});
			}catch(Exception e){
				//暂时不处理
			}
			
			//返回信息
			routeModel.setOrder(dispOrder);
			routeModel.setProducts(sb.toString());
			
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
		
		return routeModel;
	}

	@Override
	public List<TDispOrderItem> searchRouteDetailsForDeliver(String orderNo)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(orderNo);
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		List<TDispOrderItem> entries = null;

		if(dispOrder!=null){
			TDispOrderItemKey record = new TDispOrderItemKey();
			record.setOrderNo(orderNo);
			record.setOrderDate(dispOrder.getOrderDate());
			entries = tDispOrderItemMapper.selectDispItemsByKeyForDeliver(record);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}

		return entries;
	}

	/* (non-Javadoc) 
	* @title: searchRouteOrderDetail
	* @description: 搜索路单详情内详细表分页
	* @param smodel
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchRouteOrderDetail(com.nhry.model.milk.RouteOrderSearchModel) 
	*/
	@Override
	public PageInfo searchRouteOrderDetail(RouteOrderSearchModel smodel)
	{
		if(StringUtils.isEmpty(smodel.getPageNum()) || StringUtils.isEmpty(smodel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
		}
		//查询
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(smodel.getOrderNo());
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		if(dispOrder!=null){
			return tDispOrderItemMapper.selectRouteDetailsByPage(smodel);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
	}
	
	/* (non-Javadoc) 
	* @title: searchRouteOrderDetail
	* @description: 搜索路单详情内详细表不分页
	* @param smodel
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchRouteOrderDetail(com.nhry.model.milk.RouteOrderSearchModel) 
	*/
	@Override
	public List searchRouteOrderDetailAll(String code)
	{
		//查询
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(code);
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		if(dispOrder!=null){
			return tDispOrderItemMapper.selectRouteDetails(code);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
	}
	
	@Override
	public List<Map<String,String>> findOrderSumByDate(MilkQueryModel  model){
		
		if(model !=null){
			if(StringUtils.isEmpty(model.getBranchNo())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"没有奶站编号!");
			}
			if(StringUtils.isEmpty(model.getDate())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"没有时间!");
			}
			
			if(StringUtils.isEmpty(model.getLoginName())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"送奶员名称!");
			}
			//获取奶站可销售的产品
            ProductQueryModel pm = new ProductQueryModel();
            TMdBranch branch = branchService.selectBranchByNo(model.getBranchNo());
            pm.setSeting("N");
            pm.setBranchNo(branch.getBranchNo());
            pm.setDealerNo(branch.getDealerNo());
            pm.setSalesOrg(branch.getSalesOrg());
			List<TMdMara> branchSaleMaraList = productService.getBranchSaleMaraAppList(pm);
			List<Map<String, String>> List = tOrderDaliyPlanItemMapper.findOrderSumByDate(model);
			List<Map<String, String>> sortList=new ArrayList<Map<String, String>>();
			 //分奶排序:判断是否存在排序
            if(branchSaleMaraList !=null &&  branchSaleMaraList.size() >0){
            	//LinkedHashMap有序map进行排序
            	for (TMdMara tMdMara : branchSaleMaraList) {
            		//获取排序
            		String matnr = tMdMara.getMatnr();
            		Boolean falg= true;
            		for ( Map<String, String> map : List) {
						if(matnr.equals(map.get("MATNR"))){
							if("N".equals(tMdMara.getHide())){
								falg=false;
								sortList.add(map);
	            			}
						}
					}
            		//添加未有的产品
            		if(falg){
            			HashMap<String, String> hashMap = new HashMap<String,String>();
            			hashMap.put("MATNR", tMdMara.getMatnr());
            			hashMap.put("MATNR_TXT", tMdMara.getMatnrTxt());
            			hashMap.put("QTY", "");
            			sortList.add(hashMap);
            		}
				}
            }
			return sortList;
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"参数异常!");
		}
	}
	

	@Override
	public List selectRouteDetailsAllforDeliver(String code)
	{
		//查询
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(code);
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		if(dispOrder!=null){
			return tDispOrderItemMapper.selectRouteDetailsAllforDeliver(code);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
	}
	
	/* (non-Javadoc) 
	* @title: updateRouteOrder
	* @description: 更新路单状态
	* @param record
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#updateRouteOrder(com.nhry.model.milk.RouteUpdateModel) 
	*/
	@Override
	public int updateRouteOrder(RouteUpdateModel record)
	{
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(record.getOrderNo());
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		if(dispOrder!=null){
			tDispOrderMapper.updateDispOrderStatus(record.getOrderNo(),record.getStatus());
			
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: updateRouteOrderItems
	* @description: 更新路单行项目  路单如果变更产品，需要更改库存 
	* @param record
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#updateRouteOrderItems(com.nhry.model.milk.RouteUpdateModel) 
	*/
	@Override
	public int updateRouteOrderAllItems(RouteDetailUpdateListModel record)
	{
		//如果更新了送奶员，更新该路单的送奶员
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(record.getRouteNo());
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		if(dispOrder==null)throw new ServiceException(MessageCode.LOGIC_ERROR,record.getRouteNo()+"[没有此路单号!]");

		if(!dispOrder.getDispEmpNo().equals(record.getDispEmpNo())) {
			TMdBranchEmp emp = branchEmpMapper.selectBranchEmpByNo(record.getDispEmpNo());
			String oldEmp = dispOrder.getDispEmpNo() + dispOrder.getDispEmpName();
			String newEmp = record.getDispEmpNo() + emp.getEmpName();
			OperationLogUtil.saveHistoryOperation(record.getRouteNo(), LogType.ROUTE_ORDER, RouteLogEnum.DISP_EMP,newEmp,null,
					oldEmp,newEmp,null,dispOrder.getDispDate(),userSessionService.getCurrentUser(),operationLogMapper);
		}

		dispOrder.setDispEmpNo(record.getDispEmpNo());
		tDispOrderMapper.updateDispOrderEmp(dispOrder);
		tDispOrderItemMapper.updateDispOrderItemEmp(dispOrder);
		
		//更新详细项目行
		Map<String,String> productMap = productService.getMataBotTypes();
		record.getList().stream().forEach((e)->{
			updateRouteOrderItems(e,productMap);
		});
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: updateRouteOrderItems
	* @description: 更新路单行项目  路单如果变更产品，需要更改库存 
	* @param record
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#updateRouteOrderItems(com.nhry.model.milk.RouteUpdateModel) 
	*/
	@Override
	public int updateRouteOrderItems(RouteDetailUpdateModel record,Map<String,String> productMap)
	{
//		final long startTime = System.currentTimeMillis();
		
//		TDispOrderKey key = new TDispOrderKey();
//		key.setOrderNo(record.getOrderNo());
//		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
//		
//		if(dispOrder!=null){
//			Date dispDate = dispOrder.getDispDate();
			TDispOrderItemKey itemKey = new TDispOrderItemKey();
			itemKey.setOrderNo(record.getOrderNo());
			itemKey.setItemNo(record.getItemNo());
			List<TDispOrderItem> entryList = tDispOrderItemMapper.selectItemsByKeys(itemKey);
			
			if(entryList.size() > 0){
				if(!"10".equals(record.getReason()) && Integer.parseInt(record.getConfirmQty()) > entryList.get(0).getQty().intValue())throw new ServiceException(MessageCode.LOGIC_ERROR,"非换货时实际数量不能大于应送数量！");
				if("10".equals(record.getReason()) && Integer.parseInt(record.getConfirmQty()) == 0)throw new ServiceException(MessageCode.LOGIC_ERROR,"换货时数量不能是0！");
   			TDispOrderItem entry = entryList.get(0);
   			tDispOrderItemMapper.updateDispOrderItem(record , entry,productMap);
//   			//更新原订单剩余金额
//   			updatePreOrderCurAmt(entry.getOrderNo(),entry.getSalesPrice().multiply(new BigDecimal(record.getQty())));
//   			//更改路单,少送的，需要往后延期,并重新计算此后日计划的剩余金额
//   			orderService.resumeDaliyPlanForRouteOrder(record,entryList.get(0),entry,dispDate);
			}else{
				throw new ServiceException(MessageCode.LOGIC_ERROR,record.getOrderNo()+"/"+record.getItemNo()+"[没有此路单详细号!]");
			}
			
//		}else{
//			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
//		}
		
//		System.out.println("修改路单 消耗时间："+(System.currentTimeMillis()-startTime)+"毫秒");
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: updateDaliyPlanByRouteOrder
	* @description: 由更新的路单，确认后，更新日计划
	* @param record
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#updateDaliyPlanByRouteOrder(com.nhry.model.milk.RouteDetailUpdateModel) 
	*/
	@Override
	public int updateDaliyPlanByRouteOrder(String routeCode)
	{

		System.out.println(routeCode+"路单确认开始");
		final long startTime = System.currentTimeMillis();
		
		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(routeCode);
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);
		
		if(dispOrder!=null){
			if("20".equals(dispOrder.getStatus())){
				throw  new ServiceException(MessageCode.LOGIC_ERROR,"路单不能多次确认");
			}
			tDispOrderMapper.updateDispOrderStatus(routeCode,"20");
			Date dispDate = dispOrder.getDispDate();
			List<TDispOrderItem> entryList = tDispOrderItemMapper.selectNotDeliveryItemsByKeys(routeCode);
			TOrderDaliyPlanItem record = new TOrderDaliyPlanItem();

			OperationLogUtil.saveHistoryOperation(dispOrder.getOrderNo(), LogType.ROUTE_ORDER, RouteLogEnum.CONFIRM_TOUTE,dispOrder.getDispEmpNo()+dispOrder.getDispEmpName(),null,
					"未确认","确认",null,dispOrder.getDispDate(),userSessionService.getCurrentUser(),operationLogMapper);

			System.out.println(routeCode+"开始----------------");
			final long sTime = System.currentTimeMillis();

			for(TDispOrderItem e : entryList){
				//变化的也更改日计划状态
				if( (StringUtils.isNotBlank(e.getReason()) && e.getConfirmQty().intValue() < e.getQty().intValue()) || !e.getMatnr().equals(e.getConfirmMatnr())  ){
					TPlanOrderItem entry = tPlanOrderItemMapper.selectEntryByEntryNo(e.getOrgItemNo());
					//更新原订单剩余金额
					if(e.getConfirmAmt()!=null){
						updatePreOrderCurAmt(entry.getOrderNo(),e.getConfirmAmt());
					}
					//更改路单,少送的，需要往后延期,并重新计算此后日计划的剩余金额
					orderService.resumeDaliyPlanForRouteOrder(e.getConfirmQty(), e, entry, dispDate);
					//orderService.resumeDaliyPlanForRouteOrder2(e.getConfirmQty(), e, entry, dispDate);
				}else{
					//没有变化的路单更新日计划状态
					//更新原订单剩余金额
					//TPlanOrderItem entry = tPlanOrderItemMapper.selectEntryByEntryNo(e.getOrgItemNo());
					if(e.getGiftFlag()==null){
						TPreOrder order = tPreOrderMapper.selectByPrimaryKey(e.getOrgOrderNo());
						//TPreOrder order = tPreOrderMapper.selectByPrimaryKey(e.getOrgOrderNo());
						order.setCurAmt(order.getCurAmt().subtract(e.getConfirmAmt()));
						tPreOrderMapper.updateOrderCurAmt(order);

					}

					//更新日计划为确认
					record.setOrderNo(e.getOrgOrderNo());
					record.setDispDate(dispDate);
					record.setItemNo(e.getOrgItemNo());
					record.setStatus("20");
					tOrderDaliyPlanItemMapper.updateDaliyPlanItemStatus(record);
				}
			}
			System.out.println("根据路单修改日计划 消耗时间："+(System.currentTimeMillis()-startTime)+"毫秒");
			//创建回瓶管理，调用
			returnBoxService.createDayRetBox(routeCode);
			//生成内部销售订单（扣库存）调用
			createInsideSalOrder(routeCode);
			
			List<String> list = new ArrayList<String>();
			entryList.stream()
			.filter((e)->!list.contains(e.getOrgOrderNo()))
			.forEach((e)->{
				list.add(e.getOrgOrderNo());
				orderService.returnOrderRemainAmtToAcct(e.getOrgOrderNo(),dispDate);
			});
			
			//做完结订单
			List<String> oList = new ArrayList<String>();
			entryList.stream()
			.filter((e)->!oList.contains(e.getOrgOrderNo()))
			.forEach((e)->{
				oList.add(e.getOrgOrderNo());
				orderService.setOrderToFinish(e.getOrgOrderNo(),dispDate);
			});
			
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}
		
		System.out.println("路单确认总耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
		
		return 1;
	}


	/**
	 * 路单确认  优化
	 * @param routeCode
	 * @return
     */
	@Override
	public int updateDaliyPlanByRouteOrder2(String routeCode)
	{

		System.out.println(routeCode+"路单确认开始");
		final long startTime = System.currentTimeMillis();

		TDispOrderKey key = new TDispOrderKey();
		key.setOrderNo(routeCode);
		//获取路单
		TDispOrder dispOrder = tDispOrderMapper.selectByPrimaryKey(key);

		if(dispOrder!=null){
			if("20".equals(dispOrder.getStatus())){
				throw  new ServiceException(MessageCode.LOGIC_ERROR,"路单不能多次确认");
			}
			//将路单状态更新为已确认
			tDispOrderMapper.updateDispOrderStatus(routeCode,"20");
			Date dispDate = dispOrder.getDispDate();

			//获取所有的路单行
			List<TDispOrderItem> entryList = tDispOrderItemMapper.selectNotDeliveryItemsByKeys(routeCode);
			//记录日志
			TSysUser user = userSessionService.getCurrentUser();
			OperationLogUtil.saveHistoryOperation(dispOrder.getOrderNo(), LogType.ROUTE_ORDER, RouteLogEnum.CONFIRM_TOUTE,dispOrder.getDispEmpNo()+dispOrder.getDispEmpName(),null,
					"未确认","确认",null,dispOrder.getDispDate(),user,operationLogMapper);

			//记录没有发生变化的订单行项目号
			List<String> noChangeNos = new ArrayList<String>();

			System.out.println(routeCode+"开始----------------");
			final long sTime = System.currentTimeMillis();
			//保存 可以生成内部销售订单的路单行
			List<TDispOrderItem> insideOrderItems = new ArrayList<TDispOrderItem>();
			//保存 可以产生拒收复送的路单行
			List<TDispOrderItem> refuseOrderItems = new ArrayList<TDispOrderItem>();
			//记录库存数量
			Map<String,Integer>  stockMap = new HashMap<String,Integer>();
			//记录  拒收复送库存数量
			Map<String,Integer>  stockTmpMap = new HashMap<String,Integer>();
			Map<String,Object> uptMap = new HashMap<String,Object>();
			//用户记录  更新订单剩余金额
			List<TPreOrder> uptOrderCurAmt = new ArrayList<TPreOrder>();
			//循环遍历路单行
			for(TDispOrderItem e : entryList){
				//如果是损毁或者拒收（40/50），拒收复送60，则 实送数量一定要小于 应送数量
				if(("40".equals(e.getReason()) || "50".equals(e.getReason())) && e.getConfirmQty().compareTo(e.getQty())!=-1){
					throw new ServiceException(MessageCode.LOGIC_ERROR,"地址为： "+e.getAddressTxt()+"   的这条路单原因为拒收或者损毁时，送达数量必须小于数量！！！");
				}
				if(("60".equals(e.getReason())) && e.getConfirmQty().compareTo(e.getQty())!=-1){
					throw new ServiceException(MessageCode.LOGIC_ERROR,"地址为： "+e.getAddressTxt()+"   的这条路单原因为拒收复送时，送达数量必须小于数量！！！");
				}
				//变化的也更改日计划状态
				if( (StringUtils.isNotBlank(e.getReason())  && e.getConfirmQty().intValue() < e.getQty().intValue()) || !e.getMatnr().equals(e.getConfirmMatnr()) ){

					TPlanOrderItem entry = tPlanOrderItemMapper.selectEntryByEntryNo(e.getOrgItemNo());
					//更新原订单剩余金额
					if(e.getConfirmAmt()!=null){
						updatePreOrderCurAmt(entry.getOrderNo(),e.getConfirmAmt());
					}
					//更改路单,少送的，需要往后延期,并重新计算此后日计划的剩余金额
					orderService.resumeDaliyPlanForRouteOrder2(e.getConfirmQty(), e, entry, dispDate);

					if("40".equals(e.getReason()) || "50".equals(e.getReason())){
						insideOrderItems.add(e);
						//保存库存MAP
						if(!stockMap.containsKey(e.getConfirmMatnr())){
							stockMap.put(e.getConfirmMatnr(),e.getQty().intValue());
						}else{
							stockMap.replace(e.getConfirmMatnr(),stockMap.get(e.getConfirmMatnr())+e.getQty().intValue());
						}
					}else if("30".equals(e.getReason()) || "10".equals(e.getReason())){
						//保存库存MAP
						if(!stockMap.containsKey(e.getConfirmMatnr())){
							stockMap.put(e.getConfirmMatnr(),e.getQty().intValue());
						}else{
							stockMap.replace(e.getConfirmMatnr(),stockMap.get(e.getConfirmMatnr())+e.getQty().intValue());
						}
					}else if("60".equals(e.getReason())){
						refuseOrderItems.add(e);
						//保存库存MAP
						if(!stockMap.containsKey(e.getConfirmMatnr())){
							stockMap.put(e.getConfirmMatnr(),e.getQty().subtract(e.getConfirmQty()).intValue());
						}else{
							stockMap.replace(e.getConfirmMatnr(),stockMap.get(e.getConfirmMatnr())+e.getQty().subtract(e.getConfirmQty()).intValue());
						}

						//保存拒收复送库存MAP
						if(!stockTmpMap.containsKey(e.getConfirmMatnr())){
							stockTmpMap.put(e.getConfirmMatnr(),e.getConfirmQty().subtract(e.getQty()).intValue());
						}else{
							stockTmpMap.replace(e.getConfirmMatnr(),stockTmpMap.get(e.getConfirmMatnr())+e.getConfirmQty().subtract(e.getQty()).intValue());
						}
					}

				}else{
					//没有变化的路单更新日计划状态
					//更新原订单剩余金额
					//TPlanOrderItem entry = tPlanOrderItemMapper.selectEntryByEntryNo(e.getOrgItemNo());
					if(e.getGiftFlag()==null){
					/*	TPreOrder order = new TPreOrder();
						order.setOrderNo(e.getOrgOrderNo());
						order.setCurAmt(e.getConfirmAmt());
						uptOrderCurAmt.add(order);*/
						if(uptMap.size()>0){
							uptMap.replace("orderNo",e.getOrgOrderNo());
							uptMap.replace("amt",e.getConfirmAmt());
						}else{
							uptMap.put("orderNo",e.getOrgOrderNo());
							uptMap.put("amt",e.getConfirmAmt());
						}
						tPreOrderMapper.updateOrderCurAmtByOrderAndAmt(uptMap);
					}
					if(!noChangeNos.contains(e.getOrgItemNo())){
						noChangeNos.add(e.getOrgItemNo());
					}
					//保存库存MAP
					if(!stockMap.containsKey(e.getConfirmMatnr())){
						stockMap.put(e.getConfirmMatnr(),e.getConfirmQty().intValue());
					}else{
						stockMap.replace(e.getConfirmMatnr(),stockMap.get(e.getConfirmMatnr())+e.getConfirmQty().intValue());
					}
				}
			}
		/*	if(uptOrderCurAmt.size()>0){
				tPreOrderMapper.batchupdateOrderCurAmtByOrderAndAmt(uptOrderCurAmt);
			}*/

			if(noChangeNos.size()>0){
				TOrderDaliyPlanItem record = new TOrderDaliyPlanItem();
				for(String itemNo:noChangeNos){
					//更新日计划为确认
					record.setItemNo(itemNo);
					record.setDispDate(dispDate);
					record.setStatus("20");
					tOrderDaliyPlanItemMapper.updateDaliyPlanItemStatus(record);
				}
			/*	HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("dispDate",dispDate);
				map.put("status","20");
				map.put("itemNos",noChangeNos);
				tOrderDaliyPlanItemMapper.updateDaliyPlanItemStatusBatch(map);*/
			}
			//创建回瓶管理，调用
			returnBoxService.createDayRetBox(routeCode);
			//扣除库存
			if(stockMap.size()>0){
				for(String matnr : stockMap.keySet()){
					tSsmStockService.updateStock(dispOrder.getBranchNo(), matnr, new BigDecimal(stockMap.get(matnr)), user.getSalesOrg());
				}
			}
			if(stockTmpMap.size()>0){
				for(String matnr : stockTmpMap.keySet()){
					tSsmStockService.updateTmpStock(dispOrder.getBranchNo(), matnr, new BigDecimal(stockTmpMap.get(matnr)), user.getSalesOrg());
				}
			}
			//生成内部销售订单
			if(insideOrderItems.size()>0){
				createInsideSalOrderAfterConfirmRoute(insideOrderItems,dispOrder,user);
			}
			//记录拒收复送
			if(refuseOrderItems.size()>0){
				createRefuseOrderAfterConfirmRoute(refuseOrderItems,dispOrder,user);
			}
			List<String> list = new ArrayList<String>();
			entryList.stream()
					.filter((e)->!list.contains(e.getOrgOrderNo()))
					.forEach((e)->{
					TPreOrder order = tPreOrderMapper.selectByPrimaryKey(e.getOrgOrderNo());
					list.add(e.getOrgOrderNo());
					//做完结订单,并将订单余额退回订户个账
					orderService.setOrderToFinish2(order,dispDate);
			});
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此路单号!");
		}

		System.out.println("根据路单修改日计划 消耗时间："+(System.currentTimeMillis()-startTime)+"毫秒");

		return 1;
	}

	public  int createRefuseOrderAfterConfirmRoute(List<TDispOrderItem> refuseOrderItems, TDispOrder dispOrder, TSysUser user) {
		if(refuseOrderItems!=null && refuseOrderItems.size()>0){
			for(TDispOrderItem entry:refuseOrderItems){
				if("60".equals(entry.getReason()) && entry.getQty().subtract(entry.getConfirmQty()).compareTo(BigDecimal.ZERO)!=0){
					TMstRefuseResend oldResend = resendMapper.selectRefuseResendByDispEmpAndMatnr(dispOrder.getOrderNo(),dispOrder.getDispEmpNo(),entry.getConfirmMatnr());
					if(oldResend!=null){
						oldResend.setQty(oldResend.getQty().add(entry.getQty().subtract(entry.getConfirmQty())));
						oldResend.setRemainQty(oldResend.getRemainQty().add(entry.getQty().subtract(entry.getConfirmQty())));
						resendMapper.uptRefuseResend(oldResend);
					}else{
						TMstRefuseResend resend = new TMstRefuseResend();
						resend.setResendOrderNo(PrimaryKeyUtils.generateUpperUuidKey());
						resend.setBranchNo(user.getBranchNo());
						resend.setEmpNo(dispOrder.getDispEmpNo());
						resend.setQty(entry.getQty().subtract(entry.getConfirmQty()));
						resend.setRemainQty(entry.getQty().subtract(entry.getConfirmQty()));
						resend.setConfirmQty(BigDecimal.ZERO);
						resend.setInsideQty(BigDecimal.ZERO);
						resend.setMatnr(entry.getMatnr());
						resend.setStatus("10");
						resend.setSalesOrg(user.getSalesOrg());
						resend.setDispDate(entry.getOrderDate());
						resend.setDispOrderNo(entry.getOrderNo());
						resendMapper.addTMstRefuseResend(resend);
					}
				}
			}
		}
		return 1;
	}

	/**
	 * @title createDayRouteOder
	 * @description: 生成每日路单
	 * 		统计该奶站下日期下的所有的日订单，合并成多条路单，每个日订单生成一条路单行
	 * 		首先统计有多少条路单行、按送奶员及上下午为分组统计
	 * 		然后循环 查询出所有符合X送奶员 上午或下午的日订单 作为这个路单的路单行
	 * 	    最后insert
	 * @param dateStr
	 *  @see com.nhry.service.milk.dao.DeliverMilkService
     * @return
     */
	@Override
	public int createDayRouteOder(String dateStr)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TSysUser user = userSessionService.getCurrentUser();
		if(user.getBranchNo()==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"登陆人没有奶站，非奶站人员无法创建路单!");
//		Date date = afterDate(new Date(),1);
		Date date = null;
		try
		{
			date = format.parse(dateStr);
		}
		catch (ParseException e)
		{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"日期格式有误!");
		}
		if(tDispOrderMapper.selectTodayDispOrderByBranchNo(user.getBranchNo(),date).size()>0)throw new ServiceException(MessageCode.LOGIC_ERROR,format.format(date)+"该奶站已经创建过路单!");
		final long startTime = System.currentTimeMillis();
		//List<TPreOrder> empNos = tPreOrderMapper.selectDispNoByGroup(user.getBranchNo());
		//统计路单条数  统计送奶员及上下午
		List<TPreOrder> empNos = tPreOrderMapper.selectDispNoByGroup2(user.getBranchNo(),date);
		System.out.println("查询empGroup用时"+(System.currentTimeMillis()-startTime)+"毫秒");

		TDispOrder dispOrder = null;
		List<TDispOrderItem> dispEntries = null;

		Map<String,String> productMap = productService.getMataBotTypes();
		int i= 0;
		for(TPreOrder order : empNos){
			final long oneRouteStart = System.currentTimeMillis();
			System.out.println("生成一条路单开始----");
			if(StringUtils.isBlank(order.getEmpNo()))continue;

			dispOrder = new TDispOrder();
			dispEntries = new ArrayList<TDispOrderItem>();
			int totalQty = 0;
			BigDecimal totalAmt = new BigDecimal("0.00");
			//生成一条路线，一个配送时段的路单
			//List<TOrderDaliyPlanItem> daliyPlans = tOrderDaliyPlanItemMapper.selectbyDispLineNo(order.getEmpNo(),format.format(date),order.getOrderType(),user.getBranchNo());
			List<TOrderDaliyPlanItem> daliyPlans = tOrderDaliyPlanItemMapper.selectbyDispLineNo2(order.getEmpNo(),format.format(date),order.getOrderType(),user.getBranchNo());

			if(daliyPlans == null || daliyPlans.size() <= 0)continue;
				
			dispOrder.setOrderNo(PrimaryKeyUtils.generateUuidKey());
			//对每日计划的统计
			int index = 0;
			String empNo = order.getEmpNo();
			for(TOrderDaliyPlanItem plan : daliyPlans){
				i = i+1;
				TDispOrderItem item = new TDispOrderItem();
				totalQty += plan.getQty();
				totalAmt = totalAmt.add(plan.getAmt()==null?new BigDecimal("0.00"):plan.getAmt());
				//如果该行是赠品行，标记
				if(plan.getGiftQty()!=null)item.setGiftFlag("Y");
				//路单详细,一个日计划对应一行
//				if(empNo == null)empNo = plan.getLastModifiedByTxt();//配送人员id,字段临时读取,不需要再增加字段
				item.setOrderNo(dispOrder.getOrderNo());
				item.setOrderDate(date);
				item.setItemNo(String.valueOf(index));
				item.setMatnr(plan.getMatnr());
				item.setConfirmMatnr(plan.getMatnr());
				item.setUnit(plan.getUnit());
				item.setPrice(plan.getPrice());
				item.setPriceDeliver(plan.getPriceDeliver());
				item.setPriceNetValue(plan.getPriceNetValue());
				item.setPriceHome(plan.getPriceHome());
				item.setAmt(plan.getAmt());
				item.setRemainAmt(plan.getRemainAmt());
				item.setConfirmAmt(plan.getAmt());
				item.setQty(new BigDecimal(plan.getQty()));
				item.setConfirmQty(new BigDecimal(plan.getQty()));
				item.setAddressNo(plan.getCreateByTxt());//配送地址用创建人字段临时读取,不需要再增加字段
				item.setStatus("20");//取消发货，待发货，已回执
				item.setReachTimeType(plan.getReachTimeType());
				item.setOrgItemNo(plan.getItemNo());//对应原订单，订单行编号
				item.setOrgOrderNo(plan.getOrderNo());//对应原订单，订单编号
				item.setDispEmpNo(empNo);
				
				//回瓶规格
				if(productMap.containsKey(item.getMatnr())){
					if(productMap.get(item.getMatnr()).equals("10"))item.setRetQtyS(item.getQty().intValue());
					if(productMap.get(item.getMatnr()).equals("20"))item.setRetQtyM(item.getQty().intValue());
					if(productMap.get(item.getMatnr()).equals("30"))item.setRetQtyB(item.getQty().intValue());
				}
				
				dispEntries.add(item);
				index++;
			}
			//生成路单号
			dispOrder.setType("10");
			dispOrder.setAmt(totalAmt);
			dispOrder.setTotalQty(totalQty);
//			dispOrder.setDispLineNo(order.getDispLineNo());
			dispOrder.setCreateAt(new Date());
			dispOrder.setOrderDate(date);
			dispOrder.setDispDate(date);
			dispOrder.setStatus("10");//未确认
			dispOrder.setReachTimeType(order.getOrderType());
			dispOrder.setBranchNo(order.getBranchNo());
			dispOrder.setDispEmpNo(empNo);
			
			//保存日单与日单行
			tDispOrderMapper.insert(dispOrder);
			if(dispEntries.size() == 0)continue;
			tDispOrderItemMapper.batchinsert(dispEntries);
			//创建变化路单
			//createRouteChanges(dispOrder.getOrderNo(),date,empNo,dispOrder.getReachTimeType());
			System.out.println("生成一条路单一共用时"+(System.currentTimeMillis()-oneRouteStart)+"毫秒");
		}
		if(dispOrder!=null){
			OperationLogUtil.saveHistoryOperation("", LogType.ROUTE_ORDER, RouteLogEnum.CREATE_TOUTE,"",null,
					"","生成",null,dispOrder.getDispDate(),userSessionService.getCurrentUser(),operationLogMapper);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,dateStr+"  该天没有路单可以生成");
		}

		System.out.println("该奶站生成今天的所有的路单行数为"+i);
		System.out.println("生成所有路单一共用时"+(System.currentTimeMillis()-startTime)+"毫秒");
		return 1;
	}

	/* (non-Javadoc) 
	* @title: createRouteChanges
	* @description: 生成变化路单  原因代码：10 变更产品 20 变更数量 30 增加订户 40 减少订户 50 变更配送时间
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#createRouteChanges() 
	*/
	@Override
	public int createRouteChanges()//此方法暂时不用
	{
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		List<TDispOrderChangeItem> list = tDispOrderItemMapper.selectDispItemsChange("2016-06-27","2016-06-26",null);
//		
////    测试用上面的，正式用下面
////		List<TDispOrderChangeItem> list = tDispOrderItemMapper.selectDispItemsChange( format.format(new Date()), format.format(afterDate(new Date(),-1)) );
//		
//		//对比每个不一样的前今日订单生成变化单，批量保存
//		List<TDispOrderChange> saveList = new ArrayList<TDispOrderChange>();
//		for(TDispOrderChangeItem item : list){
//			TDispOrderChange change = new TDispOrderChange();
//			if(StringUtils.isBlank(item.getOrderNo1()) && StringUtils.isNotBlank(item.getOrderNo2()) ){
//				//减少订户
//				change.setReason("40");
//				change.setYestodayMatnr(item.getMatnr2());
//				change.setYestodayQty(item.getQty2());
//			}else if(StringUtils.isBlank(item.getOrderNo2()) && StringUtils.isNotBlank(item.getOrderNo1())){
//				//新增订户
//				change.setReason("30");
//				change.setTodayMatnr(item.getMatnr1());
//				change.setTodayQty(item.getQty1());
//			}else if(!item.getItemNo1().equals(item.getItemNo2())){
//				//变更产品
//				change.setReason("10");
//				change.setYestodayMatnr(item.getMatnr2());
//				change.setTodayMatnr(item.getMatnr1());
//				change.setTodayQty(item.getQty1());
//				change.setYestodayQty(item.getQty2());
//			}else if(item.getQty1().intValue() != item.getQty2().intValue()){
//				//变更数量
//				change.setReason("20");
//				change.setTodayQty(item.getQty1());
//				change.setYestodayQty(item.getQty2());
//			}else if(!item.getReachTimeType1().equals(item.getReachTimeType2())){
//				//变更配送时间
//				change.setReason("50");
//			}else{
//				continue;
//			}
//			
//			change.setYestodayReachTimeType(item.getReachTimeType2());
//			change.setTodayReachTimeType(item.getReachTimeType1());
//			change.setOrderNo(StringUtils.isNotBlank(item.getOrderNo1())?item.getOrderNo1():item.getOrderNo2());
//			change.setOrderDate(item.getOrderDate1()!=null?item.getOrderDate1():item.getOrderDate2());
//			change.setOrgOrderNo(StringUtils.isNotBlank(item.getOrgOrderNo1())?item.getOrgOrderNo1():item.getOrgOrderNo2());
//			change.setOrgItemNo(StringUtils.isNotBlank(item.getOrgItemNo1())?item.getOrgItemNo1():item.getOrgItemNo2());
//			change.setAddressNo(StringUtils.isNotBlank(item.getAddressNo1())?item.getAddressNo1():item.getAddressNo2());
//			change.setEmpNo(StringUtils.isNotBlank(item.getDispEmpNo1())?item.getDispEmpNo1():item.getDispEmpNo2());
//			
//			saveList.add(change);
//		}
//		
//		if(saveList.size()==0)return 0;
//		tDispOrderChangeMapper.batchAddNewDispOrderChanges(saveList);
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: updatePreOrderCurAmt
	* @description: 回执后更新订单的剩余金额
	* @param orderCode
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#updatePreOrderCurAmt(java.lang.String) 
	*/
	@Override
	public int updatePreOrderCurAmt(String orderNo , BigDecimal amt)
	{
//		List<TDispOrderItem> list = tDispOrderItemMapper.selectItemsByConfirmed();
//		
//		for(TDispOrderItem item : list){
			TPreOrder order = tPreOrderMapper.selectByPrimaryKey(orderNo);
			if("10".equals(order.getPaymentmethod()))return 1;//后付款的暂时不处理
			order.setCurAmt(order.getCurAmt().subtract(amt));
			tPreOrderMapper.updateOrderCurAmt(order);
//		}
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: searchRouteChangeOrder
	* @description: 获取此路单的变化路单
	* @param code
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchRouteChangeOrder(java.lang.String) 
	*/
	@Override
	public List searchRouteChangeOrder(String code)
	{
		return tDispOrderChangeMapper.searchRouteChangeOrder(code);
	}
	
	/* (non-Javadoc) 
	* @title: searchRouteChangeOrder
	* @description: 路单重新修改(行项目)
	* @param code
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#searchRouteChangeOrder(java.lang.String) 
	*/
	@Override
	public int reEditRouteDetail(RouteDetailUpdateModel item)
	{
		TDispOrderItemKey itemKey = new TDispOrderItemKey();
		itemKey.setOrderNo(item.getOrderNo());
		itemKey.setItemNo(item.getItemNo());
		List<TDispOrderItem> entryList = tDispOrderItemMapper.selectItemsByKeys(itemKey);
		TDispOrderItem entry = null;
		TSysUser sysuser = userSessionService.getCurrentUser();
				
		if(entryList.size() > 0){
			entry = entryList.get(0);
			
			//未修改任何操作
			if(!"10".equals(item.getReason()))item.setProductCode(item.getMatnr());
			if( (item.getReason()==null?"":item.getReason()).equals(entry.getReason()==null?"":entry.getReason()) && Integer.parseInt(item.getConfirmQty()) == entry.getConfirmQty().intValue() && item.getProductCode().equals(entry.getConfirmMatnr())){
				if((item.getReplaceReason()==null?"":item.getReplaceReason()).equals(entry.getReplaceReason()==null?"":entry.getReplaceReason())){
					return 0;
				}
			}
			
			if(!DateUtil.sameDateOrYestaday(new Date(),entry.getOrderDate()))throw new ServiceException(MessageCode.LOGIC_ERROR,"非今日或昨天的路单已经不能重新修改！");
			if(!"10".equals(item.getReason()) && Integer.parseInt(item.getConfirmQty()) > entry.getQty().intValue())throw new ServiceException(MessageCode.LOGIC_ERROR,"非换货时实际数量不能大于应送数量！");
			if("10".equals(item.getReason()) && Integer.parseInt(item.getConfirmQty()) == 0)throw new ServiceException(MessageCode.LOGIC_ERROR,"换货时数量不能是0！");

			Map<String, String> attrs = new HashMap<String, String>(2);
			attrs.put("matnr", entry.getConfirmMatnr());
			attrs.put("salesOrg", sysuser.getSalesOrg());
			TMdMara oldMara = tMdMaraMapper.selectProductAndExByCode(attrs);
			TDispOrder dispOrder = tDispOrderMapper.getDispOrderByNo(item.getOrderNo());
			TMdBranchEmp dispEmp = branchEmpMapper.selectBranchEmpByNo(dispOrder.getDispEmpNo());
			if (!item.getProductCode().equals(entry.getConfirmMatnr())) {
				attrs.put("matnr", item.getProductCode());
				TMdMara newMara = tMdMaraMapper.selectProductAndExByCode(attrs);
				OperationLogUtil.saveHistoryOperation(entry.getItemNo(), LogType.ROUTE_ORDER, RouteLogEnum.DISP_MATNR,dispEmp.getEmpNo()+dispEmp.getEmpName(),entry.getAddressTxt(),
						entry.getConfirmMatnr()+oldMara.getMatnrTxt(),item.getProductCode()+newMara.getMatnrTxt(),null,entry.getOrderDate(),sysuser,operationLogMapper);
			}
			if (!item.getConfirmQty().equals(entry.getConfirmQty().toBigInteger().toString())) {
				OperationLogUtil.saveHistoryOperation(entry.getItemNo(), LogType.ROUTE_ORDER, RouteLogEnum.DISP_QTY,dispEmp.getEmpNo()+dispEmp.getEmpName(),entry.getAddressTxt(),
						entry.getConfirmQty().toString(),item.getConfirmQty(),entry.getConfirmMatnr()+oldMara.getMatnrTxt(),entry.getOrderDate(),sysuser,operationLogMapper);
			}
			if (ContentDiffrentUtil.isDiffrent(item.getReason(),entry.getReason())) {
				Map<String,String> reasonMap = new HashMap<String,String>();
				reasonMap.put("10", "换货");
				reasonMap.put("20", "缺货");
				reasonMap.put("30", "质量问题");
				reasonMap.put("40", "损毁");
				reasonMap.put("50", "拒收");
				reasonMap.put("60", "拒收复送");
				OperationLogUtil.saveHistoryOperation(entry.getItemNo(), LogType.ROUTE_ORDER, RouteLogEnum.UNDELIVERED_REASON,dispEmp.getEmpNo()+dispEmp.getEmpName(),entry.getAddressTxt(),
						reasonMap.get(entry.getReason()),reasonMap.get(item.getReason()),entry.getConfirmMatnr()+oldMara.getMatnrTxt(),entry.getOrderDate(),sysuser,operationLogMapper);
			}
			if ("10".equals(item.getReason()) && !item.getReplaceReason().equals(entry.getReplaceReason())) {
				Map<String,String> reasonMap = new HashMap<String,String>();
				reasonMap.put("10", "公司原因");
				reasonMap.put("20", "质量问题");
				reasonMap.put("30", "运输损坏");
				OperationLogUtil.saveHistoryOperation(entry.getItemNo(), LogType.ROUTE_ORDER, RouteLogEnum.CHANGE_REASON,dispEmp.getEmpNo()+dispEmp.getEmpName(),entry.getAddressTxt(),
						reasonMap.get(entry.getReplaceReason()),reasonMap.get(item.getReplaceReason()),entry.getConfirmMatnr()+oldMara.getMatnrTxt(),entry.getOrderDate(),sysuser,operationLogMapper);
			}

			tDispOrderItemMapper.updateDispOrderItem(item , entry , null);
			
			//修改原日计划和原订单金额
			orderService.reEditDaliyPlansByRouteDetail(item , entry , entry.getOrderDate());
			
			List<TDispOrderItem> newEntryList = tDispOrderItemMapper.selectItemsByKeys(itemKey);
			for(TDispOrderItem e : newEntryList){
				if("Y".equals(e.getGiftFlag()))break;
				//变化的也更改日计划状态
				if( (StringUtils.isNotBlank(e.getReason()) && e.getConfirmQty().intValue() < e.getQty().intValue()) || !e.getMatnr().equals(e.getConfirmMatnr())  ){
					TPlanOrderItem orderEntry = tPlanOrderItemMapper.selectEntryByEntryNo(e.getOrgItemNo());
					//更新原订单剩余金额
					if(e.getConfirmAmt()!=null){
						updatePreOrderCurAmt(entry.getOrgOrderNo(),e.getConfirmAmt());
					}
					//更改路单,少送的，需要往后延期,并重新计算此后日计划的剩余金额
					orderService.resumeDaliyPlanForRouteOrder(e.getConfirmQty(), e, orderEntry, e.getOrderDate());
				}else{
					//没有变化的路单更新日计划状态
					if(e.getGiftFlag()==null){
						TPreOrder order = tPreOrderMapper.selectByPrimaryKey(entry.getOrgOrderNo());
						order.setCurAmt(order.getCurAmt().subtract(e.getConfirmAmt()));
						tPreOrderMapper.updateOrderCurAmt(order);
					}
				}
			}
			
			//其他操作
			updateInSalOrderAndStockByUpdateDiapOrder(newEntryList.get(0) , entry);
			
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR, item.getOrderNo()+"/"+item.getItemNo()+"[没有此路单详细号!]");
		}
		
		return 1;
	}

	/**
	 * 更新路单后  修改 内部销售订单 和 库存  和 回瓶  和拒收复送
	 * @param newItem
	 * @param orgItem
     * @return
     */
	@Override
	public int updateInSalOrderAndStockByUpdateDiapOrder(TDispOrderItem newItem, TDispOrderItem orgItem) {
		TPreOrder order = tPreOrderMapper.selectByPrimaryKey(orgItem.getOrgOrderNo());
		TSysUser user = userSessionService.getCurrentUser();
		TDispOrder dispOrder = tDispOrderMapper.getDispOrderByNo(orgItem.getOrderNo());
	//修改库存
		if( "30".equals(orgItem.getReason()) || "40".equals(orgItem.getReason()) || "50".equals(orgItem.getReason())) {
			tSsmStockService.updateStock(order.getBranchNo(), orgItem.getConfirmMatnr(), orgItem.getQty().multiply(new BigDecimal(-1)), order.getSalesOrg());
		}else {
			tSsmStockService.updateStock(order.getBranchNo(), orgItem.getConfirmMatnr(), orgItem.getConfirmQty().multiply(new BigDecimal(-1)), order.getSalesOrg());
		}

		if( "30".equals(newItem.getReason()) || "40".equals(newItem.getReason()) ||"50".equals(newItem.getReason())) {
			tSsmStockService.updateStock(order.getBranchNo(), newItem.getConfirmMatnr(), newItem.getQty(), order.getSalesOrg());
		}else{
			tSsmStockService.updateStock(order.getBranchNo(), newItem.getConfirmMatnr(), newItem.getConfirmQty(), order.getSalesOrg());
		}

	//修改拒收复送
		if("60".equals(orgItem.getReason())){
			TMstRefuseResend oldResend = resendMapper.selectRefuseResendByDispEmpAndMatnr(dispOrder.getOrderNo(),dispOrder.getDispEmpNo(),orgItem.getConfirmMatnr());
			//TMstRefuseResend oldResend = resendMapper.findByBranchEmpSendDateAndMatnr(order.getBranchNo(),dispOrder.getDispEmpNo(),orgItem.getOrderDate(),orgItem.getMatnr());
			//如果 将原来的原因60(产生了拒收复送) 和 更改后的原因也是60，但是更改后变化的数量(减少的拒收复送量) 小于剩余的拒收复送量不能修改
			if(oldResend!=null){
				if("60".equals(newItem.getReason())){
					BigDecimal newResendQty = newItem.getQty().subtract(newItem.getConfirmQty());
					BigDecimal oldResendQty = orgItem.getQty().subtract(orgItem.getConfirmQty());
					BigDecimal changeQty = newResendQty.subtract(oldResendQty);
					//如果变化量  加上 剩余量 小于0 不能修改
					if(changeQty.add(oldResend.getRemainQty()).compareTo(BigDecimal.ZERO)==-1){
						throw  new ServiceException(MessageCode.LOGIC_ERROR,"不能修改，该产品做了拒收复送，并且部分已经做了要货或内部销售订单应用，剩余的数量不足以修改");
					}
					//如果变化量  加上 剩余量 大于0 可以修改(更新数量  和 库存)
					oldResend.setQty(oldResend.getQty().add(changeQty));
					oldResend.setRemainQty(oldResend.getRemainQty().add(changeQty));
					resendMapper.uptRefuseResend(oldResend);
					tSsmStockService.updateTmpStock(order.getBranchNo(),orgItem.getConfirmMatnr(),oldResendQty.subtract(newResendQty),order.getSalesOrg());
				}else{
					//将这部分删除
					BigDecimal changeQty = orgItem.getQty().subtract(orgItem.getConfirmQty());
					//如果 result =-1 要减少的量 < 剩余量  result =0 要减少的量 = 剩余量  result =1 要减少的量 > 剩余量
					int result = changeQty.subtract(oldResend.getRemainQty()).compareTo(BigDecimal.ZERO);
					if(result==1){
						throw  new ServiceException(MessageCode.LOGIC_ERROR,"不能修改，该记录剩余的数量为"+oldResend.getRemainQty().intValue()+",小于减少量"+changeQty.intValue());
					}else if(result==0 && oldResend.getConfirmQty().compareTo(BigDecimal.ZERO)==0 && oldResend.getInsideQty().compareTo(BigDecimal.ZERO)==0){
							//如果刚好相等  并且没有被应用过 删除
							TMstRefuseResend resend = new TMstRefuseResend();
							resend.setBranchNo(order.getBranchNo());
							resend.setMatnr(orgItem.getMatnr());
							resend.setEmpNo(dispOrder.getDispEmpNo());
							resend.setDispDate(orgItem.getOrderDate());
							resend.setDispOrderNo(orgItem.getOrderNo());
							resendMapper.delRefuseResendByDispAndMatnr(resend);
					}else{
						//修改
						oldResend.setQty(oldResend.getQty().subtract(changeQty));
						oldResend.setRemainQty(oldResend.getRemainQty().subtract(changeQty));
						resendMapper.uptRefuseResend(oldResend);
					}
					//将拒收复送的也改回
					tSsmStockService.updateTmpStock(order.getBranchNo(),orgItem.getConfirmMatnr(),orgItem.getQty().subtract(orgItem.getConfirmQty()),order.getSalesOrg());
				}
			}

		}else {
			if ("60".equals(newItem.getReason())) {
				TMstRefuseResend oldResend = resendMapper.selectRefuseResendByDispEmpAndMatnr(dispOrder.getOrderNo(),dispOrder.getDispEmpNo(),newItem.getConfirmMatnr());
				if(oldResend != null){
					oldResend.setRemainQty(oldResend.getRemainQty().add(newItem.getQty().subtract(newItem.getConfirmQty())));
					oldResend.setQty(oldResend.getQty().add(newItem.getQty().subtract(newItem.getConfirmQty())));
					resendMapper.uptRefuseResend(oldResend);
				}else{
					//产生拒收复送
					TMstRefuseResend resend = new TMstRefuseResend();
					resend.setResendOrderNo(PrimaryKeyUtils.generateUpperUuidKey());
					resend.setBranchNo(user.getBranchNo());
					resend.setEmpNo(dispOrder.getDispEmpNo());
					resend.setQty(newItem.getQty().subtract(newItem.getConfirmQty()));
					resend.setRemainQty(newItem.getQty().subtract(newItem.getConfirmQty()));
					resend.setConfirmQty(BigDecimal.ZERO);
					resend.setInsideQty(BigDecimal.ZERO);
					resend.setMatnr(newItem.getMatnr());
					resend.setStatus("10");
					resend.setSalesOrg(user.getSalesOrg());
					resend.setDispDate(newItem.getOrderDate());
					resend.setDispOrderNo(newItem.getOrderNo());
					resendMapper.addTMstRefuseResend(resend);
				}
				tSsmStockService.updateTmpStock(order.getBranchNo(), orgItem.getConfirmMatnr(), newItem.getConfirmQty().subtract(newItem.getQty()), order.getSalesOrg());
			}
		}
		//修改 内部销售订单
		TMstInsideSalOrder sOrder = tMstInsideSalOrderMapper.getInSalOrderByDispOrderNo(orgItem.getOrderNo());
		// 将orgItem 产生的 内部销售订单数量 去除
		if("40".equals(orgItem.getReason()) || "50".equals(orgItem.getReason())){
			Map<String,String> map = new HashMap<String,String>();
			map.put("insOrderNo",sOrder.getInsOrderNo());
			map.put("matnr",orgItem.getMatnr());
			map.put("reason",orgItem.getReason());
			map.put("itemNo",orgItem.getItemNo());
			tMstInsideSalOrderItemMapper.deleteInSalOrderItemByMap(map);
			List<TMstInsideSalOrderItem> entries = tMstInsideSalOrderItemMapper.getItemsByNo(sOrder.getInsOrderNo());
			if(entries == null || entries.size()==0){
				tMstInsideSalOrderMapper.deleteInSalOrderByDispOrderNo(sOrder.getInsOrderNo());
			}
		}
		sOrder = tMstInsideSalOrderMapper.getInSalOrderByDispOrderNo(newItem.getOrderNo());
		//如果有拒收、损毁，新增
		if("40".equals(newItem.getReason()) || "50".equals(newItem.getReason())){
			TMdBranch branch = branchService.selectBranchByNo(order.getBranchNo());
			EmpQueryModel sModel =new  EmpQueryModel();
			sModel.setBranchNo(order.getBranchNo());
			sModel.setRoleId("10002");
			List<TMdBranchEmp> tbList = branchEmpService.queryBranchEmp(sModel);
			if(tbList.size()==0){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"此奶站没有奶站站长，请维护！！！！");
			}else if(tbList.size()>1) {
				throw new ServiceException(MessageCode.LOGIC_ERROR, "此奶站有多个奶站站长，请维护！！！！");
			}
			if(sOrder == null){
				String insOrderNo = PrimaryKeyUtils.generateUuidKey();
				sOrder = new TMstInsideSalOrder();
				sOrder.setInsOrderNo(insOrderNo);
				sOrder.setOrderDate(orgItem.getOrderDate());
				sOrder.setDispOrderNo(orgItem.getOrderNo());
				sOrder.setBranchNo(order.getBranchNo());
				if("20".equals(branch.getTargetPerson())){
					for(TMdBranchEmp item:tbList ){
						sOrder.setSalEmpNo(item.getEmpNo());
					}
				}else{
					sOrder.setSalEmpNo(dispOrder.getDispEmpNo());
				}
				sOrder.setCreateAt(newItem.getOrderDate());
				sOrder.setCreateBy(user.getLoginName());
				tMstInsideSalOrderMapper.insertInsideSalOrder(sOrder);
			}
			TMstInsideSalOrderItem item = new TMstInsideSalOrderItem();
			item.setInsOrderNo(sOrder.getInsOrderNo());
			item.setItemNo(newItem.getItemNo());
			item.setOrgOrderNo(newItem.getOrgOrderNo());
			item.setMatnr(newItem.getMatnr());
			item.setOrderDate(newItem.getOrderDate());
			item.setPrice(newItem.getPrice());
			item.setQty(newItem.getQty().subtract(newItem.getConfirmQty()));
			item.setReason(newItem.getReason());
			tMstInsideSalOrderItemMapper.insertOrderItem(item);
		}
		//修改回瓶

		//如果原 行产品 需要回瓶 则更新
		TMdMaraEx oldEx = productService.getMaraExByMatnrAndSalesOrg(orgItem.getMatnr(),order.getSalesOrg());
		if("Y".equals(oldEx.getRetBotFlag())){
			TRecBotDetail detail = returnBoxService.getTRecBotDetailByDispOrderNo(orgItem.getOrderNo(),oldEx.getBotType());
			if("20".equals(detail.getStatus())){
				throw  new ServiceException("该路单行已产品回瓶，不能修改");
			}
			detail.setReceiveNum(detail.getReceiveNum() - orgItem.getConfirmQty().intValue());
			returnBoxService.uptBoxReturnDetail(detail);
		}
		//如果新 行产品 需要回瓶 则更新
		TMdMaraEx newEx = productService.getMaraExByMatnrAndSalesOrg(newItem.getMatnr(),order.getSalesOrg());
		if("Y".equals(newEx.getRetBotFlag())){
			TRecBotDetail detail = returnBoxService.getTRecBotDetailByDispOrderNo(orgItem.getOrderNo(),newEx.getBotType());
			if(detail == null){
				TRecBotDetail bot = new TRecBotDetail();
				bot.setEmpNo(dispOrder.getDispEmpNo());
				bot.setDispOrderNo(newItem.getOrderNo());
				bot.setCreateAt(newItem.getOrderDate());
				bot.setCreateBy(user.getLoginName());
				bot.setCreateByTxt(user.getDisplayName());
				bot.setStatus("10");
				bot.setDetLsh(PrimaryKeyUtils.generateUuidKey());
				returnBoxService.addRecBotItem(bot);
			}else{
				detail.setReceiveNum(detail.getReceiveNum() + newItem.getConfirmQty().intValue());
				returnBoxService.uptBoxReturnDetail(detail);
			}
		}

		return 1;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//日期往前后加n天
	private Date afterDate(Date date, int days) {

		Calendar aCalendar =  Calendar.getInstance();
		aCalendar.setTime(date);
		aCalendar.add(aCalendar.DATE, days);//把日期往后增加一天.整数往后推,负数往前移动
		date=aCalendar.getTime();   //这个时间就是日期往后推一天的结果

		return date;
	}
	
	//一张路单，生成后，生成变化路单
	private int createRouteChanges(String orderNo,Date dispDate,String dispEmp,String reachTimeType)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<TDispOrderChangeItem> list = tDispOrderItemMapper.selectDispItemsChange(format.format(afterDate(dispDate,-1)),format.format(dispDate),orderNo,dispEmp,reachTimeType);
		
		//对比每个不一样的前今日订单生成变化单，批量保存
		List<TDispOrderChange> saveList = new ArrayList<TDispOrderChange>();
		for(TDispOrderChangeItem item : list){
			TDispOrderChange change = new TDispOrderChange();
			if(StringUtils.isBlank(item.getOrderNo1()) && StringUtils.isNotBlank(item.getOrderNo2()) ){
				//减少订户
				change.setReason("40");
			}else if(StringUtils.isBlank(item.getOrderNo2()) && StringUtils.isNotBlank(item.getOrderNo1())){
				//新增订户
				change.setReason("30");
			}else if(!item.getReachTimeType1().equals(item.getReachTimeType2())){
				//变更配送时间
				change.setReason("50");
			}else if(!item.getMatnr1().equals(item.getMatnr2())){
				//变更产品
				change.setReason("10");
			}else if(item.getQty1().intValue() != item.getQty2().intValue()){
				//变更数量
				change.setReason("20");
			}else{
				continue;
			}
			
			change.setYestodayMatnr(item.getMatnr2());
			change.setTodayMatnr(item.getMatnr1());
			change.setTodayQty(item.getQty1());
			change.setYestodayQty(item.getQty2());
			change.setYestodayReachTimeType(item.getReachTimeType2());
			change.setTodayReachTimeType(item.getReachTimeType1());
			//
			change.setOrderNo(orderNo);
			change.setOrderDate(dispDate);
			change.setOrgOrderNo(StringUtils.isNotBlank(item.getOrgOrderNo1())?item.getOrgOrderNo1():item.getOrgOrderNo2());
			change.setOrgItemNo(StringUtils.isNotBlank(item.getOrgItemNo1())?item.getOrgItemNo1():item.getOrgItemNo2());
			change.setAddressNo(StringUtils.isNotBlank(item.getAddressNo1())?item.getAddressNo1():item.getAddressNo2());
			change.setEmpNo(StringUtils.isNotBlank(item.getDispEmpNo1())?item.getDispEmpNo1():item.getDispEmpNo2());
			
			saveList.add(change);
		}
		
		if(saveList.size()==0)return 0;
		tDispOrderChangeMapper.batchAddNewDispOrderChanges(saveList);
		
		return 1;
	}

	/* (non-Javadoc) 
	* @title: createDispOrderdayliy
	* @description: 定时生成路单
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#createDispOrderdayliy() 
	*/
	@Override
	public int createDispOrderdayliy()
	{
		System.out.print("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq-----------------------------------------");
		return 0;
	}

	/* (non-Javadoc) 
	* @title: deleteDispOrderByDate
	* @description: 删除指定日期和奶站的路单，有确认是不允许删除
	* @param date
	* @return 
	* @see com.nhry.service.milk.dao.DeliverMilkService#deleteDispOrderByDate(java.lang.String) 
	*/
	@Override
	public int deleteDispOrderByDate(String date)
	{
		if(userSessionService.getCurrentUser().getBranchNo()==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"登陆人没有奶站，非奶站人员无法删除路单!");
		List<TDispOrder> list = tDispOrderMapper.selectConfirmedDispOrderByDate(userSessionService.getCurrentUser().getBranchNo(), date);
		if(list==null||list.size()<=0)throw new ServiceException(MessageCode.LOGIC_ERROR,"没有需要删除的路单!");
		if(list.stream().anyMatch((e)->"20".equals(e.getStatus())))throw new ServiceException(MessageCode.LOGIC_ERROR, date + " 此日期有确认的路单，不能删除!");
		List<String> newList = new ArrayList<String>();
		list.stream().forEach((e)->{
			newList.add(e.getOrderNo());
		});
		//tDispOrderChangeMapper.deleteDispOrderChangeByOrderNo(newList);
		tDispOrderItemMapper.deleteDispOrderItemByOrderNo(newList);
		tDispOrderMapper.deleteDispOrderByOrderNo(newList);
		try {
			OperationLogUtil.saveHistoryOperation("", LogType.ROUTE_ORDER, RouteLogEnum.DELETE_TOUTE,"",null,
                    "","删除",null,new SimpleDateFormat("yyyy-MM-dd").parse(date),userSessionService.getCurrentUser(),operationLogMapper);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return 1;
	}

	@Override
	public List<DispOrderReportEntityModel> reportDispOrderItemByParams(DispOrderReportModel model) {
		if(org.apache.commons.lang.StringUtils.isEmpty(model.getBranchNo())){
			model.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		}
		return tDispOrderItemMapper.reportDispOrderItemByParams(model);
	}

	@Override
	public List<OrderDaliyPlanReportEntityModel> reportOrderDaliyPlanByParams(OrderDaliyPlanReportModel model) {
		if(org.apache.commons.lang.StringUtils.isEmpty(model.getBranchNo())){
			model.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		}
		return tOrderDaliyPlanItemMapper.reportOrderDaliyPlanByParams(model);
	}

	/**
	 * 生成临时路单
	 * 临时路单：是在该日期下的路单已经生成的情况下，又有新的订单生成造成这些订单该日期下的日订单没有统计到路单中
	 * 此时不想删除路单重新生成，此时可以将在这些订单的范围内统计生成临时路单，逻辑和生成路单一致，只是范围
	 * 不是该奶站下所有的日订单 只限制为输入的订单
	 * @param tModel
	 * @return
     */
	@Override
	public int createTemRouteOrders(TemporaryDispOrderModel tModel) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TSysUser user = userSessionService.getCurrentUser();
		if (user.getBranchNo() == null)
			throw new ServiceException(MessageCode.LOGIC_ERROR, "登陆人没有奶站，非奶站人员无法创建路单!");
		String dateStr = tModel.getDateStr();
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			throw new ServiceException(MessageCode.LOGIC_ERROR, "日期格式有误!");
		}
		List<TDispOrder> dispOrders = tDispOrderMapper.selectDispOrderByBranchNoAndDay(user.getBranchNo(),date);
		if(dispOrders == null || dispOrders.size()==0){
			throw  new ServiceException(MessageCode.LOGIC_ERROR,format.format(date)+"的路单还未生成，您可以直接生成路单");
		}
		// 判断这些订单是否已经有订单生成了路单
		List<String> orderNos = tModel.getOrders();
		StringBuffer  hadDispNos = new StringBuffer("");
		StringBuffer  errOrderNos = new StringBuffer("");
		StringBuffer  statusOrderNos = new StringBuffer("");
		for(String orderNo : orderNos){
			if(tDispOrderItemMapper.selectCountByOrgOrderAndDate(orderNo,date) > 0){
				hadDispNos.append(orderNo+",");
			}
			List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectDaliyPlanByOrderAndDispDate(orderNo,date);
			if(items == null){
				errOrderNos.append(orderNo+", ");
			}else{
				if(items.stream().allMatch(e->"30".equals(e.getStatus()))){
					statusOrderNos.append(orderNo+", ");
				}
			}
		}
		if(StringUtils.isNotBlank(hadDispNos.toString().trim()) || StringUtils.isNotBlank(errOrderNos.toString().trim())
				||StringUtils.isNotBlank(statusOrderNos.toString().trim())){
			String wrongStr = "";
			if(StringUtils.isNotBlank(hadDispNos.toString().trim())){
				wrongStr = wrongStr +hadDispNos.toString()+"  这些订单在"+dateStr+"这天的日订单已经生成过路单<br/>";
			}
			if(StringUtils.isNotBlank(errOrderNos.toString().trim())){
				wrongStr = wrongStr +errOrderNos.toString()+"  这些订单在"+dateStr+"这天的日订单不存在<br/>";
			}
			if(StringUtils.isNotBlank(statusOrderNos.toString().trim())){
				wrongStr = wrongStr + statusOrderNos.toString()+"  这些订单在"+dateStr+"这天，没有在订的日订单了<br/>";
			}
			throw new ServiceException(MessageCode.LOGIC_ERROR,wrongStr);
		}




			//List<TPreOrder> empNos = tPreOrderMapper.selectDispNoByGroupAndOrders(userSessionService.getCurrentUser().getBranchNo(), orderNos);
		List<TPreOrder> empNos = tPreOrderMapper.selectDispNoByGroupAndOrders2(user.getBranchNo(),date, orderNos);

			TDispOrder dispOrder = null;
			List<TDispOrderItem> dispEntries = null;
			Map<String, String> productMap = productService.getMataBotTypes();
			for (TPreOrder order : empNos) {
				if (StringUtils.isBlank(order.getEmpNo())) continue;
				dispOrder = new TDispOrder();
				dispEntries = new ArrayList<TDispOrderItem>();
				int totalQty = 0;
				BigDecimal totalAmt = new BigDecimal("0.00");
				//生成一条路线，一个配送时段的路单
				List<TOrderDaliyPlanItem> daliyPlans = tOrderDaliyPlanItemMapper.selectbyDispLineNoByOrderNos(order.getEmpNo(), format.format(date), order.getOrderType(), user.getBranchNo(), orderNos);
				if (daliyPlans == null || daliyPlans.size() <= 0) continue;
				dispOrder.setOrderNo(PrimaryKeyUtils.generateUuidKey());
				//对每日计划的统计
				int index = 0;
				String empNo = order.getEmpNo();
				for (TOrderDaliyPlanItem plan : daliyPlans) {
					TDispOrderItem item = new TDispOrderItem();
					totalQty += plan.getQty();
					totalAmt = totalAmt.add(plan.getAmt() == null ? new BigDecimal("0.00") : plan.getAmt());

					//如果该行是赠品行，标记
					if (plan.getGiftQty() != null) item.setGiftFlag("Y");
					//路单详细,一个日计划对应一行
//				if(empNo == null)empNo = plan.getLastModifiedByTxt();//配送人员id,字段临时读取,不需要再增加字段
					item.setOrderNo(dispOrder.getOrderNo());
					item.setOrderDate(date);
					item.setItemNo(String.valueOf(index));
					item.setMatnr(plan.getMatnr());
					item.setConfirmMatnr(plan.getMatnr());
					item.setUnit(plan.getUnit());
					item.setPrice(plan.getPrice());
					item.setAmt(plan.getAmt());
					item.setRemainAmt(plan.getRemainAmt());
					item.setConfirmAmt(plan.getAmt());
					item.setQty(new BigDecimal(plan.getQty()));
					item.setConfirmQty(new BigDecimal(plan.getQty()));
					item.setAddressNo(plan.getCreateByTxt());//配送地址用创建人字段临时读取,不需要再增加字段
					item.setStatus("20");//取消发货，待发货，已回执
					item.setReachTimeType(plan.getReachTimeType());
					item.setOrgItemNo(plan.getItemNo());//对应原订单，订单行编号
					item.setOrgOrderNo(plan.getOrderNo());//对应原订单，订单编号
					item.setDispEmpNo(empNo);

					//回瓶规格
					if (productMap.containsKey(item.getMatnr())) {
						if (productMap.get(item.getMatnr()).equals("10")) item.setRetQtyS(item.getQty().intValue());
						if (productMap.get(item.getMatnr()).equals("20")) item.setRetQtyM(item.getQty().intValue());
						if (productMap.get(item.getMatnr()).equals("30")) item.setRetQtyB(item.getQty().intValue());
					}

					dispEntries.add(item);
					index++;
				}

				//生成临时路单号
				dispOrder.setType("20");
				dispOrder.setAmt(totalAmt);
				dispOrder.setTotalQty(totalQty);
				dispOrder.setOrderDate(date);
				dispOrder.setDispDate(date);
				dispOrder.setStatus("10");//未确认
				dispOrder.setReachTimeType(order.getOrderType());
				dispOrder.setBranchNo(order.getBranchNo());
				dispOrder.setDispEmpNo(empNo);
				//保存日单与日单行
				tDispOrderMapper.insert(dispOrder);
				if (dispEntries.size() == 0) continue;
				tDispOrderItemMapper.batchinsert(dispEntries);
			}

			return 1;
		}
}
