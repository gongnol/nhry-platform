package com.nhry.model.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cbz on 7/16/2016.
 */
public class DistInfoModel {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date beginDate;
    Date endDate;
    String pageNum;
    String pageSize;
    String branchNo;
    String dealerId;
    String salesOrg;
    Date theDate;


    public Date getBeginDate() {
        try {
            if(beginDate != null)
            return format.parse(format.format(beginDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        try {
            if(endDate != null)
            return format.parse(format.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public Date getTheDate() {
        try {
            if(theDate != null)
                return format.parse(format.format(theDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }
}
