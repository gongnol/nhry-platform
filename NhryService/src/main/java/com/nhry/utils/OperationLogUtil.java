package com.nhry.utils;

import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdOperationLogMapper;
import com.nhry.data.basic.domain.TMdOperationLog;

import java.util.Date;

/**
 * Created by gongjk on 2016/10/24.
 */
public class OperationLogUtil  {
    public static void saveHistoryOperation(String logNo, String type,String logName,String logEmp,String dispAddress, String originalValue, String newValue,
                                            String matnr, Date dispDate, TSysUser user,TMdOperationLogMapper operationLogMapper){
        final TMdOperationLog operationLogModel = new TMdOperationLog();
        operationLogModel.setLogNo(logNo);
        operationLogModel.setLogType(type);
        operationLogModel.setLogDate(new Date());
        operationLogModel.setLogName(logName);
        operationLogModel.setLogEmp(logEmp);
        operationLogModel.setDispAddress(dispAddress);
        operationLogModel.setOriginalValue(originalValue);
        operationLogModel.setNewValue(newValue);
        if(user!=null){
            operationLogModel.setLogBranch(user.getBranchNo());
            operationLogModel.setCreateBy(user.getLoginName());
            operationLogModel.setCreateByTxt(user.getDisplayName());
        }
        operationLogModel.setCreateAt(new Date());
        operationLogModel.setLogDispDate(dispDate);
        operationLogModel.setLogMatnr(matnr);
        operationLogMapper.save(operationLogModel);
    }
}
