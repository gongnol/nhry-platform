package com.nhry.data.promotion.dao;

import com.nhry.data.promotion.domain.PromotionGiftItem;
import com.nhry.data.promotion.domain.PromotionGiftItemKey;

public interface PromotionGiftItemMapper {

    int insertGiftItem(PromotionGiftItem record);

    PromotionGiftItem selectGiftItem(PromotionGiftItemKey key);

    int updateGiftItemSelective(PromotionGiftItem record);

    int updateGiftItem(PromotionGiftItem record);

	int delGiftPromByNo(String promNo);
}