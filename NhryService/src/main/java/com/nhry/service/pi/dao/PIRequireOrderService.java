package com.nhry.service.pi.dao;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.milktrans.domain.TSsmReqGoodsOrder;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.stock.StockModel;
import com.nhry.webService.client.PISuccessMessage;

import java.util.Date;

/**
 * 要货单
 * Created by cbz on 7/4/2016.
 */
public interface PIRequireOrderService {
    /**
     * 要货单
     * @param ssmReqGoodsOrder 要货单主表
     * @return
     */
    PISuccessMessage generateRequireOrder(TSsmReqGoodsOrder ssmReqGoodsOrder);

    /**
     * 销售订单创建
     * @param ssmSalOrder
     * @param kunnr 客户编号
     * @param kunwe 送达方
     * @param vkorg 销售组织
     * @param activityId 促销活动号
     * @return
     */
    PISuccessMessage generateSalesOrder(TSsmSalOrder ssmSalOrder, String kunnr, String kunwe, String vkorg, String activityId) ;

    /**
     * 销售订单创建(送奶工)
     * @param ssmSalOrder
     * @param kunnr 客户编号
     * @param kunwe 送达方
     * @param vkorg 销售组织
     * @return
     */
    PISuccessMessage generateSalesOrderOfEmp(TSsmSalOrder ssmSalOrder, String kunnr, String kunwe, String vkorg) ;

    /**
     * 交货单
      * @param orderNo 销售凭证
     * @param isDeli 是否是调货单
     * @return
     */
    String generateDelivery(String orderNo,String branchNo,boolean isDeli);

    String execRequieOrder(Date date, String branchNo);

    String execSalesOrder(Date date, TMdBranch branch);

    /**
     * 生成交换单
     * @param model
     * @return
     */
    String execDelivery(StockModel model);

    /**
     * 任务调度执行获取ECC出厂价格
     * @return
     */
    String saveFactoryPrice();

    /**
     * 通过要货单或者销售订单生成交换单
     * @param orderNo
     * @return
     */
    String execDeliveryByOrderNo(String orderNo);
    /**
     * 学生奶正常订单
     * @param order
     * @return
     */
	PISuccessMessage generateSalesOrder18(TMstOrderStud order);
	
	/**
	 * 
	 */
	/**
	 * 学生奶免费订单
	 * @param order
	 * @return
	 */
	PISuccessMessage generateSalesOrderLoss18(TMstOrderStud order);
	
	
	/**
     * 学生奶补单订单
     * @param order
     * @return
     */
	PISuccessMessage generateSalesOrderFll18(TMstOrderStud order);

	/**
	 * 学生奶补单免费
	 * @param order
	 * @return
	 */
	PISuccessMessage generateSalesOrderLossFll18(TMstOrderStud order);
	
	
	
	

}
