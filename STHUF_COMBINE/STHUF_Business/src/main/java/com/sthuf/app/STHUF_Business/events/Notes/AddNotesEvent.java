package com.sthuf.app.STHUF_Business.events.Notes;

import com.sthuf.app.STHUF_Business.events.CreateEvent;

public class AddNotesEvent extends CreateEvent{
/*	"note": {
    "itemId": "",
    "title": "",
    "description": ""
}*/
	private NotesDetails notesDetails;
	
	public AddNotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
