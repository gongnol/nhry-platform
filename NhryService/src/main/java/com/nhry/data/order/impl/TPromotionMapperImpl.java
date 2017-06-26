package com.nhry.data.order.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.order.dao.TPromotionMapper;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.PromSearchModel;
import com.nhry.model.order.TPromotionModel;
import com.nhry.model.order.TPromotionOrderModel;
import com.nhry.rest.basic.PromAllocatModel;

public class TPromotionMapperImpl implements TPromotionMapper
{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TPromotion> selectPromotionByMatnr(TPromotion record)
	{
		return sqlSessionTemplate.selectList("selectPromotionByMatnr", record);
	}

	@Override
	public TPromotion selectPromotionByPromNo(TPromotion record)
	{
		return sqlSessionTemplate.selectOne("selectPromotionByPromNo", record);
	}
	
	@Override
	public PageInfo selectPromotionsrsByPage(OrderSearchModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchPromotionsByPage",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));
	}

	@Override
	public List<TPromotion> selectPromationByOneMatnr(TPromotion record) {
		return sqlSessionTemplate.selectList("selectPromationByOneMatnr",record);
	}

	@Override
	public List<TPromotion> selectPromationByOrder(TPromotion record) {
		return sqlSessionTemplate.selectList("selectPromationByOrder",record);
	}

	@Override
	public List<TPromotion> selectPromotionByYear(TPromotion record) {
		return sqlSessionTemplate.selectList("selectPromotionByYear",record);
	}

	@Override
	public TPromotion selectPromotionByPromNoAndItemNo(TPromotion record) {
		return sqlSessionTemplate.selectOne("selectPromotionByPromNoAndItemNo",record);
	}

	@Override
	public List<TPromotionModel> selectPromotionByEntryAndAmt(TPromotion pro) {
		return sqlSessionTemplate.selectList("selectPromotionByEntryAndAmt",pro);
	}

	@Override
	public List<TPromotionModel> selectPromotionsByOrder(TPromotion pro) {
		return sqlSessionTemplate.selectList("selectPromotionsByOrder",pro);
	}

	@Override
	public List<TPromotionModel> selYearCardPromBySalesOrg(TPromotion prom) {
		return sqlSessionTemplate.selectList("selYearCardPromBySalesOrg",prom);
	}

	@Override
	public List<TPromotion> selYearCardPromByPromNo(TPromotion prom) {
		return sqlSessionTemplate.selectList("selYearCardPromByPromNo",prom);
	}

	@Override
	public int insertPromotion(TPromotion promotion) {
		
		return sqlSessionTemplate.insert("insertPromSelective",promotion);
	}

	@Override
	public List<TPromotion> searchPromoDetailByNo(String promNo) {
		return sqlSessionTemplate.selectList("searchPromoDetailByNo",promNo);
	}

	@Override
	public int delPromByNo(String promNo) {
		return sqlSessionTemplate.delete("delPromByNo",promNo);
	}

	@Override
	public PageInfo searchPromoByPage(PromSearchModel smodel) {
		return sqlSessionTemplate.selectListByPages("searchPromoByPage",smodel, Integer.parseInt(smodel.getPageNum()), Integer.parseInt(smodel.getPageSize()));

	}

	@Override
	public List<TPromotion> selectPromsBySelesOrg(PromSearchModel smodel) {
		return sqlSessionTemplate.selectList("selectPromsBySelesOrg",smodel);
	}

	@Override
	public List<TPromotionOrderModel> promotionHasOrder(PromAllocatModel smodel) {
		return sqlSessionTemplate.selectList("promotionHasOrder",smodel);
	}
}
