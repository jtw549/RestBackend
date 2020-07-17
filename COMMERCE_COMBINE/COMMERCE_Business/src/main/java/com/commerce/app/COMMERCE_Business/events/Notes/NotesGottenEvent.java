package com.commerce.app.COMMERCE_Business.events.Notes;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;

public class NotesGottenEvent extends ReadEvent{
	private final NotesDetails notesDetails;
	
	public NotesGottenEvent (ArrayList<InventoryNotes> inventoryNotes) {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.toNotesDetails(inventoryNotes,notesDetails);
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
