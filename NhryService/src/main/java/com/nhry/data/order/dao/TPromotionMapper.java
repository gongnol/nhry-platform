package com.nhry.data.order.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.PromSearchModel;
import com.nhry.model.order.TPromotionModel;
import com.nhry.model.order.TPromotionOrderModel;
import com.nhry.rest.basic.PromAllocatModel;

public interface TPromotionMapper {
    List<TPromotion> selectPromotionByMatnr(TPromotion record);

    TPromotion selectPromotionByPromNo(TPromotion record);
    
    PageInfo selectPromotionsrsByPage(OrderSearchModel smodel);

    List<TPromotion> selectPromationByOneMatnr(TPromotion record);

    List<TPromotion> selectPromationByOrder(TPromotion record);

    List<TPromotion> selectPromotionByYear(TPromotion record);

    TPromotion selectPromotionByPromNoAndItemNo(TPromotion record);
    //获取符合订单行的促销，满赠，单品满减
    List<TPromotionModel> selectPromotionByEntryAndAmt(TPromotion pro);
    //获取符合订单的促销，整单满减，年卡
    List<TPromotionModel> selectPromotionsByOrder(TPromotion pro);

    //获取销售组织下  年卡，半年卡，季卡信息
    List<TPromotionModel> selYearCardPromBySalesOrg(TPromotion prom);

    //根据促销编号获取销售组织下年卡信息
    List<TPromotion> selYearCardPromByPromNo(TPromotion prom);

	int insertPromotion(TPromotion promotion);

	List<TPromotion> searchPromoDetailByNo(String promNo);

	int delPromByNo(String promNo);

	PageInfo searchPromoByPage(PromSearchModel smodel);

	List<TPromotion> selectPromsBySelesOrg(PromSearchModel smodel);

	List<TPromotionOrderModel> promotionHasOrder(PromAllocatModel smodel);
	
	
	
}