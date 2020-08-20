package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.sharedEvent;

public class LoginUserEvent extends sharedEvent{
	/*"user": {
    "email": "",
    "metaPsd": ""
}*/
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public LoginUserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	/*public UserUpdatedEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
	
	public UserLoggedInEvent(LoginEverythingDomain loginEverythingDomain) {
		LoginEverythingDetails loginEverythingDetails = new LoginEverythingDetails();
		loginEverythingDetails.toLoginEverythingDetails(loginEverythingDomain,loginEverythingDetails);
		this.loginEverythingDetails = loginEverythingDetails;
	}
	*/
}
