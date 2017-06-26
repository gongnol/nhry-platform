package com.nhry.data.promotion.dao;

import com.nhry.data.promotion.domain.PromotionConItem;
import com.nhry.data.promotion.domain.PromotionConItemKey;

public interface PromotionConItemMapper {

    int insertConItem(PromotionConItem record);

    PromotionConItem selectConItem(PromotionConItemKey key);

    int updateConItemSelective(PromotionConItem record);

    int updateConItem(PromotionConItem record);

	int delConPromByNo(String promNo);
}