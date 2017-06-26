package com.nhry.common.service;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContainerService implements ApplicationListener<ContextRefreshedEvent> {
    private List<CommonService> services;
    
    /**
     * 容器启动执行方法
     */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		if(event.getApplicationContext().getParent() == null){
			 for(CommonService service : services){
				  service.onContainerStartedExecute();
			 }
		}
	}
	
	public void setServices(List<CommonService> services) {
		this.services = services;
	}

}
