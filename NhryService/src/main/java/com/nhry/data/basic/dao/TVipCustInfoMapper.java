package com.nhry.data.basic.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.model.basic.CustQueryModel;
import com.nhry.model.basic.CustStat;

public interface TVipCustInfoMapper {
	
	/**
	 * 添加订户
	 * @param record
	 * @return
	 */
    int addVipCust(TVipCustInfo record);

    /**
     * 根据订户编号查询订户信息(包含地址信息)
     * @param vipCustNo
     * @return
     */
    TVipCustInfo findVipCustByNo(String vipCustNo);
    
    /**
     * 根据订户编号查询订户信息(包含地址信息)
     * @param vipCustNo
     * @return
     */
    TVipCustInfo findVipCustByNoForUpt(String vipCustNo);
    
    /**
     * 找出该销售组织下没有会员编号的订户
     * @param record
     * @return
     */
    List<TVipCustInfo> findVipCustByNoSapNo(String salesOrg);
    
    /**
     * 修改订户信息
     * @param record
     * @return
     */
    int updateVipCustByNo(TVipCustInfo record);
    
    /**
     * 根据电话查找奶站订户信息
     * @param attrs
     * @return
     */
    TVipCustInfo findStaCustByPhone(Map<String,String> attrs);
    
    /**
     * 根据电话查找公司订户信息
     * @param attrs
     * @return
     */
    List<TVipCustInfo> findCompanyCustByPhone(Map<String,String> attrs);
    
    /**
     * 查询订户信息(只查询订户信息本身)
     * @param vipCustNo
     * @return
     */
    TVipCustInfo findVipCustOnlyByNo(String vipCustNo);
    
    /**
     * 修改订户状态
     * @param record
     * @return
     */
    int uptCustStatus(TVipCustInfo record);
    
    /**
     * 根据混合条件查询订户列表信息
     * @param cust
     * @return
     */
    public PageInfo findcustMixedTerms(CustQueryModel cust);

    /**
     * 机构订户根据混合条件查询订户列表信息
     * @param cust
     * @return
     */
    public PageInfo findCustByOrgId(CustQueryModel cust);
    
    /**
     * 根据电话号码获取在同一奶站下订户的个数
     * @param attrs
     * @return
     */
    public int getCustCountByPhone(Map<String,String> attrs);
    
    /**
     * 根据电话号码获取在订户编号
     * @param attrs
     * @return
     */
    public String getCustNoByPhone(Map<String,String> attrs);
    
    /**
     * 根据订户编号，删除订户信息
     * @param cno
     * @return
     */
    public int deleteCustByCno(String cno);
    
    /**
     * 获取当前组织订户状态统计数据
     * @param attrs
     * @return
     */
    public List<CustStat> getCustInfoStat(Map<String,String> attrs);

    /**
     * 更新会员编号
     */
    public int updateSapNo(TVipCustInfo vipCustInfo);

    public int updateVipMp(TVipCustInfo vipCustInfo);

    PageInfo findCustByOrg(CustQueryModel cust);

    PageInfo findCustWithoutOrg(CustQueryModel cust);
}