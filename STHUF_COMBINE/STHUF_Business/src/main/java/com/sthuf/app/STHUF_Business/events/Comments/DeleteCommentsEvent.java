package com.sthuf.app.STHUF_Business.events.Comments;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

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
