package com.nhry.data.statistics.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.model.statistics.BranchInfoModel;
import com.nhry.model.statistics.ExtendBranchInfoModel;

import java.util.List;
import java.util.Map;

/**
 * Created by cbz on 7/18/2016.
 */
public interface BranchInfoMapper {
    PageInfo branchDayInfo(BranchInfoModel model);
    Map<String,String> getBranchs(BranchInfoModel model);
    List<Map<String,String>> branchDayInfoList(BranchInfoModel model);
    PageInfo findOrderRatio(BranchInfoModel model);
    PageInfo findBranchMonthReport(BranchInfoModel model);
    PageInfo findReqOrder(BranchInfoModel model);
    List<Map<String,String>> findReqOrderOutput(BranchInfoModel model);
    List<Map<String,String>> branchDayOutput(BranchInfoModel model);
    List<Map<String,String>> findBranchMonthReportOutput(BranchInfoModel model);
    List<Map<String,String>> findOrderRatioOutput(BranchInfoModel model);
    PageInfo findChangeplanStatReport(ExtendBranchInfoModel model);
    PageInfo returnBoxStatReport(ExtendBranchInfoModel model);
    List<Map<String,String>> returnBoxStatList(ExtendBranchInfoModel model);
    PageInfo mstDispNumStat(ExtendBranchInfoModel model);
    PageInfo branchMstDispNumStat(ExtendBranchInfoModel model);
    PageInfo dayMstDispNumStat(ExtendBranchInfoModel model);
    List<Map<String,String>> branchDayRepo(BranchInfoModel model);
    Map<String,String> branchDayQty(BranchInfoModel model);
    List<Map<String,String>> exportOrderByModel(BranchInfoModel model);
    List<Map<String,String>> orderOnlineStatReport(ExtendBranchInfoModel model);
    PageInfo Refuse2receiveResend(ExtendBranchInfoModel model);
    List<Map<String,String>> PendingUnConfirmOnline(String salesOrg);

    List<Map<String,String>> Refuse2receiveResendDetail(String  resendOrderNo);
    List<Map<String,String>> exportDispInlOrderByModel(ExtendBranchInfoModel model);
    List<Map<String,String>> getDayReportBasis(BranchInfoModel model);
    List<Map<String,String>> getDayReportForm(BranchInfoModel model);
    List<Map<String,String>> getDayReportBranch(BranchInfoModel model);
}
