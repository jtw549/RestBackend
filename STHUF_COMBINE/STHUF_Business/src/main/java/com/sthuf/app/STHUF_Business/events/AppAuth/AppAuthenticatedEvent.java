package com.sthuf.app.STHUF_Business.events.AppAuth;

import com.sthuf.app.STHUF_Business.events.ReadEvent;

public class AppAuthenticatedEvent extends ReadEvent{

	private boolean clientAllowed = false;
	
	public boolean isClientAllowed() {
		return clientAllowed;
	}

	public AppAuthenticatedEvent(boolean clientAllowed) {
	this.clientAllowed = clientAllowed;
}
}
