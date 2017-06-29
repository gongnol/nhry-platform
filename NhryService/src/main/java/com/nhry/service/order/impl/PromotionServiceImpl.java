package com.nhry.service.order.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.dao.TPromotionMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.data.promotion.dao.PromotionConItemMapper;
import com.nhry.data.promotion.dao.PromotionGiftItemMapper;
import com.nhry.data.promotion.dao.PromotionOrigItemMapper;
import com.nhry.data.promotion.dao.PromotionScopeItemMapper;
import com.nhry.data.promotion.domain.PromotionConItem;
import com.nhry.data.promotion.domain.PromotionGiftItem;
import com.nhry.data.promotion.domain.PromotionOrigItem;
import com.nhry.data.promotion.domain.PromotionScopeItem;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.PromSearchModel;
import com.nhry.model.order.PromotionOrderModel;
import com.nhry.model.order.PromotionPlanDetail;
import com.nhry.model.order.TPromotionModel;
import com.nhry.model.order.TPromotionOrderModel;
import com.nhry.rest.basic.PromAllocatModel;
import com.nhry.rest.basic.PromTionItemModel;
import com.nhry.rest.basic.PromtionAddModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.impl.BranchServiceImpl;
import com.nhry.service.order.dao.PromotionService;
import com.nhry.utils.DateUtil;
import com.nhry.utils.PromNoUtil;

public class PromotionServiceImpl extends BaseService implements PromotionService
{
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private TPromotionMapper tPromotionMapper;
	private TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper;
	private OrderServiceImpl orderService;
	
    private PromotionOrigItemMapper promotionOrigItemMapper;
    private PromotionConItemMapper promotionConItemMapper;
    private PromotionGiftItemMapper promotionGiftItemMapper;
    private PromotionScopeItemMapper promotionScopeItemMapper;
    
    private BranchServiceImpl branchService;
    
    


	public void setBranchService(BranchServiceImpl branchService) {
		this.branchService = branchService;
	}

	public void setPromotionOrigItemMapper(PromotionOrigItemMapper promotionOrigItemMapper) {
		this.promotionOrigItemMapper = promotionOrigItemMapper;
	}

	public void setPromotionConItemMapper(PromotionConItemMapper promotionConItemMapper) {
		this.promotionConItemMapper = promotionConItemMapper;
	}

	public void setPromotionGiftItemMapper(PromotionGiftItemMapper promotionGiftItemMapper) {
		this.promotionGiftItemMapper = promotionGiftItemMapper;
	}

