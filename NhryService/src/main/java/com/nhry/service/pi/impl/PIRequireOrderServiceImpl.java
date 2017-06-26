package com.nhry.service.pi.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchExMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderItemMapper;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderMapper;
import com.nhry.data.milktrans.dao.TSsmSalOrderItemMapper;
import com.nhry.data.milktrans.dao.TSsmSalOrderMapper;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrder;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.data.milktrans.domain.TSsmSalOrderItems;
import com.nhry.data.stock.dao.TSsmGiOrderItemMapper;
import com.nhry.data.stock.dao.TSsmGiOrderMapper;
import com.nhry.data.stock.dao.TSsmSalFactoryPriceMapper;
import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.data.stock.domain.TSsmGiOrderItem;
import com.nhry.data.stock.domain.TSsmGiOrderItemKey;
import com.nhry.data.stock.domain.TSsmSalFactoryPrice;
import com.nhry.data.stock.domain.TSsmSalFactoryPriceKey;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.dao.TMstOrderStudItemMapper;
import com.nhry.data.stud.dao.TMstOrderStudLossMapper;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.data.stud.domain.TMstOrderStudItem;
import com.nhry.data.stud.domain.TMstOrderStudLoss;
import com.nhry.model.milktrans.ReqGoodsOrderItemSearch;
import com.nhry.model.milktrans.RequireOrderSearch;
import com.nhry.model.milktrans.SalOrderModel;
import com.nhry.model.stock.StockModel;
import com.nhry.model.stud.SchoolQueryModel;
import com.nhry.service.pi.dao.PIRequireOrderService;
import com.nhry.service.pi.pojo.SalesOrderHeader;
import com.nhry.utils.DateUtil;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.client.PISuccessMessage;
import com.nhry.webService.client.PISuccessTMessage;
import com.nhry.webService.client.businessData.model.Delivery;

/**
 * 要货单
 * Created by cbz on 7/4/2016.
 */
public class PIRequireOrderServiceImpl implements PIRequireOrderService {

    private static final Logger logger = Logger.getLogger(PIRequireOrderServiceImpl.class);

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private TMdBranchExMapper branchExMapper;

    private TSsmReqGoodsOrderItemMapper tSsmReqGoodsOrderItemMapper;

    private TSsmGiOrderMapper ssmGiOrderMapper;

    private TSsmGiOrderItemMapper ssmGiOrderItemMapper;

    private TSsmReqGoodsOrderMapper tSsmReqGoodsOrderMapper;

    private TSsmSalOrderItemMapper tSsmSalOrderItemMapper;

    private TSsmSalOrderMapper ssmSalOrderMapper;

    private TMdBranchMapper branchMapper;

    private NHSysCodeItemMapper sysCodeItemMapper;

    private UserSessionService userSessionService;

    private TSsmSalFactoryPriceMapper ssmSalFactoryPriceMapper;
    

