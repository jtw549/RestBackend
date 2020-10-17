package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.sharedEvent;

public class MessageEvent extends sharedEvent{
	/* "message": {
    "userId": ""
}*/
	private MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public MessageEvent (MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}
	
	/*public MessagesDeletedEvent (Messages messages) {
		MessagesDetails messagesDetails = new MessagesDetails();
		//messagesDetails2
		this.messagesDetails = messagesDetails;
	}*/
}