	public void setPromotionScopeItemMapper(PromotionScopeItemMapper promotionScopeItemMapper) {
		this.promotionScopeItemMapper = promotionScopeItemMapper;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

	public void settPromotionMapper(TPromotionMapper tPromotionMapper)
	{
		this.tPromotionMapper = tPromotionMapper;
	}
	public void settOrderDaliyPlanItemMapper(TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper)
	{
		this.tOrderDaliyPlanItemMapper = tOrderDaliyPlanItemMapper;
	}

	/* (non-Javadoc) 
	* @title: selectPromotionsrsByPage
	* @description: 查询销售组织下的所有促销规则
	* @param smodel
	* @return 
	* @see com.nhry.service.order.dao.PromotionService#selectPromotionsrsByPage(com.nhry.model.order.OrderSearchModel) 
	*/
	@Override
	public PageInfo selectPromotionsrsByPage(OrderSearchModel smodel)
	{
		smodel.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		smodel.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		return tPromotionMapper.selectPromotionsrsByPage(smodel);
	}

	/* (non-Javadoc) 
	* @title: getPromotionByMatnr
	* @description: 根据选择的商品号查询促销信息
	* @param code
	* @return 
	* @see com.nhry.service.order.dao.PromotionService#getPromotionByMatnr(java.lang.String) 
	*/
	@Override
	public List<TPromotion> getPromotionByMatnr(String code)
	{

		TPromotion record = new TPromotion();
		record.setOrgMatnr(code);
		record.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		record.setCreateBy(format.format(new Date()));
		return tPromotionMapper.selectPromotionByMatnr(record);
	}

	/* (non-Javadoc) 
	* @title: selectPromotionByPromNo
	* @description: 根据促销号查询唯一的促销信息
	* @param code
	* @return 
	* @see com.nhry.service.order.dao.PromotionService#selectPromotionByPromNo(java.lang.String) 
	*/
	@Override
	public TPromotion selectPromotionByPromNo(String code)
	{
		TPromotion record = new TPromotion();
		record.setPromNo(code);
		record.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		return tPromotionMapper.selectPromotionByPromNo(record);
	}

	/**
	 * 行项目促销  满赠和满减
	 * @param entry    			订单行
	 * @param entryAmount			订单行总金额
	 * @param order				订单
     */
	@Override
	public void calculateOrderEntryPromotion(TPlanOrderItem entry,BigDecimal entryAmount, TPreOrder order) {
		if(StringUtils.isBlank(entry.getPromotion()) )return;
		if(StringUtils.isBlank(entry.getPromItemNo()))return;
		TPromotion promotion = selectPromotionByPromNoAndItemNo(entry.getPromotion(),entry.getPromItemNo());
		if(promotion==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此促销!");
		if(promotion.getBuyStartTime().after(entry.getStartDispDate()) || promotion.getBuyStopTime().before(entry.getEndDispDate())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,entry.getMatnr()+"产品的促销,只能在"+promotion.getBuyStartTime().toString()+"到"+promotion.getBuyStopTime()+"之间订购!");
		}
		//处理,满赠,满n个a产品赠m个b产品
		if("Z008".equals(promotion.getPromSubType())){
			if(StringUtils.isNotBlank(entry.getGiftMatnr()) || promotion.getGiftQty()==null)return;
			//int giftQty = entry.getBuyQty()/promotion.getOrgQty().intValue()*promotion.getGiftQty().intValue();
			//if(giftQty<=0)throw new ServiceException(MessageCode.LOGIC_ERROR,entry.getMatnr()+"产品没有达到满赠要求，请修改正品数量或不参加促销!");
			entry.setGiftQty(promotion.getGiftQty().intValue());//赠送赠品的数量
			entry.setGiftMatnr(promotion.getGiftMatnr());
			entry.setGiftUnit(promotion.getGiftUnit());
		}

		//处理，满减金额...
		if("Z015".equals(promotion.getPromSubType())){
			if(entryAmount.compareTo(promotion.getLowAmt())==-1) throw new ServiceException(MessageCode.LOGIC_ERROR,"订单行总金额不足以参加促销的最低金额");
			//TODO 是否考虑阶梯
			/*BigDecimal disAmt = BigDecimal.ZERO;
			disAmt = disAmt.add(promotion.getDiscountAmt());
			order.setDiscountAmt(order.getDiscountAmt().add(disAmt));*/
		}
	}

	/**
	 *  计算订单满减金额
	 * @param order
     */
	@Override
	public  void calculateOrderPromotion(TPreOrder order){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isBlank(order.getPromotion()) )return;
		if(StringUtils.isBlank(order.getPromItemNo()))return;
		TPromotion promotion = selectPromotionByPromNoAndItemNo(order.getPromotion(),order.getPromItemNo());
		if(promotion==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此促销!");
		//满减
		if("Z016".equals(promotion.getPromSubType())){
			if(promotion.getBuyStopTime().before(order.getEndDate())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"该促销,只能在"+format.format(promotion.getBuyStartTime())+"到"+format.format(promotion.getBuyStopTime())+"之间订购!");
			}
			if(promotion.getLowAmt().compareTo(order.getInitAmt())==1) throw new ServiceException(MessageCode.LOGIC_ERROR,"该订单总金额不足以参加满减促销，该促销最少金额为"+promotion.getLowAmt()+",而该订单总金额只有"+order.getInitAmt());
		}
	}
	@Override
	public List<TPromotionModel> selectProCreatOrder(OrderCreateModel record) {
		TPreOrder order = record.getOrder();
		//后付款的不参加促销
		if("10".equals(order.getPaymentStat())){
			return null;
		}
		//机构订单
		if("70".equals(order.getPreorderSource())){
			return null;
		}
		TSysUser user = userSessionService.getCurrentUser();
		if(StringUtils.isBlank(order.getBranchNo())){
			order.setBranchNo(user.getBranchNo());
		}
		order.setSalesOrg(user.getSalesOrg());
		List<TPromotionModel> result = new ArrayList<TPromotionModel>();
		ArrayList<TPlanOrderItem> entries = record.getEntries();
		//生成每个订单行 2
		int index = 0;
		BigDecimal orderAmt = new BigDecimal("0.00");//订单总价
		Date startDate = null;
		Date endDate = null;
		for(TPlanOrderItem entry: entries){
			try
			{
				entry.setStartDispDate(format.parse(entry.getStartDispDateStr()));
				if(startDate==null){
					startDate = entry.getStartDispDate();
				}else{
					if(DateUtil.dateAfter(startDate,entry.getStartDispDate())){
						startDate = entry.getStartDispDate();
					}
				}
				if("20".equals(order.getPaymentmethod())){
					orderService.resolveEntryEndDispDate(entry);
				}else{
					entry.setEndDispDate(format.parse(entry.getEndDispDateStr()));
				}
				if(endDate==null){
					endDate = entry.getEndDispDate();
				}else{
					if(DateUtil.dateAfter(entry.getEndDispDate(),endDate)){
						endDate = entry.getEndDispDate();
					}
				}
			}
			catch (ServiceException e1){
				throw e1;
			}
			catch (Exception e)
			{
				throw new ServiceException(MessageCode.LOGIC_ERROR,"日期格式有误");
			}
			BigDecimal entryAmount = BigDecimal.ZERO;
			entryAmount = entryAmount.add(orderService.calculateEntryAmount(entry));
			entry.setEntryTotal(entryAmount);
			orderAmt = orderAmt.add(entryAmount);
			//行项目满足的促销
			TPromotion pro = new TPromotion();
			pro.setBranchNo(order.getBranchNo());
			pro.setSalesOrg(order.getSalesOrg());
			pro.setPlanStartTime(new Date());
			pro.setPlanStopTime(new Date());
			pro.setBuyStartTime(entry.getStartDispDate());
			pro.setOrgQty(new BigDecimal(entry.getDispTotal()));
			pro.setBuyStopTime(entry.getEndDispDate());
			pro.setLowAmt(entry.getEntryTotal());
			pro.setOrgMatnr(entry.getMatnr());
			List<TPromotionModel> prolist = tPromotionMapper.selectPromotionByEntryAndAmt(pro);
			if(prolist!=null && prolist.size()>0){
				prolist.stream().forEach(e->{
					e.setRowNumber(entry.getRowNum());
				});
				result.addAll(prolist);
			}
			index++;
		}

		//订单价格
		order.setCurAmt(orderAmt);
		order.setInitAmt(orderAmt);
		// 订单满足的满赠，年卡
		TPromotion pro = new TPromotion();
		pro.setBranchNo(order.getBranchNo());
		pro.setSalesOrg(order.getSalesOrg());
		pro.setPlanStartTime(new Date());
		pro.setPlanStopTime(new Date());
		pro.setBuyStartTime(startDate);
		pro.setBuyStopTime(endDate);
		pro.setLowAmt(order.getInitAmt());
		List<TPromotionModel> orderPromList = tPromotionMapper.selectPromotionsByOrder(pro);
		if(orderPromList!=null && orderPromList.size()>0){
			result.addAll(orderPromList);
		}
		return result;
	}