    public void setSsmSalFactoryPriceMapper(TSsmSalFactoryPriceMapper ssmSalFactoryPriceMapper) {
        this.ssmSalFactoryPriceMapper = ssmSalFactoryPriceMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setSsmGiOrderItemMapper(TSsmGiOrderItemMapper ssmGiOrderItemMapper) {
        this.ssmGiOrderItemMapper = ssmGiOrderItemMapper;
    }

    public void settSsmReqGoodsOrderMapper(TSsmReqGoodsOrderMapper tSsmReqGoodsOrderMapper) {
        this.tSsmReqGoodsOrderMapper = tSsmReqGoodsOrderMapper;
    }

    public void setSsmGiOrderMapper(TSsmGiOrderMapper ssmGiOrderMapper) {
        this.ssmGiOrderMapper = ssmGiOrderMapper;
    }

    public void setBranchExMapper(TMdBranchExMapper branchExMapper) {
        this.branchExMapper = branchExMapper;
    }

    public void settSsmReqGoodsOrderItemMapper(TSsmReqGoodsOrderItemMapper tSsmReqGoodsOrderItemMapper) {
        this.tSsmReqGoodsOrderItemMapper = tSsmReqGoodsOrderItemMapper;
    }

    public void settSsmSalOrderItemMapper(TSsmSalOrderItemMapper tSsmSalOrderItemMapper) {
        this.tSsmSalOrderItemMapper = tSsmSalOrderItemMapper;
    }

    public void setSsmSalOrderMapper(TSsmSalOrderMapper ssmSalOrderMapper) {
        this.ssmSalOrderMapper = ssmSalOrderMapper;
    }

    public void setSysCodeItemMapper(NHSysCodeItemMapper sysCodeItemMapper) {
        this.sysCodeItemMapper = sysCodeItemMapper;
    }

    @Override
    public PISuccessMessage generateRequireOrder(TSsmReqGoodsOrder ssmReqGoodsOrder) {
        TMdBranchEx branchEx = branchExMapper.getBranchEx(ssmReqGoodsOrder.getBranchNo());
        TMdBranch branch = branchMapper.getBranchByNo(ssmReqGoodsOrder.getBranchNo());
        ReqGoodsOrderItemSearch key = new ReqGoodsOrderItemSearch();
        key.setOrderNo(ssmReqGoodsOrder.getOrderNo());
        key.setMatnr(ssmReqGoodsOrder.getBranchNo());
        List<Map<String, String>> items = tSsmReqGoodsOrderItemMapper.findItemsForPI(key);
        if (branchEx == null) {
            throw new ServiceException(MessageCode.SERVER_ERROR, "奶站的扩展信息不存在！");
        } else {
            if (StringUtils.isEmpty(branchEx.getDocType()) || StringUtils.isEmpty(branchEx.getPurchGroup()) || StringUtils.isEmpty(branchEx.getPurchOrg()) || StringUtils.isEmpty(branchEx.getReslo())) {
                throw new ServiceException(MessageCode.SERVER_ERROR, "奶站的扩展信息不完善！");
            }
        }
        if (StringUtils.isEmpty(branch.getLgort()) && "01".equals(branch.getBranchGroup())) {
            throw new ServiceException(MessageCode.SERVER_ERROR, "奶站的库存地点为空！");
        }
        return BusinessDataConnection.RequisitionCreate(branchEx, ssmReqGoodsOrder.getRequiredDate(), items, branch.getLgort());
    }

    @Override
    public PISuccessMessage generateSalesOrder(TSsmSalOrder ssmSalOrder, String kunnr, String kunwe, String vkorg, String activityId) {
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(kunnr);
        orderHeader.setKUNWE(kunwe);
        orderHeader.setVKORG(vkorg);
        orderHeader.setActivityId(activityId);
        TMdBranch branch = branchMapper.getBranchByNo(ssmSalOrder.getBranchNo());
        
        List<Map<String, String>> items =tSsmSalOrderItemMapper.findItemsForPI(ssmSalOrder.getOrderNo());
        TMdBranchEx branchEx = branchExMapper.getBranchEx(ssmSalOrder.getBranchNo());
        //年卡 机构订奶 和 牛奶钱包 的售达方编码 传送ERP
        orderHeader.setKUNWE2(ssmSalOrder.getOnlineCode());
        String lgort = branch.getLgort();
        if ("02".equals(branch.getBranchGroup())) {
            items = tSsmSalOrderItemMapper.findDealerItemsForPI(ssmSalOrder.getOrderNo());
            lgort = branchEx.getReslo();
        }else{
            items = tSsmSalOrderItemMapper.findItemsForPI(ssmSalOrder.getOrderNo());
        }
        //年卡返利处理
//        updateSalOrderItemDiscountAmt(ssmSalOrder, items, branch.getBranchGroup());
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG13"));
        if("40".equals(ssmSalOrder.getPreorderSource())) {
            orderHeader.setKUNWE2(EnvContant.getSystemConst("online_code"));
            orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG17"));
        }
        if("10".equals(ssmSalOrder.getPreorderSource())){
            orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG17"));
        }
        orderHeader.setLgort(lgort);
        String werks = branchEx.getSupplPlnt();
        orderHeader.setWerks(werks);
        String auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        String saleOrgTX = PIPropertitesUtil.getValue("PI.SALEORG_TX");
        String freeType = ssmSalOrder.getFreeFlag();
        if ("N".equals(freeType)) {
            if (saleOrgTX.equals(ssmSalOrder.getSalesOrg())) {
                auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR1");
            } else {
                auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
            }
        } else {
            if(StringUtils.isNotEmpty(branchEx.getKostl())){
                orderHeader.setAugru(PIPropertitesUtil.getValue("PI.AUGRU"));
                orderHeader.setKostl(branchEx.getKostl());
                orderHeader.setZz001(PIPropertitesUtil.getValue("PI.ZZ001"));
            }else{
                PISuccessMessage message = new PISuccessMessage();
                message.setSuccess(false);
                message.setMessage("免费订单创建失败，请维护奶站成本中心！");
                return message;
            }
//            }
            if (saleOrgTX.equals(ssmSalOrder.getSalesOrg())) {
                auartType = PIPropertitesUtil.getValue("PI.AUART.ZFD1");
            } else {
                auartType = PIPropertitesUtil.getValue("PI.AUART.ZFD");
            }
        }
        orderHeader.setAuartType(auartType);
        orderHeader.setBSTKD(ssmSalOrder.getOrderNo());
        orderHeader.setLFDAT(ssmSalOrder.getRequiredDate());
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }
    
    
    @Autowired
    TMdSchoolMapper schoolMapper;
    
    @Autowired
    TMstOrderStudItemMapper orderMapper;
    
    @Autowired
    TMstOrderStudLossMapper tMstOrderStudLossMapper;
    
   /***
    * ITEM_NO:10为学生 20为老师
    * 
    */
    @Override
    public PISuccessMessage generateSalesOrder18(TMstOrderStud order) {
    	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(order.getSchoolCode(), order.getSalesOrg()));
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(school.getErpCodeSales());//网点编号
        orderHeader.setKUNWE(school.getErpCode());//所属经销商编号
        orderHeader.setVKORG(order.getSalesOrg());
        orderHeader.setActivityId("");
       
        //获取订单的明细
        Map<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("salesOrg", order.getSalesOrg());
        hashMap.put("orderId", order.getOrderId());
        List<TMstOrderStudItem> itemList = orderMapper.findOrderItemByOrderId(hashMap);
        List<TMstOrderStudItem> itemListUnpack = orderMapper.findOrderItemByOrderIdUnpack(hashMap);
        
        if(itemList !=null){
        	 itemList.addAll(itemListUnpack);
        }else{
        	itemList=itemListUnpack;
        }
       
        if(null == itemList || itemList.size()==0){
        	return new PISuccessMessage(false,"","");
        }
        
        //老师奶
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        Map<String, String> mapStu = new HashMap<String,String>();
        for (TMstOrderStudItem item : itemList) {
        	if("20".equals(item.getOrderType())){
        		if(item.getQty() >0){
        			Boolean falg=true;
        			for (Map<String, String> map : items) {
						if(map.get("MATNR").equals(item.getMatnr())){
							falg=false;
							int qtySum = Integer.valueOf(map.get("SUM_QTY"))+Integer.valueOf(item.getQty());
							map.put("SUM_QTY", qtySum+"");//数量'
							
						}
					}
        			
        			if(falg){
        				Map<String, String> map = new HashMap<String,String>();
            			map.put("RESLO", school.getAddress());//发货点
            			map.put("WERKS", school.getWerks());//收货工厂
            			map.put("SUM_QTY", item.getQty()+"");//数量
            			map.put("BASE_UNIT", item.getBaseUnit());//单位
            			map.put("ITEM_NO","20" );//行项目编号
            			map.put("REF_MATNR", null);//参考物料
            			map.put("MATNR",item.getMatnr());//产品号
            			map.put("PROM_NO",null);//促销号
            			map.put("PRICE","0");//产品价格
            			items.add(map);
        			}
        		}
        	}else{
        		String qty = mapStu.get("SUM_QTY");
        		if(StringUtils.isNotBlank(qty)){
        			int qtySum = item.getQty()+Integer.valueOf(qty);
        			mapStu.put("SUM_QTY", qtySum+"");//数量
        		}else{
        			mapStu.put("SUM_QTY", item.getQty()+"");//数量
        		}
        		mapStu.put("RESLO", school.getAddress());//发货点
        		mapStu.put("WERKS", school.getWerks());//收货工厂
        		mapStu.put("BASE_UNIT", item.getBaseUnit());//单位
        		mapStu.put("ITEM_NO", "10");//行项目编号
        		mapStu.put("REF_MATNR", null);//参考物料
        		mapStu.put("MATNR",item.getMatnr());//产品号
        		mapStu.put("PROM_NO","");//促销号
    			mapStu.put("PRICE","0");//产品价格
        	}
		}
        
        List<Map<String, String>> itemsRemove = new ArrayList<Map<String, String>>();
        for (Map<String, String> map : items) {
        	if(mapStu.get("MATNR").equals(map.get("MATNR"))){
        		itemsRemove.add(map);
        		int qtySum = Integer.valueOf(mapStu.get("SUM_QTY"))+Integer.valueOf(map.get("SUM_QTY"));
        		mapStu.put("SUM_QTY", qtySum+"");//数量'
        	}
		}
        
        items.removeAll(itemsRemove);
        items.add(mapStu);
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG18"));
        
        NHSysCodeItem key = new NHSysCodeItem();
        key.setItemCode(school.getWerks());
        key.setTypeCode("1014");
        NHSysCodeItem codeItem = sysCodeItemMapper.findCodeItenByCode(key);
        orderHeader.setLgort(codeItem.getAttr4());//库存地点TODO
        orderHeader.setWerks(school.getWerks());
        String auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        String saleOrgTX = PIPropertitesUtil.getValue("PI.SALEORG_TX");
        if (saleOrgTX.equals(order.getSalesOrg())) {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR1");
        } else {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        }
        orderHeader.setAuartType(auartType);
        orderHeader.setBSTKD(order.getOrderId());
        orderHeader.setLFDAT(DateUtil.getTomorrow(new Date()));
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }
    
    
    
