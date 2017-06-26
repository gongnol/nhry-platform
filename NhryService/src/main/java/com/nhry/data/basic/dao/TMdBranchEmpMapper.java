package com.nhry.data.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.model.basic.BranchEmpSearchModel;
import com.nhry.model.basic.EmpQueryModel;
import com.nhry.model.bill.EmpSalQueryModel;
import com.nhry.service.basic.pojo.BranchEmpModel;

import java.util.List;

public interface TMdBranchEmpMapper {
    int deleteBranchEmp(TMdBranchEmp record);

    int addBranchEmp(TMdBranchEmp record);

    TMdBranchEmp selectBranchEmpByNo(String empNo);
    
    /**
     * 查询有效的员工
     * @param empNo
     * @return
     */
    TMdBranchEmp selectActiveBranchEmpByNo(String empNo);

    BranchEmpModel empDetailInfo(String empNo);

    int uptBranchEmpByNo(TMdBranchEmp record);
    
    public PageInfo searchBranchEmp(EmpQueryModel smodel);

    List<TMdBranchEmp> queryBranchEmp(EmpQueryModel smodel);

    TMdBranchEmp selectBranchEmpByEmpNo(String empNo);

    List<TMdBranchEmp> getAllEmpBySalesOrg(String salesOrg);

    List<TMdBranchEmp> getAllEmpMilkManByBranchNo(String branchNo,String salesOrg);

    List<TMdBranchEmp> getAllBranchEmpByNo(BranchEmpSearchModel bModel);

    /**
     * 为了结算奶站下 送奶员 工资 （包含本月内该奶站还在职的送奶员 和 本月内才离职的送奶员）
     * @param smodel
     *    String branchNo; 奶站编号
     *    String salesOrg; 销售组织
     *    Date startDate;  月份开始
     *    Date endDate;    月份结束
     * @return
     */
    List<TMdBranchEmp> getAllRationalMilkManByBranchNo(EmpSalQueryModel smodel);
    
    int uptBranchEmpByBraNo(TMdBranchEmp record);

    int isEmp(TMdBranchEmp record);

    List<TSsmSalOrder> selectSalOrderByOnlineCode(String sapCode);

    int updateSapCode(TSsmSalOrder ssmSalOrder);
}