	//行项目促销判断
	@Override
 	public void calculateEntryPromotion(TPlanOrderItem entry){
		
		if(StringUtils.isBlank(entry.getPromotion()))return;
		if(StringUtils.isNotBlank(entry.getGiftMatnr()))return;
		if(StringUtils.isBlank(entry.getPromItemNo()))return;
 		TPromotion promotion = selectPromotionByPromNoAndItemNo(entry.getPromotion(),entry.getPromItemNo());
 		if(promotion==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此促销!");
 		if(promotion.getBuyStartTime().after(entry.getStartDispDate()) || promotion.getBuyStopTime().before(entry.getEndDispDate())){
 			throw new ServiceException(MessageCode.LOGIC_ERROR,entry.getMatnr()+"产品的促销,只能在"+promotion.getBuyStartTime().toString()+"到"+promotion.getBuyStopTime()+"之间订购!");
 		}
 		
 		//处理,满赠,满n个a产品赠m个b产品
 		if("Z008".equals(promotion.getPromType())){
 			int giftQty = entry.getBuyQty()/promotion.getOrgQty().intValue()*promotion.getGiftQty().intValue();
 			if(giftQty<=0)throw new ServiceException(MessageCode.LOGIC_ERROR,entry.getMatnr()+"产品没有达到满赠要求，请修改正品数量或不参加促销!");
 			entry.setGiftQty(giftQty);//赠送赠品的数量
 			entry.setGiftMatnr(promotion.getGiftMatnr());
 			entry.setGiftUnit(promotion.getGiftUnit());
 		}
 		
 		//处理，满减金额...
		if("Z015".equals(promotion.getPromType())){

		}
 	}

	@Override
	public TPromotion selectPromotionByPromNoAndItemNo(String promotion, String promItemNo) {
		TPromotion record = new TPromotion();
		record.setPromNo(promotion);
		record.setItemNo(promItemNo);
		record.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		return tPromotionMapper.selectPromotionByPromNoAndItemNo(record);
	}

	@Override
	public List<TPromotionModel> selYearCardPromBySalesOrg() {
		TSysUser user = userSessionService.getCurrentUser();
		if(user ==null) throw new ServiceException(MessageCode.LOGIC_ERROR,"获取不到当前登录人");
		if(StringUtils.isBlank(user.getSalesOrg())) throw new ServiceException(MessageCode.LOGIC_ERROR,"当前登录人不存在销售组织");

		TPromotion param = new TPromotion();
		param.setSalesOrg(user.getSalesOrg());
		return tPromotionMapper.selYearCardPromBySalesOrg(param);
	}

	//行项目促销判断
	@Override
 	public void calculateEntryPromotionForStop(TPlanOrderItem entry){

		if(StringUtils.isBlank(entry.getPromotion()))return;
 		//TPromotion promotion = selectPromotionByPromNo(entry.getPromotion());
		TPromotion promotion = selectPromotionByPromNoAndItemNo(entry.getPromotion(),entry.getPromItemNo());
// 		if(promotion==null)throw new ServiceException(MessageCode.LOGIC_ERROR,"没有此促销!");
 		if(promotion==null || DateUtil.dateAfter(promotion.getPlanStartTime(),entry.getStartDispDate()) || DateUtil.dateBefore(promotion.getPlanStopTime(),entry.getEndDispDate())){
 			entry.setPromotion("");
 			entry.setGiftQty(0);//赠送赠品的数量
 			entry.setGiftMatnr("");
 			entry.setGiftUnit("");
 			return;
 		}
 		
 		//处理,满赠,满n个a产品赠m个b产品
 		if("Z008".equals(promotion.getPromType())){
 			int giftQty = entry.getBuyQty()/promotion.getOrgQty().intValue()*promotion.getGiftQty().intValue();
 			if(giftQty<=0)return;
 			entry.setGiftQty(giftQty);//赠送赠品的数量
 			entry.setGiftMatnr(promotion.getGiftMatnr());
 			entry.setGiftUnit(promotion.getGiftUnit());
 		}
 		
 		//处理，满减金额...
 		//TODO
 	}
	
	//根据行项目的赠品数量生成日计划,daliyPlans已经从晚到早排好顺序
	@Override
 	public void createDaliyPlanByPromotion(TPreOrder order, List<TPlanOrderItem> entriesList,List<TOrderDaliyPlanItem> daliyPlans){
		
		//预付款的要付款+装箱才生成日计划
		if("20".equals(order.getPaymentmethod()) && !"20".equals(order.getPaymentStat())){
			return;
		}
				
		//生成每日计划,当订户订单装箱状态为已装箱或无需装箱，则系统默认该订单可生成订户日订单
		if("20".equals(order.getMilkboxStat())){
			return;
		}
		
		Map<String,TPlanOrderItem> entryMap = new HashMap<String,TPlanOrderItem>();
//		//如果是复订的
//		entriesList.stream().filter((entry)->order.getStopDateStart()!=null)
//		  .forEach((e)->{
//			  calculateEntryPromotionForStop(e);
//			  entryMap.put(e.getItemNo(), e);
//		});
		HashMap<String,Date> promDateMap = new HashMap<String,Date>();
		//需要生成促销日计划的订单行项目
		entriesList.stream().filter((entry)->StringUtils.isNotBlank(entry.getPromotion()))
								  .forEach((e)->{
		  	TPromotion prom = selectPromotionByPromNoAndItemNo(e.getPromotion(),e.getPromItemNo());
			  if(prom!=null){
				  promDateMap.put("startDate",prom.getBuyStartTime());
				  promDateMap.put("endDate",prom.getBuyStopTime());
			  }
									  entryMap.put(e.getItemNo(), e);
//									  calculateEntryPromotion(e);
		});
		
		if(entryMap.size()<=0)return;
		
		int daliyEntryNo = Integer.parseInt(daliyPlans.get(0).getPlanItemNo()) + 1;//日计划行号
		
		for(String itemNo : entryMap.keySet()){
			for(TOrderDaliyPlanItem plan : daliyPlans){
				if(plan.getItemNo().equals(itemNo)){
					TPlanOrderItem orgEntry = entryMap.get(plan.getItemNo());
					
					if(orgEntry.getGiftQty()==null) break;
					int totalGift = orgEntry.getGiftQty();
					if(totalGift<=0)break;
					if(promDateMap!=null && promDateMap.size()>0){
						if(DateUtil.dateAfter(plan.getDispDate(),promDateMap.get("endDate"))){
							throw new ServiceException(MessageCode.LOGIC_ERROR,"赠品配送日期超过促销的截止日期");
						}
						if(DateUtil.dateBefore(plan.getDispDate(),promDateMap.get("startDate"))){
							throw new ServiceException(MessageCode.LOGIC_ERROR,"赠品配送日期在促销的开始日期之前");
						}
					}
					//复制日计划
					TOrderDaliyPlanItem giftPlan = new TOrderDaliyPlanItem();
					giftPlan.setOrderNo(plan.getOrderNo());//订单编号
					giftPlan.setOrderDate(plan.getOrderDate());//订单日期
					giftPlan.setPlanItemNo(String.valueOf(daliyEntryNo));//预订单计划行项
					giftPlan.setItemNo(plan.getItemNo());//预订单日计划行
					giftPlan.setDispDate(plan.getDispDate());//配送日期
					giftPlan.setReachTimeType(plan.getReachTimeType());//送达时段类型
					giftPlan.setMatnr(orgEntry.getGiftMatnr());//产品编号
					giftPlan.setUnit(orgEntry.getGiftUnit());//配送单位
					giftPlan.setPromotionFlag(orgEntry.getPromotion());//促销号
					
					//产品数量
					if(totalGift>=plan.getQty()){
						giftPlan.setQty(plan.getQty());
					}else{
						giftPlan.setQty(totalGift);
					}
					giftPlan.setGiftQty(giftPlan.getQty());//赠品数量
					giftPlan.setStatus("10");//状态
					giftPlan.setCreateAt(new Date());//创建时间
					giftPlan.setCreateBy(userSessionService.getCurrentUser().getLoginName());//创建人
					giftPlan.setCreateByTxt(userSessionService.getCurrentUser().getDisplayName());//创建人姓名
					//机构、年卡保存分拆价格保存配送费、到户费、净值
					giftPlan.setPriceHome(plan.getPriceHome());
					giftPlan.setPriceDeliver(plan.getPriceDeliver());
					giftPlan.setPriceNetValue(plan.getPriceNetValue());
					tOrderDaliyPlanItemMapper.insert(giftPlan);
					
					//赠品数量减少
					orgEntry.setGiftQty(totalGift-giftPlan.getGiftQty());
					
					if(orgEntry.getGiftQty()<=0)break;//赠完为止
					
					daliyEntryNo++;
				}
			}
		}
		
		
	}

	@Override
	public List<TPromotion> selectAllPromotionByOrder(PromotionOrderModel model) {
		List<TPromotion> promotions = new ArrayList<TPromotion>();
		List<PromotionPlanDetail> details = model.getDetails();
		TPromotion param = new TPromotion();
		param.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		param.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		param.setBuyAmt(model.getInitAmt());
		param.setCreateBy(format.format(model.getOrderDate()));
		param.setBuyStartTime(model.getStartDate());
		param.setBuyStopTime(model.getEndDate());
		//年卡促销
		List<TPromotion> yearProms = this.selectPromotionByYear(param);
		if(yearProms!=null) {
			promotions.addAll(yearProms);
		}
		//整单促销
		List<TPromotion> orderProms = this.selectPromotionByOrder(param);
		if(orderProms!=null) {
			promotions.addAll(orderProms);
		}
		//单品促销
		for(PromotionPlanDetail detail : details) {
			param.setOrgMatnr(detail.getMatnr());
			param.setBuyAmt(detail.getAmt());
			List<TPromotion> matnrProms = this.selectPromotionByOneMatnr(param);
			if (matnrProms != null) {
				promotions.addAll(matnrProms);
			}
		}
		return promotions;
	}

	@Override
	public List<TPromotion> selectPromotionByOneMatnr(TPromotion promotion) {
		BigDecimal buyAmt = promotion.getBuyAmt();
		List<TPromotion> promotions = tPromotionMapper.selectPromationByOneMatnr(promotion);
		for(TPromotion p1 : promotions){
			p1.setDiscountAmt(buyAmt.divide(p1.getLowAmt(),BigDecimal.ROUND_UP).multiply(p1.getDiscountAmt()));
		}
		return promotions;
	}

	@Override
	public List<TPromotion> selectPromotionByOrder(TPromotion promotion) {
		BigDecimal buyAmt = promotion.getBuyAmt();
		List<TPromotion> promotions = tPromotionMapper.selectPromationByOrder(promotion);
		for(TPromotion p1 : promotions){
			p1.setDiscountAmt(buyAmt.divide(p1.getLowAmt(),BigDecimal.ROUND_UP).multiply(p1.getDiscountAmt()));
		}
		return promotions;
	}

	@Override
	public List<TPromotion> selectPromotionByYear(TPromotion promotion) {
		List<TPromotion> promotions = tPromotionMapper.selectPromotionByYear(promotion);
		return promotions;
	}

	@Override
	public List<TPromotion> selYearCardPromByPromNo(String salesNo,String promNo) {
		TPromotion promotion = new TPromotion();
		promotion.setSalesOrg(salesNo);
		promotion.setPromNo(promNo);
		return tPromotionMapper.selYearCardPromByPromNo(promotion);
	}

	@Override
	public int addPromtion(PromtionAddModel record) {
		TSysUser user = userSessionService.getCurrentUser();
	
		if(StringUtils.isBlank(record.getPromSubType())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"促销类型不能为空");
		}
		TPromotion promotion = new TPromotion();
		
		List<PromotionOrigItem> origItems = new ArrayList<PromotionOrigItem>();
		List<PromotionGiftItem> giftItems = new ArrayList<PromotionGiftItem>();
		List<PromotionConItem> conItems = new ArrayList<PromotionConItem>();
		
		//基础信息set
		
		promotion.setPromNo(createPromNo());
		promotion.setPromSubType(record.getPromSubType());
		promotion.setPromDes(record.getPromDes());
		promotion.setPlanStartTime(record.getPlanStartTime());
		promotion.setPlanStopTime(record.getPlanStopTime());
		promotion.setBuyStartTime(record.getBuyStartTime());
		promotion.setBuyStopTime(record.getBuyStopTime());
		promotion.setCreateAt(new Date());
		promotion.setCreateBy(user.getLoginName());
		promotion.setCreateByTxt(user.getDisplayName());
		promotion.setLastModified(new Date());
		promotion.setLastModifiedBy(user.getLoginName());
		promotion.setLastModifiedByTxt(user.getDisplayName());
		promotion.setPromSubType(record.getPromSubType());
		promotion.setSalesOrg(user.getSalesOrg());
		promotion.setPromStat("E006");
		tPromotionMapper.insertPromotion(promotion);
		//单品满赠
		if(record.getPromSubType().equals("Z008")){
			List<PromTionItemModel> items = record.getItems();
			if(items!=null && items.size()>0){
				int i = 1;
				for(PromTionItemModel item : items){
					String itemNo = String.valueOf(i*10);
					PromotionOrigItem origItem = new PromotionOrigItem();
					origItem.setPromNo(promotion.getPromNo());
					origItem.setItemNo(itemNo);
					origItem.setGoodNo(item.getGoodNo());
					origItem.setOrigNum(item.getOrigNum());
					origItem.setDiscountAmt(item.getDiscountAmt());
					
					origItems.add(origItem);
					
					PromotionGiftItem giftItem = new PromotionGiftItem();
					giftItem.setGiftNo(item.getGiftNo());
					giftItem.setGiftNum(item.getGiftNum());
					giftItem.setPromNo(promotion.getPromNo());
					giftItem.setItemNo(itemNo);
					
					giftItems.add(giftItem);
					i=i+1;
				}
				for(PromotionOrigItem entry : origItems){
					promotionOrigItemMapper.insertOrigItem(entry);
				}
				
				for(PromotionGiftItem entry : giftItems){
					promotionGiftItemMapper.insertGiftItem(entry);
				}
				
				
			/*	
				origItems.forEach(entry -> {
					promotionOrigItemMapper.insertOrigItem(entry);
		        });
				giftItems.forEach(entry -> {
					promotionGiftItemMapper.insertGiftItem(entry);
		        });*/
			}
			
		}
		
		
		//满减 或 年卡
		if(record.getPromSubType().equals("Z015") || record.getPromSubType().equals("Z016") ||record.getPromSubType().equals("Z017") ){
			List<PromTionItemModel> items = record.getItems();
			if(items!=null && items.size()>0){
				int i = 1;
				for(PromTionItemModel item : items){	
					String itemNo = String.valueOf(i*10);
					PromotionOrigItem origItem = new PromotionOrigItem();
					origItem.setPromNo(promotion.getPromNo());
					origItem.setItemNo(itemNo);
					origItem.setGoodNo(item.getGoodNo());
					origItem.setOrigNum(item.getOrigNum());
					origItem.setDiscountAmt(item.getDiscountAmt());
					origItems.add(origItem);
					
					PromotionConItem conItem = new PromotionConItem();
					conItem.setPromNo(promotion.getPromNo());
					conItem.setItemNo(itemNo);
					conItem.setLow(item.getLow());
					conItems.add(conItem);
					
					i=i+1;
				}
				
				origItems.forEach(entry -> {
					promotionOrigItemMapper.insertOrigItem(entry);
		        });
				conItems.forEach(entry -> {
					promotionConItemMapper.insertConItem(entry);
		        });
			}
		}
		return 1;
	}
	
