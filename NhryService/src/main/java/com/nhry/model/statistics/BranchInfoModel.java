package com.nhry.model.statistics;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cbz on 7/16/2016.
 */
public class BranchInfoModel extends BaseQueryModel implements Serializable {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String branchNo;
    String dealerId;
    String salesOrg;
    String reachTimeType;

    String branchName;

    public static SimpleDateFormat getFormat() {
        return format;
    }

    public String getReachTimeType() {
        return reachTimeType;
    }

    public void setReachTimeType(String reachTimeType) {
        this.reachTimeType = reachTimeType;
    }

    Date theDate = new Date();
    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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
