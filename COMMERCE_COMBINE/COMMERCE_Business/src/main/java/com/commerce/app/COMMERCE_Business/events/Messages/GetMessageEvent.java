package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetMessageEvent extends ReadEvent{
	/* "message": {
    "userId": ""
}*/
	private MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public GetMessageEvent (MessagesDetails messagesDetails) {
		this.messagesDetails = messagesDetails;
	}
}
