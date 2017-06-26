package com.nhry.service.milktrans.impl;

import com.nhry.common.auth.UserSessionService;
import com.nhry.common.exception.MessageCode;
import com.nhry.common.exception.ServiceException;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.data.bill.dao.CustomerBillMapper;
import com.nhry.data.bill.domain.TMstRecvBill;
import com.nhry.data.milk.dao.TDispOrderMapper;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milktrans.dao.TSsmMilkmanAmtInitMapper;
import com.nhry.data.milktrans.dao.TssmMilkmanAmtsMapper;
import com.nhry.data.milktrans.domain.TSsmMilkmanAmtInit;
import com.nhry.data.milktrans.domain.TssmMilkmanAmts;
import com.nhry.model.statistics.ExtendBranchInfoModel;
import com.nhry.model.statistics.OutMilkModel;
import com.nhry.service.milktrans.dao.OutMilkService;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by huaguan on 2016/12/23.
 */
public class OutMilkServiceImpl implements OutMilkService {
    private TSsmMilkmanAmtInitMapper tSsmMilkmanAmtInitMapper;
    private TssmMilkmanAmtsMapper tssmMilkmanAmtsMapper;
    private CustomerBillMapper customerBillMapper;
    private TDispOrderMapper tDispOrderMapper;
    private UserSessionService userSessionService;

    public void settSsmMilkmanAmtInitMapper(TSsmMilkmanAmtInitMapper tSsmMilkmanAmtInitMapper) {
        this.tSsmMilkmanAmtInitMapper = tSsmMilkmanAmtInitMapper;
    }

    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    public void setTssmMilkmanAmtsMapper(TssmMilkmanAmtsMapper tssmMilkmanAmtsMapper) {
        this.tssmMilkmanAmtsMapper = tssmMilkmanAmtsMapper;
    }

    public void setCustomerBillMapper(CustomerBillMapper customerBillMapper) {
        this.customerBillMapper = customerBillMapper;
    }

    public void settDispOrderMapper(TDispOrderMapper tDispOrderMapper) {
        this.tDispOrderMapper = tDispOrderMapper;
    }

    /**
     * 初始化出奶表奶站信息
     * 1、创建该奶站送奶员初始化结余金额
     * 2、根据该奶站送奶员初始化金额创建出奶表统计金额，
     * 根据路单查询本日进货金额
     * 根据收款单查询本日收款金额
     * @param record
     * @return
     */
    @Override
    public int insertAmtInit(OutMilkModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        //创建该奶站送奶员初始化结余金额
        TSsmMilkmanAmtInit tmai = new TSsmMilkmanAmtInit();
        tmai.setCreateBy(user.getEmpNo());
        tmai.setCreateByTxt(user.getDisplayName());
        tmai.setCreateAt(new Date());
        tmai.setBranchNo(user.getBranchNo());
        tmai.setEmpNo(record.getEmpNo());
        tmai.setReAmt(record.getReAmt());
        //根据该奶站送奶员初始化金额创建出奶表统计金额
        TssmMilkmanAmts tma = new TssmMilkmanAmts();
        tma.setBranchNo(user.getBranchNo());
        tma.setEmpNo(record.getEmpNo());
        tma.setOrderDate(record.getOrderDate());
        tma.setReAmt(tmai.getReAmt());
        tma.setCreateAt(new Date());
        //本日交款-奶站、日期，统计送奶员本日交款总额
        TMstRecvBill trb = customerBillMapper.getBranchEmpPaymentByEmpNo(user.getBranchNo(),record.getOrderDate(),record.getEmpNo());
        //查询奶站下本日进货汇总金额
        TDispOrder tdo = tDispOrderMapper.getBranchEmpAmtByEmpNo(user.getBranchNo(),record.getOrderDate(),record.getEmpNo());
        if(tdo!=null){
            tma.setDayAmt(tdo.getAmt());
        }else{
            tma.setDayAmt(new BigDecimal(0));
        }

        //如果有冲销，收款金额需要减去冲销
        if(trb!=null){
            if(trb.getOffsetAmt()!=null){
                tma.setDayBillAmt(trb.getAmt().subtract(trb.getOffsetAmt()));
            }else{
                tma.setDayBillAmt(trb.getAmt());
            }
            //本日交款调整为负值
            tma.setDayBillAmt(tma.getDayAmt().multiply(new BigDecimal(-1)));
        }else{
            tma.setDayBillAmt(new BigDecimal(0));
        }
        //本日结存金额为上日结存+本日进货+本日交款之和
         tma.setTotalAmt(tma.getReAmt().add(tma.getDayAmt()).add(tma.getDayBillAmt()));
        //保存出奶表总金额合计
        tssmMilkmanAmtsMapper.insertAmts(tma);


        return tSsmMilkmanAmtInitMapper.insertAmtInit(tmai);
    }