	public String createPromNo(){
		StringBuffer promNo = new StringBuffer("T-");
		String str = PromNoUtil.getPromNo();
		if(StringUtils.isBlank(str)){
			return "";
		}
		promNo.append(str);
		return promNo.toString();
		
	}

	@Override
	public List<TPromotion> searchPromoDetailByNo(String promNo) {
		return tPromotionMapper.searchPromoDetailByNo(promNo);
	}

	@Override
	public int delPromotion(String promNo) {
		//首先判断该促销是否有被订单参加促销
		
		List<TPreOrder> lists = orderService.selectOrderByPromNo(promNo);
		if(lists == null || lists.size()==0){
			//删除关系表
			promotionScopeItemMapper.delPromScopeByNo(promNo);
			
			//
			promotionOrigItemMapper.delOrigPromByNo(promNo);

			promotionGiftItemMapper.delGiftPromByNo(promNo);
			
			promotionConItemMapper.delConPromByNo(promNo);
			//删除头表
			tPromotionMapper.delPromByNo(promNo);
			
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该促销已经有订单参与促销,不能删除");
		}
		return 0;
	}

	@Override
	public PageInfo searchPromoByPage(PromSearchModel smodel) {
		smodel.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		smodel.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		return tPromotionMapper.searchPromoByPage(smodel);
	}

