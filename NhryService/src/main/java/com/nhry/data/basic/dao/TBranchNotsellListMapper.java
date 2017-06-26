package com.nhry.data.basic.dao;

import java.util.List;
import java.util.Map;

import com.nhry.data.basic.domain.TBranchNotsellList;

public interface TBranchNotsellListMapper {
	/**
	 * 根据清单号删除不可销售的清单
	 * @param listNo
	 * @return
	 */
    int delBranchNotsellByNo(String listNo);
    
    /**
     * 添加销售清单
     * @param record
     * @return
     */
    int addBranchNotSell(TBranchNotsellList record);
    
    /**
     * 根据产品编号删除相应的不可销售的清单
     * @param matnr
     * @return
     */
    int delBranchNotsellByMatnr(String matnr);
    
    /**
     * 根据物料编号，查询不可销售的范围
     * @param matnr
     * @return
     */
    public List<TBranchNotsellList> getNotSellListByMatnr(Map<String,String> attrs);
    
    /**
     * 根据物料编号，查询不可销售的经销商ids
     * @param attrs
     * @return
     */
    public List<String> getNotSellDealerNosByMatnr(Map<String,String> attrs);
}