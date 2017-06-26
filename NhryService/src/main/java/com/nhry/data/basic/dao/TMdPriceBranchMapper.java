package com.nhry.data.basic.dao;

import java.util.Map;

import com.nhry.data.basic.domain.TMdPriceBranch;

public interface TMdPriceBranchMapper {
	
	/**
	 * 添加价格组与奶站关系
	 * @param record
	 * @return
	 */
    int addPriceBranch(TMdPriceBranch record);
    
    /**
     * 根据奶站编号删除奶站价格组关系
     * @param branchNo
     * @return
     */
    int delPriceBranchByNo(String branchNo);
    
    /**
     * 根据价格组id删除奶站与价格组关联关系
     * @param id
     * @return
     */
    int delPriceBranchById(String id);
    
    /**
     * 根据奶站编号和价格组id删除奶站与价格组关系
     * @param record
     * @return
     */
    int delPriceBranch(Map<String,String> atrrs);
    
    /**
     * 根据奶站编号、价格组编号 查询奶站与价格组关系行数量
     * @param attrs
     * @return
     */
    int findPriceBranchCount(Map<String,String> attrs);
    
    /**
     * 根据价格组类型、奶站编号、价格组编号 查询奶站与价格组关系行数量
     * @param attrs
     * @return
     */
    int findPriceBrachCountByPt(TMdPriceBranch record);
}