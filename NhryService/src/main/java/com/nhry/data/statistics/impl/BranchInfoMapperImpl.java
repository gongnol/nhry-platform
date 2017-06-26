package com.nhry.data.statistics.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.statistics.dao.BranchInfoMapper;
import com.nhry.model.statistics.BranchInfoModel;
import com.nhry.model.statistics.ExtendBranchInfoModel;

import java.util.List;
import java.util.Map;

/**
 * Created by cbz on 7/18/2016.
 */
public class BranchInfoMapperImpl implements BranchInfoMapper{

    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public PageInfo branchDayInfo(BranchInfoModel model) {
        return sqlSessionTemplate.selectListByPages("branchDayInfo",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }

    @Override
    public Map<String, String> getBranchs(BranchInfoModel model) {
        return null;
    }

    @Override
    public List<Map<String, String>> branchDayInfoList(BranchInfoModel model) {
        return sqlSessionTemplate.selectList("branchDayInfoList",model);
    }

    @Override
    public PageInfo findOrderRatio(BranchInfoModel model) {
        return sqlSessionTemplate.selectListByPages("findOrderRatio",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }

    @Override
    public PageInfo findBranchMonthReport(BranchInfoModel model) {
        return sqlSessionTemplate.selectListByPages("findBranchMonthReport",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }

    @Override
    public PageInfo findReqOrder(BranchInfoModel model) {
        return sqlSessionTemplate.selectListByPages("findReqOrder",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }
    @Override
    public List<Map<String, String>> findReqOrderOutput(BranchInfoModel model){
        return sqlSessionTemplate.selectList("findReqOrder",model);
    }

    @Override
    public List<Map<String, String>> branchDayOutput(BranchInfoModel model){
        return sqlSessionTemplate.selectList("branchDayInfo",model);
    }

    @Override
    public List<Map<String, String>> findBranchMonthReportOutput(BranchInfoModel model){
        return sqlSessionTemplate.selectList("findBranchMonthReport",model);
    }

    @Override
    public List<Map<String, String>> findOrderRatioOutput(BranchInfoModel model){
        return sqlSessionTemplate.selectList("findOrderRatio",model);
    }
    @Override
    public PageInfo findChangeplanStatReport(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectListByPages("changeplanStatReport",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }
    @Override
    public PageInfo returnBoxStatReport(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectListByPages("returnBoxStatReport",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }

    @Override
    public List<Map<String, String>> returnBoxStatList(ExtendBranchInfoModel model) {
        return sqlSessionTemplate.selectList("returnBoxStatReport",model);
    }

    @Override
    public PageInfo mstDispNumStat(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectListByPages("mstDispNumStat",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }
    @Override
    public PageInfo branchMstDispNumStat(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectListByPages("branchMstDispNumStat",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }
    @Override
    public PageInfo dayMstDispNumStat(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectListByPages("dayMstDispNumStat",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }
    @Override
    public List<Map<String, String>> branchDayRepo(BranchInfoModel model){
        return sqlSessionTemplate.selectList("branchDayRepo",model);
    }
    @Override
    public Map<String, String> branchDayQty(BranchInfoModel model){
        return sqlSessionTemplate.selectOne("branchDayQty",model);
    }

    @Override
    public List<Map<String, String>> exportOrderByModel(BranchInfoModel model) {
        return sqlSessionTemplate.selectList("exportOrderByModel",model);
    }

    @Override
    public List<Map<String,String>> orderOnlineStatReport(ExtendBranchInfoModel model){
        return sqlSessionTemplate.selectList("orderOnlineStatReport",model);
    }
    @Override
    public PageInfo Refuse2receiveResend(ExtendBranchInfoModel model) {
        return sqlSessionTemplate.selectListByPages("Refuse2receiveResend",model,Integer.valueOf(model.getPageNum()),Integer.valueOf(model.getPageSize()));
    }

    @Override
    public List<Map<String,String>> Refuse2receiveResendDetail(String  resendOrderNo){
        return sqlSessionTemplate.selectList("Refuse2receiveResendDetail",resendOrderNo);

    }

    @Override
    public  List<Map<String,String>> PendingUnConfirmOnline(String salesOrg){
        return sqlSessionTemplate.selectList("PendingUnConfirmOnline",salesOrg);
    }

    /**
     * 台帐-每日配送统计
     * @param model
     * @return
     */
    @Override
    public List<Map<String, String>> exportDispInlOrderByModel(ExtendBranchInfoModel model) {
        return sqlSessionTemplate.selectList("exportDispInlOrderByModel",model);
    }

    @Override
    public List<Map<String, String>> getDayReportBasis(BranchInfoModel model) {
        return sqlSessionTemplate.selectList("getDayReportBasis",model);
    }

    @Override
    public List<Map<String, String>> getDayReportForm(BranchInfoModel model) {
        return sqlSessionTemplate.selectList("getDayReportForm",model);
    }

    @Override
    public List<Map<String, String>> getDayReportBranch(BranchInfoModel model) {
        return sqlSessionTemplate.selectList("getDayReportBranch",model);
    }
}
