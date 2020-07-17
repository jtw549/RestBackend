package com.commerce.app.COMMERCE_WebService.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;
import com.commerce.app.COMMERCE_Business.services.AppAuthenticationService;
import com.commerce.app.COMMERCE_Business.services.MessagesService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Friends;
import com.commerce.app.COMMERCE_WebService.rest.domain.Messages;

@Controller
@RequestMapping("/api/action/messages")
public class MessagesController {
	
	private static Logger LOG = LoggerFactory.getLogger(MessagesController.class);
	@Autowired
	private MessagesService messagesService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/sendMessage",method = RequestMethod.POST)
	public ResponseEntity<Messages> sendMessage(@RequestBody Messages messages, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(messages.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Messages>(messages, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
	
	@RequestMapping(value="/getMessage",method = RequestMethod.GET)
	public ResponseEntity<Messages> getMessage(@RequestBody Messages messages, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(messages.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Messages>(messages, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
	
	@RequestMapping(value="/deleteConversation",method = RequestMethod.DELETE)
	public ResponseEntity<Messages> deleteConversation(@RequestBody Messages messages, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(messages.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Messages>(messages, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
}
