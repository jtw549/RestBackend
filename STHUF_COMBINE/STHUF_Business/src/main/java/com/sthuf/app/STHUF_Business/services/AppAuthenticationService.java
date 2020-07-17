package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.AppAuth.AppAuthenticatedEvent;
import com.sthuf.app.STHUF_Business.events.AppAuth.AuthenticateAppEvent;

public interface AppAuthenticationService {

	public AppAuthenticatedEvent authenticateApp(AuthenticateAppEvent authenticateAppEvent);
	
	
}
