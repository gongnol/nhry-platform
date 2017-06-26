package com.nhry.data.milk.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milk.domain.TDispOrder;
import com.nhry.data.milk.domain.TDispOrderItem;
import com.nhry.data.milk.domain.TDispOrderItemKey;
import com.nhry.data.milktrans.domain.TRecBotDetail;
import com.nhry.model.milk.RouteDetailUpdateModel;
import com.nhry.model.milk.RouteOrderSearchModel;
import com.nhry.model.milktrans.DispOrderReportEntityModel;
import com.nhry.model.milktrans.DispOrderReportModel;
import com.nhry.model.milktrans.UnDeliverProductSearch;
import com.nhry.service.milk.pojo.TDispOrderChangeItem;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TDispOrderItemMapper {
	 int deleteDispOrderItemByOrderNo(List<String> codeList); 
	
	 PageInfo selectRouteDetailsByPage(RouteOrderSearchModel smodel);
	 
	 List selectRouteDetails(String routeCode);

    List selectRouteDetailsAllforDeliver(String routeCode);
	
    int deleteByPrimaryKey(TDispOrderItemKey key);
    //判断当天日订单是否已经产生路单
    List<TDispOrderItem> selectItemsByOrgOrderAndItemNo(String orderNo, String itemNo, Date date);
    
    int insert(TDispOrderItem record);

    List<TDispOrderItem> selectItemsByKeys(TDispOrderItemKey record);

    List<TDispOrderItem> selectDispItemsByKeyForDeliver(TDispOrderItemKey record);

    List<TDispOrderItem> selectNotDeliveryItemsByKeys(String code);
    
    List<TDispOrderChangeItem> selectDispItemsChange(String yestoday,String today,String orderNo,String dispEmp,String reachTimeType);

    int updateByPrimaryKeySelective(TDispOrderItem record);

    int updateDispOrderItem(RouteDetailUpdateModel record,TDispOrderItem entry,Map<String,String>productMap);
    
    int batchinsert(List<TDispOrderItem> records);
    
    List<TDispOrderItem> selectItemsByConfirmed();

    TDispOrderItem selectDispOrderItemByKey(TDispOrderItemKey code);

    PageInfo searchUndeliverProduct(UnDeliverProductSearch uSearch);

    List<TDispOrderItem> selectItemsByOrderNo(String dispOrderNo);

    List<TRecBotDetail> createRecBotByDispOrder(String dispOrderNo);
    
    int updateDispOrderItemEmp(TDispOrder order);
    
    int selectCountOfTodayByOrgOrder(String orgOrderNo, Date dispDate);

    //查询 该订单下生成的路单数 非确认的
    int selectDispOrderNumByPreOrderNo(String orderNo);
    //查询 该订单下生成的路单数
    int selectCountByOrgOrder(String orderNo);

    //查询 该订单下生成的路单数
    int selectCountByOrgOrderAndDate(String orderNo,Date date);
    //查询该行该日期是否有路单
    int selectCountByOrgOrderAndOrgItemNo(String orderNo,String itemNo,String dispDate);

    List<DispOrderReportEntityModel> reportDispOrderItemByParams(DispOrderReportModel model);

    List<TDispOrderItem> selectItemsByOrgOrderAndItemNoAndBeforeDate(TDispOrderItem dispItem);
    //该订单下是否有未确认生成的路单产生
    int selectCountsByOrderNo(String orderNo);

    //判断订单中的赠品是否已经产生路单
    List<TDispOrderItem> selectItemsByOrgOrderByProm(String orderNo);

}