package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Messages.MessagesDetails;

@XmlRootElement

public class Messages implements Serializable{
	
	private int userId;
	
	private boolean newMessage;

	public MessagesDetails toMessagesDetails() {
		MessagesDetails messagesDetails = new MessagesDetails();
		
		return messagesDetails;
	}
	
	public Messages fromMessagesDetails(MessagesDetails messagesDetails) {
		Messages messages = new Messages();
		
		return messages;
	}
}
