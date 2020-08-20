package com.commerce.app.COMMERCE_Business.events.Comments;


public class AddCommentsEvent  {
	/*"comment": {
    "itemId": "",
    "userId": "",
    "userComment": ""
}*/
	private CommentsDetails commentsDetails;

	public CommentsDetails getCommentsDetails() {
		return commentsDetails;
	}
	
	public AddCommentsEvent(CommentsDetails commentsDetails) {
		this.commentsDetails = commentsDetails;
	}
}
