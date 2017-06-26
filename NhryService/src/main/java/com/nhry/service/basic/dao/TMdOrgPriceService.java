package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdOrgPrice;
import com.nhry.model.basic.OrgPriceModel;

import java.util.Date;
import java.util.List;

/**
 * Created by huaguan on 2017/4/24.
 */
public interface TMdOrgPriceService {
    /**
     * 插入机构价格
     * @param record
     * @return
     */
    int insertOrgPriceSelective(TMdOrgPrice record);

    /**
     * 更新机构价格
     * @param record
     * @return
     */
    int updateOrgPriceSelective(List<TMdOrgPrice> record);

    /**
     * 根据机构ID初始化该机构下价格产品信息
     * @param OrgId
     * @return
     */
    int inserListOrgMatnr(String OrgId);

    List<TMdOrgPrice> selectOrgPriceList(OrgPriceModel record);

    /**
     *
     * @param record
     * @return
     */
    int updateOrgPrice(TMdOrgPrice record);

    /**
     *
     * @param record
     * @return
     */
    PageInfo selectOrgPricePage(OrgPriceModel record);

    TMdOrgPrice selectOrgPriceByMatnr(OrgPriceModel record);

    PageInfo selectOrgPriceListOldPrice(OrgPriceModel record);

    List<TMdOrgPrice> selectOrgPriceMatnrList(OrgPriceModel record);

    TMdOrgPrice selectOrgPriceByMatnrOldPrice(String orgCode, Date orderDate, String matnr);
}
