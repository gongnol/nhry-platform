package com.nhry.service.pi.impl;

import com.google.common.collect.Lists;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.basic.dao.TVipCrmAddressMapper;
import com.nhry.data.basic.domain.*;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.model.webService.CustomerComplainModel;
import com.nhry.service.basic.dao.*;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.pi.dao.PIVipInfoDataService;
import com.nhry.service.pi.pojo.CustomerComplain;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.Address.MemberAddrUpdateServiceStub;
import com.nhry.webService.client.Address.functions.*;
import com.nhry.webService.client.EvMemb;
import com.nhry.webService.client.MemberActivities.MemberActCreateServiceStub;
import com.nhry.webService.client.MemberActivities.functions.*;
import com.nhry.webService.client.MemberActivities.functions.SALES_ORG_type1;
import com.nhry.webService.client.PISuccessTMessage;
import com.nhry.webService.client.VipDetailData.PTDetailQuery_OutServiceStub;
import com.nhry.webService.client.VipInfoData.ZT_CRM_BuData_MaintainServiceStub;
import com.nhry.webService.client.VipInfoData.functions.*;
import com.nhry.webService.client.VipInfoData.functions.ADDRESS_GUID_type1;
import com.nhry.webService.client.VipInfoData.functions.CITY1_type1;
import com.nhry.webService.client.VipInfoData.functions.CITY2_type1;
import com.nhry.webService.client.VipInfoData.functions.COUNTRY_type1;
import com.nhry.webService.client.VipInfoData.functions.IV_MEMB_GUID_type1;
import com.nhry.webService.client.VipInfoData.functions.NAME_CO_type1;
import com.nhry.webService.client.VipInfoData.functions.POST_CODE1_type1;
import com.nhry.webService.client.VipInfoData.functions.REGION_type1;
import com.nhry.webService.client.VipInfoData.functions.STREET_type1;
import com.nhry.webService.client.VipInfoData.functions.STR_SUPPL1_type1;
import com.nhry.webService.client.VipInfoData.functions.STR_SUPPL2_type1;
import com.nhry.webService.client.VipInfoData.functions.TEL_MOBILE_type1;
import com.nhry.webService.client.VipInfoData.functions.TEL_NUMBER_type1;
import com.nhry.webService.client.VipPoint.PointQuery_OutServiceStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cbz on 7/30/2016.
 */
public class PIVipInfoDataServiceImpl implements PIVipInfoDataService {
    private static Logger logger = Logger.getLogger(PIVipInfoDataServiceImpl.class);
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
    private TVipCrmInfoService vipCrmInfoService;
    private DictionaryService dictionaryService;
    private ResidentialAreaService residentialAreaService;
    private BranchService branchService;
    private TVipCustInfoService vipCustInfoService;
    private TVipCrmAddressMapper vipCrmAddressMapper;
    private TaskExecutor taskExecutor;
    private BranchEmpService branchEmpService;

