package com.commerce.app.COMMERCE_WebService.rest.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Friends.FriendsDetails;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Friends {
	
	@ApiModelProperty(notes = "User Id",name="userId",required=true,value="test user Id")
	private int userId;
	@ApiModelProperty(notes = "Friend Id",name="friendId",required=true,value="test friend Id")
	private int friendId;
	
	public FriendsDetails toFriendsDetails() {
		FriendsDetails friendsDetails = new FriendsDetails();
		friendsDetails.setFriendId(friendId);
		friendsDetails.setUserId(userId);
		return friendsDetails;
	}
	
	public Friends fromFriendsDetails(FriendsDetails friendsDetails) {
		Friends friends = new Friends();
		friends.friendId=friendsDetails.getFriendId();
		friends.userId=friendsDetails.getUserId();
		return friends;
	}
	//use JWT
}