	@Override
	public List<TPromotion> selectPromsBySelesOrg() {
		PromSearchModel smodel = new PromSearchModel();
		smodel.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
		smodel.setBranchNo(userSessionService.getCurrentUser().getBranchNo());
		return tPromotionMapper.selectPromsBySelesOrg(smodel);
	}

	@Override
	public List<TMdBranch> getBranchsByPromNo(String promNo) {
		
		return branchService.getBranchsByPromNo(promNo);
	}

	@Override
	public int promotionHasOrder(PromAllocatModel smodel) {
		List<TPromotionOrderModel>  result = tPromotionMapper.promotionHasOrder(smodel);
		if(result!=null && result.size()>0){
			StringBuffer str = new StringBuffer();
			for(TPromotionOrderModel model : result){
				if (StringUtils.isBlank(str.toString())) {
					str.append("促销号:"+smodel.getPromNo()+"下,门店号为:"+model.getBranchNo());
				}else{
					str.append(","+model.getBranchNo());
				}
			}
			throw new ServiceException(MessageCode.LOGIC_ERROR,str.toString()+" 的门店已经存在订单,不能删除其关系");
		}
		return 1;
	}

	@Override
	public int relBranchByPromNo(PromAllocatModel pmodel) {
		if(StringUtils.isBlank(pmodel.getPromNo())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"促销号不能为空!!!");
		}
		String promNo = pmodel.getPromNo();
		PromotionScopeItem key = new PromotionScopeItem();
		key.setPromNo(promNo);
		//最新的关系列表(所有的奶站编号)
		List<String> branchs = pmodel.getBranchNos();
		
		
		//获取原促销号关联的奶站信息
		List<PromotionScopeItem> scopes = promotionScopeItemMapper. selectScopeItemsByKey(key);
		if(scopes!=null && scopes.size()>0){
			//用来保存要新增的关系
			List<PromotionScopeItem> newScopes = new ArrayList<PromotionScopeItem>();
			//用来保存需要删除的关系
			List<String>  delScopes = new ArrayList<String>();
			
			//用来保存原促销和奶站的关系(所有的奶站编号)
			List<String> oldScopes = new ArrayList<String>();
			scopes.stream().filter(e->StringUtils.isNotBlank(e.getBranchNo())).forEach(entry->{
				oldScopes.add(entry.getBranchNo());
			});
			StringBuffer errBuff = new StringBuffer();
			//循环便利原关系
			for(String branchNo : oldScopes){
				//如果新的关系表中 包含原关系 则忽略不处理
				if(branchs.contains(branchNo)){
					continue;
				}else{
					delScopes.add(branchNo);					
				}
			}
			if(StringUtils.isNoneBlank(errBuff.toString())){
				throw new ServiceException(MessageCode.LOGIC_ERROR,errBuff.toString()+" 的关系下已有订单,不能删除!!!");
			}
			//循环便利新的关系
			for(String branchNo : branchs){
				//如果中 原关系包含新的关系表 则忽略不处理
				if(oldScopes.contains(branchNo)){
					continue;
				}else{
					//否则说明原关系中不存在该关系,用来新增
					PromotionScopeItem scope = new PromotionScopeItem();
					scope.setBranchNo(branchNo);
					scope.setPromNo(promNo);
					newScopes.add(scope);
				}
			}
			
			if(delScopes.size()>0){
				
				PromAllocatModel model = new  PromAllocatModel();
				model.setBranchNos(delScopes);
				model.setPromNo(promNo);
				
				//判断需要删除的关系中,是否存在不能删除的关系
				List<TPromotionOrderModel> lists = tPromotionMapper.promotionHasOrder(model);
				if(lists!=null && lists.size()>0){
					for(TPromotionOrderModel entry : lists){
						if(StringUtils.isBlank(errBuff.toString())){
							errBuff.append("促销号"+promNo + "和奶站号为 :"+entry.getBranchNo());
						}else{
							errBuff.append(","+entry.getBranchNo());
						}
					}
				}else{
					promotionScopeItemMapper.delPromScopesByScope(model);
				}
				
			}
			
			if(newScopes.size()>0){
				newScopes.stream().forEach(entry->{
					promotionScopeItemMapper.insertScopeItem(entry);
				});
			}
			
			
			
		}else{
			//如果没有直接保存新的关系即可
		
			if(branchs!=null && branchs.size()>0){
				branchs.stream().forEach(branchNo->{
					PromotionScopeItem entry = new PromotionScopeItem();
					entry.setBranchNo(branchNo);
					entry.setPromNo(pmodel.getPromNo());
					promotionScopeItemMapper.insertScopeItem(entry);
				});
			}
			
		}
		
		return 0;
	}
	
}
