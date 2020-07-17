package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.UpdateEvent;


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
