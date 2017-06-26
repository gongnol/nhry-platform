package com.nhry.service.basic.dao;

import com.nhry.data.basic.domain.TaskYearMonthPlan;
import com.nhry.data.basic.domain.TaskYearMonthPlanKey;
import com.nhry.model.basic.MonthPlanModel;

import java.util.List;

/**
 * Created by cbz on 8/12/2016.
 */
public interface TaskYearMonthPlanService {

    TaskYearMonthPlan selectPlan(TaskYearMonthPlanKey key);

    List<TaskYearMonthPlan> findPlanByYear(MonthPlanModel model);

    int savePlan(TaskYearMonthPlan record);

    int savePlans(List<TaskYearMonthPlan> plans);
}
