package com.nhry.service.stud.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.stud.dao.TMdMaraStudMapper;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.model.stud.OrderStudQueryModel;
import com.nhry.service.stud.dao.MaraStudService;

/**
 * @author zhaoxijun
 * @date 2017年4月11日
 */
public class MaraStudServiceImpl implements MaraStudService {
	
	@Autowired
	private UserSessionService userSessionService;

	@Autowired
	private TMdMaraStudMapper maraStudMapper;
	
	@Override
	public List<TMdMaraStud> findAllListBySalesOrg(String salesOrg) {
		return maraStudMapper.findAllListBySalesOrg(salesOrg);
	}

	@Override
	public List<TMdMaraStud> findAllListBySalesOrg() {
		return this.findAllListBySalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
	}

	@Override
	public PageInfo findMaraStudAllPage(OrderStudQueryModel queryModel) {
		if(null == queryModel || StringUtils.isBlank(queryModel.getPageNum())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前页数必填");
		}
		if(StringUtils.isBlank(queryModel.getPageSize())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "每页显示条数必填");
		}
		
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		queryModel.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		return maraStudMapper.findMaraStudAllPage(queryModel);
	}
	
	@Override
	public int updateMaraStud(TMdMaraStud tMdMaraStud) {
		if(StringUtils.isBlank(this.userSessionService.getCurrentUser().getSalesOrg())){
			throw new ServiceException(MessageCode.LOGIC_ERROR, "当前用户未归属销售组织");
		}
		tMdMaraStud.setSalesOrg(this.userSessionService.getCurrentUser().getSalesOrg());
		return maraStudMapper.updateInfo(tMdMaraStud);
	}
	
	

}
