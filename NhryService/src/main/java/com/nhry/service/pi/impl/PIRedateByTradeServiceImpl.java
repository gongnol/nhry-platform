package com.nhry.service.pi.impl;

import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.milktrans.domain.TSsmRedateByTrade;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.milktrans.dao.RedateByTradeService;
import com.nhry.service.pi.dao.PIRedateByTradeService;
import com.nhry.service.pi.pojo.SalesOrderHeader;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.PISuccessMessage;
import com.nhry.webService.client.VipInfoData.ZT_CRM_BuData_MaintainServiceStub;
import com.nhry.webService.client.VipInfoData.functions.*;
import com.nhry.webService.client.disCount.OA_BusinessData_OutServiceStub;
import com.nhry.webService.client.disCount.functions.*;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cbz on 12/26/2016.
 */
public class PIRedateByTradeServiceImpl implements PIRedateByTradeService{
    private static String URL = EnvContant.getSystemConst("PI.VipInfoData.URL");
    private static String DISCOUNT_URL = EnvContant.getSystemConst("PI.DISCOUNT.URL");
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private static Logger logger = Logger.getLogger(PIRedateByTradeServiceImpl.class);
    private static String TYPE_CODE = "1017";
    private static String ITEM_CODE = "1";
    private RedateByTradeService redateByTradeService;
    private DictionaryService dictionaryService;
    private TMdBranchMapper branchMapper;

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setRedateByTradeService(RedateByTradeService redateByTradeService) {
        this.redateByTradeService = redateByTradeService;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    /**
     * 销售订单编号 35位
     *
     * @return
     */
    private String generateSal35Id(int i,String branchNo) {
        TMdBranch branch = branchMapper.getBranchByNo(branchNo);
        StringBuilder uuid = new StringBuilder();
        uuid.append("DH001");
        uuid.append("A");
        uuid.append(branch.getCompanyCode());
        uuid.append(branchNo.substring(1));
        uuid.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()));
        uuid.append(new Random().nextInt(80) + 10 + i);
        System.out.println("------------------------" + uuid.toString());
        return uuid.toString();
    }

    @Override
    public String sendRedateByTradeToCRM() {
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode(TYPE_CODE);
        codeItem.setItemCode(ITEM_CODE);
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        String dxpz = codeItem.getItemName();
        String flc = codeItem.getAttr2();
        List<TSsmRedateByTrade> tradeList = redateByTradeService.findNoSendRedateByTrade();
        for(TSsmRedateByTrade trade : tradeList){
            PISuccessMessage message = new PISuccessMessage();
            String dhNo = "";
            //贷项凭证
            if(dxpz.contains(trade.getSalesOrg())){
                List<Map<String, String>> items = new ArrayList<Map<String, String>>();
                SalesOrderHeader orderHeader = new SalesOrderHeader();
                dhNo = generateSal35Id(2,trade.getBranchNo());
                orderHeader.setBSTKD(dhNo);
                orderHeader.setKUNNR(trade.getDealerNo());
                orderHeader.setKUNWE(trade.getBranchNo());
                orderHeader.setActivityId(trade.getPromNo());
                orderHeader.setVKORG(trade.getSalesOrg());
                orderHeader.setAuartType(PIPropertitesUtil.getValue("PI.AUART.ZCR"));
                orderHeader.setVTWEG(PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG13"));
                orderHeader.setLFDAT(new java.util.Date());
                orderHeader.setWerks(trade.getWerks());
                orderHeader.setLgort(trade.getLgort());
                Map<String, String> item = new HashMap<String,String>();
                item.put("MATNR",trade.getMatnr());
                item.put("SUM_QTY","1");
                item.put("KBETR",trade.getRedate().toString());
                item.put("AUGRU","100");
                item.put("PROM_NO",trade.getPromNo());
                items.add(item);
                message = SalesOrderCreate(items,orderHeader);
            }
            //返利池
            if(flc.contains(trade.getSalesOrg())){
                List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
                Map<String,Object> item = new HashMap<String,Object>();
                item.put("branchNo",trade.getBranchNo());
                item.put("redate",trade.getRedate());
                items.add(item);
                message = createRebateByTrade(trade.getPromNo(),trade.getOrderNo(),"ddddd",items);
            }
            if(message.isSuccess()){
                TSsmRedateByTrade t = new TSsmRedateByTrade();
                t.setOrderNo(trade.getOrderNo());
                t.setDhNo(dhNo);
                t.setCrmNo(message.getData().toString());
                t.setLastModified(new java.util.Date());
                redateByTradeService.update(t);
            }else{
                logger.error(message.getMessage()+trade.getOrderNo()+trade.getPromNo());
            }
        }
        return "1";
    }

    /**
     * 会员信息接口连接
     *
     * @return
     * @throws AxisFault
     */
    private ZT_CRM_BuData_MaintainServiceStub connMaintainService() throws AxisFault {
        ZT_CRM_BuData_MaintainServiceStub client = new ZT_CRM_BuData_MaintainServiceStub(URL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    /**
     * 贷项凭证
     * @return
     * @throws AxisFault
     */
    private OA_BusinessData_OutServiceStub connBusinessDataService() throws AxisFault {
        OA_BusinessData_OutServiceStub client = new OA_BusinessData_OutServiceStub(DISCOUNT_URL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    private PISuccessMessage createRebateByTrade(String prom, String dhNo,String des, List<Map<String,Object>> items) {
        PISuccessMessage message = new PISuccessMessage();
        try {
            Z_CRM_CREATE_REBATE_BY_TRADE params = new Z_CRM_CREATE_REBATE_BY_TRADE();
            IV_EXTERNAL_ID_type1 externalId = new IV_EXTERNAL_ID_type1();
            externalId.setIV_EXTERNAL_ID_type0(prom);
            params.setIV_EXTERNAL_ID(externalId);
            IV_DESCRIPTION_type1 description = new IV_DESCRIPTION_type1();
            description.setIV_DESCRIPTION_type0(des);
            params.setIV_DESCRIPTION(description);
            IV_PROM_ID_type1 promId = new IV_PROM_ID_type1();
            promId.setIV_PROM_ID_type0(dhNo);
            params.setIV_PROM_ID(promId);
            IT_REBATE_TAB_type0 rebateTab = new IT_REBATE_TAB_type0();
            items.forEach(e->{
                String branchNo = String.valueOf(e.get("branchNo"));
                BigDecimal redate = new BigDecimal(String.valueOf(e.get("redate")));
                ZSCRM_ZTAB0000JQ jq = new ZSCRM_ZTAB0000JQ();
                ZZFLD0000A7_type1 a7 = new ZZFLD0000A7_type1();
                a7.setZZFLD0000A7_type0(redate);
                jq.setZZFLD0000A7(a7);
                ZZFLD0000DE_type1 de = new ZZFLD0000DE_type1();
                de.setZZFLD0000DE_type0(branchNo);
                jq.setZZFLD0000DE(de);
                rebateTab.addItem(jq);
            });
            params.setIT_REBATE_TAB(rebateTab);
            Z_CRM_CREATE_REBATE_BY_TRADEResponse response = connMaintainService().createRebateByTrade(params);
            String msg = response.getEV_MESSAGE().getEV_MESSAGE_type0();
            String crmId = response.getEV_OBJECT_ID().getEV_OBJECT_ID_type0();
            if(StringUtils.isNotEmpty(crmId)){
                message.setSuccess(true);
                message.setMessage(msg);
                message.setData(crmId);
            }else{
                message.setSuccess(false);
                message.setMessage(msg);
            }
        }catch (Exception e){
            message.setSuccess(false);
            message.setMessage(e.getMessage());
        }
        return message;
    }

    private PISuccessMessage SalesOrderCreate(List<Map<String, String>> items, SalesOrderHeader orderHeader) {
        long begin = System.currentTimeMillis();
        logger.info("获取贷项凭证开始！" + orderHeader.toString());
        items.forEach(e->{
            logger.info(e.toString());
        });
        PISuccessMessage successMessage = new PISuccessMessage();
        try {
            if(items.size() == 0){
                successMessage.setSuccess(false);
                successMessage.setData("");
                successMessage.setMessage("贷项凭证没有获取到行项目！");
                return successMessage;
            }
            IT_ZSSD00011_type1 it_zssd00011_type1 = new IT_ZSSD00011_type1();
            for (Map<String, String> map : items) {
                ZSSD00011 zssd00011 = new ZSSD00011();
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

                com.nhry.webService.client.disCount.functions.Date date1 = new com.nhry.webService.client.disCount.functions.Date();
                date1.setObject(orderHeader.getLFDAT());
                zssd00011.setREQ_DATE(date1);
                if (StringUtils.isNotEmpty(map.get("PROM_NO"))) {
                    WBS_ELEM_type1 wbs_elem_type1 = new WBS_ELEM_type1();
                    wbs_elem_type1.setWBS_ELEM_type0(map.get("PROM_NO"));
                    zssd00011.setWBS_ELEM(wbs_elem_type1);
                }

                if(map.containsKey("KBETR")){
                    KBETR_type1 kbetr_type1 = new KBETR_type1();
                    kbetr_type1.setKBETR_type0(new BigDecimal(String.valueOf(map.get("KBETR"))));
                    zssd00011.setKBETR(kbetr_type1);
                }

                if(map.containsKey("AUGRU")){
                    AUGRU_type1 augru_type3 = new AUGRU_type1();
                    augru_type3.setAUGRU_type0(map.get("AUGRU"));
                    zssd00011.setAUGRU(augru_type3);
                }
                it_zssd00011_type1.addItem(zssd00011);
            }

            ZSD_SALESORDER_DATA_RFC_5 rfc = new ZSD_SALESORDER_DATA_RFC_5();
            rfc.setIT_ZSSD00011(it_zssd00011_type1);
            ZSSD00010 zssd00010 = new ZSSD00010();
            KUNNR_type1 kunnr_type1 = new KUNNR_type1();
            KUNWE_type1 kunwe_type1 = new KUNWE_type1();
            VTWEG_type1 vtweg_type1 = new VTWEG_type1();


            kunnr_type1.setKUNNR_type0(orderHeader.getKUNNR());
            zssd00010.setKUNNR(kunnr_type1);

            if(StringUtils.isNotEmpty(orderHeader.getKUNWE())) {
                kunwe_type1.setKUNWE_type0(orderHeader.getKUNWE());
                zssd00010.setKUNWE(kunwe_type1);
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
                com.nhry.webService.client.disCount.functions.Date date = new com.nhry.webService.client.disCount.functions.Date();
                date.setObject(formatter.parse(dateString));
                zssd00010.setLFDAT(date);
                zssd00010.setAUDAT(date);
            }
            if(StringUtils.isNotEmpty(orderHeader.getBSTKD())) {
                BSTKD_type1 bstkd_type1 = new BSTKD_type1();
                bstkd_type1.setBSTKD_type0(orderHeader.getBSTKD());
                zssd00010.setBSTKD(bstkd_type1);
            }
//            if (StringUtils.isNotEmpty(orderHeader.getActivityId())) {
//                CMPGN_EXTID_type1 cmpgn_extid_type1 = new CMPGN_EXTID_type1();
//                cmpgn_extid_type1.setCMPGN_EXTID_type0(orderHeader.getActivityId());
//                zssd00010.setCMPGN_EXTID(cmpgn_extid_type1);
//            }
            if (StringUtils.isNotEmpty(orderHeader.getAugru())) {
                AUGRU_type3 augru_type1 = new AUGRU_type3();
                augru_type1.setAUGRU_type2(orderHeader.getAugru());
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

            ZSD_SALESORDER_DATA_RFC_5Response response = connBusinessDataService().zSD_SALESORDER_DATA_RFC_5(rfc);
            ET_BAPIRETURN1_type0 et_bapirequrn1_type1 = response.getET_BAPIRETURN1();
            BAPIRETURN1[] bap = et_bapirequrn1_type1.getItem();
            String result = response.getET_VBELN() != null ? response.getET_VBELN().getET_VBELN_type0() : null;
            StringBuilder msg = new StringBuilder();
            if (StringUtils.isNotEmpty(result)) {
                successMessage.setSuccess(true);
                successMessage.setData(result);
            } else {
                successMessage.setSuccess(false);
            }
            if (bap != null && bap.length > 0) {
                for (BAPIRETURN1 bapiret2 : bap) {
                    msg.append(bapiret2.getMESSAGE().getMESSAGE_type2());
                    msg.append(bapiret2.getMESSAGE_V1().getMESSAGE_V1_type2());
                    msg.append(bapiret2.getMESSAGE_V2().getMESSAGE_V2_type2());
                    msg.append(bapiret2.getMESSAGE_V3().getMESSAGE_V3_type2());
                    msg.append(bapiret2.getMESSAGE_V4().getMESSAGE_V4_type2());
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
            successMessage.setMessage("贷项凭证接口异常，请联系管理员！");
        }
        long end = System.currentTimeMillis();
        logger.info("获取贷项凭证结束"+(end - begin));
        return successMessage;
    }
}
