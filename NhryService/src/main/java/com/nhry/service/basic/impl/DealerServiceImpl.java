package com.nhry.service.basic.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.SearchModel.TMdDealerStatusModel;
import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.domain.DealerQueryModel;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.service.basic.dao.DealerService;
import com.nhry.utils.CodeGeneratorUtil;
import com.nhry.utils.date.Date;
import com.sun.tools.internal.ws.processor.model.Message;

/**
 * Created by gongjk on 2016/7/14.
 */
public class DealerServiceImpl implements DealerService {
    private TMdDealerMapper dealerMapper;
    private UserSessionService userSessionService;
    private TSysUserRoleMapper urMapper;

    public void setUrMapper(TSysUserRoleMapper urMapper) {
        this.urMapper = urMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setDealerMapper(TMdDealerMapper dealerMapper) {
        this.dealerMapper = dealerMapper;
    }

    @Override
    public List<TMdDealer> getDealerBySalesOrg() {
        TSysUser user = userSessionService.getCurrentUser();
         List<TMdDealer> list = dealerMapper.findDealersBySalesOrg(user.getSalesOrg());
        if(list == null){
            list = new ArrayList<TMdDealer>();
        }
        boolean flag = false;
        for(TMdDealer dealer : list){
            if("-1".equals(dealer.getDealerNo())){
                flag = true;
                break;
            }
        }
        if(!flag){
            TMdDealer dealer = new TMdDealer();
            dealer.setDealerNo("-1");
            dealer.setDealerName("自营奶站");
            list.add(dealer);
        }
        return list;
    }
    public  TMdDealer getDealerByNo(String dealerNo){
        return dealerMapper.selectDealerByNo(dealerNo);
    }

    @Override
    public List<TMdDealer> getDealerOnAuth() {
        List<TMdDealer> dealers = new ArrayList<TMdDealer>();
        TSysUser user = userSessionService.getCurrentUser();
        List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
       if(rids.contains("10005")){
            //经销商内勤
    	   dealers.add(this.getDealerByNo(user.getDealerId()));
    	   return dealers;
        }else if(rids.contains("10004")){
            //奶站内勤
           dealers = new ArrayList<TMdDealer>();
           TMdDealer dealer= new TMdDealer();
           dealer.setDealerNo("-1");
           dealer.setDealerName("自营奶站");
           dealers.add(dealer);
           return dealers;
        }
        return this.getDealerBySalesOrg();
    }

	@Override
	public PageInfo findDealerListByPage(DealerQueryModel sModel) {
		TSysUser user = userSessionService.getCurrentUser();
		sModel.setSalesOrg(user.getSalesOrg());
		if(StringUtils.isBlank(sModel.getDealerNo())){
			sModel.setDealerNo(user.getDealerId());
		}
		return dealerMapper.findDealerListByPage(sModel);
	}

	@Override
	public List<TMdDealer> getDealersBySalesOrg(String salesOrg) {
			if(StringUtils.isEmpty(salesOrg)){
				salesOrg = userSessionService.getCurrentUser().getSalesOrg();
			}
	         List<TMdDealer> list = dealerMapper.findDealersBySalesOrg(salesOrg);
	        if(list == null){
	            list = new ArrayList<TMdDealer>();
	        }
	        boolean flag = false;
	        for(TMdDealer dealer : list){
	            if("-1".equals(dealer.getDealerNo())){
	                flag = true;
	                break;
	            }
	        }
	        if(!flag){
	            TMdDealer dealer = new TMdDealer();
	            dealer.setDealerNo("-1");
	            dealer.setDealerName("自营奶站");
	            list.add(dealer);
	        }
	        
	        return list;
	}

	@Override
	public int addDealer(TMdDealer dealer) {
		TSysUser user = userSessionService.getCurrentUser();
		dealer.setSalesOrg(user.getSalesOrg());
		dealer.setDealerNo(CodeGeneratorUtil.getCode());
		dealer.setCreateBy(user.getLoginName());
		dealer.setCreateByTxt(user.getDisplayName());
		dealer.setCreateAt(new Date());
		dealer.setLastModified(new Date());
		dealer.setLastModifiedBy(user.getLoginName());
		dealer.setLastModifiedByTxt(user.getDisplayName());
		return dealerMapper.addDealer(dealer);
	}

	@Override
	public TMdDealer selectDealerByNo(String dealerNo) {
		return dealerMapper.selectDealerByNo(dealerNo);
	}

	@Override
	public int updateDealerStatus(TMdDealerStatusModel model) {
		if(StringUtils.isBlank(model.getDealerNo()) && (model.getDealerNos()== null && model.getDealerNos().size()<=0)){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"经销商更新状态,经销商编号不能为空");          
		}
		
		return dealerMapper.updateDealerStatus(model);
	}

	@Override
	public List<TMdDealer> getDealerOnAuthAndGroup(String branchGroup) {
		List<TMdDealer> dealers = new ArrayList<TMdDealer>();
		if(branchGroup.equals("01")){
	           dealers = new ArrayList<TMdDealer>();
	           TMdDealer dealer= new TMdDealer();
	           dealer.setDealerNo("-1");
	           dealer.setDealerName("自营奶站");
	           dealers.add(dealer);
	           return dealers;
		}else{
		        TSysUser user = userSessionService.getCurrentUser();
		        List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
		       if(rids.contains("10005")){
		            //经销商内勤
		    	   dealers.add(this.getDealerByNo(user.getDealerId()));
		    	   return dealers;
		       }else{
		    	   List<TMdDealer> list = dealerMapper.findDealersBySalesOrg(user.getSalesOrg());
		    	   dealers.addAll(list);
		    	   return dealers;
		       }
		       
		      
		      
		}
	}

	@Override
	public int updateDealerInfo(TMdDealer dealer) {
		if(StringUtils.isBlank(dealer.getDealerNo())){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该经销商编号不存在！！！");     
		}
		
		TMdDealer oldDealer = this.getDealerByNo(dealer.getDealerNo());
		if(oldDealer == null){
			throw new ServiceException(MessageCode.LOGIC_ERROR,"该经销商不存在！！！");     
		}
		return dealerMapper.updateDealerSelective(dealer);
	}
}
