package com.nhry.service.pi.pojo;

import com.nhry.data.order.domain.TPreOrder;

/**
 * Created by cbz on 7/26/2016.
 */
public class PIOrder extends TPreOrder {
    String branchEmpNo;
    String branchMp;
    String branchEmpName;
    String addressTxt;

    public String getBranchEmpNo() {
        return branchEmpNo;
    }

    public void setBranchEmpNo(String branchEmpNo) {
        this.branchEmpNo = branchEmpNo;
    }

    public String getBranchMp() {
        return branchMp;
    }

    public void setBranchMp(String branchMp) {
        this.branchMp = branchMp;
    }

    public String getBranchEmpName() {
        return branchEmpName;
    }

    public void setBranchEmpName(String branchEmpName) {
        this.branchEmpName = branchEmpName;
    }

    public String getAddressTxt() {
        return addressTxt;
    }

    public void setAddressTxt(String addressTxt) {
        this.addressTxt = addressTxt;
    }
}
