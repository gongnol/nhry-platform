package com.nhry.service.bill.impl;

import com.github.pagehelper.PageInfo;
import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.dao.TSysUserRoleMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.basic.dao.TMdBranchMapper;
import com.nhry.data.basic.dao.TMdOperationLogMapper;
import com.nhry.data.basic.domain.LogType;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.basic.domain.TVipAcct;
import com.nhry.data.bill.dao.CustomerBillMapper;
import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.bill.domain.TMstRecvOffset;
import com.nhry.data.bill.domain.TMstRefund;
import com.nhry.data.milk.dao.TDispOrderItemMapper;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.data.order.dao.TOrderDaliyPlanItemMapper;
import com.nhry.data.order.dao.TPlanOrderItemMapper;
import com.nhry.data.order.dao.TPreOrderMapper;
import com.nhry.data.order.domain.TOrderDaliyPlanItem;
import com.nhry.data.order.domain.TPlanOrderItem;
import com.nhry.data.order.domain.TPreOrder;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.model.bill.*;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.service.basic.dao.TVipCustInfoService;
import com.nhry.service.bill.dao.CustomerBillService;
import com.nhry.service.external.dao.EcService;
import com.nhry.service.order.dao.OrderService;
import com.nhry.service.order.dao.PromotionService;
import com.nhry.service.pi.dao.PIVipInfoDataService;
import com.nhry.service.pi.dao.PIVipPointCreateBatService;
import com.nhry.service.pi.pojo.MemberActivities;
import com.nhry.utils.OperationLogUtil;
import com.nhry.utils.PrimaryKeyUtils;
import com.nhry.utils.YearLastMonthUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gongjk on 2016/6/23.
 */
