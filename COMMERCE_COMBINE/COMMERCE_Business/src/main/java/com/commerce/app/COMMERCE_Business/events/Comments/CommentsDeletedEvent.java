package com.commerce.app.COMMERCE_Business.events.Comments;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.DeletedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

public class CommentsDeletedEvent extends DeletedEvent{
	  /*"status": "",
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

	private boolean deletionCompleted;
	
	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public CommentsDeletedEvent(ArrayList<InventoryComments> inventoryComments) {
		CommentsDetails commentsDetails = new CommentsDetails();
		commentsDetails.toCommentsDetails(inventoryComments,commentsDetails);
		this.commentsDetails = commentsDetails;
	}
	
	 public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
