package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;


public class UpdateUserEvent extends UpdateEvent{
/*	 "user": {
    "userId": "3489EAGFOJG489UPGAJREP",
    ...
}*/
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public UpdateUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
