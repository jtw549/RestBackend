package com.sthuf.app.STHUF_Business.events.Messages;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.Messages;

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
