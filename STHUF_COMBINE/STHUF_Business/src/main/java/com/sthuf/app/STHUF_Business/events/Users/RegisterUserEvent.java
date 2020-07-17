package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

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
