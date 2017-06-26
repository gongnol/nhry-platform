package com.nhry.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

/**
 * 环境变量工具类
 * @author Administrator
 */
public class EnvContant {
	private static final String APP_PROD_CONFIG = "env/app-prod.xml";
	private static final String APP_TEST_CONFIG = "env/app-test.xml";
	private static final String APP_DEV_CONFIG = "env/app-dev.xml";
	private static final String APP_CONFIG = "env/app.xml";
	static Logger log = Logger.getLogger(EnvContant.class);
	private static Map<String, String> configs = new HashMap<String, String>();
	private static final String SYS_INTEGRATION_MODE="product/test";  //系统集成环境
	private static final String SYS_LOCAL_MODE="develope";		//系统本地开发环境

	static {
		try {
			SAXReader read = new SAXReader();
			String appEnvConfig = APP_DEV_CONFIG;
			if (SYS_INTEGRATION_MODE.contains(SysContant.getSystemConst("app_mode"))) {
				//服务器环境
				appEnvConfig = APP_CONFIG;
			}else if(SYS_LOCAL_MODE.contains(SysContant.getSystemConst("app_mode"))){
				//本地环境
				appEnvConfig = APP_DEV_CONFIG;
			}
			// 获取根下面的 config,xml文件 进行加载读取
			InputStream inputstream = EnvContant.class.getClassLoader()
					.getResourceAsStream(appEnvConfig);
			List<Element> eleconfigs = read.read(inputstream).getRootElement()
					.elements("config");
			for (Element ele : eleconfigs) {
				String key = ele.attributeValue("key");
				String value = ele.attributeValue("value");
				configs.put(key, value);
			}
		} catch (Exception ex) {
			log.error(ex);
			ex.printStackTrace();
		}
	}

	public static String getSystemConst(String key) {
		String val = configs.get(key);
		if (val != null) {
			return val.trim();
		}
		return null;
	}

	public static String getIdmLoginPage(String remoteIp) {
		if(org.apache.commons.lang3.StringUtils.isEmpty(remoteIp)){
			return getSystemConst("authurl") + "?client_id="
					+ getSystemConst("client_id") + "&redirect_uri="
					+ getSystemConst("redirect_uri") + "&response_type="
					+ getSystemConst("response_type");
		}else{
			return getSystemConst("authurl") + "?client_id="
					+ getSystemConst("client_id") + "&redirect_uri="
					+ getSystemConst("redirect_uri") + "?id="+Base64Util.encodeStr(remoteIp)+"&response_type="
					+ getSystemConst("response_type");
		}
	}

	public static void main(String[] args) {
		System.out.println(getSystemConst("PI.MasterData.URL"));
	}

}
