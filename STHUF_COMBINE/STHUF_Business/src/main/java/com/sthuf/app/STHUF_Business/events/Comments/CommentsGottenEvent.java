package com.sthuf.app.STHUF_Business.events.Comments;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryComments;

public class CommentsGottenEvent extends ReadEvent{
	private final CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public CommentsGottenEvent(InventoryComments inventoryComments ) {
		CommentsDetails commentsDetails = new CommentsDetails();
		commentsDetails.toCommentsDetails(inventoryComments,commentsDetails);
		this.commentsDetails = commentsDetails;
	}
}
