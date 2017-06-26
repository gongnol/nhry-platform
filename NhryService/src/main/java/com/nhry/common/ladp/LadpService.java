package com.nhry.common.ladp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nhry.data.auth.dao.TSysUserMapper;
import com.nhry.data.auth.domain.TSysUser;
import com.nhry.service.auth.dao.UserService;
import com.nhry.utils.EnvContant;
import com.nhry.utils.date.Date;

public class LadpService {
	private UserService userService;

	DirContext ctx = null;

	public boolean init() {
		boolean flag = false;
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, EnvContant.getSystemConst("ladp_url"));
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL,EnvContant.getSystemConst("ladp_uname"));
		env.put(Context.SECURITY_CREDENTIALS,EnvContant.getSystemConst("ladp_password"));
		env.put("com.sun.jndi.ldap.connect.pool", "false");
		try {
			ctx = new InitialDirContext(env);
			flag = true;
			// System.out.println("authentication success");
		} catch (javax.naming.AuthenticationException e) {
			System.out.println("failed1 " + e);
		} catch (NamingException e) {
			System.out.println("failed2 " + e);
		}
		return flag;
	}

	public List<Map<String, String>> getObjectsByFilter(String basedn,
			String filter) throws NamingException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		NamingEnumeration<SearchResult> answer = search(basedn, filter);
		if(answer == null){
			return list;
		}
		while (answer.hasMoreElements()) {
			Map<String, String> atrVals = new HashMap<String, String>();
			SearchResult sr = (SearchResult) answer.next();// 得到符合搜索条件的DN
			String dn = sr.getName();
			Attributes Attrs = sr.getAttributes();// 得到符合条件的属性集
			if (Attrs != null) {
				try {
					for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
						Attribute Attr = (Attribute) ne.next();// 得到下一个属性
						// 读取属性值
						StringBuffer sb = new StringBuffer();
						for (NamingEnumeration e = Attr.getAll(); e.hasMore();) {
							String value = e.next().toString();
							sb.append(value).append(";");
						}
						if (sb.length() > 1) {
							sb.deleteCharAt(sb.length() - 1);
							atrVals.put(Attr.getID().toString(), sb.toString());
						}
					}
				} catch (NamingException e) {
					System.err.println("Throw Exception : " + e);
				}
			}
			if (atrVals.size() > 0) {
				list.add(atrVals);
			}
		}
		return list;
	}

	public NamingEnumeration<SearchResult> search(String basedn, String s) {
		// 设置返回的属性，可以使用*来返回大部份的属性值，但如
		String[] attrs = { "*" };
		NamingEnumeration<SearchResult> en = null;
		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			constraints.setReturningAttributes(attrs);
			init();
			en = ctx.search(basedn, s, constraints);
		} catch (Exception e) {
			System.out.println("Exception in search():" + e);
		}
		return en;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void convertToObject(Map<String, String> atrs, Object o,Map<String,String> spcAttrs) {
		try {
			for (String attr : atrs.keySet()) {
				String _attr = attr.replace("_", "").replace("-", "").toUpperCase();
				Field[] fields = o.getClass().getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					String fieldName = fields[i].getName();
					if (fieldName.toUpperCase().equals(_attr)) {
						String firstLetter = fieldName.substring(0, 1).toUpperCase();
						String setter = "set" + firstLetter + fieldName.substring(1);
						Method method = o.getClass().getMethod(setter,fields[i].getType());
						Object val = null;
						if (fields[i].getType().getName().equals("java.lang.String")) {
							val = atrs.get(attr);
						} else if (fields[i].getType().getName().equals("java.util.Date")) {
							val = Date.parseDate(atrs.get(attr));
						}
						method.invoke(o, val);
					}
				}
				if (spcAttrs.get(_attr) != null) {
					Method method = o.getClass().getMethod(spcAttrs.get(_attr), String.class);
					method.invoke(o, atrs.get(attr));
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步系统用户
	 */
	public boolean syncSysUsers(boolean isCompletely){
		try {
			Date date = new Date();
			DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssZ");  
			String dateStr = formatter.format(date.addMinutes(-60));  //60分钟之前
			String filter = "(&(|(modifyTimestamp>="+dateStr+")(createTimestamp>="+dateStr+"))(smart-authority="+EnvContant.getSystemConst("ladp_dh_auth")+"))";
			if(isCompletely){
				filter = "(smart-authority="+EnvContant.getSystemConst("ladp_dh_auth")+")";
			}
			List<Map<String, String>> list = getObjectsByFilter(EnvContant.getSystemConst("ladp_basedn"),filter);
			Map<String,String> spcAttrs = new HashMap<String,String>();
			spcAttrs.put("CN","setDisplayName");
			spcAttrs.put("UID","setLoginName");
			for (Map<String, String> atrs : list) {
				TSysUser u = new TSysUser();
				convertToObject(atrs, u, spcAttrs);
				userService.addUser(u);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 增量同步用户
	 */
	public void syncSysUsersForUpt(){
		syncSysUsers(false);
	}
	
	public static void main(String[] args) {
		String[] xmls = new String[]{ "classpath:beans/spring-context.xml","classpath:beans/dataSource.xml","classpath:beans/*-bean.xml"  };
        ApplicationContext context = new ClassPathXmlApplicationContext(xmls);
        LadpService ladpService = (LadpService)context.getBean("ladpService");
        ladpService.syncSysUsers(false);
	}
}
