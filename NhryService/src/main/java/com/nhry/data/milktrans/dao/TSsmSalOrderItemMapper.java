package com.nhry.data.milktrans.dao;

import com.nhry.data.milktrans.domain.TSsmSalOrderItems;
import com.nhry.model.milktrans.RequireOrderSearch;
import com.nhry.model.order.OrderPointModel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.List;

/**
 * Created by gongjk on 2016/7/16.
 */
public interface TSsmSalOrderItemMapper {
    int addSalOrderItem(TSsmSalOrderItems salOrderItems);
    List<TSsmSalOrderItems> selectItemsBySalOrderNo(Map map);
    List<Map<String,String>> findItemsForPI(String orderNo);
    List<Map<String,String>> findDealerItemsForPI(String orderNo);
    int delSalOrderItemsByOrderNo(String orderNo);
    int uptYfrechAndYGrowthByOrderNoAndItemNo(OrderPointModel model);

    OrderPointModel getSumYfrechAndYGrowByOrderNo(String orderNo);

    /**
     * 经销商奶站年卡折扣金额
     * @param rModel
     * @return
     */
    List<Map<String,String>> selectPromDaliyDiscountAmtOfDearler(RequireOrderSearch rModel);

    /**
     * 自营奶站年卡折扣金额
     * @param rModel
     * @return
     */
    List<Map<String,String>> selectPromDaliyDiscountAmtOfBranch(RequireOrderSearch rModel);

    /**
     * 销售订单行项目更新折扣率
     * @param item
     * @return
     */
    int updateDiscountAmt(TSsmSalOrderItems item);

    TSsmSalOrderItems getSalOrderItemByKey(TSsmSalOrderItems items);

    /**
     * 更新数量
     * @param items
     * @return
     */
    int updateSalOrderItem(TSsmSalOrderItems items);

    /**
     * 统计销售订单的数量
     * @param rModel
     * @return
     */
    BigDecimal sumSalOrderByDate(RequireOrderSearch rModel);

}
