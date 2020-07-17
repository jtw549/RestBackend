package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Users;

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
