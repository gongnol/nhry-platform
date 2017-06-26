package com.nhry.data.milktrans.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TssmMilkmanAmtsMapper;
import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInitKey;
import com.nhry.data.milktrans.domain.TssmMilkmanAmts;
import com.nhry.data.milktrans.domain.TssmMilkmanAmtsKey;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.statistics.OutMilkModel;

import java.util.Date;
import java.util.List;

/**
 * Created by huaguan on 2016/12/23.
 */
public class TssmMilkmanAmtsMapperImpl implements TssmMilkmanAmtsMapper{
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertAmts(TssmMilkmanAmts record) {
        return sqlSessionTemplate.insert("insertAmts",record);
    }

    /**
     * 奶站送奶员确认最大一天数据值
     * @param record
     * @return
     */
    @Override
    public TssmMilkmanAmts selectAmtsMaxDay(OutMilkModel record) {
        return sqlSessionTemplate.selectOne("selectAmtsMaxDay",record);
    }

    /**
     * 奶站送奶员确认最小一天数据值
     * @param record
     * @return
     */
    @Override
    public TssmMilkmanAmts selectAmtsMinDay(OutMilkModel record) {
        return sqlSessionTemplate.selectOne("selectAmtsMinDay",record);
    }

    /**
     * 获取指定时间、指定送奶员的出奶表统计数据
     * @param record
     * @return
     */
    @Override
    public TssmMilkmanAmts selectAmtsByDay(OutMilkModel record) {
        return sqlSessionTemplate.selectOne("selectAmtsByDay",record);
    }

    /**
     * 删除指定日期后的送奶统计表
     * @param branchNo
     * @param empNo
     * @param date
     * @return
     */
    @Override
    public int deleteAmtsKeyDay(String branchNo, String empNo, Date date) {
        TssmMilkmanAmtsKey record = new TssmMilkmanAmtsKey();
        record.setBranchNo(branchNo);
        record.setEmpNo(empNo);
        record.setOrderDate(date);
        return sqlSessionTemplate.delete("deleteAmtsKeyDay",record);
    }

    /**
     * 联合主键查询
     * @param record
     * @return
     */
    @Override
    public List<TssmMilkmanAmts> selectAmtsByPrimaryKey(ExtendBranchInfoModel record) {
        return sqlSessionTemplate.selectList("selectAmtsByPrimaryKey",record);
    }

    /**
     * 修改初始金额同时更新初始第一天数据
     * @param record
     * @return
     */
    @Override
    public int updateAmtsByPrimaryKeySelective(TssmMilkmanAmts record) {
        return sqlSessionTemplate.update("updateAmtsByPrimaryKeySelective",record);
    }

    /**
     * 查询初始第一天金额
     * @param record
     * @return
     */
    @Override
    public TssmMilkmanAmts selectAmtsOneDay(OutMilkModel record) {
        return sqlSessionTemplate.selectOne("selectAmtsOneDay",record);
    }
}
