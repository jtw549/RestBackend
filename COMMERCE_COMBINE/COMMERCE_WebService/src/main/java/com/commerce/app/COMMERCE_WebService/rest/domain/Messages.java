package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Messages.MessagesDetails;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement

public class Messages implements Serializable{
	
	//@ApiModelProperty(notes = "User gotten from login",name="userId",required=true,value="test user")
	private int userId;
	//@ApiModelProperty(notes = "User gotten from login",name="users",required=true,value="test user")
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
