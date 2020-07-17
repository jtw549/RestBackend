package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Messages;

public class MessagesSentEvent extends CreatedEvent{
	/*"status": "",
    "message": ""*/
	private final MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public MessagesSentEvent (Messages messages) {
		MessagesDetails messagesDetails = new MessagesDetails();
		//messagesDetails
		this.messagesDetails = messagesDetails;
	}
}
