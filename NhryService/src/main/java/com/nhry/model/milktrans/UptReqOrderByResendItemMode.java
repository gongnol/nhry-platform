package com.nhry.model.milktrans;

import com.nhry.data.milktrans.domain.TMstRefuseResend;
import java.util.List;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by gongjk on 2016/10/19.
 */
public class UptReqOrderByResendItemMode {
    private List<TMstRefuseResend> entries = new ArrayList<TMstRefuseResend>();
    private String matnr;
    private String reqOrderNo;
    private BigDecimal qty;

    public List<TMstRefuseResend> getEntries() {
        return entries;
    }

    public void setEntries(List<TMstRefuseResend> entries) {
        this.entries = entries;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getReqOrderNo() {
        return reqOrderNo;
    }

    public void setReqOrderNo(String reqOrderNo) {
        this.reqOrderNo = reqOrderNo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
