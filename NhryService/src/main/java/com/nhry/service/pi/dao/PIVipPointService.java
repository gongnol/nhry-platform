package com.nhry.service.pi.dao;

import com.nhry.model.webService.VipPointModel;
import com.nhry.webService.client.PISuccessTMessage;

/**
 * Created by cbz on 7/6/2016.
 */
public interface PIVipPointService {
    /**
     * 会员积分查询
     * @param model
     * @return
     */
    PISuccessTMessage queryVipPointData(VipPointModel model);
}
