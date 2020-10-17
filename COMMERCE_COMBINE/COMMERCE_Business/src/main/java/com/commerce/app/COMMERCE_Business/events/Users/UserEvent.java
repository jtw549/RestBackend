package com.commerce.app.COMMERCE_Business.events.Users;

import com.commerce.app.COMMERCE_Business.events.sharedEvent;
import com.commerce.app.COMMERCE_Domain.domain.LoginEverythingDomain;
import com.commerce.app.COMMERCE_Domain.domain.Users;

public class UserEvent extends sharedEvent{
	/*"user": {
    "email": "",
    "metaPsd": ""
}*/
	private UserDetails userDetails;
	private LoginEverythingDetails loginEverythingDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public UserEvent(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public UserEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
	
	public UserEvent(LoginEverythingDomain loginEverythingDomain) {
		LoginEverythingDetails loginEverythingDetails = new LoginEverythingDetails();
		loginEverythingDetails.toLoginEverythingDetails(loginEverythingDomain,loginEverythingDetails);
		this.setLoginEverythingDetails(loginEverythingDetails);
	}

	public LoginEverythingDetails getLoginEverythingDetails() {
		return loginEverythingDetails;
	}

	public void setLoginEverythingDetails(LoginEverythingDetails loginEverythingDetails) {
		this.loginEverythingDetails = loginEverythingDetails;
	}
	
}
