package com.nhry.model.basic;

import java.util.List;

/**
 * Created by gongjk on 2016/7/4.
 */
public class RelBranchModel {
    private String branchNo;
    List<String>  areaIds;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public List<String> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(List<String> areaIds) {
        this.areaIds = areaIds;
    }
}
