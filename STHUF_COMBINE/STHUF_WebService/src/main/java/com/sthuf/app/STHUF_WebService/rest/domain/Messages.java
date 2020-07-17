package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.sthuf.app.STHUF_Business.events.Messages.MessagesDetails;

@XmlRootElement

public class Messages implements Serializable{
	private int position;
	
	private String formula;
	
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
	
	public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
	}
}
