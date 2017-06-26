package com.nhry.service.bill.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.model.bill.*;
import com.nhry.model.order.OrderSearchModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by gongjk on 2016/6/23.
 */
public interface CustomerBillService {
   public PageInfo searchCustomerOrder(CustBillQueryModel cModel);

   public PageInfo searchCustomerOrderForRecBill(CustBillQueryModel cModel);

   public TMstRecvBill getRecBillByOrderNo(String orderNo);

   public int  customerPayment(CustomerPayMentModel cModel);

   public CustomerBillOrder getCustomerOrderDetailByCode(String orderNo);

   public TMstRecvBill createRecBillByOrderNo(String orderNo);

   List<String> searchCustomerOrderForExp(CustBillQueryModel cModel);

   BatChCollectResultModel custBatchCollect(CustBatchBillQueryModel cModel);

   CollectOrderBillModel queryCollectByOrderNo(String orderCode);

   BatChCollectResultModel custBatchCollectBySelect(OrderSearchModel oModel);

   int delRecBills(OrderSearchModel oModel);

   int customerOffset(String receiptNo);

   BigDecimal  calculateTotalBeforBatch(CustBatchBillQueryModel cModel);

   int custRefund(CustomerRefundModel cModel);

   List<CollectOrderBillModel> BatchPrintForExp(CustBillQueryModel cModel);

   int delReceipt(String receiptNo);

   int selectOrdersNoBillCount();

   BatChCollectForExpModel BatchPrintForExp2(CustBillQueryModel cModel);

   int setBranchRemark(String branchRemark);

   TMdBranch getCurrentBranch();
}
