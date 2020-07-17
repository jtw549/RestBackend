package com.commerce.app.COMMERCE_Business.events.Comments;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.CreatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

public class CommentsAddedEvent extends CreatedEvent{
	 /* "status": "",
	    "message": "",
	    "comments": {
	        "commentId": "",
	        "userComment": "",
	        "postedDate": "",
	        "user": [
	            {
	                "userId": "",
	                "firstname: "",
	                "lastname": "",
	                "profilePicURL": ""
	            }
	        ]
	    }*/
	private final CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public CommentsAddedEvent(ArrayList<InventoryComments> inventoryComments) {
		CommentsDetails commentsDetails = new CommentsDetails();
		commentsDetails.toCommentsDetails(inventoryComments,commentsDetails);
		this.commentsDetails = commentsDetails;
	}
}
