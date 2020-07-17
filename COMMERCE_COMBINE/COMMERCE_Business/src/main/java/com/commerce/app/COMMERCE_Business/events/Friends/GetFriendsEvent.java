package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetFriendsEvent extends ReadEvent{
/*	 "friends": {
    "userId": ""
}*/
	
	private FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public GetFriendsEvent(FriendsDetails friendsDetails) {
		this.friendsDetails = friendsDetails;
	}
}
