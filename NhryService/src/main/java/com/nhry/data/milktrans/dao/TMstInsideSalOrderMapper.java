package com.nhry.data.milktrans.dao;

import com.github.pagehelper.PageInfo;
import com.nhry.data.milktrans.domain.TMstInsideSalOrder;
import com.nhry.model.milktrans.InSideSalOrderSearchModel;

/**
 * Created by gongjk on 2016/6/30.
 */
public interface TMstInsideSalOrderMapper {
   public TMstInsideSalOrder getInSalOrderByDispOrderNo(String dispOrderNo);

   int insertInsideSalOrder(TMstInsideSalOrder sOrder);

   PageInfo getAuthAllInsideSalOrder(InSideSalOrderSearchModel sModel);


   int deleteInSalOrderByDispOrderNo(String insOrderNo);
}
