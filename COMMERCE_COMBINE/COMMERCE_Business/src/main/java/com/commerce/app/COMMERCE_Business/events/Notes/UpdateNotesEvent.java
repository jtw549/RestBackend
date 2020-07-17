package com.commerce.app.COMMERCE_Business.events.Notes;

import com.commerce.app.COMMERCE_Business.events.UpdateEvent;

public class UpdateNotesEvent extends UpdateEvent{
	private NotesDetails notesDetails;
	
	public UpdateNotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
