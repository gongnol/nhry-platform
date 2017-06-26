package com.nhry.common.service;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.nhry.utils.SysContant;
import com.nhry.utils.date.Date;

public class NhrySchedulerFactoryBean extends SchedulerFactoryBean {
	private static final String timer_execute_location = "_timer_execute_location";
	private static List<String> prd_execute_computes = null; // 正式环境机器节点
	private static List<String> test_execute_computes = null; // 测试环境机器节点
	private StringRedisTemplate stringRedisTemplate;
    
	static{
		prd_execute_computes = new ArrayList<String>();
		prd_execute_computes.add("ip-10-6-239-23");
		prd_execute_computes.add("ip-10-6-237-79");
		
		test_execute_computes = new ArrayList<String>();
		test_execute_computes.add("f84b4fa022e9");
	}
	
	public void init() {
		 if (File.separator.equals("/")) {  //linux系统
			    String key = stringRedisTemplate.opsForValue().get(timer_execute_location);
			    InetAddress netAddress = getInetAddress(); 
			    String hostName = getHostName(netAddress);
			    System.out.println("----------当前机器---hostName---------"+hostName);
			    if(StringUtils.isEmpty(hostName)){
			    	//获取不到当前的机器名，直接启动
			    	this.setAutoStartup(true);
					this.setStartupDelay(5);
			    }else{
			    	if(prd_execute_computes.contains(hostName)){
			    		//生产环境
			    		if(!StringUtils.isBlank(key)){
			    			String[] strs = key.split(";");
			    			Date d = new Date();
			    			if(Date.parseDate(strs[1]).addMinutes(20).compareTo(d) >= 0){
			    				//20分钟之内
			    				if(hostName.equals(strs[0])){
				    				//当前机器
			    					this.setAutoStartup(true);
			    					this.setStartupDelay(5);
			    					stringRedisTemplate.opsForValue().set(timer_execute_location, hostName+";"+new Date().toLongDate());
			    					System.out.println("----------定时任务启动---hostName---------"+hostName);
				    			}else{
				    				this.setAutoStartup(false);
				    			}
			    			}else{
			    				this.setAutoStartup(true);
		    					this.setStartupDelay(5);
		    					stringRedisTemplate.opsForValue().set(timer_execute_location, hostName+";"+new Date().toLongDate());
		    					System.out.println("----------定时任务启动---hostName---------"+hostName);
			    			}
			    		}else{
			    			this.setAutoStartup(true);
			    			stringRedisTemplate.opsForValue().set(timer_execute_location, hostName+";"+new Date().toLongDate());
			    			System.out.println("----------定时任务启动---hostName---------"+hostName);
			    		}
			    	}/*else if(test_execute_computes.contains(hostName)){
			    		//测试环境
			    		this.setAutoStartup(true);
    					this.setStartupDelay(5);
    					System.out.println("----------定时任务启动---hostName---------"+hostName);
			    	}*/else{
			    		this.setAutoStartup(true);
			    	}
			    }
		 }else{
			 //本地
			 if("true".equalsIgnoreCase(SysContant.getSystemConst("timer_execute_in_local"))){
				 this.setAutoStartup(true);
				 this.setStartupDelay(5);
			 }else{
				 this.setAutoStartup(false);
			 }
		 }
	}

	public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public String getHostName(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String name = netAddress.getHostName(); // get the host address
		return name;
	}

	public InetAddress getInetAddress() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("unknown host!");
		}
		return null;
	}
}
