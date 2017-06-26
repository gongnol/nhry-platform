package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.model.basic.BranchExkostlModel;

/**
 * 奶站扩展数据
 */
public interface TMdBranchExMapper {
    int deleteBranchEx(String branchNo);

    int insertBranchEx(TMdBranchEx record);

    int insertBranchExSelective(TMdBranchEx record);

    TMdBranchEx getBranchEx(String branchNo);

    int updateBranchExSelective(TMdBranchEx record);

    int updateBranchEx(TMdBranchEx record);

    int updateBranchKostl(BranchExkostlModel record);
}