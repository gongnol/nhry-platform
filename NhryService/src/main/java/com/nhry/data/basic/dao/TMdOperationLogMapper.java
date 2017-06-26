package com.nhry.data.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdOperationLog;
import com.nhry.model.basic.CustOperationQueryModel;

/**
 * Created by gongjk on 2016/10/24.
 */
public interface TMdOperationLogMapper {
  public  int save(TMdOperationLog log);

  PageInfo getCustOperationLog(CustOperationQueryModel cModel);

  PageInfo getOrderOperationLog(CustOperationQueryModel cModel);

  PageInfo getPlanOperationLog(CustOperationQueryModel cModel);

  PageInfo getRouteOperationLog(CustOperationQueryModel cModel);
}
