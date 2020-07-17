package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteUserEvent extends DeleteEvent{
	/* "user": {
    "userId": "3489EAGFOJG489UPGAJREP",
    ...
}*/
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public DeleteUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
