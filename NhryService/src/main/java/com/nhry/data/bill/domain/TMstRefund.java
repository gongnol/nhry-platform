package com.nhry.data.bill.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/8/29.
 * 退款表
 */
public class TMstRefund {
    private  String refundNo;       //退款单号
    private BigDecimal amt;          //退款金额
    private String remark;          //备注
    private String vipCustNo;       //订户号
    private String branchNo;        //奶站号
    private String dealerNo;        //经销商号
    private String salesOrg;        //销售组织
    private String vipName;         //订户名
    private String createBy;
    private Date createAt;
    private String createByTxt;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
    }
}
