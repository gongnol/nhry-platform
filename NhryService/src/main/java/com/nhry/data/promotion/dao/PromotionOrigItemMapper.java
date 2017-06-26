package com.nhry.data.promotion.dao;

import com.nhry.data.promotion.domain.PromotionOrigItem;
import com.nhry.data.promotion.domain.PromotionOrigItemKey;

public interface PromotionOrigItemMapper {

    int insertOrigItem(PromotionOrigItem record);

    PromotionOrigItem selectOrigItem(PromotionOrigItemKey key);

    int updateOrigItemSelective(PromotionOrigItem record);

    int updateOrigItem(PromotionOrigItem record);

	int delOrigPromByNo(String promNo);
}