package com.nhry.service.basic.impl;

import com.nhry.data.basic.dao.TMdAddressMapper;
import com.nhry.data.basic.dao.TVipCrmAddressMapper;
import com.nhry.data.basic.dao.TVipCrmMapper;
import com.nhry.data.basic.dao.TVipCustInfoMapper;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TVipCrmInfo;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.service.BaseService;
import com.nhry.service.basic.dao.TVipCrmInfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

public class TVipCrmInfoServiceImpl extends BaseService implements TVipCrmInfoService {
	private static Logger logger = Logger.getLogger(TVipCrmInfoServiceImpl.class);
	private TVipCrmMapper vipCrmMapper;
	private TVipCrmAddressMapper vipcrmAddressMapper;
	private TVipCustInfoMapper vipCustInfoMapper;
	private TMdAddressMapper addressMapper;

	public void setAddressMapper(TMdAddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	public void setVipCrmMapper(TVipCrmMapper vipCrmMapper) {
		this.vipCrmMapper = vipCrmMapper;
	}

	public void setVipCustInfoMapper(TVipCustInfoMapper vipCustInfoMapper) {
		this.vipCustInfoMapper = vipCustInfoMapper;
	}

	@Override
	public void addVipCrm(TVipCrmInfo record) {
		TVipCrmInfo tmp = findVipCrmByNo(record.getVipCustNo());
		if(tmp == null) {
			vipCrmMapper.addVipCrm(record);
		}else{
			tmp.setMp(record.getMp());
			tmp.setVipCustNoSap(record.getVipCustNoSap());
			tmp.setVipCustNo(record.getVipCustNo());
			vipCrmMapper.updateVipCrmByNo(tmp);
		}
	}

	@Override
	public TVipCrmInfo findVipCrmByNo(String vipCrmNo) {
		TVipCrmInfo crm = this.vipCrmMapper.findVipCrmByNo(vipCrmNo);
		return crm;
	}

	@Override
	public int updateVipCrmByNo(TVipCrmInfo record) {
		logger.info("更新会员"+record.getMp()+"会员号："+record.getVipCustNo());
		TVipCrmInfo crm = this.vipCrmMapper.getVipCrm(record.getVipCustNo());
		if(crm != null){
			crm.setVipCustNoSap(record.getVipCustNoSap());
			crm.setMp(record.getMp());
			crm.setVipName(record.getVipName());
			crm.setLastModified(new Date());
			crm.setLastModifiedBy("CRM");
			crm.setLastModifiedByTxt("CRM");
			vipCrmMapper.updateVipCrmByNo(crm);
		}
//		TVipCustInfo vipCustInfo = new TVipCustInfo();
//		vipCustInfo.setVipCustNoSap(record.getVipCustNo());
//		vipCustInfo.setVipMp(record.getMp());
//		vipCustInfoMapper.updateVipMp(vipCustInfo);
		return 1;
	}
	
	@Override
	public String getCrmNoByPhone(Map<String, String> attrs) {
		return vipCrmMapper.getCrmNoByPhone(attrs);
	}

	public void setVipcrmAddressMapper(TVipCrmAddressMapper vipcrmAddressMapper) {
		this.vipcrmAddressMapper = vipcrmAddressMapper;
	}

	@Override
	public int updateVipCrmAddress(TMdAddress address) {
		// TODO Auto-generated method stub
//		return addressMapper.uptCustAddress(address);
		return -1;
	}
}
