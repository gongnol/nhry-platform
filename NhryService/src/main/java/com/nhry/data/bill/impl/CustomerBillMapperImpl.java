package com.nhry.data.bill.impl;

import com.nhry.common.datasource.DynamicSqlSessionTemplate;
import com.nhry.data.bill.dao.CustomerBillMapper;
import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.bill.domain.TMstRecvOffset;
import com.nhry.data.bill.domain.TMstRefund;
import com.nhry.model.bill.CollectOrderBillModel;
import com.nhry.model.bill.CollectOrderSearchModel;
import com.nhry.model.bill.CustBillQueryModel;

import java.util.Date;
import java.util.List;


/**
 * Created by gongjk on 2016/6/23.
 */
public class CustomerBillMapperImpl implements CustomerBillMapper {
    private DynamicSqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(DynamicSqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }



    @Override
    public TMstRecvBill getRecBillByOrderNo(String orderNo) {
        return sqlSessionTemplate.selectOne("getCustomerOrderByCode",orderNo);
    }

    @Override
    public int insertCustomerPayment(TMstRecvBill customerBill) {
        return sqlSessionTemplate.insert("customerPayment",customerBill);

    }

    @Override
    public int updateCustomerBillrPayment(TMstRecvBill customerBill) {
        return sqlSessionTemplate.update("updateCustomerBillrPayment",customerBill);
    }

    @Override
    public CollectOrderBillModel queryCollectByOrderNo(String orderCode,String paymentmethod) {
        CollectOrderSearchModel model = new CollectOrderSearchModel();
        model.setOrderNo(orderCode);
        model.setPaymentmehod(paymentmethod);
        if("20".equals(paymentmethod)){
            return sqlSessionTemplate.selectOne("queryCollectByBeforeOrderNo",model);
        }else{
            return  sqlSessionTemplate.selectOne("queryCollectByAfterOrderNo",model);
        }

    }

    @Override
    public TMstRecvBill getRecBillByReceoptNo(String receiptNo) {
        return sqlSessionTemplate.selectOne("getRecBillByReceoptNo",receiptNo);
    }

    @Override
    public int addOffset(TMstRecvOffset offset) {
        return sqlSessionTemplate.insert("addOffset",offset);
    }

    @Override
    public int addRefund(TMstRefund refund) {
        return sqlSessionTemplate.insert("addRefund",refund);
    }

    @Override
    public List<CollectOrderBillModel> selectHasItemsCollectByOrders(String paymentmethod, List<String> advancePayOrders) {
        CollectOrderSearchModel model = new CollectOrderSearchModel();
        model.setOrders(advancePayOrders);
        model.setPaymentmehod(paymentmethod);
        return sqlSessionTemplate.selectList("selectHasItemsCollectByOrders",model);
    }

    @Override
    public List<CollectOrderBillModel> selectHasItemsCollectByOrders2(CustBillQueryModel cModel) {

        return sqlSessionTemplate.selectList("selectHasItemsCollectByOrders2",cModel);
    }

    @Override
    public List<CollectOrderBillModel> selectNoItemsCollectByOrders(String paymentmethod, List<String> advancePayOrders) {
        CollectOrderSearchModel model = new CollectOrderSearchModel();
        model.setOrders(advancePayOrders);
        model.setPaymentmehod(paymentmethod);
        return sqlSessionTemplate.selectList("selectNoItemsCollectByOrders",model);
    }

    @Override
    public List<CollectOrderBillModel> selectNoItemsCollectByOrders2(CustBillQueryModel cModel) {

        return sqlSessionTemplate.selectList("selectNoItemsCollectByOrders2",cModel);
    }

    @Override
    public int delReceipt(String receiptNo) {
        return sqlSessionTemplate.delete("delReceipt",receiptNo);
    }
    /**
     * 本日交款-奶站、日期，统计送奶员本日交款总额
     * @param branchNo
     * @param date
     * @return
     */
    @Override
    public List<TMstRecvBill> getBranchEmpPayment(String branchNo, Date date) {
        TMstRecvBill key = new TMstRecvBill();
        key.setBranchNo(branchNo);
        key.setReceiptDate(date);
        return sqlSessionTemplate.selectList("getBranchEmpPayment",key);
    }

    /**
     * 本日交款-送奶员纬度查询
     * @param branchNo
     * @param date
     * @param empNo
     * @return
     */
    @Override
    public TMstRecvBill getBranchEmpPaymentByEmpNo(String branchNo, Date date, String empNo) {
        TMstRecvBill key = new TMstRecvBill();
        key.setBranchNo(branchNo);
        key.setReceiptDate(date);
        key.setEmpNo(empNo);
        return sqlSessionTemplate.selectOne("getBranchEmpPaymentByEmpNo",key);
    }
}
