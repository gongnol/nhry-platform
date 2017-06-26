package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.domain.TMdDealer;

import java.util.List;

/**
 * Created by cbz on 6/29/2016.
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
}
