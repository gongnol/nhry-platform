package com.nhry.common.service;

public class SysThread extends Thread {
	
	public SysThread(CommonService service,String threadName){
		this.threadName = threadName;
		this.service = service;
	}
	
    private String threadName;
    private CommonService service;
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.executeInThread(threadName);
	}
	
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public CommonService getService() {
		return service;
	}
	public void setService(CommonService service) {
		this.service = service;
	}
}
