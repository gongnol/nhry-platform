package com.nhry.data.bill.dao;

import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.bill.domain.TMstRecvOffset;
import com.nhry.data.bill.domain.TMstRefund;
import com.nhry.model.bill.CollectOrderBillModel;
import com.nhry.model.bill.CustBillQueryModel;

import java.util.Date;
import java.util.List;

/**
 * Created by gongjk on 2016/6/23.
 */
public interface CustomerBillMapper {
    /**
     * 根据订单号 查询收款信息（不包含冲销过的收款单）
     * @param  orderNo
     * @return
     */
    public TMstRecvBill getRecBillByOrderNo(String orderNo);

    public int insertCustomerPayment(TMstRecvBill customerBill);

    public int updateCustomerBillrPayment(TMstRecvBill customerBill);

    CollectOrderBillModel queryCollectByOrderNo(String orderCode,String paymentmethod);

    TMstRecvBill getRecBillByReceoptNo(String receiptNo);

    int addOffset(TMstRecvOffset offset);

    int  addRefund(TMstRefund refund);

    List<CollectOrderBillModel> selectHasItemsCollectByOrders(String paymentmethod, List<String> advancePayOrders);
    List<CollectOrderBillModel> selectHasItemsCollectByOrders2(CustBillQueryModel cModel);

    List<CollectOrderBillModel> selectNoItemsCollectByOrders(String paymentmethod, List<String> advancePayOrders);
    List<CollectOrderBillModel> selectNoItemsCollectByOrders2(CustBillQueryModel cModel);

    int delReceipt(String receiptNo);

    /**
     * 本日交款-奶站、日期，统计送奶员本日交款总额
     * @param branchNo
     * @param date
     * @return
     */
    List<TMstRecvBill> getBranchEmpPayment(String branchNo,Date date);

    /**
     * 本日交款-送奶员纬度查询
     * @param branchNo
     * @param date
     * @param empNo
     * @return
     */
    TMstRecvBill getBranchEmpPaymentByEmpNo(String branchNo,Date date,String empNo);


}
