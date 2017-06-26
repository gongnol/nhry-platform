package com.nhry.service.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInit;
import com.nhry.data.milktrans.domain.TssmMilkmanAmts;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.statistics.OutMilkModel;

import java.util.Date;
import java.util.List;

/**
 * Created by huaguan on 2016/12/23.
 */
public interface OutMilkService {
    int insertAmtInit(OutMilkModel record);
    int createAmtsdayByday();
    int createAmtsByBranch(OutMilkModel record);
    List<TssmMilkmanAmts> selectAmtsByPrimaryKey(ExtendBranchInfoModel record);
    List<TSsmMilkmanAmtInit> selectAmtInitList();
    int updateAmtInitByPrimaryKeySelective(OutMilkModel record);
}
