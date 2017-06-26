package com.nhry.model.basic;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdDealer;

import java.util.List;

/**
 * Created by gongjk on 2016/7/6.
 */
public class BranchOrDealerList {
    private List<TMdBranch> branchList ;
    private List<TMdDealer> dealerList;

    public List<TMdBranch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<TMdBranch> branchList) {
        this.branchList = branchList;
    }

    public List<TMdDealer> getDealerList() {
        return dealerList;
    }

    public void setDealerList(List<TMdDealer> dealerList) {
        this.dealerList = dealerList;
    }
}
