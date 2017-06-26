package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TMdBranchScopeKey;

import java.util.List;

public interface TMdBranchScopeMapper {
   int deleteAreaByBranchNo(String branchNo, List<String> list);


   List<TMdBranchScopeKey> getBranchScopeByBranchNo(String branchNo);

   int addBranchScope(TMdBranchScopeKey scopeKey);

   int deleteAllAreaByBranchNo(String branchNo);
}