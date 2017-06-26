package com.nhry.data.bill.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/6/23.
 * 收款单
 */
public class TMstRecvBill implements Serializable {
    private String hadOffset;       //是否被冲销  N 未被冲销，Y 被冲销
    private String hadOffsetNo;     //如果未被冲销
    private String receiptNo;        //收款单号
    private Date receiptDate;       // 收款日期
    private String orderNo;         //订单号
    private String paymentType;      //支付类型
    private String status;          //收款状态 10 未收款，20 已收款
    private BigDecimal amt;          //记录实际收款金额
    private BigDecimal suppAmt;     //应收钱数
    private String vipCustNo;       //订户号
    private String vipCustName;     //订户名
    private String remark;          //备注
    private Date startTime;
    private Date endTime;
    private String paymentYearMonth; //支付年月
    private BigDecimal totalPrice;  //
    private BigDecimal custAccAmt; //当时订户余额
    private int totalNum;           //总数量
    private String recvEmp;          //收款人编号
    private String recvEmpName;      //收款人名称
    private BigDecimal accAmt;       //收取订户余额
    private Date createAt;
    private  String createBy;
    private String createByTxt;
    private Date lastModified;
    private String lastModifiedBy;
    private String lastModifiedByTxt;
    private BigDecimal discountAmt;     //折扣
    private String empNo;               //员工号
    private String branchNo;            //奶站号
    private BigDecimal offsetAmt;

    public String getHadOffsetNo() {
        return hadOffsetNo;
    }

    public void setHadOffsetNo(String hadOffsetNo) {
        this.hadOffsetNo = hadOffsetNo;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getSuppAmt() {
        return suppAmt;
    }

    public String getHadOffset() {
        return hadOffset;
    }

    public void setHadOffset(String hadOffset) {
        this.hadOffset = hadOffset;
    }

    public void setSuppAmt(BigDecimal suppAmt) {
        this.suppAmt = suppAmt;
    }

    public BigDecimal getCustAccAmt() {
        return custAccAmt;
    }

    public void setCustAccAmt(BigDecimal custAccAmt) {
        this.custAccAmt = custAccAmt;
    }

    public BigDecimal getAccAmt() {
        return accAmt;
    }

    public void setAccAmt(BigDecimal accAmt) {
        this.accAmt = accAmt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getVipCustName() {
        return vipCustName;
    }

    public void setVipCustName(String vipCustName) {
        this.vipCustName = vipCustName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getVipCustNo() {
        return vipCustNo;
    }

    public void setVipCustNo(String vipCustNo) {
        this.vipCustNo = vipCustNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPaymentYearMonth() {
        return paymentYearMonth;
    }

    public void setPaymentYearMonth(String paymentYearMonth) {
        this.paymentYearMonth = paymentYearMonth;
    }

    public String getRecvEmp() {
        return recvEmp;
    }

    public void setRecvEmp(String recvEmp) {
        this.recvEmp = recvEmp;
    }

    public String getRecvEmpName() {
        return recvEmpName;
    }

    public void setRecvEmpName(String recvEmpName) {
        this.recvEmpName = recvEmpName;
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

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public BigDecimal getOffsetAmt() {
        return offsetAmt;
    }

    public void setOffsetAmt(BigDecimal offsetAmt) {
        this.offsetAmt = offsetAmt;
    }
}
