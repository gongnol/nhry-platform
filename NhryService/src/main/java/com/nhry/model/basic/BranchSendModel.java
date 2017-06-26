package com.nhry.model.basic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gongjk on 2016/7/6.
 */
public class BranchSendModel implements Serializable {
    private List<String> branchNos ;

    public List<String> getBranchNos() {
        return branchNos;
    }

    public void setBranchNos(List<String> branchNos) {
        this.branchNos = branchNos;
    }
}
