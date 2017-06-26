package com.nhry.service.pi.impl;

import com.nhry.service.pi.dao.SmsSendService;
import com.nhry.service.pi.pojo.PIMessage;
import com.nhry.utils.CodeGeneratorUtil;
import com.nhry.utils.EnvContant;
import com.nhry.utils.PIPropertitesUtil;
import com.nhry.webService.client.PISuccessMessage;
import com.nhry.webService.client.sms.SmsStub;
import com.nhry.webService.client.sms.functions.Sms;
import com.nhry.webService.client.sms.functions.SmsResponse;
import org.apache.axis2.AxisFault;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cbz on 8/10/2016.
 */
public class SmsSendServiceImpl implements SmsSendService {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static String URL = EnvContant.getSystemConst("SMS.URL");
    private static String SPCODE = EnvContant.getSystemConst("SMS.SpCode");
    private static String LOGINNAME = EnvContant.getSystemConst("SMS.LoginName");
    private static String PASSWORD = EnvContant.getSystemConst("SMS.Password");

    public static void main(String []args){
        System.out.println(URL);
        System.out.println(SPCODE);
        System.out.println(LOGINNAME);
        System.out.println(PASSWORD);
    }
    private static Logger logger = Logger.getLogger(SmsSendServiceImpl.class);
    @Override
    public PIMessage sendMessage(String context, String tel) {
        PIMessage message = new PIMessage();
        try {
            SmsStub smsStub = new SmsStub(URL);
            Sms sms = new Sms();
            sms.setIn0(SPCODE);
            sms.setIn1(LOGINNAME);
            sms.setIn2(PASSWORD);
            if (StringUtils.isEmpty(context)) {
                sms.setIn3("您的验证码为123456");
            } else {
                sms.setIn3(context);
            }
            sms.setIn4(tel);
            sms.setIn5(CodeGeneratorUtil.getCode());
            sms.setIn6("");
            sms.setIn7("1");
            SmsResponse response = smsStub.sms(sms);
            String res =  response.getOut();
            String[] ress = res.split("&");
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i=0;i<ress.length;i++){
                String s = ress[i];
                String[] r = s.split("=");
                map.put(r[0],r[1]);
            }
            if(map.containsKey("result")) {
                message.setSuccess("0".equals(map.get("result").toString()));
            }
            if(map.containsKey("description")) {
                message.setMessage(map.get("description").toString());
            }
            logger.info("$$$$$$$$$$$"+context);
        } catch (Exception e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return message;
    }


}
