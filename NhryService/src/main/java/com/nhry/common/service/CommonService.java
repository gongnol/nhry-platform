package com.nhry.common.service;

/**
 * 公用服务类
 * 
 * @author Administrator
 * 
 */
public abstract class CommonService {
	/**
	 * 容器启动之后时候执行
	 */
	public abstract void onContainerStartedExecute();

	/**
	 * 启动新线程执行
	 */
	public void startNewThreadExecute(String... threadNames) {
		for(String name : threadNames){
			new SysThread(this,name).start();
		}
	}
	
	/**
	 * 在线程中执行
	 */
	public void executeInThread(String threadName) {
		
	}
}
