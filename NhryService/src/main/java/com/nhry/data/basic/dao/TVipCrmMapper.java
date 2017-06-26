package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TVipCrmInfo;

import java.util.Map;

public interface TVipCrmMapper {
	
	/**
	 * 添加会员
	 * @param record
	 * @return
	 */
    int addVipCrm(TVipCrmInfo record);
    
    /**
     * 根据订户编号查询订户信息(包含地址信息)
     * @param vipCrmNo
     * @return
     */
    TVipCrmInfo findVipCrmByNo(String vipCrmNo);
    
    /**
     * 根据订户编号查询订户信息(包含地址信息)
     * @param vipCrmNo
     * @return
     */
    TVipCrmInfo findVipCrmByNoForUpt(String vipCrmNo);
    
    /**
     * 修改订户信息
     * @param record
     * @return
     */
    int updateVipCrmByNo(TVipCrmInfo record);
    
//    /**
//     * 根据电话查找奶站订户信息
//     * @param attrs
//     * @return
//     */
//    List<TVipCrmInfo> findStaCrmByPhone(Map<String, String> attrs);
//
//    /**
//     * 根据电话查找公司订户信息
//     * @param attrs
//     * @return
//     */
//    List<TVipCrmInfo> findCompanyCrmByPhone(Map<String, String> attrs);
    
    /**
     * 查询订户信息(只查询订户信息本身)
     * @param vipCrmNo
     * @return
     */
    TVipCrmInfo findVipCrmOnlyByNo(String vipCrmNo);
    
    /**
     * 修改订户状态
     * @param record
     * @return
     */
    int uptCrmStatus(TVipCrmInfo record);
    
//    /**
//     * 根据混合条件查询订户列表信息
//     * @param Crm
//     * @return
//     */
//    public PageInfo findCrmMixedTerms(CrmQueryModel Crm);
    
//    /**
//     * 根据电话号码获取在同一奶站下订户的个数
//     * @param attrs
//     * @return
//     */
//    public int getCrmCountByPhone(Map<String, String> attrs);
    
    /**
     * 根据电话号码获取在订户编号
     * @param attrs
     * @return
     */
    public String getCrmNoByPhone(Map<String, String> attrs);

    public TVipCrmInfo getVipCrm(String vipCustNo);

}