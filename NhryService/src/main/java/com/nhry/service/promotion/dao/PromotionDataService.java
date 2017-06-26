package com.nhry.service.promotion.dao;

import com.nhry.data.promotion.domain.*;

/**
 * Created by cbz on 8/9/2016.
 */
public interface PromotionDataService {
    Promotion selectPromotionByNo(String no);
    PromotionOrigItem selectOrigItemByKey(PromotionOrigItemKey key);
    PromotionConItem selectConItemByKey(PromotionConItemKey key);
    PromotionScopeItem selectScopeItemByKey(PromotionScopeItem key);
    PromotionGiftItem selectGiftItemByKey(PromotionGiftItemKey key);
    int savePromotion(Promotion promotion);
    int savePromotionOrigItem(PromotionOrigItem item);
    int savePromotionConItem(PromotionConItem item);
    int savePromotionScopeItem(PromotionScopeItem item);
    int savePromotionGiftItem(PromotionGiftItem item);
}
