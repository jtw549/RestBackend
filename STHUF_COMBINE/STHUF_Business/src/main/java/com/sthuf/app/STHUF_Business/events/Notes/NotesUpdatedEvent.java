package com.sthuf.app.STHUF_Business.events.Notes;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.UpdatedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryNotes;

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
