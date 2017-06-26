package com.nhry.data.order.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.order.domain.TMilkboxPlan;
import com.nhry.model.order.MilkboxSearchModel;

public interface TMilkboxPlanMapper {
	
	 PageInfo selectMilkboxsByPage(MilkboxSearchModel smodel);
	
    int deleteMilkBoxByOrderNo(String orderNo);

    int insert(TMilkboxPlan record);

    int insertSelective(TMilkboxPlan record);

    TMilkboxPlan selectByPrimaryKey(String planNo);

    int updateByPrimaryKeySelective(TMilkboxPlan record);

    int updateMilkboxPlan(TMilkboxPlan record);
    
    int updateMilkboxPlans(Map<String,Object> params);
    
    int updateMilkboxPlanPrinted(String code);

    List searchMilkBox(String empNo);

    int selectMilkboxsCount(String BranchNo);
}