package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;

public interface AppAuthenticationService {

	public AppAuthenticatedEvent authenticateApp(AuthenticateAppEvent authenticateAppEvent);
	
	
}
