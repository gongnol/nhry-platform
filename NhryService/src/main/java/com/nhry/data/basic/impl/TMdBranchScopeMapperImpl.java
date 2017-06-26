package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdBranchScopeMapper;
import com.nhry.data.basic.domain.TMdBranchScopeKey;
import com.nhry.service.basic.pojo.BranchScopeModel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by gongjk on 2016/6/7.
 */
public class TMdBranchScopeMapperImpl implements TMdBranchScopeMapper{

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    @Override
        public int deleteAreaByBranchNo(String branchNo,List<String> residentialAreaIds) {
            BranchScopeModel branchScopeModel = new BranchScopeModel();
            if(StringUtils.isNotBlank(branchNo) && residentialAreaIds.size()>0){
                branchScopeModel.setResidentialAreaIds(residentialAreaIds);
                branchScopeModel.setBranchNo(branchNo);
            }
            return sqlSessionTemplate.delete("deleteByBranchNo",branchScopeModel);
        }

    @Override
    public List<TMdBranchScopeKey> getBranchScopeByBranchNo(String branchNo) {
        return sqlSessionTemplate.selectList("getBranchScopeByBranchNo",branchNo);
    }

    @Override
    public int addBranchScope(TMdBranchScopeKey scopeKey) {
        return sqlSessionTemplate.insert("addBranchScope",scopeKey);
    }

    @Override
    public int deleteAllAreaByBranchNo(String branchNo) {
        return sqlSessionTemplate.delete("deleteAllAreaByBranchNo",branchNo);
    }


    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
