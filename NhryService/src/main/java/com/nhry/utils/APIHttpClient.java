package com.nhry.utils;

/**
 * Created by cbz on 7/13/2016.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.geronimo.mail.util.Base64Encoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class APIHttpClient {

	// 接口地址
	private static String apiURL = "http://test.nhry-dev.com/master/api/v1/dic/allTypeCodes";
	private Log logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	private HttpClient httpClient = null;
	private HttpPost method = null;
	private HttpGet getMethod = null;
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
			getMethod = new HttpGet(apiURL);
//			method.setHeader("appcode", "snapp");
//			String key = generateUuidKey();
//			String appkey = "TGT-173-FXAHtVfMil2tsI2793f2ggAaoAD4Crd5SeeS0HL3c06EKMhveH-SIAM";
//			method.setHeader("appkey", appkey);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//			String date = sdf.format(new Date());
//			System.out.println("--------"+date);
//			method.setHeader("timestamp", date);
//			//以下  010da99b8b994b5@94094f2eae 是秘钥
//			String encode = encodePassword("snapp" + appkey + date,"010da9@b8b994b5794094f2eae" + getSixpw(date));
//			method.setHeader("dh-token", encode);
			//以下是get方法示例,post方法是同样的方式
			/**
			 * 主要以下四个参数：appcode：系统标示
			 *                              appkey  随机码
			 *                              timestamp  时间戳
			 *                              dh-token 加密秘钥
			 * 
			 */
			getMethod = new HttpGet(apiURL);
			getMethod.setHeader("appcode", "snapp");
			String key = generateUuidKey();
			String appkey = "TGT-33-JajXJKKRODbnzqAPFv7NHOtcZWO3zfaLHNliXAgcyG3sqgItH3-SIAM";
			getMethod.setHeader("appkey", appkey);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = sdf.format(new Date());
			System.out.println("--------"+date);
			getMethod.setHeader("timestamp", date);
			//以下  010da99b8b994b5@94094f2eae 是秘钥
			String encode = encodePassword("snapp" + appkey + date,"010da9@b8b994b5794094f2eae" + getSixpw(date));
			getMethod.setHeader("dh-token", encode);
			getMethod.setHeader("ticketName", "SIAMTGT");
		}
	}

	public static String generateUuidKey() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}

	public static String encodePassword(String plainPassword, String salt) {
		MessageDigestPasswordEncoder encoder = new ShaPasswordEncoder(256);
		encoder.setIterations(2);
		return encoder.encodePassword(plainPassword, salt);
	}
	
	public static String getSixpw(String str) {
		StringBuffer sb = new StringBuffer();
		char y = str.charAt(3);
		char m = str.charAt(5);
		char d = str.charAt(7);
		char h = str.charAt(9);
		char mi = str.charAt(11);
		char s = str.charAt(13);
		return sb.append(y).append(m).append(d).append(h).append(mi).append(s)
				.toString();
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
				method.addHeader("Content-type",
						"application/json; charset=utf-8");
				method.setHeader("Accept", "application/json");
				StringEntity se = new StringEntity(parameters,
						Charset.forName("UTF-8"));
				se.setContentEncoding("UTF-8");
				se.setContentType("application/json");
				method.setEntity(se);
				startTime = System.currentTimeMillis();
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
			}
		}
		return body;
	}

	public String httpGet() {
		String body = null;
		try {
			method.addHeader("Content-type", "text/plain; charset=utf-8");
			method.setHeader("Accept", "text/plain");
			startTime = System.currentTimeMillis();
			HttpResponse response = httpClient.execute(getMethod);

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
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}

	public static void main(String[] args) {
		APIHttpClient ac = new APIHttpClient(
				"http://127.0.0.1:8082/NhryService/api/v1/dic/allTypeCodes");
		System.out.println(ac.httpGet());
//		ac.post("{\"order\":{\"orderNo\":\"00160600000257\",\"orderType\":\"10\",\"endDate\":null,\"paymentmethod\":\"10\",\"preorderSource\":\"10\",\"onlineorderNo\":\"PT00160600000257\",\"branchNo\":\"0001\",\"branchTel\":null,\"branchName\":null,\"customerTel\":null,\"milkmemberNo\":\"7a232ddecc554f92a8a69a7330472866\",\"memberNo\":\"7a232ddecc554f92a8a69a7330472866\",\"paymentStat\":\"20\",\"milkboxStat\":\"30\",\"initAmt\":\"1000\",\"curAmt\":null,\"dispLineNo\":null,\"empNo\":null,\"empName\":null,\"adressNo\":\"2942c6773660413bb1874ef7b6d6119b\",\"createrNo\":null,\"createrBy\":null,\"preorderStat\":\"20\",\"memoTxt\":\"safasfdsffffffffffff\",\"payMethod\":\"10\",\"solicitNo\":null,\"solicitDate\":null,\"retDate\":null,\"retReason\":null,\"stopDateStart\":null,\"stopDateEnd\":null,\"stopDateStartStr\":null,\"stopDateEndStr\":null,\"solicitBy\":null,\"stopReason\":null,\"solicitorNo\":null,\"deliveryType\":\"20\"},\"entries\":[{\"orderNo\":\"00160600000257\",\"itemNo\":\"1\",\"orderDate\":null,\"refItemNo\":\"1\",\"matnr\":\"000000000050000052\",\"matnrTxt\":\"新希望屋顶盒澳特兰高品牛奶950ml\",\"unit\":\"瓶\",\"qty\":\"1\",\"salesPrice\":\"1\",\"itemamount\":\"1000\",\"ruleType\":\"10\",\"dispdays\":null,\"gapDays\":\"0\",\"ruleText\":null,\"reachTimeType\":\"10\",\"startDispDateStr\":\"2016-07-11\",\"endDispDateStr\":\"2016-10-14\",\"promotion\":null,\"promdays\":null,\"status\":\"10\",\"buyqty\":null,\"giftqty\":null}],\"address\":null}");
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
