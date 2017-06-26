package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdMaraUnitMapper;
import com.nhry.data.basic.domain.TMdMaraUnit;
import com.nhry.data.basic.domain.TMdMaraUnitKey;

/**
 * Created by cbz on 7/6/2016.
 */
public class TMdMaraUnitMapperImpl implements TMdMaraUnitMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int deleteMaraUnitByNo(TMdMaraUnitKey key) {
        return sqlSessionTemplate.delete("deleteMaraUnitByNo",key);
    }

    @Override
    public int insertMaraUnit(TMdMaraUnit record) {
        return sqlSessionTemplate.insert("insertMaraUnit",record);
    }

    @Override
    public int insertMaraUnitelective(TMdMaraUnit record) {
        return 0;
    }

    @Override
    public TMdMaraUnit selectMaraUnitByNo(TMdMaraUnitKey key) {
        return sqlSessionTemplate.selectOne("selectMaraUnitByNo",key);
    }

    @Override
    public int updateMaraUnitSelective(TMdMaraUnit record) {
        return sqlSessionTemplate.update("updateMaraUnitSelective",record);
    }

    @Override
    public int updateMaraUnit(TMdMaraUnit record) {
        return sqlSessionTemplate.update("updateMaraUnit",record);
    }
}
