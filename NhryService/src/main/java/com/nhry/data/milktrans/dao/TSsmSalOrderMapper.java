package com.nhry.data.milktrans.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milktrans.domain.TSsmSalOrder;
import com.nhry.model.milktrans.RequireOrderSearchPage;
import com.nhry.model.milktrans.SalOrderModel;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/7/16.
 */
public interface TSsmSalOrderMapper {
    int addsalOrder(TSsmSalOrder order);

    int uptVouCherNoByOrderNo(Map map);

    List<TSsmSalOrder> selectSalOrderByDateAndNo(SalOrderModel model);

    List<TSsmSalOrder> selectSalOrderByDateAndBranchNo(SalOrderModel sModel);

    List<TSsmSalOrder> selectSalOrderByRequiredDateAndNo(SalOrderModel model);

    int delSalOrderByOrderNo(String orderNo);

    List<TSsmSalOrder> findGidOrderByNotWBSTK();

    int updateWBSTK(String orderNo);

    PageInfo searchSalOrderByDealer(RequireOrderSearchPage rModel);
}