    @Override
    public PISuccessMessage generateSalesOrderLoss18(TMstOrderStud order) {
    	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(order.getSchoolCode(), order.getSalesOrg()));
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(school.getErpCodeSales());//网点编号
        orderHeader.setKUNWE(school.getErpCode());//所属经销商编号
        orderHeader.setVKORG(order.getSalesOrg());
        orderHeader.setActivityId("");
       
        //获取订单的明细
        Map<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("salesOrg", order.getSalesOrg());
        hashMap.put("orderId", order.getOrderId());
       
        List<TMstOrderStudLoss> itemList = tMstOrderStudLossMapper.findLossByOrderId(hashMap);
        List<TMstOrderStudLoss> itemListLoss = tMstOrderStudLossMapper.findLossByOrderIdUnpack(hashMap);
        if(itemList !=null){
        	 itemList.addAll(itemListLoss);
        }else{
        	itemList=itemListLoss;
        }
        if(null == itemList || itemList.size()==0){
        	return new PISuccessMessage(false,"","");
        }
        
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        for (TMstOrderStudLoss item : itemList) {
        	if(item.getQty() >0){
    			Map<String, String> map = new HashMap<String,String>();
    			map.put("RESLO", school.getAddress());//发货点
    			map.put("WERKS", school.getWerks());//收货工厂
    			map.put("SUM_QTY", item.getQty()+"");//数量
    			map.put("BASE_UNIT", item.getBaseUnit());//单位
    			map.put("ITEM_NO","20" );//行项目编号
    			map.put("REF_MATNR", null);//参考物料
    			map.put("MATNR",item.getMatnr());//产品号
    			map.put("PROM_NO",null);//促销号
    			map.put("PRICE","0");//产品价格
    			items.add(map);
        	}
		}
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG18"));
        NHSysCodeItem key = new NHSysCodeItem();
        key.setItemCode(school.getWerks());
        key.setTypeCode("1014");
        NHSysCodeItem codeItem = sysCodeItemMapper.findCodeItenByCode(key);
        orderHeader.setLgort(codeItem.getAttr4());//库存地点TODO
        orderHeader.setWerks(school.getWerks());
        orderHeader.setAugru(PIPropertitesUtil.getValue("PI.AUGRUXS"));	
        //通过销售组织和类型获取
        
