package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TaskYearMonthPlan;
import com.nhry.data.basic.domain.TaskYearMonthPlanKey;
import com.nhry.model.basic.MonthPlanModel;

import java.util.List;

public interface TaskYearMonthPlanMapper {
    int deletePlan(TaskYearMonthPlanKey key);

    int insertPlan(TaskYearMonthPlan record);

    TaskYearMonthPlan selectPlan(TaskYearMonthPlanKey key);

    int updatePlanSelective(TaskYearMonthPlan record);

    int updatePlan(TaskYearMonthPlan record);

    List<TaskYearMonthPlan> findPlanByYear(MonthPlanModel model);
}