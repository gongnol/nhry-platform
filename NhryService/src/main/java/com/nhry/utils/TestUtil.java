package com.nhry.utils;

import com.nhry.model.webService.CustInfoModel;
import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gongjk on 2016/7/12.
 */
public class TestUtil {

    public static void main(String[] args){

        System.out.println(getYearMonth());
    }
    //获取date所在的年月 例如date是2016-07-26 返回201607
    public static JSONObject getYearMonth(){
        CustInfoModel custInfoModel = new CustInfoModel();
        custInfoModel.setProvince("12");
        custInfoModel.setCity("23");
        custInfoModel.setDistrict("34");

        Map<String,String> data = new HashMap<String,String>();
        data.put("province",custInfoModel.getProvince());
        data.put("city",custInfoModel.getCity());
        data.put("district",custInfoModel.getDistrict());
        JSONObject obj4 = new JSONObject(data);

        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("data",obj4);
        map3.put("serviceName","svcGetOrderBranch");
        JSONObject obj3 = new JSONObject(map3);

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("BussGetOrderBranch",obj3);
        JSONObject obj2 = new JSONObject(map2);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("businessno","BussGetOrderBranch");
        map.put("body",obj2);


        JSONObject obj = new JSONObject(map);

        return obj;
    }
}
