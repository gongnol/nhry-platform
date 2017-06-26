package com.nhry.service.external.dao;

import java.math.BigDecimal;
import java.util.List;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchScopeKey;
import com.nhry.data.basic.domain.TMdResidentialArea;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.model.order.OrderSearchModel;

public interface EcService {
    
	/**
	 * 奶站更新时，往电商推送
	 */
	public void pushBranch2EcForUpt(TMdBranch branch);
	
	/**
	 * 获取订单列表
	 */
	public void getOrderList(OrderSearchModel model);
	
	/**
	 * 获取订单明细
	 */
	public void getOrderdtlinfo(OrderSearchModel model);
	
	/**
	 * 订单停订/续订
	 */
	public void sendOrderStopRe(OrderSearchModel model);
	
	/**
	 * 更新订单状态
	 */
	public void sendOrderStatus(TPreOrder order);
	
	/**
	 * 获取订户订单备注信息
	 */
	public void getOrderComments(TPreOrder order);
	
	/**
	 * 创建订户订单备注
	 */
	public void sendOrderComments(TPreOrder order);
	
	/**
	 * 订单创建推送
	 */
	public void sendOrderInfo(TPreOrder order,List<TPlanOrderItem> entries);
	
	/**
	 * 订单奶站信息更新
	 */
	public void sendOrderBranch(TPreOrder order);
	
	/**
	 * 推送小区信息给电商
	 * @param area
	 */
	public void sendResidentialArea2Ec(TMdResidentialArea area);
	
	/**
	 * 推送奶站与小区更新信息给电商
	 * @param branchScope
	 */
	public void senduptBranchScope2Ec(TMdBranchScopeKey branchScope,String actionFlag);

	/**
	 * 推送订单更换奶站给电商
	 * @param orderNo
	 * @param branchNo
	 * @param type
	 * @param qty
	 * @param amt
     * @param remark
     */
	public void sendReplaceBranch(String orderNo, String branchNo, String type, int qty, BigDecimal amt,String remark);
	
}
