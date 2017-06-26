package com.nhry.service.milktrans.impl;

import com.nhry.common.exception.ServiceException;
import com.nhry.data.milktrans.dao.TSsmSalOrderItemMapper;
import com.nhry.data.milktrans.dao.TSsmSalOrderMapper;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.model.order.OrderPointModel;
import com.nhry.service.milktrans.dao.OrderPointService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cbz on 8/17/2016.
 */
public class OrderPointServiceImpl implements OrderPointService {
    private static final Logger logger = Logger.getLogger(OrderPointServiceImpl.class);

    private TPreOrderMapper preOrderMapper;

    private TPlanOrderItemMapper planOrderItemMapper;

    public void setPreOrderMapper(TPreOrderMapper preOrderMapper) {
        this.preOrderMapper = preOrderMapper;
    }

    public void setPlanOrderItemMapper(TPlanOrderItemMapper planOrderItemMapper) {
        this.planOrderItemMapper = planOrderItemMapper;
    }

    @Override
    public int uptYfrechAndYGrowthByOrderNoAndItemNo(List<OrderPointModel> models) {
        logger.info("订单明细积分更新开始");
        try {
            Map<String, String> map = new HashMap<String, String>();
            for (OrderPointModel model : models) {
                map.put(model.getOrderNo(), model.getItemNo());
                model.setItemNo(model.getOrderNo().concat(model.getItemNo()));
                planOrderItemMapper.uptYfrechAndYGrowthByOrderNoAndItemNo(model);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                OrderPointModel orderPoint = planOrderItemMapper.getSumYfrechAndYGrowByOrderNo(entry.getKey());
                preOrderMapper.uptYfrechAndYGrowthByOrderNo(orderPoint);
            }
        }catch (Exception e){
            logger.error("订单明细积分更新失败！"+e.getMessage());
            throw new ServiceException("订单明细积分更新失败！");
        }
        logger.info("订单明细积分更新结束");
        return 1;
    }
}
