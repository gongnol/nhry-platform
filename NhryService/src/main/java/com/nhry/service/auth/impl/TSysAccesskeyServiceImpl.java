package com.nhry.service.auth.impl;

import com.nhry.data.auth.dao.TSysAccesskeyMapper;
import com.nhry.data.auth.domain.TSysAccesskey;
import com.nhry.service.auth.dao.TSysAccesskeyService;

public class TSysAccesskeyServiceImpl implements TSysAccesskeyService {
	private TSysAccesskeyMapper isysAkmapper;

	@Override
	public int deleteAccesskeyByAk(TSysAccesskey key) {
		// TODO Auto-generated method stub
		return this.isysAkmapper.deleteAccesskeyByAk(key);
	}

	@Override
	public int addIsysAccessKey(TSysAccesskey record) {
		// TODO Auto-generated method stub
		return this.isysAkmapper.addIsysAccessKey(record);
	}

	@Override
	public TSysAccesskey findAccesskeyByKey(TSysAccesskey key) {
		// TODO Auto-generated method stub
		return this.isysAkmapper.findAccesskeyByKey(key);
	}

	@Override
	public int updateIsysAccessKey(TSysAccesskey record) {
		// TODO Auto-generated method stub
		TSysAccesskey key = new TSysAccesskey();
		key.setAccesskey(record.getAccesskey());
		key.setType(record.getType());
		TSysAccesskey ak = this.isysAkmapper.findAccesskeyByKey(key);
		if(ak == null){
			return this.isysAkmapper.addIsysAccessKey(record);
		}else{
			return this.isysAkmapper.updateIsysAccessKey(record);
		}
	}
	
	

	public void setIsysAkmapper(TSysAccesskeyMapper isysAkmapper) {
		this.isysAkmapper = isysAkmapper;
	}

	@Override
	public int deleteExpiredAccesskey() {
		// TODO Auto-generated method stub
		return this.isysAkmapper.deleteExpiredAccesskey();
	}

}
