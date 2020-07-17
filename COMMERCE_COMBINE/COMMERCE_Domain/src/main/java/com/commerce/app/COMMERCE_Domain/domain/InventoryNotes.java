package com.commerce.app.COMMERCE_Domain.domain;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InventoryNotes {

	@Id
	private int inventoryNotesId;
	
	private int inventoryId;
	
	private String title;
	
	private String createDate;
	
	private String noteSummary;
	
	private int userId;

	public InventoryNotes() {
		
	}
	
	public int getInventoryNotesId() {
		return inventoryNotesId;
	}

	public void setInventoryNotesId(int inventoryNotesId) {
		this.inventoryNotesId = inventoryNotesId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getNoteSummary() {
		return noteSummary;
	}

	public void setNoteSummary(String noteSummary) {
		this.noteSummary = noteSummary;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
