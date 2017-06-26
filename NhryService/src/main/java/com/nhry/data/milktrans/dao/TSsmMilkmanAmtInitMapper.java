package com.nhry.data.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInit;
import com.nhry.model.statistics.OutMilkModel;

import java.util.List;

public interface TSsmMilkmanAmtInitMapper {
    /**
     * 插入出奶表初始值
     * @param record
     * @return
     */
    int insertAmtInit(TSsmMilkmanAmtInit record);
    List<TSsmMilkmanAmtInit> selectAllAmtInit();
    List<TSsmMilkmanAmtInit> selectAmtInitByBranchNo(OutMilkModel record);
    List<TSsmMilkmanAmtInit> selectAmtInitList(OutMilkModel record);
    int updateAmtInitByPrimaryKeySelective(OutMilkModel record);
}