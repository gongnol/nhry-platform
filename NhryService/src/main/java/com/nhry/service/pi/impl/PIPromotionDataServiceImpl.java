package com.nhry.service.pi.impl;

import com.nhry.data.promotion.domain.*;
import com.nhry.service.pi.dao.PIPromotionDataService;
import com.nhry.service.pi.pojo.PIMessage;
import com.nhry.service.pi.pojo.PIPromotion;
import com.nhry.service.promotion.dao.PromotionDataService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;
/**
 * Created by cbz on 8/8/2016.
 */
@WebService
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class PIPromotionDataServiceImpl implements PIPromotionDataService {
    PromotionDataService promotionDataService;

    public void setPromotionDataService(PromotionDataService promotionDataService) {
        this.promotionDataService = promotionDataService;
    }

    @Override
    public PIMessage getPromotionData(PIPromotion piPromotion) {

        PIMessage message = new PIMessage();
        try {
            Promotion promotion = piPromotion.getPromotion();
            List<PromotionConItem> conItems = piPromotion.getPromotionConItems();
            List<PromotionGiftItem> giftItems = piPromotion.getPromotionGiftItems();
            List<PromotionScopeItem> scopeItems = piPromotion.getPromotionScopeItems();
            List<PromotionOrigItem> origItems = piPromotion.getPromotionOrigItems();
            promotionDataService.savePromotion(promotion);

            if (conItems != null) {
                for (PromotionConItem conItem : conItems) {
                    promotionDataService.savePromotionConItem(conItem);
                }
            }

            if (scopeItems != null) {
                for (PromotionScopeItem scopeItem : scopeItems) {
                    promotionDataService.savePromotionScopeItem(scopeItem);
                }
            }

            if (origItems != null) {
                for (PromotionOrigItem origItem : origItems) {
                    String goodNo = origItem.getGoodNo();
                    if(goodNo.length()>18) {
                        origItem.setGoodNo(goodNo.substring(goodNo.length()-18));
                    }
                    promotionDataService.savePromotionOrigItem(origItem);
                }
            }

            if (giftItems != null) {
                for (PromotionGiftItem giftItem : giftItems) {
                    String giftNo = giftItem.getGiftNo();
                    if(giftNo.length() > 18) {
                        giftItem.setGiftNo(giftNo.substring(giftNo.length() - 18));
                    }
                    promotionDataService.savePromotionGiftItem(giftItem);
                }
            }
            message.setSuccess(true);
            message.setMessage("OK");
        }catch (Exception e){
            message.setMessage("fail");
            message.setSuccess(false);
        }
        return message;
    }
}
