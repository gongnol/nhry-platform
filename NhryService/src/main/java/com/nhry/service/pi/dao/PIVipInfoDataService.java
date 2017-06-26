package com.nhry.service.pi.dao;

import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.model.webService.CustomerComplainModel;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.webService.client.EvMemb;
import com.nhry.webService.client.PISuccessTMessage;

import java.util.List;

/**
 * Created by cbz on 7/30/2016.
 */
public interface PIVipInfoDataService {
    /**
     * 会员创建更新
     * @param vipCustInfo
     * @param vipTel
     * @return
     */
    PISuccessTMessage<EvMemb> generateVipInfoData(TVipCustInfo vipCustInfo, String vipTel);

    /**
     * 线程池方式会员创建更新
     * @param vipCustInfo
     * @param vipTel
     */
    void executeVipInfoData(TVipCustInfo vipCustInfo, String vipTel);

    /**
     * 会员积分明细查询
     * @param tel
     * @param membGuid
     * @param membId
     * @return
     */
    PISuccessTMessage queryVipDetailData(String tel,String membGuid,String membId);

    /**
     * 会员积分活动创建
     * @param memberActivities
     * @return
     */
    PISuccessTMessage createMemberActivities(MemberActivities memberActivities);

    /**
     * 订户信息更新
     * @param vipCustInfo
     * @return
     */
    PISuccessTMessage sendSubscriber(TVipCustInfo vipCustInfo);

    /**
     * 线程池方式订户信息更新
     * @param vipCustInfo
     */
    void executeUptVipCust(TVipCustInfo vipCustInfo);
    /**
     * 订户地址更新
     * @param addresss
     * @param sapGuid
     * @return
     */
    PISuccessTMessage sendAddress(List<TMdAddress> addresss, String sapGuid);
    /**
     * 线程池方式订户地址更新
     * @param address
     * @param sapGuid
     * @return
     */
    void executeSendAddress(TMdAddress address,String sapGuid);
    /**
     * 线程池方式订户地址更新
     * @param addresses
     * @param sapGuid
     * @return
     */
    void executeSendAddresses(List<TMdAddress> addresses,String sapGuid);

    /**
     * 送奶员投诉信息
     * @param model
     * @return
     */
    PISuccessTMessage queryCustomerComplain(CustomerComplainModel model);

}
