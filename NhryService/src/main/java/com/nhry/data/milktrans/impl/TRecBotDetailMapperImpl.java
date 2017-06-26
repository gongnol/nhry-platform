package com.nhry.data.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TRecBotDetailMapper;
import com.nhry.data.milktrans.domain.TRecBotDetail;
import com.nhry.model.milktrans.ReturnboxSerarch;
import com.nhry.model.stock.StockModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/6/28.
 */
public class TRecBotDetailMapperImpl implements TRecBotDetailMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public int addRecBotItem(TRecBotDetail bot) {
        return sqlSessionTemplate.insert("addRecBotItem",bot);
    }

    @Override
    public TRecBotDetail selectBotDetailByDetLsh(Map<String, String> map) {
        return sqlSessionTemplate.selectOne("selectBotDetailByDetLshAndSpec",map);
    }

    @Override
    public TRecBotDetail selectBotDetailByOrderAndSpec(Map<String, String> map) {
        return sqlSessionTemplate.selectOne("selectBotDetailByOrderAndSpec",map);
    }

    @Override
    public List<TRecBotDetail> selectRetByDispOrderNo(String dispOrderNo) {
        return sqlSessionTemplate.selectList("selectRetByDispOrderNo",dispOrderNo);
    }

    @Override
    public List<TRecBotDetail> craeteRetBotByStock(StockModel sModel) {
        return sqlSessionTemplate.selectList("craeteRetBotByStock",sModel);
    }

    @Override
    public int delBotDetailByDetLsh(String detLsh) {
        return sqlSessionTemplate.delete("delBotDetailByDetLsh",detLsh);
    }

    @Override
    public int uptRecBotDetail(TRecBotDetail entry) {
        return sqlSessionTemplate.update("uptRecBotDetail",entry);
    }

    @Override
    public PageInfo searchRetBoxPage(ReturnboxSerarch rSearch) {
        return sqlSessionTemplate.selectListByPages("searchRetBoxPage", rSearch, Integer.parseInt(rSearch.getPageNum()), Integer.parseInt(rSearch.getPageSize()));

    }
}
