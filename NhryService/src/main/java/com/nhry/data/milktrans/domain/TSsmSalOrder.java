package com.nhry.data.milktrans.domain;

import java.util.Date;

/**
 * Created by gongjk on 2016/7/16.
 * 销售订单
 */
public class TSsmSalOrder {
    private String orderNo;              //销售订单号
    private Date   orderDate;            //日期
    private String branchNo;            // 奶站号
    private String branchName;          //奶站名
    private String dealerName;          //经销商名
    private Date   requiredDate;        //要货日期
    private String voucherNo;           //凭证号
    private String status;              //状态
    private String memoTxt;
    private String salesOrg;            //销售组织
    private String dealerNo;            //经销商号
    private String branchGroup;         //奶站性质  01-自营 02-外包
    private String promNo;              //促销号
    private String freeFlag;            //免费标识
    private Date createAt;
    private  String createBy;
    private String createByTxt;
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;
    private String preorderSource;      //订单来源
    private String onlineCode;

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPromNo() {
        return promNo;
    }

    public void setPromNo(String promNo) {
        this.promNo = promNo;
    }

    public String getFreeFlag() {
        return freeFlag;
    }

    public void setFreeFlag(String freeFlag) {
        this.freeFlag = freeFlag;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemoTxt() {
        return memoTxt;
    }

    public void setMemoTxt(String memoTxt) {
        this.memoTxt = memoTxt;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getBranchGroup() {
        return branchGroup;
    }

    public void setBranchGroup(String branchGroup) {
        this.branchGroup = branchGroup;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByTxt() {
        return createByTxt;
    }

    public void setCreateByTxt(String createByTxt) {
        this.createByTxt = createByTxt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedByTxt() {
        return lastModifiedByTxt;
    }

    public void setLastModifiedByTxt(String lastModifiedByTxt) {
        this.lastModifiedByTxt = lastModifiedByTxt;
    }

    public String getPreorderSource() {
        return preorderSource;
    }

    public void setPreorderSource(String preorderSource) {
        this.preorderSource = preorderSource;
    }

    public String getOnlineCode() {
        return onlineCode;
    }

    public void setOnlineCode(String onlineCode) {
        this.onlineCode = onlineCode;
    }
}
