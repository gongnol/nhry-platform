package com.nhry.data.milk.dao;

import com.nhry.data.milktrans.domain.TMstRefuseResend;

import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/10/18.
 */
public interface TMstRefuseResendMapper {
    public  int addTMstRefuseResend(TMstRefuseResend  resend);
    public  int  uptRefuseResend(TMstRefuseResend resend);
    public  int delRefuseResendByDispAndMatnr(TMstRefuseResend resend);

    /**
     * 获取奶站下 状态下的 拒收复送信息
     * @param branchNo
     * @return
     */
    List<TMstRefuseResend> findNoUsedRefuseResend(String branchNo);

    List<TMstRefuseResend>  queryRefuseResendByMatnr(String matnr,String branchNo,String reqOrderNo);

    TMstRefuseResend selectRefuseResendByNo(String resendOrderNo);
    TMstRefuseResend findByBranchEmpSendDateAndMatnr(String branchNO, String empNo, Date dispDate,String matnr);

    List<TMstRefuseResend> findNoUsedAndUsedRefuseResend(String branchNo,String orderNo);

    List<TMstRefuseResend> selectRefuseForInside(TMstRefuseResend resend);

    TMstRefuseResend selectRefuseResendByDispEmpAndMatnr(String dispOrderNo,String empNo,String confirmMatnr);

    List<TMstRefuseResend> selectUseQtyByEmpNoAndMatnr(String reqOrderNo);

}
