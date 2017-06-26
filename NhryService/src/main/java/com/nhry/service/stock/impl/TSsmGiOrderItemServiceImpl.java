package com.nhry.service.stock.impl;

import com.nhry.common.exception.ServiceException;
import com.nhry.data.stock.dao.TSsmGiOrderItemMapper;
import com.nhry.data.stock.dao.TSsmStockMapper;
import com.nhry.data.stock.domain.*;
import com.nhry.service.stock.dao.TSsmGiOrderItemService;
import com.nhry.service.stock.dao.TSsmGiOrderService;

import java.util.List;

/**
 * Created by cbz on 7/25/2016.
 */
public class TSsmGiOrderItemServiceImpl implements TSsmGiOrderItemService {

    private TSsmGiOrderItemMapper giOrderItemMapper;

    public void setGiOrderItemMapper(TSsmGiOrderItemMapper giOrderItemMapper) {
        this.giOrderItemMapper = giOrderItemMapper;
    }

    private TSsmGiOrderService giOrderService;

    private TSsmStockMapper ssmStockMapper;

    public void setGiOrderService(TSsmGiOrderService giOrderService) {
        this.giOrderService = giOrderService;
    }

    public void setSsmStockMapper(TSsmStockMapper ssmStockMapper) {
        this.ssmStockMapper = ssmStockMapper;
    }

    @Override
    public int deleteGiOrderItemByNo(TSsmGiOrderItemKey key) {
        return giOrderItemMapper.deleteGiOrderItemByNo(key);
    }

    @Override
    public int insertGiOrderItem(TSsmGiOrderItem record) {
        return giOrderItemMapper.insertGiOrderItem(record);
    }

    @Override
    public int insertGiOrderItemSelective(TSsmGiOrderItem record) {
        return giOrderItemMapper.insertGiOrderItem(record);
    }

    @Override
    public TSsmGiOrderItem selectGiOrderItemByNo(TSsmGiOrderItemKey key) {
        return giOrderItemMapper.selectGiOrderItemByNo(key);
    }

    @Override
    public int updateGiOrderItemSelective(TSsmGiOrderItem record) {
        return giOrderItemMapper.updateGiOrderItemSelective(record);
    }

    @Override
    public int updateGiOrderItem(TSsmGiOrderItem record) {
        return giOrderItemMapper.updateGiOrderItem(record);
    }

    @Override
    public List<TSsmGiOrderItem> findGiOrderItem(TSsmGiOrderItemKey key) {
        return giOrderItemMapper.findGiOrderItem(key);
    }

    @Override
    public int updateGiOrderItems(List<TSsmGiOrderItem> giOrderItems, String salesOrg) {
        if (giOrderItems != null && giOrderItems.size() > 0) {
            TSsmGiOrder giOrder = giOrderService.selectGiOrderByNo(giOrderItems.get(0).getOrderNo());
            if ("30".equals(giOrder.getStatus())) {
                throw new ServiceException("交货单已经确认,不能重复确认！");
            }
            for (TSsmGiOrderItem item : giOrderItems) {
                TSsmGiOrderItemKey key = new TSsmGiOrderItemKey();
                key.setOrderNo(item.getOrderNo());
                key.setItemNo(item.getItemNo());
                key.setOrderDate(item.getOrderDate());
                TSsmGiOrderItem orderItem = selectGiOrderItemByNo(key);
                orderItem.setConfirmQty(item.getConfirmQty());
                orderItem.setRemark(item.getRemark());
                giOrderItemMapper.updateGiOrderItem(orderItem);
                TSsmStockKey key1 = new TSsmStockKey();
                key1.setBranchNo(giOrder.getBranchNo());
                key1.setMatnr(item.getMatnr());
                TSsmStock stock = ssmStockMapper.getStock(key1);
                if (stock == null) {
                    stock = new TSsmStock();
                    stock.setBranchNo(giOrder.getBranchNo());
                    stock.setMatnr(item.getMatnr());
                    stock.setQty(item.getConfirmQty());
                    stock.setSalesOrg(salesOrg);
                    ssmStockMapper.insertStock(stock);
                } else {
                    stock.setQty(item.getConfirmQty().add(stock.getQty()));
                    stock.setSalesOrg(salesOrg);
                    ssmStockMapper.updateStock(stock);
                }
            }
            giOrder.setStatus("30");
            giOrderService.updateGiOrder(giOrder);
        }
        return 1;
    }
}
