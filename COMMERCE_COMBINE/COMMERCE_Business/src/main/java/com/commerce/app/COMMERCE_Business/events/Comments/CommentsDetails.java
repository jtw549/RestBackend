package com.commerce.app.COMMERCE_Business.events.Comments;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryComments;

public class CommentsDetails {

	private int inventoryCommentsId;
	
	private int inventoryId;
	
	private int userId;
	
	private String comment;
	
	private String commentDate;
	
	private ArrayList<InventoryComments> inventoryCommentsList;
	
	public int getInventoryCommentsId() {
		return inventoryCommentsId;
	}

	public void setInventoryCommentsId(int inventoryCommentsId) {
		this.inventoryCommentsId = inventoryCommentsId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	public CommentsDetails toCommentsDetails(InventoryComments inventoryComments,CommentsDetails commentsDetails) {
		commentsDetails.setComment(inventoryComments.getComment());
		commentsDetails.setCommentDate(inventoryComments.getCommentDate());
		commentsDetails.setInventoryCommentsId(inventoryComments.getInventoryCommentId());
		commentsDetails.setInventoryId(inventoryComments.getInventoryId());
		commentsDetails.setUserId(inventoryComments.getUserId());
		return commentsDetails;
		
	}
	
	
	public CommentsDetails toCommentsDetails(ArrayList<InventoryComments> inventoryComments,CommentsDetails commentsDetails) {
		commentsDetails.setInventoryCommentsList(inventoryComments);
		return commentsDetails;
		
	}
	
	public InventoryComments fromCommentsDetails() {
		InventoryComments inventoryComments = new InventoryComments();
		inventoryComments.setComment(comment);
		inventoryComments.setCommentDate(commentDate);
		inventoryComments.setCommenterUserId(userId);
		inventoryComments.setInventoryCommentId(inventoryCommentsId);
		inventoryComments.setInventoryId(inventoryId);
		return inventoryComments;
		
	}

	public ArrayList<InventoryComments> getInventoryCommentsList() {
		return inventoryCommentsList;
	}

	public void setInventoryCommentsList(ArrayList<InventoryComments> inventoryCommentsList) {
		this.inventoryCommentsList = inventoryCommentsList;
	}
}
