package com.nhry.data.stock.impl;

import com.nhry.common.datasource.DynamicDataSource;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.stock.dao.TSsmGiOrderMapper;
import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.model.stock.GiOrderModel;

import java.util.List;

/**
 * Created by cbz on 7/7/2016.
 */
public class TSsmGiOrderMapperImpl implements TSsmGiOrderMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteGiOrderByNo(String orderNo) {
        return 0;
    }

    @Override
    public int insertGiOrder(TSsmGiOrder record) {
        return sqlSessionTemplate.insert("insertGiOrder",record);
    }

    @Override
    public int insertGiOrderSelective(TSsmGiOrder record) {
        return 0;
    }

    @Override
    public TSsmGiOrder selectGiOrderByNo(String orderNo) {
        return sqlSessionTemplate.selectOne("selectGiOrderByNo",orderNo);
    }

    @Override
    public int updateGiOrderSelective(TSsmGiOrder record) {
        return sqlSessionTemplate.update("updateGiOrderSelective",record);
    }

    @Override
    public int updateGiOrder(TSsmGiOrder record) {
        return sqlSessionTemplate.update("updateGiOrder",record);
    }

    @Override
    public List<TSsmGiOrder> findGiOrder(GiOrderModel model) {
        return sqlSessionTemplate.selectList("findGiOrder",model);
    }

    @Override
    public List<TSsmGiOrder> findGiOrderByReqOrderNo(String reqOrderNo) {
        return sqlSessionTemplate.selectList("findGiOrderByReqOrderNo",reqOrderNo);
    }
}
