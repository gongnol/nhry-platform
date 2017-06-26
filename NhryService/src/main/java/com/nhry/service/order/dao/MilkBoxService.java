package com.nhry.service.order.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.order.domain.TMilkboxPlan;
import com.nhry.model.order.*;

import java.util.List;

public interface MilkBoxService {
	
	PageInfo searchMilkBox(MilkboxSearchModel smodel);
	
	int addNewMilkboxPlan(MilkboxCreateModel model);
	
	int updateMilkboxStatus(MilkboxCreateModel model);
	
	int updateMilkboxStatusByList(MilkboxCreateModel model);
	
	TMilkboxPlan selectMilkboxByPlanNo(String code);
	
	int updateMilkboxPlanPrinted(String code);
	
	int deleteMilkBoxByOrderNo(String code);

	List findMilkBox(String empNo);

	int selectMilkboxsCount();
}
