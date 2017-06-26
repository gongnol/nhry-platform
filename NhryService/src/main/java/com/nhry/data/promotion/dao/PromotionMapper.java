package com.nhry.data.promotion.dao;

import com.nhry.data.promotion.domain.Promotion;

public interface PromotionMapper {

    int insertPromotion(Promotion record);

    Promotion selectPromotion(String promNo);

    int updatePromotionSelective(Promotion record);

    int updatePromotion(Promotion record);
}