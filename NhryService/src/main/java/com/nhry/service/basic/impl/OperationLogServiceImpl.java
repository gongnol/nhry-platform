package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdOperationLogMapper;
import com.nhry.model.basic.CustOperationQueryModel;
import com.nhry.service.basic.dao.OperationLogService;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by gongjk on 2016/10/24.
 */
public class OperationLogServiceImpl implements OperationLogService {
    private TMdOperationLogMapper operationLogMapper;
    private UserSessionService userSessionService;

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setOperationLogMapper(TMdOperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    @Override
    public PageInfo getCustOperationLog( CustOperationQueryModel cModel) {
        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isNoneBlank(user.getBranchNo())){
            cModel.setBranchNo(user.getBranchNo());
        }
        return operationLogMapper.getCustOperationLog(cModel);
    }

    @Override
    public PageInfo getOrderOperationLog( CustOperationQueryModel cModel) {
        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isNoneBlank(user.getBranchNo())){
            cModel.setBranchNo(user.getBranchNo());
        }

        return operationLogMapper.getOrderOperationLog(cModel);
    }

    @Override
    public PageInfo getPlanOperationLog( CustOperationQueryModel cModel) {
        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isNoneBlank(user.getBranchNo())){
            cModel.setBranchNo(user.getBranchNo());
        }
        return operationLogMapper.getPlanOperationLog(cModel);
    }

    @Override
    public PageInfo getRouteOperationLog( CustOperationQueryModel cModel) {
        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isNoneBlank(user.getBranchNo())){
            cModel.setBranchNo(user.getBranchNo());
        }

        return operationLogMapper.getRouteOperationLog(cModel);
    }
}
