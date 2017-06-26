package com.nhry.service.pi.impl;

import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.pi.dao.PIVipPointCreateBatService;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.utils.EnvContant;
import com.nhry.webService.OptionManager;
import com.nhry.webService.client.MemberActivitiesBat.MemberActCreateBatServiceStub;
import com.nhry.webService.client.MemberActivitiesBat.functions.*;
import com.nhry.webService.client.PISuccessTMessage;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cbz on 11/30/2016.
 */
public class PIVipPointCreateBatServiceImpl implements PIVipPointCreateBatService {
    private static Logger logger = Logger.getLogger(PIVipPointCreateBatServiceImpl.class);
    private static final String URL_BAT = EnvContant.getSystemConst("PI.VipInfoDataBat.URL");
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
    private static final SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    private TaskExecutor taskExecutor;
    private DictionaryService dictionaryService;

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Override
    public PISuccessTMessage createMemberActivitiesBat(List<MemberActivities> memberActivities) {
        PISuccessTMessage message = new PISuccessTMessage<>();
        try {
            MemberActCreateBatServiceStub client = conMemberActCreateBat();
            Z_CRM_MEMB_ACTIVITIES_CREATE_T create_t = new Z_CRM_MEMB_ACTIVITIES_CREATE_T();
            IT_HEAD_type0 it_head_type0 = new IT_HEAD_type0();
            IT_ITEMS_type0 it_items_type0 = new IT_ITEMS_type0();
            Map<String, String> tmpOrders = new HashMap<String, String>();
            for (MemberActivities memberActivitie : memberActivities) {
                if (StringUtils.isEmpty(tmpOrders.get(memberActivitie.getOrderid()))) {
                    ZSCRM_MEMB_ACT_H head = new ZSCRM_MEMB_ACT_H();
                    tmpOrders.put(memberActivitie.getOrderid(), memberActivitie.getOrderid());
                    //创建日期
                    ACTIVITY_DATE_type1 activity_date_type1 = new ACTIVITY_DATE_type1();
                    activity_date_type1.setACTIVITY_DATE_type0(formatter.format(memberActivitie.getActivitydate()));
                    head.setACTIVITY_DATE(activity_date_type1);
                    //会员卡号
                    CARD_ID_type1 card_id_type1 = new CARD_ID_type1();
                    card_id_type1.setCARD_ID_type0(memberActivitie.getCardid() == null ? "" : memberActivitie.getCardid());
                    head.setCARD_ID(card_id_type1);
                    //活动类别
                    CATEGORY_type1 category_type1 = new CATEGORY_type1();
                    category_type1.setCATEGORY_type0(memberActivitie.getCategory());
                    head.setCATEGORY(category_type1);
                    //会员GUID号
                    MEMBERSHIP_GUID_type1 membership_guid_type1 = new MEMBERSHIP_GUID_type1();
                    membership_guid_type1.setMEMBERSHIP_GUID_type0(memberActivitie.getMembershipguid());
                    head.setMEMBERSHIP_GUID(membership_guid_type1);
                    //订单号
                    ORDER_ID_type1 order_id_type1 = new ORDER_ID_type1();
                    order_id_type1.setORDER_ID_type0(memberActivitie.getOrderid() == null ? "" : memberActivitie.getOrderid());
                    head.setORDER_ID(order_id_type1);
                    //流程类型
                    PROCESS_TYPE_type1 process_type_type1 = new PROCESS_TYPE_type1();
                    process_type_type1.setPROCESS_TYPE_type0(memberActivitie.getProcesstype() == null ? "" : memberActivitie.getProcesstype());
                    head.setPROCESS_TYPE(process_type_type1);
                    //组织机构
                    SALES_ORG_type1 sales_org_type1 = new SALES_ORG_type1();
                    sales_org_type1.setSALES_ORG_type0(memberActivitie.getSalesorg());
                    head.setSALES_ORG(sales_org_type1);
                    //逻辑变量
                    COMMIT_type1 commit_type1 = new COMMIT_type1();
                    commit_type1.setCOMMIT_type0(memberActivitie.getCommit() == null ? "X" : memberActivitie.getCommit());
                    head.setCOMMIT(commit_type1);
                    it_head_type0.addItem(head);
                }

                ZSCRM_MEMB_ACT_I items = new ZSCRM_MEMB_ACT_I();
                //订单号
                ORDER_ID_type3 order_id_type3 = new ORDER_ID_type3();
                order_id_type3.setORDER_ID_type2(memberActivitie.getOrderid());
                items.setORDER_ID(order_id_type3);
                //处理标识

                ITEM_NUM_type1 item_num_type1 = new ITEM_NUM_type1();
                item_num_type1.setITEM_NUM_type0(memberActivitie.getItemnum() == null ? "0" : memberActivitie.getItemnum());
                items.setITEM_NUM(item_num_type1);
                //会员GUID
                HEAD_GUID_type1 head_guid_type1 = new HEAD_GUID_type1();
                head_guid_type1.setHEAD_GUID_type0(memberActivitie.getMembershipguid());
                items.setHEAD_GUID(head_guid_type1);
                //金额
                AMOUNT_type1 amount_type1 = new AMOUNT_type1();
                amount_type1.setAMOUNT_type0(memberActivitie.getAmount());
                items.setAMOUNT(amount_type1);

                POINT_TYPE_type1 point_type_type1 = new POINT_TYPE_type1();
                point_type_type1.setPOINT_TYPE_type0(memberActivitie.getPointtype() == null ? "" : memberActivitie.getPointtype());
                items.setPOINT_TYPE(point_type_type1);

                TRAN_SEQ_NUM_type1 tran_seq_num_type1 = new TRAN_SEQ_NUM_type1();
                tran_seq_num_type1.setTRAN_SEQ_NUM_type0("");
                items.setTRAN_SEQ_NUM(tran_seq_num_type1);

                TIER_type1 tier_type1 = new TIER_type1();
                tier_type1.setTIER_type0(memberActivitie.getTier() == null ? "" : memberActivitie.getTier());
                items.setTIER(tier_type1);

                TIER_GROUP_type1 tier_group_type1 = new TIER_GROUP_type1();
                tier_group_type1.setTIER_GROUP_type0(memberActivitie.getTiergroup() == null ? "" : memberActivitie.getTiergroup());
                items.setTIER_GROUP(tier_group_type1);

                RETAIL_STORE_ID_type1 retail_store_id_type1 = new RETAIL_STORE_ID_type1();
                retail_store_id_type1.setRETAIL_STORE_ID_type0(memberActivitie.getRetailstoreid() == null ? "" : memberActivitie.getRetailstoreid());
                items.setRETAIL_STORE_ID(retail_store_id_type1);

                CURRENCY_type1 currency_type1 = new CURRENCY_type1();
                currency_type1.setCURRENCY_type0(memberActivitie.getCurrency() == null ? "" : memberActivitie.getCurrency());
                items.setCURRENCY(currency_type1);

                if (memberActivitie.getProductid() != null) {
                    PRODUCT_ID_type1 product_id_type1 = new PRODUCT_ID_type1();
                    product_id_type1.setPRODUCT_ID_type0(memberActivitie.getProductid());
                    items.setPRODUCT_ID(product_id_type1);
                }
                if (memberActivitie.getProductquantity() != null) {
                    PRODUCT_QUANTITY_type1 product_quantity_type1 = new PRODUCT_QUANTITY_type1();
                    product_quantity_type1.setPRODUCT_QUANTITY_type0(memberActivitie.getProductquantity());
                    items.setPRODUCT_QUANTITY(product_quantity_type1);
                }
                if (memberActivitie.getPoints() != null) {
                    POINTS_type1 points_type = new POINTS_type1();
                    points_type.setPOINTS_type0(memberActivitie.getPoints());
                    items.setPOINTS(points_type);
                }
                it_items_type0.addItem(items);
            }
            create_t.setIT_HEAD(it_head_type0);
            create_t.setIT_ITEMS(it_items_type0);
            IV_PROCESS_type1 iv_process_type1 = new IV_PROCESS_type1();
            iv_process_type1.setIV_PROCESS_type0("X");
            create_t.setIV_PROCESS(iv_process_type1);

            Z_CRM_MEMB_ACTIVITIES_CREATE_TResponse response = client.memberActCreateBat(create_t);

            ET_MSG_type0 et_msg_type0 = response.getET_MSG();
            ZSCRM_ACTIVE_RET[] zscrm_active_rets = et_msg_type0.getItem();
            StringBuilder builder = new StringBuilder();
            for (ZSCRM_ACTIVE_RET zscrm_active_ret1 : zscrm_active_rets) {
                String msg = zscrm_active_ret1.getMSG().getMSG_type0();
                String flag = zscrm_active_ret1.getFLAG().getFLAG_type0();
                String orderId = zscrm_active_ret1.getORDER_ID().getORDER_ID_type4();
                String objectId = zscrm_active_ret1.getOBJECT_ID().getOBJECT_ID_type0();
                String itemNo = zscrm_active_ret1.getITEM_NUM().getITEM_NUM_type2();
                builder.append(orderId + ";");
                builder.append(itemNo + ";");
                builder.append(objectId + ";");
                builder.append(flag + ";");
                builder.append(msg + ";--");
            }
            logger.info("积分结果：" + builder);
            message.setSuccess(true);
        } catch (Exception e) {
            message.setSuccess(false);
            message.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return message;
    }

    @Override
    public void backPoint(TPreOrder order, BigDecimal initAmt, BigDecimal backAmt) {
        taskExecutor.execute(new Thread() {
            @Override
            public void run() {
                super.run();
                this.setName("minusVipPoint" + new Date());
                NHSysCodeItem codeItem = new NHSysCodeItem();
                codeItem.setTypeCode("2007");
                codeItem.setItemCode("1");
                codeItem = dictionaryService.findCodeItenByCode(codeItem);
                Date bakDate = new Date();
                try {
                    bakDate = format1.parse(codeItem.getItemName());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (order.getPayDate().after(bakDate)) {
                    BigDecimal fRate = backAmt.divide(initAmt, 2).multiply(new BigDecimal(order.getyFresh() == null ? 0 : order.getyFresh()));//鲜峰
                    MemberActivities item = new MemberActivities();
                    Date date = new Date();
                    item.setActivitydate(date);
                    item.setSalesorg(order.getSalesOrg());
                    item.setCategory("YRETURN");
                    item.setProcesstype("YSUB_RETURN");
                    item.setOrderid(order.getOrderNo());
                    item.setMembershipguid(order.getMemberNo());
                    item.setPointtype("YFRESH");
                    item.setPoints(fRate);
                    item.setAmount(backAmt);
                    item.setProcess("X");
                    List<MemberActivities> list1 = new ArrayList<MemberActivities>();
                    list1.add(item);
                    createMemberActivitiesBat(list1);
                }
            }
        });
    }

    private MemberActCreateBatServiceStub conMemberActCreateBat() throws AxisFault {
        MemberActCreateBatServiceStub client = new MemberActCreateBatServiceStub(URL_BAT);
        Options options = client._getServiceClient().getOptions();
        client._getServiceClient().setOptions(OptionManager.initializable(options));
        return client;
    }

}
