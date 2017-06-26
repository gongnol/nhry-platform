package com.nhry.data.basic.domain;

import java.io.Serializable;

/**
 * Created by gongjk on 2016/10/31.
 * 路单 日志
 */
public class RouteLogEnum implements Serializable {
    public final  static String  DELETE_TOUTE= "路单删除";
    public final  static String  CREATE_TOUTE= "路单生成";
    public final  static String  CONFIRM_TOUTE= "路单确认";
    public final  static String  DISP_QTY= "送达数量";
    public final  static String  DISP_MATNR = "实送产品";
    public final  static String  CHANGE_REASON = "换货原因";
    public final  static String  UNDELIVERED_REASON = "未送达原因";
    public final  static String  DISP_EMP = "送奶员";
}
