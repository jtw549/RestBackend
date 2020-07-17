package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sthuf.app.STHUF_Business.events.Notes.NotesDetails;

@XmlRootElement
@JsonAutoDetect
public class InventoryNotes implements Serializable{
	
	@JsonProperty(value="position")
	private int position;
	
	@JsonProperty(value="formula")
	private String formula;
	
	@JsonProperty(value="inventoryNotesId")
	private int inventoryNotesId;
	
	@JsonProperty(value="inventoryId")
	private int inventoryId;
	
	@JsonProperty(value="title")
	private String title;
	
	@JsonProperty(value="createDate")
	private String createDate;
	
	@JsonProperty(value="noteSummary")
	private String noteSummary;
	
	@JsonProperty(value="userId")
	private int userId;
	
	@JsonProperty(value="inventoryNotesList")
	private ArrayList<com.sthuf.app.STHUF_Domain.domain.InventoryNotes> inventoryNotesList;
	
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
	
	public ArrayList<String> appVerify(){
		ArrayList<String> appValues = new ArrayList<String>();
		appValues.add(formula);
		appValues.add(String.valueOf(position));
		return appValues;
		
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
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

	public ArrayList<com.sthuf.app.STHUF_Domain.domain.InventoryNotes> getInventoryNotes() {
		return inventoryNotesList;
	}

	public void setInventoryNotes(
			ArrayList<com.sthuf.app.STHUF_Domain.domain.InventoryNotes> inventoryNotes) {
		this.inventoryNotesList = inventoryNotes;
	}
	
	
}
