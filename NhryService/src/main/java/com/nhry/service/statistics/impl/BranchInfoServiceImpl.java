package com.nhry.service.statistics.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.statistics.dao.BranchInfoMapper;
import com.nhry.model.statistics.BranchInfoModel;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.service.milktrans.dao.OutMilkService;
import com.nhry.service.statistics.dao.BranchInfoService;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cbz on 7/18/2016.
 */
public class BranchInfoServiceImpl implements BranchInfoService {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private BranchInfoMapper branchInfoMapper;
    private UserSessionService userSessionService;
    private OutMilkService outMilkService;
    public void setBranchInfoMapper(BranchInfoMapper branchInfoMapper) {
        this.branchInfoMapper = branchInfoMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setOutMilkService(OutMilkService outMilkService) {
        this.outMilkService = outMilkService;
    }

    @Override
    public PageInfo branchDayInfo(BranchInfoModel model) {

        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.branchDayInfo(model);
    }

    @Override
    public PageInfo findOrderRatio(BranchInfoModel model) {
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findOrderRatio(model);
    }

    @Override
    public PageInfo findBranchMonthReport(BranchInfoModel model) {
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findBranchMonthReport(model);
    }

    @Override
    public PageInfo findReqOrder(BranchInfoModel model) {
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findReqOrder(model);
    }
    @Override
   public List<Map<String,String>> findReqOrderOutput(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findReqOrderOutput(model);
    }

    @Override
    public List<Map<String,String>> branchDayOutput(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.branchDayOutput(model);
    }

    @Override
    public List<Map<String,String>> findBranchMonthReportOutput(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findBranchMonthReportOutput(model);
    }

    @Override
    public List<Map<String,String>> findOrderRatioOutput(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findOrderRatioOutput(model);
    }
    @Override
    public PageInfo findChangeplanStatReport(ExtendBranchInfoModel model){

        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.findChangeplanStatReport(model);
    }
    @Override
    public PageInfo returnBoxStatReport(ExtendBranchInfoModel model){
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.returnBoxStatReport(model);
    }

    @Override
    public List<Map<String, String>> returnBoxStatList(ExtendBranchInfoModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.returnBoxStatList(model);
    }

    @Override
    public PageInfo mstDispNumStat(ExtendBranchInfoModel model){
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.mstDispNumStat(model);
    }
    @Override
    public PageInfo branchMstDispNumStat(ExtendBranchInfoModel model){
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.branchMstDispNumStat(model);
    }
    @Override
    public PageInfo dayMstDispNumStat(ExtendBranchInfoModel model){
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.dayMstDispNumStat(model);
    }
    @Override
    public List<Map<String,String>> branchDayRepo(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.branchDayRepo(model);
    }
    @Override
    public Map<String,String> branchDayQty(BranchInfoModel model){
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isEmpty(model.getBranchNo()) && StringUtils.isNotEmpty(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isNotEmpty(user.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }
        return branchInfoMapper.branchDayQty(model);
    }

    @Override
    public List<Map<String, String>> exportOrderByModel(BranchInfoModel model) {
        return branchInfoMapper.exportOrderByModel(model);
    }
    @Override
    public List<Map<String, String>> orderOnlineStatReport(ExtendBranchInfoModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isBlank(model.getBranchNo()) &&StringUtils.isNotBlank(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isBlank(model.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }

        return branchInfoMapper.orderOnlineStatReport(model);
    }

    @Override
    public PageInfo Refuse2receiveResend(ExtendBranchInfoModel model) {
        if(StringUtils.isEmpty(model.getPageNum()) || StringUtils.isEmpty(model.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        TSysUser user = userSessionService.getCurrentUser();
        if(StringUtils.isBlank(model.getBranchNo()) &&StringUtils.isNotBlank(user.getBranchNo())){
            model.setBranchNo(user.getBranchNo());
        }else if(StringUtils.isEmpty(model.getDealerId()) && StringUtils.isNotEmpty(user.getDealerId())){
            model.setDealerId(user.getDealerId());
        }
        if(StringUtils.isBlank(model.getSalesOrg())){
            model.setSalesOrg(user.getSalesOrg());
        }

        return branchInfoMapper.Refuse2receiveResend(model);
    }

    @Override
   public List<Map<String,String>> Refuse2receiveResendDetail(String  resendOrderNo){
        return branchInfoMapper.Refuse2receiveResendDetail(resendOrderNo);
    }

    @Override
    public List<Map<String,String>> PendingUnConfirmOnline(){
        TSysUser user = userSessionService.getCurrentUser();
        return branchInfoMapper.PendingUnConfirmOnline(user.getSalesOrg());
    }

    @Override
    public List<Map<String, String>> exportDispInlOrderByModel(ExtendBranchInfoModel model) {
        return branchInfoMapper.exportDispInlOrderByModel(model);
    }

    @Override
    public List<Map<String, String>> getDayReportBasisForm(BranchInfoModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        model.setSalesOrg(user.getSalesOrg());
        if(user.getBranchNo()!=null){
            model.setBranchNo(user.getBranchNo());
        }
        if(user.getDealerId()!=null){
            model.setDealerId(user.getDealerId());
        }
        //要货计划产品信息及总数
        List<Map<String,String>>  basis = branchInfoMapper.getDayReportBasis(model);
        //要货计划按照订单类型分类区分
        List<Map<String,String>>  forms = branchInfoMapper.getDayReportForm(model);
        if(basis!=null && forms !=null){
            for(Map<String,String> basisitems:basis){
                for(Map<String,String> formsitems:forms){
                    //非赠品
                    if("N".equals(basisitems.get("FREE_FLAG"))){
                        //产品相同非赠品-机构
                        if("N".equals(formsitems.get("FREE_FLAG"))
                           && basisitems.get("MATNR").equals(formsitems.get("MATNR"))
                           && "70".equals(formsitems.get("PREORDER_SOURCE"))){
                            basisitems.put("orgOrder",formsitems.get("qty"));
                        }
                        //年卡
                        if("N".equals(formsitems.get("FREE_FLAG"))
                                && basisitems.get("MATNR").equals(formsitems.get("MATNR"))
                                && "YE".equals(formsitems.get("PREORDER_SOURCE"))){
                            basisitems.put("yearOrder",formsitems.get("qty"));
                        }
                        //电商
                        if("N".equals(formsitems.get("FREE_FLAG"))
                                && basisitems.get("MATNR").equals(formsitems.get("MATNR"))
                                && "10".equals(formsitems.get("PREORDER_SOURCE"))){
                            basisitems.put("DSOrder",formsitems.get("qty"));
                        }
                        //牛奶钱包
                        if("N".equals(formsitems.get("FREE_FLAG"))
                                && basisitems.get("MATNR").equals(formsitems.get("MATNR"))
                                && "40".equals(formsitems.get("PREORDER_SOURCE"))){
                            basisitems.put("NNQBOrder",formsitems.get("qty"));
                        }
                        //奶站订单
                        if("N".equals(formsitems.get("FREE_FLAG"))
                                && basisitems.get("MATNR").equals(formsitems.get("MATNR"))
                                && ("30".equals(formsitems.get("PREORDER_SOURCE"))
                                || "EM".equals(formsitems.get("PREORDER_SOURCE")) )){
                            basisitems.put("normalOrder",formsitems.get("qty"));
                        }
                    }
                    //赠品
                    else{
                        if("Y".equals(formsitems.get("FREE_FLAG"))
                                && basisitems.get("MATNR").equals(formsitems.get("MATNR"))){
                            basisitems.put("giveOrder",formsitems.get("qty"));
                        }
                    }

                }
            }
        }
        return basis;
    }

    @Override
    public List<Map<String, String>> getDayReportBranch(BranchInfoModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        model.setSalesOrg(user.getSalesOrg());
        if(user.getBranchNo()!=null){
            model.setBranchNo(user.getBranchNo());
        }
        if(user.getDealerId()!=null){
            model.setDealerId(user.getDealerId());
        }
        return branchInfoMapper.getDayReportBranch(model);
    }
}
