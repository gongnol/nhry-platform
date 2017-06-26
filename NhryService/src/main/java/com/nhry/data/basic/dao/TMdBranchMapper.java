package com.nhry.data.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchSendMode;
import com.nhry.model.basic.BranchQueryModel;
import com.nhry.model.basic.BranchSalesOrgModel;

import java.util.List;
import java.util.Map;

public interface TMdBranchMapper {
    int setBranchRemark(TMdBranch tMdBranch);

    int deleteBranchByNo(String branchNo);

    int addBranch(TMdBranch record);

    TMdBranch selectBranchByNo(String branchNo);

    public List<TMdBranch> findBranchListByOrg(BranchSalesOrgModel bmodel);


    public PageInfo findBranchListByPage(BranchQueryModel branchModel);

    int updateBranch(TMdBranch tMdBranch);

    int uptValidBranch(TMdBranch tMdBranch);

    int uptTargetBranch(TMdBranch tMdBranch);

    List<TMdBranch> getBranchByCodeOrName(Map<String, String> map);

    List<TMdBranch> findBranchListByOrgAndAuto(String salesOrg);
    
    /**
     * 根据经销商编号、当前销售组织查询对应的奶站
     * @param attrs
     * @return
     */
    List<TMdBranch> findBranchByDno(Map<String,String> attrs);

    TMdBranch getBranchByNo(String branchNo);

    TMdBranch selectBranchInfoByBranchNo(String branchNo);

    TMdBranchSendMode getSendMode(String branchNo);

    List<TMdBranchSendMode> selectBranchSendMode(String salesOrg);

    int insertSendMode(TMdBranchSendMode sendMode);

    int delSendMode(String salesOrg);

    int uptBankBranch(TMdBranch record);

	List<TMdBranch> getBranchsByPromNo(String promNO);
}