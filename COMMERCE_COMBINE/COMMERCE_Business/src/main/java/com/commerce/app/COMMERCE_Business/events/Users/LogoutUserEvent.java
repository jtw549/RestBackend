package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class LogoutUserEvent extends ReadEvent{
/*	 "user": {
    "userId": ""
}*/
	
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public LogoutUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
