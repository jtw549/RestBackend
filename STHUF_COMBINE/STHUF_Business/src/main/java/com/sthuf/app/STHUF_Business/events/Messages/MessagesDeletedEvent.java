package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.Messages;

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
