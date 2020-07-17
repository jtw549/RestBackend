package com.sthuf.app.STHUF_Business.events.Notes;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.CreatedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryNotes;

public class NotesAddedEvent extends CreatedEvent{
/*	 "status": "",
	    "message": "",
	    "notes": [
	        {
	            "noteId": "",
	            "title": "",
	            "description": "",
	            "dateAdded": ""
	        },
	        ...
	    [*/
	private final NotesDetails notesDetails;
	
	public NotesAddedEvent (ArrayList<InventoryNotes> inventoryNotes) {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.toNotesDetails(inventoryNotes,notesDetails);
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
