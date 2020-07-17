package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Business.events.CreateEvent;

public class AddFriendsEvent extends CreateEvent{
	/* "friends": {
    "userId": "",
    "friendId": ""
}*/
	private FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public AddFriendsEvent(FriendsDetails friendsDetails) {
		this.friendsDetails = friendsDetails;
	}
}
