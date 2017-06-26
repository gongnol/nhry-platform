package com.nhry.model.milktrans;

import com.nhry.model.basic.MatnrAndQtyModel;

import java.util.List;

/**
 * Created by huaguan on 2016/10/27.
 */
public class CreateInsalOrderByRefuseModel {
    private String empNo;
    private List<MatnrAndQtyModel> matnrs;

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

}
