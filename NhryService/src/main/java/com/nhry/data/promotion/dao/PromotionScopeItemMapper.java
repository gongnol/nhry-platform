package com.nhry.data.promotion.dao;

import java.util.List;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.promotion.domain.PromotionScopeItem;
import com.nhry.rest.basic.PromAllocatModel;

public interface PromotionScopeItemMapper {

    int insertScopeItem(PromotionScopeItem record);

    PromotionScopeItem selectScopeItem(PromotionScopeItem key);
    
    List<PromotionScopeItem> selectScopeItemsByKey(PromotionScopeItem key);

	int delPromScopeByNo(String promNo);
	/**
	 * 删除单个关系(一个奶站)
	 * @param key
	 * @return
	 */
	int delPromScopeByPromScope(PromotionScopeItem key);
	
	/**
	 * 批量删除
	 * @param key
	 * @return
	 */
	int  delPromScopesByScope(PromAllocatModel model);
	
	

}