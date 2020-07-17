package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.Users;

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
