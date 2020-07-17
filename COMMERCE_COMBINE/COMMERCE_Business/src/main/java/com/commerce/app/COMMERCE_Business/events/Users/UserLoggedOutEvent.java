package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.Users;

public class UserLoggedOutEvent extends ReadEvent{
	 /*  "status": "",
	    "message": "",
	    "home": {
	        ...
	    }*/
	private final UserDetails userDetails;

	public UserLoggedOutEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
}
