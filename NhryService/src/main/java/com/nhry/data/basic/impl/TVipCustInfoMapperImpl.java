package com.nhry.data.basic.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.basic.dao.TVipCustInfoMapper;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.model.basic.CustQueryModel;
import com.nhry.model.basic.CustStat;

import java.util.List;
import java.util.Map;

public class TVipCustInfoMapperImpl implements TVipCustInfoMapper {
	private DynamicSqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int addVipCust(TVipCustInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert("addVipCust",record);
	}

	@Override
	public TVipCustInfo findVipCustByNo(String vipCustNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCustByNo", vipCustNo);
	}
	
	@Override
	public List<TVipCustInfo> findVipCustByNoSapNo(String salesOrg) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findVipCustByNoSapNo", salesOrg);
	}

	@Override
	public int updateVipCustByNo(TVipCustInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("updateVipCustByNo", record);
	}

	@Override
	public TVipCustInfo findStaCustByPhone(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findStaCustByPhone", attrs);
	}

	@Override
	public List<TVipCustInfo> findCompanyCustByPhone(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("findCompanyCustByPhone", attrs);
	}

	@Override
	public TVipCustInfo findVipCustByNoForUpt(String vipCustNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCustByNoForUpt", vipCustNo);
	}

	@Override
	public TVipCustInfo findVipCustOnlyByNo(String vipCustNo) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("findVipCustOnlyByNo", vipCustNo);
	}

	@Override
	public int uptCustStatus(TVipCustInfo record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.update("uptCustStatus", record);
	}

	@Override
	public PageInfo findcustMixedTerms(CustQueryModel cust) {
		// TODO Auto-generated method stub
		 // 核心分页代码
		PageHelper.startPage(Integer.parseInt(cust.getPageNum()), Integer.parseInt(cust.getPageSize()),false);
		PageInfo pageinfo = new PageInfo(this.sqlSessionTemplate.selectList("findcustMixedTerms",cust));
		pageinfo.setTotal(sqlSessionTemplate.selectOne("findcustMixedTermsCount", cust));
		return pageinfo;
//		return this.sqlSessionTemplate.selectListByPages("findcustMixedTerms",cust, Integer.parseInt(cust.getPageNum()), Integer.parseInt(cust.getPageSize()));
	}

	@Override
	public PageInfo findCustByOrgId(CustQueryModel cust) {
		return sqlSessionTemplate.selectListByPages("findCustByOrgId",cust, Integer.parseInt(cust.getPageNum()), Integer.parseInt(cust.getPageSize()));
	}

	@Override
	public int getCustCountByPhone(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("getCustCountByPhone", attrs);
	}

	@Override
	public String getCustNoByPhone(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne("getCustNoByPhone", attrs);
	}

	@Override
	public int deleteCustByCno(String cno) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.delete("deleteCustByCno", cno);
	}

	@Override
	public List<CustStat> getCustInfoStat(Map<String, String> attrs) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList("getCustInfoStat", attrs);
	}

	@Override
	public int updateSapNo(TVipCustInfo vipCustInfo) {
		return this.sqlSessionTemplate.update("updateSapNo",vipCustInfo);
	}

	@Override
	public int updateVipMp(TVipCustInfo vipCustInfo) {
		return this.sqlSessionTemplate.update("updateVipMp",vipCustInfo);
	}

	@Override
	public PageInfo findCustByOrg(CustQueryModel cust) {
		return sqlSessionTemplate.selectListByPages("findCustByOrg",cust, Integer.parseInt(cust.getPageNum()), Integer.parseInt(cust.getPageSize()));
	}
	@Override
	public PageInfo findCustWithoutOrg(CustQueryModel cust) {
		return sqlSessionTemplate.selectListByPages("findCustWithoutOrg",cust, Integer.parseInt(cust.getPageNum()), Integer.parseInt(cust.getPageSize()));
	}
}
