package com.nhry.webService.test;

/**
 * Created by cbz on 7/13/2016.
 */


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpAuthenticator;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class APIHttpClient {

    // 接口地址
    private static String apiURL = "http://test.nhry-dev.com/xiexiaojun/api/v1/order/create";
    private Log logger = LogFactory.getLog(this.getClass());
    private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
    private HttpClient httpClient = null;
    private HttpPost method = null;
    private long startTime = 0L;
    private long endTime = 0L;
    private int status = 0;

    /**
     * 接口地址
     *
     * @param url
     */
    public APIHttpClient(String url) {

        if (url != null) {
            this.apiURL = url;
        }
        if (apiURL != null) {
            httpClient = new DefaultHttpClient();
            method = new HttpPost(apiURL);

        }
    }

    /**
     * 调用 API
     *
     * @param parameters
     * @return
     */
    public String post(String parameters) {
        String body = null;
        logger.info("parameters:" + parameters);

        if (method != null & parameters != null
                && !"".equals(parameters.trim())) {
            try {

                // 建立一个NameValuePair数组，用于存储欲传送的参数
                method.addHeader("Content-type","application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");

                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
                startTime = System.currentTimeMillis();
                HttpAuthenticator au = new HttpAuthenticator();

                HttpResponse response = httpClient.execute(method);

                endTime = System.currentTimeMillis();
                int statusCode = response.getStatusLine().getStatusCode();

                logger.info("statusCode:" + statusCode);
                logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
                if (statusCode != HttpStatus.SC_OK) {
                    logger.error("Method failed:" + response.getStatusLine());
                    status = 1;
                }

                // Read the response body
                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {
                // 网络错误
                status = 3;
            } finally {
                logger.info("调用接口状态：" + status);
                httpClient.getConnectionManager().shutdown();
            }

        }
        return body;
    }

    public static void main(String[] args) {
        APIHttpClient ac = new APIHttpClient(apiURL);
        String param = "{\"order\":{\"orderNo\":\"00160600000999\",\"orderType\":\"10\",\"orderDate\":\"2016-06-08T14:41:56.000+0800\",\"endDate\":null,\"paymentmethod\":\"10\",\"preorderSource\":\"10\",\"onlineorderNo\":\"PT00160600000999\",\"branchNo\":\"001\",\"branchTel\":null,\"branchName\":\"川乳锦江区奶站1\",\"customerTel\":null,\"milkmemberNo\":\"7a232ddecc554f92a8a69a7330472866\",\"memberNo\":\"7a232ddecc554f92a8a69a7330472866\",\"paymentStat\":\"20\",\"milkboxStat\":\"30\",\"initAmt\":\"1000\",\"curAmt\":null,\"dispLineNo\":null,\"empNo\":\"546432\",\"empName\":null,\"adressNo\":\"2942c6773660413bb1874ef7b6d6119b\",\"createrNo\":null,\"createrBy\":null,\"preorderStat\":\"20\",\"memoTxt\":\"safasfdsffffffffffff\",\"payMethod\":\"10\",\"solicitNo\":null,\"solicitDate\":null,\"retDate\":null,\"retReason\":null,\"stopDateStart\":null,\"stopDateEnd\":null,\"stopDateStartStr\":null,\"stopDateEndStr\":null,\"solicitBy\":null,\"stopReason\":null,\"deliveryType\":\"20\",\"solicitorNo\":null},\"entries\":[{\"orderNo\":\"00160600000257\",\"itemNo\":\"1\",\"orderDate\":null,\"refItemNo\":\"1\",\"matnr\":\"000000000050000052\",\"matnrTxt\":\"新希望屋顶盒澳特兰高品牛奶950ml\",\"unit\":\"瓶\",\"qty\":\"2\",\"salesPrice\":\"1000\",\"itemamount\":\"1000\",\"ruleType\":\"10\",\"dispdays\":null,\"gapDays\":\"0\",\"ruleText\":null,\"reachTimeType\":\"10\",\"startDispDateStr\":\"2016-07-11T00:00:00.000+0800\",\"endDispDateStr\":\"2016-10-14T00:00:00.000+0800\",\"promotion\":\"20\",\"promdays\":null,\"status\":\"10\",\"buyqty\":null,\"giftqty\":null}]}";
        System.out.println(ac.post(param));
    }

    /**
     * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @return the endTime
     */
    public long getEndTime() {
        return endTime;
    }
}
