package com.nhry.data.milktrans.dao;

import com.nhry.data.milktrans.domain.TssmMilkmanAmts;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.statistics.OutMilkModel;

import java.util.Date;
import java.util.List;

public interface TssmMilkmanAmtsMapper {
    int insertAmts(TssmMilkmanAmts record);
    TssmMilkmanAmts selectAmtsMaxDay(OutMilkModel record);
    TssmMilkmanAmts selectAmtsMinDay(OutMilkModel record);
    TssmMilkmanAmts selectAmtsByDay(OutMilkModel record);
    List<TssmMilkmanAmts> selectAmtsByPrimaryKey(ExtendBranchInfoModel record);
    int deleteAmtsKeyDay(String branchNo,String empNo,Date date);
    int updateAmtsByPrimaryKeySelective(TssmMilkmanAmts record);
    TssmMilkmanAmts selectAmtsOneDay(OutMilkModel record);
}