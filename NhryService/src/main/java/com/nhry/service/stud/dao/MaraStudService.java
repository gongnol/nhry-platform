package com.nhry.service.stud.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.model.stud.OrderStudQueryModel;

/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public interface MaraStudService {
	
	
	List<TMdMaraStud> findAllListBySalesOrg(String salesOrg);
	
	List<TMdMaraStud> findAllListBySalesOrg();

	PageInfo findMaraStudAllPage(OrderStudQueryModel queryModel);

	int updateMaraStud(TMdMaraStud tMdMaraStud);
}
