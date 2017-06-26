package com.nhry.data.milk.dao;

import com.nhry.data.milktrans.domain.TMstRefuseResendItem;

import java.util.List;


/**
 * Created by gongjk on 2016/10/19.
 */
public interface TMstRefuseResendItemMapper {
    int addResendItem(TMstRefuseResendItem resendItem);

    List<TMstRefuseResendItem> selectItemByRequireOrder(String orderNo);

    int delResendItemByRequireOrderNoAndType(String orderNo,String type);

    TMstRefuseResendItem selectItemByReqorderAndNo(String reqOrderNo, String matnr);

    int uptResendItem(TMstRefuseResendItem oldResendItem);

    int delResendItemByReOrderNoAndResendOrderNo(String reqOrderNo, String resendOrderNo);
}
