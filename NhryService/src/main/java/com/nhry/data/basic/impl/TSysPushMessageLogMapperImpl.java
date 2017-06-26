package com.nhry.data.basic.impl;

import java.util.List;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TSysPushMessageLogMapper;
import com.nhry.data.basic.domain.TSysPushMessageLog;

public class TSysPushMessageLogMapperImpl implements TSysPushMessageLogMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int delPushMessageLog(String mno) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delPushMessageLog", mno);
	}

	@Override
	public int addPushMessageLog(TSysPushMessageLog record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addPushMessageLog", record);
	}

	@Override
	public TSysPushMessageLog selectPushMessageLogByNo(String mno) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("selectPushMessageLogByNo", mno);
	}

	@Override
	public int updatePushMessageLog(TSysPushMessageLog record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updatePushMessageLog", record);
	}

	@Override
	public List<TSysPushMessageLog> findSysPushMessageLogs() {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findSysPushMessageLogs");
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
