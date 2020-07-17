package com.commerce.app.COMMERCE_Business.events.Notes;

import com.commerce.app.COMMERCE_Business.events.ReadEvent;

public class GetNotesEvent extends ReadEvent{

	private NotesDetails notesDetails;
	
	public GetNotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
