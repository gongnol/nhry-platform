package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.data.basic.domain.TMdBranchSendMode;
import com.nhry.model.basic.BranchExkostlModel;
import com.nhry.model.basic.BranchOrDealerList;
import com.nhry.model.basic.BranchQueryModel;

import java.util.List;

public interface BranchService {
	int deleteBranchByNo(String branchNo);

    int addBranch(TMdBranch record);

    TMdBranch selectBranchByNo(String branchNo);

    int updateBranch(TMdBranch record);

    int uptValidBranch(TMdBranch record);

    int uptTargetBranch(TMdBranch tMdBranch);
    
    public List<TMdBranch> findBranchListByOrg();


    public PageInfo findBranchListByPage(BranchQueryModel branchModel);

   public BranchOrDealerList findResultByType(String type);

    List<TMdBranch> getBranchByCodeOrName(String branch);
    
    
    /**
     * 根据经销商编号、当前销售组织查询对应的奶站
     * @param dealerNo
     * @return
     */
    List<TMdBranch> findBranchByDno(String dealerNo);
    
    /**
     * 根据销售组织、经销商编号查询对应的奶站
     * @param dealerNo
     * @return
     */
    List<TMdBranch> findBranchBySalesOrgDno(String salesOrg,String dealerNo);

    TMdBranch getCustBranchInfo();

    int updateBranchKostl(BranchExkostlModel record);

    TMdBranchEx getBranchEx(String branchNo);

    boolean isSendMode(String branchNo);

    List<TMdBranchSendMode> findBranchSendMode();

    int insertSendModes(List<String> sendModes);

    int uptBankBranch(TMdBranch tMdBranch);

}