    /**
     * 根据送奶员、奶站创建前一天的统计数据
     * 1、获取当前日期并取前一天的日期
     * 2、获取出奶表初始化的奶站及送奶员
     * 3、循环获取该该奶站下送奶员最后一天的统计数据
     * 4、判断如果当前日期-提前一天在该奶站送奶员最后一天之后，继续
     * 5、获取交款、进货金额
     * 6、进行插入出奶表送奶员统计数据
     * @param
     * @return
     */
    @Override
    public int createAmtsdayByday() {
        OutMilkModel record = new OutMilkModel();
        TssmMilkmanAmts tma = new TssmMilkmanAmts();
        Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。

        cal.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天.
        //取今天的前一天做为计算
        Date yesterday = new Date();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(cal.getTime());
       try {
           yesterday = format.parse(dateString);
       }catch (Exception e){

       }
        //根据传入的奶站编号、送奶员编号查询是否有该奶站送奶员的统计信息
        List<TSsmMilkmanAmtInit> amtInitLists = tSsmMilkmanAmtInitMapper.selectAllAmtInit();
        if(amtInitLists!=null){
            for(TSsmMilkmanAmtInit amtInit : amtInitLists){
                record.setBranchNo(amtInit.getBranchNo());
                record.setEmpNo(amtInit.getEmpNo());
                record.setOrderDate(yesterday);
                //查询该奶站送奶员最最后一天统计数值
                TssmMilkmanAmts maxDay = tssmMilkmanAmtsMapper.selectAmtsMaxDay(record);
                //本日交款-奶站、日期，统计送奶员本日交款总额
                TMstRecvBill trb = customerBillMapper.getBranchEmpPaymentByEmpNo(record.getBranchNo(),record.getOrderDate(),record.getEmpNo());
                //查询奶站下本日进货汇总金额
                TDispOrder tdo = tDispOrderMapper.getBranchEmpAmtByEmpNo(record.getBranchNo(),record.getOrderDate(),record.getEmpNo());
                if(maxDay!=null){
                    //判断传入日期如果大于该奶站送奶员最后一天，则进行插入更新数据
                    if(record.getOrderDate().after(maxDay.getOrderDate())){
                        tma.setEmpNo(record.getEmpNo());
                        tma.setBranchNo(record.getBranchNo());
                        //该奶站送奶员最后一天的结余金额
                        tma.setReAmt(maxDay.getTotalAmt());
                        tma.setOrderDate(yesterday);
                        tma.setCreateAt(new Date());
                        if(tdo!=null){
                            tma.setDayAmt(tdo.getAmt());
                        }else{
                            tma.setDayAmt(new BigDecimal(0));
                        }
                        //如果有冲销，收款金额需要减去冲销
                        if(trb!=null){
                            if(trb.getOffsetAmt()!=null){
                                tma.setDayBillAmt(trb.getAmt().subtract(trb.getOffsetAmt()));
                            }else{
                                tma.setDayBillAmt(trb.getAmt());
                            }
                            //本日交款调整为负值
                            tma.setDayBillAmt(tma.getDayAmt().multiply(new BigDecimal(-1)));
                        }else{
                            tma.setDayBillAmt(new BigDecimal(0));
                        }
                        //本日结存金额为上日结存+本日进货+本日交款之和
                        tma.setTotalAmt(tma.getReAmt().add(tma.getDayAmt()).add(tma.getDayBillAmt()));
                        //插入前一天的统计金额
                        tssmMilkmanAmtsMapper.insertAmts(tma);
                    }
                }
            }
        }
        return 0;
    }

