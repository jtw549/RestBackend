package com.commerce.app.COMMERCE_Business.events.Comments;

import com.commerce.app.COMMERCE_Business.events.DeleteEvent;

public class DeleteCommentsEvent extends DeleteEvent{
	/* "comments": [
	              {
	                  "commentId": ""
	              },
	              {
	                  "commentId": ""
	              }
	          ]*/
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public DeleteCommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
