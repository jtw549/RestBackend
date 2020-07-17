package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

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