public class CustomerBillServiceImpl implements CustomerBillService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TMdOperationLogMapper operationLogMapper;
    private CustomerBillMapper customerBillMapper;
    private TPreOrderMapper tPreOrderMapper;
    private TPlanOrderItemMapper tPlanOrderItemMapper;
    private UserSessionService userSessionService;
    private OrderService orderService;
    private PromotionService promotionService;
    private TVipCustInfoService tVipCustInfoService;
    private TSysUserRoleMapper urMapper;
 	 private TaskExecutor taskExecutor;
 	 private EcService messLogService;
    private PIVipInfoDataService piVipInfoDataService;
    private TDispOrderItemMapper tDispOrderItemMapper;
    private TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper;
    private PIVipPointCreateBatService piVipPointCreateBatService;
    private TMdBranchMapper branchMapper;

    public void setBranchMapper(TMdBranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    public void setPiVipPointCreateBatService(PIVipPointCreateBatService piVipPointCreateBatService) {
        this.piVipPointCreateBatService = piVipPointCreateBatService;
    }

    public void setOperationLogMapper(TMdOperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }
    public void settOrderDaliyPlanItemMapper(TOrderDaliyPlanItemMapper tOrderDaliyPlanItemMapper) {
        this.tOrderDaliyPlanItemMapper = tOrderDaliyPlanItemMapper;
    }

    public void settDispOrderItemMapper(TDispOrderItemMapper tDispOrderItemMapper) {
        this.tDispOrderItemMapper = tDispOrderItemMapper;
    }

    public void setPiVipInfoDataService(PIVipInfoDataService piVipInfoDataService) {
        this.piVipInfoDataService = piVipInfoDataService;
    }

    public void setMessLogService(EcService messLogService)
 	{
 		this.messLogService = messLogService;
 	}

 	public void setTaskExecutor(TaskExecutor taskExecutor)
 	{
 		this.taskExecutor = taskExecutor;
 	}

    @Override
    public PageInfo searchCustomerOrder(CustBillQueryModel cModel) {
        final long startTime = System.currentTimeMillis();
        TSysUser user = userSessionService.getCurrentUser();
        List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
        cModel.setSalesOrg(user.getSalesOrg());
        cModel.setBranchNo(user.getBranchNo());
        cModel.setDealerNo(user.getDealerId());

        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        System.out.println("查询订单收款列表  消耗时间："+(System.currentTimeMillis()-startTime)+"毫秒");
        return tPreOrderMapper.searchCustomerOrder(cModel);
    }

    @Override
    public PageInfo searchCustomerOrderForRecBill(CustBillQueryModel cModel) {
        final long startTime = System.currentTimeMillis();
        TSysUser user = userSessionService.getCurrentUser();
        List<String> rids = urMapper.getUserRidsByLoginName(user.getLoginName());
        cModel.setSalesOrg(user.getSalesOrg());
        cModel.setBranchNo(user.getBranchNo());
        cModel.setDealerNo(user.getDealerId());

        if(StringUtils.isEmpty(cModel.getPageNum()) || StringUtils.isEmpty(cModel.getPageSize())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"pageNum和pageSize不能为空！");
        }
        System.out.println("查询订单收款列表  消耗时间："+(System.currentTimeMillis()-startTime)+"毫秒");
        return tPreOrderMapper.searchCustomerOrderForRecBill(cModel);
    }



    @Override
    public TMstRecvBill getRecBillByOrderNo(String orderNo) {
        TMstRecvBill result = customerBillMapper.getRecBillByOrderNo(orderNo);

        return result;
    }

    @Override
    public int customerPayment(CustomerPayMentModel cModel) {
            String errorContent ="";
            int updateBill = 0;
            int updateOrderStatus = 0;
            String orderNo = cModel.getOrderNo();

            TPreOrder order = tPreOrderMapper.selectByPrimaryKey(orderNo);
            if(order == null){
                errorContent = orderNo+"该订单不存在！";
                throw new ServiceException(MessageCode.LOGIC_ERROR,errorContent);
            }

            TMstRecvBill customerBill = customerBillMapper.getRecBillByOrderNo(orderNo);
            if(customerBill!= null && "20".equals(customerBill.getStatus())){
                errorContent = orderNo+"该订单已收款";
                throw new ServiceException(MessageCode.LOGIC_ERROR,errorContent);
            }
            if(customerBill==null){
                throw new ServiceException(MessageCode.LOGIC_ERROR,"还没有产生收款单，不能直接收款");
            }

            TSysUser user = userSessionService.getCurrentUser();
            Date date = new Date();


                //录入收款信息
                BigDecimal accAmt = customerBill.getAccAmt();    //已收的订户余额
                BigDecimal amt = new BigDecimal(cModel.getAmt());//收款金额
                //判断是否是年卡订单
                boolean yearCardOrder=false;

                if(StringUtils.isNotBlank(order.getPromotion()) && StringUtils.isNotBlank(order.getPromItemNo())){
                    TPromotion prom = promotionService.selectPromotionByPromNoAndItemNo(order.getPromotion(),order.getPromItemNo());
                        if(prom!=null){
                            if("Z017".equals(prom.getPromSubType())) yearCardOrder = true;
                        }
                }
                 int com;
                if (order.getDiscountAmt() != null) {
                    if(yearCardOrder){
                        throw new ServiceException("该订单为年卡订单，不需要收款");
                    }else{
                        //整单满减
                         com = accAmt.add(amt).compareTo(order.getInitAmt().subtract(order.getDiscountAmt()));
                    }
                }else{
                     com = accAmt.add(amt).compareTo(order.getInitAmt());
                }
               //收的余额 与 订单金额(减去优惠金额)比较
                //如果收款金额 加上已收的余额 大于订单金额（减去优惠金额） (将多余的钱退回余额)
                if(com== 1){
                    //记录收款金额
                    customerBill.setAmt(new BigDecimal(cModel.getAmt()));
                    //并将多出来的金额 放入订户余额中
                    TVipAcct eac = tVipCustInfoService.findVipAcctByCustNo(order.getMilkmemberNo());
                    TVipAcct ac = new TVipAcct();
                    BigDecimal acLeftAmt = new BigDecimal("0.00");
                    if(eac!=null){
                        acLeftAmt = eac.getAcctAmt();
                    }
                    ac.setVipCustNo(order.getMilkmemberNo());
                    ac.setAcctAmt(accAmt.add(amt).subtract(order.getInitAmt()));
                    tVipCustInfoService.addVipAcct(ac);
                }else if(com == 0){
                    //如果收款金额 加上已收的余额 等于 订单金额
                    customerBill.setAmt(new BigDecimal(cModel.getAmt()));
                }else{
                    //如果收款金额 加上已收的余额 小于 订单金额
                    throw new ServiceException(MessageCode.LOGIC_ERROR,orderNo+"  输入的金额和已支付的账户余额不足以支付此订单!");
                }
                //备注
                if(StringUtils.isNoneBlank(cModel.getRemark())){
                    customerBill.setRemark(cModel.getRemark());
                }
                customerBill.setPaymentType(cModel.getPaymentType());
                customerBill.setPaymentYearMonth(YearLastMonthUtil.getYearThisMonth());
                customerBill.setRecvEmp(cModel.getEmpNo());
                customerBill.setReceiptDate(date);
                customerBill.setLastModified(date);
                customerBill.setLastModifiedBy(user.getLoginName());
                customerBill.setLastModifiedByTxt(user.getDisplayName());
                customerBill.setStatus("20");
                updateBill =  customerBillMapper.updateCustomerBillrPayment(customerBill);

                 //更新订单状态为已收款
                //将收款方式记录在订单中
                order.setPayMethod(customerBill.getPaymentType());
                order.setPayDate(new Date());
                order.setPaymentStat("20");
                updateOrderStatus = tPreOrderMapper.updateOrderStatus(order);

                //预付款的,更新订单行起始日期
                if("20".equals(order.getPaymentmethod()) && cModel.getEntries()!=null && cModel.getEntries().size() > 0){
               	 orderService.updateOrderAndEntriesDispStartDate(order.getOrderNo(),cModel.getEntries());
                }
                //预付款的，付款后生成日计划
                if("20".equals(order.getPaymentmethod()) && !"20".equals(order.getMilkboxStat()) ){
                    //收过款 产生过日订单后来冲销重新收款不再生成日订单
                    List<TOrderDaliyPlanItem> oldlist = orderService.selectDaliyPlansByOrderNo(orderNo);
                    if(oldlist==null || oldlist.size()<=0){
                        OrderCreateModel omodel = orderService.selectOrderByCode(orderNo);
                        List<TOrderDaliyPlanItem> list = orderService.createDaliyPlan(omodel.getOrder(),omodel.getEntries());
                        promotionService.createDaliyPlanByPromotion(omodel.getOrder(),omodel.getEntries(),list);
                    }

                }

              /*  if("10".equals(order.getPaymentmethod()) && !"20".equals(order.getMilkboxStat())){
                    tPreOrderMapper.updateOrderToFinish(orderNo);
                }
*/
        //会员积分
        if("Y".equals(order.getIsIntegration())){
            taskExecutor.execute(new Thread(){
                @Override
                public void run() {
                    super.run();
                    this.setName("updateVip");
                    Map<String,String> planOrderMap = new HashMap<String,String>();
                    planOrderMap.put("salesOrg",user.getSalesOrg());
                    planOrderMap.put("orderNo",orderNo);
                    List<MemberActivities> items;
                    if("20".equals(order.getPaymentmethod())){
                        items   = tPlanOrderItemMapper.selectBeforePayActivitiesByOrderNo(planOrderMap);
                    }else{
                        items  = tPlanOrderItemMapper.selectAfterPayActivitiesByOrderNo(planOrderMap);
                    }
                    if(items.size()>0){
                        BigDecimal totalprice = new BigDecimal(0);
                        for (MemberActivities item : items){
                            item.setProcess("X");
                            Calendar calendar = new GregorianCalendar();
                            calendar.setTime(date);
                            Date firstDay = calendar.getTime();
                            item.setActivitydate(firstDay);
                            if(StringUtils.isNotBlank(item.getCardid())){
                                item.setCardid("");
                            }
//                            piVipInfoDataService.createMemberActivities(item);
                        }
                        piVipPointCreateBatService.createMemberActivitiesBat(items);
                    }

                }
            });
        }

        //计算订单结算价
        if("10".equals(order.getPaymentmethod())){
            BigDecimal factAmt = tPreOrderMapper.calculateOrderFactoryAmt(orderNo);
            int  updateFactAmt = tPreOrderMapper.updateOrderFacAmt(factAmt  == null ? new BigDecimal(0) : factAmt,orderNo);
        }else{
            //List<>
        }


        //发送EC,更新订单状态
        TPreOrder sendOrder = new TPreOrder();
        sendOrder.setOrderNo(order.getOrderNo());
        sendOrder.setPreorderStat("101");
        sendOrder.setPaymentmethod(cModel.getPaymentType());
        taskExecutor.execute(new Thread(){
            @Override
            public void run() {
                super.run();
                this.setName("updateOrderStatus");
                messLogService.sendOrderStatus(sendOrder);

                if("20".equals(order.getPaymentmethod()) && !"20".equals(order.getMilkboxStat())){
                    sendOrder.setEmpNo(order.getEmpNo());
                    sendOrder.setPreorderStat("200");
                    messLogService.sendOrderStatus(sendOrder);
                }

            }
        });

        //将订单收款日志写入 t_md_operation_log 表。     by  liuyin   编号   类型   名称  送奶员  配送地址 原值  新值 产品 日期
        //   start
           OperationLogUtil.saveHistoryOperation(order.getOrderNo(), LogType.ORDER, "收款",customerBill.getRecvEmpName(),null,
                   ""+order.getInitAmt(),""+customerBill.getSuppAmt(),null,date,userSessionService.getCurrentUser(),operationLogMapper);
        //   end
        return updateBill+updateOrderStatus;
    }





    @Override
    public CustomerBillOrder getCustomerOrderDetailByCode(String orderNo) {
        TMstRecvBill bill = customerBillMapper.getRecBillByOrderNo(orderNo);
        TSysUser user = userSessionService.getCurrentUser();

        int totalNum = 0;
        BigDecimal totalPrice = new BigDecimal(0);
        List<TPlanOrderItem> entries = new  ArrayList<TPlanOrderItem>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderNo",orderNo);
        map.put("salesOrg",user.getSalesOrg());
        List<TPlanOrderItem> items = tPlanOrderItemMapper.selectEntriesByOrderNo(map);
        if( items !=null && items.size()>0){
            for(TPlanOrderItem item : items){
                totalNum = totalNum+item.getQty();
                totalPrice = totalPrice.add(item.getSalesPrice().multiply(new BigDecimal(item.getQty())));
                entries.add(item);
            }
        }
        bill.setTotalNum(totalNum);
        bill.setTotalPrice(totalPrice);
        CustomerBillOrder  order = new CustomerBillOrder();
        order.setBill(bill);
        order.setEntries(entries);
        return order;
    }

    //根据订单号 创建 收款单
    @Override
    public TMstRecvBill createRecBillByOrderNo(String orderNo) {
        String errorContent ="";
        TMstRecvBill customerBill = customerBillMapper.getRecBillByOrderNo(orderNo);
        if(customerBill != null ){
            return customerBill;
        }
        TPreOrder order = tPreOrderMapper.selectByPrimaryKey(orderNo);
        if(order == null){
            errorContent = "该订单不存在！";
            throw new ServiceException(MessageCode.LOGIC_ERROR,errorContent);
        }
        if(order.getDiscountAmt()==null) order.setDiscountAmt(BigDecimal.ZERO);
        TSysUser user = userSessionService.getCurrentUser();
        customerBill  = new TMstRecvBill();
        customerBill.setHadOffsetNo(orderNo);
        customerBill.setRecvEmp(order.getEmpNo());
        customerBill.setOrderNo(orderNo);
       // customerBill.setAmt(order.getInitAmt());
        customerBill.setStatus("10");
        customerBill.setDiscountAmt(order.getDiscountAmt());
        customerBill.setReceiptNo(PrimaryKeyUtils.generateUuidKey());
        customerBill.setVipCustNo(order.getMilkmemberNo());
        customerBill.setCreateAt(new Date());
        customerBill.setCreateBy(user.getLoginName());
        customerBill.setHadOffset("N");
        customerBill.setCreateByTxt(user.getDisplayName());
        customerBill.setEndTime(order.getEndDate());
        TVipAcct ac = new TVipAcct();
        BigDecimal acLeftAmt = new BigDecimal("0.00");
        TVipAcct eac = tVipCustInfoService.findVipAcctByCustNo(order.getMilkmemberNo());
        if(eac!=null){
            acLeftAmt = eac.getAcctAmt();
        }
        //余额大于0  扣除余额
        ac.setVipCustNo(order.getMilkmemberNo());
        customerBill.setCustAccAmt(acLeftAmt);
        //订单 应该收取金额 = 订单总金额 - 订单折扣
        BigDecimal remainAmt = order.getInitAmt().subtract(order.getDiscountAmt());
        customerBill.setDiscountAmt(order.getDiscountAmt());
        //如果余额大于订单金额  则
        if(acLeftAmt.compareTo(remainAmt) == 1){
            customerBill.setAccAmt(remainAmt);
            customerBill.setSuppAmt(BigDecimal.ZERO);
            ac.setAcctAmt(order.getInitAmt().multiply(new BigDecimal(-1)));
        }else{
            ac.setAcctAmt(acLeftAmt.multiply(new BigDecimal(-1)));
            customerBill.setAccAmt(acLeftAmt);
            customerBill.setSuppAmt(remainAmt.subtract(acLeftAmt));
        }
          tVipCustInfoService.addVipAcct(ac);
          customerBillMapper.insertCustomerPayment(customerBill);
        return customerBill;
    }

    @Override
    public List<String> searchCustomerOrderForExp(CustBillQueryModel cModel) {
        TSysUser user = userSessionService.getCurrentUser();

        cModel.setSalesOrg(user.getSalesOrg());
        if(StringUtils.isBlank(cModel.getBranchNo())){
            cModel.setBranchNo(user.getBranchNo());
        }
        if(StringUtils.isBlank(cModel.getDealerNo())) {
            cModel.setDealerNo(user.getDealerId());
        }
        return tPreOrderMapper.searchCustomerOrderForExp(cModel);
    }

    @Override
    public BatChCollectResultModel custBatchCollect(CustBatchBillQueryModel model) {
        TSysUser user = userSessionService.getCurrentUser();
        model.setSalesOrg(user.getSalesOrg());
        model.setBranchNo(user.getBranchNo());
        model.setDealerNo(user.getDealerId());
        List<TPreOrder> orderList = tPreOrderMapper.searchCustomerOrderByEmpNo(model);
        BigDecimal totalPayment = new BigDecimal(0);
        BigDecimal totalAcctAmt = new BigDecimal(0);
        BigDecimal totalAmt = new BigDecimal(0);
        BatChCollectResultModel resultModel = new BatChCollectResultModel();
        if(orderList !=null && orderList.size()>0){
            for(TPreOrder order : orderList){
                //判断该订单 对应的收款单是否创建 如果没有先创建
                TMstRecvBill  bill = this.createRecBillByOrderNo(order.getOrderNo());
                if("20".equals(bill.getStatus())) continue;
                CustomerPayMentModel cmodel = new CustomerPayMentModel();
                cmodel.setAmt(bill.getSuppAmt().toString());
                cmodel.setEmpNo(order.getEmpNo());
                cmodel.setOrderNo(bill.getOrderNo());
                cmodel.setPaymentType("10");
                this.customerPayment(cmodel);
                totalPayment =  totalPayment.add(order.getInitAmt());
                totalAcctAmt = totalAcctAmt.add(bill.getAccAmt());
                totalAmt = totalAmt.add(order.getInitAmt().subtract(bill.getAccAmt()));
            }
            resultModel.setTotalAcctAmt(totalAcctAmt);
            resultModel.setTotalAmt(totalAmt);
            resultModel.setTotalPayment(totalPayment);
        }

        return resultModel;
    }

    @Override
    public int setBranchRemark(String branchRemark) {

        //备注可以设置为空,不限制非空
        if(StringUtils.isNotBlank(branchRemark) && branchRemark.length() > 200){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"奶站备注字符过长,请控制在200个字符以内");
        }
        String branchNo = userSessionService.getCurrentUser().getBranchNo();
        if(StringUtils.isBlank(branchNo)){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"当前用户未归属任何奶站");
        }
        TMdBranch branch = new TMdBranch();
        branch.setRemark(branchRemark);
        branch.setBranchNo(branchNo);
        int c = branchMapper.setBranchRemark(branch);
        return 1;
    }

    @Override
    public TMdBranch getCurrentBranch() {
        try {
            return branchMapper.getBranchByNo(this.userSessionService.getCurrentUser().getBranchNo());
        }catch(java.lang.Exception e){
            logger.error(e.getMessage(), e);
        }
      ;return new TMdBranch();
    }

    /**
     * 批量删除收款单
     * @param oModel
     * @return
     */
    @Override
    public int delRecBills(OrderSearchModel oModel) {
        if(oModel.getOrders() == null || !(oModel.getOrders().size()>0)){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"没有选择的订单");
        }
        List<TPreOrder> ordersList = tPreOrderMapper.selectCustBatchCollect(oModel);
        if(ordersList != null && ordersList.size() > 0){

            for(TPreOrder order : ordersList){

                //获取收款单
                TMstRecvBill  bill = this.getRecBillByOrderNo(order.getOrderNo());

                if(null == bill){
                    continue;
                }

                //10:后付款,20:先付款
                //不是后付款的跳过
                if(!"10".equals(order.getPaymentmethod())){
                    continue;
                }

                //10:未收款,20:已收款
                //不是未收款的跳过
                if(!"10".equals(order.getPaymentStat())){
                    continue;
                }

                //删除收款单
                customerBillMapper.delReceipt(bill.getReceiptNo());
            }
        }
        return 1;
    }

    @Override
    public BatChCollectResultModel custBatchCollectBySelect(OrderSearchModel oModel) {
        if(oModel.getOrders() == null || !(oModel.getOrders().size()>0)){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"没有选择的订单");
        }
        List<TPreOrder> ordersList = tPreOrderMapper.selectCustBatchCollect(oModel);
        BigDecimal totalPayment = new BigDecimal(0);
        BigDecimal totalAcctAmt = new BigDecimal(0);
        BigDecimal totalAmt = new BigDecimal(0);
        BatChCollectResultModel resultModel = new BatChCollectResultModel();
        if(ordersList !=null && ordersList.size()>0){
            for(TPreOrder order : ordersList){
                //判断该订单 对应的收款单是否创建 如果没有先创建
                TMstRecvBill  bill = this.createRecBillByOrderNo(order.getOrderNo());
                //已收过款
                if("20".equals(bill.getStatus())) continue;
                CustomerPayMentModel cmodel = new CustomerPayMentModel();
                cmodel.setAmt(bill.getSuppAmt().toString());
                cmodel.setEmpNo(order.getEmpNo());
                cmodel.setOrderNo(bill.getOrderNo());
                cmodel.setPaymentType("10");
                this.customerPayment(cmodel);
                totalAcctAmt = totalAcctAmt.add(bill.getAccAmt());
                totalPayment =  totalPayment.add(order.getInitAmt());
                totalAmt = totalAmt.add(order.getInitAmt().subtract(bill.getAccAmt()));
            }
            resultModel.setTotalAcctAmt(totalAcctAmt);
            resultModel.setTotalAmt(totalAmt);
            resultModel.setTotalPayment(totalPayment);
        }
        return resultModel;
    }

    @Override
    public int customerOffset(String receiptNo) {
        TMstRecvBill  bill = customerBillMapper.getRecBillByReceoptNo(receiptNo);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if("10".equals(bill.getStatus())){
            throw  new ServiceException(MessageCode.LOGIC_ERROR,"该订单还未收款！！！");
        }else if("Y".equals(bill.getHadOffset())){
            throw  new ServiceException(MessageCode.LOGIC_ERROR,"该订单已经冲销过了！！！");
        } else{

           /* int orderNum = tDispOrderItemMapper.selectDispOrderNumByPreOrderNo(bill.getOrderNo());
            if(orderNum > 0 ){
                throw  new ServiceException(MessageCode.LOGIC_ERROR,"该订单已生成了路单，不能冲销！！！");
            }*/

            TPreOrder preOrder = tPreOrderMapper.selectByPrimaryKey(bill.getOrderNo());
            if("20".equals(preOrder.getPaymentmethod())){
                //查看是否有路单产生
                TDispOrderItem dispItem = new TDispOrderItem();
                dispItem.setOrgOrderNo(preOrder.getOrderNo());
                dispItem.setOrderDate(preOrder.getOrderDate());
                List<TDispOrderItem> dispItems = tDispOrderItemMapper.selectItemsByOrgOrderAndItemNoAndBeforeDate(dispItem);
                //有路单 抛出错误信息
                if(dispItems!=null && dispItems.size()>0){
                    //confirmlist 过滤只保留已确认的路单
                    List<TDispOrderItem> confirmlist = dispItems.stream().filter(e -> ("20".equals(e.getStatus()))).collect(Collectors.toList());
                    //unConist 过滤只保留还未确认的路单
                    List<TDispOrderItem> unConist = dispItems.stream().filter(e -> ("10".equals(e.getStatus()))).collect(Collectors.toList());
                    if (confirmlist != null && confirmlist.size() > 0) {
                        //confirmlist 不为空说明有已确认的路单
                        StringBuffer mess = new StringBuffer("");
                        //将所有确认的路单日期取出
                        confirmlist.stream().forEach(e -> {
                            mess.append(e.getMatnr()+"产品"+format.format(e.getOrderDate()) + "\n");
                        });
                        throw new ServiceException(MessageCode.LOGIC_ERROR, mess + "的路单已经确认，不能冲销");
                    }else{
                        if (unConist != null && unConist.size() > 0) {
                            StringBuffer mess = new StringBuffer("");
                            unConist.stream().forEach(e -> {
                                mess.append(e.getMatnr()+"产品"+format.format(e.getOrderDate()) + "\n");
                            });
                            throw new ServiceException(MessageCode.LOGIC_ERROR, mess + "的路单已经生成，请删除后再做冲销");
                        }
                    }
                }

            }
            //扣除余额
            if(preOrder.getInitAmt().compareTo(bill.getAmt())!=0){
                //返回积分
                TVipAcct eac = tVipCustInfoService.findVipAcctByCustNo(preOrder.getMilkmemberNo());
                TVipAcct ac = new TVipAcct();
                BigDecimal acLeftAmt = new BigDecimal("0.00");
                if(eac!=null){
                    acLeftAmt = eac.getAcctAmt();
                }
                ac.setVipCustNo(preOrder.getMilkmemberNo());
                if(preOrder.getInitAmt().compareTo(bill.getAmt())==-1){
                    ac.setAcctAmt(preOrder.getInitAmt().subtract(bill.getAmt()));
                }else{
                    ac.setAcctAmt(preOrder.getInitAmt().subtract(bill.getAmt()));
                }

                tVipCustInfoService.addVipAcct(ac);
            }
            //判断是否需要 返还积分
            if("Y".equals(preOrder.getIsIntegration())){
                piVipPointCreateBatService.backPoint(preOrder,preOrder.getInitAmt(), preOrder.getInitAmt());
//                taskExecutor.execute(new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        this.setName("minusVipPoint");
//                        BigDecimal gRate = BigDecimal.ONE.multiply(new BigDecimal(preOrder.getyGrowth()==null?0:preOrder.getyGrowth()));//成长
//                        BigDecimal fRate = BigDecimal.ONE.multiply(new BigDecimal(preOrder.getyFresh()==null?0:preOrder.getyFresh()));//鲜峰
//                        MemberActivities item = new MemberActivities();
//                        Date date = new Date();
//                        item.setActivitydate(date);
//                        item.setSalesorg(preOrder.getSalesOrg());
//                        item.setCategory("YRETURN");
//                        item.setProcesstype("YSUB_RETURN");
//                        item.setOrderid(preOrder.getOrderNo());
//                        item.setMembershipguid(preOrder.getMemberNo());
//                        item.setPointtype("YGROWTH");
//                        item.setPoints(gRate);
//                        //第1遍传成长
////                        piVipInfoDataService.createMemberActivities(item);
//                        List<MemberActivities> gList = new ArrayList<MemberActivities>();
//                        gList.add(item);
//                        piVipPointCreateBatService.createMemberActivitiesBat(gList);
//                        //第2遍传先锋
//                        item.setPointtype("YFRESH");
//                        item.setPoints(fRate);
//                        List<MemberActivities> fList = new ArrayList<MemberActivities>();
//                        fList.add(item);
////                        piVipInfoDataService.createMemberActivities(item);
//                        piVipPointCreateBatService.createMemberActivitiesBat(fList);
//                    }
//                });
            }
            //将 收款单置为 已冲销
            TMstRecvBill newBill = new TMstRecvBill();
            newBill.setReceiptNo(bill.getReceiptNo());
            newBill.setHadOffset("Y");
            newBill.setHadOffsetNo(bill.getReceiptNo());
            customerBillMapper.updateCustomerBillrPayment(newBill);

            // 如果该订单为预付款订单，且没有产生路单，则删除 所有日订单
            if("20".equals(preOrder.getPaymentmethod()) && tDispOrderItemMapper.selectCountByOrgOrder(preOrder.getOrderNo()) == 0) {
                tOrderDaliyPlanItemMapper.deletePlansByOrder(bill.getOrderNo());
            }

            //生成对应的冲销单
            TSysUser user = userSessionService.getCurrentUser();
            TMstRecvOffset offset  = new TMstRecvOffset();
            offset.setOrderNo(bill.getOrderNo());
            offset.setVipCustNo(bill.getVipCustNo());
            offset.setCreateAt(new Date());
            offset.setReceiptNo(bill.getReceiptNo());
            offset.setOffsetNo(PrimaryKeyUtils.generateUuidKey());
            offset.setOffsetDate(new Date());
            offset.setAmt(bill.getAmt());
            offset.setAccAmt(bill.getAccAmt());
            customerBillMapper.addOffset(offset);
            TPreOrder order = new TPreOrder();
            order.setOrderNo(bill.getOrderNo());
            order.setPaymentStat("10");
            tPreOrderMapper.updateOrderStatus(order);
            //将订单冲销日志写入 t_md_operation_log 表。     by  liuyin   编号   类型   名称  送奶员  配送地址 原值  新值 产品 日期
            //   start
            OperationLogUtil.saveHistoryOperation(preOrder.getOrderNo(), LogType.ORDER, "冲销",preOrder.getEmpName(),null,
                    ""+preOrder.getInitAmt(),""+preOrder.getCurAmt(),null,new Date(),userSessionService.getCurrentUser(),operationLogMapper);
            //   end
        }

        return 1;
    }

    @Override
    public BigDecimal calculateTotalBeforBatch(CustBatchBillQueryModel cModel) {
        return tPreOrderMapper.calculateTotalBeforBatch(cModel);
    }

    @Override
    public int custRefund(CustomerRefundModel cModel) {
        TSysUser user = userSessionService.getCurrentUser();
        //返回积分
        TVipAcct eac = tVipCustInfoService.findVipAcctByCustNo(cModel.getVipCustNo());
        TVipAcct ac = new TVipAcct();
        BigDecimal acLeftAmt = new BigDecimal("0.00");
        if(eac!=null){
            acLeftAmt = eac.getAcctAmt();
        }
        ac.setVipCustNo(cModel.getVipCustNo());
        ac.setAcctAmt(acLeftAmt.multiply(new BigDecimal(-1)));
        int custInfo = tVipCustInfoService.addVipAcct(ac);
        TMstRefund refund = new TMstRefund();
        refund.setRefundNo(PrimaryKeyUtils.generateUpperUuidKey());
        refund.setAmt(acLeftAmt);
        refund.setCreateAt(new Date());
        refund.setVipCustNo(cModel.getVipCustNo());
        refund.setCreateBy(user.getLoginName());
        refund.setCreateByTxt(user.getDisplayName());
        refund.setVipName(cModel.getVipName());
        refund.setBranchNo(user.getBranchNo());
        refund.setDealerNo(user.getDealerId());
        refund.setSalesOrg(user.getSalesOrg());
        if(StringUtils.isNotBlank(cModel.getRemark())){
            refund.setRemark(cModel.getRemark());
        }
        int refundInfo =  customerBillMapper.addRefund(refund);
        return refundInfo + custInfo;
    }

    @Override
    public List<CollectOrderBillModel> BatchPrintForExp(CustBillQueryModel cModel) {
        TSysUser user = userSessionService.getCurrentUser();
        cModel.setBranchNo(user.getBranchNo());
        List<CollectOrderBillModel> result = new ArrayList<CollectOrderBillModel>();
        final  long startTime = System.currentTimeMillis();
        if(StringUtils.isNotBlank(cModel.getPaymentmethod()) ){
            if( "20".equals(cModel.getPaymentmethod())){
                List<String> advancePayOrders = tPreOrderMapper.selectAdvanceOrderNos(cModel);
                if(advancePayOrders!=null && advancePayOrders.size()>0){
                    for(String orderNo : advancePayOrders){
                        //创建收款单  如果有会直接返回
                        createRecBillByOrderNo(orderNo);
                    }
                        List<CollectOrderBillModel> hasItem = customerBillMapper.selectNoItemsCollectByOrders("20", advancePayOrders);
                        if (hasItem != null && hasItem.size() > 0){
                            result.addAll(hasItem);
                        }
                }
            }else{
                List<String> afterPayOrders = tPreOrderMapper.selectAfterOrderNos(cModel);
                if(afterPayOrders!=null && afterPayOrders.size()>0) {
                    for(String orderNo : afterPayOrders){
                        //创建收款单  如果有会直接返回
                        createRecBillByOrderNo(orderNo);
                    }
                    List<CollectOrderBillModel> after = customerBillMapper.selectHasItemsCollectByOrders("10", afterPayOrders);
                    if (after != null && after.size() > 0) {
                        result.addAll(after);
                    }
                }
            }
        }else{
            List<String> advancePayOrders = tPreOrderMapper.selectAdvanceOrderNos(cModel);
//            System.out.println("预付款单号共有"+(advancePayOrders==null?0:advancePayOrders.size())+"获取预付款所有订单号耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
            //预付款的

            if(advancePayOrders!=null && advancePayOrders.size()>0){
//                System.out.println("开始创建预付款订单收款单====");
//                final long startTime2 = System.currentTimeMillis();
                for(String orderNo : advancePayOrders){
                    //创建收款单  如果有会直接返回
                    createRecBillByOrderNo(orderNo);
                }
//                System.out.println("创建预付款订单收款单共耗时："+(System.currentTimeMillis()-startTime2)+"毫秒");


//                System.out.println("开始查询预付款收款单信息====");
//                final long startTime3 = System.currentTimeMillis();
                List<CollectOrderBillModel> before = customerBillMapper.selectNoItemsCollectByOrders("20", advancePayOrders);
//                System.out.println("查询预付款收款单信息共耗时："+(System.currentTimeMillis()-startTime3)+"毫秒");
                if (before != null && before.size() > 0) {
                        result.addAll(before);
                    }
            }
//            System.out.print("开始创建后付款订单收款单====");
//            final long startTime4 = System.currentTimeMillis();
            //后付款的 一定有日订单
            List<String> afterPayOrders = tPreOrderMapper.selectAfterOrderNos(cModel);
//            System.out.println("后付款单号共有"+afterPayOrders==null?0:afterPayOrders.size()+"获取预付款所有订单号耗时："+(System.currentTimeMillis()-startTime4)+"毫秒");
            if(afterPayOrders!=null && afterPayOrders.size()>0) {

//                System.out.println("开始创建后付款订单收款单====");
//                final long startTime5 = System.currentTimeMillis();
                for(String orderNo : afterPayOrders){
                    //创建收款单  如果有会直接返回
                    createRecBillByOrderNo(orderNo);
                }

//                System.out.println("开始查询后付款收款单信息====");
                final long startTime6= System.currentTimeMillis();
                List<CollectOrderBillModel> after = customerBillMapper.selectHasItemsCollectByOrders("10", afterPayOrders);
//                System.out.println("查询后付款收款单信息共耗时："+(System.currentTimeMillis()-startTime6)+"毫秒");
                if (after != null && after.size() > 0) {
                    result.addAll(after);
                }
            }

        }

        System.out.println("------总共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");

        return result;
    }


    public BatChCollectForExpModel BatchPrintForExp2(CustBillQueryModel cModel) {
        TSysUser user = userSessionService.getCurrentUser();
        cModel.setBranchNo(user.getBranchNo());
        cModel.setSalesOrg(user.getSalesOrg());
        BatChCollectForExpModel  expModel = new BatChCollectForExpModel();
        TMdBranch bmodel = branchMapper.selectBranchInfoByBranchNo(user.getBranchNo());
        if(bmodel!=null){
            expModel.setBranchAddress(bmodel.getAddress());
            expModel.setBranchName(bmodel.getBranchName());
            expModel.setBranchTel(bmodel.getTel());
            expModel.setSalesOrgName(bmodel.getSalesOrgName());
        }
        List<CollectOrderBillModel> result = new ArrayList<CollectOrderBillModel>();
        final  long startTime = System.currentTimeMillis();
        if(StringUtils.isNotBlank(cModel.getOrderNo())){
            createRecBillByOrderNo(cModel.getOrderNo());
            if("20".equals(cModel.getPaymentmethod())){
                List<CollectOrderBillModel> hasItem = customerBillMapper.selectNoItemsCollectByOrders2(cModel);
                result.addAll(hasItem);
            }else{
                List<CollectOrderBillModel> after = customerBillMapper.selectHasItemsCollectByOrders2(cModel);
                result.addAll(after);
            }
            expModel.setBillModels(result);
            System.out.println("单独导出一个收款单信息共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
            return expModel;
        }


        if(StringUtils.isNotBlank(cModel.getPaymentmethod()) ){
            if( "20".equals(cModel.getPaymentmethod())){
                List<String> advancePayOrders = tPreOrderMapper.selectAdvanceOrderNos(cModel);
                if(advancePayOrders!=null && advancePayOrders.size()>0){
                    for(String orderNo : advancePayOrders){
                        //创建收款单  如果有会直接返回
                        createRecBillByOrderNo(orderNo);
                    }
                    cModel.setPaymentmethod("20");
                    List<CollectOrderBillModel> hasItem = customerBillMapper.selectNoItemsCollectByOrders2(cModel);
                    if (hasItem != null && hasItem.size() > 0){
                        result.addAll(hasItem);
                    }
                }
            }else{
                List<String> afterPayOrders = tPreOrderMapper.selectAfterOrderNos(cModel);
                if(afterPayOrders!=null && afterPayOrders.size()>0) {
                    for(String orderNo : afterPayOrders){
                        //创建收款单  如果有会直接返回
                        createRecBillByOrderNo(orderNo);
                    }
                    cModel.setPaymentmethod("10");
                    List<CollectOrderBillModel> after = customerBillMapper.selectHasItemsCollectByOrders2(cModel);
                    if (after != null && after.size() > 0) {
                        result.addAll(after);
                    }
                }
            }
        }else{
            List<String> advancePayOrders = tPreOrderMapper.selectAdvanceOrderNos(cModel);
//            System.out.println("预付款单号共有"+(advancePayOrders==null?0:advancePayOrders.size())+"获取预付款所有订单号耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
            //预付款的

            if(advancePayOrders!=null && advancePayOrders.size()>0){
//                System.out.println("开始创建预付款订单收款单====");
//                final long startTime2 = System.currentTimeMillis();
                for(String orderNo : advancePayOrders){
                    //创建收款单  如果有会直接返回
                    createRecBillByOrderNo(orderNo);
                }
//                System.out.println("创建预付款订单收款单共耗时："+(System.currentTimeMillis()-startTime2)+"毫秒");


//                System.out.println("开始查询预付款收款单信息====");
//                final long startTime3 = System.currentTimeMillis();
                List<CollectOrderBillModel> before = customerBillMapper.selectNoItemsCollectByOrders2(cModel);
//                System.out.println("查询预付款收款单信息共耗时："+(System.currentTimeMillis()-startTime3)+"毫秒");
                if (before != null && before.size() > 0) {
                    result.addAll(before);
                }
            }
//            System.out.print("开始创建后付款订单收款单====");
//            final long startTime4 = System.currentTimeMillis();
            //后付款的 一定有日订单
            List<String> afterPayOrders = tPreOrderMapper.selectAfterOrderNos(cModel);
//            System.out.println("后付款单号共有"+afterPayOrders==null?0:afterPayOrders.size()+"获取预付款所有订单号耗时："+(System.currentTimeMillis()-startTime4)+"毫秒");
            if(afterPayOrders!=null && afterPayOrders.size()>0) {

//                System.out.println("开始创建后付款订单收款单====");
//                final long startTime5 = System.currentTimeMillis();
                for(String orderNo : afterPayOrders){
                    //创建收款单  如果有会直接返回
                    createRecBillByOrderNo(orderNo);
                }
//                System.out.println("创建后付款订单收款单共耗时："+(System.currentTimeMillis()-startTime5)+"毫秒");

//                System.out.println("开始查询后付款收款单信息====");
//                final long startTime6= System.currentTimeMillis();
                List<CollectOrderBillModel> after = customerBillMapper.selectHasItemsCollectByOrders2(cModel);
//                System.out.println("查询后付款收款单信息共耗时："+(System.currentTimeMillis()-startTime6)+"毫秒");
                if (after != null && after.size() > 0) {
                    result.addAll(after);
                }
            }

        }

        expModel.setBillModels(result);
        System.out.println("批量获取收款单信息共耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
        return expModel;
    }


    @Override
    public int delReceipt(String receiptNo) {
        if(StringUtils.isBlank(receiptNo)){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"参数 收款表单号不能为空！！！");
        }
        TMstRecvBill bill = customerBillMapper.getRecBillByReceoptNo(receiptNo);
        if(bill==null){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"该收款表已经被删除");
        }
        if(bill.getAmt()!=null &&  "N".equals(bill.getHadOffset())){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"该订单已经收过款，不能删除，你可以考虑下冲销");
        }
        TPreOrder order = tPreOrderMapper.selectByPrimaryKey(bill.getOrderNo());
        if(order == null){
            throw new ServiceException(MessageCode.LOGIC_ERROR,"该订单已不存在了，请查看");
        }

        //处理余额(如果有收取余额，则将余额退回)
        if(bill.getAccAmt()!=null && bill.getAccAmt().compareTo(BigDecimal.ZERO)==1){
            //获取积分
            TVipAcct eac = tVipCustInfoService.findVipAcctByCustNo(order.getMilkmemberNo());
            TVipAcct ac = new TVipAcct();
            BigDecimal acLeftAmt = new BigDecimal("0.00");
            if(eac!=null){
                acLeftAmt = eac.getAcctAmt();
            }
            ac.setVipCustNo(order.getMilkmemberNo());
            ac.setAcctAmt(bill.getAccAmt());
            tVipCustInfoService.addVipAcct(ac);
        }

        return customerBillMapper.delReceipt(receiptNo);
    }


    @Override
    public CollectOrderBillModel queryCollectByOrderNo(String orderCode) {
        TPreOrder order = tPreOrderMapper.selectByPrimaryKey(orderCode);
        return customerBillMapper.queryCollectByOrderNo(orderCode,order.getPaymentmethod());
    }


    public void setCustomerBillMapper(CustomerBillMapper customerBillMapper) {
        this.customerBillMapper = customerBillMapper;
    }

    public void settPreOrderMapper(TPreOrderMapper tPreOrderMapper) {
        this.tPreOrderMapper = tPreOrderMapper;
    }

    public void settPlanOrderItemMapper(TPlanOrderItemMapper tPlanOrderItemMapper) {
        this.tPlanOrderItemMapper = tPlanOrderItemMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }
    public void setOrderService(OrderService orderService) {
       this.orderService = orderService;
    }
    
    public void setPromotionService(PromotionService promotionService) {
       this.promotionService = promotionService;
    }
    public void settVipCustInfoService(TVipCustInfoService tVipCustInfoService) {
       this.tVipCustInfoService = tVipCustInfoService;
    }

    public void setUrMapper(TSysUserRoleMapper urMapper) {
        this.urMapper = urMapper;
    }

    @Override
    public int selectOrdersNoBillCount(){
        return tPreOrderMapper.selectOrdersNoBillCount(userSessionService.getCurrentUser().getBranchNo());
    }
}
