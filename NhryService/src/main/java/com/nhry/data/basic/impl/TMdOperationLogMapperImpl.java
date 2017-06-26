package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdOperationLogMapper;
import com.nhry.data.basic.domain.TMdOperationLog;
import com.nhry.model.basic.CustOperationQueryModel;

/**
 * Created by gongjk on 2016/10/24.
 */
public class TMdOperationLogMapperImpl implements TMdOperationLogMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public int save(TMdOperationLog log) {
        return sqlSessionTemplate.insert("save",log);
    }

    @Override
    public PageInfo getCustOperationLog(CustOperationQueryModel cModel) {
        return sqlSessionTemplate.selectListByPages("getCustOperationLog", cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));
    }

    @Override
    public PageInfo getOrderOperationLog(CustOperationQueryModel cModel) {
        return sqlSessionTemplate.selectListByPages("getOrderOperationLog", cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));
    }

    @Override
    public PageInfo getPlanOperationLog(CustOperationQueryModel cModel) {
        return sqlSessionTemplate.selectListByPages("getPlanOperationLog", cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));
    }

    @Override
    public PageInfo getRouteOperationLog(CustOperationQueryModel cModel) {
        return sqlSessionTemplate.selectListByPages("getRouteOperationLog", cModel, Integer.parseInt(cModel.getPageNum()), Integer.parseInt(cModel.getPageSize()));
    }
}
