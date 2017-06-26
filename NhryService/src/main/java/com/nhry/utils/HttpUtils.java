package com.nhry.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class HttpUtils {
	private static Logger LOGGER = Logger.getLogger(HttpUtils.class);
	public static byte[] streamToByte(InputStream inputstream) throws Exception {
		byte bys[] = new byte[1024];
		int len = 0;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		while ((len = inputstream.read(bys)) != -1) {
			out.write(bys, 0, len);
		}
		return out.toByteArray();
	}

	public static String getLocalIpAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String request(String uri, Map<String, Object> params)
			throws IOException {
		return request(uri, params, "utf-8");
	}

	/**
	 * @param uri
	 * @param params
	 * @return
	 * @throws IOException
	 *             ����һ��http ���󷽷�Ϊpost
	 *
	 */
	public static String request(String uri, Map<String, Object> params,
			String encoding) throws IOException {
		System.setProperty("javax.net.ssl.trustStore", "/opt/java/jdk1.8.0_72/jre/lib/security/cacerts");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		long currentTime = System.currentTimeMillis();
		URL postUrl = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);

		connection.setRequestMethod("POST");

		connection.setUseCaches(false);

		connection.setInstanceFollowRedirects(true);

		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		StringBuffer content = new StringBuffer();
		Object[] arrays = params.entrySet().toArray();
		for (int index = 0; index < arrays.length; index++) {
			Entry<String, Object> value = (Entry<String, Object>) arrays[index];
			Object target = value.getValue();
			if (target instanceof Collection) {
				Object array[] = ((Collection) target).toArray();
				for (int i = 0; i < array.length; i++) {
					content.append(value.getKey() + "="
							+ URLEncoder.encode(array[i].toString(), encoding));
					if (i <= array.length - 1) {
						content.append("&");
					}
				}
				continue;
			} else {
				content.append(value.getKey()
						+ "="
						+ URLEncoder.encode(
								target == null ? "" : target.toString(),
								encoding));
			}

			if (index <= arrays.length - 1) {
				content.append("&");
			}
		}

		out.writeBytes(content.toString());
		out.flush();
		out.close();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String line;
		StringBuffer result = new StringBuffer();

		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		connection.disconnect();
		return result.toString();
	}

	public static byte[] request2(String uri, Map<String, Object> params,
			String encoding) throws IOException {
		long currentTime = System.currentTimeMillis();
		System.setProperty("javax.net.ssl.trustStore", "/opt/java/jdk1.8.0_72/jre/lib/security/cacerts");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		URL postUrl = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) postUrl
				.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);

		connection.setRequestMethod("POST");

		connection.setUseCaches(false);

		connection.setInstanceFollowRedirects(true);

		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.connect();
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		StringBuffer content = new StringBuffer();
		Object[] arrays = params.entrySet().toArray();
		for (int index = 0; index < arrays.length; index++) {
			Entry<String, Object> value = (Entry<String, Object>) arrays[index];
			Object target = value.getValue();
			if (target instanceof Collection) {
				Object array[] = ((Collection) target).toArray();
				for (int i = 0; i < array.length; i++) {
					content.append(value.getKey() + "="
							+ URLEncoder.encode(array[i].toString(), encoding));
					if (i <= array.length - 1) {
						content.append("&");
					}
				}
				continue;
			} else {
				content.append(value.getKey()
						+ "="
						+ URLEncoder.encode(
								target == null ? "" : target.toString(),
								encoding));
			}

			if (index <= arrays.length - 1) {
				content.append("&");
			}
		}

		out.writeBytes(content.toString());
		out.flush();
		out.close();
		InputStream input = connection.getInputStream();
		int len = 0;
		byte[] bs = new byte[2048];
		ByteArrayOutputStream outbyte = new ByteArrayOutputStream();
		while ((len = input.read(bs)) != -1) {
			outbyte.write(bs, 0, len);
		}
		connection.disconnect();
		return outbyte.toByteArray();
	}

	public static String idmAppPost(String url, String body) {
		try {
			URL restServiceURL = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("POST");
			httpConnection.setDoOutput(true);
			httpConnection.setRequestProperty("Content-Type","application/json");
			httpConnection.setRequestProperty("appcode",EnvContant.getSystemConst("idm_appcode"));
			httpConnection.setRequestProperty("appkey", "1234567890qweasd");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = sdf.format(new Date()) + "Z";
			httpConnection.setRequestProperty("timestamp", date);
			String encode = encodePasswordLtOne(EnvContant.getSystemConst("idm_appcode") + "1234567890qweasd" + date,EnvContant.getSystemConst("idm_salt"));
			httpConnection.setRequestProperty("encode", encode);
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(body.getBytes());
			outputStream.flush();
			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}
			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));
			String output = responseBuffer.readLine();
			httpConnection.disconnect();
			return output;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * sha256加密
	 * @param plainPassword  加密密码
	 * @param salt   原始字符串
	 * @return
	 */
	public static String encodePassword(String plainPassword, String salt) {
		MessageDigestPasswordEncoder encoder = new ShaPasswordEncoder(256);
		encoder.setIterations(2);
		return encoder.encodePassword(plainPassword, salt);
	}
	
	public static String encodePasswordLtOne(String plainPassword, String salt) {
		MessageDigestPasswordEncoder encoder = new ShaPasswordEncoder(256);
		return encoder.encodePassword(plainPassword, salt);
	}

	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			convertSuccess = false;
		}
		return convertSuccess;
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

	public static void main(String[] args) throws Exception {
		// String msg = HttpUtils.request(
		// "http://test.nhry-dev.com/xiexiaojun/api/v1/dic/items/1015",
		// new HashMap<String, Object>());
		// System.out.println(msg);
		// System.out.println(encodePassword("eca4495f3e9281a6120160805140156",
		// "012f88c17c2f4cf9bf9a96fc2e8f2760"));
//		idmAppPost2("/api/v1/dic/items/1006", body);
		encodePassword("dhxtTGT-5-JnWrTFuO5bUzanFpziJinAbOMEweDdcMHJdRmUHUADqem27iXl-SIAM", "01@da99b8b994b5794094f2eae689700");
	}
}
