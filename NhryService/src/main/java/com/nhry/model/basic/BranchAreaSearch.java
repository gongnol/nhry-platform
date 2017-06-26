package com.nhry.model.basic;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/6/27.
 */
public class BranchAreaSearch extends BaseQueryModel implements Serializable{
    private String branchNo;

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
