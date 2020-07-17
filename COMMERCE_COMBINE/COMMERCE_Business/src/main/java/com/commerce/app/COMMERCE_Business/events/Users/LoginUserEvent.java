package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class LoginUserEvent extends ReadEvent{
	/*"user": {
    "email": "",
    "metaPsd": ""
}*/
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public LoginUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
