package com.nhry.service.webService.dao;

import com.nhry.model.webService.CustInfoModel;
import com.nhry.model.webService.DealerBranchModel;

/**
 * Created by gongjk on 2016/7/27.
 */
public interface GetOrderBranchService {
    public DealerBranchModel getOrderBranch(CustInfoModel custInfoModel);
}
