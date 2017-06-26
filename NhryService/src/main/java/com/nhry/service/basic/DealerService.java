package com.nhry.service.basic;

import com.nhry.data.basic.domain.TMdDealer;

import java.util.List;

/**
 * Created by gongjk on 2016/7/14.
 */
public interface DealerService {
    List<TMdDealer> getDealerBySalesOrg();

    List<TMdDealer> getDealerOnAuth();
}
