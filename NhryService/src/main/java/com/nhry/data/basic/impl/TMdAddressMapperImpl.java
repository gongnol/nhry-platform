package com.nhry.data.basic.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TMdAddressMapper;
import com.nhry.data.basic.domain.TMdAddress;

import java.util.List;
import java.util.Map;

public class TMdAddressMapperImpl implements TMdAddressMapper{
	private DynamicSqlSessionTemplate sqlSessionTemplate;
	@Override
	public int addAddressForCust(TMdAddress address) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addAddressForCust", address);
	}

	@Override
	public TMdAddress findAddressById(String addressId) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findAddressById", addressId);
	}

	@Override
	public int uptCustAddress(TMdAddress record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptCustAddress", record);
	}

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TMdAddress> findOriginAddressByCustNo(String custNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findOriginAddressByCustNo", custNo);
	}

	@Override
	public List<TMdAddress> findCnAddressByCustNo(String custNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findCnAddressByCustNo", custNo);
	}

	@Override
	public TMdAddress findAddressDetailById(String id) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findAddressDetailById", id);
	}

	@Override
	public int uptCustAddressUnDefault(TMdAddress record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptCustAddressUnDefault", record);
	}

	@Override
	public List<TMdAddress> findAddressByMixedTerms(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findAddressByMixedTerms", attrs);
	}

	@Override
	public int deleteAddressByCustNo(String custNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteAddressByCustNo", custNo);
	}
	@Override
	public TMdAddress findAddressByCustNoISDefault(String id){
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findAddressByCustNoISDefault", id);
	}

	@Override
	public String findAddressTxtByMap(Map<String, String> map) {
		return this.sqlSessionTemplate.selectOne("findAddressTxtByMap", map);
	}
}
