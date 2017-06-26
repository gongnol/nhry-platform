package com.nhry.data.milk.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderKey;
import com.nhry.model.milk.RouteOrderSearchModel;
import com.nhry.model.milktrans.CreateEmpReturnboxModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TDispOrderMapper {
	 List<TDispOrder> selectConfirmedDispOrderByDate(String branchNo,String date);
	
	 int deleteDispOrderByOrderNo(List<String> codeList);
    //查询今天奶站下的路单数
    List<TDispOrder> selectTodayDispOrderByBranchNo(String branchNo,Date date);

    int insert(TDispOrder record);

    PageInfo searchRoutePlansByPage(RouteOrderSearchModel smodel);

    TDispOrder selectByPrimaryKey(TDispOrderKey key);

    TDispOrder selectYestodayDispOrderByEmp(TDispOrder record);
    
    TDispOrder selectYestodayDispOrderByEmpType10(TDispOrder record);

    int updateDispOrderStatus(String orderCode,String status);
    BigDecimal creatRecBot(CreateEmpReturnboxModel cModel);

    TDispOrder getDispOrderByNo(String dispOrderNo);
    
    int updateDispOrderEmp(TDispOrder order);

    //查询日期下奶站下已确认的路单数
    List<TDispOrder> selectConfirmDispOrderByBranchNoAndDay(String branchNo,Date date);
    //查询日期下奶站下的路单数
    List<TDispOrder> selectDispOrderByBranchNoAndDay(String branchNo,Date date);

    /**
     * 查询奶站下本日进货汇总金额
     * @param branchNo
     * @param date
     * @return
     */
    List<TDispOrder> getBranchEmpAmt(String branchNo,Date date);

    /**
     * 本日进货-送奶员金额
     * @param branchNo
     * @param date
     * @param empNo
     * @return
     */
    TDispOrder getBranchEmpAmtByEmpNo(String branchNo,Date date,String empNo);


}