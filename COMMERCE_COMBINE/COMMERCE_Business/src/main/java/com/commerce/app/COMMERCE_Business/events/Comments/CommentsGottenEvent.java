package com.commerce.app.COMMERCE_Business.events.Comments;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

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