    public void setBranchEmpService(BranchEmpService branchEmpService) {
        this.branchEmpService = branchEmpService;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public void setResidentialAreaService(ResidentialAreaService residentialAreaService) {
        this.residentialAreaService = residentialAreaService;
    }

    public void setBranchService(BranchService branchService) {
        this.branchService = branchService;
    }

    public void setVipCustInfoService(TVipCustInfoService vipCustInfoService) {
        this.vipCustInfoService = vipCustInfoService;
    }

    public void setVipCrmInfoService(TVipCrmInfoService vipCrmInfoService) {
        this.vipCrmInfoService = vipCrmInfoService;
    }

    public void setVipCrmAddressMapper(TVipCrmAddressMapper vipCrmAddressMapper) {
        this.vipCrmAddressMapper = vipCrmAddressMapper;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    private static final String URL = EnvContant.getSystemConst("PI.VipInfoData.URL");
    private static final String POINTURL = EnvContant.getSystemConst("PI.VipPointData.URL");
    private static final String DetailURL = EnvContant.getSystemConst("PI.VipDetialData.URL");
    private static final String MESSAGE_FLAG = PIPropertitesUtil.getValue("PI.MESSAGE.FLAG.OK");
    private static final String MEMBERACTURL = EnvContant.getSystemConst("PI.MemberActCreate.URL");
    private static final String MEMBERADDR = EnvContant.getSystemConst("PI.MemberAddrUpdate.URL");
    private static final String PICRMEXEC = EnvContant.getSystemConst("PI.CRM.EXEC");

    public static void main(String[] args) {
        System.out.println(URL);
        System.out.println(POINTURL);
        System.out.println(DetailURL);
        System.out.println(MEMBERACTURL);
        System.out.println(MEMBERADDR);
        System.out.println(PICRMEXEC);
    }

    @Override
    public PISuccessTMessage generateVipInfoData(TVipCustInfo vipCustInfo, String vipTel) {

        PISuccessTMessage<EvMemb> result = new PISuccessTMessage<EvMemb>();
        if (vipCustInfo != null) {
            Map<String, String> attrs = new HashMap<String, String>();
            if (StringUtils.isEmpty(vipTel)) {
                attrs.put("phone", vipCustInfo.getMp());
                vipTel = vipCustInfo.getMp();
            } else {
                attrs.put("phone", vipTel);
            }
            String vipno = vipCrmInfoService.getCrmNoByPhone(attrs);
            java.util.List<TMdAddress> addresses = vipCustInfoService.findCnAddressByCustNo(vipCustInfo.getVipCustNo());
            TMdAddress address = null;
            if (StringUtils.isNotEmpty(vipno)) {
                vipCustInfo.setVipCustNoSap(vipno);
                vipCustInfo.setVipMp(vipTel);
                vipCustInfoService.updateSapNo(vipCustInfo);
                result.setSuccess(true);
                result.setMessage("会员已经存在！");
            } else {
                try {
                    iniVipCustInfo(vipCustInfo);
                    TVipCrmInfo vipCrmInfo = new TVipCrmInfo();
                    BeanUtils.copyProperties(vipCrmInfo, vipCustInfo);
                    vipCrmInfo.setMp(vipTel);
                    for (TMdAddress address1 : addresses) {
                        if ("Y".equals(address1.getIsDafault())) {
                            address = address1;
                        }
                    }
//                    TVipCrmAddress vipCrmAddress = new TVipCrmAddress();
                    if (address != null) {
//                        BeanUtils.copyProperties(vipCrmAddress, address);
                        vipCrmInfo.setAddressId(address.getAddressId());
                    }
                    ZT_CRM_BuData_MaintainServiceStub client = connMaintainService();
                    Z_CRM_MEMB_MSTDATA_UPD_DH z_crm_memb_mstdata_upd_dh = new Z_CRM_MEMB_MSTDATA_UPD_DH();
                    ZSCRM_MEMB_UPD_DH_INPUT zscrm_memb_upd_dh_input = new ZSCRM_MEMB_UPD_DH_INPUT();
                    NAME_LAST_type1 name_last_type1 = new NAME_LAST_type1();
                    name_last_type1.setNAME_LAST_type0(vipCustInfo.getVipName());
                    zscrm_memb_upd_dh_input.setNAME_LAST(name_last_type1);
                    //不用传了
//                if(address!=null) {
//                    ADDRESS_GUID_type1 address_guid_type1 = new ADDRESS_GUID_type1();
//                    address_guid_type1.setADDRESS_GUID_type0(address.getAddressId());
//                    zscrm_memb_upd_dh_input.setADDRESS_GUID(address_guid_type1);
//                }

                    NAME_CO_type1 name_co_type1 = new NAME_CO_type1();
                    name_co_type1.setNAME_CO_type0(vipCustInfo.getVipName());
                    zscrm_memb_upd_dh_input.setNAME_CO(name_co_type1);

                    STR_SUPPL1_type1 str_suppl1_type1 = new STR_SUPPL1_type1();
                    str_suppl1_type1.setSTR_SUPPL1_type0(vipCustInfo.getAddressTxt() == null ? "" : vipCustInfo.getAddressTxt());
                    zscrm_memb_upd_dh_input.setSTR_SUPPL1(str_suppl1_type1);

                    COUNTRY_type1 country_type1 = new COUNTRY_type1();
                    country_type1.setCOUNTRY_type0("CN");//(vipCustInfo.getCountry());
                    zscrm_memb_upd_dh_input.setCOUNTRY(country_type1);

                    REGION_type1 region_type1 = new REGION_type1();
                    region_type1.setREGION_type0(vipCustInfo.getProvince() == null ? "" : vipCustInfo.getProvince());
                    zscrm_memb_upd_dh_input.setREGION(region_type1);

                    CITY1_type1 city1_type1 = new CITY1_type1();
                    city1_type1.setCITY1_type0(vipCustInfo.getCity() == null ? "" : vipCustInfo.getCity());
                    zscrm_memb_upd_dh_input.setCITY1(city1_type1);

                    CITY2_type1 cit2_type1 = new CITY2_type1();
                    cit2_type1.setCITY2_type0(vipCustInfo.getCounty() == null ? "" : vipCustInfo.getCounty());
                    zscrm_memb_upd_dh_input.setCITY2(cit2_type1);

                    STREET_type1 street_type1 = new STREET_type1();
                    street_type1.setSTREET_type0(vipCustInfo.getStreet() == null ? "" : vipCustInfo.getStreet());
                    zscrm_memb_upd_dh_input.setSTREET(street_type1);

                    STR_SUPPL2_type1 str_suppl2_type1 = new STR_SUPPL2_type1();
                    str_suppl2_type1.setSTR_SUPPL2_type0(vipCustInfo.getSubdist() == null ? "" : vipCustInfo.getSubdist());
                    zscrm_memb_upd_dh_input.setSTR_SUPPL2(str_suppl2_type1);

                    TEL_MOBILE_type1 tel_mobile_type1 = new TEL_MOBILE_type1();
                    tel_mobile_type1.setTEL_MOBILE_type0(vipCustInfo.getMp());
                    zscrm_memb_upd_dh_input.setTEL_MOBILE(tel_mobile_type1);

                    TEL_NUMBER_type1 tel_number_type1 = new TEL_NUMBER_type1();
                    tel_number_type1.setTEL_NUMBER_type0(vipCustInfo.getTel() == null ? "" : vipCustInfo.getTel());
                    zscrm_memb_upd_dh_input.setTEL_NUMBER(tel_number_type1);


                    ZZFLD0000DM_type1 zzfld0000DM_type1 = new ZZFLD0000DM_type1();
                    zzfld0000DM_type1.setZZFLD0000DM_type0(vipCustInfo.getActivityNo() == null ? "" : vipCustInfo.getActivityNo());
                    zscrm_memb_upd_dh_input.setZZFLD0000DM(zzfld0000DM_type1);

                    POST_CODE1_type1 post_code1_type1 = new POST_CODE1_type1();
                    post_code1_type1.setPOST_CODE1_type0(vipCustInfo.getZip() == null ? "" : vipCustInfo.getZip());
                    zscrm_memb_upd_dh_input.setPOST_CODE1(post_code1_type1);

                    SMTP_ADDR_type1 smtp_addr_type1 = new SMTP_ADDR_type1();
                    smtp_addr_type1.setSMTP_ADDR_type0(vipCustInfo.getEmail() == null ? "" : vipCustInfo.getEmail());
                    zscrm_memb_upd_dh_input.setSMTP_ADDR(smtp_addr_type1);

                    ALIPAY_ACCOUNT_type1 alipay_account_type1 = new ALIPAY_ACCOUNT_type1();
                    alipay_account_type1.setALIPAY_ACCOUNT_type0(vipCustInfo.getAlipayAccount() == null ? "" : vipCustInfo.getAlipayAccount());
                    zscrm_memb_upd_dh_input.setALIPAY_ACCOUNT(alipay_account_type1);

                    WEBCHAT_NO_type1 webchat_no_type1 = new WEBCHAT_NO_type1();
                    webchat_no_type1.setWEBCHAT_NO_type0(vipCustInfo.getWebchatNo() == null ? "" : vipCustInfo.getWebchatNo());
                    zscrm_memb_upd_dh_input.setWEBCHAT_NO(webchat_no_type1);

                    NH_EC_ACCOUNT_type1 nh_ec_account_type1 = new NH_EC_ACCOUNT_type1();
                    nh_ec_account_type1.setNH_EC_ACCOUNT_type0(vipCustInfo.getNhEcAccount() == null ? "" : vipCustInfo.getNhEcAccount());
                    zscrm_memb_upd_dh_input.setNH_EC_ACCOUNT(nh_ec_account_type1);

                    JD_ACCOUNT_type1 jd_account_type1 = new JD_ACCOUNT_type1();
                    jd_account_type1.setJD_ACCOUNT_type0(vipCustInfo.getJdAccount() == null ? "" : vipCustInfo.getJdAccount());
                    zscrm_memb_upd_dh_input.setJD_ACCOUNT(jd_account_type1);

                    SEX_type1 sex_type1 = new SEX_type1();
                    sex_type1.setSEX_type0(vipCustInfo.getSex() == null ? "" : vipCustInfo.getSex());
                    zscrm_memb_upd_dh_input.setSEX(sex_type1);

                    if (vipCustInfo.getBirthday() != null) {
                        Date date = new Date();
                        date.setObject(vipCustInfo.getBirthday());
                        zscrm_memb_upd_dh_input.setBIRTHDT(date);
                    }
                    CERT_ID_type1 cert_id_type1 = new CERT_ID_type1();
                    cert_id_type1.setCERT_ID_type0(vipCustInfo.getCertId() == null ? "" : vipCustInfo.getCertId());
                    zscrm_memb_upd_dh_input.setCERT_ID(cert_id_type1);

                    REMARKS_type1 remarks_type1 = new REMARKS_type1();
                    remarks_type1.setREMARKS_type0(vipCustInfo.getMemoTxt() == null ? "" : vipCustInfo.getMemoTxt());
                    zscrm_memb_upd_dh_input.setREMARKS(remarks_type1);

                    ZZFLD00006T_type1 zzfld00006T_type1 = new ZZFLD00006T_type1();
                    zzfld00006T_type1.setZZFLD00006T_type0(vipCustInfo.getSalesOrg() == null ? "" : vipCustInfo.getSalesOrg());
                    zscrm_memb_upd_dh_input.setZZFLD00006T(zzfld00006T_type1);

                    DELIVER_REMARKS_type1 deliver_remarks_type1 = new DELIVER_REMARKS_type1();
                    deliver_remarks_type1.setDELIVER_REMARKS_type0(vipCustInfo.getDispMemoTxt() == null ? "" : vipCustInfo.getDispMemoTxt());
                    zscrm_memb_upd_dh_input.setDELIVER_REMARKS(deliver_remarks_type1);

                    ZSCRM_ZTAB0000LQ zscrm_ztab0000LQ = new ZSCRM_ZTAB0000LQ();

                    ZZFLD0000B4_type1 zzfld0000B4_type1 = new ZZFLD0000B4_type1();
                    zzfld0000B4_type1.setZZFLD0000B4_type0(vipCustInfo.getVipCustNo());
                    zscrm_ztab0000LQ.setZZFLD0000B4(zzfld0000B4_type1);

                    ZZFLD0000B8_type1 zzfld0000B8_type1 = new ZZFLD0000B8_type1();
                    zzfld0000B8_type1.setZZFLD0000B8_type0(vipCustInfo.getMp());
                    zscrm_ztab0000LQ.setZZFLD0000B8(zzfld0000B8_type1);

                    ZZFLD0000B6_type1 zzfld0000B6_type1 = new ZZFLD0000B6_type1();
                    zzfld0000B6_type1.setZZFLD0000B6_type0(vipCustInfo.getMilkbox() == null ? "" : vipCustInfo.getMilkbox());
                    zscrm_ztab0000LQ.setZZFLD0000B6(zzfld0000B6_type1);

                    ZZFLD0000B5_type1 zzfld0000B5_type1 = new ZZFLD0000B5_type1();
                    zzfld0000B5_type1.setZZFLD0000B5_type0(vipCustInfo.getVipType() == null ? "" : vipCustInfo.getVipType());
                    zscrm_ztab0000LQ.setZZFLD0000B5(zzfld0000B5_type1);
                    if (vipCustInfo.getSubscribeDate() != null) {
                        Date zdDate = new Date();
                        zdDate.setObject(vipCustInfo.getSubscribeDate());
                        zscrm_ztab0000LQ.setZZFLD0000BA(zdDate);
                    }
                    ZZFLD0000B9_type1 zzfld0000B9_type1 = new ZZFLD0000B9_type1();
                    zzfld0000B9_type1.setZZFLD0000B9_type0(vipCustInfo.getSubscriber() == null ? "" : vipCustInfo.getSubscriber());
                    zscrm_ztab0000LQ.setZZFLD0000B9(zzfld0000B9_type1);

                    ZZFLD0000B7_type1 zzfld0000B7_type1 = new ZZFLD0000B7_type1();
                    zzfld0000B7_type1.setZZFLD0000B7_type0(vipCustInfo.getStatus() == null ? "" : vipCustInfo.getStatus());
                    zscrm_ztab0000LQ.setZZFLD0000B7(zzfld0000B7_type1);
                    if (vipCustInfo.getFirstOrderTime() != null) {
                        Date bbDate = new Date();
                        bbDate.setObject(vipCustInfo.getFirstOrderTime());
                        zscrm_ztab0000LQ.setZZFLD0000BB(bbDate);
                    }
                    ZZFLD0000BD_type1 zzfld0000BD_type1 = new ZZFLD0000BD_type1();
                    zzfld0000BD_type1.setZZFLD0000BD_type0(vipCustInfo.getBranchNo());
                    zscrm_ztab0000LQ.setZZFLD0000BD(zzfld0000BD_type1);

                    //TODO 退订日期  地址唯一编号
                    ZZFLD0000BE_type1 zzfld0000BE_type1 = new ZZFLD0000BE_type1();
                    zzfld0000BE_type1.setZZFLD0000BE_type0(vipCustInfo.getBranchName());
                    zscrm_ztab0000LQ.setZZFLD0000BE(zzfld0000BE_type1);

                    T_ZTAB0000LQ_type0 t_ztab0000LQ_type0 = new T_ZTAB0000LQ_type0();
                    t_ztab0000LQ_type0.addItem(zscrm_ztab0000LQ);
                    z_crm_memb_mstdata_upd_dh.setT_ZTAB0000LQ(t_ztab0000LQ_type0);
                    z_crm_memb_mstdata_upd_dh.setIS_DATA_INPUT(zscrm_memb_upd_dh_input);

                    Z_CRM_MEMB_MSTDATA_UPD_DHResponse response = client.memberCreate(z_crm_memb_mstdata_upd_dh);

                    com.nhry.webService.client.VipInfoData.functions.ZSCRM_MESSAGE message = response.getES_RETURN();
                    String flag = message.getFLAG().getFLAG_type0().toString();
                    String msg = message.getMSG().getMSG_type0().toString();
                    result.setMessage(msg);
                    vipno = response.getEV_MEMB_GUID().getEV_MEMB_GUID_type0().toString();
                    if (MESSAGE_FLAG.equals(flag) || StringUtils.isNotEmpty(vipno)) {
                        result.setSuccess(true);
                        EvMemb evMemb = new EvMemb();
                        vipno = response.getEV_MEMB_GUID().getEV_MEMB_GUID_type0().toString();
                        evMemb.setEvMembGuid(vipno);
                        String evMembId = response.getEV_MEMB_ID().getEV_MEMB_ID_type0().toString();
                        evMemb.setEvMembId(evMembId);
                        result.setData(evMemb);
                        vipCrmInfo.setVipCustNo(vipno);
                        vipCrmInfo.setVipCustNoSap(evMembId);
                        vipCrmInfoService.addVipCrm(vipCrmInfo);

//                        vipCrmAddress.setSapGuid(vipno);
//                        vipCrmAddress.setIsDefault("Y");
//                        vipCrmAddress.setIsDelete("N");
//                        vipCrmAddressMapper.addVipCrmAddress(vipCrmAddress);
                        vipCustInfo.setVipCustNoSap(vipno);
                        vipCustInfo.setVipMp(vipTel);
                        vipCustInfoService.updateSapNo(vipCustInfo);
                    } else {
                        logger.info("会员账号创建失败！返回状态是：" + flag + ";消息：" + msg +";手机号："+vipCustInfo.getMp()+";GUID"+vipno);
                        result.setSuccess(false);
                    }
                    logger.info(msg);
                } catch (Exception e) {
                    result.setSuccess(false);
                    logger.error("会员账号创建失败！" + vipCustInfo.getMp() + e.getMessage());
                    result.setMessage("会员账号创建失败！"+vipCustInfo.getMp());
                }
            }
            if (result.isSuccess()) {
                try {
                    //发送地址
                    if(addresses.size()>0) {
                        sendAddress(addresses, vipno);
                    }
//                executeUptVipCust(vipCustInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public void executeVipInfoData(TVipCustInfo vipCustInfo, String vipTel) {
        if ("on".equals(PICRMEXEC)) {
            taskExecutor.execute(new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        this.setName(vipCustInfo.getVipCustNo());
                        generateVipInfoData(vipCustInfo, vipTel);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void iniVipCustInfo(TVipCustInfo vipCustInfo) {
        if (StringUtils.isNotEmpty(vipCustInfo.getSubdist())) {
            TMdResidentialArea area = residentialAreaService.selectById(vipCustInfo.getSubdist());
            if (area != null) {
                vipCustInfo.setSubdist(area.getResidentialAreaTxt());
            }
        }
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode("1001");
        codeItem.setItemCode(vipCustInfo.getCity());
        NHSysCodeItem city = dictionaryService.findCodeItenByCode(codeItem);
        if (city != null) {
            vipCustInfo.setCity(city.getItemName());
        }
        TMdBranch branch = branchService.selectBranchByNo(vipCustInfo.getBranchNo());
        if (branch != null) {
            vipCustInfo.setBranchName(branch.getBranchName());
        }
        codeItem.setItemCode(vipCustInfo.getCounty());
        NHSysCodeItem county = dictionaryService.findCodeItenByCode(codeItem);
        if (county != null) {
            vipCustInfo.setCounty(county.getItemName());
        }
    }


    @Override
    public PISuccessTMessage queryVipDetailData(String tel, String membGuid, String membId) {

        return null;
    }

    @Override
    public PISuccessTMessage createMemberActivities(MemberActivities memberActivities) {
        PISuccessTMessage result = new PISuccessTMessage();
        if ("off".equals(PICRMEXEC)) {
            result.setSuccess(true);
            result.setMessage("暂停使用！");
            return result;
        }
        try {
            MemberActCreateServiceStub client = connMemberActService();
            Z_CRM_MEMB_ACTIVITIES_CREATE z_crm_memb_activities_create = new Z_CRM_MEMB_ACTIVITIES_CREATE();
            ZSCRM_MEMB_ACTIVITIES zscrm_memb_activities = new ZSCRM_MEMB_ACTIVITIES();

            ACTIVITY_DATE_type1 activity_date_type1 = new ACTIVITY_DATE_type1();
            activity_date_type1.setACTIVITY_DATE_type0(new BigDecimal(formatter.format(memberActivities.getActivitydate())));
            zscrm_memb_activities.setACTIVITY_DATE(activity_date_type1);

            if (memberActivities.getAmount() != null) {
                AMOUNT_type1 amount_type1 = new AMOUNT_type1();
                amount_type1.setAMOUNT_type0(memberActivities.getAmount());
                zscrm_memb_activities.setAMOUNT(amount_type1);
            }

//            CARD_ID_type1 card_id_type1 = new CARD_ID_type1();
//            card_id_type1.setCARD_ID_type0(memberActivities.getCardid());
//            zscrm_memb_activities.setCARD_ID(card_id_type1);

            CATEGORY_type1 category_type1 = new CATEGORY_type1();
            category_type1.setCATEGORY_type0(memberActivities.getCategory());
            zscrm_memb_activities.setCATEGORY(category_type1);

            COMMIT_type1 commit_type1 = new COMMIT_type1();
            commit_type1.setCOMMIT_type0(memberActivities.getCommit() == null ? "X" : memberActivities.getCommit());
            zscrm_memb_activities.setCOMMIT(commit_type1);

            CURRENCY_type1 currency_type1 = new CURRENCY_type1();
            currency_type1.setCURRENCY_type0(memberActivities.getCurrency() == null ? "" : memberActivities.getCurrency());
            zscrm_memb_activities.setCURRENCY(currency_type1);

            ITEM_NUM_type1 item_num_type1 = new ITEM_NUM_type1();
            item_num_type1.setITEM_NUM_type0(memberActivities.getItemnum() == null ? "" : memberActivities.getItemnum());
            zscrm_memb_activities.setITEM_NUM(item_num_type1);

            MEMBERSHIP_GUID_type1 membership_guid_type1 = new MEMBERSHIP_GUID_type1();
            membership_guid_type1.setMEMBERSHIP_GUID_type0(memberActivities.getMembershipguid());
            zscrm_memb_activities.setMEMBERSHIP_GUID(membership_guid_type1);

            ORDER_ID_type1 order_id_type1 = new ORDER_ID_type1();
            order_id_type1.setORDER_ID_type0(memberActivities.getOrderid() == null ? "" : memberActivities.getOrderid());
            zscrm_memb_activities.setORDER_ID(order_id_type1);

            POINT_TYPE_type1 point_type_type1 = new POINT_TYPE_type1();
            point_type_type1.setPOINT_TYPE_type0(memberActivities.getPointtype() == null ? "" : memberActivities.getPointtype());
            zscrm_memb_activities.setPOINT_TYPE(point_type_type1);

            PROCESS_type1 process_type1 = new PROCESS_type1();
            process_type1.setPROCESS_type0(memberActivities.getProcess() == null ? "X" : memberActivities.getProcess());
            zscrm_memb_activities.setPROCESS(process_type1);

            PRODUCT_ID_type1 product_id_type1 = new PRODUCT_ID_type1();
            product_id_type1.setPRODUCT_ID_type0(memberActivities.getProductid() == null ? "" : memberActivities.getProductid());
            zscrm_memb_activities.setPRODUCT_ID(product_id_type1);

            if (memberActivities.getProductquantity() != null) {
                PRODUCT_QUANTITY_type1 product_quantity_type1 = new PRODUCT_QUANTITY_type1();
                product_quantity_type1.setPRODUCT_QUANTITY_type0(memberActivities.getProductquantity());
                zscrm_memb_activities.setPRODUCT_QUANTITY(product_quantity_type1);
            }

            RETAIL_STORE_ID_type1 retail_store_id_type1 = new RETAIL_STORE_ID_type1();
            retail_store_id_type1.setRETAIL_STORE_ID_type0(memberActivities.getRetailstoreid() == null ? "" : memberActivities.getRetailstoreid());
            zscrm_memb_activities.setRETAIL_STORE_ID(retail_store_id_type1);

            SALES_ORG_type1 sales_org_type1 = new SALES_ORG_type1();
            sales_org_type1.setSALES_ORG_type0(memberActivities.getSalesorg());
            zscrm_memb_activities.setSALES_ORG(sales_org_type1);

            TRAN_SEQ_NUM_type1 tran_seq_num_type1 = new TRAN_SEQ_NUM_type1();
            tran_seq_num_type1.setTRAN_SEQ_NUM_type0("");
            zscrm_memb_activities.setTRAN_SEQ_NUM(tran_seq_num_type1);

            TIER_type1 tier_type1 = new TIER_type1();
            tier_type1.setTIER_type0(memberActivities.getTier() == null ? "" : memberActivities.getTier());
            zscrm_memb_activities.setTIER(tier_type1);

            TIER_GROUP_type1 tier_group_type1 = new TIER_GROUP_type1();
            tier_group_type1.setTIER_GROUP_type0(memberActivities.getTiergroup() == null ? "" : memberActivities.getTiergroup());
            zscrm_memb_activities.setTIER_GROUP(tier_group_type1);

            PROCESS_TYPE_type1 process_type_type1 = new PROCESS_TYPE_type1();
            process_type_type1.setPROCESS_TYPE_type0(memberActivities.getProcesstype() == null ? "" : memberActivities.getProcesstype());
            zscrm_memb_activities.setPROCESS_TYPE(process_type_type1);

            if (memberActivities.getPoints() != null) {
                POINTS_type1 points_type1 = new POINTS_type1();
                points_type1.setPOINTS_type0(memberActivities.getPoints());
                zscrm_memb_activities.setPOINTS(points_type1);
            }
            z_crm_memb_activities_create.setIS_MEMB_ACT(zscrm_memb_activities);

            Z_CRM_MEMB_ACTIVITIES_CREATEResponse response = client.memberActCreate(z_crm_memb_activities_create);

            com.nhry.webService.client.MemberActivities.functions.ZSCRM_MESSAGE message = response.getES_RETURN();
            String flag = message.getFLAG().getFLAG_type0();
            String msg = message.getMSG().getMSG_type0();
            if (MESSAGE_FLAG.equals(flag)) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
            result.setMessage(msg);
            logger.info(msg);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public PISuccessTMessage sendSubscriber(TVipCustInfo vipCustInfo) {
        PISuccessTMessage result = new PISuccessTMessage();
        try {
            iniVipCustInfo(vipCustInfo);
            ZT_CRM_BuData_MaintainServiceStub stub = connMaintainService();
            Z_CRM_MEMB_ZTAB0000LQ_UPDATE z_crm_memb_ztab0000LQ_update = new Z_CRM_MEMB_ZTAB0000LQ_UPDATE();

            IV_MEMB_GUID_type1 iv_memb_guid_type1 = new IV_MEMB_GUID_type1();
            iv_memb_guid_type1.setIV_MEMB_GUID_type0(vipCustInfo.getVipCustNoSap());
            z_crm_memb_ztab0000LQ_update.setIV_MEMB_GUID(iv_memb_guid_type1);

            T_ZTAB0000LQ_type2 t_ztab0000LQ_type2 = new T_ZTAB0000LQ_type2();
            ZSCRM_ZTAB0000LQ zscrm_ztab0000LQ = new ZSCRM_ZTAB0000LQ();

            ZZFLD0000B4_type1 zzfld0000B4_type1 = new ZZFLD0000B4_type1();
            zzfld0000B4_type1.setZZFLD0000B4_type0(vipCustInfo.getVipCustNo());
            zscrm_ztab0000LQ.setZZFLD0000B4(zzfld0000B4_type1);

            ZZFLD0000B8_type1 zzfld0000B8_type1 = new ZZFLD0000B8_type1();
            zzfld0000B8_type1.setZZFLD0000B8_type0(vipCustInfo.getMp());
            zscrm_ztab0000LQ.setZZFLD0000B8(zzfld0000B8_type1);

            ZZFLD0000B6_type1 zzfld0000B6_type1 = new ZZFLD0000B6_type1();
            zzfld0000B6_type1.setZZFLD0000B6_type0(vipCustInfo.getMilkbox() == null ? "" : vipCustInfo.getMilkbox());
            zscrm_ztab0000LQ.setZZFLD0000B6(zzfld0000B6_type1);

            ZZFLD0000B5_type1 zzfld0000B5_type1 = new ZZFLD0000B5_type1();
            zzfld0000B5_type1.setZZFLD0000B5_type0(vipCustInfo.getVipType() == null ? "" : vipCustInfo.getVipType());
            zscrm_ztab0000LQ.setZZFLD0000B5(zzfld0000B5_type1);

            ZZFLD0000B9_type1 zzfld0000B9_type1 = new ZZFLD0000B9_type1();
            zzfld0000B9_type1.setZZFLD0000B9_type0(vipCustInfo.getSubscriber() == null ? "" : vipCustInfo.getSubscriber());
            zscrm_ztab0000LQ.setZZFLD0000B9(zzfld0000B9_type1);

            if (vipCustInfo.getFirstOrderTime() != null) {
                Date data = new Date();
                data.setObject(vipCustInfo.getFirstOrderTime());
                zscrm_ztab0000LQ.setZZFLD0000BC(data);
            }

            if (vipCustInfo.getSubscribeDate() != null) {
                Date zdDate = new Date();
                zdDate.setObject(vipCustInfo.getSubscribeDate());
                zscrm_ztab0000LQ.setZZFLD0000BA(zdDate);
            }
            ZZFLD0000BD_type1 zzfld0000BD_type1 = new ZZFLD0000BD_type1();
            zzfld0000BD_type1.setZZFLD0000BD_type0(vipCustInfo.getBranchNo());
            zscrm_ztab0000LQ.setZZFLD0000BD(zzfld0000BD_type1);

            ZZFLD0000BE_type1 zzfld0000BE_type1 = new ZZFLD0000BE_type1();
            zzfld0000BE_type1.setZZFLD0000BE_type0(vipCustInfo.getBranchName());
            zscrm_ztab0000LQ.setZZFLD0000BE(zzfld0000BE_type1);
            //TODO
            t_ztab0000LQ_type2.addItem(zscrm_ztab0000LQ);
            z_crm_memb_ztab0000LQ_update.setT_ZTAB0000LQ(t_ztab0000LQ_type2);

            Z_CRM_MEMB_ZTAB0000LQ_UPDATEResponse response = stub.subscriberMaintain(z_crm_memb_ztab0000LQ_update);
            com.nhry.webService.client.VipInfoData.functions.ZSCRM_MESSAGE message = response.getES_RETURN();
            String flag = message.getFLAG().getFLAG_type0();
            String msg = message.getMSG().getMSG_type0();
            if (MESSAGE_FLAG.equals(flag)) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
            result.setMessage(msg);
            logger.info(msg);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void executeUptVipCust(TVipCustInfo vipCustInfo) {
        if ("on".equals(PICRMEXEC)) {
            taskExecutor.execute(new Thread() {
                public void run() {
                    try {
                        this.setName(vipCustInfo.getVipCustNo());
                        sendSubscriber(vipCustInfo);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public PISuccessTMessage sendAddress(List<TMdAddress> addresss, String sapGuid) {
        PISuccessTMessage result = new PISuccessTMessage();
        try {
            for (TMdAddress address : addresss) {
                address = vipCustInfoService.findAddressById(address.getAddressId());
                if (StringUtils.isEmpty(sapGuid)) {
                    TVipCustInfo custInfo = vipCustInfoService.findVipCustByNoForUpt(address.getVipCustNo());
                    sapGuid = custInfo.getVipCustNoSap();
                }
                if (StringUtils.isNotEmpty(sapGuid)) {
                    MemberAddrUpdateServiceStub stub = connMemberAddrService();
                    Z_CRM_ADDR_UPDATE z_crm_addr_update = new Z_CRM_ADDR_UPDATE();

                    NHSysCodeItem codeItem = new NHSysCodeItem();
                    codeItem.setTypeCode("1001");
                    if (StringUtils.isEmpty(address.getCityName())) {
                        codeItem.setItemCode(address.getCity());
                        NHSysCodeItem item = dictionaryService.findCodeItenByCode(codeItem);
                        if (item != null) {
                            address.setCity(item.getItemName());
                        }
                    }
                    if (StringUtils.isEmpty(address.getCountyName())) {
                        codeItem.setItemCode(address.getCounty());
                        NHSysCodeItem item = dictionaryService.findCodeItenByCode(codeItem);
                        if (item != null) {
                            address.setCounty(item.getItemName());
                        }
                    }

                    if (StringUtils.isNotEmpty(sapGuid)) {
                        com.nhry.webService.client.Address.functions.IV_MEMB_GUID_type1 iv_memb_guid_type1 = new com.nhry.webService.client.Address.functions.IV_MEMB_GUID_type1();
                        iv_memb_guid_type1.setIV_MEMB_GUID_type0(sapGuid);
                        z_crm_addr_update.setIV_MEMB_GUID(iv_memb_guid_type1);
                    }
                    T_ADDR_type1 t_addr_type1 = new T_ADDR_type1();
                    ZSCRM_ADDR_SHIP_TO zscrm_addr_ship_to = new ZSCRM_ADDR_SHIP_TO();

                    ADDRESS_GUID_type3 address_guid_type3 = new ADDRESS_GUID_type3();
                    address_guid_type3.setADDRESS_GUID_type2(address.getAddressId());
                    zscrm_addr_ship_to.setADDRESS_GUID(address_guid_type3);

                    com.nhry.webService.client.Address.functions.CITY1_type1 city1_type1 = new com.nhry.webService.client.Address.functions.CITY1_type1();
                    city1_type1.setCITY1_type0(address.getCityName() == null ? "" : address.getCityName());
                    zscrm_addr_ship_to.setCITY1(city1_type1);

                    com.nhry.webService.client.Address.functions.CITY2_type1 city2_type1 = new com.nhry.webService.client.Address.functions.CITY2_type1();
                    city2_type1.setCITY2_type0(address.getCountyName() == null ? "" : address.getCountyName());
                    zscrm_addr_ship_to.setCITY2(city2_type1);

                    com.nhry.webService.client.Address.functions.COUNTRY_type1 country_type1 = new com.nhry.webService.client.Address.functions.COUNTRY_type1();
                    country_type1.setCOUNTRY_type0("CN");
                    zscrm_addr_ship_to.setCOUNTRY(country_type1);

                    com.nhry.webService.client.Address.functions.TEL_NUMBER_type1 tel_number_type1 = new com.nhry.webService.client.Address.functions.TEL_NUMBER_type1();
                    tel_number_type1.setTEL_NUMBER_type0(address.getTel() == null ? "" : address.getTel());
                    zscrm_addr_ship_to.setTEL_NUMBER(tel_number_type1);

                    com.nhry.webService.client.Address.functions.TEL_MOBILE_type1 tel_mobile_type1 = new com.nhry.webService.client.Address.functions.TEL_MOBILE_type1();
                    tel_mobile_type1.setTEL_MOBILE_type0(address.getMp() == null ? "" : address.getMp());
                    zscrm_addr_ship_to.setTEL_MOBILE(tel_mobile_type1);

                    com.nhry.webService.client.Address.functions.STREET_type1 street_type1 = new com.nhry.webService.client.Address.functions.STREET_type1();
                    street_type1.setSTREET_type0(address.getStreet() == null ? "" : address.getStreet());
                    zscrm_addr_ship_to.setSTREET(street_type1);

                    com.nhry.webService.client.Address.functions.STR_SUPPL2_type1 str_suppl2_type1 = new com.nhry.webService.client.Address.functions.STR_SUPPL2_type1();
                    str_suppl2_type1.setSTR_SUPPL2_type0(address.getResidentialAreaName() == null ? "" : address.getResidentialAreaName());
                    zscrm_addr_ship_to.setSTR_SUPPL2(str_suppl2_type1);

                    com.nhry.webService.client.Address.functions.STR_SUPPL1_type1 str_suppl1_type1 = new com.nhry.webService.client.Address.functions.STR_SUPPL1_type1();
                    str_suppl1_type1.setSTR_SUPPL1_type0(address.getAddressTxt() == null ? "" : address.getAddressTxt());
                    zscrm_addr_ship_to.setSTR_SUPPL1(str_suppl1_type1);

                    com.nhry.webService.client.Address.functions.REGION_type1 region_type1 = new com.nhry.webService.client.Address.functions.REGION_type1();
                    region_type1.setREGION_type0(address.getProvince() == null ? "" : address.getProvince());
                    zscrm_addr_ship_to.setREGION(region_type1);

                    com.nhry.webService.client.Address.functions.NAME_CO_type1 name_co_type1 = new com.nhry.webService.client.Address.functions.NAME_CO_type1();
                    name_co_type1.setNAME_CO_type0(address.getRecvName() == null ? "" : address.getRecvName());
                    zscrm_addr_ship_to.setNAME_CO(name_co_type1);

                    com.nhry.webService.client.Address.functions.POST_CODE1_type1 post_code1_type1 = new com.nhry.webService.client.Address.functions.POST_CODE1_type1();
                    post_code1_type1.setPOST_CODE1_type0(address.getZip() == null ? "" : address.getZip());
                    zscrm_addr_ship_to.setPOST_CODE1(post_code1_type1);

                    MODE_type1 mode_type1 = new MODE_type1();
                    String isdelete = address.getIsDelete();
                    if (StringUtils.isNotEmpty(isdelete) && "Y".equals(isdelete)) {
                        mode_type1.setMODE_type0("D");
                    } else {
                        mode_type1.setMODE_type0("");
                    }
                    zscrm_addr_ship_to.setMODE(mode_type1);

                    t_addr_type1.addItem(zscrm_addr_ship_to);
                    z_crm_addr_update.setT_ADDR(t_addr_type1);

                    long beginDate = System.currentTimeMillis();
                    Z_CRM_ADDR_UPDATEResponse response = stub.memberAddrUpdate(z_crm_addr_update);
                    long endDate = System.currentTimeMillis();
                    long l = endDate - beginDate;
                    logger.info("调用会员地址接口用时："+ l/1000);
                    ZSCRM_ADDR_UPDATE_RETURN message = response.getES_RETURN();
                    String flag = message.getFLAG().getFLAG_type0();
                    String msg = message.getMSG().getMSG_type0();
                    if (MESSAGE_FLAG.equals(flag)) {
                        result.setSuccess(true);
                    } else {
                        result.setSuccess(false);
                    }
                    result.setMessage(msg);
                    logger.info(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void executeSendAddress(TMdAddress address, String sapGuid) {
        if ("on".equals(PICRMEXEC)) {
            taskExecutor.execute(new Thread() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        this.setName(address.getAddressId());
                        List<TMdAddress> addresses = new ArrayList<TMdAddress>();
                        addresses.add(address);
                        sendAddress(addresses, sapGuid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void executeSendAddresses(List<TMdAddress> addresses, String sapGuid) {
        if ("on".equals(PICRMEXEC)) {
            taskExecutor.execute(new Thread() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                        this.setName(PrimaryKeyUtils.generateUpperUuidKey());
                        sendAddress(addresses, sapGuid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public PISuccessTMessage queryCustomerComplain(CustomerComplainModel model) {
        PISuccessTMessage message = new PISuccessTMessage();
        try {
            ZT_CRM_BuData_MaintainServiceStub stub = connMaintainService();
            Z_CRM_SNG_TS z_crm_sng_ts = new Z_CRM_SNG_TS();
            ZSCRM_SNG_TS_QUERY zscrm_sng_ts_query = new ZSCRM_SNG_TS_QUERY();
            if(StringUtils.isNotEmpty(model.getSalesOrg())){
                com.nhry.webService.client.VipInfoData.functions.SALES_ORG_type1 sales_org_type1 = new com.nhry.webService.client.VipInfoData.functions.SALES_ORG_type1();
                sales_org_type1.setSALES_ORG_type0(model.getSalesOrg());
                zscrm_sng_ts_query.setSALES_ORG(sales_org_type1);
            }
            if(StringUtils.isNotEmpty(model.getBranchNo())) {
                NZBH_type1 nzbh_type1 = new NZBH_type1();
                nzbh_type1.setNZBH_type0(model.getBranchNo());
                zscrm_sng_ts_query.setNZBH(nzbh_type1);
            }
            if(StringUtils.isNotEmpty(model.getEmpNo())) {
                SNGBH_type1 sngbh_type1 = new SNGBH_type1();
                sngbh_type1.setSNGBH_type0(model.getEmpNo());
                zscrm_sng_ts_query.setSNGBH(sngbh_type1);
            }
            if(model.getStartDate()!=null) {
                Date startDate = new Date();
                startDate.setObject(model.getStartDate());
                zscrm_sng_ts_query.setDATE_START(startDate);
            }
            if(model.getEndDate()!=null) {
                Date endDate = new Date();
                endDate.setObject(model.getEndDate());
                zscrm_sng_ts_query.setDATE_END(endDate);
            }

            z_crm_sng_ts.setIS_QUERY(zscrm_sng_ts_query);
            Z_CRM_SNG_TSResponse response = stub.customerComplain(z_crm_sng_ts);
            ET_DATA_type0 et_data_type0 =  response.getET_DATA();

            ZSCRM_SNG_TS[] zscrm_sng_tses =  et_data_type0.getItem();
            List<CustomerComplain> customerComplains = Lists.newArrayList();
            if(zscrm_sng_tses!=null && zscrm_sng_tses.length > 0){
                for(ZSCRM_SNG_TS zscrm_sng_ts : zscrm_sng_tses){
                    String empNo = zscrm_sng_ts.getSNGBH().getSNGBH_type2();
                    TMdBranchEmp emp = branchEmpService.selectBranchEmpByNo(empNo);
                    CustomerComplain complain = new CustomerComplain();
                    complain.setSALESORG(zscrm_sng_ts.getSALES_ORG().getSALES_ORG_type2());
                    complain.setNZBH(zscrm_sng_ts.getNZBH().getNZBH_type2());
                    complain.setBranchName(emp!=null?emp.getBranchName():"");
                    complain.setSNGBH(emp!=null?emp.getEmpName():empNo);
                    complain.setCATEGORY1(zscrm_sng_ts.getCATEGORY1().getCATEGORY1_type0());
                    complain.setCATEGORY2(zscrm_sng_ts.getCATEGORY2().getCATEGORY2_type0());
                    complain.setCATEGORY3(zscrm_sng_ts.getCATEGORY3().getCATEGORY3_type0());
                    complain.setZZOBJECTID(zscrm_sng_ts.getZZOBJECT_ID().getZZOBJECT_ID_type0());
                    complain.setDESCRIPTION(zscrm_sng_ts.getDESCRIPTION().getDESCRIPTION_type0());
                    complain.setCREATEDATE(zscrm_sng_ts.getCREATE_DATE().getObject().toString());
                    customerComplains.add(complain);
                }
            }
            message.setSuccess(true);
            message.setData(customerComplains);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            message.setSuccess(false);
            message.setMessage("获取投诉信息失败！");
        }
        return message;
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
     * 会员积分查询
     *
     * @return
     * @throws AxisFault
     */
    private PointQuery_OutServiceStub connQueryService() throws AxisFault {
        PointQuery_OutServiceStub client = new PointQuery_OutServiceStub(POINTURL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    /**
     * 会员积分明细查询
     *
     * @return
     * @throws AxisFault
     */
    private PTDetailQuery_OutServiceStub conDetailQueryService() throws AxisFault {
        PTDetailQuery_OutServiceStub client = new PTDetailQuery_OutServiceStub(DetailURL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    /**
     * 会员积分创建
     *
     * @return
     * @throws AxisFault
     */
    private MemberActCreateServiceStub connMemberActService() throws AxisFault {
        MemberActCreateServiceStub client = new MemberActCreateServiceStub(MEMBERACTURL);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

    /**
     * 订户地址修改
     *
     * @return
     * @throws AxisFault
     */
    private MemberAddrUpdateServiceStub connMemberAddrService() throws AxisFault {
        MemberAddrUpdateServiceStub client = new MemberAddrUpdateServiceStub(MEMBERADDR);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }
}
