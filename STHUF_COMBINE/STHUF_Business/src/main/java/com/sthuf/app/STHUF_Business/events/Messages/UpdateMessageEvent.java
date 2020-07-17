package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.UpdateEvent;

public class UpdateMessageEvent extends UpdateEvent{
	private  MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public UpdateMessageEvent (MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}
}
