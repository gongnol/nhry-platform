package com.nhry.data.basic.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdPriceMapper;
import com.nhry.data.basic.domain.TMdPrice;
import com.nhry.model.basic.PriceQueryModel;
import com.nhry.service.basic.pojo.PriceGroup;

public class TMdPriceMapperImpl implements TMdPriceMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(
			DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int addNewPriceGroup(TMdPrice record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addNewPriceGroup", record);
	}

	@Override
	public int disablePriceGroup(TMdPrice record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("disablePriceGroup", record);
	}

	@Override
	public int updatePriceGroup(TMdPrice record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updatePriceGroup", record);
	}

	@Override
	public PageInfo searchPriceGroups(PriceQueryModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchPriceGroups",smodel, Integer.parseInt(smodel.getPageNum()),Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public TMdPrice selectPriceGroupById(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectPriceGroupByCode", id);
	}

	@Override
	public List<PriceGroup> findMaraPriceBymatnrAndNo(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findMaraPriceBymatnrAndNo", attrs);
	}

	@Override
	public PriceGroup findMaraPriceBymatnrAndOrg(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findMaraPriceBymatnrAndOrg", attrs);
	}

	@Override
	public TMdPrice selectPGByCode4Edit(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectPGByCode4Edit", id);
	}

	@Override
	public List<TMdPrice> getPricesGroupByBn(Map<String,String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getPricesGroupByBn",attrs);
	}

	@Override
	public List<TMdPrice> getOwnBranchPricesGroupByBn(String salesOrg) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getOwnBranchPricesGroupByBn", salesOrg);
	}

	@Override
	public List<TMdPrice> getDealerBranchPricesGroupByBn(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getDealerBranchPricesGroupByBn", attrs);
	}

	@Override
	public int getCompPriceGroupCount(Map<String,String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("getCompPriceGroupCount", attrs);
	}
}
