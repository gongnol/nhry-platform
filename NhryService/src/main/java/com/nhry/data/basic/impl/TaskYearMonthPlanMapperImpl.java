package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TaskYearMonthPlanMapper;
import com.nhry.data.basic.domain.TaskYearMonthPlan;
import com.nhry.data.basic.domain.TaskYearMonthPlanKey;
import com.nhry.model.basic.MonthPlanModel;

import java.util.List;

/**
 * Created by cbz on 8/12/2016.
 */
public class TaskYearMonthPlanMapperImpl implements TaskYearMonthPlanMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deletePlan(TaskYearMonthPlanKey key) {
        return sqlSessionTemplate.delete("deletePlan",key);
    }

    @Override
    public int insertPlan(TaskYearMonthPlan record) {
        return sqlSessionTemplate.insert("insertPlan",record);
    }

    @Override
    public TaskYearMonthPlan selectPlan(TaskYearMonthPlanKey key) {
        return sqlSessionTemplate.selectOne("selectPlan",key);
    }

    @Override
    public int updatePlanSelective(TaskYearMonthPlan record) {
        return sqlSessionTemplate.update("updatePlanSelective",record);
    }

    @Override
    public int updatePlan(TaskYearMonthPlan record) {
        return sqlSessionTemplate.update("updatePlan",record);
    }

    @Override
    public List<TaskYearMonthPlan> findPlanByYear(MonthPlanModel model) {
        return sqlSessionTemplate.selectList("findPlanByYear",model);
    }
}
