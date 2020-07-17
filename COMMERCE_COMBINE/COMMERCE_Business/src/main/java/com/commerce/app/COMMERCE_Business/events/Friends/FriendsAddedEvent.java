package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.Friends;

public class FriendsAddedEvent extends CreatedEvent{
	/*{
	    "status": "",
	    "message": ""
	}*/
	
	private final FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public FriendsAddedEvent(Friends friends) {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.toFriendsDetails(friends);
		this.friendsDetails = friendsDetails;
	}
}
