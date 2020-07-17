package com.sthuf.app.STHUF_Domain.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Friends {

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

	public Friends() {
		
	}
	
}
