package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateMessageEvent extends UpdateEvent{
	private  MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public UpdateMessageEvent (MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}
}
