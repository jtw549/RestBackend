package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Domain.domain.Users;

public class UserAccountInfoGottenEvent {
/*	"status": "",
    "message": "",
    "user": {
        "userId": "",
        "firstName": "",
        "lastName": "",
        "email": "",
        "bio": "",
        "counts": [
            {
                "items": "",
                "selling": "",
                "friends": ""
            }
        ],
        "privacy": "public"
    }*/
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public UserAccountInfoGottenEvent(Users users) {
		UserDetails userDetails = new UserDetails();
		userDetails.toUserDetails(users,userDetails);
		this.userDetails = userDetails;
	}
}
