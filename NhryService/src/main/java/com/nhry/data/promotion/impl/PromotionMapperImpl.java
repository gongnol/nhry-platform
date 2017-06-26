package com.nhry.data.promotion.impl;

import com.nhry.common.datasource.DynamicDataSource;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.promotion.dao.PromotionMapper;
import com.nhry.data.promotion.domain.Promotion;

/**
 * Created by cbz on 8/8/2016.
 */
public class PromotionMapperImpl implements PromotionMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertPromotion(Promotion record) {
        return sqlSessionTemplate.insert("insertPromotion",record);
    }

    @Override
    public Promotion selectPromotion(String promNo) {
        return sqlSessionTemplate.selectOne("selectPromotion",promNo);
    }

    @Override
    public int updatePromotionSelective(Promotion record) {
        return sqlSessionTemplate.update("updatePromotionSelective",record);
    }

    @Override
    public int updatePromotion(Promotion record) {
        return sqlSessionTemplate.update("updatePromotion",record);
    }
}
