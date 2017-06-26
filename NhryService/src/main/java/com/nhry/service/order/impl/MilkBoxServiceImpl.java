package com.nhry.service.order.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdBranchEmp;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.task.TaskExecutor;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.order.dao.TMilkboxPlanMapper;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TMilkboxPlan;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.order.MilkboxCreateModel;
import com.nhry.model.order.MilkboxSearchModel;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.service.BaseService;
import com.nhry.service.external.dao.EcService;
import com.nhry.service.order.dao.MilkBoxService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.order.dao.PromotionService;

public class MilkBoxServiceImpl extends BaseService implements MilkBoxService
{
	private TMilkboxPlanMapper tMilkboxPlanMapper;
	private TPreOrderMapper tPreOrderMapper;
	private TMdBranchEmpMapper branchEmpMapper;
	private OrderService orderService;
	private PromotionService promotionService;
	private TPlanOrderItemMapper tPlanOrderItemMapper;
	private TaskExecutor taskExecutor;
	private EcService messLogService;
	
	public void setMessLogService(EcService messLogService)
	{
		this.messLogService = messLogService;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor)
	{
		this.taskExecutor = taskExecutor;
	}
	
	public void settPlanOrderItemMapper(TPlanOrderItemMapper tPlanOrderItemMapper)
	{
		this.tPlanOrderItemMapper = tPlanOrderItemMapper;
	}
	public void setPromotionService(PromotionService promotionService)
	{
		this.promotionService = promotionService;
	}
	public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper)
	{
		this.branchEmpMapper = branchEmpMapper;
	}
	public void settPreOrderMapper(TPreOrderMapper tPreOrderMapper)
	{
		this.tPreOrderMapper = tPreOrderMapper;
	}
	public void settMilkboxPlanMapper(TMilkboxPlanMapper tMilkboxPlanMapper)
	{
		this.tMilkboxPlanMapper = tMilkboxPlanMapper;
	}
	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}

	/* (non-Javadoc) 
	* @title: searchMilkBox
	* @description: 查询奶箱列表
	* @param smodel
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#searchMilkBox(com.nhry.model.order.OrderSearchModel) 
	*/
	@Override
	public PageInfo searchMilkBox(MilkboxSearchModel smodel)
	{	
		smodel.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		smodel.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		return tMilkboxPlanMapper.selectMilkboxsByPage(smodel);
	}
	
	/* (non-Javadoc) 
	* @title: selectMilkboxByPlanNo
	* @description: 根据装箱单号查详细
	* @param code
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#selectMilkboxByPlanNo(java.lang.String) 
	*/
	@Override
	public TMilkboxPlan selectMilkboxByPlanNo(String code)
	{
		return tMilkboxPlanMapper.selectByPrimaryKey(code);
	}

	/* (non-Javadoc) 
	* @title: addNewMilkboxPlan
	* @description: 创建新的奶箱工单
	* @param record
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#addNewMilkboxPlan(com.nhry.data.order.domain.TMilkboxPlan) 
	*/
	@Override
	public int addNewMilkboxPlan(MilkboxCreateModel model)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		TPreOrder order = tPreOrderMapper.selectByPrimaryKey(model.getCode());
		if(order!=null){
			TMilkboxPlan record = new TMilkboxPlan();
			//新增一个奶箱工单
			//装箱单号，现在临时生成
			Date date = new Date();
			record.setPlanNo(String.valueOf(date.getTime()));
			record.setOrderNo(order.getOrderNo());
			record.setAdressNo(order.getAdressNo());
			record.setBranchNo(order.getBranchNo());
			record.setCreateAt(new Date());
			record.setCreateBy(userSessionService.getCurrentUser().getLoginName());
			record.setCreateByTxt(userSessionService.getCurrentUser().getDisplayName());
			record.setEmpNo(order.getEmpNo());

			TMdBranchEmp branch = branchEmpMapper.selectBranchEmpByNo(order.getEmpNo());
			record.setEmpName(null!=branch?branch.getEmpName():"");
			record.setMemberNo(order.getMilkmemberNo());
			//保存订户的具体信息
//			record.setMemberNo(memberNo);
//			record.setMemberName(memberName);
//			record.setMemberTel(memberTel);
			//输入的装箱状态和付款状态
			record.setMilkboxStat(StringUtils.isNotBlank(model.getStatus())?model.getStatus():order.getMilkboxStat());
			record.setPaymentStat(StringUtils.isNotBlank(model.getPaymentStatus())?model.getPaymentStatus():order.getPaymentStat());
			//计划安装日期
			try
			{
				if(model.getSetDate()!=null ){
					record.setPlanDate(model.getSetDate());
				}else{
					record.setPlanDate(afterDate(new Date(),1));
				}
			}
			catch (Exception e)
			{
				throw new ServiceException(MessageCode.LOGIC_ERROR, "日期格式不正确！");
			}
			
			tMilkboxPlanMapper.insert(record);
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订单不存在！");
		}
	
		return 1;
	}

	/* (non-Javadoc) 
	* @title: updateMilkboxStatus
	* @description: 更新装箱工单
	* @param model
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#updateMilkboxStatus(com.nhry.model.order.MilkboxSearchModel) 
	*/
	@Override
	public int updateMilkboxStatus(MilkboxCreateModel model)
	{
		TMilkboxPlan plan = tMilkboxPlanMapper.selectByPrimaryKey(model.getCode());
		if(plan!=null){
			if(!"20".equals(plan.getMilkboxStat()))return 1;
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			//如果更改了原订单行的配送起始日期,要更新原来的订单
			if(model.getEntries()!=null && model.getEntries().size()>0){
				orderService.updateOrderAndEntriesDispStartDate(plan.getOrderNo(),model.getEntries());
			}
			
			TPreOrder o = new TPreOrder();
			o.setOrderNo(plan.getOrderNo());
			if(StringUtils.isNotBlank(model.getPaymentStatus())){
				plan.setPaymentStat(model.getPaymentStatus());
				o.setPaymentStat(plan.getPaymentStat());
			}
			if(StringUtils.isNotBlank(model.getStatus())){
				//关联更新订单的装箱与付款状态
				plan.setMilkboxStat(model.getStatus());
				o.setMilkboxStat(plan.getMilkboxStat());
				tPreOrderMapper.updateOrderStatus(o);
				
				//预付款的订单要付款+装箱才生成日计划
				OrderCreateModel omodel = orderService.selectOrderByCode(plan.getOrderNo());
				if(!"20".equals(plan.getMilkboxStat()) ){
					if( ("20".equals(omodel.getOrder().getPaymentmethod()) && "20".equals(omodel.getOrder().getPaymentStat())) || !"20".equals(omodel.getOrder().getPaymentmethod()) ){
						//生成每日计划
						List<TOrderDaliyPlanItem> list = orderService.createDaliyPlan(omodel.getOrder(), omodel.getEntries());
						//如果有赠品，生成赠品的日计划
						promotionService.createDaliyPlanByPromotion(omodel.getOrder(), omodel.getEntries() ,list);
						
						//发送EC,更新订单状态
	       			TPreOrder sendOrder = new TPreOrder();
	       			sendOrder.setOrderNo(omodel.getOrder().getOrderNo());
	       			sendOrder.setPreorderStat("200");
	       			sendOrder.setEmpNo(omodel.getOrder().getEmpNo());
	       			taskExecutor.execute(new Thread(){
	       				@Override
	       				public void run() {
	       					super.run();
	       					this.setName("updateOrderStatus");
	       					messLogService.sendOrderStatus(sendOrder);
	       				}
	       			});
	       			
					}
				}
			}
			if(model.getSetDate()!=null){
				plan.setPlanDate(model.getSetDate());
			}
			plan.setLastModified(new Date());
			plan.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
			plan.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR, "装箱单不存在！");
		}
		
		return tMilkboxPlanMapper.updateMilkboxPlan(plan);
	}

	/* (non-Javadoc) 
	* @title: updateMilkboxStatusByList
	* @description: 批量更新装箱工单的状态           已装箱,无需装箱
	* @param model
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#updateMilkboxStatusByList(com.nhry.model.order.MilkboxCreateModel) 
	*/
	@Override
	public int updateMilkboxStatusByList(MilkboxCreateModel model)
	{
		List<String> orderCodes = Arrays.asList(model.getCode().split(","));
		
		orderCodes.stream().forEach((e)->{
			model.setCode(e);
			updateMilkboxStatus(model);
		});
		
		return 1;
	}
	
	/* (non-Javadoc) 
	* @title: updateMilkboxPlanPrinted
	* @description: 打印工单后标记
	* @param code
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#updateMilkboxPlanPrinted(java.lang.String) 
	*/
	@Override
	public int updateMilkboxPlanPrinted(String code)
	{
		return tMilkboxPlanMapper.updateMilkboxPlanPrinted(code);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//日期往前后加n天
	private Date afterDate(Date date, int days) {

		Calendar aCalendar =  Calendar.getInstance();
		aCalendar.setTime(date);
		aCalendar.add(aCalendar.DATE, days);//把日期往后增加一天.整数往后推,负数往前移动
		date=aCalendar.getTime();   //这个时间就是日期往后推一天的结果

		return date;
	}

	/**
	 * 查询奶箱列表不分页,用于导出报表
	 * @param empNo
	 * @return smodel
     */
	@Override
	public List findMilkBox(String empNo)
	{
		return tMilkboxPlanMapper.searchMilkBox(empNo);
	}

	/* (non-Javadoc) 
	* @title: deleteMilkBoxByOrderNo
	* @description: 
	* @param code
	* @return 
	* @see com.nhry.service.order.dao.MilkBoxService#deleteMilkBoxByOrderNo(java.lang.String) 
	*/
	@Override
	public int deleteMilkBoxByOrderNo(String code)
	{
		return tMilkboxPlanMapper.deleteMilkBoxByOrderNo(code);
	}

	@Override
	public int selectMilkboxsCount(){
		return tMilkboxPlanMapper.selectMilkboxsCount(userSessionService.getCurrentUser().getBranchNo());
	}
}
