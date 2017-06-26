package com.nhry.service.basic.impl;

import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TaskYearMonthPlanMapper;
import com.nhry.data.basic.domain.TaskYearMonthPlan;
import com.nhry.data.basic.domain.TaskYearMonthPlanKey;
import com.nhry.model.basic.MonthPlanModel;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.TaskYearMonthPlanService;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by cbz on 8/12/2016.
 */
public class TaskYearMonthPlanServiceImpl extends BaseService implements TaskYearMonthPlanService {

    private TaskYearMonthPlanMapper taskYearMonthPlanMapper;

    public void setTaskYearMonthPlanMapper(TaskYearMonthPlanMapper taskYearMonthPlanMapper) {
        this.taskYearMonthPlanMapper = taskYearMonthPlanMapper;
    }

    @Override
    public TaskYearMonthPlan selectPlan(TaskYearMonthPlanKey key) {
        return taskYearMonthPlanMapper.selectPlan(key);
    }

    @Override
    public List<TaskYearMonthPlan> findPlanByYear(MonthPlanModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getTaskYear())){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int year = calendar.get(Calendar.YEAR);
            model.setTaskYear(String.valueOf(year));
        }
        if(StringUtils.isEmpty(model.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return taskYearMonthPlanMapper.findPlanByYear(model);
    }

    @Override
    public int savePlan(TaskYearMonthPlan record) {
        TSysUser user = userSessionService.getCurrentUser();
        TaskYearMonthPlanKey key = new TaskYearMonthPlanKey();
        key.setBranckNo(record.getBranckNo());
        key.setTaskYear(record.getTaskYear());
        TaskYearMonthPlan plan = this.selectPlan(key);
        int i = 0;
        if(plan == null){
            record.setCreaterAt(new Date());
            record.setCreaterBy(user.getLoginName());
            i=taskYearMonthPlanMapper.insertPlan(record);
        }else{
            plan.setTaskJan(record.getTaskJan());
            plan.setTaskFeb(record.getTaskFeb());
            plan.setTaskMar(record.getTaskMar());
            plan.setTaskApr(record.getTaskApr());
            plan.setTaskMay(record.getTaskMay());
            plan.setTaskJun(record.getTaskJun());
            plan.setTaskJul(record.getTaskJul());
            plan.setTaskAug(record.getTaskAug());
            plan.setTaskSep(record.getTaskSep());
            plan.setTaskOct(record.getTaskOct());
            plan.setTaskDev(record.getTaskDev());
            plan.setTaskNov(record.getTaskNov());
            plan.setUpdateAt(new Date());
            plan.setUpdateBy(user.getLoginName());
            plan.setTaskYearPlan(record.getTaskYearPlan());
            i=taskYearMonthPlanMapper.updatePlan(plan);
        }
        return i;
    }

    @Override
    public int savePlans(List<TaskYearMonthPlan> plans) {
        int i = 0;
        if(plans != null){
            for(TaskYearMonthPlan plan : plans){
                i = savePlan(plan);
            }
        }
        return i;
    }
}
