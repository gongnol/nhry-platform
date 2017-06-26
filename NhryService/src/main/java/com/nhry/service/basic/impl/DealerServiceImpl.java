package com.nhry.service.basic.impl;

import com.nhry.common.auth.UserSessionService;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.service.basic.DealerService;

import java.util.ArrayList;
import java.util.List;

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
        List<TMdDealer> dealers ;
        TSysUser user = userSessionService.getCurrentUser();
        List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
       if(rids.contains("10005")){
            //经销商内勤
          this.getDealerByNo(user.getDealerId());
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
}
