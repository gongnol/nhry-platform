package com.nhry.data.basic.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdPriceYearcard;
import com.nhry.model.basic.YearcardPricePageModel;
import com.nhry.model.basic.YearcardPriceQueryModel;

import java.util.List;

public interface TMdPriceYearcardMapper {
    int deletePriceYearcardByKey(String id);

    int insertPriceYearcard(TMdPriceYearcard record);

    TMdPriceYearcard selectPriceYearcardByKey(String id);

    int updatePriceYearcardByKey(TMdPriceYearcard record);

    List<TMdPriceYearcard> selectPriceYearcardBySalesOrg(YearcardPriceQueryModel record);

    TMdPriceYearcard selectPriceYearcardByMatnr(YearcardPriceQueryModel record);

    TMdPriceYearcard selectOldPriceYearcardByMatnr(YearcardPriceQueryModel record);

    PageInfo<TMdPriceYearcard> selectYearcardPriceListPage(YearcardPricePageModel record);

    PageInfo<TMdPriceYearcard> selectYearcardPriceAndOldPrice(YearcardPricePageModel record);
}