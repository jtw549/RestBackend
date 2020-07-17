package com.commerce.app.COMMERCE_Business.events.Notes;

import java.sql.Date;
import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;

public class NotesDetails {

	private int inventoryNotesId;
	
	private int inventoryId;
	
	private String title;
	
	private String createDate;
	
	private String noteSummary;
	
	private int userId;
	
	private ArrayList<InventoryNotes> inventoryNotes;
	
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

	public NotesDetails toNotesDetails(ArrayList<InventoryNotes> inventoryNotes,NotesDetails notesDetails) {
		notesDetails.setInventoryNotes(inventoryNotes);
		return notesDetails;
		
	}
	public NotesDetails toNotesDetails(InventoryNotes inventoryNotes,NotesDetails notesDetails) {
		notesDetails.setCreateDate(inventoryNotes.getCreateDate());
		notesDetails.setInventoryId(inventoryNotes.getInventoryId());
		notesDetails.setInventoryNotesId(inventoryNotes.getInventoryNotesId());
		notesDetails.setNoteSummary(inventoryNotes.getNoteSummary());
		notesDetails.setTitle(inventoryNotes.getTitle());
		notesDetails.setUserId(inventoryNotes.getUserId());
		return notesDetails;
	}
	
	public InventoryNotes fromNotesDetails() {
		InventoryNotes inventoryNotes = new InventoryNotes();
		inventoryNotes.setCreateDate(createDate);
		inventoryNotes.setInventoryId(inventoryId);
		inventoryNotes.setInventoryNotesId(inventoryNotesId);
		inventoryNotes.setNoteSummary(noteSummary);
		inventoryNotes.setTitle(title);
		inventoryNotes.setUserId(userId);
		return inventoryNotes;
	}

	public ArrayList<InventoryNotes> getInventoryNotes() {
		return inventoryNotes;
	}

	public void setInventoryNotes(ArrayList<InventoryNotes> inventoryNotes) {
		this.inventoryNotes = inventoryNotes;
	}
}
