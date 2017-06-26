package com.nhry.data.basic.impl;

import java.util.List;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdMaraSortMapper;
import com.nhry.data.basic.domain.TMdMaraSort;
import com.nhry.model.basic.UpdateMaraModel;

public class TMdMaraSortMapperImpl implements TMdMaraSortMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

	@Override
	public int updatebyMatnr(UpdateMaraModel updateMaraModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("updatebyMatnr", updateMaraModel);
	}

	@Override
	public int insert(UpdateMaraModel updateMaraModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("addTMdMaraSort", updateMaraModel);
	}

	@Override
	public int delete(UpdateMaraModel updateMaraModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("delete", updateMaraModel);
	}

	@Override
	public List<TMdMaraSort> findListByBranchNo(String branchNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("findListByBranchNo", branchNo);
	}

	
    
   
}
