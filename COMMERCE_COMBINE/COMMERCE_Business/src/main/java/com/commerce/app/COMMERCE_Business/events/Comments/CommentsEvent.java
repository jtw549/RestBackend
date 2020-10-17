package com.commerce.app.COMMERCE_Business.events.Comments;


public class CommentsEvent  {
	/*"comment": {
    "itemId": "",
    "userId": "",
    "userComment": ""
}*/
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public CommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
