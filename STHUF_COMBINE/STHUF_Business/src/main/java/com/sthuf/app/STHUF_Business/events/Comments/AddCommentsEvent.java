package com.sthuf.app.STHUF_Business.events.Comments;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddCommentsEvent extends CreateEvent{
	/*"comment": {
    "itemId": "",
    "userId": "",
    "userComment": ""
}*/
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public AddCommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
