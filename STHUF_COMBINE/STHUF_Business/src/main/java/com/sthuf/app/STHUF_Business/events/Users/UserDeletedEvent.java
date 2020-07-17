package com.sthuf.app.STHUF_Business.events.Users;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.Users;

public class UserDeletedEvent extends DeletedEvent{
/*	{
	    "status": "",
	    "message": ""
	}*/
	private final UserDetails userDetails;
	 
	private boolean deletionCompleted;
	 
	public UserDeletedEvent(Users users) {
	UserDetails userDetails = new UserDetails();
	userDetails.toUserDetails(users,userDetails);
	this.userDetails = userDetails;
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	 
	public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
