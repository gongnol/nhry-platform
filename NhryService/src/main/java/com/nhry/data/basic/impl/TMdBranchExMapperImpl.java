package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdBranchExMapper;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.model.basic.BranchExkostlModel;

/**
 * Created by cbz on 7/5/2016.
 */
public class TMdBranchExMapperImpl implements TMdBranchExMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteBranchEx(String branchNo) {
        return sqlSessionTemplate.delete("deleteBranchEx",branchNo);
    }

    @Override
    public int insertBranchEx(TMdBranchEx record) {
        return sqlSessionTemplate.insert("insertBranchEx",record);
    }

    @Override
    public int insertBranchExSelective(TMdBranchEx record) {
        return sqlSessionTemplate.insert("insertBranchExSelective",record);
    }

    @Override
    public TMdBranchEx getBranchEx(String branchNo) {
        return sqlSessionTemplate.selectOne("getBranchEx",branchNo);
    }

    @Override
    public int updateBranchExSelective(TMdBranchEx record) {
        return sqlSessionTemplate.update("updateBranchExSelective",record);
    }

    @Override
    public int updateBranchEx(TMdBranchEx record) {
        return sqlSessionTemplate.update("updateBranchEx",record);
    }

    @Override
    public int updateBranchKostl(BranchExkostlModel record) {
        return sqlSessionTemplate.update("updateBranchKostl",record);
    }
}
