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
import com.commerce.app.COMMERCE_Business.services.FriendsService;
import com.commerce.app.COMMERCE_WebService.rest.domain.Friends;
import com.commerce.app.COMMERCE_WebService.rest.domain.InventoryComments;

@Controller
@RequestMapping("/api/action/friends")
public class FriendController {

	private static Logger LOG = LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	private FriendsService friendsService;
	@Autowired
    private AppAuthenticationService appAuthenticationService;
	
	@RequestMapping(value="/addFriend",method = RequestMethod.POST)
	public ResponseEntity<Friends> addFriend(@RequestBody Friends friends, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(friends.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Friends>(friends, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
	
	@RequestMapping(value="/deleteFriend",method = RequestMethod.DELETE)
	public ResponseEntity<Friends> deleteFriend(@RequestBody Friends friends, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(friends.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Friends>(friends, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
	
	@RequestMapping(value="/getFriends",method = RequestMethod.GET)
	public ResponseEntity<Friends> getFriends(@RequestBody Friends friends, UriComponentsBuilder builder) {
		AppAuthenticatedEvent appAuthenticatedEvent =appAuthenticationService.authenticateApp(new AuthenticateAppEvent(friends.appVerify()));
    	boolean appAllowed = appAuthenticatedEvent.isClientAllowed();
    	if (false == appAllowed) {
    		return new ResponseEntity<Friends>(friends, HttpStatus.FORBIDDEN);
    	}
		
		return null;
		
	}
}
