package com.nhry.service.milktrans.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchEmpMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.dao.TMdMaraMapper;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TMdBranchEmp;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.milk.dao.TDispOrderMapper;
import com.nhry.data.milk.dao.TMstRefuseResendItemMapper;
import com.nhry.data.milk.dao.TMstRefuseResendMapper;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderItemMapper;
import com.nhry.data.milktrans.dao.TSsmReqGoodsOrderMapper;
import com.nhry.data.milktrans.dao.TSsmSalOrderItemMapper;
import com.nhry.data.milktrans.dao.TSsmSalOrderMapper;
import com.nhry.data.milktrans.domain.*;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.stock.dao.TSsmGiOrderItemMapper;
import com.nhry.data.stock.dao.TSsmGiOrderMapper;
import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.data.stud.domain.TMstOrderStud;
import com.nhry.model.milktrans.*;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.milktrans.dao.RequireOrderService;
import com.nhry.service.pi.dao.PIRequireOrderService;
import com.nhry.service.stock.dao.TSsmStockService;
import com.nhry.utils.DateUtil;
import com.nhry.utils.SysContant;
import com.nhry.webService.client.PISuccessMessage;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gongjk on 2016/6/24.
 */
public class RequireOrderServiceImpl implements RequireOrderService {
    private static Logger logger = Logger.getLogger(RequireOrderServiceImpl.class);
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private TSsmReqGoodsOrderItemMapper tSsmReqGoodsOrderItemMapper;
    private TSsmReqGoodsOrderMapper tSsmReqGoodsOrderMapper;
    private TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper;
    private TDispOrderMapper tDispOrderMapper;
    private UserSessionService userSessionService;
    private PIRequireOrderService piRequireOrderService;
    private TMdBranchMapper branchMapper;
    private TMdMaraMapper tMdMaraMapper;
    private TSsmSalOrderMapper tSsmSalOrderMapper;
    private TSsmSalOrderItemMapper tSsmSalOrderItemMapper;
    private TSsmGiOrderMapper tSsmGiOrderMapper;
    private TSsmGiOrderItemMapper tSsmGiOrderItemMapper;
    private TMstRefuseResendMapper resendMapper;
    private TMstRefuseResendItemMapper resendItemMapper;
    private TSsmStockService stockService;
    private DictionaryService dictionaryService;
    private StringRedisTemplate stringRedisTemplate;
    private TMdBranchEmpMapper branchEmpMapper;

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
    public void setStockService(TSsmStockService stockService) {
        this.stockService = stockService;
    }

    public void setResendItemMapper(TMstRefuseResendItemMapper resendItemMapper) {
        this.resendItemMapper = resendItemMapper;
    }

    public void setResendMapper(TMstRefuseResendMapper resendMapper) {
        this.resendMapper = resendMapper;
    }

    public void settSsmGiOrderItemMapper(TSsmGiOrderItemMapper tSsmGiOrderItemMapper) {
        this.tSsmGiOrderItemMapper = tSsmGiOrderItemMapper;
    }

    public void settSsmGiOrderMapper(TSsmGiOrderMapper tSsmGiOrderMapper) {
        this.tSsmGiOrderMapper = tSsmGiOrderMapper;
    }

    public void settDispOrderMapper(TDispOrderMapper tDispOrderMapper) {
        this.tDispOrderMapper = tDispOrderMapper;
    }

    public void settSsmSalOrderMapper(TSsmSalOrderMapper tSsmSalOrderMapper) {
        this.tSsmSalOrderMapper = tSsmSalOrderMapper;
    }

    public void settSsmSalOrderItemMapper(TSsmSalOrderItemMapper tSsmSalOrderItemMapper) {
        this.tSsmSalOrderItemMapper = tSsmSalOrderItemMapper;
    }

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setPiRequireOrderService(PIRequireOrderService piRequireOrderService) {
        this.piRequireOrderService = piRequireOrderService;
    }

    public void settSsmReqGoodsOrderItemMapper(TSsmReqGoodsOrderItemMapper tSsmReqGoodsOrderItemMapper) {
        this.tSsmReqGoodsOrderItemMapper = tSsmReqGoodsOrderItemMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void settSsmReqGoodsOrderMapper(TSsmReqGoodsOrderMapper tSsmReqGoodsOrderMapper) {
        this.tSsmReqGoodsOrderMapper = tSsmReqGoodsOrderMapper;
    }

    public void settOrderDaliyPlanItemMapper(TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper) {
        this.tOrderDaliyPlanItemMapper = tOrderDaliyPlanItemMapper;
    }

    public void settMdMaraMapper(TMdMaraMapper tMdMaraMapper) {
        this.tMdMaraMapper = tMdMaraMapper;
    }

    public void setBranchEmpMapper(TMdBranchEmpMapper branchEmpMapper) {
        this.branchEmpMapper = branchEmpMapper;
    }
    /**
     * 根据 日期 获取当前登录人所在奶站的 要货计划
     *
     * @param orderDate
     * @return
     */
    @Override
    public RequireOrderModel searchRequireOrder(Date orderDate) {
        if (orderDate == null) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "查询要货计划的日期不能为空");
        }
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderModel orderModel = new RequireOrderModel();
        RequireOrderSearch rModel = new RequireOrderSearch();

