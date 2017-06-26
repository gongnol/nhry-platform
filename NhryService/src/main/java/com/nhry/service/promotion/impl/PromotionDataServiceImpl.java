package com.nhry.service.promotion.impl;

import com.nhry.data.promotion.dao.*;
import com.nhry.data.promotion.domain.*;
import com.nhry.service.promotion.dao.PromotionDataService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by cbz on 8/9/2016.
 */
public class PromotionDataServiceImpl implements PromotionDataService{
    private static Logger logger = Logger.getLogger(PromotionDataServiceImpl.class);
    private PromotionMapper promotionMapper;
    private PromotionOrigItemMapper promotionOrigItemMapper;
    private PromotionConItemMapper promotionConItemMapper;
    private PromotionGiftItemMapper promotionGiftItemMapper;
    private PromotionScopeItemMapper promotionScopeItemMapper;

    public void setPromotionMapper(PromotionMapper promotionMapper) {
        this.promotionMapper = promotionMapper;
    }

    public void setPromotionOrigItemMapper(PromotionOrigItemMapper promotionOrigItemMapper) {
        this.promotionOrigItemMapper = promotionOrigItemMapper;
    }

    public void setPromotionConItemMapper(PromotionConItemMapper promotionConItemMapper) {
        this.promotionConItemMapper = promotionConItemMapper;
    }

    public void setPromotionGiftItemMapper(PromotionGiftItemMapper promotionGiftItemMapper) {
        this.promotionGiftItemMapper = promotionGiftItemMapper;
    }

    public void setPromotionScopeItemMapper(PromotionScopeItemMapper promotionScopeItemMapper) {
        this.promotionScopeItemMapper = promotionScopeItemMapper;
    }

    @Override
    public Promotion selectPromotionByNo(String no) {
        return promotionMapper.selectPromotion(no);
    }

    @Override
    public PromotionOrigItem selectOrigItemByKey(PromotionOrigItemKey key) {
        return promotionOrigItemMapper.selectOrigItem(key);
    }

    @Override
    public PromotionConItem selectConItemByKey(PromotionConItemKey key) {
        return promotionConItemMapper.selectConItem(key);
    }

    @Override
    public PromotionScopeItem selectScopeItemByKey(PromotionScopeItem key) {
        return promotionScopeItemMapper.selectScopeItem(key);
    }

    @Override
    public PromotionGiftItem selectGiftItemByKey(PromotionGiftItemKey key) {
        return promotionGiftItemMapper.selectGiftItem(key);
    }

    @Override
    public int savePromotion(Promotion promotion) {
        logger.info("促销活动开始："+promotion.getPromNo());
        int i = 0;
        Promotion p = this.selectPromotionByNo(promotion.getPromNo());
        if(p == null){
            if(StringUtils.isEmpty(promotion.getPromStat())){
                promotion.setPromStat("E0006");
            }
            promotion.setCreateAt(new Date());
            promotion.setCreateByTxt("CRM");
            promotion.setCreateBy("CRM");
             i = promotionMapper.insertPromotion(promotion);
        }else{
            promotion.setLastModified(new Date());
            promotion.setLastModifiedBy("CRM");
            promotion.setLastModifiedByTxt("CRM");
            i = promotionMapper.updatePromotionSelective(promotion);
        }
        logger.info("促销活动结束");
        return i;
    }

    @Override
    public int savePromotionOrigItem(PromotionOrigItem item) {
        int i = 0;
        PromotionOrigItemKey key = new PromotionOrigItemKey();
        key.setItemNo(item.getItemNo());
        key.setPromNo(item.getPromNo());
        PromotionOrigItem origItem = this.selectOrigItemByKey(key);
        if(origItem == null){
            promotionOrigItemMapper.insertOrigItem(item);
        }else{
            promotionOrigItemMapper.updateOrigItemSelective(item);
        }
        return i;
    }

    @Override
    public int savePromotionConItem(PromotionConItem item) {
        int i = 0;
        PromotionConItemKey key = new PromotionConItemKey();
        key.setItemNo(item.getItemNo());
        key.setPromNo(item.getPromNo());
        PromotionConItem ConItem = this.selectConItemByKey(key);
        if(ConItem == null){
            promotionConItemMapper.insertConItem(item);
        }else{
            promotionConItemMapper.updateConItemSelective(item);
        }
        return i;
    }

    @Override
    public int savePromotionScopeItem(PromotionScopeItem item) {
        int i = 0;
        PromotionScopeItem ScopeItem = this.selectScopeItemByKey(item);
        if(ScopeItem == null){
            promotionScopeItemMapper.insertScopeItem(item);
        }
        return i;
    }

    @Override
    public int savePromotionGiftItem(PromotionGiftItem item) {
        int i = 0;
        PromotionGiftItemKey key = new PromotionGiftItemKey();
        key.setItemNo(item.getItemNo());
        key.setPromNo(item.getPromNo());
        PromotionGiftItem GiftItem = this.selectGiftItemByKey(key);
        if(GiftItem == null){
            promotionGiftItemMapper.insertGiftItem(item);
        }else{
            promotionGiftItemMapper.updateGiftItemSelective(item);
        }
        return i;
    }
}
