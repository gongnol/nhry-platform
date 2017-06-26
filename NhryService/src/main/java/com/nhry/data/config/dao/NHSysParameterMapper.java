package com.nhry.data.config.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.nhry.data.config.domain.NHSysParameter;
import com.nhry.model.basic.SysParamQueryModel;

public interface NHSysParameterMapper {
    int deleteSysParamByCode(String paramCode);

    int addSysParam(NHSysParameter record);

    NHSysParameter selectSysParamByCode(String paramCode);

    int uptSysParamByCode(NHSysParameter record);
    
    public PageInfo findSysParam(SysParamQueryModel param);
}