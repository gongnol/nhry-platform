package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdOrgPriceMapper;
import com.nhry.data.basic.domain.TMdOrgPrice;
import com.nhry.model.basic.OrgPriceModel;

import java.util.List;

/**
 * Created by huaguan on 2017/4/24.
 */
public class TMdOrgPriceMapperImpl implements TMdOrgPriceMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertOrgPriceSelective(TMdOrgPrice record) {
        return sqlSessionTemplate.insert("insertOrgPriceSelective",record);
    }

    @Override
    public int updateOrgPriceSelective(TMdOrgPrice record) {
        return sqlSessionTemplate.update("updateOrgPriceSelective",record);
    }

    @Override
    public int isOrgPriceEmp(TMdOrgPrice record) {
        return sqlSessionTemplate.selectOne("isOrgPriceEmp",record);
    }

    @Override
    public List<TMdOrgPrice> selectListByOrgIdAndSaleOrg(TMdOrgPrice record) {
        return sqlSessionTemplate.selectList("selectOrgPriceByOrgIdAndSaleOrg",record);
    }

    @Override
    public List<TMdOrgPrice> selectOrgPriceList(OrgPriceModel record) {
        return sqlSessionTemplate.selectList("selectOrgPriceList",record);
    }

    @Override
    public TMdOrgPrice selectOrgPriceById(String id) {
        return sqlSessionTemplate.selectOne("selectOrgPriceById",id);
    }

    @Override
    public PageInfo selectOrgPricePage(OrgPriceModel record) {
        return sqlSessionTemplate.selectListByPages("selectOrgPriceListPage",record, Integer.parseInt(record.getPageNum()),Integer.parseInt(record.getPageSize()));
    }

    @Override
    public TMdOrgPrice selectOrgPriceByMatnr(OrgPriceModel record) {
        return sqlSessionTemplate.selectOne("selectOrgPriceByMatnr",record);
    }

    @Override
    public PageInfo selectOrgPriceListOldPrice(OrgPriceModel record) {
        return sqlSessionTemplate.selectListByPages("selectOrgPriceListOldPrice",record, Integer.parseInt(record.getPageNum()),Integer.parseInt(record.getPageSize()));
    }

    @Override
    public List<TMdOrgPrice> selectOrgPriceMatnrList(OrgPriceModel record) {
        return sqlSessionTemplate.selectList("selectOrgPriceListOldPrice",record);
    }

    @Override
    public TMdOrgPrice selectOrgPriceByMatnrOldPrice(OrgPriceModel record) {
        return sqlSessionTemplate.selectOne("selectOrgPriceByMatnrOldPrice",record);
    }
}
