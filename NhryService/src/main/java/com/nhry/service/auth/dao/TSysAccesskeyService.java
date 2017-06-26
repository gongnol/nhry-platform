package com.nhry.service.auth.dao;

import com.nhry.data.auth.domain.TSysAccesskey;

public interface TSysAccesskeyService {
	/**
	 * 删除ak
	 * @param key
	 * @return
	 */
    int deleteAccesskeyByAk(TSysAccesskey key);
    
    /**
     * 添加ak
     * @param record
     * @return
     */
    int addIsysAccessKey(TSysAccesskey record);
    
    /**
     * 根据key查找ak
     * @param key
     * @return
     */
    TSysAccesskey findAccesskeyByKey(TSysAccesskey key);
    
    /**
     * 更新ak
     * @param record
     * @return
     */
    int updateIsysAccessKey(TSysAccesskey record);
    
    /**
     * 删除过期的token
     * @return
     */
    public int deleteExpiredAccesskey(); 
}
