package com.nhry.service.statistics.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.statistics.DistInfoModel;

/**
 * Created by cbz on 7/16/2016.
 */
public interface DistributionInfoService {
    PageInfo findDistDifferInfo(DistInfoModel model);
}
