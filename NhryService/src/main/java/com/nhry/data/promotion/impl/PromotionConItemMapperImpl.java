package com.nhry.data.promotion.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.promotion.dao.PromotionConItemMapper;
import com.nhry.data.promotion.domain.PromotionConItem;
import com.nhry.data.promotion.domain.PromotionConItemKey;

/**
 * Created by cbz on 8/8/2016.
 */
public class PromotionConItemMapperImpl implements PromotionConItemMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertConItem(PromotionConItem record) {
        return sqlSessionTemplate.insert("insertConItem",record);
    }

    @Override
    public PromotionConItem selectConItem(PromotionConItemKey key) {
        return sqlSessionTemplate.selectOne("selectConItem",key);
    }

    @Override
    public int updateConItemSelective(PromotionConItem record) {
        return sqlSessionTemplate.update("updateConItemSelective",record);
    }

    @Override
    public int updateConItem(PromotionConItem record) {
        return sqlSessionTemplate.update("updateConItem",record);
    }
    
    @Override
	public int delConPromByNo(String promNo) {
		return sqlSessionTemplate.delete("delConPromByNo",promNo);
	}
}
