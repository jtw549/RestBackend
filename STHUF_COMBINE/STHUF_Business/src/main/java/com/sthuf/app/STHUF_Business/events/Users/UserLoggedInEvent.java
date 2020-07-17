package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.LoginEverythingDomain;

public class UserLoggedInEvent extends ReadEvent {
	/*	 "status": "",
	    "message": "",
	    "key": "",
	    "user": {
	        "userId": "",
	        "firstName": "",
	        "lastName": "",
	        "email": "",
	        "bio": "",
	        "privacy": "",
	        "counts": [
	            {
	                "items": "",
	                "selling": "",
	                "friends": ""
	            }
	        ],
	        "items": [
	            "--collection of items in getItems action--"
	        ]
	    }*/
	private final LoginEverythingDetails loginEverythingDetails;
	
	public LoginEverythingDetails getUserDetails() {
		return loginEverythingDetails;
	}
	
	public UserLoggedInEvent(LoginEverythingDomain loginEverythingDomain) {
		LoginEverythingDetails loginEverythingDetails = new LoginEverythingDetails();
		loginEverythingDetails.toLoginEverythingDetails(loginEverythingDomain,loginEverythingDetails);
		this.loginEverythingDetails = loginEverythingDetails;
	}
}
