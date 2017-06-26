package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.model.basic.BranchEmpSearchModel;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.service.basic.pojo.BranchEmpModel;
import java.util.*;

public interface BranchEmpService {
	int deleteBranchEmpByNo(String empNo);

    int addBranchEmp(TMdBranchEmp record,boolean isLeave);

    TMdBranchEmp selectBranchEmpByNo(String empNo);

    int uptBranchEmpByNo(TMdBranchEmp record);
    
    public PageInfo searchBranchEmp(EmpQueryModel smodel);

    List<TMdBranchEmp> queryBranchEmp(EmpQueryModel smodel);

    BranchEmpModel empDetailInfo(String empNo);

    List<TMdBranch> getComPanyAllBranch();

    List<TMdBranchEmp> getAllEmpByBranchNo(String branchNo);

    List<TMdBranchEmp>  getAllEmpBySalesOrg();

    List<TMdBranchEmp> getAllBranchEmpByNo(BranchEmpSearchModel bModel);
}
