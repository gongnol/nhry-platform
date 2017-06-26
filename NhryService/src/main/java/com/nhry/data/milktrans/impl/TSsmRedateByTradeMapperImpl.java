package com.nhry.data.milktrans.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milktrans.dao.TSsmRedateByTradeMapper;
import com.nhry.data.milktrans.domain.TSsmRedateByTrade;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by cbz on 12/26/2016.
 */
public class TSsmRedateByTradeMapperImpl implements TSsmRedateByTradeMapper {

    private DynamicSqlSessionTemplate sqlSessionFactory;

    public void setSqlSessionFactory(DynamicSqlSessionTemplate sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public int insertRedateByTrade(TSsmRedateByTrade ssmRedateByTrade) {
        return sqlSessionFactory.insert("insertRedateByTrade",ssmRedateByTrade);
    }

    @Override
    public int updateRedateByTrade(TSsmRedateByTrade ssmRedateByTrade) {
        return sqlSessionFactory.update("updateRedateByTrade",ssmRedateByTrade);
    }

    @Override
    public List<TSsmRedateByTrade> findNoSendRedateByTrade() {
        return sqlSessionFactory.selectList("findNoSendRedateByTrade");
    }
}
