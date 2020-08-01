package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Friends.FriendsDetails;

@XmlRootElement
public class Friends {
	
	private int userId;
	
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
	//Changing to use JWT
	/*public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
		
	}*/
}
