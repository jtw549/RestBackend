package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.CreatedEvent;
import com.sthuf.app.STHUF_Domain.domain.Messages;

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
