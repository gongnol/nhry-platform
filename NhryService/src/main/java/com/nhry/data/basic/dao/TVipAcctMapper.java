package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TVipAcct;

public interface TVipAcctMapper {
	/**
	 * 添加订户订奶资金账户
	 * @param record
	 * @return
	 */
    int addVipAcct(TVipAcct record);
    
    /**
     * 根据会员编号查询资金账号
     * @param custNo
     * @return
     */
    TVipAcct findVipAcctByCustNo(String custNo);
    
    /**
     * 修改资金账号
     * @param record
     * @return
     */
    int uptVipAcct(TVipAcct record);
}