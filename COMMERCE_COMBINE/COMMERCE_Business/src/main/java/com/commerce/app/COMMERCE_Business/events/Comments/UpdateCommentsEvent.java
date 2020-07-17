package com.commerce.app.COMMERCE_Business.events.Comments;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateCommentsEvent extends UpdateEvent{
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public UpdateCommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
