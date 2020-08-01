package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Comments.CommentsDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@JsonAutoDetect
public class InventoryComments implements Serializable{

	@JsonProperty(value="inventoryCommentsId")
	private int inventoryCommentsId;
	
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	@JsonProperty(value="commentorUserId")
	private int commentorUserId;
	
	@JsonProperty(value="comment")
	private String comment;
	
	@JsonProperty(value="commentDate")
	private String commentDate;
	
	@JsonProperty(value="inventoryCommentsList")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> inventoryCommentsList;
	
	public CommentsDetails toCommentsDetails() {
		CommentsDetails commentsDetails = new CommentsDetails();
		commentsDetails.setComment(comment);
		commentsDetails.setCommentDate(commentDate);
		commentsDetails.setInventoryCommentsId(inventoryCommentsId);
		commentsDetails.setInventoryId(inventoryId);
		commentsDetails.setUserId(commentorUserId);
		return commentsDetails;
		
	}
	
	public InventoryComments fromCommentsDetails(CommentsDetails commentsDetails) {
		InventoryComments inventoryComments = new InventoryComments();
		inventoryComments.inventoryCommentsList = commentsDetails.getInventoryCommentsList();
		return inventoryComments;
		
	}


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

	public int getCommentorUserId() {
		return commentorUserId;
	}

	public void setCommentorUserId(int commentorUserId) {
		this.commentorUserId = commentorUserId;
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

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> getInventoryCommentsList() {
		return inventoryCommentsList;
	}

	public void setInventoryCommentsList(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryComments> inventoryCommentsList) {
		this.inventoryCommentsList = inventoryCommentsList;
	}
	
	
}
