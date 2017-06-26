package com.nhry.service.milktrans.impl;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.basic.dao.TMdBranchExMapper;
import com.nhry.data.basic.domain.TMdBranchEx;
import com.nhry.data.config.domain.NHSysCodeItem;
import com.nhry.data.milktrans.dao.TSsmRedateByTradeMapper;
import com.nhry.data.milktrans.domain.TSsmRedateByTrade;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.promotion.dao.PromotionMapper;
import com.nhry.data.promotion.domain.Promotion;
import com.nhry.service.config.dao.DictionaryService;
import com.nhry.service.milktrans.dao.RedateByTradeService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by cbz on 12/27/2016.
 */
public class RedateByTradeServiceImpl implements RedateByTradeService {
    private static Logger logger = Logger.getLogger(RedateByTradeServiceImpl.class);
    private static String TYPE_CODE = "1017";
    private static String ITEM_CODE = "1";

    private TSsmRedateByTradeMapper tSsmRedateByTradeMapper;
    private TPlanOrderItemMapper tPlanOrderItemMapper;
    private PromotionMapper promotionMapper;
    private DictionaryService dictionaryService;
    private TaskExecutor taskExecutor;
    private TMdBranchExMapper branchExMapper;

    @Override
    public void insert(String orderNo, String branchNo, String salesOrg, String promNo, String matnr, BigDecimal redate, String dealerNo) {
        TMdBranchEx branchEx = branchExMapper.getBranchEx(branchNo);
        TSsmRedateByTrade ssmRedateByTrade = new TSsmRedateByTrade();
        ssmRedateByTrade.setOrderNo(orderNo);
        ssmRedateByTrade.setBranchNo(branchNo);
        ssmRedateByTrade.setSalesOrg(salesOrg);
        ssmRedateByTrade.setPromNo(promNo);
        ssmRedateByTrade.setCreateDate(new Date());
        ssmRedateByTrade.setMatnr(matnr);
        ssmRedateByTrade.setDhNo("");
        ssmRedateByTrade.setCrmNo("");
        ssmRedateByTrade.setRedate(redate);
        ssmRedateByTrade.setOrderDate(new Date());
        ssmRedateByTrade.setDhNo(orderNo);
        ssmRedateByTrade.setWerks(branchEx.getSupplPlnt());
        ssmRedateByTrade.setLgort(branchEx.getReslo());
        ssmRedateByTrade.setDealerNo(StringUtils.isEmpty(dealerNo) ? branchNo:dealerNo);
        tSsmRedateByTradeMapper.insertRedateByTrade(ssmRedateByTrade);
    }

    @Override
    public List<TSsmRedateByTrade> findNoSendRedateByTrade() {
        return tSsmRedateByTradeMapper.findNoSendRedateByTrade();
    }

    @Override
    public void update(TSsmRedateByTrade ssmRedateByTrade) {
        tSsmRedateByTradeMapper.updateRedateByTrade(ssmRedateByTrade);
    }

    @Override
    public void saveRedate(TPreOrder order) {
        taskExecutor.execute(new Thread() {
            @Override
            public void run() {
                this.setName(order.getOrderNo());
                if(StringUtils.isNotEmpty(order.getPromotion())) {
                    NHSysCodeItem codeItem = new NHSysCodeItem();
                    codeItem.setTypeCode(TYPE_CODE);
                    codeItem.setItemCode(ITEM_CODE);
                    codeItem = dictionaryService.findCodeItenByCode(codeItem);
                    String promSubTypes = codeItem.getAttr1();
                    Promotion promotion = promotionMapper.selectPromotion(order.getPromotion());
                    String promSubType = promotion.getPromSubType();
                    if(promSubTypes.contains(promSubType)) {
                        List<TPlanOrderItem> itemList = tPlanOrderItemMapper.selectByOrderCode(order.getOrderNo());
                        String matnr = "";
                        for (TPlanOrderItem item : itemList) {
                            matnr = item.getMatnr();
                        }
                        if (StringUtils.isEmpty(matnr)) {
                            throw new ServiceException(MessageCode.LOGIC_ERROR, "未定位到订单行项目物料！");
                        }
                        insert(order.getOrderNo(), order.getBranchNo(), order.getSalesOrg(), order.getPromotion(), matnr, order.getDiscountAmt(), order.getDealerNo());
                        logger.info("返利数据创建成功！"+order.getOrderNo());
                    }
                }
            }
        });
    }

    public void setPromotionMapper(PromotionMapper promotionMapper) {
        this.promotionMapper = promotionMapper;
    }

    public void settSsmRedateByTradeMapper(TSsmRedateByTradeMapper tSsmRedateByTradeMapper) {
        this.tSsmRedateByTradeMapper = tSsmRedateByTradeMapper;
    }

    public void settPlanOrderItemMapper(TPlanOrderItemMapper tPlanOrderItemMapper) {
        this.tPlanOrderItemMapper = tPlanOrderItemMapper;
    }

    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void setBranchExMapper(TMdBranchExMapper branchExMapper) {
        this.branchExMapper = branchExMapper;
    }
}
