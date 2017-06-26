package com.nhry.data.basic.domain;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/10/24.
 * 订单日志
 */
public class OrderLogEnum implements Serializable {
    //public final static  String CREATE_ORDER = "创建订单";
    public final static  String MEMO_TXT = "备注";
    public final static  String ADD_PRODUCT = "新增产品";
    public final static  String CHANGE_PRODUCT = "变更品种";
    public final static  String CHANGE_PRODUCT_QTY_RULE = "变更品种、数量和配送日期";
    public final static  String CHANGE_PRODUCT_QTY= "变更品种和数量";
    public final static  String CHANGE_PRODUCT_RULE= "变更品种和配送日期";
    public final static  String CHANGE_QTY_RULE = "变更数量和配送日期";
    public final static  String CHANGE_QTY = "变更数量";
    public final static  String CHANGE_RULE_TYPE = "变更周期";
   // public final static  String CHANGE_RULE = "变更配送规律";
    public final static  String ORDER_ITEM_STOP = "行项目停订";
   public final static  String LONG_STOP_ORDER = "长期停订";
    public final static  String STOP_ORDER = "短期停订";
    public final static  String BACK_ORDER = "退订";
    public final static  String RESUME_ORDER = "复订";
    public final static  String DH_BACK_ORDER = "电商退订";
    public final static  String JG_BACK_ORDER = "机构订奶退订";
    public final static  String YEAR_CARD_BACK_ORDER = "年卡退订";
    public final static  String YEAR_CARD_BACK_ORDER_ADVANCE = "年卡提前退订";
    public final static  String DEL_ITEM = "删除";
    public final static  String CHANGE_EMP = "送奶员替换";
    public final static  String CTN_ORDER = "续订";
    public final static  String STATUS = "状态";
    public final static  String RETURN_ORDER = "退单";
    public final static  String RETURN_BACK_ORDER = "确认订单退回";
    public final static String REPLACE_BRANCH = "更换奶站";

}
