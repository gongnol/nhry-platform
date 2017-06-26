package com.nhry.data.promotion.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.promotion.dao.PromotionGiftItemMapper;
import com.nhry.data.promotion.domain.PromotionGiftItem;
import com.nhry.data.promotion.domain.PromotionGiftItemKey;

/**
 * Created by cbz on 8/8/2016.
 */
public class PromotionGiftItemMapperImpl implements PromotionGiftItemMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertGiftItem(PromotionGiftItem record) {
        return sqlSessionTemplate.insert("insertGiftItem",record);
    }

    @Override
    public PromotionGiftItem selectGiftItem(PromotionGiftItemKey key) {
        return sqlSessionTemplate.selectOne("selectGiftItem",key);
    }

    @Override
    public int updateGiftItemSelective(PromotionGiftItem record) {
        return sqlSessionTemplate.update("updateGiftItemSelective",record);
    }

    @Override
    public int updateGiftItem(PromotionGiftItem record) {
        return sqlSessionTemplate.update("updateGiftItem",record);
    }

	@Override
	public int delGiftPromByNo(String promNo) {
		return  sqlSessionTemplate.delete("delGiftPromByNo",promNo);
	}
}
