package com.nhry.data.basic.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.SearchModel.TMdDealerStatusModel;
import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.domain.DealerQueryModel;
import com.nhry.data.basic.domain.TMdDealer;

import java.util.List;

/**
 */
public class TMdDealerMapperImpl implements TMdDealerMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteDealerByNo(String dealerNo) {
        return 0;
    }

    @Override
    public int insertDealer(TMdDealer record) {
        return sqlSessionTemplate.insert("insertDealer",record);
    }

    @Override
    public TMdDealer selectDealerByNo(String dealerNo) {
        return sqlSessionTemplate.selectOne("selectDealerByNo",dealerNo);
    }

    @Override
    public int updateDealerSelective(TMdDealer record) {
        return sqlSessionTemplate.update("updateDealerSelective",record);
    }

    @Override
    public int updateDealer(TMdDealer record) {
        return sqlSessionTemplate.update("updateDealer",record);
    }

	@Override
	public List<TMdDealer> findDealersBySalesOrg(String salesOrg) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findDealersBySalesOrg", salesOrg);
	}

	@Override
	public PageInfo findDealerListByPage(DealerQueryModel sModel) {
		return sqlSessionTemplate.selectListByPages("findDealerListByPage",sModel, Integer.parseInt(sModel.getPageNum()), Integer.parseInt(sModel.getPageSize()));

	}

	@Override
	public int addDealer(TMdDealer dealer) {
		return sqlSessionTemplate.insert("addDealer",dealer);
	}

	@Override
	public int updateDealerStatus(TMdDealerStatusModel model) {
		return sqlSessionTemplate.update("updateDealerStatus",model);
	}
}
