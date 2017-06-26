package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdPriceYearcardMapper;
import com.nhry.data.basic.domain.TMdPriceYearcard;
import com.nhry.model.basic.YearcardPricePageModel;
import com.nhry.model.basic.YearcardPriceQueryModel;

import java.util.List;

/**
 * Created by chen on 2017/5/15.
 */
public class TMdPriceYearcardMapperImpl implements TMdPriceYearcardMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deletePriceYearcardByKey(String id) {
        return sqlSessionTemplate.delete("deletePriceYearcardByKey",id);
    }

    @Override
    public int insertPriceYearcard(TMdPriceYearcard record) {
        return sqlSessionTemplate.insert("insertPriceYearcard",record);
    }

    @Override
    public TMdPriceYearcard selectPriceYearcardByKey(String id) {
        return sqlSessionTemplate.selectOne("selectPriceYearcardByKey",id);
    }

    @Override
    public int updatePriceYearcardByKey(TMdPriceYearcard record) {
        return sqlSessionTemplate.update("updatePriceYearcardByKey",record);
    }

    @Override
    public List<TMdPriceYearcard> selectPriceYearcardBySalesOrg(YearcardPriceQueryModel record) {
        return sqlSessionTemplate.selectList("selectPriceYearcardBySalesOrg",record);
    }

    @Override
    public TMdPriceYearcard selectPriceYearcardByMatnr(YearcardPriceQueryModel record) {
        return sqlSessionTemplate.selectOne("selectPriceYearcardByMatnr",record);
    }

    @Override
    public TMdPriceYearcard selectOldPriceYearcardByMatnr(YearcardPriceQueryModel recode) {
        return sqlSessionTemplate.selectOne("selectOldPriceYearcardByMatnr",recode);
    }

    @Override
    public PageInfo<TMdPriceYearcard> selectYearcardPriceListPage(YearcardPricePageModel record) {
        return sqlSessionTemplate.selectListByPages("selectYearcardPriceListPage",record,Integer.valueOf(record.getPageNum()),Integer.valueOf(record.getPageSize()));
    }

    @Override
    public PageInfo<TMdPriceYearcard> selectYearcardPriceAndOldPrice(YearcardPricePageModel record) {
        return sqlSessionTemplate.selectListByPages("selectYearcardPriceAndOldPrice",record,Integer.valueOf(record.getPageNum()),Integer.valueOf(record.getPageSize()));
    }
}
