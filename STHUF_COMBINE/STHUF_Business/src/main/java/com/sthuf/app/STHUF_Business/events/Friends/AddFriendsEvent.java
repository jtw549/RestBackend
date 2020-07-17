package com.sthuf.app.STHUF_Business.events.Friends;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

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
