package com.sthuf.app.STHUF_Business.events.Comments;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryComments;

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
