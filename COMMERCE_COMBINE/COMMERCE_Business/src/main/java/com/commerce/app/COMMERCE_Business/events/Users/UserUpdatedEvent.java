package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Users;

public class UserUpdatedEvent extends UpdatedEvent{
/*	{
	    "status": "",
	    "message": ""
	}*/
	
	public UserDetails getUserDetails() {
		return userDetails;
	}

	private final UserDetails userDetails;

	public UserUpdatedEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
}
