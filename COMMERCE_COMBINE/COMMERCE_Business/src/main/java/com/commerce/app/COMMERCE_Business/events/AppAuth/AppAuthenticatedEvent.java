package com.commerce.app.COMMERCE_Business.events.AppAuth;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class AppAuthenticatedEvent extends ReadEvent{

	private boolean clientAllowed = false;
	
	public boolean isClientAllowed() {
		return clientAllowed;
	}

	public AppAuthenticatedEvent(boolean clientAllowed) {
	this.clientAllowed = clientAllowed;
}
}