    /**
     *奶站选择日期自助生成出奶表数据
     * @return
     */
    @Override
    public int createAmtsByBranch(OutMilkModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        record.setBranchNo(user.getBranchNo());
        Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
        //取今天的前一天做为计算--做为生成结束日期
        Date totay = new Date();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(cal.getTime());
        try {
            totay = format.parse(dateString);
        }catch (Exception e){

        }
        //需要生成的出奶统计表的前一天(查询指定日期前是否有数据)
        Date inDayBefore = new Date();
        Calendar calinDay = Calendar.getInstance();
        calinDay.setTime(record.getOrderDate());
        calinDay.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天.
        String inDay = format.format(calinDay.getTime());

        try {
            inDayBefore = format.parse(inDay);
        }catch (Exception e){

        }
        //根据传入的奶站编号查询是否有该奶站送奶员的统计信息
        List<TSsmMilkmanAmtInit> amtInitLists = tSsmMilkmanAmtInitMapper.selectAmtInitByBranchNo(record);
        if(amtInitLists!=null){
            for(TSsmMilkmanAmtInit amtInit : amtInitLists){
                OutMilkModel model = new OutMilkModel();
                model.setBranchNo(user.getBranchNo());
                model.setEmpNo(amtInit.getEmpNo());
                model.setOrderDate(inDayBefore);
                record.setEmpNo(amtInit.getEmpNo());
                //获取传入日期前一天的出奶统计信息
                TssmMilkmanAmts selectAmtsByDay = tssmMilkmanAmtsMapper.selectAmtsByDay(model);
                if(selectAmtsByDay!=null){
                    TssmMilkmanAmts tma = new TssmMilkmanAmts();
                    Calendar dd = Calendar.getInstance();
                    dd.setTime(record.getOrderDate());//指定日期做为重新生成开始日期
                    TssmMilkmanAmts minDayInit = tssmMilkmanAmtsMapper.selectAmtsMinDay(record);
                    if(minDayInit.getOrderDate().before(record.getOrderDate())){
                        //删除这个送奶员传入日期的统计数据
                        tssmMilkmanAmtsMapper.deleteAmtsKeyDay(model.getBranchNo(),model.getEmpNo(),record.getOrderDate());
                    }
                    BigDecimal totamAmts =selectAmtsByDay.getTotalAmt();
                    //根据传入日期重新生成
                    while(dd.getTime().before(totay)){
                        model.setOrderDate(dd.getTime());
                        //本日交款-奶站、日期，统计送奶员本日交款总额
                        TMstRecvBill trb = customerBillMapper.getBranchEmpPaymentByEmpNo(model.getBranchNo(),model.getOrderDate(),model.getEmpNo());
                        //查询奶站下本日进货汇总金额
                        TDispOrder tdo = tDispOrderMapper.getBranchEmpAmtByEmpNo(model.getBranchNo(),model.getOrderDate(),model.getEmpNo());
                        tma.setEmpNo(model.getEmpNo());
                        tma.setBranchNo(model.getBranchNo());
                        //该奶站送奶员最后一天的结余金额
                        tma.setReAmt(totamAmts);
                        tma.setOrderDate(dd.getTime());
                        tma.setCreateAt(new Date());
                        if(tdo!=null){
                            tma.setDayAmt(tdo.getAmt());
                        }else{
                            tma.setDayAmt(new BigDecimal(0));
                        }
                        //如果有冲销，收款金额需要减去冲销
                        if(trb!=null){
                            if(trb.getOffsetAmt()!=null){
                                tma.setDayBillAmt(trb.getAmt().subtract(trb.getOffsetAmt()));
                            }else{
                                tma.setDayBillAmt(trb.getAmt());
                            }
                            //本日交款调整为负值
                            tma.setDayBillAmt(tma.getDayAmt().multiply(new BigDecimal(-1)));
                        }else{
                            tma.setDayBillAmt(new BigDecimal(0));
                        }
                        //本日结存金额为上日结存+本日进货+本日交款之和
                        tma.setTotalAmt(tma.getReAmt().add(tma.getDayAmt()).add(tma.getDayBillAmt()));
                        totamAmts = tma.getTotalAmt();
                        //插入前一天的统计金额
                        tssmMilkmanAmtsMapper.insertAmts(tma);
                        dd.add(Calendar.DATE, 1);
                    }
                }
            }
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR, "该奶站没有初始化数据，请先初始化");
        }
        return 0;
    }
    /**
     * 联合主键查询
     * @param record
     * @return
     */
    @Override
    public List<TssmMilkmanAmts> selectAmtsByPrimaryKey(ExtendBranchInfoModel record) {
        return tssmMilkmanAmtsMapper.selectAmtsByPrimaryKey(record);
    }

    @Override
    public List<TSsmMilkmanAmtInit> selectAmtInitList() {
        OutMilkModel record = new OutMilkModel();
        TSysUser user = userSessionService.getCurrentUser();
        record.setBranchNo(user.getBranchNo());
        return tSsmMilkmanAmtInitMapper.selectAmtInitList(record);
    }

    /**
     * 更新出奶表初始化金额
     * 判断如果该送奶员初始化的金额已经应用，则不允许进行修改
     * @param record
     * @return
     */
    @Override
    public int updateAmtInitByPrimaryKeySelective(OutMilkModel record) {
        TSysUser user = userSessionService.getCurrentUser();
        record.setBranchNo(user.getBranchNo());
        TssmMilkmanAmts maxTMA = tssmMilkmanAmtsMapper.selectAmtsMaxDay(record);
        TssmMilkmanAmts minTMA = tssmMilkmanAmtsMapper.selectAmtsMinDay(record);
        //判断最小日期要等于最大日期才能进行更新操作，即只初始化了第一天的数据
        if(maxTMA.getOrderDate().compareTo(minTMA.getOrderDate())==0){
            //更新初始化金额及初始化日期
            tSsmMilkmanAmtInitMapper.updateAmtInitByPrimaryKeySelective(record);
            TssmMilkmanAmts oneDayTMA = tssmMilkmanAmtsMapper.selectAmtsOneDay(record);
            TssmMilkmanAmts tma =new  TssmMilkmanAmts();
            tma.setReAmt(record.getReAmt());
            tma.setLastModified(new Date());
            tma.setLastModifiedBy(user.getDisplayName());
            tma.setBranchNo(record.getBranchNo());
            tma.setEmpNo(record.getEmpNo());
            //日期不等于空的情况下要重新计算该日期的出货、进货及总金额
            if(record.getOrderDate()!=null){
                tma.setOrderDate(record.getOrderDate());
                //本日交款-奶站、日期，统计送奶员本日交款总额
                TMstRecvBill trb = customerBillMapper.getBranchEmpPaymentByEmpNo(record.getBranchNo(),record.getOrderDate(),record.getEmpNo());
                //查询奶站下本日进货汇总金额
                TDispOrder tdo = tDispOrderMapper.getBranchEmpAmtByEmpNo(record.getBranchNo(),record.getOrderDate(),record.getEmpNo());
                if(tdo!=null){
                    tma.setDayAmt(tdo.getAmt());
                }else{
                    tma.setDayAmt(new BigDecimal(0));
                }
                //如果有冲销，收款金额需要减去冲销
                if(trb!=null){
                    if(trb.getOffsetAmt()!=null){
                        tma.setDayBillAmt(trb.getAmt().subtract(trb.getOffsetAmt()));
                    }else{
                        tma.setDayBillAmt(trb.getAmt());
                    }
                    //本日交款调整为负值
                    tma.setDayBillAmt(tma.getDayAmt().multiply(new BigDecimal(-1)));
                }else{
                    tma.setDayBillAmt(new BigDecimal(0));
                }
                //本日结存金额为上日结存+本日进货+本日交款之和
                tma.setTotalAmt(tma.getReAmt().add(tma.getDayAmt()).add(tma.getDayBillAmt()));
            }else{
                tma.setTotalAmt(tma.getReAmt().add(oneDayTMA.getDayAmt()).add(oneDayTMA.getDayBillAmt()));
            }
            tssmMilkmanAmtsMapper.updateAmtsByPrimaryKeySelective(tma);
        }else{
            throw new ServiceException(MessageCode.LOGIC_ERROR, "送奶员："+record.getEmpNo()+"已经有台帐统计信息，不能进行修改");
        }
        return 0;
    }
}