        String salesOrg = user.getSalesOrg();
        rModel.setBranchNo(user.getBranchNo());
        rModel.setOrderDate(orderDate);
        TSsmReqGoodsOrder order = this.tSsmReqGoodsOrderMapper.searchRequireOrder(rModel);
        if (order != null) {

            List<TMstRefuseResend>  resendList = resendMapper.findNoUsedAndUsedRefuseResend(user.getBranchNo(),order.getOrderNo());
            Set<String> matnrMap = new HashSet<String>();
            if(resendList!=null && resendList.size()>0){
                resendList.stream().forEach(resend->{
                    matnrMap.add(resend.getMatnr());
                });
            }
            orderModel.setStatus(order.getStatus());
            orderModel.setRequiredDate(order.getOrderDate());
            orderModel.setBranchNo(order.getBranchNo());
            orderModel.setOrderNo(order.getOrderNo());
            orderModel.setOrderDate(order.getOrderDate());
            orderModel.setCreateAt(order.getCreateAt());
            orderModel.setLastModified(order.getLastModified());
            if (StringUtils.isNotBlank(order.getVoucherNo())) {
                orderModel.setVoucherNo(order.getVoucherNo());
            }
            List<TSsmReqGoodsOrderItem> items = this.tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByOrderNo(order.getOrderNo());
            List<OrderRequireItem> entries = new ArrayList<OrderRequireItem>();
            for (TSsmReqGoodsOrderItem item : items) {
                OrderRequireItem entry = new OrderRequireItem();
                Map<String, String> map = new HashMap<String, String>();
                map.put("salesOrg", salesOrg);
                map.put("matnr", item.getMatnr());
                TMdMara mara = tMdMaraMapper.selectProductByCode(map);
                if(matnrMap.contains(item.getMatnr())){
                    entry.setHasTmp(true);
                } else {
                    entry.setHasTmp(false);
                }
                entry.setResendQty(item.getResendQty());
                entry.setMatnr(item.getMatnr());
                entry.setMatnrTxt(mara.getMatnrTxt());
                entry.setQty(item.getQty());
                entry.setFlag(item.getFlag());
                entry.setIncreQty(item.getIncreQty());
                entries.add(entry);
            }
            orderModel.setEntries(entries);
        } else {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "当天的要货计划还未生成");
        }
        return orderModel;
    }

    /**
     * 修改新添加的要货计划行
     *
     * @param rModel
     * @return
     */
    @Override
    public int uptNewRequireOrderItem(UpdateNewRequiredModel rModel) {
        try {
            TSysUser user = userSessionService.getCurrentUser();
            String orderNo = rModel.getOrderNo();
            TSsmReqGoodsOrder orderModel = this.tSsmReqGoodsOrderMapper.getRequireOrderByNo(orderNo);
            //获取数据库中存好的要货计划 如果状态已经确定，则不能修改
            if (orderModel.getStatus() == "30") {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "要货订单已确定，不能改变");
            }

            Map<String, String> map = new HashMap<String, String>();
            map.put("salesOrg", user.getSalesOrg());
            map.put("matnr", rModel.getMatnr());

            TMdMara mara = tMdMaraMapper.selectProductByCode(map);
            TSsmReqGoodsOrderItemUpt itemUpt = new TSsmReqGoodsOrderItemUpt();
            itemUpt.setMatnr(rModel.getMatnr());
            itemUpt.setOrderNo(orderNo);
            itemUpt.setMatnrTxt(mara.getMatnrTxt());
            itemUpt.setIncreQty(rModel.getIncreQty());
            itemUpt.setQty(rModel.getQty());
            itemUpt.setUnit(mara.getBaseUnit());
            itemUpt.setOldMatnr(rModel.getOldMatnr());
            this.tSsmReqGoodsOrderItemMapper.uptNewReqGoodsItem(itemUpt);
            return 1;
        } catch (Exception e) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "修改失败");
        }

    }

    @Override
    public int addRequireOrderItem(TSsmReqGoodsOrderItem item) {
        String message = "";
        String orderNo = item.getOrderNo();
        TSsmReqGoodsOrderItem oldItem = tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByMatnrAndOrderNo(orderNo, item.getMatnr());
        if (oldItem != null) {
            message = "该产品已存在，请重新选择";
            throw new ServiceException(MessageCode.LOGIC_ERROR, message);
        }


        TSysUser user = userSessionService.getCurrentUser();
        TSsmReqGoodsOrder orderModel = this.tSsmReqGoodsOrderMapper.getRequireOrderByNo(orderNo);

        if ("30".equals(orderModel.getStatus())) {
            message = "这天的要货计划已确定，不可再添加或修改";
            throw new ServiceException(MessageCode.LOGIC_ERROR, message);
        }
        orderModel.setLastModified(new Date());
        orderModel.setLastModifiedBy(user.getLoginName());
        orderModel.setLastModifiedByTxt(user.getDisplayName());
        tSsmReqGoodsOrderMapper.uptRequireGoodsModifyInfo(orderModel);

        if (StringUtils.isBlank(item.getUnit())) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("salesOrg", user.getSalesOrg());
            map.put("matnr", item.getMatnr());
            TMdMara mara = tMdMaraMapper.selectProductByCode(map);
            item.setUnit(mara.getBaseUnit());
        }
        item.setFlag("2");
        item.setItemNo(tSsmReqGoodsOrderItemMapper.getMaxItemNoByOrderNo(orderNo) + 10);
        item.setOrderDate(orderModel.getOrderDate());
        return tSsmReqGoodsOrderItemMapper.insertRequireOrderItem(item);
    }

    @Override
    public int delRequireOrderItem(ReqGoodsOrderItemSearch item) {
        TSsmReqGoodsOrderItem oldItem = tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByMatnrAndOrderNo(item.getOrderNo(), item.getMatnr());
        if ("1".equals(oldItem.getFlag())) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "生成的要货计划行不能删除");
        }
        return tSsmReqGoodsOrderItemMapper.delRequireOrderItem(item);
    }


    @Override
    public int uptRequireOrder(UpdateRequiredModel uModel) {
        String message = "修改失败";
        try {
            String orderNo = uModel.getOrderNo();
            TSsmReqGoodsOrder orderModel = this.tSsmReqGoodsOrderMapper.getRequireOrderByNo(orderNo);
            //获取数据库中存好的要货计划 如果状态已经确定，则不能修改
            if (orderModel.getStatus() == "30") {
                message = "要货订单已确定，不能改变";
                throw new ServiceException(MessageCode.LOGIC_ERROR, message);
            }


            this.tSsmReqGoodsOrderItemMapper.uptReqGoodsItem(uModel);
            return 1;
        } catch (Exception e) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, message);
        }
    }

    /**
     * 根据日订单 生成经销商奶站的参加促销的销售订单
     * 此时还没有发送
     * @param orderDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public TSsmSalOrder creatPromoSalOrderOfDealerBranch(Date orderDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);

        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfDealerBranch(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "free", 2, "30","",branchNo ,salesOrg );
            for (int i = 1; i <= items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i - 1);
                createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "dealer");
            }
            return order;
        }
        return null;
    }

    /**
     * 根据日订单 生成经销商奶站的  orderDate 日期的  不参加促销的奶站销售订单
     * 此时还没有发送
     * @param orderDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfDealerBranch(Date orderDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch(rModel);

        Map<String,Integer> resends = this.findReqGoodResendByOrderNo(orderDate,branchNo);

        if (items != null && items.size() > 0) {
            //生成 促销订单
            TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "", 1, "30","",branchNo , salesOrg);
            for (int i = 0; i < items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i);
                //去除拒收复送的数量
                if(resends.containsKey(item.getMatnr()) || resends.containsKey(item.getConfirmMatnr())) {
                    int rQty = 0;
                    rQty = resends.get(item.getMatnr());
                    if(rQty == 0 ){
                        rQty = resends.get(item.getConfirmMatnr());
                    }
                    int qty = item.getQty();
                    item.setQty(qty-rQty);
                }
                //生成 促销订单行项目
                createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "dealer");
            }
            return order;
        }
        return null;
    }

    /**
     * 根据日订单 生成经销商奶站的机构销售订单
     * 此时还没有发送
     * @param orderDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfDealerBranch70(Date orderDate, String branchNo, String salesOrg) {
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch70(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String orgCode = map.get("orgCode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal remainAmt = (BigDecimal)map.get("remainAmt");
            if(orderMap.containsKey(orgCode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(orgCode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remainAmt);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remainAmt);
                itemList.add(item);
                orderMap.put(orgCode,itemList);
            }
        }

        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "", 1, "70",orgCode,branchNo ,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    //生成 促销订单行项目
                    setBalanceAmt(item);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "dealer");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    /**
     * 经销商奶站年卡订单生成
     * @param requireDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public TSsmSalOrder createPromDaliyDiscountAmtOfDearler(Date requireDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(requireDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(requireDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        List<Map<String,String>> items = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfDearler(rModel);
        if (items != null && items.size() > 0) {
            String dealerSend = getYearCode(salesOrg);
            TSsmSalOrder order = createSaleOrder(requireDate, "dealer", "", 2, "YE",dealerSend,branchNo , salesOrg);
            int i = 1;
            for (Map<String,String> map : items) {
                String matnr = map.get("MATNR").toString();
                BigDecimal qty = new BigDecimal(String.valueOf(map.get("QTY")));
                BigDecimal remainAmt = new BigDecimal(String.valueOf(map.get("REMAIN_AMT")));
                BigDecimal discountAmt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remainAmt);
                item.setAmt(discountAmt);
                item.setPromotionFlag(map.get("PROMOTION_FLAG").toString());
                setBalanceAmt(item);
                createSaleOrderItem(item, i++, order.getOrderNo(), requireDate, "dealer");
            }
            return order;
        }
        return null;
    }

    /**
     * 获取年卡的销售代码
     * @param salesOrg
     * @return
     */
    private String getYearCode(String salesOrg) {
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode("2009");
        codeItem.setItemCode(salesOrg);
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        String dealerSend = "";
        if(codeItem != null && org.apache.commons.lang.StringUtils.isNotEmpty(codeItem.getItemName())){
            dealerSend= codeItem.getItemName();
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR,"请联系管理员设置年卡的销售客户编码！");
        }
        return dealerSend;
    }

    /**
     * 自营奶站年卡销售订单生成
     * @param requireDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public TSsmSalOrder createPromDaliyDiscountAmtOfBranch(Date requireDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setOrderDate(requireDate);
        rModel.setBranchNo(user.getBranchNo());
        rModel.setSalesOrg(user.getSalesOrg());
        List<Map<String,String>> items = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfBranch(rModel);
        if (items != null && items.size() > 0) {
            String dealerSend = getYearCode(salesOrg);
            //生成 促销订单
            TSsmSalOrder order = createSaleOrder(requireDate, "branch", "", 1, "YE",dealerSend,user.getBranchNo() ,user.getSalesOrg() );
            int i = 1;
            for (Map<String,String> map : items) {
                String matnr = map.get("MATNR").toString();
                BigDecimal qty = new BigDecimal(String.valueOf(map.get("QTY")));
                BigDecimal remainAmt = new BigDecimal(String.valueOf(map.get("REMAIN_AMT")));
                BigDecimal discountAmt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remainAmt);
                item.setAmt(discountAmt);
                item.setPromotionFlag(map.get("PROMOTION_FLAG").toString());
                setBalanceAmt(item);
                createSaleOrderItem(item, i++, order.getOrderNo(), requireDate, "branch");
            }
            return order;
        } else {
            return null;
        }
    }

    @Override
    public TSsmSalOrder creatPromoSalOrderOfDealerBranch40(Date orderDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);

        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfDealerBranch40(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "free", 2, "40","",branchNo , salesOrg);
            for (int i = 1; i <= items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i - 1);
                createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "dealer");
            }
            return order;
        }
        return null;
    }

    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfDealerBranch40(Date orderDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch40(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "", 1, "40", "",branchNo ,salesOrg );
            for (int i = 0; i < items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i);
                setBalanceAmt(item);
                createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "dealer");
            }
            return order;
        }
        return null;
    }


    /**
     * 自营奶站   创建 不参加促销的销售订单
     * 此时还没有发送
     *
     * @param orderDate
     * @return
     */

    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfSelftBranch(Date orderDate) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setOrderDate(orderDate);
        rModel.setBranchNo(user.getBranchNo());
        rModel.setSalesOrg(user.getSalesOrg());
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch(rModel);
        if (items != null && items.size() > 0) {
            //生成 促销订单
            TSsmSalOrder order = createSaleOrder(orderDate, "branch", "", 1, "30","",user.getBranchNo() ,user.getSalesOrg() );

            for (int i = 0; i < items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i);
                //生成 促销订单行项目
                createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
            }
            return order;
        } else {
            return null;
        }

    }


    /**
     * 自营奶站   创建 参加促销的销售订单
     * 此时还没有发送
     *
     * @param orderDate
     * @return
     */
    @Override
    public TSsmSalOrder creatPromoSalOrderOfSelftBranch(Date orderDate) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setOrderDate(orderDate);
        rModel.setBranchNo(user.getBranchNo());
        rModel.setSalesOrg(user.getSalesOrg());
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "branch", "free", 2, "30", "",user.getBranchNo() ,user.getSalesOrg() );
            if (items != null && items.size() > 0) {
                for (int i = 1; i <= items.size(); i++) {
                    TOrderDaliyPlanItem item = items.get(i - 1);
                    createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "branch");
                }
            }
            return order;
        } else {
            return null;
        }
    }


    /**
     * 获取指定日期下的 销售订单
     *
     * @param sModel
     * @return
     */
    @Override
    public List<TSsmSalOrder> getSaleOrderByQueryDate(SalOrderModel sModel) {
        TSysUser user = userSessionService.getCurrentUser();
        String branchNo = user.getBranchNo();
        if (branchNo == null) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "该用户不存在奶站");
        }
        if (sModel.getBranchNo() == null) {
            sModel.setBranchNo(user.getBranchNo());
        }
        List<TSsmSalOrder> result = tSsmSalOrderMapper.selectSalOrderByDateAndBranchNo(sModel);
        return result;
    }

    @Override
    public List<TSsmSalOrderItems> getSaleOrderDetailByOrderNo(String orderNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderNo", orderNo);
        map.put("salesOrg", userSessionService.getCurrentUser().getSalesOrg());
        return tSsmSalOrderItemMapper.selectItemsBySalOrderNo(map);
    }

    /**
     * 生成指定日期的要货计划
     *
     * @param eSearch
     * @return
     */
    @Override
    public RequireOrderModel creatRequireOrderByDate(ReqGoodsOrderSearch eSearch) {
        Date orderDate = eSearch.getRequiredDate();
        RequireOrderSearch rModel = new RequireOrderSearch();
        Date requireDate = null;
        TSysUser user = userSessionService.getCurrentUser();
        //如果是华西或者天音 则requiredDate日期为今天  否则requiredDate为明天
        requireDate = getRequireDate(orderDate);
        rModel.setBranchNo(user.getBranchNo());
        rModel.setOrderDate(orderDate);
        rModel.setRequiredDate(requireDate);
        rModel.setSalesOrg(user.getSalesOrg());
        TSsmReqGoodsOrder order = null;
        //首先查看今天的要货计划是否已存在
        order = this.tSsmReqGoodsOrderMapper.searchRequireOrder(rModel);
        String orderNo = "";
        if (order != null) {
            if ("30".equals(order.getStatus())) {
                //如果已生成，并且已经发送过ERP
                throw new ServiceException(MessageCode.LOGIC_ERROR, "当天要货计划已生成，并且已经发送过ERP，不能再次生成，请查阅!!!");
            } else {
                orderNo = order.getOrderNo();
                //将 拒收复送  复原
                List<TMstRefuseResendItem> entries = resendItemMapper.selectItemByRequireOrder(order.getOrderNo());
                if(entries!=null && entries.size()>0){
                    //key  拒收复送单号，value 数量
                    Map<String, BigDecimal> matnrList = new HashMap<String,BigDecimal>();
                    entries.stream().filter(e->(e.getQty().intValue()>0)).forEach(e->{
                           matnrList.put(e.getResendOrderNo(),e.getQty());
                    });
                    //有拒收复送产品,更新拒收复送数量，删除子项
                    if(matnrList.size()>0){
                        for(String resendOrderNo : matnrList.keySet()){
                            BigDecimal uptQty = matnrList.get(resendOrderNo);
                            TMstRefuseResend resend = resendMapper.selectRefuseResendByNo(resendOrderNo);
                            resend.setConfirmQty(resend.getConfirmQty().subtract(uptQty));
                            resend.setRemainQty(resend.getRemainQty().add(uptQty));
                           resendMapper.uptRefuseResend(resend);
                           stockService.updateTmpStock(order.getBranchNo(),resend.getMatnr(),uptQty.multiply(new BigDecimal(-1)),resend.getSalesOrg());
                        }
                        resendItemMapper.delResendItemByRequireOrderNoAndType(order.getOrderNo(),"10");

                    }
                }
                tSsmReqGoodsOrderItemMapper.delRequireOrderItemsByOrderNo(order.getOrderNo());
                tSsmReqGoodsOrderMapper.deleRequireGoodsOrderbyNo(order.getOrderNo());
            }
        }


        //查看明天和后天的订单
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectDaliyPlansByBranchAndDay(rModel);
        //将i天后的日订单中符合的产品加入到 生成的要货计划
        if (items != null && items.size() > 0) {
            order = new TSsmReqGoodsOrder();
            if(StringUtils.isEmpty(orderNo)) {
                orderNo = this.generateSal30Id();
            }
            order.setRequiredDate(requireDate);
            order.setStatus("10");
            order.setOrderNo(orderNo);
            order.setOrderDate(orderDate);
            order.setBranchNo(user.getBranchNo());
            order.setCreateAt(orderDate);
            order.setCreateBy(user.getLoginName());
            order.setCreateByTxt(user.getDisplayName());
//            order.setLastModified(orderDate);
//            order.setLastModifiedByTxt(user.getDisplayName());
//            order.setLastModifiedBy(user.getLoginName());
            tSsmReqGoodsOrderMapper.insertRequireOrder(order);
            for (int j = 0; j < items.size(); j++) {

                TOrderDaliyPlanItem entry = items.get(j);
                TSsmReqGoodsOrderItem item = new TSsmReqGoodsOrderItem();

                item.setFlag("1");
                item.setUnit(entry.getUnit());
                item.setOrderDate(orderDate);
                item.setItemNo((j + 1) * 10);
                item.setOrderNo(order.getOrderNo());
                item.setMatnr(entry.getMatnr());
                item.setMatnrTxt(entry.getMatnrTxt());
                item.setQty(entry.getQty());
                item.setIncreQty(0);
                this.tSsmReqGoodsOrderItemMapper.insertRequireOrderItem(item);
            }
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站没有" + sdf.format(orderDate) + " 可以生成要货计划的行项目");
        }
        //查询出今天的要货计划
        return this.searchRequireOrder(orderDate);
    }
    @Override
    public Date getSalOrderDate(Date orderDate, TMdBranch branch){
        TSysUser user = userSessionService.getCurrentUser();
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode(SysContant.getSystemConst("branch_require_date"));
        codeItem.setItemCode(user.getSalesOrg());
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        if(codeItem == null){
            if("01".equals(branch.getBranchGroup())){
                return orderDate;
            }else{
                return DateUtil.getDay(orderDate,1);
            }
        }else{
            if("01".equals(branch.getBranchGroup())){
                return DateUtil.getDay(orderDate,Integer.valueOf(codeItem.getAttr2()));
            }else{
                return DateUtil.getDay(orderDate,Integer.valueOf(codeItem.getAttr3()));
            }
        }
    }
    @Override
    public Date getRequireDate(Date orderDate) {
        TSysUser user = userSessionService.getCurrentUser();
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode(SysContant.getSystemConst("branch_require_date"));
        codeItem.setItemCode(user.getSalesOrg());
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        if(codeItem == null){
           return DateUtil.getDay(orderDate,1);
        }else{
            String attr = codeItem.getAttr1();
            int num = Integer.valueOf(attr);
            return DateUtil.getDay(orderDate,num);
        }
//        if ("4181".equals(user.getSalesOrg()) || "4390".equals(user.getSalesOrg())) {
//            requireDate = orderDate;
//        }else if("4511".equals(user.getSalesOrg()) || "4151".equals(user.getSalesOrg())){
//            requireDate = DateUtil.getDayAfterTomorrow(orderDate);
//        } else {
//            requireDate = DateUtil.getTomorrow(orderDate);
//        }
    }

    @Override
    public Date getZyOrderDate(Date requireDate) {
        TSysUser user = userSessionService.getCurrentUser();
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode(SysContant.getSystemConst("branch_require_date"));
        codeItem.setItemCode(user.getSalesOrg());
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        if(codeItem == null){
            return DateUtil.getDay(requireDate,-1);
        }else{
            String attr = codeItem.getAttr4();
            int num = Integer.valueOf(attr) ;
            return DateUtil.getDay(requireDate,num*-1);
        }
    }

    @Override
    public String sendRequireOrderToERPByDate(ReqGoodsOrderSearch eSearch) {
        String result = "";
        Date orderDate = eSearch.getRequiredDate();
        TSysUser user = userSessionService.getCurrentUser();
        String salesOrg = user.getSalesOrg();
        String branchNo = user.getBranchNo();
        RequireOrderSearch search = new RequireOrderSearch();
        search.setOrderDate(orderDate);
        search.setBranchNo(branchNo);
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.searchRequireOrder(search);
        String errorMessage = "";
        if (order == null) {
            errorMessage = "今天的要货计划还未创建";
            throw new ServiceException(MessageCode.LOGIC_ERROR, errorMessage);
        } else {
            if ("30".equals(order.getStatus())) {
                errorMessage = "今天的要货计划已发送至ERP";
                throw new ServiceException(MessageCode.LOGIC_ERROR, errorMessage);
            }
            TMdBranch branch = branchMapper.selectBranchByNo(branchNo);
            //自营奶站
            if ("01".equals(branch.getBranchGroup())) {
                PISuccessMessage message = piRequireOrderService.generateRequireOrder(order);
                if (message.isSuccess()) {
                    order.setVoucherNo(message.getData());
                    if (!uptRequireOrderAndDayOrderStatus(order, user)) {
                        errorMessage = "修改要货计划或日订单状态失败";
                        throw new ServiceException(MessageCode.LOGIC_ERROR, errorMessage);
                    }
                    result = order.getVoucherNo();
                } else {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, message.getMessage());
                }
            } else {
//                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                String redisKey = branchNo+format.format(orderDate);
                Object isSal = stringRedisTemplate.opsForHash().get("SALORDER",redisKey);
                if(isSal != null && "ON".equals(isSal)){
                    stringRedisTemplate.opsForHash().put("SALORDER", redisKey, "OFF");
                    throw new ServiceException(MessageCode.LOGIC_ERROR,"销售订单已经发送，请耐心等待！");
                }else {
                    stringRedisTemplate.opsForHash().put("SALORDER", redisKey, "ON");
                    //经销商奶站 生成销售订单 并发送
                    this.creaSalOrderOfDealerBranchByDate(orderDate);
                    order.setLastModified(new Date());
                    order.setLastModifiedBy(user.getLoginName());
                    order.setLastModifiedByTxt(user.getDisplayName());
                    order.setStatus("30");
                    tSsmReqGoodsOrderMapper.uptRequireGoodsModifyInfo(order);
                    stringRedisTemplate.opsForHash().put("SALORDER", redisKey,"OFF");
                }
            }
        }
        return result;
    }

    @Override
    public Map<String,Integer> findReqGoodResendByOrderNo(Date orderDate,String branchNo){
        RequireOrderSearch search = new RequireOrderSearch();
        search.setOrderDate(orderDate);
        search.setBranchNo(branchNo);
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.searchRequireOrder(search);
        Map<String, Integer> results = new HashMap<String, Integer>();
        if(order != null) {
            List<TSsmReqGoodsOrderItem> items = this.tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByOrderNo(order.getOrderNo());
            items.stream().forEach(e -> {
                if (e.getResendQty() > 0) {
                    results.put(e.getMatnr(), e.getResendQty());
                }
            });
        }
        return results;
    }

    @Override
    public List<TMstRefuseResend> findReqGoodResendByEmpNo(Date orderDate, String branchNo) {
        RequireOrderSearch search = new RequireOrderSearch();
        search.setOrderDate(orderDate);
        search.setBranchNo(branchNo);
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.searchRequireOrder(search);
        return resendMapper.selectUseQtyByEmpNoAndMatnr(order.getOrderNo());
    }

    /**
     * 生成经销商奶站送奶工的销售订单
     * @param orderDate
     * @param branchNo
     * @param salesOrg
     * @return
     */
    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfDealerBranchAndEmpNo(Date orderDate, String branchNo, String salesOrg) {
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranchAndEmpNo(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet empSet = new HashSet();
        Map<String,String> sapcodeMap = new HashMap<String,String>();
        for(Map<String,Object> map : orgList){
            String empNo =  map.get("empNo").toString();
            TMdBranchEmp branchEmp = branchEmpMapper.selectBranchEmpByNo(empNo);
            String sapcode = branchEmp.getSapcode();
            if(StringUtils.isEmpty(sapcode)){
               if(!empSet.contains(branchEmp.getEmpName()))
                   empSet.add(branchEmp.getEmpName());
            }
            sapcodeMap.put(empNo,sapcode);
        }
        if(empSet.size()>0){
            stringBuilder.append(empSet.toString() + "没有设置SAP客户编码，请为送奶员设置SAP客户编码！");
            stringRedisTemplate.opsForHash().put("SALORDER", user.getBranchNo()+format.format(orderDate),"OFF");
            throw new ServiceException(MessageCode.LOGIC_ERROR,stringBuilder.toString());
        }
        List<TMstRefuseResend> refuseQtys = this.findReqGoodResendByEmpNo(orderDate,branchNo);
        for(Map<String,Object> map : orgList){
            String empNo = map.get("empNo").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            //减去拒收复送量
            for(TMstRefuseResend refuseResend : refuseQtys){
                if(refuseResend.getMatnr().equals(matnr) && refuseResend.getEmpNo().equals(empNo)){
                    qty = qty.subtract(refuseResend.getUseQty());
                }
            }
            if(orderMap.containsKey(empNo)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(empNo);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                itemList.add(item);
                orderMap.put(empNo,itemList);
            }
        }

        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate,"dealer","",1,"EM",sapcodeMap.get(orgCode),branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "dealer");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    @Override
    public boolean isEmpSendMode() {
        TSysUser user = userSessionService.getCurrentUser();
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode(SysContant.getSystemConst("emp_send_mode"));
        codeItem.setItemCode(user.getSalesOrg());
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        if(codeItem != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TSsmSalOrder creatNoPromoSalOrderAndSendOfSelftBranch(Date requiredDate) {
        TSsmSalOrder entry = this.creatNoPromoSalOrderOfSelftBranch(requiredDate);
        generateSalesOrderAnduptVouCher(entry);
        return entry;
    }

    @Override
    public TSsmSalOrder creatPromoSalOrderAndSendOfSelftBranch(Date requiredDate) {
        TSsmSalOrder entry = this.creatPromoSalOrderOfSelftBranch(requiredDate);
        generateSalesOrderAnduptVouCher(entry);
        return entry;
    }

    /**
     * 自营奶站生成销售订单和发送销售订单到ERP
     * 销售订单生成规则：
     * 1：奶站促销的订单
     * 2：牛奶钱包的促销的订单
     * 3 牛奶钱包非促销订单
     * 4 机构订奶的销售订单
     * 5 正常订单 （交货单减去其他销售订单）
     * @param search
     * @return
     */
    @Override
    public List<TSsmSalOrder> creaSalOrderOfSelftBranchByDate2(SalOrderDaySearch search) {
        boolean flag1 = isEmpSendMode();
        if(flag1){
           return creaSalOrderOfSelftBranchAndEmpNoByDate(search);
        }
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranch branch = branchMapper.selectBranchByNo(user.getBranchNo());
        Date orderDate = search.getOrderDate();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(user.getBranchNo());
//        rModel.setOrderDate(DateUtil.getYestoday(orderDate));
        rModel.setOrderDate(this.getZyOrderDate(orderDate));
        rModel.setSalesOrg(user.getSalesOrg());
        //获取要的货是今天的要货计划
        TSsmReqGoodsOrder reqGoodsOrder = this.tSsmReqGoodsOrderMapper.searchRequireOrder(rModel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (reqGoodsOrder == null || StringUtils.isBlank(reqGoodsOrder.getVoucherNo())) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "今天还没要货");
        } else {
            //判断要货计划对应的 交货单 是否生成 若没生成 提示还没生成
            List<TSsmGiOrder> giOrders = tSsmGiOrderMapper.findGiOrderByReqOrderNo(reqGoodsOrder.getVoucherNo());
            if (giOrders == null || giOrders.size() <= 0) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的交货单还没有生成，请先获取交货单");
            } else {
                //判断所有的交货计划是否都已确认过
                if (giOrders.stream().anyMatch(
                        (e) -> (!"30".equals(e.getStatus()))
                )
                        ) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "含有未确认的交货单，请确认!");
                }
                SalOrderModel sMode = new SalOrderModel();
                sMode.setOrderDate(orderDate);
                sMode.setBranchNo(branch.getBranchNo());
                //查看今天销售订单
                List<TSsmSalOrder> result = tSsmSalOrderMapper.selectSalOrderByDateAndNo(sMode);
                if (result != null && result.size() > 0) {
                    Boolean flag = true;
                    for (TSsmSalOrder entry : result) {
                        if (StringUtils.isNotBlank(entry.getVoucherNo())) {
                            continue;
                        } else {
                            flag = false;
                            generateSalesOrderAnduptVouCher(entry);
                        }
                    }
                    if (flag) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站今天已经创建所有销售订单,请直接查询");
                    }
                    return this.getSaleOrderByQueryDate(sMode);
                } else {
                    //判断今天的路单是否已经生成
                    List<TDispOrder> dispOrders = tDispOrderMapper.selectDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
                    if (dispOrders == null || dispOrders.size() == 0) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单还没生成，请先生成路单并全部确认后再生成");
                    } else {
                        //判断今天的路单是否已经全部确认
                        List<TDispOrder> confirmDispOrders = tDispOrderMapper.selectConfirmDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
                        if (confirmDispOrders != null) {
                            if (confirmDispOrders.size() < dispOrders.size()) {
                                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单还有" + (dispOrders.size() - confirmDispOrders.size()) + "个路单没确认，请全部确认后再生成");
                            }
                        } else {
                            throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单所有的路单都没确认，请全部确认后再生成");
                        }
                    }

                    if ("01".equals(branch.getBranchGroup())) {
                        RequireOrderSearch rsModel = new RequireOrderSearch();
                        rsModel.setBranchNo(user.getBranchNo());
                        rsModel.setSalesOrg(user.getSalesOrg());
                        rsModel.setOrderDate(orderDate);
                        rsModel.setPreorderSource("30");

                        //获取交货单中的产品
                        rModel.setReqOrderNo(reqGoodsOrder.getVoucherNo());
                        List<TOrderDaliyPlanItem> planItems = tSsmGiOrderItemMapper.selectNoProDayPlanOfSelfBranch(rModel);
                        Map<String, Integer> entries = new HashMap<String, Integer>();
                        if (planItems != null && planItems.size() > 0) {
                            for (TOrderDaliyPlanItem planItem : planItems) {
                                entries.put(planItem.getConfirmMatnr(), planItem.getQty());
                            }
                        }
                        //年卡销售订单
                        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
                        TSsmSalOrder yearOrder = creatPromDaliyDiscountAmtOfBranchSubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(yearOrder != null){
                            salOrderList.add(yearOrder);
                        }
                        //机构订单
                        List<TSsmSalOrder> orgOrders = creatProDayPlanOfSelfOrgSubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(orgOrders != null && orgOrders.size()>0){
                            salOrderList.addAll(orgOrders);
                        }
                        //牛奶钱包
                        TSsmSalOrder noprom40 = creatNoPromoSalOrderOfBranch40SubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(noprom40 != null){
                            salOrderList.add(noprom40);
                        }
                        //牛奶钱包满赠
                        TSsmSalOrder prom40 = creatPromoSalOrderOfBranch40SubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(prom40 != null){
                            salOrderList.add(prom40);
                        }
                        //电商订单
                        List<TSsmSalOrder> noprom10 = creatNoPromoSalOrderOfBranch10SubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(noprom10 != null && noprom10.size() > 0){
                            salOrderList.addAll(noprom10);
                        }
                        //电商订单满赠
                        List<TSsmSalOrder> prom10 = creatPromoSalOrderOfBranch10SubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(noprom10 != null && noprom10.size() > 0){
                            salOrderList.addAll(prom10);
                        }
                        //免费订单 TODO
                        TSsmSalOrder free = creatNoPromoSalOrderOfBranch90(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(free != null){
                            salOrderList.add(free);
                        }
                        //奶站订单满赠
                        TSsmSalOrder prom = creatProDayPlanOfSelfBranchSubGi(orderDate,branch.getBranchNo(),branch.getSalesOrg(),entries);
                        if(prom != null){
                            salOrderList.add(prom);
                        }

                        //获取确认后的路单中的参加促销的产品
//                        List<TOrderDaliyPlanItem> yearItems = new ArrayList<TOrderDaliyPlanItem>();
//                        List<Map<String,String>> itemMap = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfBranch(rModel);
//                        if (itemMap != null && itemMap.size() > 0) {
//                            for (Map<String, String> map : itemMap) {
//                                String matnr = map.get("MATNR").toString();
//                                BigDecimal qty = new BigDecimal(String.valueOf(map.get("QTY")));
//                                BigDecimal price = new BigDecimal(String.valueOf(map.get("PRICE1")));
//                                BigDecimal discountAmt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
//                                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
//                                item.setQty(qty.intValue());
//                                item.setMatnr(matnr);
//                                item.setConfirmMatnr(matnr);
//                                item.setPrice(price);
//                                item.setAmt(discountAmt);
//                                yearItems.add(item);
//                            }
//                        }
//                        //奶站促销
//                        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rsModel);
//                        rsModel.setPreorderSource("40");
//                        //牛奶钱包促销
//                        List<TOrderDaliyPlanItem> item40s = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rsModel);
//                        //牛奶钱包非促销
//                        List<TOrderDaliyPlanItem> itemNo40s = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch40(rsModel);
//                        //机构订奶
//                        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfOrg(rsModel);
//                        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
//                        for(Map<String,Object> map : orgList){
//                            String orgCode = map.get("orgCode").toString();
//                            String matnr = map.get("matnr").toString();
//                            BigDecimal qty = (BigDecimal)map.get("qty");
//                            if(orderMap.containsKey(orgCode)) {
//                                List<TOrderDaliyPlanItem> itemList = orderMap.get(orgCode);
//                                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
//                                item.setQty(qty.intValue());
//                                item.setConfirmMatnr(matnr);
//                                item.setMatnr(matnr);
//                                itemList.add(item);
//                            }else{
//                                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
//                                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
//                                item.setQty(qty.intValue());
//                                item.setMatnr(matnr);
//                                item.setConfirmMatnr(matnr);
//                                itemList.add(item);
//                                orderMap.put(orgCode,itemList);
//                            }
//                        }
//                        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
//                        if(orderMap.size()>0){
//                            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet()){
//                               String orgCode =  entry.getKey();
//                                List<TOrderDaliyPlanItem> itemOrgs = entry.getValue();
//                                TSsmSalOrder salOrder = null;
//                                salOrder = createSsmSalOrderAndItmes(search.getOrderDate(),user,itemOrgs,entries, "","70",orgCode);
//                                if(salOrder!=null){
//                                    salOrderList.add(salOrder);
//                                }
//                            }
//                        }
//
//                        TSsmSalOrder prom = null;
//                        TSsmSalOrder prom40 = null;
//                        TSsmSalOrder noprom40 = null;
//                        TSsmSalOrder yearOrder = null;
//
//                        if(yearItems.size()>0) {
//                            String onlineCode = getYearCode(user.getSalesOrg());
//                            yearOrder = createSsmSalOrderAndItmes(search.getOrderDate(), user, yearItems, entries, "", "YE", onlineCode);
//                        }
//                        noprom40 = createSsmSalOrderAndItmes(search.getOrderDate(), user, itemNo40s, entries, "", "40", "");
//                        prom40 = createSsmSalOrderAndItmes(search.getOrderDate(), user, item40s, entries, "free", "40", "");
//                        prom = createSsmSalOrderAndItmes(search.getOrderDate(), user, items, entries, "free", "30", "");
                        //生成 不参加促销
                        if (entries != null && entries.size() > 0) {
                            TSsmSalOrder noprom = createSalOrderByGiOrderMap(entries, user, orderDate);
                            salOrderList.add(noprom);
                        }

                        if(salOrderList.size()>0){
                            for (TSsmSalOrder salOrder : salOrderList){
                                generateSalesOrderAnduptVouCher(salOrder);
                            }
                        }
//                        if(yearOrder!=null){
//                            generateSalesOrderAnduptVouCher(yearOrder);
//                        }
//
//                        if (noprom40!=null){
//                            generateSalesOrderAnduptVouCher(noprom40);
//                        }
//                        if (noprom != null) {
//                            generateSalesOrderAnduptVouCher(noprom);
//                        }
//                        if (prom != null) {
//                            generateSalesOrderAnduptVouCher(prom);
//                        }
//                        if (prom40 != null) {
//                            generateSalesOrderAnduptVouCher(prom40);
//                        }
                        return this.getSaleOrderByQueryDate(sMode);
                    } else {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站不是自营奶站");
                    }
                }
            }
        }
    }
    private TSsmSalOrder createSsmSalOrderAndItmes(Date orderDate, TSysUser user, List<TOrderDaliyPlanItem> item40s, Map<String, Integer> entries, String free, String preorderSource, String onlineCode) {
        TSsmSalOrder order = null;
        if (item40s != null && item40s.size() > 0) {
            boolean hasCreateOrder = false;
            for (int i = 1; i <= item40s.size(); i++) {
                TOrderDaliyPlanItem item = item40s.get(i - 1);
                if (entries.containsKey(item.getConfirmMatnr())) {
                    if (!hasCreateOrder) {
                        order = createSaleOrder(orderDate, "branch", free , 2, preorderSource, onlineCode,user.getBranchNo() ,user.getSalesOrg() );
                        hasCreateOrder = true;
                    }
                    if (item.getQty() >= entries.get(item.getConfirmMatnr())) {
                        item.setQty(entries.get(item.getConfirmMatnr()));
                        entries.remove(item.getConfirmMatnr());
                    } else {
                        entries.replace(item.getConfirmMatnr(), entries.get(item.getConfirmMatnr()) - item.getQty());
                    }
                    setBalanceAmt(item);
                    createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "branch");
                } else {
                    continue;
                }
            }
        }
        return order;
    }

    private void setBalanceAmt(TOrderDaliyPlanItem item) {
        BigDecimal amt = item.getRemainAmt();
        if(amt != null) {
            if (item.getBalanceAmt() != null) {
                amt = amt.add(item.getBalanceAmt());
            }
            BigDecimal qty = new BigDecimal(item.getQty());
            BigDecimal price = amt.divide(qty, 2, BigDecimal.ROUND_DOWN);
            item.setPrice(price);
            BigDecimal balanceAmt = amt.subtract(price.multiply(qty));
            item.setBalanceAmt(balanceAmt);
        }
    }

    @Override
    public List<TMstRefuseResend>  queryRefuseResendByMatnr(String matnr,String reqOrderNo) {
        TSysUser user = userSessionService.getCurrentUser();
        return resendMapper.queryRefuseResendByMatnr(matnr,user.getBranchNo(),reqOrderNo);
    }

    @Override
    public int uptRequireOrderByResendItem(UptReqOrderByResendItemMode umodel) {
        List<TMstRefuseResend> resendlist = umodel.getEntries();
        if (resendlist != null && resendlist.size() > 0) {
            TSsmReqGoodsOrderItem item = tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByMatnrAndOrderNo(umodel.getReqOrderNo(), umodel.getMatnr());
            TSysUser user = userSessionService.getCurrentUser();

            String reqOrderNo = item.getOrderNo();
            int total = resendlist.stream().mapToInt(r -> r.getUseQty().intValue()).sum();
            if (item.getQty() + item.getIncreQty() < total) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "选择的拒收复送总数不应该大于要货数量");
            }

            //要货减少量
            int uptReqQty = 0;
            for(TMstRefuseResend resend : resendlist){
                String resendOrderNo = resend.getResendOrderNo();
                //单条拒收复送应用增加量
                BigDecimal addQty = BigDecimal.ZERO;
                //生成使用拒收复送详情
                TMstRefuseResend oldResend = resendMapper.selectRefuseResendByNo(resend.getResendOrderNo());
                TMstRefuseResendItem oldResendItem = resendItemMapper.selectItemByReqorderAndNo(umodel.getReqOrderNo(),resend.getResendOrderNo());
                if(oldResendItem != null){
                    //如果等于0 说明不再应用
                    if(resend.getUseQty().compareTo(BigDecimal.ZERO) == 0){
                        uptReqQty = uptReqQty +oldResendItem.getQty().intValue();
                        addQty = addQty.subtract(oldResendItem.getQty());
                        resendItemMapper.delResendItemByReOrderNoAndResendOrderNo(umodel.getReqOrderNo(),oldResend.getResendOrderNo());
                    }else{
                        uptReqQty = uptReqQty +oldResendItem.getQty().subtract(resend.getUseQty()).intValue();
                        addQty =addQty.add(resend.getUseQty().subtract(oldResendItem.getQty()));
                        //如果大于零  说明改变应用
                        oldResendItem.setQty(resend.getUseQty());
                        resendItemMapper.uptResendItem(oldResendItem);
                    }
                    //库存
                    stockService.updateTmpStock(oldResend.getBranchNo(),oldResend.getMatnr(),resend.getUseQty().subtract(oldResendItem.getQty()),user.getSalesOrg());
                }else{
                    if(resend.getUseQty().compareTo(BigDecimal.ZERO) == 0){
                        continue;
                    }else{
                        addQty = addQty.add(resend.getUseQty());
                        uptReqQty = uptReqQty + resend.getUseQty().multiply(new BigDecimal(-1)).intValue();
                        TMstRefuseResendItem resendItem = new TMstRefuseResendItem();
                        resendItem.setResendOrderNo(resendOrderNo);
                        resendItem.setOrderNo(reqOrderNo);
                        resendItem.setType("10");
                        resendItem.setCreateAt(new Date());
                        resendItem.setCreateBy(user.getLoginName());
                        resendItem.setQty(resend.getUseQty());
                        resendItemMapper.addResendItem(resendItem);
                        //库存
                        stockService.updateTmpStock(oldResend.getBranchNo(),oldResend.getMatnr(),resend.getUseQty(),user.getSalesOrg());
                    }
                }
                if(resend.getUseQty().compareTo(BigDecimal.ZERO)==0 && oldResendItem==null){
                    continue;
                }else{
                    //更新拒收复送 信息
                    oldResend.setRemainQty(oldResend.getRemainQty().subtract(addQty));
                    oldResend.setConfirmQty(oldResend.getConfirmQty().add(addQty));
                    if(oldResend.getRemainQty().compareTo(BigDecimal.ZERO) != -1){
                        oldResend.setStatus("20");
                    }else{
                        oldResend.setStatus("30");
                    }
                    resendMapper.uptRefuseResend(oldResend);
                }
            }
            //更新 要货计划行信息
            TSsmReqGoodsOrderItemUpt uptItem = new TSsmReqGoodsOrderItemUpt();

            uptItem.setResendQty(item.getResendQty()-uptReqQty);
            uptItem.setQty(item.getQty()+uptReqQty);
            uptItem.setOrderNo(item.getOrderNo());
            uptItem.setOldMatnr(item.getMatnr());
            tSsmReqGoodsOrderItemMapper.uptNewReqGoodsItem(uptItem);
            return 1;
        } else {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "拒收复送参数不能为空");
        }

    }

    @Override
    public PageInfo searchRequireOrderByDealer(RequireOrderSearchPage rModel) {
        TSysUser user =userSessionService.getCurrentUser();
        rModel.setDealerId(user.getDealerId());
        return tSsmReqGoodsOrderMapper.searchRequireOrderByDealer(rModel);
    }
    @Override
    public PageInfo searchSalOrderByDealer(RequireOrderSearchPage rModel) {
        TSysUser user =userSessionService.getCurrentUser();
        rModel.setDealerId(user.getDealerId());
        return tSsmSalOrderMapper.searchSalOrderByDealer(rModel);
    }
    @Override
    public RequireOrderModel getRequireOrderByOrderNo(String orderNo) {
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.getRequireOrderByNo(orderNo);
        TSysUser user =userSessionService.getCurrentUser();
        String salesOrg = user.getSalesOrg();
        RequireOrderModel orderModel = new RequireOrderModel();
        if (order != null) {
            List<TMstRefuseResend>  resendList = resendMapper.findNoUsedAndUsedRefuseResend(order.getBranchNo(),order.getOrderNo());
            Set<String> matnrMap = new HashSet<String>();
            if(resendList!=null && resendList.size()>0){
                resendList.stream().forEach(resend->{
                    matnrMap.add(resend.getMatnr());
                });
            }
            orderModel.setStatus(order.getStatus());
            orderModel.setRequiredDate(order.getOrderDate());
            orderModel.setBranchNo(order.getBranchNo());
            orderModel.setOrderNo(order.getOrderNo());
            orderModel.setOrderDate(order.getOrderDate());
            if (StringUtils.isNotBlank(order.getVoucherNo())) {
                orderModel.setVoucherNo(order.getVoucherNo());
            }
            List<TSsmReqGoodsOrderItem> items = this.tSsmReqGoodsOrderItemMapper.getReqGoodsItemsByOrderNo(order.getOrderNo());
            List<OrderRequireItem> entries = new ArrayList<OrderRequireItem>();
            for (TSsmReqGoodsOrderItem item : items) {
                OrderRequireItem entry = new OrderRequireItem();
                Map<String, String> map = new HashMap<String, String>();
                map.put("salesOrg", salesOrg);
                map.put("matnr", item.getMatnr());
                TMdMara mara = tMdMaraMapper.selectProductByCode(map);
                if(matnrMap.contains(item.getMatnr())){
                    entry.setHasTmp(true);
                } else {
                    entry.setHasTmp(false);
                }
                entry.setResendQty(item.getResendQty());
                entry.setMatnr(item.getMatnr());
                entry.setMatnrTxt(mara.getMatnrTxt());
                entry.setQty(item.getQty());
                entry.setFlag(item.getFlag());
                entry.setIncreQty(item.getIncreQty());
                entries.add(entry);
            }
            orderModel.setEntries(entries);
        } else {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "当天的要货计划还未生成");
        }
        return orderModel;
    }

    @Override
    public String batchSendSalOrder(List orderNos) {
        StringBuilder builder = new StringBuilder();
        if(orderNos.size()>0) {
            TSysUser user = userSessionService.getCurrentUser();
            NHSysCodeItem codeItem = new NHSysCodeItem();
            codeItem.setTypeCode("2008");
            codeItem.setItemCode("1");
            codeItem = dictionaryService.findCodeItenByCode(codeItem);
            if(codeItem == null){
                throw new ServiceException(MessageCode.LOGIC_ERROR,"该销售组织没有开通经销商统一报货权限！");
            }
            String dealerSend = codeItem.getItemName();
            //判读是否是经销商统一报货，同时判读是否是大商
//            if(dealerSend.contains(user.getSalesOrg())&&!user.getDealerId().equals(user.getBranchNo())){
            if(dealerSend.contains(user.getSalesOrg())){
                for (int i = 0; i < orderNos.size(); i++) {
                    String orderNo = orderNos.get(i).toString();
                    try {
                        sendSalOrderErp(orderNo, user);
                    } catch (Exception e) {
                        e.getMessage();
                        builder.append(orderNo + "--" + e.getMessage());
                    }
                }
            }else{
                throw new ServiceException(MessageCode.LOGIC_ERROR,"该销售组织没有开通经销商统一报货权限！");
            }
            if(builder.length()>0){
                logger.error(builder.toString());
            }
        }
        return builder.toString();
    }
    private void sendSalOrderErp(String orderNo, TSysUser user) {
        TSsmReqGoodsOrder order = tSsmReqGoodsOrderMapper.getRequireOrderByNo(orderNo);
        if(!"30".equals(order.getStatus())){
            String branchNo = order.getBranchNo();
            TMdBranch branch = branchMapper.selectBranchByNo(branchNo);
            String salesOrg = branch.getSalesOrg();
            Date orderDate =order.getOrderDate();
            //是否存在销售订单
            SalOrderModel sMode = new SalOrderModel();
            sMode.setOrderDate(orderDate);
            sMode.setBranchNo(branchNo);
            List<TSsmSalOrder> results = tSsmSalOrderMapper.selectSalOrderByDateAndNo(sMode);
            if (results != null && results.size() > 0) {
                for (TSsmSalOrder item : results) {
                    if (StringUtils.isNotBlank(item.getVoucherNo())) {
                        continue;
                    } else {
                        generateSalesOrderAnduptVouCher(item);
                    }
                }
            } else {
                TSsmSalOrder noPromOrder = this.creatNoPromoSalOrderOfDealerBranch(orderDate,branchNo ,salesOrg );
                TSsmSalOrder promOrder = this.creatPromoSalOrderOfDealerBranch(orderDate,branchNo ,salesOrg );
                //经销商机构订奶
                List<TSsmSalOrder> salOrderList = creatNoPromoSalOrderOfDealerBranch70(orderDate,branchNo ,salesOrg );
                if(salOrderList.size()>0){
                    for(TSsmSalOrder order1 : salOrderList) {
                        generateSalesOrderAnduptVouCher(order1);
                    }
                }
                if (noPromOrder != null) {
                    generateSalesOrderAnduptVouCher(noPromOrder);
                }
                if (promOrder != null) {
                    generateSalesOrderAnduptVouCher(promOrder);
                }
            }
            order.setLastModified(new Date());
            order.setLastModifiedBy(user.getLoginName());
            order.setLastModifiedByTxt(user.getDisplayName());
            order.setStatus("30");
            tSsmReqGoodsOrderMapper.uptRequireGoodsModifyInfo(order);
        }
    }

    /**
     * 根据 交货单 产品数量 生成  不参加促销的销售订单
     */

    public TSsmSalOrder createSalOrderByGiOrderMap(Map<String, Integer> giOrderMap, TSysUser user, Date orderDate) {
        TSsmSalOrder order = createSaleOrder(orderDate, "branch", "", 1, "30", "",user.getBranchNo() ,user.getSalesOrg() );
        int i = 0;
        for (String key : giOrderMap.keySet()) {
            i = i + 1;
            TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
            item.setQty(giOrderMap.get(key));
            item.setConfirmMatnr(key);
            createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
        }
        return order;
    }

    /**
     * 自营奶站 根据已确认路单  和  内部销售订单 生成销售订单
     * 创建前 判断是否已经生成 -> 判断今天的路单是否已经生成 -> 判断今天的路单是否已经全部确认(否则给出提示)
     *
     * @param search
     * @return
     */
    @Override
    public List<TSsmSalOrder> creaSalOrderOfSelftBranchByDate(SalOrderDaySearch search) {
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranch branch = branchMapper.selectBranchByNo(user.getBranchNo());
        SalOrderModel sMode = new SalOrderModel();
        sMode.setOrderDate(search.getOrderDate());
        sMode.setBranchNo(branch.getBranchNo());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<TSsmSalOrder> result = tSsmSalOrderMapper.selectSalOrderByDateAndNo(sMode);
        if (result != null && result.size() > 0) {
            Boolean flag = true;
            for (TSsmSalOrder entry : result) {
                if (StringUtils.isNotBlank(entry.getVoucherNo())) {
                    continue;
                } else {
                    flag = false;
                    generateSalesOrderAnduptVouCher(entry);
                }
            }
            if (flag) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "已经创建所有销售订单,请直接查询");
            }
            return this.getSaleOrderByQueryDate(sMode);
        } else {

            //判断今天的路单是否已经生成
            List<TDispOrder> dispOrders = tDispOrderMapper.selectDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
            if (dispOrders == null || dispOrders.size() == 0) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + " 这天的路单还没生成，请先生成路单并全部确认后再生成");
            } else {
                //判断今天的路单是否已经全部确认
                List<TDispOrder> confirmDispOrders = tDispOrderMapper.selectConfirmDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
                if (confirmDispOrders != null) {
                    if (confirmDispOrders.size() < dispOrders.size()) {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单还有" + (dispOrders.size() - confirmDispOrders.size()) + "个路单没确认，请全部确认后再生成");
                    }
                } else {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单所有的路单都没确认，请全部确认后再生成");
                }
            }
            if ("01".equals(branch.getBranchGroup())) {
                //首先创建，创建完再发送
                TSsmSalOrder noprom = this.creatNoPromoSalOrderOfSelftBranch(search.getOrderDate());
                TSsmSalOrder prom = this.creatPromoSalOrderOfSelftBranch(search.getOrderDate());
                if (noprom != null) {
                    generateSalesOrderAnduptVouCher(noprom);
                }
                if (prom != null) {
                    generateSalesOrderAnduptVouCher(prom);
                }
                return this.getSaleOrderByQueryDate(sMode);
            } else {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站不是自营奶站");
            }
        }

    }

    /**
     * 生成经销商的销售订单并发送到ERP
     * 1：标准销售订单
     * 2：促销销售订单
     * 3：机构销售订单
     * @param orderDate
     * @return
     */
    @Override
    public int creaSalOrderOfDealerBranchByDate(Date orderDate) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        TSysUser user = userSessionService.getCurrentUser();
        NHSysCodeItem codeItem = new NHSysCodeItem();
        codeItem.setTypeCode("2008");
        codeItem.setItemCode("1");
        codeItem = dictionaryService.findCodeItenByCode(codeItem);
        //判断是否有经销商统一报货
        if(codeItem != null
                && codeItem.getItemName().contains(user.getSalesOrg())
                && !user.getDealerId().equals(user.getBranchNo())){
            stringRedisTemplate.opsForHash().put("SALORDER", user.getBranchNo()+format.format(orderDate),"OFF");
            throw new ServiceException(MessageCode.LOGIC_ERROR,"该公司必须由经销商统一报货！");
        }
        SalOrderModel sMode = new SalOrderModel();
        sMode.setOrderDate(orderDate);
        sMode.setBranchNo(user.getBranchNo());
        List<TSsmSalOrder> results = tSsmSalOrderMapper.selectSalOrderByDateAndNo(sMode);
        if (results != null && results.size() > 0) {
            Boolean flag = true;
            for (TSsmSalOrder item : results) {
                if (StringUtils.isNotBlank(item.getVoucherNo())) {
                    continue;
                } else {
                    flag = false;
                    generateSalesOrderAnduptVouCher(item);
                }
            }
            if (flag) {
                stringRedisTemplate.opsForHash().put("SALORDER", user.getBranchNo()+format.format(orderDate),"OFF");
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站今天已经创建所有销售订单,请直接查询");
            }
            return 1;
        } else {
            List<TSsmSalOrder> ssmSalOrders = new ArrayList<TSsmSalOrder>();
            //年卡销售订单
            TSsmSalOrder yearOrder = this.createPromDaliyDiscountAmtOfDearler(orderDate,user.getBranchNo(),user.getSalesOrg());
            if(yearOrder != null){
                ssmSalOrders.add(yearOrder);
            }
            boolean flag = isEmpSendMode();
            if(flag){
                //送奶工报货
                List<TSsmSalOrder> ssmSalOrders1 = this.creatNoPromoSalOrderOfDealerBranchAndEmpNo(orderDate,user.getBranchNo() ,user.getSalesOrg());
                if(ssmSalOrders1.size() > 0){
                    ssmSalOrders.addAll(ssmSalOrders1);
                }
            }else {
                //奶站销售订单
                TSsmSalOrder noPromOrder = this.creatNoPromoSalOrderOfDealerBranch(orderDate,user.getBranchNo() ,user.getSalesOrg() );
                if(noPromOrder != null){
                    ssmSalOrders.add(noPromOrder);
                }
            }
            //赠品销售订单
            TSsmSalOrder promOrder = this.creatPromoSalOrderOfDealerBranch(orderDate,user.getBranchNo() ,user.getSalesOrg() );
            if(promOrder != null){
                ssmSalOrders.add(promOrder);
            }
            //经销商机构订奶
            List<TSsmSalOrder> salOrderList = this.creatNoPromoSalOrderOfDealerBranch70(orderDate,user.getBranchNo() ,user.getSalesOrg() );
            if(salOrderList.size()>0){
                ssmSalOrders.addAll(salOrderList);
            }

            TSsmSalOrder noprom40 = this.creatNoPromoSalOrderOfDealerBranch40(orderDate,user.getBranchNo(),user.getSalesOrg());
            if(noprom40 != null){
                ssmSalOrders.add(noprom40);
            }

            TSsmSalOrder prom40 = this.creatPromoSalOrderOfDealerBranch40(orderDate,user.getBranchNo(),user.getSalesOrg());
            if(prom40 != null){
                ssmSalOrders.add(prom40);
            }

            List<TSsmSalOrder> noprom10 = this.creatNoPromoSalOrderOfDealerBranch10(orderDate,user.getBranchNo(),user.getSalesOrg());
            if(noprom10 != null && noprom10.size()>0){
                ssmSalOrders.addAll(noprom10);
            }

            TSsmSalOrder free = this.creatNoPromoSalOrderOfDealerBranch90(orderDate,user.getBranchNo(),user.getSalesOrg());
            if(free != null){
                ssmSalOrders.add(free);
            }


            ssmSalOrders.forEach(e->{
                generateSalesOrderAnduptVouCher(e);
            });

        }
        return 0;
    }

    /**
     * 添加  销售订单行项目
     *
     * @param item      产品code，产品数量
     * @param i         用来生成itemNo
     * @param orderNo   销售单号
     * @param orderDate 日期
     * @param type      如果type=dealer 则为经销商订单行项目，否则为自营奶站订单行项目
     */
    private void createSaleOrderItem(TOrderDaliyPlanItem item, int i, String orderNo, Date orderDate, String type) {
        TSsmSalOrderItems salOrderItems = new TSsmSalOrderItems();
        salOrderItems.setOrderNo(orderNo);
        salOrderItems.setOrderDate(orderDate);
        salOrderItems.setQty(item.getQty());
        salOrderItems.setIniQty(item.getQty());
        //年卡折扣率
        salOrderItems.setDiscountAmt(item.getAmt());
        salOrderItems.setPrice(item.getPrice());
        salOrderItems.setYk21(item.getBalanceAmt());
        if (StringUtils.isNotBlank(item.getPromotionFlag())) {
            salOrderItems.setPromNo(item.getPromotionFlag());
        }
        if ("dealer".equals(type)) {
            salOrderItems.setMatnr(item.getMatnr());
            salOrderItems.setType("10");
        } else {
            salOrderItems.setMatnr(item.getConfirmMatnr());
            salOrderItems.setRefMatnr(item.getMatnr());
            salOrderItems.setType("20");
        }

        salOrderItems.setItemNo(i * 10);
        tSsmSalOrderItemMapper.addSalOrderItem(salOrderItems);

    }

    /**
     * 创建一个销售订单
     * @param requiredDate 日期
     * @param type         类型（dealer为经销商销售订单  branch 为自营奶站销售订单）
     * @param promotion    如果促销号不为空，则该销售订单为一个参加促销的销售订单，否则为正品促销订单
     * @param preorderSource
     * @param onlineCode @return
     * @param branchNo
     * @param salesOrg
     */
    private TSsmSalOrder createSaleOrder(Date requiredDate, String type, String promotion, int i, String preorderSource, String onlineCode, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        TSsmSalOrder order = new TSsmSalOrder();
        String orderNo = this.generateSal35Id(i, branchNo);
        order.setOrderNo(orderNo);
        order.setSalesOrg(salesOrg);
        TMdBranch branch = branchMapper.selectBranchByNo(branchNo);
        order.setRequiredDate(getSalOrderDate(requiredDate, branch));
//        if ("4181".equals(salesOrg) || "4390".equals(salesOrg)) {
//            order.setRequiredDate(requiredDate);
//        }else if("4511".equals(salesOrg) || "4151".equals(salesOrg)){
//            order.setRequiredDate(DateUtil.getDayAfterTomorrow(requiredDate));
//        }else {
//            if ("01".equals(branch.getBranchGroup())) {
//                order.setRequiredDate(requiredDate);
//            } else {
//                order.setRequiredDate(DateUtil.getTomorrow(requiredDate));
//            }
//        }

        order.setBranchNo(branchNo);
        if ("dealer".equals(type)) {
            order.setDealerNo(branch.getDealerNo());
            order.setBranchGroup("10");
        } else {
            order.setDealerNo(branchNo);
            order.setBranchGroup("20");
        }
        if ("free".equals(promotion)) {
            order.setFreeFlag("Y");
        } else {
            order.setFreeFlag("N");
        }
        order.setOrderDate(requiredDate);
        order.setCreateAt(requiredDate);
        order.setCreateByTxt(user.getDisplayName());
        order.setCreateBy(user.getLoginName());
        if (StringUtils.isNoneBlank(promotion)) {
            order.setPromNo(promotion);
        }
        order.setPreorderSource(preorderSource);
        order.setOnlineCode(onlineCode);
        tSsmSalOrderMapper.addsalOrder(order);
        return order;
    }

    private boolean uptRequireOrderAndDayOrderStatus(TSsmReqGoodsOrder order, TSysUser user) {
        //更新要货计划状态为确认
        order.setLastModified(new Date());
        order.setLastModifiedBy(user.getLoginName());
        order.setLastModifiedByTxt(user.getDisplayName());
        order.setStatus("30");
        tSsmReqGoodsOrderMapper.uptRequireGoodsModifyInfo(order);
        String branchNo = order.getBranchNo();
        String salesOrg = user.getSalesOrg();
        Date requiredDate = order.getRequiredDate();
        //更新后两天配送的订户日订单
        for (int i = 1; i <= 2; i++) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(requiredDate);
            calendar.add(calendar.DATE, i);//把日期往后增加i天.整数往后推 这个时间就是日期往后推一天的结果
            Date orderDate = calendar.getTime();
            //更近orderDate时的产品
            RequireOrderSearch search = new RequireOrderSearch();
            search.setBranchNo(branchNo);
            search.setPreDays(i);
            search.setSalesOrg(salesOrg);
            search.setRequiredDate(orderDate);
            //TODO 有问题
            List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectDaliyPlansByBranchAndDay(search);
            if (items != null && items.size() > 0) {
                for (TOrderDaliyPlanItem item : items) {
                    item.setStatus("20");
                    tOrderDaliyPlanItemMapper.updateDaliyPlanItemStatus(item);
                }
            }

        }


        return true;
    }


    public void uptVouCherNoByOrderNo(String orderNo, String voucherNo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderNo", orderNo);
        map.put("voucherNo", voucherNo);
        tSsmSalOrderMapper.uptVouCherNoByOrderNo(map);
    }

    /**
     * 销售订单编号 35位
     *
     * @return
     */
    private String generateSal35Id(int i, String branchNo) {
        TMdBranch branch = branchMapper.getBranchByNo(branchNo);
        StringBuilder uuid = new StringBuilder();
        uuid.append("DH001");
        uuid.append("A");
        uuid.append(branch.getCompanyCode());
        String branchNo1 = branch.getBranchNo();
        uuid.append(branchNo1.substring(1));
        uuid.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        uuid.append(new Random().nextInt(80) + 10 + i);
        System.out.println("------------------------" + uuid.toString());
        return uuid.toString();
    }

    /**
     * 要货单编号  30位
     *
     * @return
     */
    private String generateSal30Id() {
        TMdBranch branch = branchMapper.getBranchByNo(userSessionService.getCurrentUser().getBranchNo());
        StringBuilder uuid = new StringBuilder();
        uuid.append("DH001");
        uuid.append("B");
        uuid.append(branch.getCompanyCode());
        if (org.apache.commons.lang.StringUtils.isEmpty(branch.getLgort())) {
            uuid.append(branch.getSalesOrg());
        } else {
            uuid.append(branch.getLgort());
        }
        uuid.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        uuid.append((int) ((Math.random() * 90) + 10));
        return uuid.toString();
    }

    public void generateSalesOrderAnduptVouCher(TSsmSalOrder order) {
        TMdBranch branch = branchMapper.selectBranchByNo(order.getBranchNo());
        PISuccessMessage message = null;
//        if ("01".equals(branch.getBranchGroup())) {
//            message = piRequireOrderService.generateSalesOrder(order, order.getDealerNo(), order.getBranchNo(), order.getSalesOrg(), "");
//        } else {
//            message = piRequireOrderService.generateSalesOrder(order, order.getDealerNo(), order.getBranchNo(), order.getSalesOrg(), "");
//        }
        //送奶工报货
        if("EM".equals(order.getPreorderSource())){
            if ("01".equals(branch.getBranchGroup())) {
                message = piRequireOrderService.generateSalesOrderOfEmp(order, order.getOnlineCode(), order.getOnlineCode(), order.getSalesOrg());
            }else {
                message = piRequireOrderService.generateSalesOrderOfEmp(order, order.getBranchNo(), order.getOnlineCode(), order.getSalesOrg());
            }
        }else{
            message = piRequireOrderService.generateSalesOrder(order, order.getDealerNo(), order.getBranchNo(), order.getSalesOrg(), "");

        }
        if (message.isSuccess()) {
            this.uptVouCherNoByOrderNo(order.getOrderNo(), message.getData());
        } else {
        	//SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            stringRedisTemplate.opsForHash().put("SALORDER", order.getBranchNo()+format.format(order.getOrderDate()),"OFF");
            throw new ServiceException(MessageCode.LOGIC_ERROR, message.getMessage());
        }
    }
    
  
    
    
    
    
    
    
    @Override
    public List<TSsmSalOrder> creaSalOrderOfSelftBranchAndEmpNoByDate(SalOrderDaySearch search){
        TSysUser user = userSessionService.getCurrentUser();
        TMdBranch branch = branchMapper.selectBranchByNo(user.getBranchNo());
        Date orderDate = search.getOrderDate();
        SalOrderModel sMode = new SalOrderModel();
        sMode.setOrderDate(orderDate);
        sMode.setBranchNo(branch.getBranchNo());
        //查看今天销售订单,存在直接返回销售订单
        List<TSsmSalOrder> result = tSsmSalOrderMapper.selectSalOrderByRequiredDateAndNo(sMode);
        if (result != null && result.size() > 0) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站今天已经创建所有销售订单,请直接查询");
//            return this.getSaleOrderByQueryDate(sMode);
        }
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(user.getBranchNo());
        rModel.setOrderDate(DateUtil.getYestoday(orderDate));
        rModel.setSalesOrg(user.getSalesOrg());
        TSsmReqGoodsOrder reqGoodsOrder = this.tSsmReqGoodsOrderMapper.searchRequireOrder(rModel);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (reqGoodsOrder == null || StringUtils.isBlank(reqGoodsOrder.getVoucherNo())) {
            throw new ServiceException(MessageCode.LOGIC_ERROR, "今天还没要货");
        } else {
            //判断要货计划对应的 交货单 是否生成 若没生成 提示还没生成
            List<TSsmGiOrder> giOrders = tSsmGiOrderMapper.findGiOrderByReqOrderNo(reqGoodsOrder.getVoucherNo());
            if (giOrders == null || giOrders.size() <= 0) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的交货单还没有生成，请先获取交货单");
            } else {
                //判断所有的交货计划是否都已确认过
                if (giOrders.stream().anyMatch(
                    (e) -> (!"30".equals(e.getStatus()))
                )) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "含有未确认的交货单，请确认!");
                }
                //判断今天的路单是否已经生成
                List<TDispOrder> dispOrders = tDispOrderMapper.selectDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
                if (dispOrders == null || dispOrders.size() == 0) {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单还没生成，请先生成路单并全部确认后再生成");
                } else {
                    //判断今天的路单是否已经全部确认
                    List<TDispOrder> confirmDispOrders = tDispOrderMapper.selectConfirmDispOrderByBranchNoAndDay(user.getBranchNo(), search.getOrderDate());
                    if (confirmDispOrders != null) {
                        if (confirmDispOrders.size() < dispOrders.size()) {
                            throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单还有" + (dispOrders.size() - confirmDispOrders.size()) + "个路单没确认，请全部确认后再生成");
                        }
                    } else {
                        throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站" + sdf.format(search.getOrderDate()) + "的路单所有的路单都没确认，请全部确认后再生成");
                    }
                }
                if ("01".equals(branch.getBranchGroup())) {
                    RequireOrderSearch rsModel = new RequireOrderSearch();
                    rsModel.setBranchNo(user.getBranchNo());
                    rsModel.setSalesOrg(user.getSalesOrg());
                    rsModel.setOrderDate(orderDate);
                    rsModel.setPreorderSource("30");
                    //送奶工销售订单
                    creatNoPromoSalOrderOfBranchAndEmpNo(orderDate,user.getBranchNo(),user.getSalesOrg());
                    //奶站促销订单
                    creatPromoSalOrderOfSelftBranch(rsModel.getOrderDate());
                    //牛奶钱包销售订单
                    creatNoPromoSalOrderOfBranch40(orderDate,user.getBranchNo(),user.getSalesOrg());
                    //牛奶钱包促销订单
                    creatPromoSalOrderOfBranch40(orderDate,user.getBranchNo(),user.getSalesOrg());
                    //机构的销售订单
                    creatNoPromoSalOrderOfBranchOrg(orderDate,user.getBranchNo(),user.getSalesOrg());
                    //年卡的销售订单
                    creatPromDaliyDiscountAmtOfBranch(orderDate,user.getBranchNo(),user.getSalesOrg());
                    //电商销售订单
                    creatNoPromoSalOrderOfBranch10(orderDate,user.getBranchNo(),user.getSalesOrg());

                    creatPromoSalOrderOfBranch10(orderDate,user.getBranchNo(),user.getSalesOrg());
                    return this.getSaleOrderByQueryDate(sMode);
                } else {
                    throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站不是自营奶站");
                }
            }
        }
    }
    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfBranchAndEmpNo(Date orderDate, String branchNo, String salesOrg){
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranchAndEmpNo(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet empSet = new HashSet();
        Map<String,String> sapcodeMap = new HashMap<String,String>();
        for(Map<String,Object> map : orgList){
            String empNo =  map.get("empNo").toString();
            TMdBranchEmp branchEmp = branchEmpMapper.selectBranchEmpByEmpNo(empNo);
            String sapcode = branchEmp.getSapcode();
            if(StringUtils.isEmpty(sapcode)){
                if(!empSet.contains(branchEmp.getEmpName()))
                    empSet.add(branchEmp.getEmpName());
            }
            sapcodeMap.put(empNo,sapcode);
        }
        if(empSet.size()>0){
            stringBuilder.append(empSet.toString() + "没有设置SAP客户编码，请为送奶员设置SAP客户编码！");
            throw new ServiceException(MessageCode.LOGIC_ERROR,stringBuilder.toString());
        }
        for(Map<String,Object> map : orgList){
            String empNo = map.get("empNo").toString();
            String matnr = map.get("matnr") == null? "" : map.get("matnr").toString();
            String confirmMatnr = map.get("confirmMatnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            if(orderMap.containsKey(empNo)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(empNo);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(confirmMatnr);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(confirmMatnr);
                itemList.add(item);
                orderMap.put(empNo,itemList);
            }
        }

        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate,"branch","", 2 ,"EM",sapcodeMap.get(orgCode),branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }
    @Override
    public TSsmSalOrder creatPromoSalOrderOfBranch40(Date orderDate, String branchNo, String salesOrg){
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("40");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "branch", "free", 2, "40","",branchNo , salesOrg);
            for (int i = 1; i <= items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i - 1);
                createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "branch");
            }
            return order;
        }
        return null;
    }
    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfBranch40(Date orderDate, String branchNo, String salesOrg){
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("40");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch40(rModel);
        Map<String,Object> amts = getBalancesByMatrn40(orderDate,branchNo,salesOrg);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "branch", "", 2, "40","",branchNo , salesOrg);
            for (int i = 1; i <= items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i - 1);
                if(amts.size()>0){
                    if(amts.get(item.getMatnr()) != null)
                    item.setAmt((BigDecimal) amts.get(item.getMatnr()));
                }
                setBalanceAmt(item);
                createSaleOrderItem(item, i, order.getOrderNo(), orderDate, "branch");
            }
            return order;
        }
        return null;
    }
    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfBranchOrg(Date requiredDate, String branchNo, String salesOrg){
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(requiredDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfOrg(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String orgCode = map.get("orgCode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal remarnAmt = (BigDecimal)map.get("remainAmt");
            if(orderMap.containsKey(orgCode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(orgCode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setRemainAmt(remarnAmt);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remarnAmt);
                itemList.add(item);
                orderMap.put(orgCode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(requiredDate,"branch","",2,"70",orgCode,branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    setBalanceAmt(item);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), requiredDate, "branch");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    @Override
    public TSsmSalOrder creatPromDaliyDiscountAmtOfBranch(Date requiredDate, String branchNo, String salesOrg){
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(requiredDate);
        List<Map<String,String>> itemMap = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfBranch(rModel);
        List<TOrderDaliyPlanItem> items = new ArrayList<TOrderDaliyPlanItem>();
        if (itemMap != null && itemMap.size() > 0) {
            for (Map<String, String> map : itemMap) {
                String matnr = map.get("MATNR").toString();
                BigDecimal qty = new BigDecimal(String.valueOf(map.get("QTY")));
                BigDecimal price = new BigDecimal(String.valueOf(map.get("PRICE1")));
                BigDecimal discountAmt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                item.setAmt(discountAmt);
                items.add(item);
            }
        }
        if (items != null && items.size() > 0) {
            String onlineCode = getYearCode(user.getSalesOrg());
            TSsmSalOrder order = createSaleOrder(requiredDate, "branch", "", 2, "YE", onlineCode,branchNo , salesOrg);
            for (int i = 1; i <= items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i - 1);
                createSaleOrderItem(item, i, order.getOrderNo(), requiredDate, "branch");
            }
            return order;
        }
        return null;
    }

    /**
     * 发送自营奶站送奶工销售订单
     * @param search
     * @return
     */
    public List<TSsmSalOrder> batchSendSalOrderByDate(SalOrderDaySearch search){
        TSysUser user = userSessionService.getCurrentUser();
        SalOrderModel sMode = new SalOrderModel();
        sMode.setOrderDate(search.getOrderDate());
        sMode.setBranchNo(user.getBranchNo());
        //查看今天销售订单
        List<TSsmSalOrder> result = tSsmSalOrderMapper.selectSalOrderByDateAndNo(sMode);
        if (result != null && result.size() > 0) {
            Boolean flag = true;
            for (TSsmSalOrder entry : result) {
                if (StringUtils.isNotBlank(entry.getVoucherNo())) {
                    continue;
                } else {
                    flag = false;
                    generateSalesOrderAnduptVouCher(entry);
                }
            }
            if (flag) {
                throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站今天已经发送所有销售订单,请直接查询");
            }
            return this.getSaleOrderByQueryDate(sMode);
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR, "请先生成该日的销售订单再发送");
        }
    }

    @Override
    public List<TSsmSalOrderItems> updateSalOrderItems(List<TSsmSalOrderItems> itemss) {
        String orderNo = "";
        if(itemss != null && itemss.size()>0) {
            for (TSsmSalOrderItems e : itemss) {
                orderNo = e.getOrderNo();
                tSsmSalOrderItemMapper.updateSalOrderItem(e);
            }
            return getSaleOrderDetailByOrderNo(orderNo);
        }
        return null;
    }

    @Override
    public BigDecimal sumGiOrderItemByReqOrderNo(Date orderDate){
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(user.getBranchNo());
        rModel.setOrderDate(DateUtil.getYestoday(orderDate));
        rModel.setSalesOrg(user.getSalesOrg());
        TSsmReqGoodsOrder reqGoodsOrder = this.tSsmReqGoodsOrderMapper.searchRequireOrder(rModel);
        if(reqGoodsOrder != null && StringUtils.isNotEmpty(reqGoodsOrder.getVoucherNo())){
            return tSsmGiOrderItemMapper.sumGiOrderItemByReqOrderNo(reqGoodsOrder.getVoucherNo());
        }
        return null;
    }

    @Override
    public BigDecimal sumSalOrderByDate(Date reqOrderDate) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(user.getBranchNo());
        rModel.setRequiredDate(reqOrderDate);
        return tSsmSalOrderItemMapper.sumSalOrderByDate(rModel);
    }

    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfBranch40SubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("40");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch40(rModel);
        return createSsmSalOrderAndItmes(orderDate, user, items, entries, "", "40", "");
    }

    @Override
    public TSsmSalOrder creatPromoSalOrderOfBranch40SubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("40");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rModel);
        return createSsmSalOrderAndItmes(orderDate, user, items, entries, "free", "40", "");
    }

    @Override
    public TSsmSalOrder creatProDayPlanOfSelfBranchSubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("30");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch(rModel);
        return createSsmSalOrderAndItmes(orderDate, user, items, entries, "free", "30", "");
    }

    @Override
    public TSsmSalOrder creatPromDaliyDiscountAmtOfBranchSubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> yearItems = new ArrayList<TOrderDaliyPlanItem>();
        List<Map<String,String>> itemMap = tSsmSalOrderItemMapper.selectPromDaliyDiscountAmtOfBranch(rModel);
        if (itemMap != null && itemMap.size() > 0) {
            for (Map<String, String> map : itemMap) {
                String matnr = map.get("MATNR").toString();
                BigDecimal qty = new BigDecimal(String.valueOf(map.get("QTY")));
                BigDecimal price = new BigDecimal(String.valueOf(map.get("PRICE1")));
                BigDecimal discountAmt = new BigDecimal(String.valueOf(map.get("DISCOUNT_AMT")));
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                item.setAmt(discountAmt);
                yearItems.add(item);
            }
        }
        if(yearItems.size()>0) {
            String onlineCode = getYearCode(user.getSalesOrg());
            return createSsmSalOrderAndItmes(orderDate, user, yearItems, entries, "", "YE", onlineCode);
        }
        return null;
    }

    @Override
    public List<TSsmSalOrder> creatProDayPlanOfSelfOrgSubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfOrg(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String orgCode = map.get("orgCode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal remainAmt = (BigDecimal)map.get("remainAmt");
            if(orderMap.containsKey(orgCode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(orgCode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setRemainAmt(remainAmt);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setRemainAmt(remainAmt);
                itemList.add(item);
                orderMap.put(orgCode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if(orderMap.size()>0){
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet()){
                String orgCode =  entry.getKey();
                List<TOrderDaliyPlanItem> itemOrgs = entry.getValue();
                TSsmSalOrder salOrder = createSsmSalOrderAndItmes(orderDate,user,itemOrgs,entries, "","70",orgCode);
                if(salOrder != null){
                    salOrderList.add(salOrder);
                }
            }
        }
        return salOrderList;
    }

    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfBranch10SubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch10(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String onlinecode = map.get("onlinecode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal price = (BigDecimal)map.get("price");
            if(orderMap.containsKey(onlinecode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(onlinecode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
                orderMap.put(onlinecode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if(orderMap.size()>0){
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet()){
                String orgCode =  entry.getKey();
                List<TOrderDaliyPlanItem> itemOrgs = entry.getValue();
                TSsmSalOrder salOrder = createSsmSalOrderAndItmes(orderDate,user,itemOrgs,entries, "","10",orgCode);
                if(salOrder != null){
                    salOrderList.add(salOrder);
                }
            }
        }
        return salOrderList;
    }

    @Override
    public List<TSsmSalOrder> creatPromoSalOrderOfBranch10SubGi(Date orderDate, String branchNo, String salesOrg, Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch10(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String onlinecode = map.get("onlinecode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal price = (BigDecimal)map.get("price");
            if(orderMap.containsKey(onlinecode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(onlinecode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
                orderMap.put(onlinecode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if(orderMap.size()>0){
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet()){
                String orgCode =  entry.getKey();
                List<TOrderDaliyPlanItem> itemOrgs = entry.getValue();
                TSsmSalOrder salOrder = createSsmSalOrderAndItmes(orderDate,user,itemOrgs,entries, "free","10",orgCode);
                if(salOrder != null){
                    salOrderList.add(salOrder);
                }
            }
        }
        return salOrderList;
    }

    @Override
    public List<TSsmSalOrder> creatPromoSalOrderOfBranch10(Date orderDate, String branchNo, String salesOrg) {
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectProDayPlanOfSelfBranch10(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String onlinecode = map.get("onlinecode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            String promotion = map.get("promotion").toString();
            if(orderMap.containsKey(onlinecode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(onlinecode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setPromotionFlag(promotion);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPromotionFlag(promotion);
                itemList.add(item);
                orderMap.put(onlinecode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate,"branch","free",2,"10",orgCode,branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfBranch10(Date orderDate, String branchNo, String salesOrg) {
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch10(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String onlinecode = map.get("onlinecode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal price = (BigDecimal)map.get("price");
            if(orderMap.containsKey(onlinecode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(onlinecode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setConfirmMatnr(matnr);
                item.setMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                itemList.add(item);
                orderMap.put(onlinecode,itemList);
            }
        }
        Map<String,Object> amts = this.getBalancesByMatrn10(orderDate,branchNo,salesOrg);
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String orgCode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate,"branch","",2,"10",orgCode,branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    if(amts.size()>0){
                        String name = item.getMatnr().concat(order.getOnlineCode());
                        item.setAmt((BigDecimal) amts.get(name));
                    }
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    @Override
    public List<TSsmSalOrder> creatNoPromoSalOrderOfDealerBranch10(Date orderDate, String branchNo, String salesOrg) {
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> orgList = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch10(rModel);
        Map<String,List<TOrderDaliyPlanItem>> orderMap = new HashMap<String,List<TOrderDaliyPlanItem>>();
        for(Map<String,Object> map : orgList){
            String onlinecode = map.get("onlinecode").toString();
            String matnr = map.get("matnr").toString();
            BigDecimal qty = (BigDecimal)map.get("qty");
            BigDecimal price = (BigDecimal)map.get("price");
            BigDecimal amt = (BigDecimal)map.get("amt");
            if(orderMap.containsKey(onlinecode)) {
                List<TOrderDaliyPlanItem> itemList = orderMap.get(onlinecode);
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                item.setAmt(amt);
                itemList.add(item);
            }else{
                List<TOrderDaliyPlanItem> itemList = new ArrayList<TOrderDaliyPlanItem>();
                TOrderDaliyPlanItem item = new TOrderDaliyPlanItem();
                item.setQty(qty.intValue());
                item.setMatnr(matnr);
                item.setConfirmMatnr(matnr);
                item.setPrice(price);
                item.setAmt(amt);
                itemList.add(item);
                orderMap.put(onlinecode,itemList);
            }
        }
        List<TSsmSalOrder> salOrderList = new ArrayList<TSsmSalOrder>();
        if (orderMap != null && orderMap.size() > 0) {
            for(Map.Entry<String,List<TOrderDaliyPlanItem>> entry : orderMap.entrySet() ){
                String onlinecode = entry.getKey();
                List<TOrderDaliyPlanItem> itemList = entry.getValue();
                TSsmSalOrder order = createSaleOrder(orderDate,"branch","",2,"10",onlinecode,branchNo,salesOrg );
                for (int i = 0; i < itemList.size(); i++) {
                    TOrderDaliyPlanItem item = itemList.get(i);
                    createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "branch");
                }
                salOrderList.add(order);
            }
        }
        return salOrderList;
    }

    @Override
    public Map<String, Object> getBalancesByMatrn40(Date orderDate, String branchNo, String salesOrg) {
        Map<String,Object> maps = new HashMap<String,Object>();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch40(rModel);
        if(items != null && items.size()>0){
            items.forEach(e->{
                if(e.getBalanceAmt()!=null){
                    maps.put(e.getMatnr(),e.getBalanceAmt());
                }
            });
        }
        return maps;
    }

    @Override
    public Map<String, Object> getBalancesByMatrn10(Date orderDate, String branchNo, String salesOrg) {
        Map<String,Object> maps = new HashMap<String,Object>();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<Map<String,Object>> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch10(rModel);
        if(items != null && items.size()>0){
            items.forEach(e->{
                if(e.get("amt")!= null){
                    maps.put(e.get("matnr").toString().concat(e.get("onlinecode").toString()),e.get("amt"));
                }
            });
        }
        return maps;
    }

    @Override
    public Map<String, Object> getBalancesByMatrn(Date orderDate, String branchNo, String salesOrg) {
        return null;
    }

    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfBranch90(Date orderDate, String branchNo, String salesOrg,Map<String, Integer> entries) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setPreorderSource("40");
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfSelfBranch90(rModel);
        return createSsmSalOrderAndItmes(orderDate, user, items, entries, "free", "90", "");
    }

    @Override
    public TSsmSalOrder creatNoPromoSalOrderOfDealerBranch90(Date orderDate, String branchNo, String salesOrg) {
        TSysUser user = userSessionService.getCurrentUser();
        RequireOrderSearch rModel = new RequireOrderSearch();
        rModel.setFirstDay(DateUtil.getTomorrow(orderDate));
        rModel.setSecondDay(DateUtil.getDayAfterTomorrow(orderDate));
        rModel.setBranchNo(branchNo);
        rModel.setSalesOrg(salesOrg);
        rModel.setOrderDate(orderDate);
        List<TOrderDaliyPlanItem> items = tOrderDaliyPlanItemMapper.selectNoProDayPlanOfDealerBranch90(rModel);
        if (items != null && items.size() > 0) {
            TSsmSalOrder order = createSaleOrder(orderDate, "dealer", "free", 1, "90", "",branchNo ,salesOrg );
            for (int i = 0; i < items.size(); i++) {
                TOrderDaliyPlanItem item = items.get(i);
                createSaleOrderItem(item, i + 1, order.getOrderNo(), orderDate, "dealer");
            }
            return order;
        }
        return null;
    }
}
