package com.nhry.data.statistics.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.statistics.DistInfoModel;

/**
 * Created by cbz on 7/15/2016.
 */
public interface DistributionInfoMapper {
    PageInfo findDistDifferInfo(DistInfoModel model);
}
