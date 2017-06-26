package com.nhry.service.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmRedateByTrade;
import com.nhry.data.order.domain.TPreOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * 返利处理业务类
 * Created by cbz on 12/27/2016.
 */
public interface RedateByTradeService {
    /**
     * 订单完结时，记录奶站促销的返利金额
     * @param orderNo
     * @param branchNo
     * @param salesOrg
     * @param promNo
     * @param matnr
     * @param redate
     * @param dealerNo
     * @return
     */
    void insert(String orderNo, String branchNo, String salesOrg, String promNo, String matnr, BigDecimal redate, String dealerNo);

    /**
     * 查询未发送的数据，一次10条
     * @return
     */
    List<TSsmRedateByTrade> findNoSendRedateByTrade();

    /**
     * 更新返利的处理状态
     * @param ssmRedateByTrade
     */
    void update(TSsmRedateByTrade ssmRedateByTrade);

    /**
     * 保存完结订单的促销结果
     * @param order
     */
    void saveRedate(TPreOrder order);
}
