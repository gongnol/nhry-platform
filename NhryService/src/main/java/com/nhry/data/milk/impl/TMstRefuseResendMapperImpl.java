package com.nhry.data.milk.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.milk.dao.TMstRefuseResendMapper;
import com.nhry.data.milktrans.domain.TMstRefuseResend;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongjk on 2016/10/18.
 */
public class TMstRefuseResendMapperImpl implements TMstRefuseResendMapper {

    private DynamicSqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public int addTMstRefuseResend(TMstRefuseResend resend) {
        return sqlSessionTemplate.insert("addTMstRefuseResend",resend);
    }
    @Override
    public int uptRefuseResend(TMstRefuseResend resend){
        return sqlSessionTemplate.update("uptRefuseResend",resend);
    }

    @Override
    public int delRefuseResendByDispAndMatnr(TMstRefuseResend resend) {
        return sqlSessionTemplate.delete("delRefuseResendByDispAndMatnr",resend);
    }

    @Override
    public List<TMstRefuseResend> findNoUsedRefuseResend(String branchNo) {

        return sqlSessionTemplate.selectList("findNoUsedRefuseResend",branchNo);
    }

    @Override
    public List<TMstRefuseResend> queryRefuseResendByMatnr(String matnr,String branchNo,String reqOrderNo) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("matnr",matnr);
        map.put("branchNo",branchNo);
        map.put("orderNo",reqOrderNo);
        return sqlSessionTemplate.selectList("queryRefuseResendByMatnr",map);
    }

    @Override
    public TMstRefuseResend selectRefuseResendByNo(String resendOrderNo) {
        TMstRefuseResend resend = new TMstRefuseResend();
        resend.setResendOrderNo(resendOrderNo);
        return sqlSessionTemplate.selectOne("selectRefuseResend",resend);
    }

    @Override
    public TMstRefuseResend findByBranchEmpSendDateAndMatnr(String branchNo, String empNo, Date dispDate, String matnr) {
        TMstRefuseResend resend = new TMstRefuseResend();
        resend.setBranchNo(branchNo);
        resend.setEmpNo(empNo);
        resend.setDispDate(dispDate);
        resend.setMatnr(matnr);
        return sqlSessionTemplate.selectOne("selectRefuseResend",resend);
    }

    @Override
    public List<TMstRefuseResend> findNoUsedAndUsedRefuseResend(String branchNo,String orderNo) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("branchNo",branchNo);
        map.put("orderNo",orderNo);
        return sqlSessionTemplate.selectList("findNoUsedAndUsedRefuseResend",map);
    }

    @Override
    public List<TMstRefuseResend> selectRefuseForInside(TMstRefuseResend resend){
        return sqlSessionTemplate.selectList("selectRefuseForInside",resend);
    }

    @Override
    public TMstRefuseResend selectRefuseResendByDispEmpAndMatnr(String dispOrderNo,String empNo,String matnr) {
        TMstRefuseResend resend = new TMstRefuseResend();
        resend.setDispOrderNo(dispOrderNo);
        resend.setEmpNo(empNo);
        resend.setMatnr(matnr);
        return sqlSessionTemplate.selectOne("selectRefuseResend",resend);
    }

    @Override
    public List<TMstRefuseResend> selectUseQtyByEmpNoAndMatnr(String reqOrderNo) {
        return sqlSessionTemplate.selectList("selectUseQtyByEmpNoAndMatnr",reqOrderNo);
    }
}
