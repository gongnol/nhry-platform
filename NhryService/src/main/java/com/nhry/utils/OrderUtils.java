package com.nhry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单工具类
 * @author zhaoxijun
 * @date 2017年5月9日
 */
public class OrderUtils {
	public static String getCode(){
        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date())+(new Random().nextInt(89999)+10000);
    }
	
	public static String signFormat(String sign){
		if("10".equals(sign))return "在订";
        if("20".equals(sign))return "停订";
        if("30".equals(sign))return "退订";
        if("40".equals(sign))return "完结";
        return "";
	}
	
	public static String orderSourceFmt(String preorderSource, String promSubType){
		if("10".equals(preorderSource) )return "电商";
        if("20".equals(preorderSource))return "征订";
        if("Z017".equals(promSubType))return "年卡";
        if("30".equals(preorderSource) )return "奶站";
        if("40".equals(preorderSource))return "牛奶钱包";
        if("50".equals(preorderSource))return "送奶工App";
        if("60".equals(preorderSource))return "电话";
        if("70".equals(preorderSource))return "机构";
        return "";
	}
}
