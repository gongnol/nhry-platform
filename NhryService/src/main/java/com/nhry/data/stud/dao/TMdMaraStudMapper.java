package com.nhry.data.stud.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.model.stud.OrderStudQueryModel;

public interface TMdMaraStudMapper {
	List<TMdMaraStud> findAllListBySalesOrg(String salesOrg);

	List<TMdMaraStud> findAllListBySalesOrgNotIn(Map<String, Object> selectMaraMap);

	PageInfo findMaraStudAllPage(OrderStudQueryModel queryModel);

	int updateInfo(TMdMaraStud tMdMaraStud);
	

	
	/**
	 * 根据产品编号查询产品
	 * @param matnr
	 * @return
	 */
	TMdMaraStud selectProductByCode(Map<String,String> attrs);
	
	TMdMaraStud selectMaraByMap(String matnr, String salesOrg);
	
	int updateProduct(TMdMaraStud tMdMaraStud);
}