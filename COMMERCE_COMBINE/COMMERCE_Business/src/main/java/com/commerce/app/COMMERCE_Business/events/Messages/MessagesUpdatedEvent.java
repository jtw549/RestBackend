package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Messages;

public class MessagesUpdatedEvent extends UpdatedEvent{
	private final MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public MessagesUpdatedEvent (Messages messages) {
		MessagesDetails messagesDetails = new MessagesDetails();
		//messagesDetails
		this.messagesDetails = messagesDetails;
	}
}
