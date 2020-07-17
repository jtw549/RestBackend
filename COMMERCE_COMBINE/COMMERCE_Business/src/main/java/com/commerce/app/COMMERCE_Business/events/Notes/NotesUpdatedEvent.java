package com.commerce.app.COMMERCE_Business.events.Notes;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.UpdatedEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;

public class NotesUpdatedEvent extends UpdatedEvent{
	private final NotesDetails notesDetails;
	
	public NotesUpdatedEvent (ArrayList<InventoryNotes> inventoryNotes ) {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.toNotesDetails(inventoryNotes,notesDetails);
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
