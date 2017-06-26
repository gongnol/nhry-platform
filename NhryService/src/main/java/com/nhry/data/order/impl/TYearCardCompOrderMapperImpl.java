package com.nhry.data.order.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.order.dao.TYearCardCompOrderMapper;
import com.nhry.data.order.domain.TMstYearCardCompOrder;
import com.nhry.model.statistics.ExtendBranchInfoModel;

import java.util.List;

/**
 * Created by gongjk on 2016/12/14.
 */
public class TYearCardCompOrderMapperImpl implements TYearCardCompOrderMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int addYearCardCompOrder(TMstYearCardCompOrder yOrder) {
        return sqlSessionTemplate.insert("addYearCardCompOrder",yOrder);
    }
    /**
     * 年卡补偿单据，根据奶站、经销商、销售组织及订单退订日期区间查询
     * @param model
     * @return
     */
    @Override
    public List<TMstYearCardCompOrder> selectYearCardCompensateList(ExtendBranchInfoModel model) {
        return sqlSessionTemplate.selectList("selectYearCardCompensateList",model);
    }
}
