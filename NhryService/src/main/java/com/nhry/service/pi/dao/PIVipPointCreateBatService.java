package com.nhry.service.pi.dao;

import com.nhry.data.order.domain.TPreOrder;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.webService.client.PISuccessTMessage;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cbz on 11/30/2016.
 */
public interface PIVipPointCreateBatService {
    /**
     * 会员积分活动批量创建
     * @param memberActivities
     * @return
     */
    PISuccessTMessage createMemberActivitiesBat(List<MemberActivities> memberActivities);

    void backPoint(TPreOrder order, BigDecimal initAmt,BigDecimal backAmt);

}
