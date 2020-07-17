package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.Friends;

public class FriendsGottenEvent extends ReadEvent{
	/*"friends": {
    "count": 5,
    "data": [
        {
            "id": "9847AWN8R87WA9W8974",
            "fullName": "Curtis John",
            "profilePictureUrl": "",
            "profileUrl": "",
            "bio": "This is my bio",
            "counts": {
                "items": 100,
                "friends": 420
            },

        },
        ...
    ]
}*/
	
	private final FriendsDetails friendsDetails;

	public FriendsDetails getFriendsDetails() {
		return friendsDetails;
	}
	
	public FriendsGottenEvent(Friends friends) {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.toFriendsDetails(friends);
		this.friendsDetails = friendsDetails;
	}
}
