package com.nhry.model.statistics;

import com.nhry.model.basic.BaseQueryModel;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LIUYIN on 4/20/2017.
 */
public class Cash_account_Model extends BaseQueryModel implements Serializable {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String branchNo;//客户编号
    String branchName;//客户名称
    String salesOrg;//奶站所属分公司
    String reachTimeType;//日期
    String cash_num;//账户余额








    public String getReachTimeType() {
		return reachTimeType;
	}

	public void setReachTimeType(String reachTimeType) {
		this.reachTimeType = reachTimeType;
	}

	 

	 
	public String getCash_num() {
		return cash_num;
	}

	public void setCash_num(String cash_num) {
		this.cash_num = cash_num;
	}

	public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
 
    public static SimpleDateFormat getFormat() {
        return format;
    }

     
    Date theDate = new Date();
    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
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
