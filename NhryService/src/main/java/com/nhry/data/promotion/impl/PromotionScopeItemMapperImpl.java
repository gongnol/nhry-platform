package com.nhry.data.promotion.impl;

import java.util.List;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.promotion.dao.PromotionScopeItemMapper;
import com.nhry.data.promotion.domain.PromotionScopeItem;
import com.nhry.rest.basic.PromAllocatModel;

/**
 * Created by cbz on 8/8/2016.
 */
public class PromotionScopeItemMapperImpl implements PromotionScopeItemMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertScopeItem(PromotionScopeItem record) {
        return sqlSessionTemplate.insert("insertScopeItem",record);
    }

    @Override
    public PromotionScopeItem selectScopeItem(PromotionScopeItem key) {
        return sqlSessionTemplate.selectOne("selectScopeItem",key);
    }

	@Override
	public int delPromScopeByNo(String promNo) {
		
		return sqlSessionTemplate.delete("delPromScopeByNo",promNo);
	}

	@Override
	public List<PromotionScopeItem> selectScopeItemsByKey(PromotionScopeItem key) {
		return sqlSessionTemplate.selectList("selectScopeItemsByKey",key);
	}

	@Override
	public int delPromScopeByPromScope(PromotionScopeItem key) {
		return sqlSessionTemplate.delete("delPromScopeByPromScope",key);
	}

	@Override
	public int delPromScopesByScope( PromAllocatModel model) {
		return sqlSessionTemplate.delete("delPromScopesByScope",model);
	}

}
