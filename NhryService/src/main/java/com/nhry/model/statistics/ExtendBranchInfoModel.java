package com.nhry.model.statistics;


import java.util.Date;

/**
 * Created by huaguan on 2016/8/4.
 */
public class ExtendBranchInfoModel extends BranchInfoModel {
    String empNo;
    Date dateStart;
    Date dateEnd;
    String monthDate;


    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date orderDateStart) {
        this.dateStart = orderDateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date orderDateEnd) {
        this.dateEnd = orderDateEnd;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }
}
