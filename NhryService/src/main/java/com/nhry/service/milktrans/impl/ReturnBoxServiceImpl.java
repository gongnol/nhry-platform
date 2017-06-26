package com.nhry.service.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.milk.dao.TDispOrderItemMapper;
import com.nhry.data.milk.dao.TDispOrderMapper;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milktrans.dao.TRecBotDetailMapper;
import com.nhry.data.milktrans.domain.TRecBotDetail;
import com.nhry.data.stock.dao.TSsmStockMapper;
import com.nhry.model.milktrans.ReturnboxSerarch;
import com.nhry.model.milktrans.UpdateReturnBoxModel;
import com.nhry.model.stock.StockModel;
import com.nhry.service.milktrans.dao.ReturnBoxService;
import com.nhry.utils.DateUtil;
import com.nhry.utils.PrimaryKeyUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/6/27.
 */
public class ReturnBoxServiceImpl implements ReturnBoxService {
    private TRecBotDetailMapper tRecBotDetailMapper;
    private TDispOrderMapper tDispOrderMapper;
    private TDispOrderItemMapper tDispOrderItemMapper;
    private TMdBranchEmpMapper empMapper;
    private UserSessionService userSessionService;
    private TSysUserRoleMapper urMapper;
    private TSsmStockMapper tSsmStockMapper;

    public void setUrMapper(TSysUserRoleMapper urMapper) {
        this.urMapper = urMapper;
    }

    public void setEmpMapper(TMdBranchEmpMapper empMapper) {
        this.empMapper = empMapper;
    }
    public void settRecBotDetailMapper(TRecBotDetailMapper tRecBotDetailMapper) {
        this.tRecBotDetailMapper = tRecBotDetailMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void settDispOrderMapper(TDispOrderMapper tDispOrderMapper) {
        this.tDispOrderMapper = tDispOrderMapper;
    }

    public void settDispOrderItemMapper(TDispOrderItemMapper tDispOrderItemMapper) {
        this.tDispOrderItemMapper = tDispOrderItemMapper;
    }

    @Override
    public int uptBoxRetrun(UpdateReturnBoxModel boxModel) {
        try{
            TSysUser user = userSessionService.getCurrentUser();
            Date date = new Date();
            Map<String,String> map = new HashMap<String,String>();
            map.put("detLsh",boxModel.getDetLsh());
            map.put("spec",boxModel.getSpec());
            TRecBotDetail rotDetail = tRecBotDetailMapper.selectBotDetailByDetLsh(map);
            rotDetail.setRealNum(boxModel.getRealNum());
            rotDetail.setRecDate(date);
            rotDetail.setStatus("20");
            rotDetail.setLastModified(date);
            rotDetail.setLastModifiedBy(user.getLoginName());
            rotDetail.setLastModifiedByTxt(user.getDisplayName());
            tRecBotDetailMapper.uptRecBotDetail(rotDetail);
            return 1;
        }catch (Exception e){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"录入失败");
        }

    }

    @Override
    public int uptBoxReturnDetail(TRecBotDetail boxModel) {
        return tRecBotDetailMapper.uptRecBotDetail(boxModel);
    }


    /**
     * 路单确认时根据路单号创建该员工的回瓶管理单
     * @param dispOrderNo
     * @return
     */
    @Override
    public int createDayRetBox(String dispOrderNo) {
        final long startTime = System.currentTimeMillis();
        TSysUser user = userSessionService.getCurrentUser();
        TDispOrder dispOrder = tDispOrderMapper.getDispOrderByNo(dispOrderNo);

        List<TRecBotDetail> tRecBot = tRecBotDetailMapper.selectRetByDispOrderNo(dispOrderNo);
        if (tRecBot == null || tRecBot.size() == 0 ) {
            //生成回瓶详情列表
            List<TRecBotDetail> entries = tDispOrderItemMapper.createRecBotByDispOrder(dispOrderNo);
            if (entries != null && entries.size() > 0) {
                for (TRecBotDetail bot : entries) {
                    bot.setEmpNo(dispOrder.getDispEmpNo());
                    bot.setDispOrderNo(dispOrderNo);
                    bot.setCreateAt(DateUtil.getTomorrow(dispOrder.getDispDate()));
                    bot.setCreateBy(user.getLoginName());
                    bot.setCreateByTxt(user.getDisplayName());
                    bot.setStatus("10");
                    bot.setDetLsh(PrimaryKeyUtils.generateUuidKey());
                    tRecBotDetailMapper.addRecBotItem(bot);
                }
            }
        }
        System.out.println("根据路单生成回瓶共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
         return 1;
    }

    @Override
    public PageInfo searchRetBoxPage(ReturnboxSerarch rSearch) {
        TSysUser user = userSessionService.getCurrentUser();
        rSearch.setSalesOrg(user.getSalesOrg());
        rSearch.setBranchNo(user.getBranchNo());
        rSearch.setDealerNo(user.getDealerId());
        //返回列表
        PageInfo result = tRecBotDetailMapper.searchRetBoxPage(rSearch);
        return result;
    }
	
	 @Override
	 public String getLastDayRets(String code)
	 {
		  List<TRecBotDetail> list = tRecBotDetailMapper.selectRetByDispOrderNo(code);
		  Map<String, Integer> map = new HashMap<String, Integer>();
		  map.put("10",0);
		  map.put("20",0);
		  map.put("30",0);
		  for(TRecBotDetail e:list){
			   int amt = map.get(e.getSpec());
			   if("10".equals(e.getSpec())){
				   map.replace("10", amt + e.getReceiveNum());
			   }
            if("20".equals(e.getSpec())){
            	map.replace("20", amt + e.getReceiveNum());			  
            }
            if("30".equals(e.getSpec())){
            	map.replace("30", amt + e.getReceiveNum());
            }
		  }
		  
		  StringBuilder retStr = new StringBuilder("");
		  retStr.append("大瓶:"+map.get("30"));
		  retStr.append(" 中瓶:"+map.get("20"));
		  retStr.append(" 小瓶:"+map.get("10"));
		  
		  return retStr.toString();
	 }

    @Override
    public int craeteRetBotByStock(StockModel sModel) {
        Date today = new Date();
        TSysUser user = userSessionService.getCurrentUser();
        //生成回瓶详情列表
        List<TRecBotDetail> entries = tRecBotDetailMapper.craeteRetBotByStock(sModel);
        if (entries != null && entries.size() > 0) {
            for (TRecBotDetail bot : entries) {
                bot.setEmpNo(sModel.getEmpNo());
                bot.setCreateAt(today);
                bot.setCreateBy(user.getLoginName());
                bot.setCreateByTxt(user.getDisplayName());
                bot.setStatus("10");
                bot.setDetLsh(PrimaryKeyUtils.generateUuidKey());
                tRecBotDetailMapper.addRecBotItem(bot);
            }
        }
        return 1;
    }

    @Override
    public int addRecBotItem(TRecBotDetail botDetail) {
        return tRecBotDetailMapper.addRecBotItem(botDetail);
    }


    @Override
    public TRecBotDetail getTRecBotDetailByDispOrderNo(String dispOrderNo,String type) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("dispOrderNo",dispOrderNo);
        map.put("spec",type);
        return tRecBotDetailMapper.selectBotDetailByOrderAndSpec(map);
    }

}
