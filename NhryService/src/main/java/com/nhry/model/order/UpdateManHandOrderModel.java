package com.nhry.model.order;

import com.wordnik.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/21.
 */
@ApiModel(value = "UpdateManHandOrderModel", description = "更新人工分单中的所属奶站对象")
public class UpdateManHandOrderModel implements Serializable {

    private String orderNo;      //订单号
    private String branchNo;     //奶站号
    private String isValid;      //是否分配的是上线奶站
    private String dealerNo;     //经销商号
    private String salesOrg;      //销售组织
    private String retReason;     //保存原订单的订户编号
    private String milkmemberNo;  //分配奶站后保存的订户编号
    private String empNo;         //选择送奶员
    private String memoTxt;       //退回备注
    private Date retDate;        //退回日期
    private String preorderStat;

    public String getPreorderStat() {
        return preorderStat;
    }

    public void setPreorderStat(String preorderStat) {
        this.preorderStat = preorderStat;
    }

    public String getMemoTxt() {
        return memoTxt;
    }

    public void setMemoTxt(String memoTxt) {
        this.memoTxt = memoTxt;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getMilkmemberNo() {
        return milkmemberNo;
    }

    public void setMilkmemberNo(String milkmemberNo) {
        this.milkmemberNo = milkmemberNo;
    }

    public String getSalesOrg()
	{
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg)
	{
		this.salesOrg = salesOrg;
	}

    public String getRetReason() {
        return retReason;
    }

    public void setRetReason(String retReason) {
        this.retReason = retReason;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}