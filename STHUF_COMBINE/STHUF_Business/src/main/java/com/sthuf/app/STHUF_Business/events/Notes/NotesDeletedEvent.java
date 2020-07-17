package com.sthuf.app.STHUF_Business.events.Notes;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.DeletedEvent;
import com.sthuf.app.STHUF_Domain.domain.InventoryNotes;

public class NotesDeletedEvent extends DeletedEvent {
	/*  "status": "",
	    "message": "",
	    "notes": [
	        {
	            "noteId": "",
	            "title": "",
	            "description": "",
	            "dateAdded": ""
	        },
	        ...
	    ]*/
	private final NotesDetails notesDetails;
	
	private boolean deletionCompleted;
	
	public NotesDeletedEvent (ArrayList<InventoryNotes> inventoryNotes) {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.toNotesDetails(inventoryNotes,notesDetails);
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
	
	 public boolean isDeletionCompleted() {
		    return deletionCompleted;
		  }
}
