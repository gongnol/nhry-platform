package com.nhry.data.basic.impl;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TSysMessageMapper;
import com.nhry.data.basic.domain.TSysMessage;
import com.nhry.model.basic.MessageModel;

public class TSysMessageMapperImpl implements TSysMessageMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int delTSysMessageByNo(String messageNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("delTSysMessageByNo", messageNo);
	}

	@Override
	public int addTSysMessage(TSysMessage record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addTSysMessage", record);
	}

	@Override
	public TSysMessage findTSysmessageByNo(String messageNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findTSysmessageByNo", messageNo);
	}

	@Override
	public int uptTSysMessage(TSysMessage record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptTSysMessage", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public PageInfo searchMessages(MessageModel mess) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectListByPages("searchMessages", mess, Integer.parseInt(mess.getPageNum()), Integer.parseInt(mess.getPageSize()));
	}

	@Override
	public int closeSysMessage(Map attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("closeSysMessage", attrs);
	}
}
