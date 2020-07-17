package com.sthuf.app.STHUF_Business.events.Friends;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.Friends;

public class FriendsRemovedEvent extends DeletedEvent{
	/* "status": "",
	    "message": ""*/
	
	
	private final FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public FriendsRemovedEvent(Friends friends) {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.toFriendsDetails(friends);
		this.friendsDetails = friendsDetails;
	}
}
