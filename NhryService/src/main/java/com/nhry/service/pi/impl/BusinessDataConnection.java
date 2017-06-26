package com.nhry.service.pi.impl;

import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.service.pi.pojo.SalesOrderHeader;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.PISuccessMessage;
import com.nhry.webService.client.PISuccessTMessage;
import com.nhry.webService.client.businessData.ZT_BusinessData_MaintainServiceStub;
import com.nhry.webService.client.businessData.functions.*;
import com.nhry.webService.client.businessData.model.Delivery;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by cbz on 7/4/2016.
 */
public class BusinessDataConnection {

    private static final String URL = EnvContant.getSystemConst("PI.BusinessData.URL");
    private static final String SIGN = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.SIGN");
    private static final String EQ = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.OPTION.EQ");
    private static final String I_DELIVERY_D = "D";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger logger = Logger.getLogger(BusinessDataConnection.class);

    public static ZT_BusinessData_MaintainServiceStub getConn() throws AxisFault {
        ZT_BusinessData_MaintainServiceStub stub = new ZT_BusinessData_MaintainServiceStub(URL);
        Options options = stub._getServiceClient().getOptions();
        OptionManager.initializable(options);
        return stub;
    }

    public static PISuccessMessage RequisitionCreate(TMdBranchEx branchEx, Date reqDate, List<Map<String, String>> items, String lgort) {
        logger.info("获取要货单开始" + branchEx.getBranchNo() + "&" + formatter.format(reqDate));
        items.forEach(e->{
            logger.info(e.toString());
        });
        PISuccessMessage successMessage = new PISuccessMessage();
        try {
            ZSD_REQUISITION_CREATE_RFC rfc = new ZSD_REQUISITION_CREATE_RFC();
            ZSD_REQ_EKKO ekko = new ZSD_REQ_EKKO();
            COMP_CODE_type1 comp_code_type1 = new COMP_CODE_type1();
            comp_code_type1.setCOMP_CODE_type0(branchEx.getCompCode());
            ekko.setCOMP_CODE(comp_code_type1);

            DOC_TYPE_type1 doc_type_type1 = new DOC_TYPE_type1();
            doc_type_type1.setDOC_TYPE_type0(branchEx.getDocType());
            ekko.setDOC_TYPE(doc_type_type1);
            String dateString = formatter.format(reqDate);
            com.nhry.webService.client.businessData.functions.Date date = new com.nhry.webService.client.businessData.functions.Date();
            date.setObject(formatter.parse(dateString));
            ekko.setI_DATUM(date);

            PUR_GROUP_type1 pur_group_type1 = new PUR_GROUP_type1();
            pur_group_type1.setPUR_GROUP_type0(branchEx.getPurchGroup());
            ekko.setPUR_GROUP(pur_group_type1);

            SUPPL_PLNT_type1 suppl_plnt_type1 = new SUPPL_PLNT_type1();
            suppl_plnt_type1.setSUPPL_PLNT_type0(branchEx.getSupplPlnt());
            ekko.setSUPPL_PLNT(suppl_plnt_type1);

            PURCH_ORG_type1 purch_org_type1 = new PURCH_ORG_type1();
            purch_org_type1.setPURCH_ORG_type0(branchEx.getPurchOrg());
            ekko.setPURCH_ORG(purch_org_type1);
            rfc.setI_EKKO(ekko);
            IT_ITEM_type0 it_item_type0 = new IT_ITEM_type0();
            int num = 0;
            for (Map<String, String> item : items) {
                String item_no = String.valueOf(item.get("ITEM_NO"));
                String order_no = item.get("ORDER_NO");
                String matnr = item.get("MATNR");
                String qtys = String.valueOf(item.get("SUM_QTY"));
                BigDecimal qty = new BigDecimal(qtys);
                String werks = branchEx.getSupplPlnt();
                String reslo = branchEx.getReslo();
                String base_unit = item.get("BASE_UNIT");
                String branchNo = branchEx.getSupplPlnt();
                ZSSD00019 zssd00019 = new ZSSD00019();
                //TODO 待修改
                EXT_RFX_ITEM_type1 ext_rfx_item_type1 = new EXT_RFX_ITEM_type1();
                ext_rfx_item_type1.setEXT_RFX_ITEM_type0(item_no);
                zssd00019.setEXT_RFX_ITEM(ext_rfx_item_type1);

                EXT_RFX_NUMBER_type1 ext_rfx_number_type1 = new EXT_RFX_NUMBER_type1();
                ext_rfx_number_type1.setEXT_RFX_NUMBER_type0(order_no);
                zssd00019.setEXT_RFX_NUMBER(ext_rfx_number_type1);

                MATNR_type5 matnr_type5 = new MATNR_type5();
                matnr_type5.setMATNR_type4(matnr);
                zssd00019.setMATNR(matnr_type5);

                MEINS_type3 meins_type3 = new MEINS_type3();
                meins_type3.setMEINS_type2(base_unit);
                zssd00019.setMEINS(meins_type3);

                MENGE_type1 menge_type1 = new MENGE_type1();
                menge_type1.setMENGE_type0(qty);
                zssd00019.setMENGE(menge_type1);
                //发货库存地点
                RESLO_type3 reslo_type3 = new RESLO_type3();
                reslo_type3.setRESLO_type2(reslo);//TODO 待修改
                zssd00019.setRESLO(reslo_type3);
                //收货工厂
                WERKS_type5 werks_type5 = new WERKS_type5();
                werks_type5.setWERKS_type4(werks);
                zssd00019.setWERKS(werks_type5);
                //收货库存地点
                LGORT_type5 lgort_type5 = new LGORT_type5();
                lgort_type5.setLGORT_type4(lgort);
                zssd00019.setLGORT(lgort_type5);

                PO_ITEM_type1 po_item_type1 = new PO_ITEM_type1();
                po_item_type1.setPO_ITEM_type0(item_no);
                zssd00019.setPO_ITEM(po_item_type1);
                it_item_type0.addItem(zssd00019);
            }
            rfc.setIT_ITEM(it_item_type0);
            ZSD_REQUISITION_CREATE_RFCResponse response;
            response = BusinessDataConnection.getConn().requisitionCreate(rfc);
            ET_MESSAGE_type1 message = response.getET_MESSAGE();
            BAPIRET2[] bap = message.getItem();
            String result = response.getET_EBELN() != null ? response.getET_EBELN().getET_EBELN_type0() : null;
            StringBuilder msg = new StringBuilder();
            if (StringUtils.isNotEmpty(result)) {
                successMessage.setSuccess(true);
                successMessage.setData(result);
                logger.info("要货单编号" + result);
            } else {
                successMessage.setSuccess(false);
            }
            if (bap != null && bap.length > 0) {
                for (BAPIRET2 bapiret2 : bap) {
//                    BAPIRET2 bapiret2 = bap[0];
                    msg.append(bapiret2.getMESSAGE().getMESSAGE_type0());
                    msg.append(bapiret2.getMESSAGE_V1().getMESSAGE_V1_type0());
                    msg.append(bapiret2.getMESSAGE_V2().getMESSAGE_V2_type0());
                    msg.append(bapiret2.getMESSAGE_V3().getMESSAGE_V3_type0());
                    msg.append(bapiret2.getMESSAGE_V4().getMESSAGE_V4_type0());
                }
                successMessage.setMessage(msg.toString());
                logger.info(message.toString());
            } else {
                successMessage.setMessage("");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            successMessage.setSuccess(false);
            successMessage.setData("");
            successMessage.setMessage("要货单接口异常，请联系管理员");
        }
        logger.info("获取要货单结束！");
        return successMessage;
    }

    public static PISuccessMessage SalesOrderCreate(List<Map<String, String>> items, SalesOrderHeader orderHeader) {
        long begin = System.currentTimeMillis();
        logger.info("获取销售订单开始！" + orderHeader.toString());
        items.forEach(e->{
            logger.info(e.toString());
        });
        PISuccessMessage successMessage = new PISuccessMessage();
        try {
            if(items.size() == 0){
                successMessage.setSuccess(false);
                successMessage.setData("");
                successMessage.setMessage("销售订单没有获取到行项目！");
                return successMessage;
            }
            IT_ZSSD00011_type0 it_zssd00011_type1 = new IT_ZSSD00011_type0();
            for (Map<String, String> map : items) {
                ZSSD00011 zssd00011 = new ZSSD00011();
                //年卡折扣率
                if(map.containsKey("DISCOUNT_AMT")) {
                    BigDecimal amt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
                    if(amt.compareTo(new BigDecimal("0"))>0) {
                        YK01_type1 yk01_type1 = new YK01_type1();
                        yk01_type1.setYK01_type0(amt);
                        zssd00011.setYK01(yk01_type1);
                    }
                }
                if(map.containsKey("YK21")) {
                    BigDecimal amt = new BigDecimal(String.valueOf(map.get("YK21")));
                    if(amt.compareTo(new BigDecimal("0"))>0) {
                        YK21_type1 yk21_type1 = new YK21_type1();
                        yk21_type1.setYK21_type0(amt);
                        zssd00011.setYK21(yk21_type1);
                    }
                }
                MATNR_type1 matnr_type1 = new MATNR_type1();
                matnr_type1.setMATNR_type0(map.get("MATNR"));
                zssd00011.setMATNR(matnr_type1);
                if(map.containsKey("SUM_QTY")) {
                    KWMENG_type1 kwmeng_type1 = new KWMENG_type1();
                    BigDecimal kw = new BigDecimal(String.valueOf(map.get("SUM_QTY")));
                    kwmeng_type1.setKWMENG_type0(kw);
                    zssd00011.setKWMENG(kwmeng_type1);
                }
                if(map.containsKey("BASE_UNIT")) {
                    VRKME_type1 vrkme_type1 = new VRKME_type1();
                    vrkme_type1.setVRKME_type0(map.get("BASE_UNIT"));
                    zssd00011.setVRKME(vrkme_type1);
                }
                if(StringUtils.isNotEmpty(orderHeader.getWerks())) {
                    WERKS_type1 werks_type1 = new WERKS_type1();
                    werks_type1.setWERKS_type0(orderHeader.getWerks());
                    zssd00011.setWERKS(werks_type1);
                }
                if(StringUtils.isNotEmpty(orderHeader.getLgort())) {
                    LGORT_type1 lgort_type1 = new LGORT_type1();
                    lgort_type1.setLGORT_type0(orderHeader.getLgort());
//                lgort_type1.setLGORT_type0("4005");
                    zssd00011.setLGORT(lgort_type1);
                }
                if(map.containsKey("ITEM_NO")) {
                    POSEX_type1 posex_type1 = new POSEX_type1();
                    posex_type1.setPOSEX_type0(String.valueOf(map.get("ITEM_NO")));
                    zssd00011.setPOSEX(posex_type1);
                }
                if (StringUtils.isNotEmpty(map.get("REF_MATNR"))) {
                    PR_REF_MAT_type1 pr_ref_mat_type1 = new PR_REF_MAT_type1();
                    pr_ref_mat_type1.setPR_REF_MAT_type0(map.get("REF_MATNR") == null ? "" : map.get("REF_MATNR"));
                    zssd00011.setPR_REF_MAT(pr_ref_mat_type1);
                }

                com.nhry.webService.client.businessData.functions.Date date1 = new com.nhry.webService.client.businessData.functions.Date();
                date1.setObject(orderHeader.getLFDAT());
                zssd00011.setREQ_DATE(date1);
                if (StringUtils.isNotEmpty(map.get("PROM_NO"))) {
                    WBS_ELEM_type1 wbs_elem_type1 = new WBS_ELEM_type1();
                    wbs_elem_type1.setWBS_ELEM_type0(map.get("PROM_NO"));
                    zssd00011.setWBS_ELEM(wbs_elem_type1);
                }

                if(map.containsKey("PRICE") && map.get("PRICE") != null){
                    KBETR_type1 kbetr_type1 = new KBETR_type1();
                    kbetr_type1.setKBETR_type0(new BigDecimal(String.valueOf(map.get("PRICE"))));
                    zssd00011.setKBETR(kbetr_type1);
                }

                if(map.containsKey("AUGRU")){
                    AUGRU_type3 augru_type3 = new AUGRU_type3();
                    augru_type3.setAUGRU_type2(map.get("AUGRU"));
                    zssd00011.setAUGRU(augru_type3);
                }
                it_zssd00011_type1.addItem(zssd00011);
            }

            ZSD_SALESORDER_DATA_RFC_2 rfc = new ZSD_SALESORDER_DATA_RFC_2();
            rfc.setIT_ZSSD00011(it_zssd00011_type1);
            ZSSD00010 zssd00010 = new ZSSD00010();
            KUNNR_type1 kunnr_type1 = new KUNNR_type1();
            KUNWE_type1 kunwe_type1 = new KUNWE_type1();
            VTWEG_type1 vtweg_type1 = new VTWEG_type1();

            //电商客户编号
            if(StringUtils.isNotEmpty(orderHeader.getKUNWE2())){
                kunnr_type1.setKUNNR_type0(orderHeader.getKUNWE2());
                zssd00010.setKUNNR(kunnr_type1);
                kunwe_type1.setKUNWE_type0(orderHeader.getKUNWE2());
                zssd00010.setKUNWE(kunwe_type1);
                KUNWE2_type1 kunwe2_type1 = new KUNWE2_type1();
                kunwe2_type1.setKUNWE2_type0(orderHeader.getKUNWE());
                zssd00010.setKUNWE2(kunwe2_type1);
//                vtweg_type1.setVTWEG_type0(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG17"));
//                zssd00010.setVTWEG(vtweg_type1);
            }else{
                kunnr_type1.setKUNNR_type0(orderHeader.getKUNNR());
                zssd00010.setKUNNR(kunnr_type1);
                if(StringUtils.isNotEmpty(orderHeader.getKUNWE())) {
                    kunwe_type1.setKUNWE_type0(orderHeader.getKUNWE());
                    zssd00010.setKUNWE(kunwe_type1);
                }
//                vtweg_type1.setVTWEG_type0(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG"));
//                zssd00010.setVTWEG(vtweg_type1);
            }
            vtweg_type1.setVTWEG_type0(orderHeader.getVTWEG());
            zssd00010.setVTWEG(vtweg_type1);

            VKORG_type1 vkorg_type1 = new VKORG_type1();
            vkorg_type1.setVKORG_type0(orderHeader.getVKORG());
            zssd00010.setVKORG(vkorg_type1);

            SPART_type1 spart_type1 = new SPART_type1();
            spart_type1.setSPART_type0(PIPropertitesUtil.getValue("PI.SPART"));
            zssd00010.setSPART(spart_type1);
            AUART_type1 auart_type1 = new AUART_type1();
            auart_type1.setAUART_type0(orderHeader.getAuartType());
            zssd00010.setAUART(auart_type1);
            if(orderHeader.getLFDAT()!=null) {
                String dateString = formatter.format(orderHeader.getLFDAT());
                com.nhry.webService.client.businessData.functions.Date date = new com.nhry.webService.client.businessData.functions.Date();
                date.setObject(formatter.parse(dateString));
                zssd00010.setLFDAT(date);
                zssd00010.setAUDAT(date);
            }
            if(StringUtils.isNotEmpty(orderHeader.getBSTKD())) {
                BSTKD_type1 bstkd_type1 = new BSTKD_type1();
                bstkd_type1.setBSTKD_type0(orderHeader.getBSTKD());
                zssd00010.setBSTKD(bstkd_type1);
            }
            if (StringUtils.isNotEmpty(orderHeader.getActivityId())) {
                CMPGN_EXTID_type1 cmpgn_extid_type1 = new CMPGN_EXTID_type1();
                cmpgn_extid_type1.setCMPGN_EXTID_type0(orderHeader.getActivityId());
                zssd00010.setCMPGN_EXTID(cmpgn_extid_type1);
            }
            if (StringUtils.isNotEmpty(orderHeader.getAugru())) {
                AUGRU_type1 augru_type1 = new AUGRU_type1();
                augru_type1.setAUGRU_type0(orderHeader.getAugru());
                zssd00010.setAUGRU(augru_type1);
            }
            if (StringUtils.isNotEmpty(orderHeader.getZz001())) {
                ZZ001_type1 zz001_type1 = new ZZ001_type1();
                zz001_type1.setZZ001_type0(orderHeader.getZz001());
                zssd00010.setZZ001(zz001_type1);
            }
            if (StringUtils.isNotEmpty(orderHeader.getKostl())) {
                KOSTL_type1 kostl_type1 = new KOSTL_type1();
                kostl_type1.setKOSTL_type0(orderHeader.getKostl());
                zssd00010.setKOSTL(kostl_type1);
            }
            rfc.setIT_ZSSD00010(zssd00010);

            ZSD_SALESORDER_DATA_RFC_2Response response = BusinessDataConnection.getConn().salesOrderCreate(rfc);
            ET_BAPIRETURN1_type1 et_bapirequrn1_type1 = response.getET_BAPIRETURN1();
            BAPIRET2[] bap = et_bapirequrn1_type1.getItem();
            String result = response.getET_VBELN() != null ? response.getET_VBELN().getET_VBELN_type0() : null;
            StringBuilder msg = new StringBuilder();
            if (StringUtils.isNotEmpty(result)) {
                successMessage.setSuccess(true);
                successMessage.setData(result);
            } else {
                successMessage.setSuccess(false);
            }
            if (bap != null && bap.length > 0) {
                for (BAPIRET2 bapiret2 : bap) {
                    msg.append(bapiret2.getMESSAGE().getMESSAGE_type0());
                    msg.append(bapiret2.getMESSAGE_V1().getMESSAGE_V1_type0());
                    msg.append(bapiret2.getMESSAGE_V2().getMESSAGE_V2_type0());
                    msg.append(bapiret2.getMESSAGE_V3().getMESSAGE_V3_type0());
                    msg.append(bapiret2.getMESSAGE_V4().getMESSAGE_V4_type0());
                }
                successMessage.setMessage(msg.toString());
                logger.info(msg.toString());
            } else {
                successMessage.setMessage("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            successMessage.setSuccess(false);
            successMessage.setData("");
            successMessage.setMessage("销售订单接口异常，请联系管理员！");
        }
        long end = System.currentTimeMillis();
        logger.info("获取销售订单结束"+(end - begin));
        return successMessage;
    }

    public static PISuccessTMessage<List<Delivery>> DeliveryQuery(String orderNo, boolean deliveryType, boolean isZy) {
        PISuccessTMessage message = new PISuccessTMessage();
        try {
            ZSD_DELIVERY_DATA zsd_delivery_data = new ZSD_DELIVERY_DATA();
            if (deliveryType) {
                I_DELIVERY_type1 i_delivery_type = new I_DELIVERY_type1();
                i_delivery_type.setI_DELIVERY_type0(I_DELIVERY_D);
                zsd_delivery_data.setI_DELIVERY(i_delivery_type);
            }
            //销售订单/要货单号
            IT_SO_type1 it_so_type1 = new IT_SO_type1();
            ZSSD00068 zssd00068 = new ZSSD00068();
            SIGN_type5 sign_type5 = new SIGN_type5();
            sign_type5.setSIGN_type4(SIGN);
            zssd00068.setSIGN(sign_type5);
            OPTION_type5 option_type5 = new OPTION_type5();
            option_type5.setOPTION_type4(EQ);
            zssd00068.setOPTION(option_type5);
            LOW_type3 low_type3 = new LOW_type3();
            low_type3.setLOW_type2(orderNo);
            zssd00068.setLOW(low_type3);
            it_so_type1.addItem(zssd00068);
            zsd_delivery_data.setIT_SO(it_so_type1);
            ZSD_DELIVERY_DATAResponse response = BusinessDataConnection.getConn().deliveryQuery(zsd_delivery_data);
            ET_DATA_type0 et_data_type0 = response.getET_DATA();
            ZSSD00069[] zssd00069s = et_data_type0.getItem();
            List<Delivery> deliveries = new ArrayList<Delivery>();
            if (zssd00069s != null && zssd00069s.length > 0) {
                for (ZSSD00069 zssd00069 : zssd00069s) {
                    if (zssd00069.getWBSTK() != null && StringUtils.isNotEmpty(zssd00069.getWBSTK().getWBSTK_type0())) {
                        String wbstk = zssd00069.getWBSTK().getWBSTK_type0();
//                        if ("C".equals(wbstk) || isZy) {
                        Delivery delivery = new Delivery();
                        delivery.setWbstk(wbstk);
                        delivery.setKUNNR(zssd00069.getKUNNR().getKUNNR_type2());
                        delivery.setBSTKD(zssd00069.getBSTKD().getBSTKD_type2());
                        delivery.setVBELN(zssd00069.getVBELN().getVBELN_type0());
                        delivery.setPOSNR(zssd00069.getPOSNR().getPOSNR_type0());
                        delivery.setLFIMG(zssd00069.getLFIMG().getLFIMG_type0());
                        delivery.setMEINS(zssd00069.getMEINS().getMEINS_type0());
                        delivery.setKUNAG(zssd00069.getKUNAG().getKUNAG_type0());
                        Object o = zssd00069.getLFDAT().getObject();
                        try {
                            String dateString = formatter.format(o);
                            delivery.setLFDAT(formatter.parse(dateString));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        delivery.setVBELV(zssd00069.getVBELV().getVBELV_type0());
                        delivery.setPOSNV(zssd00069.getPOSNV().getPOSNV_type0());
                        delivery.setLGORT(zssd00069.getLGORT().getLGORT_type2());
                        delivery.setRESLO(zssd00069.getRESLO().getRESLO_type0());
                        delivery.setCmpre(zssd00069.getCMPRE().getCMPRE_type0());
                        delivery.setMATNR(zssd00069.getMATNR().getMATNR_type2());
                        delivery.setPSTYV(zssd00069.getPSTYV().getPSTYV_type2());
                        deliveries.add(delivery);
//                        }
                    }
                }
//                if (deliveries.size() == 0) {
//                    message.setSuccess(false);
//                    message.setMessage("交货单未过账！");
//                }else {
                    message.setSuccess(true);
                    message.setData(deliveries);
//                }
            } else {
                message.setSuccess(false);
                if(isZy){
                    message.setMessage("获取出厂价格失败，销售订单生成失败！");
                }else{
                    message.setMessage("交货单没有生成！");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            message.setMessage(e.getMessage());
            message.setSuccess(false);
        }
        return message;
    }


}
