package com.nhry.service.stud.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.stud.ExportStudOrderMilkModel;
import com.nhry.model.stud.OrderBatchBuildModel;
import com.nhry.model.stud.OrderStudLossModel;
import com.nhry.model.stud.OrderStudQueryModel;

/**
 * @author zhaoxijun
 * @date 2017年4月12日
 */
public interface OrderStudService {

    int createOrder(TMstOrderStud mstOrderStud) throws Exception;

    TMstOrderStud selectByOrderId(String orderId);

    int updateByOrder(TMstOrderStud mstOrderStud);
    
    PageInfo<TMstOrderStud> findOrderPage(OrderStudQueryModel queryModel);

	Map<String, Object> findOrderInfoBySchoolCodeAndDate(TMstOrderStud mstOrderStud);

	Map<String, Object> buildBatchInfo(OrderBatchBuildModel orderBatchBuildModel)  throws Exception;

	int createOrderWithBatch(OrderBatchBuildModel orderBatchBuildModel)  throws Exception;

	int updateOrderWithBatch(OrderBatchBuildModel orderBatchBuildModel);

	int calcLoss(OrderStudLossModel orderStudLossModel);
	
	String exportStudOrderMilk(ExportStudOrderMilkModel model) throws Exception;
	
	String exportStudOrderMilkSum(ExportStudOrderMilkModel model) throws Exception;

	int createOrderUnpack(TMstOrderStud mstOrderStud) throws Exception;
	
	int createOrderFill(TMstOrderStud mstOrderStud) throws Exception;
	
	Map<String, Object> findOrderInfoBySchoolCodeAndDateUnpack(TMstOrderStud mstOrderStud);
	
	Map<String, Object> findOrderInfoBySchoolCodeAndDateFill(TMstOrderStud mstOrderStud);

	String findDefaultMaraForSchool(TMstOrderStud mstOrderStud);
/*
	String generateSalesOrder18();*/

	List<TMstOrderStud> findOrderStudByDateAndSalesOrg();
	
	
}