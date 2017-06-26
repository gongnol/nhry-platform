package com.nhry.service.pi.dao;

import com.nhry.service.pi.pojo.PIMessage;
import com.nhry.service.pi.pojo.PIPromotion;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by cbz on 8/8/2016.
 */
@WebService
public interface PIPromotionDataService {
    PIMessage getPromotionData(@WebParam(name = "PIPromotions") PIPromotion piPromotion);
}
