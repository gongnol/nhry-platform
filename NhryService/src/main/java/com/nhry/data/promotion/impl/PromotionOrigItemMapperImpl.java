package com.nhry.data.promotion.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.promotion.dao.PromotionOrigItemMapper;
import com.nhry.data.promotion.domain.PromotionOrigItem;
import com.nhry.data.promotion.domain.PromotionOrigItemKey;

/**
 * Created by cbz on 8/8/2016.
 */
public class PromotionOrigItemMapperImpl implements PromotionOrigItemMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override

    public int insertOrigItem(PromotionOrigItem record) {
        return sqlSessionTemplate.insert("insertOrigItem",record);
    }

    @Override
    public PromotionOrigItem selectOrigItem(PromotionOrigItemKey key) {
        return sqlSessionTemplate.selectOne("selectOrigItem",key);
    }

    @Override
    public int updateOrigItemSelective(PromotionOrigItem record) {
        return sqlSessionTemplate.update("updateOrigItemSelective",record);
    }

    @Override
    public int updateOrigItem(PromotionOrigItem record) {
        return sqlSessionTemplate.update("updateOrigItem",record);
    }

	@Override
	public int delOrigPromByNo(String promNo) {
		return sqlSessionTemplate.delete("delOrigPromByNo",promNo);
	}
}
