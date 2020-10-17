package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Domain.domain.Friends;

public class FriendsEvent {
	/* "friends": {
    "userId": "",
    "friendId": ""
}*/
	private FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public FriendsEvent(FriendsDetails friendsDetails) {
		this.friendsDetails = friendsDetails;
	}
	
	/*public FriendsAddedEvent(Friends friends) {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.toFriendsDetails(friends);
		this.friendsDetails = friendsDetails;
	}*/
}
