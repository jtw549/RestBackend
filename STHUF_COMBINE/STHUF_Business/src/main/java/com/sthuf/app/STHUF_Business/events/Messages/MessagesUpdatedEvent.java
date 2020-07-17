package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.UpdatedEvent;
import com.sthuf.app.STHUF_Domain.domain.Messages;

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
