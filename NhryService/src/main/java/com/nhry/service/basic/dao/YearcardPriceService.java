package com.nhry.service.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdPriceYearcard;
import com.nhry.model.basic.YearcardPricePageModel;
import com.nhry.model.basic.YearcardPriceQueryModel;

import java.util.List;

/**
 * Created by chen on 2017/5/15.
 */
public interface YearcardPriceService {

    int addYearcardPrice(TMdPriceYearcard recode);

    int updateYearcardPrice(TMdPriceYearcard record);

    int updateYearcardPrices(List<TMdPriceYearcard> records);

    List<TMdPriceYearcard> selectYearcardPriceByParams(YearcardPriceQueryModel record);

    TMdPriceYearcard getYearcardPrice(String id);

    TMdPriceYearcard selectPriceYearcardByMatnr(String matnr);

    TMdPriceYearcard selectOldPriceYearcardByMatnr(YearcardPriceQueryModel recode);

    PageInfo<TMdPriceYearcard> selectYearcardPriceListPage(YearcardPricePageModel record);

    PageInfo<TMdPriceYearcard> selectYearcardPriceAndOldPrice(YearcardPricePageModel record);
}
