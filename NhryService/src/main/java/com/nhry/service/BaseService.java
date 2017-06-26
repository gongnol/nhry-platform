package com.nhry.service;

import com.nhry.common.auth.UserSessionService;

public class BaseService {
    
	protected UserSessionService userSessionService;

	public void setUserSessionService(UserSessionService userSessionService) {
		this.userSessionService = userSessionService;
	}
}
