package com.nhry.data.promotion.dao;

import java.util.List;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.promotion.domain.PromotionScopeItem;

public interface PromotionScopeItemMapper {

    int insertScopeItem(PromotionScopeItem record);

    PromotionScopeItem selectScopeItem(PromotionScopeItem key);
    
    List<PromotionScopeItem> selectScopeItemsByKey(PromotionScopeItem key);

	int delPromScopeByNo(String promNo);
	
	int delPromScopeByPromScope(PromotionScopeItem key);

}