package com.nhry.service.pi.pojo;

import com.nhry.data.promotion.domain.*;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by cbz on 8/8/2016.
 */
public class PIPromotion {
    Promotion promotion;
    List<PromotionConItem> promotionConItems = new ArrayList<PromotionConItem>();
    List<PromotionGiftItem> promotionGiftItems = new ArrayList<PromotionGiftItem>();
    List<PromotionOrigItem> promotionOrigItems = new ArrayList<PromotionOrigItem>();
    List<PromotionScopeItem> promotionScopeItems = new ArrayList<PromotionScopeItem>();

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<PromotionConItem> getPromotionConItems() {
        return promotionConItems;
    }

    public void setPromotionConItems(List<PromotionConItem> promotionConItems) {
        this.promotionConItems = promotionConItems;
    }

    public List<PromotionGiftItem> getPromotionGiftItems() {
        return promotionGiftItems;
    }

    public void setPromotionGiftItems(List<PromotionGiftItem> promotionGiftItems) {
        this.promotionGiftItems = promotionGiftItems;
    }

    public List<PromotionOrigItem> getPromotionOrigItems() {
        return promotionOrigItems;
    }

    public void setPromotionOrigItems(List<PromotionOrigItem> promotionOrigItems) {
        this.promotionOrigItems = promotionOrigItems;
    }

    public List<PromotionScopeItem> getPromotionScopeItems() {
        return promotionScopeItems;
    }

    public void setPromotionScopeItems(List<PromotionScopeItem> promotionScopeItems) {
        this.promotionScopeItems = promotionScopeItems;
    }
}
