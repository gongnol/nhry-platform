package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TVipCrmAddress;

public interface TVipCrmAddressMapper {
    
    /**
     * 添加会员详细地址
     * @param record
     * @return
     */
    int addVipCrmAddress(TVipCrmAddress record);
    
    /**
     * 根据地址编号查询地址详细信息
     * @param addressId
     * @return
     */
    TVipCrmAddress findVipCrmAddress(String addressId);
    
    /**
     * 修改会员地址详细信息
     * @param record
     * @return
     */
    int uptVipCrmAddress(TVipCrmAddress record);
}