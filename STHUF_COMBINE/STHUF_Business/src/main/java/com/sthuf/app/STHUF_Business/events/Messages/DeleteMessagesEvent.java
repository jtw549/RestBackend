package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

public class DeleteMessagesEvent extends DeleteEvent{
	
	private MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public DeleteMessagesEvent (MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}
}
