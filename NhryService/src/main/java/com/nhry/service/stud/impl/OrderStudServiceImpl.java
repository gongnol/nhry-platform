package com.nhry.service.stud.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;














import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.stud.dao.TMdClassMapper;
import com.nhry.data.stud.dao.TMdMaraStudMapper;
import com.nhry.data.stud.dao.TMdSchoolClassMapper;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.dao.TMdSchoolMaraRuleBaseMapper;
import com.nhry.data.stud.dao.TMdSchoolMaraRuleMapper;
import com.nhry.data.stud.dao.TMdSchoolRuleMapper;
import com.nhry.data.stud.dao.TMstOrderStudItemMapper;
import com.nhry.data.stud.dao.TMstOrderStudLossMapper;
import com.nhry.data.stud.dao.TMstOrderStudMapper;
import com.nhry.data.stud.domain.TMdClass;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMdSchoolMaraRule;
import com.nhry.data.stud.domain.TMdSchoolMaraRuleBase;
import com.nhry.data.stud.domain.TMdSchoolRule;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.data.stud.domain.TMstOrderStudItem;
import com.nhry.data.stud.domain.TMstOrderStudLoss;
import com.nhry.model.stud.ExportStudOrderMilkModel;
import com.nhry.model.stud.OrderBatchBuildModel;
import com.nhry.model.stud.OrderStudLossModel;
import com.nhry.model.stud.OrderStudQueryModel;
import com.nhry.model.stud.SchoolClassModel;
import com.nhry.model.stud.SchoolMaraRuleModel;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.service.pi.dao.PIRequireOrderService;
import com.nhry.service.stud.dao.OrderStudService;
import com.nhry.utils.DateUtil;
import com.nhry.utils.EnvContant;


