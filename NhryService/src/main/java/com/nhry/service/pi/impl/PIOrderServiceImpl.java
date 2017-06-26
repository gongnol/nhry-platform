package com.nhry.service.pi.impl;

import com.nhry.data.basic.dao.TMdAddressMapper;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.domain.TMdAddress;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.service.pi.dao.PIOrderService;
import com.nhry.service.pi.pojo.Order;
import com.nhry.service.pi.pojo.PIReturnMessage;
import org.apache.commons.lang.StringUtils;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by cbz on 7/20/2016.
 */
@WebService
public class PIOrderServiceImpl implements PIOrderService {
    TPreOrderMapper orderMapper;
    TOrderDaliyPlanItemMapper orderDaliyPlanItemMapper;
    TPlanOrderItemMapper planOrderItemMapper;
    TMdBranchMapper branchMapper;
    TMdAddressMapper addressMapper;

    public void setOrderMapper(TPreOrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void setOrderDaliyPlanItemMapper(TOrderDaliyPlanItemMapper orderDaliyPlanItemMapper) {
        this.orderDaliyPlanItemMapper = orderDaliyPlanItemMapper;
    }

    public void setPlanOrderItemMapper(TPlanOrderItemMapper planOrderItemMapper) {
        this.planOrderItemMapper = planOrderItemMapper;
    }

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setAddressMapper(TMdAddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public PIReturnMessage findOrder(String ORDER_NO) {
        PIReturnMessage message = new PIReturnMessage();
        Order result = new Order();
        if(StringUtils.isEmpty(ORDER_NO)){
            message.setSuccess(false);
            message.setMessage("订单编号不能为空！");
        }
        TPreOrder order1 = orderMapper.selectByPrimaryKey(ORDER_NO);
        if(order1 == null){
            message.setSuccess(false);
            message.setMessage("订单不存在！");
        }else{
            List<TPlanOrderItem> planOrderItems = planOrderItemMapper.selectByOrderCode(ORDER_NO);
            TMdBranch branch = branchMapper.getBranchByNo(order1.getBranchNo());
            List<TOrderDaliyPlanItem> orderDaliyPlanItems = orderDaliyPlanItemMapper.selectDaliyPlansByOrderNo(ORDER_NO);
            TMdAddress address = addressMapper.findAddressDetailById(order1.getAdressNo());
            StringBuilder addressTxt = new StringBuilder();
            if(StringUtils.isNotEmpty(address.getProvince())){
                addressTxt.append(address.getProvince());
            }
            if(StringUtils.isNotEmpty(address.getCity())){
                addressTxt.append(address.getCity());
            }
            if(StringUtils.isNotEmpty(address.getCounty())){
                addressTxt.append(address.getCounty());
            }
            if(StringUtils.isNotEmpty(address.getResidentialArea())){
                addressTxt.append(address.getResidentialArea());
            }
            if(StringUtils.isNotEmpty(address.getAddressTxt())){
                addressTxt.append(address.getAddressTxt());
            }
            order1.setAddressTxt(addressTxt.toString());
            order1.setBranchMp(branch.getMp());
            order1.setBranchEmpName(branch.getContact());
            order1.setEmpNo(branch.getEmpNo());
            result.setOrder(order1);
            result.setDaliyPlanItems(orderDaliyPlanItems);
            result.setPlanOrderItems(planOrderItems);
            message.setData(result);
        }
        return message;
    }
}
