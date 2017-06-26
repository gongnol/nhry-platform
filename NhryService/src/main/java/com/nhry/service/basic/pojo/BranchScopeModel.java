package com.nhry.service.basic.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gongjk on 2016/6/7.
 */
public class BranchScopeModel  implements Serializable {

    private String branchNo;
    private List<String> residentialAreaIds;


    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public List<String> getResidentialAreaIds() {
        return residentialAreaIds;
    }

    public void setResidentialAreaIds(List<String> residentialAreaIds) {
        this.residentialAreaIds = residentialAreaIds;
    }
}
