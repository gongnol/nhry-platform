package com.nhry.service.stock.impl;

import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.stock.dao.TSsmGiOrderMapper;
import com.nhry.data.stock.domain.TSsmGiOrder;
import com.nhry.model.stock.GiOrderModel;
import com.nhry.service.stock.dao.TSsmGiOrderService;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by cbz on 7/25/2016.
 */
public class TSsmGiOrderServiceImpl implements TSsmGiOrderService {
    private TSsmGiOrderMapper giOrderMapper;

    public void setGiOrderMapper(TSsmGiOrderMapper giOrderMapper) {
        this.giOrderMapper = giOrderMapper;
    }

    @Override
    public List<TSsmGiOrder> findGiOrder(GiOrderModel model) {
        if(StringUtils.isEmpty(model.getBranchNo()) || model.getOrderDate() == null){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"奶站编号或者订单日期不能为空");
        }
        return giOrderMapper.findGiOrder(model);
    }

    @Override
    public int deleteGiOrderByNo(String orderNo) {
        return giOrderMapper.deleteGiOrderByNo(orderNo);
    }

    @Override
    public int insertGiOrder(TSsmGiOrder record) {
        return giOrderMapper.insertGiOrder(record);
    }

    @Override
    public int insertGiOrderSelective(TSsmGiOrder record) {
        return giOrderMapper.insertGiOrderSelective(record);
    }

    @Override
    public TSsmGiOrder selectGiOrderByNo(String orderNo) {
        return giOrderMapper.selectGiOrderByNo(orderNo);
    }

    @Override
    public int updateGiOrderSelective(TSsmGiOrder record) {
        return giOrderMapper.updateGiOrderSelective(record);
    }

    @Override
    public int updateGiOrder(TSsmGiOrder record) {
        return giOrderMapper.updateGiOrder(record);
    }
}
