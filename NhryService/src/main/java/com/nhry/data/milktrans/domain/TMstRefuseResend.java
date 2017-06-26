package com.nhry.data.milktrans.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gongjk on 2016/10/18.
 *拒收复送记录表
 */
public class TMstRefuseResend implements Serializable {
    private String resendOrderNo;       //主键
    private String salesOrg;            //销售组织
    private String branchNo;            //奶站号
    private String empNo;       //送奶员编号
    private String empName;     //送奶员名称
    private String matnr;          //产品
    private String matnrTxt;        //产品名
    private String status;          //状态
    private BigDecimal qty;         //产生拒收复送数量
    private BigDecimal confirmQty;  //应用到要货计划数量
    private BigDecimal remainQty;   //剩余数量
    private BigDecimal insideQty;  //内部销售订单数量
    private Date  dispDate;         //路单产生的配送日期
    private String dispOrderNo;     //路单号
    private BigDecimal useQty;

    public BigDecimal getInsideQty() {
        return insideQty;
    }

    public void setInsideQty(BigDecimal insideQty) {
        this.insideQty = insideQty;
    }

    public BigDecimal getUseQty() {
        return useQty;
    }

    public void setUseQty(BigDecimal useQty) {
        this.useQty = useQty;
    }

    public BigDecimal getRemainQty() {
        return remainQty;
    }

    public void setRemainQty(BigDecimal remainQty) {
        this.remainQty = remainQty;
    }

    public String getResendOrderNo() {
        return resendOrderNo;
    }

    public void setResendOrderNo(String resendOrderNo) {
        this.resendOrderNo = resendOrderNo;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMatnrTxt() {
        return matnrTxt;
    }

    public void setMatnrTxt(String matnrTxt) {
        this.matnrTxt = matnrTxt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getConfirmQty() {
        return confirmQty;
    }

    public void setConfirmQty(BigDecimal confirmQty) {
        this.confirmQty = confirmQty;
    }

    public Date getDispDate() {
        return dispDate;
    }

    public void setDispDate(Date dispDate) {
        this.dispDate = dispDate;
    }

    public String getDispOrderNo() {
        return dispOrderNo;
    }

    public void setDispOrderNo(String dispOrderNo) {
        this.dispOrderNo = dispOrderNo;
    }
}
