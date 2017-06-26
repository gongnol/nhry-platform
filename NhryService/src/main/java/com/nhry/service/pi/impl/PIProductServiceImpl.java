package com.nhry.service.pi.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.axis2.client.Options;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.basic.dao.PIProductMapper;
import com.nhry.data.basic.dao.TMdBranchExMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.dao.TMdDealerMapper;
import com.nhry.data.basic.dao.TMdMaraMapper;
import com.nhry.data.basic.dao.TMdMaraUnitMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.data.basic.domain.TMdDealer;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.basic.domain.TMdMaraUnit;
import com.nhry.data.basic.domain.TMdMaraUnitKey;
import com.nhry.data.config.dao.NHSysCodeItemMapper;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.stud.dao.TMdSchoolMapper;
import com.nhry.data.stud.domain.TMdMaraStud;
import com.nhry.data.stud.domain.TMdSchool;
import com.nhry.data.stud.impl.TMdMaraStudMapperImpl;
import com.nhry.service.basic.dao.TSysMessageService;
import com.nhry.service.external.dao.EcService;
import com.nhry.service.pi.dao.PIProductService;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.Supplier.OA_MasterData_OutServiceStub;
import com.nhry.webService.client.Supplier.functions.ET_LIFNR_type0;
import com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNR;
import com.nhry.webService.client.Supplier.functions.ZMM_MC_ET_LIFNRResponse;
import com.nhry.webService.client.Supplier.functions.ZSMM00013;
import com.nhry.webService.client.masterData.ZT_MasterDataQueryServiceStub;
import com.nhry.webService.client.masterData.functions.ET_DATA_type0;
import com.nhry.webService.client.masterData.functions.ET_KNVP_type1;
import com.nhry.webService.client.masterData.functions.ET_KUNNR_type1;
import com.nhry.webService.client.masterData.functions.ET_LGORT_type0;
import com.nhry.webService.client.masterData.functions.ET_MAKTX_type1;
import com.nhry.webService.client.masterData.functions.ET_MARM_type1;
import com.nhry.webService.client.masterData.functions.ET_MATNR_type1;
import com.nhry.webService.client.masterData.functions.ET_PARTNER_type1;
import com.nhry.webService.client.masterData.functions.ET_ZTMM00037_type1;
import com.nhry.webService.client.masterData.functions.HIGH_type9;
import com.nhry.webService.client.masterData.functions.IT_KUNNR_type0;
import com.nhry.webService.client.masterData.functions.IT_MTART_type0;
import com.nhry.webService.client.masterData.functions.IT_VTWEG_type0;
import com.nhry.webService.client.masterData.functions.IT_VTWEG_type1;
import com.nhry.webService.client.masterData.functions.KNVP;
import com.nhry.webService.client.masterData.functions.LOW_type3;
import com.nhry.webService.client.masterData.functions.LOW_type5;
import com.nhry.webService.client.masterData.functions.LOW_type9;
import com.nhry.webService.client.masterData.functions.MARM;
import com.nhry.webService.client.masterData.functions.OPTION_type3;
import com.nhry.webService.client.masterData.functions.OPTION_type5;
import com.nhry.webService.client.masterData.functions.OPTION_type9;
import com.nhry.webService.client.masterData.functions.SIGN_type3;
import com.nhry.webService.client.masterData.functions.SIGN_type5;
import com.nhry.webService.client.masterData.functions.SIGN_type9;
import com.nhry.webService.client.masterData.functions.T001L;
import com.nhry.webService.client.masterData.functions.T024;
import com.nhry.webService.client.masterData.functions.T024E;
import com.nhry.webService.client.masterData.functions.VTWEG_type3;
import com.nhry.webService.client.masterData.functions.ZMM_POS_24DATA;
import com.nhry.webService.client.masterData.functions.ZMM_POS_24DATAResponse;
import com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFC;
import com.nhry.webService.client.masterData.functions.ZSD_CUSTOMER_DATA_SYN_RFCResponse;
import com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFC;
import com.nhry.webService.client.masterData.functions.ZSD_MATERAIL_DATA_RFCResponse;
import com.nhry.webService.client.masterData.functions.ZSD_SALES_ORGANIZATION_RFC;
import com.nhry.webService.client.masterData.functions.ZSD_SALES_ORGANIZATION_RFCResponse;
import com.nhry.webService.client.masterData.functions.ZSD_T005_DATA;
import com.nhry.webService.client.masterData.functions.ZSD_T005_DATAResponse;
import com.nhry.webService.client.masterData.functions.ZSSD00002;
import com.nhry.webService.client.masterData.functions.ZSSD00003;
import com.nhry.webService.client.masterData.functions.ZSSD00005;
import com.nhry.webService.client.masterData.functions.ZSSD00006;
import com.nhry.webService.client.masterData.functions.ZSSD00008;
import com.nhry.webService.client.masterData.functions.ZSSD00023;
import com.nhry.webService.client.masterData.functions.ZSSD00024;
import com.nhry.webService.client.masterData.functions.ZSSD00025;
import com.nhry.webService.client.masterData.functions.ZSSD00027;
import com.nhry.webService.client.masterData.functions.ZSSD00030;
import com.nhry.webService.client.masterData.functions.ZSSD00071;
import com.nhry.webService.client.masterData.functions.ZTMM00037;
import com.nhry.webService.client.masterData.functions.ZTSD00024;
import com.nhry.webService.client.masterData.model.ET_KNVP;
import com.nhry.webService.client.masterData.model.ET_KUNNR;
import com.nhry.webService.client.masterData.model.ET_LGORT;
import com.nhry.webService.client.masterData.model.ET_MATNR;
import com.nhry.webService.client.masterData.model.ET_PARTNER;
import com.nhry.webService.client.masterData.model.ET_VKORG;

/**
 * Created by cbz on 6/21/2016.
 */
@SuppressWarnings("unchecked")
public class PIProductServiceImpl implements PIProductService {
    private static Logger logger = Logger.getLogger(PIProductServiceImpl.class);
    public static String URL = EnvContant.getSystemConst("PI.MasterData.URL");
    public static String SUPPLIER_URL = EnvContant.getSystemConst("PI_SUPPLIER.URL");
    public static String VKORG = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG13");
    public static String VKORG18 = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.VKORG18");
    public static String OPTION = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.OPTION.EQ");
    public static String SIGN = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.SIGN");
    public static String LOW = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.LOW");
    public static String ZORM = PIPropertitesUtil.getValue("PI.MasterData.mATQUERY.ZORM");
    public static String PRODH = PIPropertitesUtil.getValue("PI.PRODH");
    public static String CANCELSALESORG = PIPropertitesUtil.getValue("PI.CANCEL_SALEORG");
    public static String BRANDCHTYPE_ZY = "01";
    public static String BRANDCHTYPE_WB = "02";
    private PIProductMapper piProductMapper;
    private TMdMaraMapper maraMapper;
    private TMdBranchMapper branchMapper;
    private TMdBranchExMapper branchExMapper;
    private TMdDealerMapper dealerMapper;
    private TMdMaraUnitMapper maraUnitMapper;
    private NHSysCodeItemMapper codeItemMapper;
    private TSysMessageService messageService;
    private TaskExecutor taskExecutor;
    private EcService ecService;
    
    
    @Autowired
    private TMdMaraStudMapperImpl tMdMaraStudMapper; 
    
    @Autowired
    private TMdSchoolMapper schoolMapper;
    
    @Autowired
    private NHSysCodeItemMapper nHSysCodeItemMapper;
    
    public void setMessageService(TSysMessageService messageService) {
        this.messageService = messageService;
    }

    public void setBranchExMapper(TMdBranchExMapper branchExMapper) {
        this.branchExMapper = branchExMapper;
    }

    public void setMaraMapper(TMdMaraMapper maraMapper) {
        this.maraMapper = maraMapper;
    }

    public void setPiProductMapper(PIProductMapper piProductMapper) {
        this.piProductMapper = piProductMapper;
    }

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setDealerMapper(TMdDealerMapper dealerMapper) {
        this.dealerMapper = dealerMapper;
    }

    public void setMaraUnitMapper(TMdMaraUnitMapper maraUnitMapper) {
        this.maraUnitMapper = maraUnitMapper;
    }

