package com.nhry.data.bill.dao;

import com.nhry.data.bill.domain.TMdDispRate;

/**
 * Created by gongjk on 2016/7/4.
 */
public interface TMdDispRateMapper {
    public TMdDispRate getDispRateBySaleOrg(String saleOrg);

    int uptDispRateTypeBySaleOrg(TMdDispRate dispRate);

    int addDispRateSalOrg(TMdDispRate dispRate);
}
