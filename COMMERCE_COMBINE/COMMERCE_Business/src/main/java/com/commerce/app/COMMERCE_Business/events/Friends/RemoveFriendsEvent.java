package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class RemoveFriendsEvent extends DeleteEvent{
	/* "friends": {
    "userId": "",
    "friendId": ""
}*/
	
	private FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public RemoveFriendsEvent(FriendsDetails friendsDetails) {
		this.friendsDetails = friendsDetails;
	}
}
