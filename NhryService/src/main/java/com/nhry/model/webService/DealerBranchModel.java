package com.nhry.model.webService;

import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdDealer;

/**
 * Created by gongjk on 2016/8/4.
 */
public class DealerBranchModel {
    private TMdBranch branch;
    private TMdDealer dealer;

    public TMdBranch getBranch() {
        return branch;
    }

    public void setBranch(TMdBranch branch) {
        this.branch = branch;
    }

    public TMdDealer getDealer() {
        return dealer;
    }

    public void setDealer(TMdDealer dealer) {
        this.dealer = dealer;
    }
}
