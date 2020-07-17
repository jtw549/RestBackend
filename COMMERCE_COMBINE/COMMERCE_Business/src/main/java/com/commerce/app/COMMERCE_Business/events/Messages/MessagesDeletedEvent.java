package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Messages;

public class MessagesDeletedEvent extends DeletedEvent{

	
	private final MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public MessagesDeletedEvent (Messages messages) {
		MessagesDetails messagesDetails = new MessagesDetails();
		//messagesDetails2
		this.messagesDetails = messagesDetails;
	}
}