        NHSysCodeItem key1 = new NHSysCodeItem();
        key1.setItemCode(school.getWerks());
        key1.setTypeCode("1014");
        String value = PIPropertitesUtil.getValue("PI."+order.getSalesOrg());
        orderHeader.setKostl(value);
        orderHeader.setZz001(PIPropertitesUtil.getValue("PI.ZZ001XS"));
        orderHeader.setAuartType(PIPropertitesUtil.getValue("PI.AUART.ZFD"));
        orderHeader.setBSTKD(order.getOrderId()+"_L");
        orderHeader.setLFDAT(DateUtil.getTomorrow(new Date()));
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }
    
    @Override
    public PISuccessMessage generateSalesOrderFll18(TMstOrderStud order) {
    	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(order.getSchoolCode(), order.getSalesOrg()));
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(school.getErpCodeSales());//网点编号
        orderHeader.setKUNWE(school.getErpCode());//所属经销商编号
        orderHeader.setVKORG(order.getSalesOrg());
        orderHeader.setActivityId("");
       
        //获取订单的明细
        Map<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("salesOrg", order.getSalesOrg());
        hashMap.put("orderId", order.getOrderId());
        hashMap.put("orderType", "20 ");
        List<TMstOrderStudItem> itemList = orderMapper.findOrderItemByMapFill(hashMap);
        if(null == itemList || itemList.size()==0){
        	return new PISuccessMessage(false,"","");
        }
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        for (TMstOrderStudItem item : itemList) {
        	if(item.getQty() >0){
        			Map<String, String> map = new HashMap<String,String>();
        			map.put("RESLO", school.getAddress());//发货点
        			map.put("WERKS", school.getWerks());//收货工厂
        			map.put("SUM_QTY", item.getQty()+"");//数量
        			map.put("BASE_UNIT", item.getBaseUnit());//单位
        			map.put("ITEM_NO","20" );//行项目编号
        			map.put("REF_MATNR", null);//参考物料
        			map.put("MATNR",item.getMatnr());//产品号
        			map.put("PROM_NO",null);//促销号
        			map.put("PRICE","0");//产品价格
        		    items.add(map);
        	}
		}
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG18"));
        NHSysCodeItem key = new NHSysCodeItem();
        key.setItemCode(school.getWerks());
        key.setTypeCode("1014");
        NHSysCodeItem codeItem = sysCodeItemMapper.findCodeItenByCode(key);
        orderHeader.setLgort(codeItem.getAttr4());//库存地点TODO
        orderHeader.setWerks(school.getWerks());
        String auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        String saleOrgTX = PIPropertitesUtil.getValue("PI.SALEORG_TX");
        if (saleOrgTX.equals(order.getSalesOrg())) {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR1");
        } else {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        }
        orderHeader.setAuartType(auartType);
        orderHeader.setBSTKD(order.getOrderId()+"_F");
        orderHeader.setLFDAT(DateUtil.getTomorrow(new Date()));
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }
    
    
    
    @Override
    public PISuccessMessage generateSalesOrderLossFll18(TMstOrderStud order) {
    	TMdSchool school = schoolMapper.selectByPrimaryKey(new SchoolQueryModel(order.getSchoolCode(), order.getSalesOrg()));
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(school.getErpCodeSales());//网点编号
        orderHeader.setKUNWE(school.getErpCode());//所属经销商编号
        orderHeader.setVKORG(order.getSalesOrg());
        orderHeader.setActivityId("");
        //获取订单的明细
        Map<String, Object> hashMap = new HashMap<String,Object>();
        hashMap.put("salesOrg", order.getSalesOrg());
        hashMap.put("orderId", order.getOrderId());
       
        List<TMstOrderStudLoss> itemList = tMstOrderStudLossMapper.findLossByOrderIdFill(hashMap);
        List<TMstOrderStudLoss> itemListLoss = tMstOrderStudLossMapper.findLossByOrderIdFill(hashMap);
        if(itemList !=null){
        	 itemList.addAll(itemListLoss);
        }else{
        	itemList=itemListLoss;
        }
        if(null == itemList || itemList.size()==0){
        	return new PISuccessMessage(false,"","");
        }
        
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        for (TMstOrderStudLoss item : itemList) {
        	if(item.getQty() >0){
        			Map<String, String> map = new HashMap<String,String>();
        			map.put("RESLO", school.getAddress());//发货点
        			map.put("WERKS", school.getWerks());//收货工厂
        			map.put("SUM_QTY", item.getQty()+"");//数量
        			map.put("BASE_UNIT", item.getBaseUnit());//单位
        			map.put("ITEM_NO","20" );//行项目编号
        			map.put("REF_MATNR", null);//参考物料
        			map.put("MATNR",item.getMatnr());//产品号
        			map.put("PROM_NO",null);//促销号
        			map.put("PRICE","0");//产品价格
        			items.add(map);
        	}
		}
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG18"));
        NHSysCodeItem key = new NHSysCodeItem();
        key.setItemCode(school.getWerks());
        key.setTypeCode("1014");
        NHSysCodeItem codeItem = sysCodeItemMapper.findCodeItenByCode(key);
        orderHeader.setLgort(codeItem.getAttr4());//库存地点TODO
        orderHeader.setWerks(school.getWerks());
        orderHeader.setAugru(PIPropertitesUtil.getValue("PI.AUGRUXS"));	
        //通过销售组织和类型获取
        
        NHSysCodeItem key1 = new NHSysCodeItem();
        key1.setItemCode(school.getWerks());
        key1.setTypeCode("1014");
        String value = PIPropertitesUtil.getValue("PI."+order.getSalesOrg());
        orderHeader.setKostl(value);
        orderHeader.setZz001(PIPropertitesUtil.getValue("PI.ZZ001XS"));
        orderHeader.setAuartType(PIPropertitesUtil.getValue("PI.AUART.ZFD"));
        orderHeader.setBSTKD(order.getOrderId()+"_LF");
        orderHeader.setLFDAT(DateUtil.getTomorrow(new Date()));
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }
    

    
    
    @Override
    public PISuccessMessage generateSalesOrderOfEmp(TSsmSalOrder ssmSalOrder, String kunnr, String kunwe, String vkorg) {
        SalesOrderHeader orderHeader = new SalesOrderHeader();
        orderHeader.setKUNNR(kunnr);
        orderHeader.setKUNWE(kunwe);
        orderHeader.setVKORG(vkorg);
        TMdBranch branch = branchMapper.getBranchByNo(ssmSalOrder.getBranchNo());
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        TMdBranchEx branchEx = branchExMapper.getBranchEx(ssmSalOrder.getBranchNo());
        String lgort = branch.getLgort();
        if ("02".equals(branch.getBranchGroup())) {
            items = tSsmSalOrderItemMapper.findDealerItemsForPI(ssmSalOrder.getOrderNo());
            lgort = branchEx.getReslo();
        }else{
            items = tSsmSalOrderItemMapper.findItemsForPI(ssmSalOrder.getOrderNo());
        }
        orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG13"));
        orderHeader.setLgort(lgort);
        String werks = branchEx.getSupplPlnt();
        orderHeader.setWerks(werks);
        String auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        String saleOrgTX = PIPropertitesUtil.getValue("PI.SALEORG_TX");
        if (saleOrgTX.equals(ssmSalOrder.getSalesOrg())) {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR1");
        } else {
            auartType = PIPropertitesUtil.getValue("PI.AUART.ZOR");
        }
        orderHeader.setAuartType(auartType);
        orderHeader.setBSTKD(ssmSalOrder.getOrderNo());
        orderHeader.setLFDAT(ssmSalOrder.getRequiredDate());
        PISuccessMessage message = BusinessDataConnection.SalesOrderCreate(items, orderHeader);
        return message;
    }

    /**
     * 查询年卡返利金额，发送ERP，更新销售订单明细年卡折扣金额，
     * @param ssmSalOrder
     * @param items
     * @param branchGroup
     */
    private void updateSalOrderItemDiscountAmt(TSsmSalOrder ssmSalOrder, List<Map<String, String>> items, String branchGroup) {
        RequireOrderSearch model = new RequireOrderSearch();
        model.setFirstDay(DateUtil.getTomorrow(ssmSalOrder.getOrderDate()));
        model.setSecondDay(DateUtil.getDayAfterTomorrow(ssmSalOrder.getOrderDate()));
        model.setBranchNo(ssmSalOrder.getBranchNo());
        model.setSalesOrg(ssmSalOrder.getSalesOrg());
        model.setOrderDate(ssmSalOrder.getOrderDate());
        List<Map<String,String>> disCountAmtList;
        if("02".equals(branchGroup)){
            disCountAmtList = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfDearler(model);
        }else{
            disCountAmtList = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfBranch(model);
        }
        if(disCountAmtList != null && disCountAmtList.size()>0) {
            Map<String, String> disCountAmtMap = new HashMap<String, String>();
            Map<String, String> disCountPriceMap = new HashMap<String, String>();

            disCountAmtList.forEach(item -> {
                disCountAmtMap.put(item.get("MATNR"), String.valueOf(item.get("DISCOUNT_AMT")));
                disCountPriceMap.put(item.get("MATNR"),item.get("PRICE1"));
            });
            items.forEach(item -> {
                String matnr = item.get("MATNR");
                if (disCountAmtMap.containsKey(matnr)) {
                    item.put("DISCOUNT_AMT", String.valueOf(disCountAmtMap.get(matnr)));
                    item.put("KBETR",disCountPriceMap.get(matnr));
                    updateDiscountAmt(disCountAmtMap, item, matnr);
                }
            });
        }
    }

    private void updateDiscountAmt(Map<String, String> disCountAmtMap, Map<String, String> item, String matnr) {
        TSsmSalOrderItems ssmSalOrderItems = new TSsmSalOrderItems();
        try {
            ssmSalOrderItems.setOrderDate(format.parse(String.valueOf(item.get("ORDER_DATE"))));
        } catch (ParseException e) {

        }
        ssmSalOrderItems.setItemNo(Integer.parseInt(String.valueOf(item.get("ITEM_NO"))));
        ssmSalOrderItems.setOrderNo(item.get("ORDER_NO"));
        ssmSalOrderItems.setDiscountAmt(new BigDecimal(String.valueOf(disCountAmtMap.get(matnr))));
        tSsmSalOrderItemMapper.updateDiscountAmt(ssmSalOrderItems);
    }

    @Override
    public String generateDelivery(String orderNo, String branchNo, boolean isDeli){
        if (StringUtils.isEmpty(orderNo)) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "调拨单或销售订单凭证没有生成！");
        } else {
            List<TSsmGiOrder> order = ssmGiOrderMapper.findGiOrderByReqOrderNo(orderNo);
            if(order.size()>0){
                throw new ServiceException(MessageCode.LOGIC_ERROR, "交货单已生成,请直接查询");
            }
            savePriceAndGiOrder(orderNo, branchNo, isDeli,false);
        }
        return "1";
    }

    private void savePriceAndGiOrder(String orderNo, String branchNo, boolean isDeli,boolean isZy) {
        PISuccessTMessage<List<Delivery>> message1 = BusinessDataConnection.DeliveryQuery(orderNo, isDeli, isZy);
        if(message1.isSuccess()) {
            List<Delivery> deliveries = message1.getData();
            if (deliveries.size() > 0) {
                TSsmGiOrder ssmGiOrder = null;
                for (Delivery d : deliveries) {
                    if(!"C".equals(d.getWbstk())){
                        //判断是否过账，有没过账的返回提示信息
                        throw new ServiceException(MessageCode.LOGIC_ERROR,d.getVBELN()+"交货单未过账！");
                    }
                }
                for (Delivery d : deliveries) {
                    //防止一个调拨单生成多个交货单
                    if(!isZy) {
                        ssmGiOrder = ssmGiOrderMapper.selectGiOrderByNo(d.getVBELN());
                        if (ssmGiOrder == null) {
                            ssmGiOrder = new TSsmGiOrder();
                            ssmGiOrder.setBranchNo(branchNo);
                            ssmGiOrder.setOrderNo(d.getVBELN());
                            ssmGiOrder.setStatus("10");
                            ssmGiOrder.setSyncAt(new Date());
                            ssmGiOrder.setOrderDate(d.getLFDAT());
                            ssmGiOrder.setMemoTxt(d.getBSTKD());
                            ssmGiOrder.setReqOrderNo(d.getVBELV());
                            ssmGiOrderMapper.insertGiOrder(ssmGiOrder);
                        }
                        TSsmGiOrderItemKey key = new TSsmGiOrderItemKey();
                        key.setOrderDate(d.getLFDAT());
                        key.setItemNo(d.getPOSNR());
                        key.setOrderNo(d.getVBELN());
                        TSsmGiOrderItem ssmGiOrderItem = ssmGiOrderItemMapper.selectGiOrderItemByNo(key);
                        if (ssmGiOrderItem == null) {
                            ssmGiOrderItem = new TSsmGiOrderItem();
                            ssmGiOrderItem.setOrderNo(d.getVBELN());
                            ssmGiOrderItem.setMatnr(d.getMATNR());
                            ssmGiOrderItem.setUnit(d.getMEINS());
                            ssmGiOrderItem.setItemNo(d.getPOSNR());
                            ssmGiOrderItem.setOrderDate(d.getLFDAT());
                            ssmGiOrderItem.setItemType(d.getPSTYV());
                            ssmGiOrderItem.setQty(d.getLFIMG());
                            ssmGiOrderItem.setFactoryPrice(d.getCmpre());
                            ssmGiOrderItemMapper.insertGiOrderItem(ssmGiOrderItem);
                        } else {
                            ssmGiOrderItem.setMatnr(d.getMATNR());
                            ssmGiOrderItem.setUnit(d.getMEINS());
                            ssmGiOrderItem.setItemType(d.getPSTYV());
                            ssmGiOrderItem.setQty(d.getLFIMG());
                            ssmGiOrderItem.setFactoryPrice(d.getCmpre());
                            ssmGiOrderItemMapper.updateGiOrderItem(ssmGiOrderItem);
                        }
                    }
                    //是销售订单生成的交货单保存奶站产品的出厂价格
                    if(!isDeli){
                        TSysUser user = userSessionService.getCurrentUser();
                        TSsmSalFactoryPriceKey key = new TSsmSalFactoryPriceKey();
                        key.setOrderDate(d.getLFDAT());
                        key.setMatnr(d.getMATNR());
                        key.setBranchNo(branchNo);
                        TSsmSalFactoryPrice price =ssmSalFactoryPriceMapper.selectFactoryPrice(key);
                        if(price == null) {
                            price = new TSsmSalFactoryPrice();
                            price.setCreateAt(new Date());
                            price.setCreateBy(user.getLoginName());
                            price.setBranchNo(branchNo);
                            price.setMatnr(d.getMATNR());
                            price.setOrderDate(d.getLFDAT());
                            price.setSalesOrg(user.getSalesOrg());
                            price.setFactoryPrice(d.getCmpre());
                            ssmSalFactoryPriceMapper.insertFactoryPrice(price);
                        }
                    }
                }
            }else{
                throw new ServiceException(MessageCode.LOGIC_ERROR,"交货单未过账！");
            }
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR,message1.getMessage());
        }
    }

    @Override
    public String execRequieOrder(Date date, String branchNo) {
        RequireOrderSearch search = new RequireOrderSearch();
        search.setRequiredDate(date);
        search.setOrderDate(date);
        search.setBranchNo(branchNo);
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.searchRequireOrder(search);
        generateRequireOrder(order);
        return "1";
    }

    public String execDelivery(StockModel model) {
        String message = "";
        TMdBranch branch = branchMapper.getBranchByNo(model.getBranchNo());
        Date curDate = new Date();
//        String salesOrg = branch.getSalesOrg();
//        如果是华西或者天音 则requiredDate日期为今天  否则requiredDate为明天
//        if("4181".equals(salesOrg) || "4390".equals(salesOrg)){
//            curDate = new Date();
//        }else{
//            curDate = DateUtil.getTomorrow(new Date());
//        }
        if(model.getCurDate() != null){
            curDate = model.getCurDate();
        }
        if ("01".equals(branch.getBranchGroup())) {
            RequireOrderSearch search = new RequireOrderSearch();
            search.setRequiredDate(curDate);
            search.setBranchNo(model.getBranchNo());
            List<TSsmReqGoodsOrder> order1 = tSsmReqGoodsOrderMapper.searchRequireOrderByRequireDate(search);
            if (order1.size()==0) {
                throw new ServiceException(MessageCode.SERVER_ERROR, "要货单没有生成！");
            } else {
                message = generateDelivery(order1.get(0).getVoucherNo(), model.getBranchNo(), true);
            }
        } else {
            SalOrderModel model1 = new SalOrderModel();
            model1.setBranchNo(model.getBranchNo());
            model1.setOrderDate(curDate);
            List<TSsmSalOrder> orders = ssmSalOrderMapper.selectSalOrderByRequiredDateAndNo(model1);
            if (orders.size() != 0) {
                for (TSsmSalOrder order : orders) {
                    message = generateDelivery(order.getVoucherNo(), model.getBranchNo(), false);
                }
            } else {
                throw new ServiceException(MessageCode.SERVER_ERROR, "销售订单没有生成！");
            }
        }
        return message;
    }

    @Override
    public String saveFactoryPrice() {
        List<TSsmSalOrder> orders = ssmSalOrderMapper.findGidOrderByNotWBSTK();
        if(orders.size() >0){
            for(TSsmSalOrder order : orders){
                PISuccessTMessage<List<Delivery>> message1 = BusinessDataConnection.DeliveryQuery(order.getVoucherNo(), false, true);
                if(message1.isSuccess()) {
                    List<Delivery> deliveries = message1.getData();
                    if (deliveries.size() > 0) {
                        for (Delivery d : deliveries) {
                            TSysUser user = userSessionService.getCurrentUser();
                            TSsmSalFactoryPriceKey key = new TSsmSalFactoryPriceKey();
                            key.setOrderDate(d.getLFDAT());
                            key.setMatnr(d.getMATNR());
                            key.setBranchNo(order.getBranchNo());
                            TSsmSalFactoryPrice price =ssmSalFactoryPriceMapper.selectFactoryPrice(key);
                            if(price == null) {
                                price = new TSsmSalFactoryPrice();
                                price.setCreateAt(new Date());
//                                price.setCreateBy(user.getLoginName());
                                price.setBranchNo(order.getBranchNo());
                                price.setMatnr(d.getMATNR());
                                price.setOrderDate(d.getLFDAT());
                                price.setSalesOrg(order.getSalesOrg());
                                price.setFactoryPrice(d.getCmpre());
                                ssmSalFactoryPriceMapper.insertFactoryPrice(price);
                            }
                        }
                        ssmSalOrderMapper.updateWBSTK(order.getOrderNo());
                    }
                }
            }
        }
        return "1";
    }

    @Override
    public String execDeliveryByOrderNo(String orderNo) {
        String message = "";
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranch branch = branchMapper.getBranchByNo(user.getBranchNo());
        String group = branch.getBranchGroup();
        if("01".equals(group)){
            message = generateDelivery(orderNo, branch.getBranchNo(), true);
        }else{
            message = generateDelivery(orderNo, branch.getBranchNo(), false);
        }
        return message;
    }


    @Override
    public String execSalesOrder(Date date, TMdBranch branch) {
//        RequireOrderSearch search = new RequireOrderSearch();
//        search.setRequiredDate(date);
//        search.setBranchNo(branch.getBranchNo());
//        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.searchRequireOrder(search);

//        generateSalesOrder(order,branch.getDealerNo(),branch.getBranchNo(),branch.getSalesOrg(),"");
        return "1";
    }


}
