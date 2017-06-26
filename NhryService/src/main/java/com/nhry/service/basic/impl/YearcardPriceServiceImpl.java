package com.nhry.service.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdPriceYearcardMapper;
import com.nhry.data.basic.domain.TMdPriceYearcard;
import com.nhry.model.basic.YearcardPricePageModel;
import com.nhry.model.basic.YearcardPriceQueryModel;
import com.nhry.service.basic.dao.YearcardPriceService;
import com.nhry.utils.DateUtil;
import com.nhry.utils.PrimaryKeyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.method.P;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 2017/5/15.
 */
public class YearcardPriceServiceImpl implements YearcardPriceService {

    private TMdPriceYearcardMapper priceYearcardMapper;
    private UserSessionService userSessionService;

    @Override
    public int addYearcardPrice(TMdPriceYearcard record) {

        if(record.getPriceNetValue() == null || record.getPriceDeliver() == null || record.getMatnr() == null || "N".equals(record.getStatus())){
            return 1;
        }
        if(record.getPriceHome() == null){
            record.setPriceHome(BigDecimal.ZERO);
        }

        TMdPriceYearcard oldPrice = this.selectPriceYearcardByMatnr(record.getMatnr());
        if(oldPrice != null) {

            if (oldPrice.getPriceHome() == null) oldPrice.setPriceHome(BigDecimal.ZERO);

            if(record.getPriceNetValue().compareTo(oldPrice.getPriceNetValue()) == 0
                    && record.getPriceHome().compareTo(oldPrice.getPriceHome()) == 0
                    && record.getPriceDeliver().compareTo(oldPrice.getPriceDeliver()) == 0){
                return 1;
            }
            oldPrice.setEndDate(DateUtil.getYestoday(new Date()));
            oldPrice.setStatus("N");
            priceYearcardMapper.updatePriceYearcardByKey(oldPrice);
        }
        TSysUser user = userSessionService.getCurrentUser();
        record.setId(PrimaryKeyUtils.generateUuidKey());
        if(record.getStartDate() == null){
            record.setStartDate(new Date());
        }
        if(StringUtils.isEmpty(record.getIsShow())){
            record.setIsShow("Y");
        }
        record.setSalesOrg(user.getSalesOrg());
        record.setCreateAt(new Date());
        record.setCreateBy(user.getLoginName());
        record.setCreateByTxt(user.getDisplayName());
        uptPriceAgree(record);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            record.setEndDate(format.parse("9999-01-01"));
        }catch (Exception e) {

        }
        return priceYearcardMapper.insertPriceYearcard(record);
    }

    private void uptPriceAgree(TMdPriceYearcard record) {
        record.setPriceAgree(BigDecimal.ZERO);
        if(record.getPriceNetValue()!=null){
            record.setPriceAgree(record.getPriceAgree().add(record.getPriceNetValue()));
        }
        if(record.getPriceDeliver()!=null){
            record.setPriceAgree(record.getPriceAgree().add(record.getPriceDeliver()));
        }
        if(record.getPriceHome() != null){
            record.setPriceAgree(record.getPriceAgree().add(record.getPriceHome()));
        }
    }

    @Override
    public int updateYearcardPrice(TMdPriceYearcard record) {
        TSysUser user = userSessionService.getCurrentUser();
        record.setLastModified(new Date());
        record.setLastModifiedBy(user.getLoginName());
        record.setLastModifiedByTxt(user.getDisplayName());
        uptPriceAgree(record);
        return priceYearcardMapper.updatePriceYearcardByKey(record);
    }

    @Override
    public List<TMdPriceYearcard> selectYearcardPriceByParams(YearcardPriceQueryModel record) {
        record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
        return priceYearcardMapper.selectPriceYearcardBySalesOrg(record);
    }

    @Override
    public TMdPriceYearcard getYearcardPrice(String id) {
        return priceYearcardMapper.selectPriceYearcardByKey(id);
    }

    public void setPriceYearcardMapper(TMdPriceYearcardMapper priceYearcardMapper) {
        this.priceYearcardMapper = priceYearcardMapper;
    }
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @Override
    public int updateYearcardPrices(List<TMdPriceYearcard> records) {
        if(records.size()>0){
            records.forEach(e -> {
                addYearcardPrice(e);
            });
        }
        return 1;
    }

    @Override
    public TMdPriceYearcard selectPriceYearcardByMatnr(String matnr) {
        YearcardPriceQueryModel model = new YearcardPriceQueryModel();
        model.setSearch(matnr);
        model.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
        return priceYearcardMapper.selectPriceYearcardByMatnr(model);
    }

    @Override
    public TMdPriceYearcard selectOldPriceYearcardByMatnr(YearcardPriceQueryModel recode) {
        recode.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
        return priceYearcardMapper.selectOldPriceYearcardByMatnr(recode);
    }

    @Override
    public PageInfo<TMdPriceYearcard> selectYearcardPriceListPage(YearcardPricePageModel record) {
        record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
        return priceYearcardMapper.selectYearcardPriceListPage(record);
    }

    @Override
    public PageInfo<TMdPriceYearcard> selectYearcardPriceAndOldPrice(YearcardPricePageModel record) {
        record.setSalesOrg(userSessionService.getCurrentUser().getSalesOrg());
        return priceYearcardMapper.selectYearcardPriceAndOldPrice(record);
    }

}
