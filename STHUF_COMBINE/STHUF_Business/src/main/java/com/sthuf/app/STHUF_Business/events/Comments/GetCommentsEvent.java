package com.sthuf.app.STHUF_Business.events.Comments;

import com.sthuf.app.STHUF_Business.events.ReadEvent;

public class GetCommentsEvent extends ReadEvent{
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public GetCommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
