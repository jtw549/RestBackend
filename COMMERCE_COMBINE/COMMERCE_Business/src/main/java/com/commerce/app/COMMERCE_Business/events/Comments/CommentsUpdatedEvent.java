package com.commerce.app.COMMERCE_Business.events.Comments;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

public class CommentsUpdatedEvent extends UpdatedEvent{
	private final CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public CommentsUpdatedEvent(InventoryComments inventoryComments) {
		CommentsDetails commentsDetails = new CommentsDetails();
		commentsDetails.toCommentsDetails(inventoryComments,commentsDetails);
		this.commentsDetails = commentsDetails;
	}
}
