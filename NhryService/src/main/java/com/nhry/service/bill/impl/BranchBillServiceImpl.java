package com.nhry.service.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.bill.dao.BranchBillMapper;
import com.nhry.model.bill.CustBranchBillSearch;
import com.nhry.model.bill.EmpBranchBillDetailSearch;
import com.nhry.model.bill.EmpBranchBillSearch;
import com.nhry.service.bill.dao.BranchBillService;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by gongjk on 2016/6/27.
 */
public class BranchBillServiceImpl implements BranchBillService {
    private BranchBillMapper branchBillMapper;
    private UserSessionService userSessionService;
    private TSysUserRoleMapper tSysUserRoleMapper;

    public void setBranchBillMapper(BranchBillMapper branchBillMapper) {
        this.branchBillMapper = branchBillMapper;
    }

    public void settSysUserRoleMapper(TSysUserRoleMapper tSysUserRoleMapper) {
        this.tSysUserRoleMapper = tSysUserRoleMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }


    @Override
    public PageInfo EmpBranchBill(EmpBranchBillSearch eSearch) {
        TSysUser user = userSessionService.getCurrentUser();
        //List<String> rids = tSysUserRoleMapper.getUserRidsByLoginName(user.getLoginName());
        if(StringUtils.isNotBlank(user.getBranchNo())){
            eSearch.setBranchNo(user.getBranchNo());
        }
        if(StringUtils.isNoneBlank(user.getDealerId())){
            eSearch.setDealerNo(user.getDealerId());
        }
        if(StringUtils.isNoneBlank(user.getSalesOrg())){
            eSearch.setSalesOrg(user.getSalesOrg());
        }
        PageInfo data = branchBillMapper.branchBillEmpSearch(eSearch);
        return data;
    }

    @Override
    public PageInfo getEmpBranchBillDetail(EmpBranchBillDetailSearch bsearch) {
        TSysUser user = userSessionService.getCurrentUser();
        bsearch.setSalesOrg(user.getSalesOrg());
      /*  List<String> rids = tSysUserRoleMapper.getUserRidsByLoginName(user.getLoginName());
        if(rids.contains("10004")){
            bsearch.setBranchNo(user.getBranchNo());
        }*/

        if(StringUtils.isNotBlank(user.getBranchNo())){
            bsearch.setBranchNo(user.getBranchNo());
        }
        if(StringUtils.isNoneBlank(user.getDealerId())){
            bsearch.setDealerNo(user.getDealerId());
        }
        if(StringUtils.isNoneBlank(user.getSalesOrg())){
            bsearch.setSalesOrg(user.getSalesOrg());
        }
        return branchBillMapper.branchBillEmpItemSearch(bsearch);
    }

    @Override
    public PageInfo CustomerBranchBill(CustBranchBillSearch bsearch) {
        TSysUser user = userSessionService.getCurrentUser();
       /* List<String> rids = tSysUserRoleMapper.getUserRidsByLoginName(user.getLoginName());
        if(rids.contains("10004")){
            bsearch.setBranchNo(user.getBranchNo());
        }*/
        if(StringUtils.isNotBlank(user.getBranchNo())){
            bsearch.setBranchNo(user.getBranchNo());
        }
        if(StringUtils.isNoneBlank(user.getDealerId())){
            bsearch.setDealerNo(user.getDealerId());
        }
        if(StringUtils.isNoneBlank(user.getSalesOrg())){
            bsearch.setSalesOrg(user.getSalesOrg());
        }
        return branchBillMapper.CustomerBranchBill(bsearch);
    }
}
