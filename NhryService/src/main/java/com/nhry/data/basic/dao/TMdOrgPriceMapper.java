package com.nhry.data.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdOrgPrice;
import com.nhry.model.basic.OrgPriceModel;

import java.util.List;

public interface TMdOrgPriceMapper {

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
    int updateOrgPriceSelective(TMdOrgPrice record);

    /**
     * 查询该销售组织、机构下是否有产品价格组信息，如果没有，进行初始化
     * @param record
     * @return
     */
    int isOrgPriceEmp(TMdOrgPrice record);

    /**
     * 根据销售组织、机构编号获取价格列表
     * @param record
     * @return
     */
    List<TMdOrgPrice> selectListByOrgIdAndSaleOrg(TMdOrgPrice record);

    /**
     * 获取价格列表
     * @param record
     * @return
     */
    List<TMdOrgPrice> selectOrgPriceList(OrgPriceModel record);

    /**
     * ID获取机构价格信息
     * @param id
     * @return
     */
    TMdOrgPrice selectOrgPriceById(String id);

    /**
     * 分页获取机构价格商品列表
     * @param record
     * @return
     */
    PageInfo selectOrgPricePage(OrgPriceModel record);

    /**
     * 获取价格
     * @param record
     * @return
     */
    TMdOrgPrice selectOrgPriceByMatnr(OrgPriceModel record);

    /**
     *
     * @param record
     * @return
     */
    PageInfo selectOrgPriceListOldPrice(OrgPriceModel record);

    /**
     *  机构下返回可售卖产品列表
     * @param record
     * @return
     */
    List<TMdOrgPrice> selectOrgPriceMatnrList(OrgPriceModel record);

    /**
     * 根据产品、机构获取该产品机构价格
     * @param record
     * @return
     */
    TMdOrgPrice selectOrgPriceByMatnrOldPrice(OrgPriceModel record);
}