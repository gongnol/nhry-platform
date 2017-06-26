package com.nhry.service.config.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.config.dao.NHSysParameterMapper;
import com.nhry.data.config.domain.NHSysParameter;
import com.nhry.model.basic.SysParamQueryModel;
import com.nhry.service.BaseService;
import com.nhry.service.config.dao.SysParamService;
import com.nhry.utils.date.Date;

public class SysParamServiceImpl extends BaseService implements SysParamService {
    private NHSysParameterMapper sysParamMapper;
    
	@Override
	public int deleteSysParamByCode(String paramCode) {
		// TODO Auto-generated method stub
		return sysParamMapper.deleteSysParamByCode(paramCode);
	}

	@Override
	public int addSysParam(NHSysParameter record) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(record.getParamCode())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"参数编码必须填写！");
		}else{
			NHSysParameter _record = this.selectSysParamByCode(record.getParamCode());
			if(_record != null){
				throw new ServiceException(MessageCode.LOGIC_ERROR,"该参数编码对应的系统参数已经存在！");
			}
		}
		record.setCreateAt(new Date());
		record.setCreateBy(this.userSessionService.getCurrentUser().getLoginName());
		record.setCreateByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		return sysParamMapper.addSysParam(record);
	}

	@Override
	public NHSysParameter selectSysParamByCode(String paramCode) {
		// TODO Auto-generated method stub
		return sysParamMapper.selectSysParamByCode(paramCode);
	}

	@Override
	public int uptSysParamByCode(NHSysParameter record) {
		// TODO Auto-generated method stub
		record.setLastModified(new Date());
		record.setLastModifiedBy(this.userSessionService.getCurrentUser().getLoginName());
		record.setLastModifiedByTxt(this.userSessionService.getCurrentUser().getDisplayName());
		return sysParamMapper.uptSysParamByCode(record);
	}

	public void setSysParamMapper(NHSysParameterMapper sysParamMapper) {
		this.sysParamMapper = sysParamMapper;
	}

	@Override
	public PageInfo findSysParam(SysParamQueryModel param) {
		// TODO Auto-generated method stub
		return sysParamMapper.findSysParam(param);
	}
}