    public void setCodeItemMapper(NHSysCodeItemMapper codeItemMapper) {
        this.codeItemMapper = codeItemMapper;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void setEcService(EcService ecService) {
        this.ecService = ecService;
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public EcService getEcService() {
        return ecService;
    }

    /**
     * 物料查询
     *
     * @return
     */
    @Override
    public int matHandler() {
        logger.info("物料接口调用开始");
        try{
        	//13渠道接口
        	matHandler13();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("物料接口调用报错！" + e.getMessage());
            return 0;
        }
        logger.info("物料接口调用结束");
        return 1;
    }
    
    /**
     * 物料查询
     *
     * @return
     */
    @Override
    public int studMatHandler() {
        logger.info("学生奶物料接口调用开始");
        try{
        	//18渠道获取
        	matHandler18();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("物料接口调用报错！" + e.getMessage());
            return 0;
        }
        logger.info("物料接口调用结束");
        return 1;
    }
    
    
    private  int matHandler13() throws RemoteException{
         ZSD_MATERAIL_DATA_RFCResponse response = getMaterailData(VKORG);
         MARM[] marms = response.getET_MARM().getItem();
         List<ET_MATNR> etMatnrs = getET_MATNR(response,VKORG);
         Map<String, String> etMap = getET_MAKTX(response);
         Map<String, String> matnrUnit = new HashMap<String, String>();
         Map<String, ZTMM00037> ztmm00037Map = getET_ZTMM00037(response);
         for (ET_MATNR etMatnr : etMatnrs) {
             matnrUnit.put(etMatnr.getMATNR(), etMatnr.getMEINS());
             Map<String, String> mara = new HashMap<String, String>();
             mara.put("salesOrg", etMatnr.getVKORG());
             mara.put("matnr", etMatnr.getMATNR());
             TMdMara tMdMara = maraMapper.selectProductByCode(mara);
             
             ZTMM00037 ztmm00037 = ztmm00037Map.get(etMatnr.getMATNR());
             if (tMdMara != null) {
                 tMdMara.setBaseUnit(etMatnr.getMEINS());
                 tMdMara.setWeight(etMatnr.getNTGEW() == null ? null : etMatnr.getNTGEW().floatValue());
                 tMdMara.setWeightUnit(etMatnr.getGEWEI());
                 tMdMara.setMatnrTxt(etMap.get(etMatnr.getMATNR()));
                 tMdMara.setLastModified(new java.util.Date());
                 if (ztmm00037 != null) {
                     tMdMara.setFirstCat(ztmm00037.getPRDL1().getPRDL1_type0());
                     tMdMara.setSecCate(ztmm00037.getPRDL2().getPRDL2_type0());
                     tMdMara.setSpec(ztmm00037.getFRMAT().getFRMAT_type0());
                     tMdMara.setSpecUnit(ztmm00037.getMEINS().getMEINS_type4());
                     tMdMara.setZbotCode(ztmm00037.getPACK1().getPACK1_type0());
                     tMdMara.setImportantPrdFlag(ztmm00037.getCLASF().getCLASF_type0());
                     tMdMara.setBrand(ztmm00037.getBRANF().getBRANF_type0());
                 }
                 maraMapper.updateProduct(tMdMara);
             } else {
                 tMdMara = new TMdMara();
                 tMdMara.setMatnr(etMatnr.getMATNR());
                 tMdMara.setSalesOrg(etMatnr.getVKORG());
                 tMdMara.setBaseUnit(etMatnr.getMEINS());
                 tMdMara.setWeight(etMatnr.getNTGEW() == null ? null : etMatnr.getNTGEW().floatValue());
                 tMdMara.setWeightUnit(etMatnr.getGEWEI());
                 tMdMara.setMatnrTxt(etMap.get(etMatnr.getMATNR()));
                 tMdMara.setCreateAt(new Date());
                 if (ztmm00037 != null) {
                     tMdMara.setFirstCat(ztmm00037.getPRDL1().getPRDL1_type0());
                     tMdMara.setSecCate(ztmm00037.getPRDL2().getPRDL2_type0());
                     tMdMara.setSpec(ztmm00037.getFRMAT().getFRMAT_type0());
                     tMdMara.setSpecUnit(ztmm00037.getMEINS().getMEINS_type4());
                     tMdMara.setZbotCode(ztmm00037.getPACK1().getPACK1_type0());
                     tMdMara.setImportantPrdFlag(ztmm00037.getCLASF().getCLASF_type0());
                     tMdMara.setBrand(ztmm00037.getBRANF().getBRANF_type0());
                 }
                 tMdMara.setStatus("N");//不生效
                 maraMapper.addProduct(tMdMara);
                 messageService.sendMessagesForCreateProducts(tMdMara);
             }
         }
         saveMatMarm(marms, matnrUnit);
         Map<String, String> prdl1Map = new HashMap<String, String>();
         Map<String, String> prdl2Map = new HashMap<String, String>();
         Map<String, String> branfMap = new HashMap<String, String>();
         Map<String, String> frmatMap = new HashMap<String, String>();
         Map<String, String> pack1Map = new HashMap<String, String>();
         Map<String, String> clasfMap = new HashMap<String, String>();
         for (Map.Entry<String, ZTMM00037> entry : ztmm00037Map.entrySet()) {
             ZTMM00037 ztmm00037 = entry.getValue();
             if (StringUtils.isNotEmpty(ztmm00037.getPRDL1().getPRDL1_type0()))
                 prdl1Map.put(ztmm00037.getPRDL1().getPRDL1_type0(), ztmm00037.getPRDLD().getPRDLD_type0());
             if (StringUtils.isNotEmpty(ztmm00037.getPRDL2().getPRDL2_type0()))
                 prdl2Map.put(ztmm00037.getPRDL2().getPRDL2_type0(), ztmm00037.getPRDLT().getPRDLT_type0());
             if (StringUtils.isNotEmpty(ztmm00037.getBRANF().getBRANF_type0()))
                 branfMap.put(ztmm00037.getBRANF().getBRANF_type0(), ztmm00037.getBRANS().getBRANS_type0());
             if (StringUtils.isNotEmpty(ztmm00037.getFRMAT().getFRMAT_type0()))
                 frmatMap.put(ztmm00037.getFRMAT().getFRMAT_type0(), ztmm00037.getFRMAD().getFRMAD_type0());
             if (StringUtils.isNotEmpty(ztmm00037.getPACK1().getPACK1_type0()))
                 pack1Map.put(ztmm00037.getPACK1().getPACK1_type0(), ztmm00037.getPACKD().getPACKD_type0());
             if (StringUtils.isNotEmpty(ztmm00037.getCLASF().getCLASF_type0()))
                 clasfMap.put(ztmm00037.getCLASF().getCLASF_type0(), ztmm00037.getCLAST().getCLAST_type0());
         }
         saveDL(prdl1Map, "2000"); //大类
         saveDL(prdl2Map, "2001"); //中类
         saveDL(branfMap, "2002"); //产品品牌
         saveDL(frmatMap, "2003"); //规格
         saveDL(pack1Map, "2004");//包装类型
         saveDL(clasfMap, "2005");//重点产品分类
         return 1;
    }
  
    private  int matHandler18() {
        logger.info("物料接口调用开始");
        try {
            ZSD_MATERAIL_DATA_RFCResponse response = getMaterailData(VKORG18);
            MARM[] marms = response.getET_MARM().getItem();
            List<ET_MATNR> etMatnrs = getET_MATNR(response,VKORG18);
            Map<String, String> etMap = getET_MAKTX(response);
            Map<String, String> matnrUnit = new HashMap<String, String>();
            Map<String, ZTMM00037> ztmm00037Map = getET_ZTMM00037(response);
            for (ET_MATNR etMatnr : etMatnrs) {
                matnrUnit.put(etMatnr.getMATNR(), etMatnr.getMEINS());
                Map<String, String> mara = new HashMap<String, String>();
                mara.put("salesOrg", etMatnr.getVKORG());
                mara.put("matnr", etMatnr.getMATNR());
                TMdMaraStud tMdMara = tMdMaraStudMapper.selectProductByCode(mara);
                ZTMM00037 ztmm00037 = ztmm00037Map.get(etMatnr.getMATNR());
                if (tMdMara != null) {
                    tMdMara.setBaseUnit(etMatnr.getMEINS());
                    tMdMara.setWeight(etMatnr.getNTGEW() == null ? null : etMatnr.getNTGEW().floatValue());
                    tMdMara.setWeightUnit(etMatnr.getGEWEI());
                    tMdMara.setMatnrTxt(etMap.get(etMatnr.getMATNR()));
                    tMdMara.setLastModified(new java.util.Date());
                    if (ztmm00037 != null) {
                        tMdMara.setFirstCat(ztmm00037.getPRDL1().getPRDL1_type0());
                        tMdMara.setSecCate(ztmm00037.getPRDL2().getPRDL2_type0());
                        tMdMara.setSpec(ztmm00037.getFRMAT().getFRMAT_type0());
                        tMdMara.setSpecUnit(ztmm00037.getMEINS().getMEINS_type4());
                        tMdMara.setZbotCode(ztmm00037.getPACK1().getPACK1_type0());
                        tMdMara.setImportantPrdFlag(ztmm00037.getCLASF().getCLASF_type0());
                        tMdMara.setBrand(ztmm00037.getBRANF().getBRANF_type0());
                    }
                    tMdMaraStudMapper.updateProduct(tMdMara);
                } else {
                    tMdMara = new TMdMaraStud();
                    tMdMara.setMatnr(etMatnr.getMATNR());
                    tMdMara.setSalesOrg(etMatnr.getVKORG());
                    tMdMara.setBaseUnit(etMatnr.getMEINS());
                    tMdMara.setWeight(etMatnr.getNTGEW() == null ? null : etMatnr.getNTGEW().floatValue());
                    tMdMara.setWeightUnit(etMatnr.getGEWEI());
                    tMdMara.setMatnrTxt(etMap.get(etMatnr.getMATNR()));
                    tMdMara.setCreateAt(new Date());
                    if (ztmm00037 != null) {
                        tMdMara.setFirstCat(ztmm00037.getPRDL1().getPRDL1_type0());
                        tMdMara.setSecCate(ztmm00037.getPRDL2().getPRDL2_type0());
                        tMdMara.setSpec(ztmm00037.getFRMAT().getFRMAT_type0());
                        tMdMara.setSpecUnit(ztmm00037.getMEINS().getMEINS_type4());
                        tMdMara.setZbotCode(ztmm00037.getPACK1().getPACK1_type0());
                        tMdMara.setImportantPrdFlag(ztmm00037.getCLASF().getCLASF_type0());
                        tMdMara.setBrand(ztmm00037.getBRANF().getBRANF_type0());
                    }
                    tMdMara.setStatus("N");//不生效
                    tMdMaraStudMapper.addProduct(tMdMara);
                    messageService.sendMessagesForCreateProducts(tMdMara);
                }
            }
            saveMatMarm(marms, matnrUnit);
            Map<String, String> prdl1Map = new HashMap<String, String>();
            Map<String, String> prdl2Map = new HashMap<String, String>();
            Map<String, String> branfMap = new HashMap<String, String>();
            Map<String, String> frmatMap = new HashMap<String, String>();
            Map<String, String> pack1Map = new HashMap<String, String>();
            Map<String, String> clasfMap = new HashMap<String, String>();
            for (Map.Entry<String, ZTMM00037> entry : ztmm00037Map.entrySet()) {
                ZTMM00037 ztmm00037 = entry.getValue();
                if (StringUtils.isNotEmpty(ztmm00037.getPRDL1().getPRDL1_type0()))
                    prdl1Map.put(ztmm00037.getPRDL1().getPRDL1_type0(), ztmm00037.getPRDLD().getPRDLD_type0());
                if (StringUtils.isNotEmpty(ztmm00037.getPRDL2().getPRDL2_type0()))
                    prdl2Map.put(ztmm00037.getPRDL2().getPRDL2_type0(), ztmm00037.getPRDLT().getPRDLT_type0());
                if (StringUtils.isNotEmpty(ztmm00037.getBRANF().getBRANF_type0()))
                    branfMap.put(ztmm00037.getBRANF().getBRANF_type0(), ztmm00037.getBRANS().getBRANS_type0());
                if (StringUtils.isNotEmpty(ztmm00037.getFRMAT().getFRMAT_type0()))
                    frmatMap.put(ztmm00037.getFRMAT().getFRMAT_type0(), ztmm00037.getFRMAD().getFRMAD_type0());
                if (StringUtils.isNotEmpty(ztmm00037.getPACK1().getPACK1_type0()))
                    pack1Map.put(ztmm00037.getPACK1().getPACK1_type0(), ztmm00037.getPACKD().getPACKD_type0());
                if (StringUtils.isNotEmpty(ztmm00037.getCLASF().getCLASF_type0()))
                    clasfMap.put(ztmm00037.getCLASF().getCLASF_type0(), ztmm00037.getCLAST().getCLAST_type0());
            }
            saveDL(prdl1Map, "2000"); //大类
            saveDL(prdl2Map, "2001"); //中类
            saveDL(branfMap, "2002"); //产品品牌
            saveDL(frmatMap, "2003"); //规格
            saveDL(pack1Map, "2004");//包装类型
            saveDL(clasfMap, "2005");//重点产品分类
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("物料接口调用报错！" + e.getMessage());
            return 0;
        }
        logger.info("物料接口调用结束");
        return 1;
    }
    
    
    /**
     * 保存到物料相关的字典表
     *
     * @param prdl1Map
     */
    private void saveDL(Map<String, String> prdl1Map, String typeCode) {
        if (prdl1Map != null) {
            for (Map.Entry<String, String> entry : prdl1Map.entrySet()) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(entry.getKey());
                param.setTypeCode(typeCode);
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(entry.getKey());
                    codeItem.setTypeCode(typeCode);
                    codeItem.setItemName(entry.getValue());
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(entry.getValue());
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }

    /**
     * 保存物料的计量单位
     *
     * @param marms
     * @param matnrUnit
     */
    private void saveMatMarm(MARM[] marms, Map<String, String> matnrUnit) {
        for (MARM marm : marms) {
            String matnr = marm.getMATNR().getMATNR_type4();
            String meinh = marm.getMEINH().getMEINH_type0();
            String mat = matnrUnit.get(matnr);
            if (StringUtils.isNotEmpty(mat) && StringUtils.isNotEmpty(matnr) && StringUtils.isNotEmpty(meinh)) {
                TMdMaraUnitKey key = new TMdMaraUnitKey();
                key.setUnit(meinh);
                key.setMatnr(matnr);
                TMdMaraUnit maraUnit = maraUnitMapper.selectMaraUnitByNo(key);
                if (maraUnit == null) {
                    maraUnit = new TMdMaraUnit();
                    maraUnit.setBaseUnit(mat);
                    maraUnit.setMatnr(marm.getMATNR().getMATNR_type4());
                    maraUnit.setUnit(marm.getMEINH().getMEINH_type0());
                    maraUnit.setUmrez(marm.getUMREZ().getUMREZ_type0());
                    maraUnit.setUmren(marm.getUMREN().getUMREN_type0());
                    maraUnit.setCreateAt(new Date());
                    maraUnitMapper.insertMaraUnit(maraUnit);
                } else {
                    maraUnit.setBaseUnit(mat);
                    maraUnit.setUmrez(marm.getUMREZ().getUMREZ_type0());
                    maraUnit.setUmren(marm.getUMREN().getUMREN_type0());
                    maraUnit.setLastModified(new Date());
                    maraUnitMapper.updateMaraUnit(maraUnit);
                }
            }
        }
    }

    /**
     * 自营奶站和供应商及供应商奶站
     *
     * @return
     */
    @Override
    public int customerDataHandle() {
    	customerDataHandle13();
    	return 1;
    }
    
    /**
     * 学生奶数据
     */
    @Override
    public int studCustomerDataHandle() {
    	customerDataHandle18();
    	return 1;
    }
    
   

    private int saveSchool(ET_KUNNR et_kunnr, Map<String, ET_KNVP> et_KNVPMap,ET_VKORG et_VKORG ,ZTSD00024 ztsd00024, Map<String, ET_KUNNR> kunnr_Map, Map<String, String> lifnrMap) {
    	//客户编码
     	String kunnr= et_kunnr.getKUNNR();
    	//附加信息
    	Map<String, String> map = new HashMap<String,String>();
    	map.put("erpCode", kunnr);
    	map.put("salesOrg", et_VKORG.getVKORG());
    	TMdSchool tmdschool = schoolMapper.selectByEmpCode(map);
    	if(tmdschool !=null){
    		if(et_KNVPMap !=null && et_KNVPMap.get("SP") !=null){
    			ET_KNVP et_KNVP = et_KNVPMap.get("SP");
    			String lifnr = et_KNVP.getLifnr();
    			if(StringUtils.isNotBlank(lifnr)){
    				tmdschool.setDispatching(lifnr);
    				if(null != lifnrMap){
    					tmdschool.setDispatchingName(lifnrMap.get(lifnr));
    				}
    			}
			}
    		
			if(et_KNVPMap !=null && et_KNVPMap.get("Z9") !=null){
				ET_KNVP et_KNVP = et_KNVPMap.get("Z9");
    				String kunn2 = et_KNVP.getKunn2();
				if(StringUtils.isNotBlank(kunn2)){
					tmdschool.setUnload(kunn2);
					ET_KUNNR et_KUNNR = kunnr_Map.get(kunn2);
					if(et_KUNNR !=null){
						tmdschool.setUnloadName(et_KUNNR.getNAME1());
					};
				}
			}
			
			
    		tmdschool.setErpCode(kunnr);
    		tmdschool.setSchoolCodeTxt(et_kunnr.getSort2());
    		tmdschool.setSchoolName(et_kunnr.getNAME1());
    		tmdschool.setTel(et_kunnr.getTELF1());
    		tmdschool.setWerks(et_kunnr.getBUKRS());
    		tmdschool.setAddress(et_kunnr.getSTRAS());
    		if(ztsd00024 !=null)tmdschool.setLgort(ztsd00024.getLGORT().getLGORT_type0());	
    		
    		tmdschool.setErpCodeSales(StringUtils.isNotBlank(et_VKORG.getKUNWE())? et_VKORG.getKUNWE():et_VKORG.getKUNNR());
    		schoolMapper.updateByTMdSchool(tmdschool);
    		return 1;
    	}else{
    		tmdschool = new TMdSchool();
    		//获取销售组织
    		if(et_KNVPMap !=null && et_KNVPMap.get("SP") !=null){
    			ET_KNVP et_KNVP = et_KNVPMap.get("SP");
    			String lifnr = et_KNVP.getLifnr();
    			if(StringUtils.isNotBlank(lifnr)){
    				tmdschool.setDispatching(lifnr);
    				if(null != lifnrMap){
    					tmdschool.setDispatchingName(lifnrMap.get(lifnr));
    				}
    			}
			}
    		
			if(et_KNVPMap !=null && et_KNVPMap.get("Z9") !=null){
				ET_KNVP et_KNVP = et_KNVPMap.get("Z9");
    				String kunn2 = et_KNVP.getKunn2();
				if(StringUtils.isNotBlank(kunn2)){
					tmdschool.setUnload(kunn2);
					ET_KUNNR et_KUNNR = kunnr_Map.get(kunn2);
					if(et_KUNNR !=null){
						tmdschool.setUnloadName(et_KUNNR.getNAME1());
					};
				}
			}
    		tmdschool.setSchoolCode(UUID.randomUUID().toString().replace("-", ""));
    		tmdschool.setErpCode(kunnr);
    		tmdschool.setSchoolCodeTxt(et_kunnr.getSort2());
    		tmdschool.setSchoolName(et_kunnr.getNAME1());
    		tmdschool.setTel(et_kunnr.getTELF1());
    		tmdschool.setVisiable("10");
    		tmdschool.setSalesOrg(et_VKORG.getVKORG());
    		tmdschool.setErpCodeSales(StringUtils.isNotBlank(et_VKORG.getKUNWE())? et_VKORG.getKUNWE():et_VKORG.getKUNNR());
    		tmdschool.setAddress(et_kunnr.getSTRAS());
    		tmdschool.setWerks(et_kunnr.getBUKRS());
    		if(ztsd00024 !=null)tmdschool.setLgort(ztsd00024.getLGORT().getLGORT_type0());
    		schoolMapper.saveSchool(tmdschool);
    		return 1;
    	}
    }
    
    
    
    private int customerDataHandle18(){
    	logger.info("学生奶客户数据调用开始");
        try {
        	ZSD_CUSTOMER_DATA_SYN_RFCResponse response1 = getCustomerDataBYKunnr("0400000001","0499999999");
            ZSD_CUSTOMER_DATA_SYN_RFCResponse response = getCustomerData(VKORG18);
            Map<String, String> lifnrMap = this.getZSMM00013ForMap();//供货商
            Map<String, ET_KUNNR> kunnr_Map1 = getET_KUNNR(response1);
            Map<String, ET_KUNNR> kunnr_Map = getET_KUNNR(response);
            
            Map<String,  Map<String,ET_KNVP>> et_KNVP = getET_KNVP(response);
            List<ET_VKORG> et_VKORG18 = getET_VKORG18(response);
            List<ET_PARTNER> et_partner = getET_PARTNER(response);
            Map<String,ZTSD00024> gcss = getET_DATAs();
            int zycount = 0;
            for (int i = 0; i < et_VKORG18.size(); i++) {
            	ET_VKORG et_VKORG = et_VKORG18.get(i);
            	String kunnr = et_VKORG.getKUNNR();
            	ZTSD00024 ztsd00024 = gcss.get(kunnr);
            	//保存售达方
            	for (ET_PARTNER et_PARTNER : et_partner) {
            		if(et_PARTNER.getKUNWE().equals(kunnr)){
            			et_VKORG.setKUNWE(et_PARTNER.getKUNNR());
            		}
				}
            	ET_KUNNR et_kunnr = kunnr_Map.get(kunnr);
            	//获取送达方
            	if(et_kunnr !=null && StringUtils.isNotBlank(et_kunnr.getNAME1())){
            		Map<String, ET_KNVP> map = et_KNVP.get(kunnr);
            		this.saveSchool(et_kunnr, map, et_VKORG,ztsd00024, kunnr_Map1, lifnrMap);
            	}
            	zycount++;
			}
            logger.info("自营奶站" + zycount + "条");
            return 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        logger.info("客户数据调用结束");
        return 1;
   }
    
    
    
    private int customerDataHandle13(){
    	  logger.info("客户数据调用开始");
          try {
              ZSD_CUSTOMER_DATA_SYN_RFCResponse response = getCustomerData(VKORG);
              Map<String, ET_KUNNR> et_kunnrs = getET_KUNNR(response);
              Map<String, List<ET_VKORG>> et_vkorgs = getET_VKORG(response);
              List<ET_PARTNER> et_partner = getET_PARTNER(response);
              Map<String, List<ET_PARTNER>> partners = new HashMap<String, List<ET_PARTNER>>();
              List<ET_VKORG> zys = et_vkorgs.get("01");
//              Map<String, String> gcs = getET_DATA(); //客户对应的库存地点
              Map<String,ZTSD00024> gcss = getET_DATAs();
              Map<String, ET_LGORT> ccds = getET_LGORT(); //库存地点对应的工厂
              int zycount = 0;
              for (ET_VKORG et_vkorg : zys) {
                  String kunnr = et_vkorg.getKUNNR();
                  ZTSD00024 ztsd00024 = gcss.get(kunnr);
                  if (ztsd00024 != null) {
                      String lgort  = ztsd00024.getLGORT().getLGORT_type0();
                      String werks = ztsd00024.getBUKRS().getBUKRS_type6();
                      if (StringUtils.isNotEmpty(werks)) {
                          zycount++;
                          saveBranch(et_kunnrs, BRANDCHTYPE_ZY, et_vkorg.getVKORG(), et_vkorg.getKUNNR(), lgort, werks, "");
                      }
                  }
              }
              logger.info("自营奶站" + zycount + "条");
              List<ET_VKORG> wbs = et_vkorgs.get("02");
              Map<String, ET_VKORG> jxs = new HashMap<String, ET_VKORG>();
              for (ET_VKORG et_vkorg : wbs) {
                  String kunner = et_vkorg.getKUNNR();
                  for (ET_PARTNER et_partner1 : et_partner) {
                      //是售达方都作为经销商处理
                      if (kunner.equals(et_partner1.getKUNNR())) {
                          jxs.put(kunner, et_vkorg);
                      }
                  }
              }
              /**
               * 保存经销商信息
               */
              for (Map.Entry<String, ET_VKORG> entry : jxs.entrySet()) {
                  saveDealer(et_kunnrs, entry.getKey(), entry.getValue().getVKORG());
              }
              for (Map.Entry<String, ET_VKORG> entry : jxs.entrySet()) {
                  String kunnr = entry.getKey();
                  List<ET_PARTNER> l = new ArrayList<>();
                  for (ET_PARTNER p : et_partner) {
                      //送达方都作为经销商奶站
                      if (kunnr.equals(p.getKUNNR())) {
                          l.add(p);
                      }
                  }
                  if (l.size() > 0)
                      partners.put(kunnr, l);
              }
              int zxscount = 0;
              for (Map.Entry<String, List<ET_PARTNER>> entry : partners.entrySet()) {
                  String key = entry.getKey();
                  List<ET_PARTNER> lists = entry.getValue();
                  for (ET_PARTNER partner : lists) {
                      saveBranch(et_kunnrs, BRANDCHTYPE_WB, partner.getVKORG(), partner.getKUNWE(), "", "", key);
                      zxscount++;
                  }
              }
              logger.info("经销商奶站" + zxscount + "条");
              return 1;
          } catch (Exception e) {
              logger.error(e.getMessage());
              e.printStackTrace();
          }
          logger.info("客户数据调用结束");
          return 1;
    }

    /**
     * 保存经销商信息
     *
     * @param et_kunnrs
     * @param key
     * @param vkorg
     */
    private void saveDealer(Map<String, ET_KUNNR> et_kunnrs, String key, String vkorg) {
        ET_KUNNR et_kunnr = et_kunnrs.get(key);
        TMdDealer dealer = dealerMapper.selectDealerByNo(key);
        if (et_kunnr != null)
            if (dealer == null) {
                dealer = new TMdDealer();
                dealer.setDealerNo(key);
                dealer.setDealerName(et_kunnr.getNAME1());
                dealer.setCity(et_kunnr.getORT01());
                dealer.setProvince(et_kunnr.getREGIO());
                dealer.setCreateAt(new Date());
                dealer.setCreateBy("ECC");
                dealer.setCreateByTxt("ECC");
                dealer.setSalesOrg(vkorg);
                dealer.setAddress(et_kunnr.getSTRAS());
                dealer.setTel(et_kunnr.getTELF1());
                dealer.setDelFlag("N");
                dealer.setCompanyCode(et_kunnr.getBUKRS());
                dealerMapper.insertDealer(dealer);
            } else {
                dealer.setDealerNo(key);
                dealer.setDealerName(et_kunnr.getNAME1());
                dealer.setCity(et_kunnr.getORT01());
                dealer.setProvince(et_kunnr.getREGIO());
                dealer.setCreateAt(new Date());
                dealer.setCreateBy("ECC");
                dealer.setCreateByTxt("ECC");
                dealer.setSalesOrg(vkorg);
                dealer.setAddress(et_kunnr.getSTRAS());
                dealer.setTel(et_kunnr.getTELF1());
                dealer.setCompanyCode(et_kunnr.getBUKRS());
                dealer.setDelFlag("N");
                dealerMapper.updateDealer(dealer);
            }
    }

    /**
     * 保存奶站信息
     *
     * @param et_kunnrs
     * @param branchGroup
     * @param vkorg
     * @param kunnr
     * @param lgort
     * @param werks
     * @param dealerNo
     */
    private void saveBranch(Map<String, ET_KUNNR> et_kunnrs, String branchGroup, String vkorg, String kunnr, String lgort, String werks, String dealerNo) {
        ET_KUNNR et_kunnr = et_kunnrs.get(kunnr);

        if (et_kunnr != null) {
            TMdBranch branch = branchMapper.getBranchByNo(et_kunnr.getKUNNR());
            if (branch == null) {
                branch = new TMdBranch();
                branch.setBranchNo(et_kunnr.getKUNNR());
                branch.setBranchName(et_kunnr.getNAME1());
                branch.setTel(et_kunnr.getTELF1());
                branch.setAddress(et_kunnr.getSTRAS());
                branch.setCity(et_kunnr.getORT01());
                branch.setBranchGroup(branchGroup);
                branch.setProvince(et_kunnr.getREGIO());
                branch.setSalesCha("13");
                branch.setSalesOrg(vkorg);
                branch.setCreateAt(new Date());
                branch.setCreateBy("ECC");
                branch.setCreateByTxt("ECC");
                branch.setDealerNo(dealerNo);
                if (StringUtils.isNotEmpty(lgort))
                    branch.setLgort(lgort);
                if (StringUtils.isNotEmpty(werks))
                    branch.setWerks(werks);
                branch.setCompanyCode(et_kunnr.getBUKRS());
                branchMapper.addBranch(branch);
                messageService.sendMessagesForCreateBranch(branch);
            } else {
                branch.setBranchNo(et_kunnr.getKUNNR());
                branch.setBranchName(et_kunnr.getNAME1());
                branch.setTel(et_kunnr.getTELF1());
                branch.setAddress(et_kunnr.getSTRAS());
                branch.setCity(et_kunnr.getORT01());
                branch.setBranchGroup(branchGroup);
                branch.setProvince(et_kunnr.getREGIO());
                branch.setSalesCha("13");
                branch.setSalesOrg(vkorg);
                branch.setDealerNo(dealerNo);
                if (StringUtils.isNotEmpty(lgort))
                    branch.setLgort(lgort);
                if (StringUtils.isNotEmpty(werks))
                    branch.setWerks(werks);
                branch.setLastModified(new Date());
                branch.setLastModifiedBy("ECC");
                branch.setLastModifiedByTxt("ECC");
                branch.setCompanyCode(et_kunnr.getBUKRS());
                branchMapper.updateBranch(branch);
            }
            //Todo
            final TMdBranch finalBranch = branch;
            taskExecutor.execute(new Thread() {
                public void run() {
                    try {
                        this.setName(finalBranch.getBranchNo() + new Date());
                        ecService.pushBranch2EcForUpt(finalBranch);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                }
            });
            TMdBranchEx branchEx = branchExMapper.getBranchEx(branch.getBranchNo());
            NHSysCodeItem key = new NHSysCodeItem();
            key.setItemCode(et_kunnr.getBUKRS());
            key.setTypeCode("1014");
            NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(key);
            if (branchEx == null) {
                branchEx = new TMdBranchEx();
                branchEx.setBranchNo(branch.getBranchNo());
                branchEx.setCompCode(et_kunnr.getBUKRS());
                branchEx.setCreateAt(new Date());
                branchEx.setCreateByTxt("ECC");
                branchEx.setCreateBy("ECC");
                if (codeItem != null) {
                    branchEx.setPurchOrg(codeItem.getAttr1());
                    branchEx.setPurchGroup(codeItem.getAttr3());
                    branchEx.setSupplPlnt(codeItem.getAttr2());
                    branchEx.setReslo(codeItem.getAttr4());
                }
                branchEx.setDocType("Z08");
                branchExMapper.insertBranchEx(branchEx);
            } else {
                branchEx.setCompCode(et_kunnr.getBUKRS());
                branchEx.setLastModified(new Date());
                branchEx.setLastModifiedBy("ECC");
                branchEx.setLastModifiedByTxt("ECC");
                if (codeItem != null) {
                    branchEx.setPurchOrg(codeItem.getAttr1());
                    branchEx.setPurchGroup(codeItem.getAttr3());
                    branchEx.setSupplPlnt(codeItem.getAttr2());
                    branchEx.setReslo(codeItem.getAttr4());
                }
                branchEx.setDocType("Z08");
                branchExMapper.updateBranchEx(branchEx);
            }
        }
    }
    
    
    
   

    /**
     * 工厂
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public int matWHWHandler() throws RemoteException {
        Map<String,ZTSD00024> etMap = getET_DATAs();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ZTSD00024> entry : etMap.entrySet()) {
            TMdBranch branch = branchMapper.getBranchByNo(entry.getKey());
            ZTSD00024 lgort = entry.getValue();
            if(lgort != null && branch != null) {
                branch.setWerks(lgort.getBUKRS().getBUKRS_type6());
                branch.setLgort(lgort.getLGORT().getLGORT_type0());
                sb.append("---"+lgort.getBUKRS().getBUKRS_type6());
                sb.append(lgort.getLGORT().getLGORT_type0());
                branchMapper.updateBranch(branch);
            }
        }
        System.out.println(sb);
        return 1;
    }

    /**
     * 字典表
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public int salesQueryHandler() throws RemoteException {
        try {
            ZSD_SALES_ORGANIZATION_RFCResponse response = salesQuery();
            saveCompany(response);
            saveWerks(response);
            saveLgort(response);
            saveVkorg(response);
            ZSD_T005_DATAResponse response1 = codeQuery();
            saveET_T024E(response1);
            saveET_T024(response1);
        } catch (Exception e) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "字典数据保存出错！");
        }
        return 1;
    }


    /**
     * 销售组织
     *
     * @return
     * @throws RemoteException
     */
    private ZSD_SALES_ORGANIZATION_RFCResponse salesQuery() throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        ZSD_SALES_ORGANIZATION_RFC rfc = new ZSD_SALES_ORGANIZATION_RFC();
        return client.salesQuery(rfc);
    }
    
    /**
     * 供货商
     * @return
     * @throws RemoteException
     */
    private ZMM_MC_ET_LIFNRResponse zMM_MC_ET_LIFNR() throws RemoteException {
    	OA_MasterData_OutServiceStub client = getOA_MasterData_OutServiceStub();
    	ZMM_MC_ET_LIFNR lifnr = new ZMM_MC_ET_LIFNR();
        return client.zMM_MC_ET_LIFNR(lifnr);
    }
    
    /**
     * 获取全部供货商(数组)
     * @return
     * @throws RemoteException
     */
    private ZSMM00013[] getET_LIFNR_ITEMS() throws RemoteException{
    	ET_LIFNR_type0 type0 = this.zMM_MC_ET_LIFNR().getET_LIFNR();
    	ZSMM00013[] items = type0.getItem();
    	return items;
    }
    
    private Map<String, String> getZSMM00013ForMap() throws RemoteException{
    	Map<String, String> resultMap = new HashMap<String, String>();
    	ZSMM00013[] items = this.getET_LIFNR_ITEMS();
    	if(null != items && items.length > 0){
    		for(ZSMM00013 item : items){
    			if(null != item.getLIFNR()
    					&& StringUtils.isNotBlank(item.getLIFNR().getLIFNR_type2())){
    				String name = "";
    				if(null != item.getNAME1()
    						&& StringUtils.isNotBlank(item.getNAME1().getNAME1_type0())){
    					name = item.getNAME1().getNAME1_type0();
    				}
    				resultMap.put(item.getLIFNR().getLIFNR_type2(), name);
    			}
    		}
    	}
    	return resultMap;
    }
    
    

    /**
     * 保存销售组织
     *
     * @param response
     */
    private void saveVkorg(ZSD_SALES_ORGANIZATION_RFCResponse response) {
        ZSSD00025[] zssd00025s = response.getET_VKORG().getItem();
        for (ZSSD00025 zssd00025 : zssd00025s) {
            String vkorg = zssd00025.getVKORG().getVKORG_type14();
            String vkorgTxt = zssd00025.getVKORGTEXT().getVKORGTEXT_type0();
            String bukrs = zssd00025.getBUKRS().getBUKRS_type10();
            String vtweg = zssd00025.getVTWEG().getVTWEG_type14();
            String sparttext = zssd00025.getSPARTTEXT().getSPARTTEXT_type0();
            if (StringUtils.isNotEmpty(vkorg) && VKORG.equals(vtweg)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(vkorg);
                param.setTypeCode("1002");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(vkorg);
                    codeItem.setTypeCode("1002");
                    codeItem.setItemName(vkorgTxt);
                    codeItem.setParent(bukrs);
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(vkorgTxt);
                    codeItem.setParent(bukrs);
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }

    /**
     * 保存库存地点
     *
     * @param response
     */
    private void saveLgort(ZSD_SALES_ORGANIZATION_RFCResponse response) {
        ZSSD00024[] zssd00024s = response.getET_LGORT().getItem();
        for (ZSSD00024 zssd00024 : zssd00024s) {
            String lgort = zssd00024.getLGORT().getLGORT_type4();
            String name = zssd00024.getNAME1().getNAME1_type4();
            String werks = zssd00024.getWERKS().getWERKS_type8();
            String des = zssd00024.getLGOBE().getLGOBE_type2();
            if (StringUtils.isNotEmpty(lgort)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(werks.concat(lgort));
                param.setTypeCode("1011");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(werks.concat(lgort));
                    codeItem.setTypeCode("1011");
                    codeItem.setItemName(des);
                    codeItem.setParent(werks);
                    codeItem.setAttr1(lgort);
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(des);
                    codeItem.setParent(werks);
                    codeItem.setAttr1(lgort);
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }

    /**
     * 保存工厂
     *
     * @param response
     */
    private void saveWerks(ZSD_SALES_ORGANIZATION_RFCResponse response) {
        ZSSD00023[] zssd00023s = response.getET_WERKS().getItem();
        for (ZSSD00023 zssd00023 : zssd00023s) {
            String werks = zssd00023.getWERKS().getWERKS_type4();
            String butxt = zssd00023.getNAME().getNAME_type0();
            String bukrs = zssd00023.getBUKRS().getBUKRS_type2();
            if (StringUtils.isNotEmpty(werks)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(werks);
                param.setTypeCode("1005");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(werks);
                    codeItem.setTypeCode("1005");
                    codeItem.setItemName(butxt);
                    codeItem.setParent(bukrs);
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(butxt);
                    codeItem.setParent(bukrs);
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }

    }


    private void saveCompany(ZSD_SALES_ORGANIZATION_RFCResponse response) {
        ZSSD00027[] zssd00027s = response.getET_BUKRS().getItem();
        for (ZSSD00027 zssd00027 : zssd00027s) {
            String bukrs = zssd00027.getBUKRS().getBUKRS_type8();
            String butxt = zssd00027.getBUTXT().getBUTXT_type0();
            if (StringUtils.isNotEmpty(bukrs)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(bukrs);
                param.setTypeCode("1003");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(bukrs);
                    codeItem.setTypeCode("1003");
                    codeItem.setItemName(butxt);
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(butxt);
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }


    /**
     * 字典数据
     *
     * @return
     * @throws RemoteException
     */
    private ZSD_T005_DATAResponse codeQuery() throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        ZSD_T005_DATA zsd_t005_data = new ZSD_T005_DATA();
        return client.codeQuery(zsd_t005_data);
    }

    /**
     * 保存采购组织
     *
     * @param response
     */
    private void saveET_T024E(ZSD_T005_DATAResponse response) {
        T024E[] t024Es = response.getET_T024E().getItem();
        for (T024E t024e : t024Es) {
            String ekorg = t024e.getEKORG().getEKORG_type0();
            if (StringUtils.isNotEmpty(ekorg)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(ekorg);
                param.setTypeCode("1004");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(ekorg);
                    codeItem.setTypeCode("1004");
                    codeItem.setItemName(t024e.getEKOTX().getEKOTX_type0());
                    codeItem.setParent(t024e.getBUKRS().getBUKRS_type4());
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(t024e.getEKOTX().getEKOTX_type0());
                    codeItem.setParent(t024e.getBUKRS().getBUKRS_type4());
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }


    /**
     * 保存采购组
     *
     * @param response
     */
    private void saveET_T024(ZSD_T005_DATAResponse response) {
        T024[] t024s = response.getET_T024().getItem();
        for (T024 t024 : t024s) {
            String ekgrp = t024.getEKGRP().getEKGRP_type0();
            if (StringUtils.isNotEmpty(ekgrp)) {
                NHSysCodeItem param = new NHSysCodeItem();
                param.setItemCode(ekgrp);
                param.setTypeCode("1013");
                NHSysCodeItem codeItem = codeItemMapper.findCodeItenByCode(param);
                if (codeItem == null) {
                    codeItem = new NHSysCodeItem();
                    codeItem.setItemCode(ekgrp);
                    codeItem.setTypeCode("1013");
                    codeItem.setItemName(t024.getEKNAM().getEKNAM_type0());
                    codeItem.setCreateAt(new Date());
                    codeItem.setCreateByTxt("ECC");
                    codeItem.setCreateBy("ECC");
                    codeItemMapper.addCodeItem(codeItem);
                } else {
                    codeItem.setItemName(t024.getEKNAM().getEKNAM_type0());
                    codeItem.setLastModified(new Date());
                    codeItem.setLastModifiedBy("ECC");
                    codeItem.setLastModifiedByTxt("ECC");
                    codeItemMapper.updateCodeItemByCode(codeItem);
                }
            }
        }
    }

    /**
     * 客户数据
     *
     * @return
     * @throws RemoteException
     */
    private ZSD_CUSTOMER_DATA_SYN_RFCResponse getCustomerData(String vkorg) throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        ZSD_CUSTOMER_DATA_SYN_RFC zsdCustomerDataSynRfc = new ZSD_CUSTOMER_DATA_SYN_RFC();
        ZSD_CUSTOMER_DATA_SYN_RFCResponse response = new ZSD_CUSTOMER_DATA_SYN_RFCResponse();
        IT_VTWEG_type1 it_vtweg_type1 = new IT_VTWEG_type1();
        ZSSD00071 zssd00071 = new ZSSD00071();
        SIGN_type5 sign_type5 = new SIGN_type5();
        sign_type5.setSIGN_type4("I");
        zssd00071.setSIGN(sign_type5);
        OPTION_type5 option_type5 = new OPTION_type5();
        option_type5.setOPTION_type4("EQ");
        zssd00071.setOPTION(option_type5);
        LOW_type5 low_type5 = new LOW_type5();
        low_type5.setLOW_type4(vkorg);
        zssd00071.setLOW(low_type5);
        it_vtweg_type1.addItem(zssd00071);
        zsdCustomerDataSynRfc.setIT_VTWEG(it_vtweg_type1);
        response = client.customerQuery(zsdCustomerDataSynRfc);
        return response;
    }
   
    
    
    private ZSD_CUSTOMER_DATA_SYN_RFCResponse getCustomerDataBYKunnr(String low,String high) throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        ZSD_CUSTOMER_DATA_SYN_RFC zsdCustomerDataSynRfc = new ZSD_CUSTOMER_DATA_SYN_RFC();
        ZSD_CUSTOMER_DATA_SYN_RFCResponse response = new ZSD_CUSTOMER_DATA_SYN_RFCResponse();
        IT_KUNNR_type0 param = new com.nhry.webService.client.masterData.functions.IT_KUNNR_type0();
        com.nhry.webService.client.masterData.functions.ZSSD00001 zssd00001 = new com.nhry.webService.client.masterData.functions.ZSSD00001();
        SIGN_type9 sign_type9 = new SIGN_type9();
        sign_type9.setSIGN_type8("I");
        zssd00001.setSIGN(sign_type9);
        OPTION_type9 option_type9 = new OPTION_type9();
        option_type9.setOPTION_type8("BT");
        zssd00001.setOPTION(option_type9);
        LOW_type9 low_type9 = new LOW_type9();
        low_type9.setLOW_type8(low);
        zssd00001.setLOW(low_type9);
        
        HIGH_type9 high_type9 = new HIGH_type9();
        high_type9.setHIGH_type8(high);
        zssd00001.setHIGH(high_type9);
        
        
        param.addItem(zssd00001);
        zsdCustomerDataSynRfc.setIT_KUNNR(param);
        response = client.customerQuery(zsdCustomerDataSynRfc);
        return response;
    }

    /**
     * 材料数据
     *
     * @return
     * @throws RemoteException
     */
    private ZSD_MATERAIL_DATA_RFCResponse getMaterailData(String vkorg) throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        IT_MTART_type0 itMtartType0 = new IT_MTART_type0();
        ZSSD00006 zssd00006 = new ZSSD00006();
        SIGN_type3 sign_type3 = new SIGN_type3();
        sign_type3.setSIGN_type2(SIGN);
        zssd00006.setSIGN(sign_type3);
        OPTION_type3 option_type3 = new OPTION_type3();
        option_type3.setOPTION_type2(OPTION);
        zssd00006.setOPTION(option_type3);
        LOW_type3 low_type3 = new LOW_type3();
        low_type3.setLOW_type2(LOW);
        zssd00006.setLOW(low_type3);
        itMtartType0.addItem(zssd00006);
        IT_VTWEG_type0 it_vtweg_type0 = new IT_VTWEG_type0();
        ZSSD00071 zssd00071 = new ZSSD00071();
        SIGN_type5 sign_type5 = new SIGN_type5();
        sign_type5.setSIGN_type4(SIGN);
        zssd00071.setSIGN(sign_type5);
        OPTION_type5 option_type5 = new OPTION_type5();
        option_type5.setOPTION_type4(OPTION);
        zssd00071.setOPTION(option_type5);
        LOW_type5 low_type5 = new LOW_type5();
        low_type5.setLOW_type4(vkorg);
        zssd00071.setLOW(low_type5);
        it_vtweg_type0.addItem(zssd00071);

        ZSD_MATERAIL_DATA_RFCResponse response;
        ZSD_MATERAIL_DATA_RFC zsdMaterailDataRfc = new ZSD_MATERAIL_DATA_RFC();
        zsdMaterailDataRfc.setIT_MTART(itMtartType0);
        zsdMaterailDataRfc.setIT_VTWEG(it_vtweg_type0);
        return client.mATQUERY(zsdMaterailDataRfc);
    }

    /**
     * 客户对应的库存地点和工厂
     *
     * @return
     */
    private Map<String, String> getET_DATA() throws RemoteException {
        ZMM_POS_24DATAResponse response = getMatWHQuery();
        ET_DATA_type0 et_data_type0 = response.getET_DATA();
        ZTSD00024[] ztsd00024s = et_data_type0.getItem();
        Map<String, String> map = new HashMap<String, String>();
        for (ZTSD00024 zt : ztsd00024s) {
            String kunner = zt.getKUNNR1().getKUNNR1_type0();
            String lgort = zt.getLGORT().getLGORT_type0();
            String prodh = zt.getPRODH().getPRODH_type0();
            if (org.apache.commons.lang.StringUtils.isNotEmpty(kunner)) {
                map.put(kunner, lgort);
            }
        }
        return map;
    }
    private Map<String, ZTSD00024> getET_DATAs() throws RemoteException {
        ZMM_POS_24DATAResponse response = getMatWHQuery();
        ET_DATA_type0 et_data_type0 = response.getET_DATA();
        ZTSD00024[] ztsd00024s = et_data_type0.getItem();
        Map<String, ZTSD00024> map = new HashMap<String, ZTSD00024>();
        for (ZTSD00024 zt : ztsd00024s) {
            String kunner = zt.getKUNNR1().getKUNNR1_type0();
            String lgort = zt.getLGORT().getLGORT_type0();
            if (StringUtils.isNotEmpty(kunner) && StringUtils.isNotEmpty(lgort)) {
                map.put(kunner, zt);
            }
        }
        return map;
    }
    /**
     * 库存地点和工厂对应关系
     *
     * @return
     * @throws RemoteException
     */
    private Map<String, ET_LGORT> getET_LGORT() throws RemoteException {
        ZMM_POS_24DATAResponse response = getMatWHQuery();
        ET_LGORT_type0 et_lgort_type0 = response.getET_LGORT();
        T001L[] t001Ls = et_lgort_type0.getItem();
        Map<String, ET_LGORT> result = new HashMap<String, ET_LGORT>();
        for (T001L t001L : t001Ls) {
            ET_LGORT et = new ET_LGORT();
            et.setWERKS(t001L.getWERKS().getWERKS_type6());
            et.setLGOBE(t001L.getLGOBE().getLGOBE_type0());
            et.setLGORT(t001L.getLGORT().getLGORT_type2());
            result.put(t001L.getLGORT().getLGORT_type2(), et);
        }
        return result;
    }

    /**
     * 库存地点和工厂对应关系
     *
     * @return
     * @throws RemoteException
     */
    private Map<String, ET_LGORT> getET_LGORTs() throws RemoteException {
        ZMM_POS_24DATAResponse response = getMatWHQuery();
        ET_LGORT_type0 et_lgort_type0 = response.getET_LGORT();
        T001L[] t001Ls = et_lgort_type0.getItem();
        Map<String, ET_LGORT> result = new HashMap<String, ET_LGORT>();
        for (T001L t001L : t001Ls) {
            ET_LGORT et = new ET_LGORT();
            String werks = t001L.getWERKS().getWERKS_type6();
            if(!CANCELSALESORG.equals(werks)) {
                et.setWERKS(werks);
                et.setLGOBE(t001L.getLGOBE().getLGOBE_type0());
                et.setLGORT(t001L.getLGORT().getLGORT_type2());
                result.put(t001L.getLGORT().getLGORT_type2().concat(t001L.getLGOBE().getLGOBE_type0()), et);
            }
        }
        return result;
    }

    private ZMM_POS_24DATAResponse getMatWHQuery() throws RemoteException {
        ZT_MasterDataQueryServiceStub client = getZt_masterDataQueryServiceStub();
        ZMM_POS_24DATA zmm_pos_24DATA = new ZMM_POS_24DATA();
        return client.matWHWQuery(zmm_pos_24DATA);
    }

    /**
     * 客户主数据
     *
     * @param response
     * @return
     */
    private Map<String, ET_KUNNR> getET_KUNNR(ZSD_CUSTOMER_DATA_SYN_RFCResponse response) {
        ET_KUNNR_type1 et_kunnr_type1 = response.getET_KUNNR();
        ZSSD00002[] zssd00002s = et_kunnr_type1.getItem();
        Map<String, ET_KUNNR> map = new HashMap<String, ET_KUNNR>();
        if (zssd00002s.length > 0) {
            for (ZSSD00002 zssd00002 : zssd00002s) {
                ET_KUNNR et = new ET_KUNNR();
                if (zssd00002.getBUKRS() != null && !"4020".equals(zssd00002.getBUKRS().getBUKRS_type0())) {
                    et.setBUKRS(zssd00002.getBUKRS() == null ? null : zssd00002.getBUKRS().getBUKRS_type0());
                    et.setKUNNR(zssd00002.getKUNNR() == null ? null : zssd00002.getKUNNR().getKUNNR_type2());
                    et.setNAME1(zssd00002.getNAME1() == null ? null : zssd00002.getNAME1().getNAME1_type0());
                    et.setNAME2(zssd00002.getNAME2() == null ? null : zssd00002.getNAME2().getNAME2_type0());
                    et.setNAME3(zssd00002.getNAME3() == null ? null : zssd00002.getNAME3().getNAME3_type0());
                    et.setNAMEV(zssd00002.getNAMEV() == null ? null : zssd00002.getNAMEV().getNAMEV_type0());
                    et.setORT01(zssd00002.getORT01() == null ? null : zssd00002.getORT01().getORT01_type0());
                    et.setREGIO(zssd00002.getREGIO() == null ? null : zssd00002.getREGIO().getREGIO_type0());
                    et.setSTRAS(zssd00002.getSTRAS() == null ? null : zssd00002.getSTRAS().getSTRAS_type0());
                    et.setTELF1(zssd00002.getTELF1() == null ? null : zssd00002.getTELF1().getTELF1_type0());
                    et.setSort2(zssd00002.getSORT2() == null ? null : zssd00002.getSORT2().getSORT2_type0());
                    map.put(zssd00002.getKUNNR().getKUNNR_type2(), et);
                }
            }
        }
        return map;
    }
    

    
    private Map<String, Map<String,ET_KNVP>> getET_KNVP(ZSD_CUSTOMER_DATA_SYN_RFCResponse response) {
        ET_KNVP_type1 et_KNVP = response.getET_KNVP();
        if(et_KNVP == null ){
        	return new HashMap<String,Map<String,ET_KNVP>>();
        }
        KNVP[] itemList = et_KNVP.getItem();
        Map<String, Map<String,ET_KNVP>> map = new HashMap<String,Map<String,ET_KNVP>>();
        if (itemList.length > 0) {
            for ( KNVP  knvp : itemList) {
            	  ET_KNVP et = new ET_KNVP();
                  if (knvp !=  null && StringUtils.isNotBlank(knvp.getPARVW().getPARVW_type0())) {
                	  et.setDefpa(knvp.getDEFPA() ==null ? null:knvp.getDEFPA().getDEFPA_type0());
                	  et.setKnref(knvp.getKNREF() ==null ? null:knvp.getKNREF().getKNREF_type0());
                	  et.setKunn2(knvp.getKUNN2() ==null ? null:knvp.getKUNN2().getKUNN2_type0());
                	  et.setKunnr(knvp.getKUNNR() ==null ? null:knvp.getKUNNR().getKUNNR_type0());
                	  et.setLifnr(knvp.getLIFNR() ==null ? null:knvp.getLIFNR().getLIFNR_type0());
                	  et.setMandt(knvp.getMANDT() ==null ? null:knvp.getMANDT().getMANDT_type4());
                	  et.setParnr(knvp.getPARNR() ==null ? null:knvp.getPARNR().getPARNR_type0());
                	  et.setParvw(knvp.getPARVW() ==null ? null:knvp.getPARVW().getPARVW_type0());
                	  et.setParza(knvp.getPARZA() ==null ? null:knvp.getPARZA().getPARZA_type0());
                	  et.setPernr(knvp.getPERNR() ==null ? null:knvp.getPERNR().getPERNR_type0());
                	  et.setSpart(knvp.getSPART() ==null ? null:knvp.getSPART().getSPART_type2());
                	  et.setVokrg(knvp.getKNREF() ==null ? null:knvp.getKNREF().getKNREF_type0());
                	  Map<String, ET_KNVP> knvpMap = map.get(knvp.getKUNNR().getKUNNR_type0());
                	  if(knvpMap ==null){
                		  knvpMap=new HashMap<String, ET_KNVP>();
                		  knvpMap.put(knvp.getPARVW().getPARVW_type0(),et);
                		  map.put(knvp.getKUNNR().getKUNNR_type0(), knvpMap);
                	  }else{
                		  knvpMap.put(knvp.getPARVW().getPARVW_type0(),et);
                		  map.put(knvp.getKUNNR().getKUNNR_type0(), knvpMap);
                	  }
                  }
            }
        }

        return map;
    }
    
    /**
     * 售达方渠道对应的送达方
     *
     * @param response
     * @return
     */
    private List<ET_PARTNER> getET_PARTNER(ZSD_CUSTOMER_DATA_SYN_RFCResponse response) {
        ET_PARTNER_type1 et_partner_type1 = response.getET_PARTNER();
        ZSSD00030[] zssd00030s = et_partner_type1.getItem();
        List<ET_PARTNER> records = new ArrayList<ET_PARTNER>();
        if (zssd00030s.length > 0) {
            for (ZSSD00030 zssd00030 : zssd00030s) {
                String vtweg = zssd00030.getVTWEG() == null ? null : zssd00030.getVTWEG().getVTWEG_type6();
                //if(vtweg!=null && VKORG.equals(vtweg)) {
                ET_PARTNER et = new ET_PARTNER();
                et.setKUNNR(zssd00030.getKUNNR() == null ? null : zssd00030.getKUNNR().getKUNNR_type4());
                et.setKUNWE(zssd00030.getKUNWE() == null ? null : zssd00030.getKUNWE().getKUNWE_type0());
                et.setSPART(zssd00030.getSPART() == null ? null : zssd00030.getSPART().getSPART_type4());
                et.setVKORG(zssd00030.getVKORG() == null ? null : zssd00030.getVKORG().getVKORG_type6());
                et.setVTWEG(zssd00030.getVTWEG() == null ? null : zssd00030.getVTWEG().getVTWEG_type6());
                records.add(et);
            }
            //            }
        }
        return records;
    }
    
    

    /**
     * 客户渠道主数据
     *
     * @param response
     * @return
     */
    private Map<String, List<ET_VKORG>> getET_VKORG(ZSD_CUSTOMER_DATA_SYN_RFCResponse response) {
        List<ET_VKORG> records = new ArrayList<ET_VKORG>();
        ZSSD00003[] zssd00003s = response.getET_VKORG().getItem();
        Map<String, List<ET_VKORG>> map = new HashMap<String, List<ET_VKORG>>();
        List<ET_VKORG> zy = new ArrayList<>();
        List<ET_VKORG> wb = new ArrayList<>();
        if (zssd00003s.length > 0) {
            for (ZSSD00003 zssd00003 : zssd00003s) {
                if (zssd00003.getVTWEG() != null && VKORG.equals(zssd00003.getVTWEG().getVTWEG_type10())) {
                    ET_VKORG et = new ET_VKORG();
                    String kvgr2 = zssd00003.getKVGR2() == null ? null : zssd00003.getKVGR2().getKVGR2_type0();
                    et.setKUNNR(zssd00003.getKUNNR() == null ? null : zssd00003.getKUNNR().getKUNNR_type8());
                    et.setVTWEG(zssd00003.getVTWEG() == null ? null : zssd00003.getVTWEG().getVTWEG_type10());
                    et.setVKORG(zssd00003.getVKORG() == null ? null : zssd00003.getVKORG().getVKORG_type10());
                    et.setSPART(zssd00003.getSPART() == null ? null : zssd00003.getSPART().getSPART_type8());
                    et.setKDGRP(zssd00003.getKDGRP() == null ? null : zssd00003.getKDGRP().getKDGRP_type0());
                    et.setKUNWE(zssd00003.getKUNWE() == null ? null : zssd00003.getKUNWE().getKUNWE_type2());
                    et.setKVGR1(zssd00003.getKVGR1() == null ? null : zssd00003.getKVGR1().getKVGR1_type0());
                    et.setKVGR2(zssd00003.getKVGR2() == null ? null : zssd00003.getKVGR2().getKVGR2_type0());
                    if (org.apache.commons.lang.StringUtils.isNotEmpty(kvgr2) && "01".equals(kvgr2)) {
                        zy.add(et);
                    } else if (org.apache.commons.lang.StringUtils.isNotEmpty(kvgr2) && "02".equals(kvgr2)) {
                        wb.add(et);
                    }
                }
            }
            map.put("01", zy);
            map.put("02", wb);
        }
        return map;
    }
    
    
    /**
     * 客户渠道主数据
     *
     * @param response
     * @return
     */
    private List<ET_VKORG> getET_VKORG18(ZSD_CUSTOMER_DATA_SYN_RFCResponse response) {
        ZSSD00003[] zssd00003s = response.getET_VKORG().getItem();
        List<ET_VKORG> zy = new ArrayList<>();
        if (zssd00003s.length > 0) {
            for (ZSSD00003 zssd00003 : zssd00003s) {
                if (zssd00003.getVTWEG() != null) {
                    ET_VKORG et = new ET_VKORG();
                    et.setKUNNR(zssd00003.getKUNNR() == null ? null : zssd00003.getKUNNR().getKUNNR_type8());
                    et.setVTWEG(zssd00003.getVTWEG() == null ? null : zssd00003.getVTWEG().getVTWEG_type10());
                    et.setVKORG(zssd00003.getVKORG() == null ? null : zssd00003.getVKORG().getVKORG_type10());
                    et.setSPART(zssd00003.getSPART() == null ? null : zssd00003.getSPART().getSPART_type8());
                    et.setKDGRP(zssd00003.getKDGRP() == null ? null : zssd00003.getKDGRP().getKDGRP_type0());
                    et.setKUNWE(zssd00003.getKUNWE() == null ? null : zssd00003.getKUNWE().getKUNWE_type2());
                    et.setKVGR1(zssd00003.getKVGR1() == null ? null : zssd00003.getKVGR1().getKVGR1_type0());
                    et.setKVGR2(zssd00003.getKVGR2() == null ? null : zssd00003.getKVGR2().getKVGR2_type0());
                    zy.add(et);
                }
            }
        }
        return zy;
    }

    private ZT_MasterDataQueryServiceStub getZt_masterDataQueryServiceStub() throws org.apache.axis2.AxisFault {
        ZT_MasterDataQueryServiceStub client = new ZT_MasterDataQueryServiceStub(URL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }
    
    /**
     * 获取供货商client
     * @return
     * @throws org.apache.axis2.AxisFault
     */
    private OA_MasterData_OutServiceStub getOA_MasterData_OutServiceStub() throws org.apache.axis2.AxisFault {
    	OA_MasterData_OutServiceStub client = new OA_MasterData_OutServiceStub(SUPPLIER_URL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    public MARM[] getET_MARM(ZSD_MATERAIL_DATA_RFCResponse response) {
        ET_MARM_type1 et_marm_type1 = response.getET_MARM();
        MARM[] marms = et_marm_type1.getItem();
        return marms;
    }

    /**
     * 获取产品数据
     *
     * @param response
     * @return
     */
    private List<ET_MATNR> getET_MATNR(ZSD_MATERAIL_DATA_RFCResponse response,String vkorg) {

        ET_MATNR_type1 et_matnr = response.getET_MATNR();
        ZSSD00005[] zssd00005s = et_matnr.getItem();
        List<ET_MATNR> records = new ArrayList<ET_MATNR>();
        if (zssd00005s.length > 0) {
            for (ZSSD00005 zssd00005 : zssd00005s) {
                VTWEG_type3 vtweg_type3 = zssd00005.getVTWEG();
                if (vtweg_type3 != null && vkorg.equals(vtweg_type3.getVTWEG_type2()) && zssd00005.getMATNR() != null && zssd00005.getMTPOS_MARA() != null && ZORM.equals(zssd00005.getMTPOS_MARA().getMTPOS_MARA_type0())) {
                    ET_MATNR etMatnr = new ET_MATNR();
                    etMatnr.setMATNR(zssd00005.getMATNR().getMATNR_type6());//    "matnr",
                    etMatnr.setBOMX(zssd00005.getBOMX() == null ? null : zssd00005.getBOMX().getBOMX_type0());   //    "bomx",
                    etMatnr.setGEWEI(zssd00005.getGEWEI() == null ? null : zssd00005.getGEWEI().getGEWEI_type2());//    "gewei"
                    etMatnr.setMEINS(zssd00005.getMEINS() == null ? null : zssd00005.getMEINS().getMEINS_type2());//    "meins",
                    etMatnr.setMTPOSMARA(zssd00005.getMTPOS_MARA() == null ? null : zssd00005.getMTPOS_MARA().getMTPOS_MARA_type0());//    "mtposmara",
                    etMatnr.setNTGEW(zssd00005.getNTGEW() == null ? null : zssd00005.getNTGEW().getNTGEW_type0());//    "ntgew",
                    etMatnr.setSPART(zssd00005.getSPART() == null ? null : zssd00005.getSPART().getSPART_type0());//    "spart",
                    etMatnr.setVKORG(zssd00005.getVKORG() == null ? null : zssd00005.getVKORG().getVKORG_type2());//    "vkorg",
                    etMatnr.setVTWEG(zssd00005.getVTWEG() == null ? null : zssd00005.getVTWEG().getVTWEG_type2());//    "vtweg",
                    etMatnr.setWERKS(zssd00005.getWERKS() == null ? null : zssd00005.getWERKS().getWERKS_type2());
                    etMatnr.setMTPOSMARA(zssd00005.getMTPOS_MARA() == null ? null : zssd00005.getMTPOS_MARA().getMTPOS_MARA_type0());
                    etMatnr.setMTART(zssd00005.getMTART() == null ? null : zssd00005.getMTART().getMTART_type0());
                    records.add(etMatnr);
                }
            }
        }
        return records;
    }

    /**
     * 产品的描述
     *
     * @param response
     * @return
     */
    private Map getET_MAKTX(ZSD_MATERAIL_DATA_RFCResponse response) {
        ET_MAKTX_type1 et_maktx = response.getET_MAKTX();
        ZSSD00008[] zssd00008s = et_maktx.getItem();
        Map<String, String> map = new HashMap<String, String>();
        if (zssd00008s.length > 0)
            for (ZSSD00008 zssd00008 : zssd00008s) {
                map.put(zssd00008.getMATNR().getMATNR_type2(), zssd00008.getMAKTX().getMAKTX_type0());
            }
        return map;
    }

    /**
     * 物料的增强属性
     *
     * @param response
     * @return
     */
    private Map<String, ZTMM00037> getET_ZTMM00037(ZSD_MATERAIL_DATA_RFCResponse response) {
        ET_ZTMM00037_type1 et_ztmm00037_type1 = response.getET_ZTMM00037();
        Map<String, ZTMM00037> result = new HashMap<String, ZTMM00037>();
        if (et_ztmm00037_type1 != null) {
            ZTMM00037[] ztmm00037s = et_ztmm00037_type1.getItem();
            for (ZTMM00037 ztmm00037 : ztmm00037s) {
                result.put(ztmm00037.getMATNR().getMATNR_type8(), ztmm00037);
            }
        }
        return result;
    }

    public Map<String, TMdMara> findAll() {
        Map<String, TMdMara> results = new HashMap<String, TMdMara>();
        List<TMdMara> lists = piProductMapper.findAll();
        for (TMdMara tMdMara : lists) {
            results.put(tMdMara.getMatnr(), tMdMara);
        }
        return results;
    }
}