/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public class OrderStudServiceImpl implements OrderStudService {
	
	@Autowired
	private TMdSchoolMaraRuleMapper tMdSchoolMaraRuleMapper;
	
	@Autowired
	private TMdSchoolMaraRuleBaseMapper tMdSchoolMaraRuleBaseMapper;

	@Autowired
	private TMstOrderStudMapper mstOrderStudMapper;
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private TMstOrderStudItemMapper orderStudItemMapper;
	
	@Autowired
	private TMdClassMapper classMapper;
	
	@Autowired
	private TMdSchoolClassMapper schoolClassMapper;
	
	@Autowired
	private TMdMaraStudMapper maraStudMapper;
	
	@Autowired
	private TMstOrderStudLossMapper orderStudLossMapper;
	
	@Autowired
	private TMdSchoolMapper schoolMapper;
	
	@Autowired
	private TMdSchoolRuleMapper schoolRuleMapper;
	
	@Autowired
	PIRequireOrderService pIRequireOrderService;
	
    public static String getCode(){
		DateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
        int num = new Random().nextInt(89999)+10000;
        return format.format(new Date())+num;
    }
	
	@Override
	public int createOrder(final TMstOrderStud mstOrderStud) throws Exception {
		
		if(null == mstOrderStud){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "参数必传");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期必选");
		}
		if(StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校必选");
		}
		if(CollectionUtils.isNotEmpty(mstOrderStud.getList10()) && StringUtils.isBlank(mstOrderStud.getMatnr())){
			boolean flag = true;
			for(TMstOrderStudItem item : mstOrderStud.getList10()){
				if(null != item.getQty() && item.getQty() > 0){
					flag = false;
					break;
				}
			}
			if(!flag){
				throw new ServiceException(MessageCode.LOGIC_ERROR, "学生奶未选择牛奶品种");
			}
		}
		Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(mstOrderStud.getOrderDateStr());
		Date date = new Date();
		TSysUser user = this.userSessionService.getCurrentUser();
		
		TMstOrderStud order = new TMstOrderStud();
		order.setSchoolCode(mstOrderStud.getSchoolCode());
		order.setOrderDateStr(mstOrderStud.getOrderDateStr());
		order.setSalesOrg(user.getSalesOrg());
        order = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(order);
        String orderId = null;
        if(null != order){
        	
        	//已发送ERP的不能被覆盖和删除
        	orderId = order.getOrderId();
        	if("10".equals(order.getErpOrderStatus()) 
        			|| "10".equals(order.getErpOrderFreeStatus())
        			|| "10".equals(order.getErpOrderFillStatus())){
        		throw new ServiceException(MessageCode.LOGIC_ERROR, "已发送ERP的订单不能被更新");
        	}
        	//将订单失效
//    		this.deleteOrderAndItem(mstOrderStud.getOrderDateStr(), mstOrderStud.getSchoolCode(), user.getSalesOrg());
        	
        	//物理删除
			orderStudItemMapper.deleteOrderItemByOrderId(orderId);
			orderStudLossMapper.deleteByOrderId(orderId);
			
			//更新订单
			TMstOrderStud updateOrderStud = new TMstOrderStud();
			updateOrderStud.setOrderId(orderId);
			updateOrderStud.setLastModified(new Date());
			updateOrderStud.setLastModifiedBy(user.getLoginName());
			updateOrderStud.setLastModifiedByTxt(user.getDisplayName());
			updateOrderStud.setIsBatch("20");
			mstOrderStudMapper.updateByOrder(updateOrderStud);
        }
        else{
        	
        	//创建主订单
    		orderId = getCode();
    		mstOrderStud.setOrderId(orderId);
    		mstOrderStud.setOrderDate(orderDate);
    		mstOrderStud.setCreateAt(date);
    		mstOrderStud.setCreateBy(user.getLoginName());
    		mstOrderStud.setCreateByTxt(user.getDisplayName());
    		mstOrderStud.setLastModified(date);
    		mstOrderStud.setLastModifiedBy(user.getLoginName());
    		mstOrderStud.setLastModifiedByTxt(user.getDisplayName());
    		mstOrderStud.setSalesOrg(user.getSalesOrg());
    		mstOrderStud.setOrderStatus("10");
    		mstOrderStud.setIsBatch("20");
    		mstOrderStudMapper.insertOrder(mstOrderStud);
        }
		
		List<TMstOrderStudItem> list10 = mstOrderStud.getList10();//学生奶
	    if(CollectionUtils.isNotEmpty(list10)){
	    	for(TMstOrderStudItem item : list10){
	    		if(StringUtils.isBlank(item.getClassCode())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setSchoolCode(mstOrderStud.getSchoolCode());
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setMatnr(mstOrderStud.getMatnr());
	    		item.setOrderDate(orderDate);
	    		item.setOrderType("10");
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudItemMapper.insertSdutOrderItem(item);
	    	}
	    }
	    
	    List<TMstOrderStudItem> list20 = mstOrderStud.getList20();//老师奶
	    if(CollectionUtils.isNotEmpty(list20)){
	    	for(TMstOrderStudItem item : list20){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setSchoolCode(mstOrderStud.getSchoolCode());
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setOrderDate(orderDate);
	    		item.setOrderType("20");
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudItemMapper.insertSdutOrderItem(item);
	    	}
	    }
	    
	    List<TMstOrderStudLoss> list30 = mstOrderStud.getList30();//损耗
	    if(CollectionUtils.isNotEmpty(list30)){
	    	for(TMstOrderStudLoss item : list30){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudLossMapper.insertOrderStudLoss(item);
	    	}
	    }
		return 1;
	}

	@Override
	public TMstOrderStud selectByOrderId(String orderId) {
		return mstOrderStudMapper.selectByOrderId(orderId);
	}

	@Override
	public int updateByOrder(TMstOrderStud mstOrderStud) {
		if(null == mstOrderStud || StringUtils.isBlank(mstOrderStud.getOrderId())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订单号必传");
		}
		Date date = new Date();
		mstOrderStud.setLastModified(date);
	/*	mstOrderStud.setLastModifiedBy(userSessionService.getCurrentUser().getLoginName());
		mstOrderStud.setLastModifiedByTxt(userSessionService.getCurrentUser().getDisplayName());*/
		return mstOrderStudMapper.updateByOrder(mstOrderStud);
	}

	@Override
	public PageInfo<TMstOrderStud> findOrderPage(OrderStudQueryModel queryModel) {
		if(null == queryModel || StringUtils.isBlank(queryModel.getPageNum())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前页数必填");
		}
		if(StringUtils.isBlank(queryModel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "每页显示条数必填");
		}
		queryModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		return mstOrderStudMapper.findOrderPage(queryModel);
	}

	@Override
	public Map<String, Object> findOrderInfoBySchoolCodeAndDate(TMstOrderStud mstOrderStud) {
		if(null == mstOrderStud || StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传，请选择学校站点");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数的订单日期必传，请选择取数的订单日期");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		mstOrderStud.setSalesOrg(user.getSalesOrg());
		Map<String, Object> resultMap = new HashMap<>();
		TMstOrderStud orderStud = this.mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(mstOrderStud);
		
		if(null == orderStud){
			//学校不存在该日期的订单，则初始化数据
			resultMap.put("orderStud", null);
			
			//学生奶
			List<TMstOrderStudItem> list10 = new ArrayList<TMstOrderStudItem>();
			List<TMdClass> classList = schoolClassMapper.findAllClassBySchool(new SchoolClassModel(user.getSalesOrg(), mstOrderStud.getSchoolCode()));
			if(CollectionUtils.isNotEmpty(classList)){
				TMstOrderStudItem item10 = null;
				for(TMdClass mdClass : classList){
					item10 = new TMstOrderStudItem();
					item10.setClassCode(mdClass.getClassCode());
					item10.setClassName(mdClass.getClassName());
					item10.setQty(0);
					list10.add(item10);
				}
			}
			resultMap.put("list10", list10);
			
			//老师奶
			List<TMstOrderStudItem> list20 = new ArrayList<TMstOrderStudItem>();
			List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudItem item20 = null;
				for(TMdMaraStud mara : maraList){
					item20 = new TMstOrderStudItem();
					item20.setQty(0);
					item20.setMatnr(mara.getMatnr());
					item20.setMatnrTxt(mara.getMatnrTxt());
					item20.setZbotCode(mara.getZbotCode());
					item20.setZbotCodeName(mara.getZbotCodeName());
					list20.add(item20);
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = new ArrayList<TMstOrderStudLoss>();
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudLoss item30 = null;
				for(TMdMaraStud mara : maraList){
					item30 = new TMstOrderStudLoss();
					item30.setQty(0);
					item30.setMatnr(mara.getMatnr());
					item30.setMatnrTxt(mara.getMatnrTxt());
					item30.setZbotCode(mara.getZbotCode());
					item30.setZbotCodeName(mara.getZbotCodeName());
					list30.add(item30);
				}
			}
			resultMap.put("list30", list30);
		}
		else{
			//存在订单，返回信息
			resultMap.put("orderStud", orderStud);
			
			//学生奶
			Map<String, Object> selectMap = new HashMap<>();
			selectMap.put("orderId", orderStud.getOrderId());
			selectMap.put("orderType", "10");
			selectMap.put("salesOrg", user.getSalesOrg());
			List<TMstOrderStudItem> list10 = orderStudItemMapper.findOrderItemByMap(selectMap);
			if(CollectionUtils.isEmpty(list10)){
				
				list10 = new ArrayList<TMstOrderStudItem>();
				List<TMdClass> classList = schoolClassMapper.findAllClassBySchool(new SchoolClassModel(user.getSalesOrg(), mstOrderStud.getSchoolCode()));
				if(CollectionUtils.isNotEmpty(classList)){
					TMstOrderStudItem item10 = null;
					for(TMdClass mdClass : classList){
						item10 = new TMstOrderStudItem();
						item10.setClassCode(mdClass.getClassCode());
						item10.setClassName(mdClass.getClassName());
						item10.setQty(0);
						list10.add(item10);
					}
				}
			}
			else{
				orderStud.setMatnr(list10.get(0).getMatnr());
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudItem item : list10){
					notInList.add(item.getClassCode());
				}
				Map<String, Object> selectClassMap = new HashMap<>();
				selectClassMap.put("salesOrg", user.getSalesOrg());
				selectClassMap.put("notInList", notInList);
				selectClassMap.put("schoolCode", mstOrderStud.getSchoolCode());
				List<TMdClass> classList = classMapper.findClassListBySalesOrgNotIn(selectClassMap);
				if(CollectionUtils.isNotEmpty(classList)){
					TMstOrderStudItem item10 = null;
					for(TMdClass mdClass : classList){
						item10 = new TMstOrderStudItem();
						item10.setClassCode(mdClass.getClassCode());
						item10.setClassName(mdClass.getClassName());
						item10.setQty(0);
						list10.add(item10);
					}
				}
			}
			resultMap.put("list10", list10);
			
			//老师奶
			selectMap.put("orderType", "20");
			List<TMstOrderStudItem> list20 = orderStudItemMapper.findOrderItemByMap(selectMap);
			if(CollectionUtils.isEmpty(list20)){
				list20 = new ArrayList<TMstOrderStudItem>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudItem item : list20){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = orderStudLossMapper.findLossByOrderId(selectMap);
			if(CollectionUtils.isEmpty(list30)){
				list30 = new ArrayList<TMstOrderStudLoss>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudLoss item : list30){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			resultMap.put("list30", list30);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> buildBatchInfo(OrderBatchBuildModel orderBatchBuildModel) throws Exception {
		TSysUser user = this.userSessionService.getCurrentUser();
		if(null == orderBatchBuildModel || StringUtils.isBlank(orderBatchBuildModel.getOrderGetDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数日期必传");
		}
		if(StringUtils.isBlank(orderBatchBuildModel.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期必传");
		}
		if(StringUtils.isBlank(orderBatchBuildModel.getWeek())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "指定套餐必传");
		}
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<TMdSchool> baseSchoolList = this.schoolMapper.findSchoolListForBuildBatchOrder(user.getSalesOrg());
		if(CollectionUtils.isEmpty(baseSchoolList)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "未查询到学校,或者已有学校中未设置学校奶品政策");
		}
		
		List<TMdSchool> schoolList = new ArrayList<TMdSchool>();
		if(StringUtils.isNotBlank(orderBatchBuildModel.getUncloudSchoolCodeTxts())){
			orderBatchBuildModel.setUncloudSchoolCodeTxts(orderBatchBuildModel.getUncloudSchoolCodeTxts().replace("，", "").replace(" ", "").trim());
			String[] schoolCodes = orderBatchBuildModel.getUncloudSchoolCodeTxts().split(",");
			f1:for(TMdSchool school : baseSchoolList){
				for(String schoolCodeTxt : schoolCodes){
					if(schoolCodeTxt.equals(school.getSchoolCodeTxt())){
						continue f1;
					}
				}
				schoolList.add(school);
			}
		}
		else{
			schoolList = baseSchoolList;
		}
		
		if(CollectionUtils.isEmpty(schoolList)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "过滤后没有学校");
		}
		
		resultMap.put("schoolList", schoolList);
		return resultMap;
	}
	private String findMatnr(TMdSchoolRule schoolRule, int week) throws ParseException{
		if(1 == week){//星期天
			return schoolRule.getWeek7Matnr();
		}
		else if(2 == week){//星期一
			return schoolRule.getWeek1Matnr();
		}
		else if(3 == week){//W2
			return schoolRule.getWeek2Matnr();
		}
		else if(4 == week){//W3
			return schoolRule.getWeek3Matnr();
		}
		else if(5 == week){//W4
			return schoolRule.getWeek4Matnr();
		}
		else if(6 == week){//W5
			return schoolRule.getWeek5Matnr();
		}
		else if(7 == week){//W6
			return schoolRule.getWeek6Matnr();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	@Deprecated
	private String findMatnr(TMdSchoolRule schoolRule, String orderDateStr) throws ParseException{
		Calendar c = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date orderDate = dateFormat.parse(orderDateStr);
		c.setTime(orderDate);
		int week = c.get(Calendar.DAY_OF_WEEK);
		if(1 == week){//星期天
			return schoolRule.getWeek7Matnr();
		}
		else if(2 == week){//星期一
			return schoolRule.getWeek1Matnr();
		}
		else if(3 == week){//W2
			return schoolRule.getWeek2Matnr();
		}
		else if(4 == week){//W3
			return schoolRule.getWeek3Matnr();
		}
		else if(5 == week){//W4
			return schoolRule.getWeek4Matnr();
		}
		else if(6 == week){//W5
			return schoolRule.getWeek5Matnr();
		}
		else if(7 == week){//W6
			return schoolRule.getWeek6Matnr();
		}
		return null;
	}
	
	private void buildLoss(HashMap<String, Integer> map, String matnr, int addVal){
		Integer val = map.get(matnr);
		if(null == val){
			map.put(matnr, addVal);
		}
		else{
			map.put(matnr, val+addVal);
		}
	}

	@Override
	public int createOrderWithBatch(OrderBatchBuildModel orderBatchBuildModel) throws Exception {
		TSysUser user = this.userSessionService.getCurrentUser();
		if(null == orderBatchBuildModel || StringUtils.isBlank(orderBatchBuildModel.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		if(null == orderBatchBuildModel || StringUtils.isBlank(orderBatchBuildModel.getOrderGetDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数日期必传");
		}
		if(StringUtils.isBlank(orderBatchBuildModel.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期必传");
		}
		if(orderBatchBuildModel.getOrderGetDateStr().equals(orderBatchBuildModel.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数日期和目标日期不能是同一天");
		}
		if(StringUtils.isBlank(orderBatchBuildModel.getWeek())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "指定套餐必传");
		}
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		
		Map<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put("getOrderDateStr", orderBatchBuildModel.getOrderGetDateStr());
		selectMap.put("salesOrg", user.getSalesOrg());
		selectMap.put("schoolCode", orderBatchBuildModel.getSchoolCode());
		TMdSchoolRule schoolRule = schoolRuleMapper.findSchoolRuleByMap(selectMap);
		if(null == schoolRule){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "未查询到学生奶品政策");
		}
//		String matnr = findMatnr(schoolRule, orderBatchBuildModel.getOrderDateStr());
		String matnr = findMatnr(schoolRule, Integer.parseInt(orderBatchBuildModel.getWeek()));
		if(StringUtils.isBlank(matnr)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前学校未设置该套餐的奶品政策");
		}
		List<TMstOrderStudItem> orderItemList = orderStudItemMapper.findOrderItemByMapWithBatch(selectMap);
		List<TMstOrderStudItem> orderItemListUnpack = orderStudItemMapper.findOrderItemUnpackByMapWithBatch(selectMap);
		if(CollectionUtils.isEmpty(orderItemList) && CollectionUtils.isEmpty(orderItemListUnpack)){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数日期未找到订奶数据");
		}
		
		/**
		 * 生成
		 */
		TMstOrderStud order = new TMstOrderStud();
		order.setSchoolCode(orderBatchBuildModel.getSchoolCode());
		order.setOrderDateStr(orderBatchBuildModel.getOrderGetDateStr());
		order.setSalesOrg(user.getSalesOrg());
        order = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(order);
        if(null == order){
        	throw new ServiceException(MessageCode.LOGIC_ERROR, "取数日期订单不存在");
        }
        
        order = new TMstOrderStud();
		order.setSchoolCode(orderBatchBuildModel.getSchoolCode());
		order.setOrderDateStr(orderBatchBuildModel.getOrderDateStr());
		order.setSalesOrg(user.getSalesOrg());
        order = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(order);
        if(null != order){
        	throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期".concat(orderBatchBuildModel.getOrderDateStr()).concat("已存在订奶数据,请先删除"));
        }
//        if(null != order){
//        	
//        	//已发送ERP的不能被覆盖和删除
//        	if("10".equals(order.getErpOrderStatus()) || "10".equals(order.getErpOrderFreeStatus())){
//        		throw new ServiceException(MessageCode.LOGIC_ERROR, "已发送ERP的订单不能被批量生成覆盖");
//        	}
//        	
//        	//单独生成的订奶订单不能被批量生成覆盖
//        	if("20".equals(order.getIsBatch())){
//        		throw new ServiceException(MessageCode.LOGIC_ERROR, "单独生成的订奶订单不能被批量生成覆盖");
//        	}
//        	
//        	//将订单失效
//        	this.deleteOrderAndItem(orderBatchBuildModel.getOrderDateStr(), orderBatchBuildModel.getSchoolCode(), user.getSalesOrg());
//        }
		
        
        
		String orderId = getCode();
		TMstOrderStud mstOrderStud = new TMstOrderStud();
		Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderBatchBuildModel.getOrderDateStr());
		Date date = new Date();
		mstOrderStud.setSchoolCode(orderBatchBuildModel.getSchoolCode());
		mstOrderStud.setOrderId(orderId);
		mstOrderStud.setOrderDate(orderDate);
		mstOrderStud.setCreateAt(date);
		mstOrderStud.setCreateBy(user.getLoginName());
		mstOrderStud.setCreateByTxt(user.getDisplayName());
		mstOrderStud.setLastModified(date);
		mstOrderStud.setLastModifiedBy(user.getLoginName());
		mstOrderStud.setLastModifiedByTxt(user.getDisplayName());
		mstOrderStud.setSalesOrg(user.getSalesOrg());
		mstOrderStud.setOrderStatus("10");
		mstOrderStud.setIsBatch("10");
		mstOrderStudMapper.insertOrder(mstOrderStud);
		
		List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
		
		//orderItemList
		if(CollectionUtils.isNotEmpty(orderItemList)){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			if(null != maraList){
				maraList.stream().forEach((e)->{
					map.put(e.getMatnr(), 0);
				});
			}
			for(TMstOrderStudItem item : orderItemList){
				if("10".equals(item.getOrderType())){
					item.setMatnr(matnr);//学生奶替换新的套餐，老师奶取原来的数据
					this.buildLoss(map, item.getMatnr(), item.getQty());//老师奶不计算损耗
				}
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setOrderDate(orderDate);
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		orderStudItemMapper.insertSdutOrderItem(item);
			}
			
			if(map.size() > 0){
				TMstOrderStudLoss item = null;
				OrderStudLossModel lossModel = new OrderStudLossModel();
				lossModel.setSchoolCode(orderBatchBuildModel.getSchoolCode());
				for(Entry<String, Integer> entry : map.entrySet()){
					if(StringUtils.isBlank(entry.getKey())){
		    			continue;
		    		}
		    		if(entry.getValue() == null || entry.getValue() < 0){
		    			continue;
		    		}
		    		lossModel.setMatnr(entry.getKey());
		    		lossModel.setMatnrCount(entry.getValue());
		    		int qty = 0;
		    		try {
		    			qty = this.calcLoss(lossModel);
					} catch (Exception e) {
						logger.error(e.getMessage());
						continue;
					}
		    		if(qty <= 0){
		    			continue;
		    		}
		    		
		    		item = new TMstOrderStudLoss();
		    		item.setMatnr(entry.getKey());
		    		item.setQty(qty);
		    		item.setOrderId(orderId);
		    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
		    		item.setCreateAt(date);
		    		item.setCreateBy(user.getLoginName());
		    		item.setCreateByTxt(user.getDisplayName());
		    		item.setLastModified(date);
		    		item.setLastModifiedBy(user.getLoginName());
		    		item.setLastModifiedByTxt(user.getDisplayName());
		    		item.setSalesOrg(user.getSalesOrg());
		    		orderStudLossMapper.insertOrderStudLoss(item);
				}
			}
		}
		
		
		//orderItemListUnpack
		if(CollectionUtils.isNotEmpty(orderItemListUnpack)){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			if(null != maraList){
				maraList.stream().forEach((e)->{
					map.put(e.getMatnr(), 0);
				});
			}
			for(TMstOrderStudItem item : orderItemListUnpack){
				this.buildLoss(map, item.getMatnr(), item.getQty());
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setOrderDate(orderDate);
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		orderStudItemMapper.insertSdutOrderItemUnpack(item);
			}
			
			if(map.size() > 0){
				TMstOrderStudLoss item = null;
				OrderStudLossModel lossModel = new OrderStudLossModel();
				lossModel.setSchoolCode(orderBatchBuildModel.getSchoolCode());
				for(Entry<String, Integer> entry : map.entrySet()){
					if(StringUtils.isBlank(entry.getKey())){
		    			continue;
		    		}
		    		if(entry.getValue() == null || entry.getValue() < 0){
		    			continue;
		    		}
		    		lossModel.setMatnr(entry.getKey());
		    		lossModel.setMatnrCount(entry.getValue());
		    		int qty = 0;
		    		try {
		    			qty = this.calcLoss(lossModel);
					} catch (Exception e) {
						logger.error(e.getMessage());
						continue;
					}
		    		if(qty <= 0){
		    			continue;
		    		}
		    		
		    		item = new TMstOrderStudLoss();
		    		item.setMatnr(entry.getKey());
		    		item.setQty(qty);
		    		item.setOrderId(orderId);
		    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
		    		item.setCreateAt(date);
		    		item.setCreateBy(user.getLoginName());
		    		item.setCreateByTxt(user.getDisplayName());
		    		item.setLastModified(date);
		    		item.setLastModifiedBy(user.getLoginName());
		    		item.setLastModifiedByTxt(user.getDisplayName());
		    		item.setSalesOrg(user.getSalesOrg());
		    		orderStudLossMapper.insertOrderStudLossUnpack(item);
				}
			}
		}
		return 1;
	}
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	private int deleteOrderAndItem(String orderDateStr, String schoolCode, String salesOrg){
//		Map<String, Object> delMap = new HashMap<String, Object>();
//		delMap.put("orderDateStr", orderDateStr);
//		delMap.put("schoolCode", schoolCode);
//		delMap.put("salesOrg", salesOrg);
//		int c = orderStudItemMapper.deleteOrderAndItem(delMap);
//		return c;
//	}

	@Override
	public int updateOrderWithBatch(OrderBatchBuildModel orderBatchBuildModel) {
		TSysUser user = this.userSessionService.getCurrentUser();
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		if(null == orderBatchBuildModel || StringUtils.isBlank(orderBatchBuildModel.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "请选择需要删除订单数据的目标日期");
		}
		if(StringUtils.isBlank(orderBatchBuildModel.getUserRandomCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "验证码必填");
		}
		if(!orderBatchBuildModel.getUserRandomCode().equalsIgnoreCase(orderBatchBuildModel.getServerRandomCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "验证码错误");
		}
		Map<String, Object> delMap = new HashMap<String, Object>();
		delMap.put("orderDateStr", orderBatchBuildModel.getOrderDateStr());
		delMap.put("salesOrg", user.getSalesOrg());
		int c = orderStudItemMapper.deleteOrderWithBatch(delMap);
		return c;
	}

	/*
	 * 计算损耗
	 * (non-Javadoc)
	 * @see com.nhry.service.stud.dao.OrderStudService#calcLoss(com.nhry.model.stud.OrderStudLossModel)
	 */
	@Override
	public int calcLoss(OrderStudLossModel orderStudLossModel) {
		TSysUser user = this.userSessionService.getCurrentUser();
		if(null == orderStudLossModel|| StringUtils.isBlank(orderStudLossModel.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传，请选择学校");
		}
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		if(StringUtils.isBlank(orderStudLossModel.getMatnr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "奶品代码必传");
		}
		if(null == orderStudLossModel.getMatnrCount() || orderStudLossModel.getMatnrCount() <= 0){
			orderStudLossModel.setMatnrCount(0);
		}
		HashMap<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put("salesOrg", user.getSalesOrg());
		selectMap.put("matnr", orderStudLossModel.getMatnr());
		selectMap.put("schoolCode", orderStudLossModel.getSchoolCode());
		TMdSchoolMaraRule maraRule = tMdSchoolMaraRuleMapper.findSchoolMaraRuleForMatnr(selectMap);
		TMdSchoolMaraRuleBase ruleBase = tMdSchoolMaraRuleBaseMapper.findMaraRuleBaseByModel(new SchoolMaraRuleModel(user.getSalesOrg(), orderStudLossModel.getSchoolCode(), null, null));
		
		if(null == maraRule && null == ruleBase){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前学校未设置损耗政策");
		}
		
		BigDecimal result = new BigDecimal("0");
		if(null != ruleBase && orderStudLossModel.getMatnrCount()  > 0){//当日喝的才计算，没喝的不计算
			if(null != ruleBase.getFixedQty() && ruleBase.getFixedQty() > 0){
				
				/**
				 * 数量计算
				 */
				result = result.add(new BigDecimal(ruleBase.getFixedQty()));
			}
			else if(null != ruleBase.getFixedScale() && ruleBase.getFixedScale() > 0){
				
				/**
				 * 比例计算
				 */
//				if(ruleBase.getFixedMaxQty() == null || ruleBase.getFixedMaxQty() <= 0){
//					throw new ServiceException(MessageCode.LOGIC_ERROR, "比例计算中，上限数量未设置(不能<=0)");
//				}
				result = new BigDecimal(orderStudLossModel.getMatnrCount()).multiply(
							new BigDecimal(ruleBase.getFixedScale()).divide(new BigDecimal("100"))
						);
				if(null != ruleBase.getFixedMaxQty() 
						&& ruleBase.getFixedMaxQty() > 0 
						&& result.compareTo(new BigDecimal(ruleBase.getFixedMaxQty())) > 0){
					result = new BigDecimal(ruleBase.getFixedMaxQty());//超过上限，取上限值
				}
				
			}
		}
		if(null != maraRule){//当日喝的要计算，没喝的也要计算
			/**
			 * 每个奶品的数量设置，取数，计算
			 */
			if(null != maraRule.getMatnrQty() && maraRule.getMatnrQty() > 0){
				result = result.add(new BigDecimal(maraRule.getMatnrQty()));
			}
			
		}
		return result.setScale(0, BigDecimal.ROUND_UP).intValue();//损耗固定比例：有余数都+1(向上取整)
	}
	
	@Override
	public String exportStudOrderMilkSum(ExportStudOrderMilkModel model)  throws Exception{
		if(null == model || StringUtils.isBlank(model.getExportSumStartOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "开始日期必传");
		}
		if(StringUtils.isBlank(model.getExportSumEndOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "结束日期必传");
		}
		if(model.getExportSumStartOrderDateStr().compareTo(model.getExportSumEndOrderDateStr()) > 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "开始日期不能大于结束日期");
		}
		String nfile = getCode().concat("StudOrderMilkSumTemplate.xls");
		String url = EnvContant.getSystemConst("filePath");
		File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "StudOrderMilkSumTemplate.xls");  
        FileInputStream input = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(input);
        
        this.buildExportFileSheetSum( workbook, model.getExportSumStartOrderDateStr(), model.getExportSumEndOrderDateStr());
        
        File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + nfile);
        FileOutputStream stream = new FileOutputStream(export);
        workbook.write(stream);
        stream.flush();
        stream.close();
        return nfile;
	}
	
	/**
	 * 整合补单奶品milkFillList到汇总sumMilkList
	 * @param sumMilkList
	 * @param milkFillList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void fullMilkFill(List<TMstOrderStud> sumMilkList, List<TMstOrderStud> milkFillList) throws IllegalAccessException, InvocationTargetException{
		if(CollectionUtils.isEmpty(milkFillList)){
			return ;
		}
		for(TMstOrderStud item : milkFillList){
			TMstOrderStud sumMilkItem = null;
			if(CollectionUtils.isEmpty(sumMilkList)){
				for(TMstOrderStud item2 : sumMilkList){
					if(item.getMatnr().equals(item2.getMatnr())){
						sumMilkItem = item2;
					}
				}
			}
			
			//汇总存在该奶品，将item奶品数量累加到sumMilkItem
			if(sumMilkItem != null){
				sumMilkItem.setList20Sum(
					String.valueOf(Integer.parseInt(item.getList20Sum())+Integer.parseInt(sumMilkItem.getList20Sum()))		
				);
				sumMilkItem.setList30Sum(
					String.valueOf(Integer.parseInt(item.getList30Sum())+Integer.parseInt(sumMilkItem.getList30Sum()))		
				);
				sumMilkItem.setTotalSum(
					String.valueOf(Integer.parseInt(item.getTotalSum())+Integer.parseInt(sumMilkItem.getTotalSum()))		
				);
			}
			//汇总不存在该奶品,将milkFillList。item放到sumMilkList
			else{
				sumMilkList.add(item);
			}
			
		}
	}
	
	/**
	 * 整合分包不分包到sumMilkList
	 * milkList后面需要用到，不能修改里面的对象
	 * milkUnpackList后面没用到，可以修改对象
	 * @param sumMilkList
	 * @param milkList
	 * @param milkUnpackList
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void fullMilkUnpack(List<TMstOrderStud> sumMilkList, List<TMstOrderStud> milkList, List<TMstOrderStud> milkUnpackList) throws IllegalAccessException, InvocationTargetException{
		if(CollectionUtils.isNotEmpty(milkUnpackList)){
			for(TMstOrderStud item : milkUnpackList){
				if(CollectionUtils.isNotEmpty(milkList)){
					for(TMstOrderStud item2 : milkList){
						if(item.getMatnr().equals(item2.getMatnr())){
							item.setList20Sum(
								String.valueOf(Integer.parseInt(item.getList20Sum())+Integer.parseInt(item2.getList10Sum())+Integer.parseInt(item2.getList20Sum()))		
							);
							item.setList30Sum(
								String.valueOf(Integer.parseInt(item.getList30Sum())+Integer.parseInt(item2.getList30Sum()))		
							);
							item.setTotalSum(
								String.valueOf(Integer.parseInt(item.getTotalSum())+Integer.parseInt(item2.getTotalSum()))		
							);
						}
					}
				}
				sumMilkList.add(item);
			}
			
			//如果milkUnpackList中没有milkList的奶品，需要克隆milkList的奶品到sumMilkList
			if(CollectionUtils.isNotEmpty(milkList)){
				TMstOrderStud tmp = null;
				for(TMstOrderStud item : milkList){
					boolean flag = false;
					for(TMstOrderStud item2 : milkUnpackList){
						if(item.getMatnr().equals(item2.getMatnr())){
							flag = true;
							break;
						}
					}
					if(!flag){
						tmp = new TMstOrderStud();
						BeanUtils.copyProperties(tmp, item);
						tmp.setList20Sum(
							String.valueOf(Integer.parseInt(item.getList20Sum())+Integer.parseInt(item.getList10Sum()))		
						);
						tmp.setTotalSum(
							String.valueOf(Integer.parseInt(tmp.getList20Sum())+Integer.parseInt(item.getList30Sum()))		
						);
						sumMilkList.add(tmp);
					}
				}
			}
		}
		else{
			//克隆milkList的奶品到sumMilkList
			if(CollectionUtils.isNotEmpty(milkList)){
				TMstOrderStud tmp = null;
				for(TMstOrderStud item : milkList){
					tmp = new TMstOrderStud();
					BeanUtils.copyProperties(tmp, item);
					tmp.setList20Sum(
						String.valueOf(Integer.parseInt(item.getList20Sum())+Integer.parseInt(item.getList10Sum()))		
					);
					tmp.setTotalSum(
						String.valueOf(Integer.parseInt(tmp.getList20Sum())+Integer.parseInt(item.getList30Sum()))		
					);
					sumMilkList.add(tmp);
				}
			}
		}
	}

	@Override
	public String exportStudOrderMilk(ExportStudOrderMilkModel model)  throws Exception{
		TSysUser user = this.userSessionService.getCurrentUser();
		if(StringUtils.isBlank(model.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订单日期必传");
		}
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		TMstOrderStud selectObj = new TMstOrderStud();
		selectObj.setSalesOrg(user.getSalesOrg());
		selectObj.setOrderDateStr(model.getOrderDateStr());
		
		/**
		 * 需包装的学生奶汇总数
		 */
		List<TMstOrderStud> milkList = mstOrderStudMapper.findMatnrWithOrder(selectObj);
		if(CollectionUtils.isNotEmpty(milkList)){
			TMstOrderStud obj = new TMstOrderStud();
			obj.setSalesOrg(user.getSalesOrg());
			obj.setOrderDateStr(model.getOrderDateStr());
			for(TMstOrderStud item : milkList){
				obj.setMatnr(item.getMatnr());
				obj.setOrderType("10");
				String list10Sum = orderStudItemMapper.findSumBySelective(obj);//学生奶数量
				obj.setOrderType("20");
				String list20Sum = orderStudItemMapper.findSumBySelective(obj);//老师奶数量
				obj.setOrderType("");
				String list30Sum = orderStudItemMapper.findLossSumBySelective(obj);//损耗奶数量
				String totalSum = String.valueOf(Integer.parseInt(list10Sum)+Integer.parseInt(list20Sum)+Integer.parseInt(list30Sum));
				item.setList10Sum(list10Sum);
				item.setList20Sum(list20Sum);
				item.setList30Sum(list30Sum);
				item.setTotalSum(totalSum);
			}
		}
		
		/**
		 * 补损的学生奶汇总数
		 */
		List<TMstOrderStud> milkFillList = mstOrderStudMapper.findMatnrWithOrderFill(selectObj);
		if(CollectionUtils.isNotEmpty(milkFillList)){
			TMstOrderStud obj = new TMstOrderStud();
			obj.setSalesOrg(user.getSalesOrg());
			obj.setOrderDateStr(model.getOrderDateStr());
			for(TMstOrderStud item : milkFillList){
				obj.setMatnr(item.getMatnr());
				obj.setOrderType("20");
				String list20Sum = orderStudItemMapper.findSumBySelectiveFill(obj);//学校奶数量
				obj.setOrderType("");
				String list30Sum = orderStudItemMapper.findLossSumBySelectiveFill(obj);//损耗奶数量
				String totalSum = String.valueOf(Integer.parseInt(list20Sum)+Integer.parseInt(list30Sum));
				item.setList20Sum(list20Sum);
				item.setList30Sum(list30Sum);
				item.setTotalSum(totalSum);
			}
		}
		
		/**
		 * 不需包装的学生奶汇总数
		 */
		List<TMstOrderStud> milkUnpackList = mstOrderStudMapper.findMatnrWithOrderUnpack(selectObj);
		if(CollectionUtils.isNotEmpty(milkUnpackList)){
			TMstOrderStud obj = new TMstOrderStud();
			obj.setSalesOrg(user.getSalesOrg());
			obj.setOrderDateStr(model.getOrderDateStr());
			for(TMstOrderStud item : milkUnpackList){
				obj.setMatnr(item.getMatnr());
				obj.setOrderType("20");
				String list20Sum = orderStudItemMapper.findSumBySelectiveUnpack(obj);//学校奶数量
				obj.setOrderType("");
				String list30Sum = orderStudItemMapper.findLossSumBySelectiveUnpack(obj);//损耗奶数量
				String totalSum = String.valueOf(Integer.parseInt(list20Sum)+Integer.parseInt(list30Sum));
				item.setList20Sum(list20Sum);
				item.setList30Sum(list30Sum);
				item.setTotalSum(totalSum);
			}
		}
		
		/**
		 * 需包装和不需包装的学生奶汇总数
		 * 整合不需包装的学生奶汇总数和需包装的学生奶汇总数和补损的学生奶汇总数
		 */
		List<TMstOrderStud> sumMilkList = new ArrayList<TMstOrderStud>();
		this.fullMilkUnpack(sumMilkList, sumMilkList, milkUnpackList);
		this.fullMilkFill(sumMilkList, milkFillList);
		
		
		/**
		 * 需包装的学生奶明细数
		 */
		List<TMstOrderStud> itemList = mstOrderStudMapper.findSchoolWithOrder(selectObj);
		if(CollectionUtils.isNotEmpty(itemList)){
			TMstOrderStud obj = new TMstOrderStud();
			obj.setSalesOrg(user.getSalesOrg());
			obj.setOrderDateStr(model.getOrderDateStr());
			for(TMstOrderStud item : itemList){
				item.setSalesOrg(user.getSalesOrg());
				item.setOrderDateStr(model.getOrderDateStr());
				obj.setSchoolCode(item.getSchoolCode());
				obj.setMatnr(item.getMatnr());
				obj.setOrderType("10");
				String list10Sum = orderStudItemMapper.findSumBySelective(obj);//学生奶数量
				obj.setOrderType("20");
				String list20Sum = orderStudItemMapper.findSumBySelective(obj);//老师奶数量
				obj.setOrderType("");
				String list30Sum = orderStudItemMapper.findLossSumBySelective(obj);//损耗奶数量
				String totalSum = String.valueOf(Integer.parseInt(list10Sum)+Integer.parseInt(list20Sum)+Integer.parseInt(list30Sum));
				item.setList10Sum(list10Sum);
				item.setList20Sum(list20Sum);
				item.setList30Sum(list30Sum);
				item.setTotalSum(totalSum);
			}
		}
		
		return buildExportFile(model.getOrderDateStr(), null == milkList?new ArrayList<TMstOrderStud>():milkList, sumMilkList,  null == itemList?new ArrayList<TMstOrderStud>():itemList);
	}
	
	private String buildExportFile(String orderDateStr, List<TMstOrderStud> milkList, List<TMstOrderStud> sumMilkList, List<TMstOrderStud> itemList) throws Exception{
		
		String nfile = getCode().concat("StudOrderMilkTemplate.xls");
		String url = EnvContant.getSystemConst("filePath");
		File file = new File(url +  File.separator + "report"+ File.separator + "template" + File.separator + "StudOrderMilkTemplate.xls");  
        FileInputStream input = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(input);
       
        this.buildExportFileSheet0(milkList, workbook, orderDateStr);
        this.buildExportFileSheet1(sumMilkList, workbook, orderDateStr);
        this.buildExportFileSheet2(itemList, workbook, orderDateStr);
        this.buildExportFileSheet3(itemList, workbook, orderDateStr);
        this.buildExportFileSheet4(itemList, workbook, orderDateStr);
        //this.buildExportFileSheet5(itemList, workbook, orderDateStr);
        
        
        File export = new File(url +  File.separator + "report"+ File.separator + "export" + File.separator + nfile);
        FileOutputStream stream = new FileOutputStream(export);
        workbook.write(stream);
        stream.flush();
        stream.close();
        return nfile;
	}
	
	/**
	 * 汇总数-分包
	 * @param milkList
	 * @param workbook
	 * @param orderDateStr
	 * @throws ParseException
	 */
	private void buildExportFileSheet0(List<TMstOrderStud> milkList, Workbook workbook, String orderDateStr) throws ParseException{
		//sheet0(汇总数-分包)
		String orderDateStr2 = new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr));
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        cell.setCellValue(orderDateStr2.concat("需包装的学生奶汇总数"));
        int r = 2;
        for(TMstOrderStud item : milkList) {
        	if("0".equals(item.getList10Sum()) && "0".equals(item.getList20Sum())
        			&& "0".equals(item.getList30Sum()) && "0".equals(item.getTotalSum())){
        		continue;
        	}
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(item.getMatnrTxt());//品种
            cell = row.createCell(1);
            cell.setCellValue(item.getZbotCodeName());//单位
            cell = row.createCell(2);
            cell.setCellValue(item.getList10Sum());//班级奶
            cell = row.createCell(3);
            cell.setCellValue(item.getList20Sum());//老师奶
            cell = row.createCell(4);
            cell.setCellValue(item.getList30Sum());//补损奶
            cell = row.createCell(5);
            cell.setCellValue(item.getTotalSum());//合计
            r++;
        }
	}
	
	/**
	 * 汇总数-分包+不分包
	 * @param sumMilkList
	 * @param workbook
	 * @param orderDateStr
	 * @throws ParseException
	 */
	private void buildExportFileSheet1(List<TMstOrderStud> sumMilkList, Workbook workbook, String orderDateStr) throws ParseException{
		//sheet1(汇总数-分包+不分包)
		String orderDateStr2 = new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr));
		Sheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
	    cell.setCellValue(orderDateStr2.concat("需包装和不需包装的学生奶汇总数"));
	    int r = 2;
	    for(TMstOrderStud item : sumMilkList) {
	    	if("0".equals(item.getList10Sum()) && "0".equals(item.getList20Sum())
	    			&& "0".equals(item.getList30Sum()) && "0".equals(item.getTotalSum())){
	    		continue;
	    	}
	        row = sheet.createRow(r);
	        cell = row.createCell(0);
	        cell.setCellValue(item.getMatnrTxt());//品种
	        cell = row.createCell(1);
	        cell.setCellValue(item.getZbotCodeName());//单位
	        cell = row.createCell(2);
	        cell.setCellValue(item.getList20Sum());//不需包装的学校奶
	        cell = row.createCell(3);
	        cell.setCellValue(item.getList30Sum());//不需包装的补损奶
	        cell = row.createCell(4);
	        cell.setCellValue(item.getTotalSum());//合计
	        r++;
	    }
	}

	/**
	 * 学校汇总
	 * @param itemList
	 * @param workbook
	 * @param orderDateStr
	 * @throws ParseException
	 */
	private void buildExportFileSheet2(List<TMstOrderStud> itemList, Workbook workbook, String orderDateStr) throws ParseException{
		//sheet2(学校汇总数)
		String orderDateStr2 = new SimpleDateFormat("yyyy年MM月dd日").format(new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr));
	    Sheet sheet = workbook.getSheetAt(2);
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    cell.setCellValue(orderDateStr2.concat("需包装的学生奶明细数"));
	    int r = 2;
	    for(TMstOrderStud item : itemList) {
	    	if("0".equals(item.getList10Sum()) && "0".equals(item.getList20Sum())
	    			&& "0".equals(item.getList30Sum()) && "0".equals(item.getTotalSum())){
	    		continue;
	    	}
	        row = sheet.createRow(r);
	        cell = row.createCell(0);
	        cell.setCellValue(item.getErpCode());//编号
	        cell = row.createCell(1);
	        cell.setCellValue(item.getSchoolName());//学校
	        cell = row.createCell(2);
	        cell.setCellValue(item.getMatnrTxt());//品种
	        cell = row.createCell(3);
	        cell.setCellValue(item.getZbotCodeName());//单位
	        cell = row.createCell(4);
	        cell.setCellValue(item.getList10Sum());//班级奶
	        cell = row.createCell(5);
	        cell.setCellValue(item.getList20Sum());//老师奶
	        cell = row.createCell(6);
	        cell.setCellValue(item.getList30Sum());//补损奶
	        cell = row.createCell(7);
	        cell.setCellValue(item.getTotalSum());//合计
	        r++;
	    }
	}

	/**
	 * 标签
	 * @param itemList
	 * @param workbook
	 * @param orderDateStr
	 * @throws ParseException
	 */
	private void buildExportFileSheet3(List<TMstOrderStud> itemList, Workbook workbook, String orderDateStr) throws ParseException{
		//sheet3(标签)
		String orderDateStr3 = new SimpleDateFormat("yyyy/MM/dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(orderDateStr));
	    List<TMstOrderStud> classItemList = null;
	    Sheet sheet = workbook.getSheetAt(3);
	    Row row = null;
	    Cell cell = null;
	    int r = -1; 
	    CellStyle styleBold = workbook.createCellStyle();
	    styleBold.setBottomBorderColor(HSSFColor.BLUE.index);
	    for(TMstOrderStud item : itemList) {
	    	if("0".equals(item.getList10Sum()) && "0".equals(item.getList20Sum())
	    			&& "0".equals(item.getList30Sum()) && "0".equals(item.getTotalSum())){
	    		continue;
	    	}
	    	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(item.getSchoolCode(), this.userSessionService.getCurrentUser().getSalesOrg()));
	    	
	    	//学校班级标签
	    	if(!"0".equals(item.getList10Sum())){
	    		classItemList = orderStudItemMapper.findClassOrderItemByOrderStud(item);
	    		if(CollectionUtils.isNotEmpty(classItemList)){
	    			for(TMstOrderStud classItem : classItemList) {
	    				if("0".equals(classItem.getQty())){
	    					continue;
	    				}
	    				r += 1;
	            		row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue(orderDateStr3);//时间
	                    r += 1;
	                    row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue(item.getMatnrTxt());//奶品
	                    r += 1;
	                    row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue(item.getSchoolName());//学校
	                    r += 1;
	                    row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue(null!=school?school.getDispatchingName():"配送商不详");//配送商
	                    r += 1;
	                    row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue(classItem.getClassName());//老师奶/班级/补损奶
	                    r += 1;
	                    row = sheet.createRow(r);
	                    cell = row.createCell(0);
	                    cell.setCellValue("数量  "+classItem.getQty()+"  "+item.getZbotCodeName());//数量
	    			}
	    		}
	    	}
	    	
	    	//学校老师标签
	    	if(!"0".equals(item.getList20Sum())){
	    		r += 1;
	    		row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(orderDateStr3);//时间
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(item.getMatnrTxt());//奶品
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(item.getSchoolName());//学校
	            r += 1;
                row = sheet.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue(null!=school?school.getDispatchingName():"配送商不详");//配送商
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue("老师奶");//老师奶/班级/补损奶
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue("数量  "+item.getList20Sum()+"  "+item.getZbotCodeName());//数量
	    	}
	    	
	    	
	    	//学校补损标签
	    	if(!"0".equals(item.getList30Sum())){
	    		r += 1;
	    		row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(orderDateStr3);//时间
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(item.getMatnrTxt());//奶品
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue(item.getSchoolName());//学校
	            r += 1;
                row = sheet.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue(null!=school?school.getDispatchingName():"配送商不详");//配送商
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue("补损奶");//老师奶/班级/补损奶
	            r += 1;
	            row = sheet.createRow(r);
	            cell = row.createCell(0);
	            cell.setCellValue("数量  "+item.getList30Sum()+"  "+item.getZbotCodeName());//数量
	    	}
	    }
	}

	/**
	 * 学校分奶
	 * @param itemList
	 * @param workbook
	 * @param orderDateStr
	 */
	private void buildExportFileSheet4(List<TMstOrderStud> itemList, Workbook workbook, String orderDateStr){
		//sheet4,学校分奶
		if(CollectionUtils.isEmpty(itemList)){
			return;
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		
    	Set<String> schoolCodeSet = new HashSet<String>();//当期所有的学校
    	for (TMstOrderStud item : itemList) {
    		schoolCodeSet.add(item.getSchoolCode());
		}
    	Sheet sheet = workbook.createSheet("学校分奶");
        sheet.setDefaultColumnWidth(24);
		sheet.setDefaultRowHeightInPoints(25);
		
		CellStyle style1 = workbook.createCellStyle();
		style1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);   
        style1.setAlignment(CellStyle.ALIGN_CENTER);
        Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short)16);
        font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style1.setFont(font1);
        
        CellStyle style2 = workbook.createCellStyle();
		style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);   
        style2.setAlignment(CellStyle.ALIGN_LEFT);
        Font font2 = workbook.createFont();
        font2.setFontHeightInPoints((short)14);//字号
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style2.setFont(font2);
        
        CellStyle style3 = workbook.createCellStyle();
		style3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);   
        style3.setAlignment(CellStyle.ALIGN_RIGHT);
        Font font3 = workbook.createFont();
        font3.setFontHeightInPoints((short)14);//字号
        font3.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style3.setFont(font3);
        
        Row row = null;
    	Cell cell = null; 
        int r = -1;
        
        //创建表格数据
        for(String schoolCode : schoolCodeSet){
        	TMstOrderStud orderStud = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(new TMstOrderStud(schoolCode, user.getSalesOrg(), orderDateStr));
        	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(schoolCode, user.getSalesOrg()));
        	if(null == orderStud){
        		logger.info("学校{}当日{}订单不存在", schoolCode, orderDateStr);
        		continue;
        	}
        	if(null == school){
        		logger.info("学校{}不存在", schoolCode);
        		continue;
        	}
        	
        	row = sheet.createRow(++r);//0
            cell = row.createCell(0);
            cell.setCellStyle(style1);
            cell.setCellValue("奶站所辖明细表");
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 3));
            
            //线路是卸货点，车次是配送商
            row = sheet.createRow(++r);//1
            cell = row.createCell(0);
            cell.setCellStyle(style2);
            cell.setCellValue("站名："+school.getSchoolName());
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
            
            row = sheet.createRow(++r);//2
            cell = row.createCell(0);
            cell.setCellStyle(style2);
            cell.setCellValue("线路："+StringUtils.defaultString(school.getUnloadName()));
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
            cell = row.createCell(1);
            cell = row.createCell(2);
            cell.setCellStyle(style2);
            cell.setCellValue("车次："+StringUtils.defaultString(school.getDispatchingName()));
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 2, 3));
            
            row = sheet.createRow(++r);//3
            cell = row.createCell(0);
            cell.setCellStyle(style2);
            cell.setCellValue("日期："+orderDateStr);
            sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
            
            int list10QtyCount = 0;
            int list20QtyCount = 0;
            int list30QtyCount = 0;
            
    		//学生奶
			Map<String, Object> selectMap = new HashMap<>();
			selectMap.put("orderId", orderStud.getOrderId());
			selectMap.put("orderType", "10");
			selectMap.put("salesOrg", user.getSalesOrg());
			List<TMstOrderStudItem> list10 = orderStudItemMapper.findOrderItemByMap(selectMap);
			if(CollectionUtils.isNotEmpty(list10)){
				row = sheet.createRow(++r);//4;
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("品名："+list10.get(0).getMatnrTxt());
		        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
		        
		        row = sheet.createRow(++r);//5
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("班级");
		        cell = row.createCell(1);
		        cell.setCellStyle(style2);
		        cell.setCellValue("数量");
		        cell = row.createCell(2);
		        cell.setCellStyle(style2);
		        cell.setCellValue("班级");
		        cell = row.createCell(3);
		        cell.setCellStyle(style2);
		        cell.setCellValue("数量");
		        
		        int totalSize = list10.size();
		        int rowSize = (totalSize%2!=0)?(totalSize+1)/2:totalSize/2;
		        Queue<Row> queue = new LinkedBlockingDeque<Row>();
				for (int i = 0; i < list10.size(); i++) {
					list10QtyCount += list10.get(i).getQty();
//					if(i % 2 == 0){
					if((i+1) <= rowSize){
						row = sheet.createRow(++r);//6
				        cell = row.createCell(0);
				        cell.setCellStyle(style2);
				        cell.setCellValue(list10.get(i).getClassName());//班级名称
				        cell = row.createCell(1);
				        cell.setCellStyle(style2);
				        cell.setCellValue(String.valueOf(list10.get(i).getQty()));//班级喝奶数量
				        queue.offer(row);
					}
					else{
						row = queue.poll();
						cell = row.createCell(2);
				        cell.setCellStyle(style2);
				        cell.setCellValue(list10.get(i).getClassName());
				        cell = row.createCell(3);
				        cell.setCellStyle(style2);
				        cell.setCellValue(String.valueOf(list10.get(i).getQty()));
					}
				}
				
				row = sheet.createRow(++r);
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("小计");
		        cell = row.createCell(1);
		        cell.setCellStyle(style3);
		        cell.setCellValue(String.valueOf(list10QtyCount));
		        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 3));
		        
			}
			
			//老师奶
			selectMap.put("orderType", "20");
			List<TMstOrderStudItem> list20 = orderStudItemMapper.findOrderItemByMap(selectMap);
			if(CollectionUtils.isNotEmpty(list20)){
				row = sheet.createRow(++r);
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("教师");
		        cell = row.createCell(1);
		        cell.setCellStyle(style1);
		        cell.setCellValue("");
		        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 3));
		        
				for (int i = 0; i < list20.size(); i++) {
					list20QtyCount += list20.get(i).getQty();
					row = sheet.createRow(++r);
			        cell = row.createCell(0);
			        cell.setCellStyle(style1);
			        cell.setCellValue("");
			        cell = row.createCell(1);
			        cell.setCellStyle(style2);
			        cell.setCellValue(list20.get(i).getMatnrTxt());//奶品名称
			        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 2));
			        cell = row.createCell(3);
			        cell.setCellStyle(style3);
			        cell.setCellValue(String.valueOf(list20.get(i).getQty()));//奶品数量
				}
			}
			
			//损耗
			List<TMstOrderStudLoss> list30 = orderStudLossMapper.findLossByOrderId(selectMap);
			if(CollectionUtils.isNotEmpty(list30)){
				row = sheet.createRow(++r);
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("补损");
		        cell = row.createCell(1);
		        cell.setCellStyle(style1);
		        cell.setCellValue("");
		        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 3));
		        
				for (int i = 0; i < list30.size(); i++) {
					list30QtyCount += list30.get(i).getQty();
					row = sheet.createRow(++r);
			        cell = row.createCell(0);
			        cell.setCellStyle(style1);
			        cell.setCellValue("");
			        cell = row.createCell(1);
			        cell.setCellStyle(style2);
			        cell.setCellValue(list30.get(i).getMatnrTxt());//奶品名称
			        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 2));
			        cell = row.createCell(3);
			        cell.setCellStyle(style3);
			        cell.setCellValue(String.valueOf(list30.get(i).getQty()));//奶品数量
				}
			}
			if(list20QtyCount > 0 || list30QtyCount > 0){
				row = sheet.createRow(++r);
		        cell = row.createCell(0);
		        cell.setCellStyle(style2);
		        cell.setCellValue("小计");
		        cell = row.createCell(1);
		        cell.setCellStyle(style3);
		        cell.setCellValue(String.valueOf(list20QtyCount+list30QtyCount));
		        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 3));
			}
			row = sheet.createRow(++r);
	        cell = row.createCell(0);
	        cell.setCellStyle(style2);
	        cell.setCellValue("合计");
	        cell = row.createCell(1);
	        cell.setCellStyle(style3);
	        cell.setCellValue(String.valueOf(list10QtyCount+list20QtyCount+list30QtyCount));
	        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 1, 3));
	        
	        r++;//每个项目再空一行
        }
	}
	
	/**
	 * 奶站销售汇总
	 * 学校数量核对表（奶站销售汇总）
	 * 
	 * 1、	不计算损耗数量
		2、	老师奶、学生奶、分包、不分包都合在一起的
		3、	产品如果所有学校都为0就不显示
		4、	数字为0，留空
	 * @param itemList
	 * @param workbook
	 * @param orderDateStr
	 */
	private void buildExportFileSheetSum(Workbook workbook, String startOrderDateStr, String endOrderDateStr){
		TSysUser user = this.userSessionService.getCurrentUser();
    	
		//奶站销售汇总
//		workbook.setSheetName(0, "学校销售汇总");
    	Sheet sheet = workbook.getSheetAt(0);
        sheet.setDefaultColumnWidth(24);
		sheet.setDefaultRowHeightInPoints(25);
		
		CellStyle style1 = workbook.createCellStyle();
		style1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);   
        style1.setAlignment(CellStyle.ALIGN_CENTER);
        Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short)16);
        font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style1.setFont(font1);
        
        CellStyle style2 = workbook.createCellStyle();
		style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);   
        style2.setAlignment(CellStyle.ALIGN_LEFT);
        Font font2 = workbook.createFont();
        font2.setFontHeightInPoints((short)12);//字号
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style2.setFont(font2);
        
        Row row = null;
    	Cell cell = null; 
        int r = -1;
        
        row = sheet.createRow(++r);//0
        cell = row.createCell(0);
        cell.setCellStyle(style1);
        cell.setCellValue("学校销售汇总表");
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 3));
        
        row = sheet.createRow(++r);//1
        cell = row.createCell(0);
        cell.setCellStyle(style2);
        cell.setCellValue("账期：所有");
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
        cell = row.createCell(1);
        cell = row.createCell(2);
        cell.setCellStyle(style2);
        cell.setCellValue("奶亭：所有");
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 2, 3));
        
        row = sheet.createRow(++r);//2
        cell = row.createCell(0);
        cell.setCellStyle(style2);
        cell.setCellValue("奶站类别：所有类别");
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
        cell = row.createCell(1);
        cell = row.createCell(2);
        cell.setCellStyle(style2);
        cell.setCellValue("牛奶品种类别：所有类别");
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 2, 3));
        
        row = sheet.createRow(++r);//3
        cell = row.createCell(0);
        cell.setCellStyle(style2);
        cell.setCellValue("开始日期："+startOrderDateStr);
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 0, 1));
        cell = row.createCell(1);
        cell = row.createCell(2);
        cell.setCellStyle(style2);
        cell.setCellValue("结束日期："+endOrderDateStr);
        sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), 2, 3));
        row = sheet.createRow(++r);//4 空一行
        
        Set<String> schoolCodeSet = new HashSet<String>();//当期所有的学校
    	List<String> itemList = mstOrderStudMapper.findAllSchoolByOrderDateBetwen(user.getSalesOrg(), startOrderDateStr, endOrderDateStr);
    	
		if(null == itemList || itemList.size() == 0){
    		return;
    	}
    	for (String item : itemList) {
    		schoolCodeSet.add(item);
		}
    	
        //数据准备
        Map<String, HashMap<String, Integer>> dataMap = new HashMap<>();
        List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
        if(CollectionUtils.isEmpty(maraList)){
        	return ;
        }
        
        //所有奶品
        maraList.forEach(item->{
        	dataMap.put(item.getMatnr(),  new HashMap<String, Integer>());
        });
        
        //dataMap:数据准备
        for (Entry<String, HashMap<String, Integer>> entryItem : dataMap.entrySet()) {
			String matnr = entryItem.getKey();
			HashMap<String, Integer> entryVal = entryItem.getValue();
			for(String schoolCode : schoolCodeSet){
				int matnrCount = 0;
				
				//继续累加
				//分包
				matnrCount += orderStudItemMapper.findMatnrCountByMap("t_mst_order_stud_item", matnr, startOrderDateStr, endOrderDateStr,  schoolCode, user.getSalesOrg());
				
				//不分包
				matnrCount += orderStudItemMapper.findMatnrCountByMap("t_mst_order_stud_item_unpack", matnr, startOrderDateStr, endOrderDateStr, schoolCode, user.getSalesOrg());
				
				//补单
				matnrCount += orderStudItemMapper.findMatnrCountByMap("t_mst_order_stud_item_fill", matnr, startOrderDateStr, endOrderDateStr, schoolCode, user.getSalesOrg());
				entryVal.put(schoolCode, matnrCount);
			}
			
		}
        
        //数据过滤:产品如果所有学校都为0就不显示
        List<String> delMaraList = new ArrayList<String>();
        for (Entry<String, HashMap<String, Integer>> entryItem : dataMap.entrySet()) {
        	HashMap<String, Integer> entryVal = entryItem.getValue();
        	if(entryVal.size() > 0){
        		boolean flag = true;//默认都为0
        		for(Entry<String, Integer> item : entryVal.entrySet()){
        			if(item.getValue() > 0){
        				flag = false;
        				break;
        			}
        		}
        		if(flag){
        			delMaraList.add(entryItem.getKey());
        		}
        	}
        }
        if(delMaraList.size() > 0){
        	delMaraList.stream().forEach(item->{
        		dataMap.remove(item);
        	});
        }
        
        //填写表格数据
        int c = -1;
        row = sheet.createRow(++r);
        cell = row.createCell(++c);
        cell.setCellStyle(style2);
        cell.setCellValue("代码");
        cell = row.createCell(++c);
        cell.setCellStyle(style2);
        cell.setCellValue("名称");
        
        //表格头数据
        List<String> baseMaraList = new ArrayList<String>();
        for (Entry<String, HashMap<String, Integer>> entryItem : dataMap.entrySet()) {
        	TMdMaraStud mara = maraStudMapper.selectMaraByMap(entryItem.getKey(), user.getSalesOrg());
        	if(null == mara){
        		logger.info("奶品"+entryItem.getKey()+"不存在");
        		continue;
        	}
        	baseMaraList.add(mara.getMatnr());
        	cell = row.createCell(++c);
            cell.setCellStyle(style2);
            cell.setCellValue(StringUtils.isNotBlank(mara.getShortTxt())?mara.getShortTxt():mara.getMatnrTxt());
        }
        cell = row.createCell(++c);
        cell.setCellStyle(style2);
        cell.setCellValue("合计");
        
        //表格内容数据
        for(String schoolCode : schoolCodeSet){
        	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(schoolCode, user.getSalesOrg()));
        	if(null == school){
        		logger.info("学校{}不存在", schoolCode);
        		continue;
        	}
        	c = -1;
        	row = sheet.createRow(++r);
        	cell = row.createCell(++c);
            cell.setCellStyle(style2);
            cell.setCellValue(school.getErpCode());//学校代码
            cell = row.createCell(++c);
            cell.setCellStyle(style2);
            cell.setCellValue(school.getSchoolName());//学校名称
            int allCount = 0;
        	for(String matnr : baseMaraList){
        		int count = this.fulishMaraCountFromMap(dataMap, matnr, schoolCode);
        		allCount += count;
        		cell = row.createCell(++c);
                cell.setCellStyle(style2);
                cell.setCellValue(count>0?String.valueOf(count):"");//数量
        	}
        	cell = row.createCell(++c);
            cell.setCellStyle(style2);
            cell.setCellValue(allCount>0?String.valueOf(allCount):"");//合计
		}
	}
	
	private int fulishMaraCountFromMap(Map<String, HashMap<String, Integer>> dataMap, String matnr, String schoolCode){
		if(null == dataMap || dataMap.size() == 0){
			return 0;
		}
		for (Entry<String, HashMap<String, Integer>> entryItem : dataMap.entrySet()) {
			if(entryItem.getKey().equals(matnr)){
				for(Entry<String, Integer> item : entryItem.getValue().entrySet()){
					if(item.getKey().equals(schoolCode)){
						return item.getValue();
					}
        		}
				break;
			}
		}
		return 0;
	}
	
	@Override
	public int createOrderUnpack(TMstOrderStud mstOrderStud) throws Exception {

		/**
		 * 校验
		 */
		if(null == mstOrderStud){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "参数必传");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期必选");
		}
		if(StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校必选");
		}
		if(null == mstOrderStud.getList20() || mstOrderStud.getList20().size() == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订奶列表必传");
		}
		boolean flag = false;
		for(TMstOrderStudItem item : mstOrderStud.getList20()){
			if(null != item.getQty() && item.getQty() > 0){
				flag = true;
				break;
			}
		}
		if(!flag){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订奶列表中的奶品数量不能全是0");
		}
		
		
		/**
		 * 生成订单
		 */
		Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(mstOrderStud.getOrderDateStr());
		Date date = new Date();
		TSysUser user = this.userSessionService.getCurrentUser();
		
		TMstOrderStud order = new TMstOrderStud();
		order.setSchoolCode(mstOrderStud.getSchoolCode());
		order.setOrderDateStr(mstOrderStud.getOrderDateStr());
		order.setSalesOrg(user.getSalesOrg());
		order = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(order);
		
		String orderId = null == order?getCode():order.getOrderId();
		if(null == order){
			
			//创建主订单
			mstOrderStud.setOrderId(orderId);
			mstOrderStud.setOrderDate(orderDate);
			mstOrderStud.setCreateAt(date);
			mstOrderStud.setCreateBy(user.getLoginName());
			mstOrderStud.setCreateByTxt(user.getDisplayName());
			mstOrderStud.setLastModified(date);
			mstOrderStud.setLastModifiedBy(user.getLoginName());
			mstOrderStud.setLastModifiedByTxt(user.getDisplayName());
			mstOrderStud.setSalesOrg(user.getSalesOrg());
			mstOrderStud.setOrderStatus("10");
			mstOrderStud.setIsBatch("20");
			mstOrderStudMapper.insertOrder(mstOrderStud);
		}
		else{
			
			//已发送ERP的不能被覆盖和删除
        	if("10".equals(order.getErpOrderStatus()) 
        			|| "10".equals(order.getErpOrderFreeStatus())
        			|| "10".equals(order.getErpOrderFillStatus())){
        		throw new ServiceException(MessageCode.LOGIC_ERROR, "已发送ERP的订单不能被更新");
        	}
        	
			//物理删除
			orderStudItemMapper.deleteOrderItemByOrderIdUnpack(orderId);
			orderStudLossMapper.deleteByOrderIdUnpack(orderId);
			
			//更新订单
			TMstOrderStud updateOrderStud = new TMstOrderStud();
			updateOrderStud.setOrderId(orderId);
			updateOrderStud.setLastModified(new Date());
			updateOrderStud.setLastModifiedBy(user.getLoginName());
			updateOrderStud.setLastModifiedByTxt(user.getDisplayName());
			updateOrderStud.setIsBatch("20");
			mstOrderStudMapper.updateByOrder(updateOrderStud);
		}
		
	    List<TMstOrderStudItem> list20 = mstOrderStud.getList20();//订奶列表
	    if(CollectionUtils.isNotEmpty(list20)){
	    	for(TMstOrderStudItem item : list20){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setSchoolCode(mstOrderStud.getSchoolCode());
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setOrderDate(orderDate);
	    		item.setOrderType("20");
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudItemMapper.insertSdutOrderItemUnpack(item);
	    	}
	    }
	    
	    List<TMstOrderStudLoss> list30 = mstOrderStud.getList30();//损耗
	    if(CollectionUtils.isNotEmpty(list30)){
	    	for(TMstOrderStudLoss item : list30){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudLossMapper.insertOrderStudLossUnpack(item);
	    	}
	    }
		return 1;
	
	}
	
	@Override
	public int createOrderFill(TMstOrderStud mstOrderStud) throws Exception {

		/**
		 * 校验
		 */
		if(null == mstOrderStud){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "参数必传");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期必选");
		}
		if(StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校必选");
		}
		if(null == mstOrderStud.getList20() || mstOrderStud.getList20().size() == 0){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "补单奶品列表必传");
		}
		boolean flag = false;
		for(TMstOrderStudItem item : mstOrderStud.getList20()){
			if(null != item.getQty() && item.getQty() > 0){
				flag = true;
				break;
			}
		}
		if(!flag){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "订奶列表中的奶品数量不能全是0");
		}
		
		
		/**
		 * 生成订单
		 */
		Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(mstOrderStud.getOrderDateStr());
		Date date = new Date();
		TSysUser user = this.userSessionService.getCurrentUser();
		
		TMstOrderStud order = new TMstOrderStud();
		order.setSchoolCode(mstOrderStud.getSchoolCode());
		order.setOrderDateStr(mstOrderStud.getOrderDateStr());
		order.setSalesOrg(user.getSalesOrg());
		order = mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(order);
		
		String orderId = null==order?null:order.getOrderId();
		if(null == order){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "目标日期".concat(mstOrderStud.getOrderDateStr()).concat("还未生成正常销售订单，不能补单"));
		}
		else{
			
			//已发送ERP的不能被覆盖和删除
        	if("10".equals(order.getErpOrderFillStatus())){
        		throw new ServiceException(MessageCode.LOGIC_ERROR, "该补单数据已发送ERP(单号："+order.getErpOrderFillId()+")，不能被更新");
        	}
        	
			//物理删除
			orderStudItemMapper.deleteOrderItemByOrderIdFill(orderId);
			orderStudLossMapper.deleteByOrderIdFill(orderId);
		}
		
	    List<TMstOrderStudItem> list20 = mstOrderStud.getList20();//订奶列表
	    if(CollectionUtils.isNotEmpty(list20)){
	    	for(TMstOrderStudItem item : list20){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setSchoolCode(mstOrderStud.getSchoolCode());
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setOrderDate(orderDate);
	    		item.setOrderType("20");
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudItemMapper.insertSdutOrderItemFill(item);
	    	}
	    }
	    
	    List<TMstOrderStudLoss> list30 = mstOrderStud.getList30();//损耗
	    if(CollectionUtils.isNotEmpty(list30)){
	    	for(TMstOrderStudLoss item : list30){
	    		if(StringUtils.isBlank(item.getMatnr())){
	    			continue;
	    		}
	    		if(item.getQty() == null || item.getQty() <= 0){
	    			continue;
	    		}
	    		item.setOrderId(orderId);
	    		item.setMid(UUID.randomUUID().toString().replace("-", ""));
	    		item.setCreateAt(date);
	    		item.setCreateBy(user.getLoginName());
	    		item.setCreateByTxt(user.getDisplayName());
	    		item.setLastModified(date);
	    		item.setLastModifiedBy(user.getLoginName());
	    		item.setLastModifiedByTxt(user.getDisplayName());
	    		item.setSalesOrg(user.getSalesOrg());
	    		orderStudLossMapper.insertOrderStudLossFill(item);
	    	}
	    }
		return 1;
	
	}

	@Override
	public Map<String, Object> findOrderInfoBySchoolCodeAndDateUnpack(TMstOrderStud mstOrderStud) {

		if(null == mstOrderStud || StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传，请选择学校站点");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数的订单日期必传，请选择取数的订单日期");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		mstOrderStud.setSalesOrg(user.getSalesOrg());
		Map<String, Object> resultMap = new HashMap<>();
		TMstOrderStud orderStud = this.mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(mstOrderStud);
		
		if(null == orderStud){
			//学校不存在该日期的订单，则初始化数据
			resultMap.put("orderStud", null);
			
			//奶品
			List<TMstOrderStudItem> list20 = new ArrayList<TMstOrderStudItem>();
			List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudItem item20 = null;
				for(TMdMaraStud mara : maraList){
					item20 = new TMstOrderStudItem();
					item20.setQty(0);
					item20.setMatnr(mara.getMatnr());
					item20.setMatnrTxt(mara.getMatnrTxt());
					item20.setZbotCode(mara.getZbotCode());
					item20.setZbotCodeName(mara.getZbotCodeName());
					list20.add(item20);
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = new ArrayList<TMstOrderStudLoss>();
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudLoss item30 = null;
				for(TMdMaraStud mara : maraList){
					item30 = new TMstOrderStudLoss();
					item30.setQty(0);
					item30.setMatnr(mara.getMatnr());
					item30.setMatnrTxt(mara.getMatnrTxt());
					item30.setZbotCode(mara.getZbotCode());
					item30.setZbotCodeName(mara.getZbotCodeName());
					list30.add(item30);
				}
			}
			resultMap.put("list30", list30);
		}
		else{
			//存在订单，返回信息
			resultMap.put("orderStud", orderStud);
			
			//奶品
			Map<String, Object> selectMap = new HashMap<>();
			selectMap.put("orderId", orderStud.getOrderId());
			selectMap.put("salesOrg", user.getSalesOrg());
			selectMap.put("orderType", "20");
			List<TMstOrderStudItem> list20 = orderStudItemMapper.findOrderItemByMapUnpack(selectMap);
			if(CollectionUtils.isEmpty(list20)){
				list20 = new ArrayList<TMstOrderStudItem>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudItem item : list20){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = orderStudLossMapper.findLossByOrderIdUnpack(selectMap);
			if(CollectionUtils.isEmpty(list30)){
				list30 = new ArrayList<TMstOrderStudLoss>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudLoss item : list30){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			resultMap.put("list30", list30);
		}
		return resultMap;
	
	}
	
	@Override
	public Map<String, Object> findOrderInfoBySchoolCodeAndDateFill(TMstOrderStud mstOrderStud) {

		if(null == mstOrderStud || StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传，请选择学校站点");
		}
		if(StringUtils.isBlank(mstOrderStud.getOrderDateStr())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "取数的订单日期必传，请选择订单日期");
		}
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		TSysUser user = this.userSessionService.getCurrentUser();
		mstOrderStud.setSalesOrg(user.getSalesOrg());
		Map<String, Object> resultMap = new HashMap<>();
		TMstOrderStud orderStud = this.mstOrderStudMapper.selectOrderBySchoolCodeAndDateWithOrderStatus10(mstOrderStud);
		
		if(null == orderStud){
			//学校不存在该日期的订单，则初始化数据
			resultMap.put("orderStud", null);
			
			//奶品
			List<TMstOrderStudItem> list20 = new ArrayList<TMstOrderStudItem>();
			List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudItem item20 = null;
				for(TMdMaraStud mara : maraList){
					item20 = new TMstOrderStudItem();
					item20.setQty(0);
					item20.setMatnr(mara.getMatnr());
					item20.setMatnrTxt(mara.getMatnrTxt());
					item20.setZbotCode(mara.getZbotCode());
					item20.setZbotCodeName(mara.getZbotCodeName());
					list20.add(item20);
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = new ArrayList<TMstOrderStudLoss>();
			if(CollectionUtils.isNotEmpty(maraList)){
				TMstOrderStudLoss item30 = null;
				for(TMdMaraStud mara : maraList){
					item30 = new TMstOrderStudLoss();
					item30.setQty(0);
					item30.setMatnr(mara.getMatnr());
					item30.setMatnrTxt(mara.getMatnrTxt());
					item30.setZbotCode(mara.getZbotCode());
					item30.setZbotCodeName(mara.getZbotCodeName());
					list30.add(item30);
				}
			}
			resultMap.put("list30", list30);
		}
		else{
			//存在订单，返回信息
			resultMap.put("orderStud", orderStud);
			
			//奶品
			Map<String, Object> selectMap = new HashMap<>();
			selectMap.put("orderId", orderStud.getOrderId());
			selectMap.put("salesOrg", user.getSalesOrg());
			selectMap.put("orderType", "20");
			List<TMstOrderStudItem> list20 = orderStudItemMapper.findOrderItemByMapFill(selectMap);
			if(CollectionUtils.isEmpty(list20)){
				list20 = new ArrayList<TMstOrderStudItem>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudItem item : list20){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudItem item20 = null;
					for(TMdMaraStud mara : maraList){
						item20 = new TMstOrderStudItem();
						item20.setQty(0);
						item20.setMatnr(mara.getMatnr());
						item20.setMatnrTxt(mara.getMatnrTxt());
						item20.setZbotCode(mara.getZbotCode());
						item20.setZbotCodeName(mara.getZbotCodeName());
						list20.add(item20);
					}
				}
			}
			resultMap.put("list20", list20);
			
			//损耗
			List<TMstOrderStudLoss> list30 = orderStudLossMapper.findLossByOrderIdFill(selectMap);
			if(CollectionUtils.isEmpty(list30)){
				list30 = new ArrayList<TMstOrderStudLoss>();
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrg(user.getSalesOrg());
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			else{
				List<String> notInList = new ArrayList<String>();
				for(TMstOrderStudLoss item : list30){
					notInList.add(item.getMatnr());
				}
				Map<String, Object> selectMaraMap = new HashMap<>();
				selectMaraMap.put("salesOrg", user.getSalesOrg());
				selectMaraMap.put("notInList", notInList);
				List<TMdMaraStud> maraList = maraStudMapper.findAllListBySalesOrgNotIn(selectMaraMap);
				if(CollectionUtils.isNotEmpty(maraList)){
					TMstOrderStudLoss item30 = null;
					for(TMdMaraStud mara : maraList){
						item30 = new TMstOrderStudLoss();
						item30.setQty(0);
						item30.setMatnr(mara.getMatnr());
						item30.setMatnrTxt(mara.getMatnrTxt());
						item30.setZbotCode(mara.getZbotCode());
						item30.setZbotCodeName(mara.getZbotCodeName());
						list30.add(item30);
					}
				}
			}
			resultMap.put("list30", list30);
		}
		return resultMap;
	
	}

	@Override
	public String findDefaultMaraForSchool(TMstOrderStud mstOrderStud) {
		String matnr = null;
		TSysUser user = this.userSessionService.getCurrentUser();
		if(StringUtils.isBlank(user.getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		if(null == mstOrderStud || StringUtils.isBlank(mstOrderStud.getSchoolCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "学校代码必传");
		}
		TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(mstOrderStud.getSchoolCode(), user.getSalesOrg()));
		if(null == school){
			throw new ServiceException(MessageCode.LOGIC_ERROR, mstOrderStud.getSchoolCode()+"学校不存在");
		}
		Map<String, Object> selectMap = new HashMap<String, Object>();
		selectMap.put("salesOrg", user.getSalesOrg());
		selectMap.put("schoolCode", mstOrderStud.getSchoolCode());
		TMdSchoolRule schoolRule = schoolRuleMapper.findSchoolRuleByMap(selectMap);
		if(null == schoolRule){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "未查询到学生奶品政策");
		}
		
		try {
			
			matnr = findMatnr(schoolRule, Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return matnr;
	}
	
	@Override
	public  List<TMstOrderStud>  findOrderStudByDateAndSalesOrg(){
		TSysUser currentUser = userSessionService.getCurrentUser();
		SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
		return mstOrderStudMapper.findOrderStudByDateAndSalesOrg(format.format(DateUtil.getTomorrow(new Date())),currentUser.getSalesOrg());
	} 
	
	
	
	
/*	@Override
	public String generateSalesOrder18() {
		TSysUser currentUser = userSessionService.getCurrentUser();
		String msg="";
		SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
		//获取当天所有的报货信息
		List<TMstOrderStud> list = mstOrderStudMapper.findOrderStudByDateAndSalesOrg(format.format(new Date()),currentUser.getSalesOrg());
		if(list !=null &&  list.size() > 0 ){
			for (TMstOrderStud order : list) {
				PISuccessMessage sucMsg = pIRequireOrderService.generateSalesOrder18(order);
				if (sucMsg.isSuccess()) {
					order.setErpOrderId(sucMsg.getData());
		            this.updateByOrder(order);
		        } else {
		        	throw new ServiceException(MessageCode.LOGIC_ERROR, sucMsg.getMessage());
		        }
			}
		}else{
			throw new ServiceException(MessageCode.LOGIC_ERROR,"对不起,当日可发送erp的销售订单为0！");
		}
		return msg;
	}*/

}
