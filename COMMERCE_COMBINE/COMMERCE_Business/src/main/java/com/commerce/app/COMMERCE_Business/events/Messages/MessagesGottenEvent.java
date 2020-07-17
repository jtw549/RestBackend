package com.commerce.app.COMMERCE_Business.events.Messages;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.Messages;

public class MessagesGottenEvent extends ReadEvent{
	 /*"status": "",
	    "message": "",
	    "messages": [
	        {
	            "messageId": "",
	            "userMessage": "",
	            "user": {
	                "userId": "",
	                "firstName": "",
	                "lastName": "",
	                "profilePicURL": ""
	            }
	        },
	        ...
	    ]*/
	
	private final MessagesDetails messagesDetails;

	public MessagesDetails getMessagesDetails() {
		return messagesDetails;
	}
	
	public MessagesGottenEvent (Messages messages) {
		MessagesDetails messagesDetails = new MessagesDetails();
		//messagesDetails
		this.messagesDetails = messagesDetails;
	}
}
