package com.nhry.model.milktrans;

import com.nhry.model.basic.MatnrAndQtyModel;

import java.util.List;

/**
 * Created by gongjk on 2016/7/21.
 */
public class CreateInSalOrderModel {
    private String empNo;
    private List<MatnrAndQtyModel> matnrs;
    private String salesOrg;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public List<MatnrAndQtyModel> getMatnrs() {
        return matnrs;
    }

    public void setMatnrs(List<MatnrAndQtyModel> matnrs) {
        this.matnrs = matnrs;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }
}
