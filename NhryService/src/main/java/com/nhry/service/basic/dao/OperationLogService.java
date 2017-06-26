package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.basic.CustOperationQueryModel;

/**
 * Created by gongjk on 2016/10/24.
 */
public interface OperationLogService {
    PageInfo getCustOperationLog( CustOperationQueryModel cModel);
    PageInfo getOrderOperationLog( CustOperationQueryModel cModel);
    PageInfo getPlanOperationLog( CustOperationQueryModel cModel);
    PageInfo getRouteOperationLog( CustOperationQueryModel cModel);
}
