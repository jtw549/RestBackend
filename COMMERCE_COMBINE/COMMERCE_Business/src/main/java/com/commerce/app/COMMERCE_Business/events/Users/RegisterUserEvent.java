package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.CreateEvent;

public class RegisterUserEvent extends CreateEvent{
	/*{
	    "user": {
	        "firstName": "",
	        "lastName": "",
	        "email": "",
	        "metaPsd": "",
	        "bio": ""
	    }
	}*/
	
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public RegisterUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
