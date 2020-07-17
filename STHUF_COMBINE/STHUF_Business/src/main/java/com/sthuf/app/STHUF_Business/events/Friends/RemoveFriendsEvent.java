package com.sthuf.app.STHUF_Business.events.Friends;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

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
