package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.CreatedEvent;
import com.sthuf.app.STHUF_Domain.domain.Users;

public class UserRegisteredEvent extends CreatedEvent{

	private final UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public UserRegisteredEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
}
