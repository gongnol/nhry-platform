package com.nhry.data.stud.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.stud.OrderStudQueryModel;

public interface TMstOrderStudMapper {

    int insertOrder(TMstOrderStud mstOrderStud);

    TMstOrderStud selectByOrderId(String orderId);

    int updateByOrder(TMstOrderStud mstOrderStud);
    
    PageInfo<TMstOrderStud> findOrderPage(OrderStudQueryModel queryModel);

	TMstOrderStud selectOrderBySchoolCodeAndDateWithOrderStatus10(TMstOrderStud mstOrderStud);

	List<TMstOrderStud> findMatnrWithOrder(TMstOrderStud selectObj);

	List<TMstOrderStud> findSchoolWithOrder(TMstOrderStud selectObj);

	List<TMstOrderStud> findMatnrWithOrderUnpack(TMstOrderStud selectObj);
	
	List<TMstOrderStud> findOrderStudByDateAndSalesOrg(String orderDateStr, String salesOrg);

	List<String> findAllSchoolByOrderDateBetwen(String salesOrg, String startOrderDateStr, String endOrderDateStr);

	List<TMstOrderStud> findMatnrWithOrderFill(TMstOrderStud selectObj);
}