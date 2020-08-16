package com.commerce.app.COMMERCE_Domain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InventoryComments {
	
	@Id
	private int inventoryCommentId;
	
	private int inventoryId;
	
	private int userId;
	
	private String comment;
	
	private String commentDate;
	
	private int commenterUserId;
	
	public InventoryComments() {
		
	}

	public int getInventoryCommentId() {
		return inventoryCommentId;
	}

	public void setInventoryCommentId(int inventoryCommentId) {
		this.inventoryCommentId = inventoryCommentId;
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

	public int getCommenterUserId() {
		return commenterUserId;
	}

	public void setCommenterUserId(int commenterUserId) {
		this.commenterUserId = commenterUserId;
	}
}
