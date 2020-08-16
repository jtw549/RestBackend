package com.commerce.app.COMMERCE_WebService.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.commerce.app.COMMERCE_Business.events.Notes.NotesDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@JsonAutoDetect
public class InventoryNotes implements Serializable{
	
	@ApiModelProperty(notes = "Inventory notes id",name="inventoryNotesId",required=true,value="test inventory notes id")
	@JsonProperty(value="inventoryNotesId")
	private int inventoryNotesId;
	
	@ApiModelProperty(notes = "Inventory id",name="inventoryId",required=true,value="test inventory id")
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	@ApiModelProperty(notes = "Inventory note title",name="title",required=true,value="test inventory note title")
	@JsonProperty(value="title")
	private String title;
	
	@ApiModelProperty(notes = "Inventory note date",name="createDate",required=true,value="test inventory note date")
	@JsonProperty(value="createDate")
	private String createDate;
	
	@ApiModelProperty(notes = "Inventory note",name="noteSummary",required=true,value="test inventory note")
	@JsonProperty(value="noteSummary")
	private String noteSummary;
	
	@ApiModelProperty(notes = "Inventory notes user id associated with the note",name="userId",required=true,value="test inventory note user id")
	@JsonProperty(value="userId")
	private int userId;
	
	@ApiModelProperty(notes = "List of inventory notes",name="inventoryNotesList",required=true,value="test inventory note list")
	@JsonProperty(value="inventoryNotesList")
	private ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> inventoryNotesList;
	
	public NotesDetails toNotesDetails() {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.setCreateDate(createDate);
		notesDetails.setInventoryId(inventoryId);
		notesDetails.setInventoryNotesId(inventoryNotesId);
		notesDetails.setNoteSummary(noteSummary);
		notesDetails.setTitle(title);
		notesDetails.setUserId(userId);
		return notesDetails;
	}
	
	public InventoryNotes fromNotesDetails(NotesDetails notesDetails) {
		InventoryNotes inventoryNotes = new InventoryNotes();
		inventoryNotes.createDate=notesDetails.getCreateDate();
		inventoryNotes.inventoryId=notesDetails.getInventoryId();
		inventoryNotes.inventoryNotesId=notesDetails.getInventoryNotesId();
		inventoryNotes.noteSummary=notesDetails.getNoteSummary();
		inventoryNotes.title=notesDetails.getTitle();
		inventoryNotes.userId=notesDetails.getUserId();
		inventoryNotes.inventoryNotesList = notesDetails.getInventoryNotes();
		return inventoryNotes;
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

	public ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> getInventoryNotes() {
		return inventoryNotesList;
	}

	public void setInventoryNotes(
			ArrayList<com.commerce.app.COMMERCE_Domain.domain.InventoryNotes> inventoryNotes) {
		this.inventoryNotesList = inventoryNotes;
	}
	
	
}
