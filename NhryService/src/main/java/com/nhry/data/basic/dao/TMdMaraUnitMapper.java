package com.nhry.data.basic.dao;

import com.nhry.data.basic.domain.TMdMaraUnit;
import com.nhry.data.basic.domain.TMdMaraUnitKey;

public interface TMdMaraUnitMapper {
    int deleteMaraUnitByNo(TMdMaraUnitKey key);

    int insertMaraUnit(TMdMaraUnit record);

    int insertMaraUnitelective(TMdMaraUnit record);

    TMdMaraUnit selectMaraUnitByNo(TMdMaraUnitKey key);

    int updateMaraUnitSelective(TMdMaraUnit record);

    int updateMaraUnit(TMdMaraUnit record);
}