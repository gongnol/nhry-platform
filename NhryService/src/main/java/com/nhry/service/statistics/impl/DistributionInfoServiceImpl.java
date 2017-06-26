package com.nhry.service.statistics.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.statistics.dao.DistributionInfoMapper;
import com.nhry.model.statistics.DistInfoModel;
import com.nhry.service.statistics.dao.DistributionInfoService;
import org.apache.commons.lang.StringUtils;

/**
 * Created by cbz on 7/16/2016.
 */
public class DistributionInfoServiceImpl implements DistributionInfoService{
    private DistributionInfoMapper distributionInfoMapper;
    private UserSessionService userSessionService;

    public void setDistributionInfoMapper(DistributionInfoMapper distributionInfoMapper) {
        this.distributionInfoMapper = distributionInfoMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @Override
    public PageInfo findDistDifferInfo(DistInfoModel model) {
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return distributionInfoMapper.findDistDifferInfo(model);
    }
}
