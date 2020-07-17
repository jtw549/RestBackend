package com.commerce.app.COMMERCE_Business.events.Friends;

import com.commerce.app.COMMERCE_Domain.domain.Friends;

public class FriendsDetails {

	private int userId;
	
	private int friendId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public FriendsDetails toFriendsDetails(Friends friends) {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.setFriendId(friends.getFriendId());
		friendsDetails.setUserId(friends.getUserId());
		return friendsDetails;
	}
	
	public Friends fromFriendsDetails() {
		Friends friends = new Friends();
		friends.setFriendId(friendId);
		friends.setUserId(userId);
		return friends;
	}
}
