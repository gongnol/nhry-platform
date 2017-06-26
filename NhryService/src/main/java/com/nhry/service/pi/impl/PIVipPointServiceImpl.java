package com.nhry.service.pi.impl;

import com.nhry.model.webService.VipPointModel;
import com.nhry.service.pi.dao.PIVipPointService;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.EvMembPoint;
import com.nhry.webService.client.PISuccessTMessage;
import com.nhry.webService.client.VipPoint.PointQuery_OutServiceStub;
import com.nhry.webService.client.VipPoint.functions.*;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.commons.lang.StringUtils;

/**
 * Created by cbz on 7/6/2016.
 */
public class PIVipPointServiceImpl implements PIVipPointService {
    private static String POINTURL = EnvContant.getSystemConst("PI.VipPointData.URL");
    private static String MESSAGE_FLAG = PIPropertitesUtil.getValue("PI.MESSAGE.FLAG.OK");
    private static String PICRMEXEC = EnvContant.getSystemConst("PI.CRM.EXEC");
    public static void main(String []args){
        System.out.println(POINTURL);
        System.out.println(PICRMEXEC);
    }
    @Override
    public PISuccessTMessage queryVipPointData(VipPointModel model) {
        PISuccessTMessage<java.util.List<EvMembPoint>> result = new PISuccessTMessage<java.util.List<EvMembPoint>>();
        if(!"on".equals(PICRMEXEC)){
            result.setSuccess(false);
            result.setMessage("暂停使用！");
            return result;
        }
        try {
            PointQuery_OutServiceStub client = connQueryService();
            Z_CRM_PT_QUERY_RFC z_crm_pt_query_rfc = new Z_CRM_PT_QUERY_RFC();
            IV_TEL_type1 iv_tel_type1 = new IV_TEL_type1();
            if(StringUtils.isNotEmpty(model.getTel())){
                iv_tel_type1.setIV_TEL_type0(model.getTel());
                z_crm_pt_query_rfc.setIV_TEL(iv_tel_type1);
                z_crm_pt_query_rfc.setIV_TEL(iv_tel_type1);
            }
            if(StringUtils.isNotEmpty(model.getMembGuid())){
                IV_GUID_type1 iv_guid_type1 = new IV_GUID_type1();
                iv_guid_type1.setIV_GUID_type0(model.getMembGuid());
                z_crm_pt_query_rfc.setIV_GUID(iv_guid_type1);
            }
            if(StringUtils.isNotEmpty(model.getMembId())){
                IV_CARD_ID_type1 iv_card_id_type1 = new IV_CARD_ID_type1();
                iv_card_id_type1.setIV_CARD_ID_type0(model.getMembId());
                z_crm_pt_query_rfc.setIV_CARD_ID(iv_card_id_type1);
            }
            Z_CRM_PT_QUERY_RFCResponse response = client.pointQuery_Out(z_crm_pt_query_rfc);
            java.util.List<EvMembPoint> points = new java.util.ArrayList<EvMembPoint>();
            ZSCRM_PT_BALANCE[] balances = response.getT_BALANCE_OUT().getItem();
            if(balances != null){
                for(ZSCRM_PT_BALANCE balance :balances){
                    EvMembPoint point = new EvMembPoint();
                    point.setBalance(balance.getBALANCE().getBALANCE_type0());
                    point.setEvMembId(balance.getMEMB_ID().getMEMB_ID_type0());
                    point.setEvMembGuid(balance.getGUID().getGUID_type0().toString());
                    point.setType(balance.getPT_TYPE().getPT_TYPE_type0());
                    points.add(point);
                }
            }
            String flag = response.getES_RETURN().getFLAG().getFLAG_type0();
            String msg = response.getES_RETURN().getMSG().getMSG_type0();
            result.setData(points);
            result.setSuccess(MESSAGE_FLAG.equals(flag));
            result.setMessage(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 会员积分查询
     * @return
     * @throws AxisFault
     */
    private PointQuery_OutServiceStub connQueryService() throws AxisFault {
        PointQuery_OutServiceStub client = new PointQuery_OutServiceStub(POINTURL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }
}
